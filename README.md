# 说明

  `SpringBoot App` Demo，搭建模版。   
  作者:andy.ten@tom.com 
  
## 版本
> v1.0.4 : 2020.07.02
>> 增加了日志配置,使用Lombok中的@Slf4j注解
>> 配置日志格式配置：logback-spring.xml
>> 优化druid配置，增加了慢sql输出到指定log_druid.log文件中
---
> v1.0.3 : 2020.07.01
>> 增加了Thymeleaf测试html页
---
> v1.0.2 : 2020.06.29
>> 增加了User、Role的Test测试类
---
> v1.0.1 : 2020.06.18
>> 实现application.yml配置方式
>> 增加druid配置
>> 增加jpa配置
>> Entity类使用Lombok配置

## 环境

- SpringBoot版本：2.3.1.RELEASE
- JDK版本：Jdk1.8+
- Maven版本：3.5.0+
- 数据库：mysql5.7，数据库用户名：sprbdemo
- 数据库开发工具：Navicat
- Java开发工具：IntelliJ IDEA
- 组件
  - `Druid`：数据库连接池
  - `JPA`：orm持久化规范接口
  - `Slf4j+logback-spring`：日志插件
  - `Thymeleaf`: 前端页面插件
  - `Lombok`：生成Setter、Getter插件
  
## 运行

```java
# 运行jar命令
$ java -jar sprbdemo-1.0.1-SNAPSHOT.jar
```

## 目录

``` 目录
.
├── pom.xml
├── settings-springboot-demo.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── sprb
    │   │           ├── SprbDemoApplication.java
    │   │           ├── config
    │   │           ├── controller
    │   │           ├── demo
    │   │           ├── domain
    │   │           ├── repository
    │   │           └── service
    │   └── resources
    │       ├── META-INF
    │       ├── application.properties.bak
    │       ├── application.yml
    │       ├── logback-spring.xml
    │       ├── rebel.xml
    │       ├── static
    │       └── templates
    │           └── countryIndex.html
    └── test
        └── java
            └── com
                └── sprb
                    ├── controller
                    ├── demo
                    └── repository

22 directories, 8 files

```

## 主页

- 欢迎访问个人 [github-xukaixing](https://github.com/xukaixing) 主页.
- 欢迎访问个人 [gitee-xukaixing](https://gitee.com/xukaixing) 主页.
