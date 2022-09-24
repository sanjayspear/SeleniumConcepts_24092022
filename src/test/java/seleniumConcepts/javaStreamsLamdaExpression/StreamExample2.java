package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamExample2 {

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
		
		System.out.println("Length of String greater then 4");
		
		names.stream().filter(s->s.length() > 4).forEach(s->System.out.println(s));
		
		System.out.println("Length of String greater then 5");
		
		Stream.of("Adam", "David", "Alekhya", "Stalin", "Ash", "Abhilash", "Arvind", "Rashmi")
		.filter(s -> s.length() >= 7 ).forEach(s->System.out.println(s));
		

	}

}
