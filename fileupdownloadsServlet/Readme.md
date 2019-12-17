File upload and download based on Servlet.

Understand how servlet works :
To be specific, if we use Tomcat as our web container. Context container is the one that really take care of the servlet container. One Tomcat has one Servlet container and one servlet can have many context containers. In Context container is an instance of Wrapper. One context corresponding to one web application.
During the initailization of starting the web application, we create an important configuration called ServletConfig for a servlet, which is responsible for parsing all web applications configuration.
And package Servlet into StandardWrapper class and add StandardWrapper into Context container. So context container is the real that runs the servlet container.