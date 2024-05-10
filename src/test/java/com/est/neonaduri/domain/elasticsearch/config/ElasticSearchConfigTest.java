package com.est.neonaduri.domain.elasticsearch.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.assertj.core.api.Assertions;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest(classes = ElasticSearchConfig.class)
class ElasticsearchConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void restClientBeanShouldBeConfigured() {
        RestClient restClient = context.getBean(RestClient.class);
        Assertions.assertThat(restClient).isNotNull();
    }

    @Test
    public void elasticsearchClientShouldBeConfigured() {
        ElasticsearchClient elasticsearchClient = context.getBean(ElasticsearchClient.class);
        Assertions.assertThat(elasticsearchClient).isNotNull();
    }
}