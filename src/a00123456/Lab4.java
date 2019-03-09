/**
 * Project: A00123456Lab4
 * File: Lab4.java
 */

package a00123456;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import a00123456.data.CompareByJoinedDate;
import a00123456.data.Customer;
import a00123456.io.CustomerReader;
import a00123456.io.CustomerReport;

/**
 * To demonstrate knowledge Generics and Collections
 * 
 * Create a commandline program which reads customer data, creates Customer objects, adds them to a collection, and prints a simple Customer report
 * sorted by joined date
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class Lab4 {

	private static final Instant startTime = Instant.now();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(startTime);

		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			printEndTimeAndDuration();
			System.exit(-1);
		}

		new Lab4().run(args[0]);
	}

	public static void printEndTimeAndDuration() {
		Instant endTime = Instant.now();
		System.out.println(endTime);

		// print the duration
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Populate the customers and print them out.
	 */
	private void run(String customerData) {
		try {
			Map<Long, Customer> customers = CustomerReader.read(customerData);

			// sort the customers by joined date
			List<Customer> customersList = new ArrayList<>(customers.values());
			Collections.sort(customersList, new CompareByJoinedDate());

			CustomerReport.write(customersList);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		} finally {
			printEndTimeAndDuration();
		}
	}

}
