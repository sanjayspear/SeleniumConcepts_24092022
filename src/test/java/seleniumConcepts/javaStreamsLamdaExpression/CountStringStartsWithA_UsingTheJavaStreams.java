package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CountStringStartsWithA_UsingTheJavaStreams {

	public static void main(String[] args) {
		// Without Using Java Streams

		int count = 0;
		ArrayList<String> names = new ArrayList<String>();

		names.add("Adam");
		names.add("David");
		names.add("Alekhya");
		names.add("Stalin");
		names.add("Ash");
		names.add("Abhilash");
		names.add("Arvind");
		names.add("Rashmi");

		for (int i = 0; i < names.size(); i++) {
			String str = names.get(i);

			if (str.startsWith("A")) {
				count++;
			}
		}

		System.out.println("Name starts with 'A' count " + count + " ==> without using java streams concepts");

		// Using Java Steams

		long c = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println("Name starts with 'A' count " + c + " ==> with using java streams concepts");

		/*
		 * NOTE: 1. stream() method converts all name into java streams. 2. filter() is
		 * the intermediate operator. 3. Count is the terminal operator. 4. There is no
		 * life for the filter(...) [Intermediate operator] if there is no count()
		 * [Terminal operator].
		 * 
		 */

		// NOTE: You can directly use streams for practice without converting Collection
		// / list into streams.

		// Ex:

		long xcount = Stream.of("Adam", "David", "Alekhya", "Stalin", "Ash", "Abhilash", "Arvind", "Rashmi")
				.filter(s -> s.startsWith("A")).count();

		System.out.println("Name starts with 'A' count " + xcount
				+ " ==> Using streams but, without convertin list into streams [Used Streams Directly]");

	}

}
