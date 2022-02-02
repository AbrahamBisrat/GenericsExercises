package labs.prob5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SecondSmallestGeneric {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>() {
			{	
				add(3);
				add(5);
				add(43);
				add(234);
				add(0);
				add(1);
				add(1);
			}
		};
		
		System.out.println(secondBiggest(numbers));
		
		System.out.println(secondSmallest(numbers));
		
		System.out.println(smallestGeneric(numbers));
		
		System.out.println(secondSmallestGen(numbers));
		
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
	
	public static <T extends Comparable<T>> T smallestGeneric(List< T> list) {
		T smallest = list.get(0);
		for(T each : list) {
			if(each.compareTo(smallest) < 0) {
				smallest = each;
			}
		}
		return smallest;
	}
	
	public static <T extends Comparable<T>> T secondSmallestGen(List<T> list) {
		return list.stream()
				   .distinct()
				   .sorted()
				   .limit(2)
				   .collect(Collectors.toList())
				   .get(1);
	}
}
