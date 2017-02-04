package top.mhcraft;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ListenThread extends Thread{
	static ExecutorService es;
	static String ip;
	static int th;
	static int port;
	tools t=new tools();
	public void run() {
		/*
		 * 
		 * mapÄÚÈÝÌî³ä
		 */
		es=Executors.newCachedThreadPool(new ThreadFactories());
		while(Configs.isRunning()){
			if(((ThreadPoolExecutor)es).getActiveCount()<th){
				es.execute(new MOTDThread(getMap()));
			}
		}

		
		
	}
	public HashMap<String, Object> getMap(){
		HashMap<String, Object> socksmap=t.getSocks();
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("socksip", socksmap.get("ip"));
		map.put("socksport",  socksmap.get("port"));
		map.put("ip", ip);
		map.put("port", port);
		return map;
		
	}
	public ListenThread(String ip,int port,int th){
		ListenThread.ip=ip;
		ListenThread.port=port;
		ListenThread.th=th;
	}
	

}
