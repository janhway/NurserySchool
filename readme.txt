һ�����ذ�װ��������maven  ����eclipse��maven�滻Ϊ�°�װ��maven��

�������ذ�װmysql
��windows���������ⰲװ�汾(��MSI��װ��)����ѹ������þͿ���ʹ�á�MSI��װ��������̨�����Ͼ�����װ�������⣬�����á�

�ⰲװ��Ĺٷ����ص�ַ��http://cdn.mysql.com/Downloads/MySQL-5.6/mysql-5.6.22-win32.zip

����һ���ⰲװ������÷�ʽ�����������http://blog.csdn.net/q98842674/article/details/12094777

�������ذ�װtomcat

�ģ����벿��
1.���ش��� git clone https://github.com/janhway/NurserySchool.git
2. cd NurserySchool/
3. mvn clean package
���Ա����war���� target/NurserySchool.war
4.��war������tomcat  

5.�������ݿ�ʾ�� nurseryschool
���԰ѹ��������nurseryschool.sql�ļ��е���俽����mysql�ͻ��˶������ִ�У�

6.ִ��tomcat

�壺���뵽eclipse  ͨ��import maven project
������eclipse�����±������͵���

��������ʾ������

1.�����û�
����
������POST
http://localhost:8080/rest/user
ͷ����
Content-Type: application/json;charset=UTF-8
��Ϣ��:
{"password":"janhwaypassword", "userName":"janhway22","role":"SCHOOLMASTER"}

��Ӧ��
��Ϣ��
ok.userid=3

2.�û���¼
����
������POST
http://localhost:8080/rest/login
ͷ����
Content-Type: application/json;charset=UTF-8
��Ϣ��:
{"password":"janhwaypassword", "userName":"janhway22"}

��Ӧ��
��Ϣ��
{"userId":2,"token":"MjoxNDE5MDU2OTQ3NDUwOjE0MTkwNjA1NDc0NTA="}



3.��ѯ�����û�
����
������GET
http://localhost:8080/rest/user
ͷ����
Content-Type: application/json;charset=UTF-8
��Ϣ��:


��Ӧ��
��Ϣ��
{"userList":[{"userName":"janhway","role":"SCHOOLMASTER"},{"userName":"janhway11","role":"SCHOOLMASTER"}]}







