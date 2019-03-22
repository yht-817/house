package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.ruoyi.project.*.*.mapper")
public class RuoYiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("" +
                " ________ __   ____  ____  ____   ______ ______\n" +
                " /  ___/  |  \\_/ ___\\/ ___\\/ __ \\ /  ___//  ___/\n" +
                " \\___ \\|  |  /\\  \\__\\  \\__\\  ___/ \\___ \\ \\___ \\ \n" +
                "/____  >____/  \\___  >___  >___  >____  >____  >\n" +
                "     \\/            \\/    \\/    \\/     \\/     \\/ ");
    }
}