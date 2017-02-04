package top.mhcraft;

public class RAMs {
	/*
	 * 数据存储类
	 * 
	 */
	Thread t;
	
	Long time;
	public Thread getThread(){
		return t;
		
	}
	public long GetTime(){
		/*
		 * 返回Unix时间戳
		 */
		return time;
		
	}
	public RAMs(long time,Thread t){
		this.time=time;
		this.t=t;
		
	}
}
