package hello.repository.elasticsearch;

import hello.domain.elasticSearch.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/6/7.
 */
@Component
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
