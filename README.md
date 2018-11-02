# SimpleSpringBoot 程序

添加pom.xml。

添加Mybatis依赖和数据库依赖

```xml
<!-- Springboot集成Mybatis依赖 -->
<dependency>
		<groupId>org.mybatis.spring.boot</groupId>
		<artifactId>mybatis-spring-boot-starter</artifactId>
		<version>1.1.1</version>
</dependency>

<!-- Mysql驱动 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.21</version>
</dependency>
```
springboot集成Mybatis，在配置文件中配置数据库连接信息，创建表并添加数据



创建数据表
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `user` VALUES ('1', 'king', '12');
INSERT INTO `user` VALUES ('2', 'flag', '45');
```
集成Spring-Data-JPA

添加依赖
```xml
<!-- spring-data-jpa依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
使用Gson将返回结果封装成json

添加Gson依赖，并排除jackson依赖（通常情况）
```xml
<!-- 加入gson依赖 -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
</dependency>

<!-- 排除jackson依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

编写启动代码，在浏览器中输入
```
http://localhost:8081/
```
即可看到
```Hello World!```
此时即可证明springboot的程序已经启动，如果想更换端口请到
```src/main/resources/application.properties```中修改。

添加相应的控制器后，用POSTMAN等Http请求工具POST请求
```
http://localhost:8081/user/add
```
在Body中添加json
```
{
   	"id":"12",
   	"name":"kkk",
   	"age":10
}
```
可以在浏览器中看到```参数不可为空```或者```name的值```字符串


在浏览器中输入```http://localhost:8081/user/addsome```在页面看到```true```然后在数据库中查看，可以发现已经增加了数据，证明JPA集成成功

在浏览器中输入```http://localhost:8081/user/queryall```可以看到json数据，如下
```json
{
    "data": [
        {
            "id": 1,
            "name": "king",
            "age": 12
        },
        {
            "id": 2,
            "name": "flag",
            "age": 45
        },
        {
            "id": 33,
            "name": "laodi",
            "age": 10
        },
        {
            "id": 34,
            "name": "laodi",
            "age": 10
        }
    ],
    "state": "200"
}
```
其中state为200表示请求成功，其他为失败，data是返回的数据；

此时证明Mybatis集成成功，可以对数据库进行操作。


# SpringBoot 集成 Elasticsearch 程序 即将合并到 master 分支

springBoot 使用的是 <font color=#DC143C>2.1.0.RELEASE</font>   版本，其他版本可能会有问题。

####elasticsearch-head安装及启动

head是用于监控Elasticsearch状态的客户端插件，包括数据可视化，增删改查工具，es语句的可视化等等。

5.0之后的安装方式如下：
```shell
git clone git://github.com/mobz/elasticsearch-head.git
 
cd elasticsearch-head 
npm install
npm install -g grunt-cli
yum install nodejs
grunt server &
Open http://localhost:9100 
```
注：1.head插件监听的是9100端口 2.安装前要完成nodejs, grunt的安装

启动方式：

使用npm方式启动，在head插件目录中执行
```shell
grunt server  &
```

先启动Elasticsearch,注意日志和数据的存放目录，在配置文件中要写正确
Elasticsearch启动后在浏览器中输入
```http://127.0.0.1:9200/```
可以看到类似如下信息
```$xslt
{
"name": "cZgwsjC",
"cluster_name": "elasticsearch",
"cluster_uuid": "yKBnnem0SQal4yS3Ws386g",
"version": {
    "number": "6.2.4",
    "build_hash": "ccec39f",
    "build_date": "2018-04-12T20:37:28.497551Z",
    "build_snapshot": false,
    "lucene_version": "7.2.1",
    "minimum_wire_compatibility_version": "5.6.0",
    "minimum_index_compatibility_version": "5.0.0"
},
"tagline": "You Know, for Search"
}
```
证明ES启动正常
下面可以启动服务
启动后在浏览器输入:```http://127.0.0.1:8081/elasticSearch/addArticle```返回 true,插入数据

然后在浏览器输入 ```http://127.0.0.1:8081/elasticSearch/searchArticle``` 查看数据
可以看到如下数据
```json
[
    {
        "id": 1,
        "title": "springboot integreate elasticsearch",
        "abstracts": "springboot integreate elasticsearch is very easy",
        "content": "elasticsearch based on lucene,spring-data-elastichsearch based on elaticsearch,this tutorial tell you how to integrete springboot with spring-data-elasticsearch",
        "postTime": 1541053864818,
        "clickCount": 1,
        "author": {
            "id": 1,
            "name": "kingflag",
            "remark": "java 开发"
        },
        "tutorial": {
            "id": 1,
            "name": "elastic search"
        }
    }
]
```

在浏览器输入:```http://127.0.0.1:8081/elasticSearch/deleteArticle```返回 true,删除数据

#集成kafka,
配置过程见另一个demo，[地址](https://github.com/kingflag/SpringBoot-Kafka) windows 与linux配置类似，亲测可用

KafkaTask定时生成数据，将数据发送到kafka，kafka消费者接收到数据后将数据报错到ES中