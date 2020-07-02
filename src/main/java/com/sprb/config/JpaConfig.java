package com.sprb.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName:JpaConfig
 * @Descripion: 针对存储库提供的配置类
 * @Author:andy.ten@tom.com
 * @Date:2020/6/18 9:39 上午
 * @Version V1.0
 */

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.**.repository")
@EntityScan(basePackages = "com.**.domain")
public class JpaConfig
{
  // @Bean
  // PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor()
  // {
  //   return new PersistenceExceptionTranslationPostProcessor();
  // }
}
