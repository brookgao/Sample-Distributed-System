package DATA;


public class dataRecord {
	private final int IDLE_MODE = 0;
	private final int READ_MODE = 1;
	private final int WRITE_MODE = 2;
	private final int READ_TIME = 5000;
	private final int WRITE_TIME = 5000;
	
	private int state;
	private int key_id;
	private int value;
	
	public dataRecord(int i_keyId, int i_value){
		key_id = i_keyId;
		state = IDLE_MODE;
		value =i_value;
	}
	
	public synchronized int op_read(){
		int out_value;
		
		/*
		op		state	action
		-------------------------------
		READ		IDLE	-> process
		READ		READ	-> block
		READ		WRITE	-> block
		*/

		
		while(state != IDLE_MODE){
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
		
		state = READ_MODE;
		
		try{
			Thread.sleep(READ_TIME);
		}catch(InterruptedException e){
			//no messages
		}
		
		out_value = value;
		state = IDLE_MODE;
		
		notifyAll();
		return (out_value);
	}
	
	public synchronized void op_write(int i_value){
		/*
		op		state	action
		-------------------------------
		READ		IDLE	-> process
		READ		READ	-> block
		READ		WRITE	-> block
		*/
		
		while(state != IDLE_MODE){
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
		
		state = WRITE_MODE;
		
		try{
			Thread.sleep(WRITE_TIME);
		}catch(InterruptedException e){
			//no messages
		}
		
		value = i_value;
		state = IDLE_MODE;
		
		notifyAll();
	}
	
	public int get_KeyId(){
		return (key_id);
	}

}
