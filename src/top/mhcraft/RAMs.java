package top.mhcraft;

public class RAMs {
	/*
	 * ���ݴ洢��
	 * 
	 */
	Thread t;
	
	Long time;
	public Thread getThread(){
		return t;
		
	}
	public long GetTime(){
		/*
		 * ����Unixʱ���
		 */
		return time;
		
	}
	public RAMs(long time,Thread t){
		this.time=time;
		this.t=t;
		
	}
}
