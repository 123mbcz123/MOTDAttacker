package top.mhcraft;

import java.util.concurrent.ThreadFactory;

public class ThreadFactories implements ThreadFactory{
	/*
	 * ���� Javadoc��
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 * �̹߳���
	 */
	@Override
	public Thread newThread(Runnable r) {
		tools t=new tools();
		Thread th=new Thread(r);
		t.addThread(th, System.currentTimeMillis());
		return th;
	}
	
	
}
	

