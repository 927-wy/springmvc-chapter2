
# springmvc-chapter2
##环境搭建

环境：Eclipse Java EE IDE Version:Mars.2 Release (4.5.2),apache-tomcat 8.0.39

###eclipse
新建项目：

    file-->new-->Dynamic Web Project-->Finish
把各种src，WebContent往里放就好了。
主要是Eclipse的服务器，之前把war包直接解压到webapp，报404，并不知道是哪儿的问题，而Eclipse里面配置服务器的话，日志会很全，而且可以Debug。

//配置服务器

    Window-->preferences-->Server-->Runtime Environment

//显示服务器

    Window-->Show View-->Other--> Server
这个时候控制台（右下角会有Servers）那里选择Server，右击Add，把动态工程加进去，启动服务器，访问

    http://127.0.0.1:8080/springmvc-chapter2/hello
就可以啦。
