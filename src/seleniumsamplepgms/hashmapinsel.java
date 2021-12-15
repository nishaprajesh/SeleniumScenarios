package seleniumsamplepgms;

import java.util.HashMap;

public class hashmapinsel {
/* Role based or permission based use cases
 * eg: manager user : see all the orders
 * customers: only see products
 * seller: only matching orders
 */
	public static void main(String[] args) {
		
		getcredentials().get("customer");
	}
	public static HashMap<String,String> getcredentials()
	{
		HashMap<String, String> usermap= new HashMap<String, String>();
		usermap.put("manager", "user1:pwd1");
		usermap.put("customer", "user2:pwd2");
		usermap.put("seller", "user3:pwd3");
		return usermap;
				
	}

}
