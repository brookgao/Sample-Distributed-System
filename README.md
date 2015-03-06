# Sample-Distributed-System

##简单实现一个分布式系统(java)
1 dispatcher, 2 servers, 2 clients
###结构图如下: 
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/structure.png) 

####Dispatcher与Backend server之间通过RMI通信，具体可参考：
####http://blog.csdn.net/jzhf2012/article/details/41040051

####Dispatcher与client之间通过sockect通信，具体可参考:
单线程socket:http://www.cnblogs.com/linzheng/archive/2011/01/23/1942328.html
多线程socket:http://lupingzi.iteye.com/blog/509177

###说明:
每当第i个server开启时，会自动生成10个dataRecord, dataID分别为10*i至(10*i+9),value分别为0~9;
server0管理0～9�号data，server1管理10～19号data；
client可使用socket与dispatcher通信，执行read或者write请求，如read 5(读5�号data)或者write 5 888(将5号data的value改为888)；
dispatcher跟据client请求中对应的id号，将任务分配给不同的server去执行，得到返回结果再发回给client.

###演示流程:
####1.开启remiregistry
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/rmiregistry.png)

####2.rmic，开启backend server0和server1
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/server0.png)
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/server1.png)

####3.开启dispatcher(当有client连上时会出现提示)
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/dispatcher.png)

####4.开启client1和client2
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/client1.png)
![image](https://github.com/brookgao/Sample-Distributed-System/raw/master/Images/client2.png)




  
  
  

