package hello.task;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: kingflag
 * @create: 2018-11-02 09:22
 **/
@Component
public class KafkaTask {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 定时执行任务(测试往kafka推数据)
     * 每秒执行一次:(0/1 * * * * ? )
     * 每分钟执行一次:(0 0/1 * * * ? )
     * 每小时执行一次:(0 0 0/1 1/1 * ? )
     * 每天凌晨执行一次(0 0 0 1/1 * ? )
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void sendMessageTiming() {
        try {
            String topic = "testSendMessageTiming";
            Long key = System.currentTimeMillis();
            StringBuffer data = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                data.append(UUID.randomUUID().toString().replace("-", ""));
            }
            kafkaTemplate.send(new ProducerRecord(topic, key.toString(), data.toString()));
            logger.info("发送结束");
        } catch (Exception e) {
            logger.error("发送异常");
        }

    }


}
