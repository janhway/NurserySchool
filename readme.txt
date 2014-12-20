一：下载安装构建工具maven  （把eclipse的maven替换为新安装的maven）

二：下载安装mysql
对windows可以下载免安装版本(非MSI安装版)，解压后简单配置就可以使用。MSI安装版在我这台机器上经常安装的有问题，不好用。

免安装版的官方下载地址：http://cdn.mysql.com/Downloads/MySQL-5.6/mysql-5.6.22-win32.zip

搜索一下免安装版的配置方式，比如这个，http://blog.csdn.net/q98842674/article/details/12094777

三：下载安装tomcat

四：编译部署
1.下载代码 git clone https://github.com/janhway/NurserySchool.git
2. cd NurserySchool/
3. mvn clean package
可以编译出war包， target/NurserySchool.war
4.把war包部署到tomcat  

5.创建数据库示例 nurseryschool
可以把工程里面的nurseryschool.sql文件中的语句拷贝到mysql客户端端下逐句执行；

6.执行tomcat

五：引入到eclipse  通过import maven project
可以在eclipse环境下编码编译和调试

六：几个示例功能

1.创建用户
请求：
方法：POST
http://localhost:8080/rest/user
头部：
Content-Type: application/json;charset=UTF-8
消息体:
{"password":"janhwaypassword", "userName":"janhway22","role":"SCHOOLMASTER"}

响应：
消息体
ok.userid=3

2.用户登录
请求：
方法：POST
http://localhost:8080/rest/login
头部：
Content-Type: application/json;charset=UTF-8
消息体:
{"password":"janhwaypassword", "userName":"janhway22"}

响应：
消息体
{"userId":2,"token":"MjoxNDE5MDU2OTQ3NDUwOjE0MTkwNjA1NDc0NTA="}



3.查询所有用户
请求：
方法：GET
http://localhost:8080/rest/user
头部：
Content-Type: application/json;charset=UTF-8
消息体:


响应：
消息体
{"userList":[{"userName":"janhway","role":"SCHOOLMASTER"},{"userName":"janhway11","role":"SCHOOLMASTER"}]}







