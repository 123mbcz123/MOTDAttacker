package top.mhcraft;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class tools {
	private static  ArrayList<String > list=new ArrayList<String >();
	//�����б�
	private static int i=0;
	//����λ�õ�ַ
	private static int times=0;
	//��������
	private static List <RAMs> RList=new ArrayList<RAMs> ();
	//�����̼߳���
	/*
	 * ��ȡ�����ַ
	 */
	public HashMap<String, Object> getSocks(){
		String[] ips=getIp().split("\\:");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("ip", ips[0]);
		map.put("port", (int )Integer.valueOf(ips[1]));
		return map;
		
	}
	/*
	 * ��Ӵ���
	 */
	public void Update(ArrayList<String> list){
		tools.list=list;
	}
	/*
	 * ���ش���
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
	 * ����ͳ��
	 */
	public void HookTime(){
		times++;
	}
	/*
	 * ������ֵ����
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