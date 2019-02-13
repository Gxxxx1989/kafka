package com.guoxi;

import com.guoxi.kafka.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.guoxi")
public class App {
    public  static void main(String args[]){
        ConfigurableApplicationContext context=SpringApplication.run(App.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);

//        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
