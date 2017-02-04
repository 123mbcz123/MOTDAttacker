package top.mhcraft;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class tools {
	private static  ArrayList<String > list=new ArrayList<String >();
	//代理列表
	private static int i=0;
	//代理位置地址
	private static int times=0;
	//攻击次数
	private static List <RAMs> RList=new ArrayList<RAMs> ();
	//所有线程集合
	/*
	 * 获取代理地址
	 */
	public HashMap<String, Object> getSocks(){
		String[] ips=getIp().split("\\:");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("ip", ips[0]);
		map.put("port", (int )Integer.valueOf(ips[1]));
		return map;
		
	}
	/*
	 * 添加代理
	 */
	public void Update(ArrayList<String> list){
		tools.list=list;
	}
	/*
	 * 返回代理
	 */
	private String getIp(){
		String ip=list.get(i);
		i++;
		if(i==list.size()){
			i=0;
		}
		return ip;
		
	}
	/*
	 * 攻击统计
	 */
	public void HookTime(){
		times++;
	}
	/*
	 * 攻击数值返回
	 */
	public int getTimes(){
		return times;
	}

	public void addThread(Thread t,long unixtime){
		RList.add(new RAMs(unixtime,t));
	}
	public List <RAMs>  getList(){
		return RList;
		
	}
	public void Del(MOTDThread t){
		
	}
	

}