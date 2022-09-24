package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ToConvertStreamIntoMap {

	public static Map<String, Integer> toMap(String input) {
		Map<String, Integer> lengthMap = Arrays.stream(input.split(" "))
				.collect(Collectors.toMap(value -> value, value -> value.length()));

		return lengthMap;
	}

	public static void main(String[] args) {
		String input = "Geeks for Geek";

		System.out.println(toMap(input));
	}

}
