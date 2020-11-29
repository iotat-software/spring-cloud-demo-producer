package cn.iotat.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * spring-boot启动类，以一定要加上scanBasePackages
 * 此为扫描包下的文件，不然其他模块的组件无法加载
 */
@SpringBootApplication(scanBasePackages = {"cn.iotat.producer"})
/**
 * 开启nacos的服务发现
 */
@EnableDiscoveryClient
/**
 * mybatis包扫描
 */
@MapperScan("cn.iotat.producer.dao")
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
