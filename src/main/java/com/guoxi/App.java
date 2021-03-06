package com.guoxi;

import com.guoxi.kafka.KafkaSender;
import com.guoxi.service.AsyncTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
@ComponentScan("com.guoxi")
@EnableAsync
public class App {
    public  static void main(String args[]){
        ConfigurableApplicationContext context=SpringApplication.run(App.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);
        AsyncTaskService asyncTaskService= context.getBean(AsyncTaskService.class);

//        for (int i = 0; i < 10; i++) {
//            asyncTaskService.executeAsyncTask(i);
//        }
        //sender.send();
        ListenableFuture<SendResult<String, String>> send57=sender.send57();
        System.out.println(send57);
    }
}
