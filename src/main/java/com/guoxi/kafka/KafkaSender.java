package com.guoxi.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guoxi.vo.Datas;
import com.guoxi.vo.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

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
            datas.setTime(String.valueOf(System.currentTimeMillis()));
            //datas.setTime(String.valueOf(System.currentTimeMillis()+(i+1)*1000));
            //datas.setTime("983427253000");
            //System.out.println("System.currentTimeMillis():----------->"+(System.currentTimeMillis()));
            //System.out.println("System.currentTimeMillis()+i*1000:----------->"+(System.currentTimeMillis()+(i+1)*1000));
            datas.setValue((Math.random() * 10));
            List<Datas> list = new ArrayList<>();
            list.add(datas);
            root.setDatas(list);
            root.setVer("1.0");
            log.info("+++++++++++++++++++++  message = {}", gson.toJson(root));
            log.info("+++++++++++++++++++++  message = {}", gson.toJson(datas));
            kafkaTemplate.send("rc-metric-data", gson.toJson(root));

        }
    }

    public ListenableFuture<SendResult<String, String>> send57(){
        Root root = new Root();
        Datas datas = new Datas();
        datas.setMetric("h2s");
        datas.setProducer("mixiaoquan");
        datas.setChannel("AAASSS");
        datas.setSn("mxq20190111");
        datas.setTime(String.valueOf(System.currentTimeMillis()));
        datas.setValue(8d);
        List<Datas> list = new ArrayList<>();
        list.add(datas);
        root.setDatas(list);
        root.setVer("1.0");

        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("rc-metric-data", gson.toJson(root));

        return send;

    }
}
