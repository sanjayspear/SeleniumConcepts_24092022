package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheUniqueNumberUsingStream {

	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 5, 2, 1, 5, 6, 3, 2, 7, 8, 4, 9, 4, 5, 8, 7, 6, 8 };

		List<Integer> values1 = Arrays.asList(arr);

		values1.stream().distinct().sorted().forEach(v -> System.out.println(v));
		
		System.out.println("================================================================");
		
		List<Integer> values2 = Arrays.asList(arr);

		List<Integer> list = values2.stream().distinct().sorted().collect(Collectors.toList());
		
		System.out.println(list.get(4));
		System.out.println(list.get(5));
	}

}
