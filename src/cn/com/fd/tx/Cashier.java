/**
 * 
 */
package cn.com.fd.tx;

import java.util.List;

/**
 * <p> Description: </p>
 * @author fengda
 * @date 2017年1月16日 下午5:32:54
 */
public interface Cashier {

	public void checkOut(String userName, List<String> isbns);
	
}
