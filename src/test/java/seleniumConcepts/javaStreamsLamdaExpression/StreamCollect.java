package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollect {

	public static void main(String[] args) {
		String[] names = { "Ashok", "Sanjay", "Bheem", "Chetan", "Eshaan" };
		
		List<String> list = Arrays.asList(names).stream().filter(x->x.endsWith("n")).sorted().map(x->x.toLowerCase()).collect(Collectors.toList());
		
		System.out.println(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		Set<String> set = Arrays.asList(names).stream().filter(x->x.endsWith("n")).sorted().map(x->x.toLowerCase()).collect(Collectors.toSet());
		
		System.out.println(set);
		
		Map<String, Integer> map = Arrays.asList(names).stream().collect(Collectors.toMap(value -> value, value -> value.length()));
		
		System.out.println(map);

	}

}
