# Sample-Distributed-System
简单实现分布式系统(java)
1 dispatcher, 2 servers, 2 clients
结构图如下: 
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/structure.png) 

Dispatcher与Backend server之间通过RMI通信，具体可参考：
http://blog.csdn.net/jzhf2012/article/details/41040051

Dispatcher与client之间通过sockect通信，具体可参考:
单线程socket:http://www.cnblogs.com/linzheng/archive/2011/01/23/1942328.html
多线程socket:http://lupingzi.iteye.com/blog/509177


  
  
  

