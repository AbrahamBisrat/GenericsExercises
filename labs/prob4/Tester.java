package labs.prob4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tester {
	
	public static void main(String[] args) {
		
		questionA();	
		
		questionB();
		
		
	}

	private static void questionA() {
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		double dbl = sum(nums);
		/*nums.add(3.14);*/
		
		/**
		 * There is an error in the above line due to type mismatch
		 * The wildcard accepted the type of nums list from the assignment
		 * to be Integer and the above line is trying to add Double 
		 * to an Integer list
		 */
	}

	private static void questionB() {
		List<Object> objs = new ArrayList<>();
		objs.add(1);
		objs.add("two");
		List<? super Integer> ints = objs;
		ints.add(3);
//		double dbl = sum(ints);
		
		/**
		 * objs -> is an an object array
		 * ints type is inferred from objs, thus making it Object array
		 * sum accepts Collection/List that extend Numbers or Numbers themselves
		 * It's lower-bounded in other terms
		 * ints type [Object] doesn't extend Number, thus producing type conflict
		 */
	}
	
	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		
		for(Number num : nums)
			s += num.doubleValue();
		return s;
	}
}
