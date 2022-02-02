package labs.prob5;

import java.util.ArrayList;
import java.util.List;

public class SecondSmallestGeneric {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>() {
			{
				add(0);
				add(1);
				add(1);
				add(3);
				add(5);
				add(43);
				add(234);
			}
		};
		System.out.println(secondBiggest(numbers));
		
		System.out.println(secondSmallest(numbers));
		
	}
	
	private static int secondBiggest(List<Integer> numsList) {
		int max = numsList.get(0);
		int deputyMax = numsList.get(0);
		for(int each : numsList) {
			if(each > max){
				deputyMax = max;
				max = each;
			}
			else if(each > deputyMax) {
				deputyMax = each;
			}
		}
		return deputyMax;
	}
	
	private static int secondSmallest(List<Integer> numbers) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for(int each : numbers) {
			if(each < smallest) {
				secondSmallest = smallest;
				smallest = each;
			}else if(secondSmallest > each) {
				secondSmallest = each;
			}
		}
		return secondSmallest;
	}

}
