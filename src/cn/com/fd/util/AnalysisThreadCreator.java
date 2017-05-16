package cn.com.fd.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.com.fd.test.service.AnalysisWorker;


/**
 * Description:创建线程管理类，根据服务器cpu数量启动相应的线程数
 * @author fengda
 * @date 2016年8月8日 下午3:19:51
 */
public class AnalysisThreadCreator implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		for(int i=0;i<3;i++){
			System.out.println("********************************");
			AnalysisWorker analysisWorker = new AnalysisWorker();
			Thread analyThread = new Thread(analysisWorker);
			analyThread.start();
		}
	}

}
