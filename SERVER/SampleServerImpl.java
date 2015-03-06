package SERVER;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

import DATA.dataRecord;

public class SampleServerImpl extends UnicastRemoteObject implements SampleServer{	
	private int tran_id;
	private int value;
	private static ArrayList<dataRecord> dataItems;

	public SampleServerImpl() throws RemoteException{
		super();
	}
	
	//private static final long serialVersionUID = 53864436L;

	public static void main(String args[]){
		dataItems = new ArrayList<dataRecord>();
		int ServerNo = Integer.parseInt(args[0]);
		for(int i=0;i<10;i++){
			int order = i+ServerNo*10;
			dataRecord my_data = new dataRecord(order,i);
			dataItems.add(my_data);
			System.out.println("The item"+order+" is created, value="+i);
		}
		
		try{
		//	System.setSecurityManager(new RMISecurityManager());
			SampleServerImpl Server = new SampleServerImpl();
			System.out.println("SAMPLE-SERVER"+ServerNo+" ready..");
			Naming.rebind("SAMPLE-SERVER"+ServerNo, Server);
			System.out.println("Server"+ServerNo+" waiting....");
			
		}catch(java.net.MalformedURLException me){
			System.out.println("Malformed UL:"+me.toString());
		}catch(RemoteException re){
			System.out.println("Remote exception: "+re.toString());
		}
	}
	
	
	public int readTrans(int i_tranId) throws RemoteException{
		tran_id = i_tranId;
		value = dataItems.get(tran_id%10).op_read();
		System.out.println("trans["+tran_id+"] | key_id="+dataItems.get(tran_id%10).get_KeyId()+" reads:"+value);
		return value;
	}
	

	public void writeTrans(int i_tranId, int i_value) throws RemoteException{
		tran_id = i_tranId;
		value = i_value;
		dataItems.get(tran_id%10).op_write(value);
		System.out.println("trans["+tran_id+"] | key_id="+dataItems.get(tran_id%10).get_KeyId()+" wirtes:"+value);
	}
	
	
}
