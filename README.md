# cov-emi-diff

CovEMIDiff 后端展示系统

## 项目依赖

- Java 8 及以上版本
- Maven
- MySQL

## 项目配置

根据 `src/main/resources/application-sample.yml` 模板创建所需的配置文件 `application.yml`。

需要修改的配置：
1. `spring.datasource`：MySQL 数据库连接主机，用户及密码
2. `emi.parent-location`：实验脚本生成程序所在的目录

## 项目构建

```shell
mvn clean package
```

## 项目运行

```shell
java -jar /path/to/cov-emi-diff-xxx.jar
```