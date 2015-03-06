package SERVER;
import java.io.*;
import java.net.*;
import java.rmi.*;

public class ServerThread extends Thread {
	String url;
	SampleServer remoteObject;
    Socket socket;
    public ServerThread(Socket s){
        socket = s ;
    }
    
    public void run()
    {
        try{
    		String line;
			int item_value;
			String[] op;
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			line = sin.readLine();
	
			while(!(line.equals("E"))){
				op = is.readLine().split(" ");
				 url = "//localhost/SAMPLE-SERVER"+Integer.parseInt(op[1])/10;
				 try{
					 remoteObject = (SampleServer)Naming.lookup(url);
				
					if(op[0].equals("read")){
						System.out.println("[Client]Read item"+op[1]);
						item_value = remoteObject.readTrans(Integer.parseInt(op[1]));
						os.println("The value of item"+op[1]+" is "+item_value);
					}else if(op[0].equals("write")){
						System.out.println("[Client]Wirte item"+op[1]+"'s value to "+op[2]);
						remoteObject.writeTrans(Integer.parseInt(op[1]), Integer.parseInt(op[2]));
						os.println("Writing opreation succeessfully.");
					}else{
						os.println("Please input as [read item_id] or [write item_id value]");	
					}
					os.flush();
				 }catch(RemoteException exc){
						System.out.println("Error in lookup: " + exc.toString());
				 }catch(java.net.MalformedURLException exc){
						System.out.println("Malformed URL: "+ exc.toString());
				 }catch(java.rmi.NotBoundException exc){
						System.out.println("NotBound: "+exc.toString());
				}
			}		
			os.close();
			is.close();
			socket.close();
		//	server.close();	
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
