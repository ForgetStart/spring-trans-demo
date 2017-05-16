/**
 * 
 */
package cn.com.fd.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年1月16日 下午3:45:25
 */
@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	/* (non-Javadoc)
	 * @see cn.com.fd.tx.BookShopService#purchase(java.lang.String, java.lang.String)
	 */
	/**
	 * @Transactional(propagation=Propagation.REQUIRES_NEW)
	 * 当如上配置时，在被checkOut事务方法调用时，即使checkOut方法有事务，
	 * 但是purchase仍然独自开启一个事务，当用户余额只购买一本书，库存充足时，
	 * 购买第二本书时，出现异常，事务回滚时回滚到购买第二本书的起始，第一本购买成功
	 */
	@Transactional
	@Override
	public void purchase(String username, String isbn) {
		
		//获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//更新用户余额
		bookShopDao.updateUserAccount(username, price);

	}

}
