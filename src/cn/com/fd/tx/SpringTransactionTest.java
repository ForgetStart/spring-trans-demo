/**
 * 
 */
package cn.com.fd.tx;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年1月16日 下午3:12:13
 */
public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService booService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext(new String [] {"applicationContext.xml"});
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDaoImpl");
		booService = (BookShopService) ctx.getBean("bookShopServiceImpl");
		cashier = (Cashier) ctx.getBean("cashierImpl");
	}
	
	@Test
	public void testFindBookPriceByIsbn(){
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	
	@Test
	public void testUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testUpdateUserAccount(){
		bookShopDao.updateUserAccount("AA", 70);
	}
	
	@Test
	public void testPurchase(){
		booService.purchase("AA", "1001");
	}
	
	/**
	 * 验证事务传播行为的方法
	 */
	@Test
	public void testCheckOut(){
		cashier.checkOut("AA", Arrays.asList("1001","1002"));
	}
}
