package hello.repository.elasticsearch;

import hello.domain.kafka2es.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author: kingflag
 * @create: 2018-11-02 10:17
 **/
@Component
public interface CityRepository extends ElasticsearchRepository<City, String> {

}
