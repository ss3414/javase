# ************************************************************分割线************************************************************
# todo java命令运行含第三方依赖的class文件（PowerShell多行脚本）

# 最精简写法
# ①注意用户class位于Idea target目录下，所以运行前先用Idea编译
# ②注意包名前的空格
java -classpath "
C:\Program Files\Java\jdk1.8.0_161\jre\lib\rt.jar;C:\Users\Administrator\IdeaProjects(2)\javase\java_crazy\target\classes;C:\Users\Administrator\.m2\repository\mysql\mysql-connector-java\5.1.38\mysql-connector-java-5.1.38.jar"`
 c13.JDBC