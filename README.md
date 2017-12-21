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

在浏览器中输入<code>http://localhost:8081/user/queryall</code>
当看到类似于
```
queryall:[User [id=1, name=king, age=12], User [id=2, name=flag, age=45]]
```
此时证明Mybatis集成成功，可以对数据库进行操作。

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
