package com.example.springbootconsumer;

import com.gupaoedu.book.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootConsumerApplication {

    //该注解还没有注册中心时使用
    //@Reference(url = "dubbo://192.168.56.1:20880/com.gupaoedu.book.dubbo.IHelloService")
    //有注册中心了可不用后续url
    @Reference
    private IHelloService helloService;


    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumerApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> System.out.println(helloService.sayHello("Mic"));
    }

}
