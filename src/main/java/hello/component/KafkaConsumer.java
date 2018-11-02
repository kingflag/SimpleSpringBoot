package hello.component;

import hello.domain.kafka2es.City;
import hello.repository.elasticsearch.CityRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: kingflag
 * @create: 2018-11-01 20:37
 **/
@Component
public class KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityRepository logRepository;


    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf("offset = %d,key =%s,value=%s\n", record.offset(), record.key(), record.value());
    }

    @KafkaListener(topics = {"testSendMessageTiming"})
    public void listenTiming(ConsumerRecord<?, ?> record) {

        City city = new City();
        String randomUUID = UUID.randomUUID().toString().replace("-", "");
        city.setId(randomUUID);
        city.setScore("2" + randomUUID);
        city.setName("北京");
        city.setDescription("北京是个好城市" + randomUUID);
        logRepository.save(city);

        System.out.printf("offset = %d,key =%s,value=%s\n", record.offset(), record.key(), record.value());
    }

}
