package com.aquarius;

import com.github.ltsopensource.spring.boot.annotation.EnableJobTracker;
import com.github.ltsopensource.spring.boot.annotation.EnableTaskTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@EnableDubbo
@ImportResource(locations = {"classpath:*.xml"})
//@MapperScan("com.aquarius.mapper")
@EnableJobTracker
@EnableTaskTracker
public class DxpzkApplication {

    /*
        mysql -u root -p
        redis-server /usr/local/etc/redis.conf
        ./zkServer.sh start

        zkCli.sh -server 127.0.0.1:2181
     */
    public static void main(String[] args) {
        SpringApplication.run(DxpzkApplication.class, args);
    }

}

