package com.est.neonaduri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing //created_at, updated_at 자동 업데이트
@EnableScheduling // 스케줄러 구현 시 필요
@EnableCaching
public class NeonaduriApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeonaduriApplication.class, args);
    }

}
