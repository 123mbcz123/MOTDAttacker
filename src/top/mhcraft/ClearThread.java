package top.mhcraft;
import java.util.List;
import java.util.TimerTask;

public class ClearThread extends TimerTask{

	@SuppressWarnings("deprecation")
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			UnixTime=System.currentTimeMillis();
			tools Tools=new tools();
			List<RAMs> list=Tools.getList();
			Thread t=null;
			RAMs r=null;
			for(int i=0;i<list.size();i++){
				r=list.get(i);
				t=r.getThread();
				
				if(t!=null&&t.isAlive()){
					if((UnixTime-r.GetTime())>=time){
						t.stop();
						list.remove(r);
					}
				}else{
					list.remove(r);
				}
			}

		}
		//}
	}
	long UnixTime=0;
	int time=0;
	
	public ClearThread(int time){
		this.time=time;
		/*
		 * 设置线程存活时间
		 */
	}
}
