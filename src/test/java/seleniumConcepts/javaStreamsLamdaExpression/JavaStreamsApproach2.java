package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.stream.Stream;

public class JavaStreamsApproach2 {

	public static void main(String[] args) {
		long D = Stream.of("Adam", "David", "Alekhya", "Danial", "Ash", "Abhilash", "Arvind", "Rashmi").filter(s ->

		{
			s.startsWith("D");
			return true;
		}).count();

		System.out.println("Name starts with 'A' count " + D
				+ " ==> Using streams but, without convertin list into streams [Used Streams Directly]");

	}

}
