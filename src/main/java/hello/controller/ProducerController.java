package hello.controller;

import hello.component.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kingflag
 * @create: 2018-11-01 20:39
 **/
@RestController
public class ProducerController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/kafka/send.do", method = RequestMethod.GET)
    public String sendMessage(@RequestParam(value = "key") String key, @RequestParam(value = "data") String data) {
        kafkaProducer.sendMessage(key, data);
        return "sucess";
    }
}
