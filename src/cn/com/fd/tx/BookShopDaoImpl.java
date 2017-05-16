/**
 * 
 */
package cn.com.fd.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.com.fd.exception.AccountException;
import cn.com.fd.exception.StockException;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年1月16日 下午2:25:29
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/* (non-Javadoc)
	 *	根据书号获取书的单价
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "select price from book where isbn = ?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	/* (non-Javadoc)
	 * 更新书的库存，使书号对应的库存 -1
	 */
	@Override
	public void updateBookStock(String isbn) {
		//检查书的库存是否足够，不够则抛出异常
		String sql2 = "select stock from book_stock where isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock == 0){
			throw new StockException("库存量不足");
		}
		
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	/* (non-Javadoc)
	 * 更新用户的账户余额，使username的balance - price
	 */
	@Override
	public void updateUserAccount(String userName, int price) {
		
		//检查余额是否足够，不够则抛出异常
		String sql2 = "select balance from account where username = ?";
		int account = jdbcTemplate.queryForObject(sql2, Integer.class,userName);
		if(account < price){
			throw new AccountException("余额不足");
		}
		
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price,userName);
	}

}
