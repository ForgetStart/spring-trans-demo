/**
 * 
 */
package cn.com.fd.tx;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年1月16日 下午5:34:04
 */
@Service
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	
	
	@Transactional
	@Override
	public void checkOut(String userName, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(userName, isbn);
		}
	}

}
