package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.stream.Stream;

public class StreamExample4 {

	public static void main(String[] args) {

		// Convert both Alekhya & Rashmika stringd to upper case through Map.

		Stream.of("Adam", "David", "Alekhya", "Stalin", "Ash", "Abhilash", "Arvind", "Rashmika")
				.filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}

}
