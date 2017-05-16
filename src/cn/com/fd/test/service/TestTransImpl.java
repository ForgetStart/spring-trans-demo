package cn.com.fd.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransImpl implements TestTrans {

	@Transactional(isolation=Isolation.SERIALIZABLE)
	@Override
	public void putMsg() {
		System.out.println("****************线程开始**************************");
		System.out.println(Thread.currentThread().getId());
		int a = 1;
		int b = 2;
		for(int i=0; i<10; i++){
			int s = a+b;
		}
		System.out.println("******************线程结束*****************************");
	}

}
