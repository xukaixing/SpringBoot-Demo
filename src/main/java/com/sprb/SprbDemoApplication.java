package com.sprb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName:JpaConfig
 * @Descripion: SpringBootDemo启动类, 该类必须放到最外层
 * @Author:andy.ten@tom.com
 * @Date:2020/6/18 9:39 上午
 * @Version V1.0
 */
// @SpringBootApplication(scanBasePackages = {"com.**.demo", "com.**.controller", "com.**.service"})
@SpringBootApplication
// 可指定需要spring扫描的包
@ComponentScan(basePackages = {"com.**.demo", "com.**.controller", "com.**.service", "com.**.repository"})
public class SprbDemoApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(SprbDemoApplication.class, args);
  }

}
