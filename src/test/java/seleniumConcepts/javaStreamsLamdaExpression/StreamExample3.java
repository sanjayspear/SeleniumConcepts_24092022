package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamExample3 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Adam");
		names.add("David");
		names.add("Alekhya");
		names.add("Stalin");
		names.add("Ash");
		names.add("Abhilash");
		names.add("Arvind");
		names.add("Rashmi");

		System.out.println("Length of String greater then 4 and limited to only 3 results");
		System.out.println();

		// You can also limit the out of the intermediate stream result

		names.stream().filter(s -> s.length() > 4).limit(3).forEach(s -> System.out.println(s));

		System.out.println();
		System.out.println("Length of String greater then 5 and limited to only 2 results");
		System.out.println();

		// You can also limit the out of the intermediate stream result

		Stream.of("Adam", "David", "Alekhya", "Stalin", "Ash", "Abhilash", "Arvind", "Rashmi")
				.filter(s -> s.length() >= 5).limit(2).forEach(s -> System.out.println(s));

	}

}
