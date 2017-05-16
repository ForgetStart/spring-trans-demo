package cn.com.fd.test.service;

import cn.com.fd.util.SpringContextUtils;

public class AnalysisWorker implements Runnable {
	
	@Override
	public void run() {
		TestTransImpl testTransImpl = SpringContextUtils.getBean(TestTransImpl.class);
		testTransImpl.putMsg();
	}
}
