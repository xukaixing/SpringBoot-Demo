# 说明

  `SpringBoot App` Demo，搭建模版。   
  作者:andy.ten@tom.com 
  
## 版本
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
  - `Slf4j`：日志插件
  - `Lombok`：生成Setter、Getter插件
  
## 运行

```java
jar
```

## 目录

``` 目录
.
├── README.md
├── pom.xml
├── springboot-demo.iml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── sprb
    │   │           ├── SprbDemoApplication.java
    │   │           ├── config
    │   │           ├── controller
    │   │           ├── dao
    │   │           ├── demo
    │   │           ├── entities
    │   │           └── service
    │   └── resources
    │       ├── application.properties.bak
    │       ├── application.yml
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── sprb
                    ├── dao
                    └── demo

20 directories, 6 files

```

## 主页

- 欢迎访问个人 [github-xukaixing](https://github.com/xukaixing) 主页.
- 欢迎访问个人 [gitee-xukaixing](https://gitee.com/xukaixing) 主页.
