//package com.guoxi.kafka;
//
//import com.aliyun.hitsdb.client.HiTSDB;
//import com.aliyun.hitsdb.client.HiTSDBClientFactory;
//import com.aliyun.hitsdb.client.HiTSDBConfig;
//import com.aliyun.hitsdb.client.value.request.Point;
//import com.aliyun.hitsdb.client.value.response.batch.DetailsResult;
//import com.google.gson.Gson;
//import com.guoxi.vo.Datas;
//import com.guoxi.vo.Root;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//import static org.apache.kafka.common.requests.DeleteAclsResponse.log;
//
//@Component
//@Slf4j
//public class KafkaReceiver {
//
//    @Value("${opentsdb.url}")
//    private String url;
//
//    @Value("${opentsdb.port}")
//    private int port;
//
//
//    @KafkaListener(topics = {"test"})
//    public void listen(ConsumerRecord<?, ?> record) {
//
//        HiTSDBConfig config = HiTSDBConfig.address(url, port).config();
//
//        HiTSDB tsdb = HiTSDBClientFactory.connect(config);
//
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//        Root root = new Gson().fromJson(record.value().toString(), Root.class);
//
//        if (root != null && root.getDatas() != null) {
//            for (Datas data : root.getDatas()) {
//
//                Map<String, String> tagMap = new HashMap<String, String>();
//                if (data.getChannel().equals("")) {
//                    // 读取时显示为空串
//                    tagMap.put("channel", "NULL");
//                } else {
//                    tagMap.put("channel", data.getChannel());
//                }
//                tagMap.put("producer_code", data.getProducer());
//                tagMap.put("device_sn", data.getSn());
////                tagMap.put("metric_id", String.valueOf(ms.getMetricId()));
//                tagMap.put("metric_code", data.getMetric());
//
//
//                List<Point> list = new ArrayList<>();
//                DetailsResult detailsResult = null;
//                for (Point point : points) {
//                    list.add(point);
//                    if (list.size() == 70) {
//                        List<Point> pointListB = list;
//                        detailsResult = tsdb.putSync(pointListB, DetailsResult.class);
//                        list.clear();
//                    }
//                }
//
//
////                Point point = Point.metric(data.getMetric()).tag(tagMap)
////                        .value(Long.valueOf(data.getTime()) / 1000, data.getValue()).build();
////
////                DetailsResult detailsResult = tsdb.putSync(DetailsResult.class, point);
//                log.info("同步写入结果：" + detailsResult.toString());
//
//            }
//        }
//
//        if (kafkaMessage.isPresent()) {
//
//            Object message = kafkaMessage.get();
//
//            log.info("------------------收到消息 record =" + record);
//            log.info("------------------收到消息 message =" + message);
//        }
//
//    }
//}
