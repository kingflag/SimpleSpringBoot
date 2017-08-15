# SimpleSpringBoot 程序

添加pom.xml。

编写启动代码，在浏览器中输入<code>http://localhost:8081/</code>即可看到<code>Hello World!</code>;此时即可证明springboot的程序已经启动，如果想更换端口请到<code>src/main/resources/application.properties</code>中修改。

添加相应的控制器后，在浏览器中输入<code>http://localhost:8081/user/add</code>可以在浏览器中看到<code>add</code>字符串

springboot集成Mybatis，在配置文件中配置数据库连接信息，创建表并添加数据


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
