package hello.controller.impl;

import hello.domain.elasticSearch.Article;
import hello.domain.elasticSearch.Author;
import hello.domain.elasticSearch.Tutorial;
import hello.domain.kafka2es.City;
import hello.repository.elasticsearch.ArticleSearchRepository;
import hello.repository.elasticsearch.CityRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by admin on 2018/6/7.
 */
@RestController
@RequestMapping("/elasticSearch")
public class ElasticSearchControllerImpl {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("addArticle")
    public boolean addArticle() {
        Author author = new Author();
        author.setId(1L);
        author.setName("kingflag");
        author.setRemark("java 开发");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        articleSearchRepository.save(article);
        return true;
    }

    @RequestMapping("searchArticle")
    public List<Article> searchArticle() {
        List result = null;
        try {
            result = new LinkedList<>();
            //搜索关键字
            String queryString = "springboot";
            QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
            Iterable<Article> searchResult = articleSearchRepository.search(builder);
            Iterator<Article> iterator = searchResult.iterator();
            while (iterator.hasNext()) {
                Article article = iterator.next();
                System.out.println(article);
                result.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return result;
    }

    @RequestMapping("deleteArticle")
    public boolean deleteArticle() {

        try {
            Article article = new Article();
            article.setId(1L);
            articleSearchRepository.delete(article);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("addCity")
    public boolean addCity() {
        City city = new City();
        city.setId(UUID.randomUUID().toString().replace("-", ""));
        city.setScore(String.valueOf(System.currentTimeMillis()));
        city.setName("上海");
        city.setDescription("上海是个热城市");

        cityRepository.save(city);
        System.out.println(cityRepository.count());
        return true;
    }

    @RequestMapping("searchCity")
    public List<City> searchCity() {
        List result = null;
        try {
            //搜索关键字
            result = new LinkedList<>();
            String queryString = "是";
            QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
            Iterable<City> searchResult = cityRepository.search(builder);
            Iterator<City> iterator = searchResult.iterator();
            while (iterator.hasNext()) {
                City city = iterator.next();
                System.out.println(city);
                result.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return result;
    }

    @RequestMapping("deleteAllCity")
    public boolean deleteAllCity() {
        cityRepository.deleteAll();
        return true;
    }
}
