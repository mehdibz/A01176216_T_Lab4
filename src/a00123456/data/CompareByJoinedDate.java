/**
 * Project: A00123456Lab4
 * File: CompareByJoinedDate.java
 */

package a00123456.data;

import java.util.Comparator;

/**
 * @author Sam Cirka, A00123456
 *
 */
public class CompareByJoinedDate implements Comparator<Customer> {
	@Override
	public int compare(Customer customer1, Customer customer2) {
		return customer1.getJoinedDate().compareTo(customer2.getJoinedDate());
	}
}
