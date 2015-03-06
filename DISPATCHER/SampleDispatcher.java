package DISPATCHER;
import java.rmi.*;
import java.net.*;

import SERVER.ServerThread;


public class SampleDispatcher{
	public static void main(String[] args){
		//System.setSecurityManager(new RMISecurityManager());
		System.out.println("Security Manager loaded..");
		int port = 54321;
		int con=1;
		
		//try{
		ServerSocket server = null;
		try{
			server = new ServerSocket(port);
		}catch(Exception e){
			System.out.println("cannot listen to:"+e);
			System.exit(1);
		}
			
		while(true){
			try{
				Socket socket = server.accept();
				new ServerThread(socket).start();
				System.out.println("接收了 第"+con+"个请求");
				con++;
			}catch(Exception e){
				System.out.println("Accept Error."+e);
			}
		}
	
	}
}
