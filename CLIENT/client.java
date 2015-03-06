package CLIENT;
import java.io.*;
import java.net.*;

public class client {
	public client(){
		try{
			String line;
			Socket socket = new Socket("127.0.0.1",54321);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(!((line = sin.readLine()).equals("E"))){
				System.out.println("[Client]I want to "+line);
				os.println(line);
				os.flush();
				System.out.println("[Server]"+is.readLine());
			}	
			os.close();
			is.close();
			socket.close();
		}catch(Exception e){
			System.out.println("Error"+e);
		}
	}
	
	public static void main(String args[]){
		new client();
	}

}
