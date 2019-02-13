//package com.guoxi.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 类名 KafkaController
// * 类描述 springBoot整合kafka
// *
// * @author dell
// * @version 1.0
// * 创建日期 2017/12/15
// * 时间 11:55
// */
//@RestController
//@EnableAutoConfiguration
//public class KafkaController {
//
//    /**
//     * 注入kafkaTemplate
//     */
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//
//    /**
//     * 发送消息的方法
//     *
//     * @param key  推送数据的key
//     * @param data 推送数据的data
//     */
//    private void send(String key, String data) {
//        kafkaTemplate.send("test", key, data);
//    }
//
//    @RequestMapping("/kafka")
//    public String testKafka() {
//        int iMax = 10000;
//        for (int i = 1; i < iMax; i++) {
//            send("key" + i, "data" + i);
//        }
//        return "success";
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(KafkaController.class, args);
//    }
//
//    /**
//     * 使用日志打印消息
//     */
//    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);
//
//    @KafkaListener(topics = "test")
//    public void receive(ConsumerRecord<?, ?> consumer) {
//        logger.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
//    }
//
//}
