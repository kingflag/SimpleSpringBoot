# SimpleSpringBoot 程序

添加pom.xml。

编写启动代码，在浏览器中输入<code>http://localhost:8081/</code>即可看到<code>Hello World!</code>;此时即可证明springboot的程序已经启动，如果想更换端口请到<code>src/main/resources/application.properties</code>中修改。

添加相应的控制器后，在浏览器中输入<code>http://localhost:8081/user/add</code>可以在浏览器中看到<code>add</code>字符串

springboot集成Mybatis，在配置文件中配置数据库连接信息，创建表并添加数据

添加Mybatis依赖和数据库依赖

```javascript
<!-- Springboot集成Mybatis依赖 -->
<dependency>
		<groupId>org.mybatis.spring.boot</groupId>
		<artifactId>mybatis-spring-boot-starter</artifactId>
		<version>1.1.1</version>
</dependency>
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!-- Mysql驱动 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.21</version>
</dependency>
```

创建数据表
```javascript
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO `user` VALUES ('1', 'king', '12');
INSERT INTO `user` VALUES ('2', 'flag', '45');
```


在浏览器中输入<code>http://localhost:8081/user/queryall</code>
当看到类似于
```javascript
queryall:[User [id=1, name=king, age=12], User [id=2, name=flag, age=45]]
```
此时证明Mybatis集成成功，可以对数据库进行操作。

集成Spring-Data-JPA

添加依赖
```javascript
<!-- spring-data-jpa依赖 -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
在浏览器中输入<code>http://localhost:8081/user/addsome</code>在页面看到<code>true</code>然后在数据库中查看，可以发现已经增加了数据，证明JPA集成成功
