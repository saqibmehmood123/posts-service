package com.bank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.kafka.core.KafkaAdmin;
import org.apache.kafka.clients.admin.NewTopic;
*/

import java.util.HashMap;
import java.util.Map;

////@Configuration
public class KafkaTopicConfig {


/*
@Bean
public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put("bootstrap.servers",
            "b-1.eksmskclustersaqib.3f7fbg.c2.kafka.eu-north-1.amazonaws.com:9098," +
            "b-2.eksmskclustersaqib.3f7fbg.c2.kafka.eu-north-1.amazonaws.com:9098");
    configs.put("security.protocol", "SASL_SSL");
    configs.put("sasl.mechanism", "AWS_MSK_IAM");
    configs.put("sasl.jaas.config", "software.amazon.msk.auth.iam.IAMLoginModule required;");
    configs.put("sasl.client.callback.handler.class", "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
    return new KafkaAdmin(configs);
}


@Bean
public NewTopic orderTopic() {
    return new NewTopic("order", 1, (short) 3); // 1 partition, 3 replicas
}
*/

}
