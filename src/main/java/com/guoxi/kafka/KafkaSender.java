package com.guoxi.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guoxi.vo.Datas;
import com.guoxi.vo.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    @Value("${value.max}")
    private int max;

    //发送消息方法
    public void send() {
        for (int i = 0; i < max; i++) {
            Root root = new Root();
            Datas datas = new Datas();
            datas.setMetric("h2s");
            datas.setProducer("ijinus");
            datas.setChannel("");
            datas.setSn("123");
            datas.setTime(String.valueOf(System.currentTimeMillis() / 1000));
            datas.setValue((Math.random() * 10));
            List<Datas> list = new ArrayList<>();
            list.add(datas);
            root.setDatas(list);
            root.setVer("1.0");
//            log.info("+++++++++++++++++++++  message = {}", gson.toJson(root));
//            log.info("+++++++++++++++++++++  message = {}", gson.toJson(datas));
            kafkaTemplate.send("test", gson.toJson(root));
        }


    }
}
