package SERVER;
import java.rmi.*;

public interface SampleServer extends Remote{
	public int readTrans(int i_tranId) throws RemoteException;
	public void writeTrans(int i_tranId, int i_value) throws RemoteException;
}
