package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.Arrays;

public class SortArrayTroughStreams {

	public static void main(String[] args) {
		String[] arr = {"Sanjay", "Mithun", "Ashok", "Mayank", "Ritesh", "Shrusti", "Shreya", "Karthik", "Aishu", "Ranjitha", "Abhilash", "Arvind"};
		
		
		Arrays.asList(arr).stream().sorted().forEach(System.out::println);
		System.out.println("====================================================================");
		Arrays.asList(arr).stream().sorted().map(s->s.toUpperCase()).forEach(System.out::println);
		System.out.println("====================================================================");
		Arrays.asList(arr).stream().filter(s->s.length()>6).sorted().map(s->s.toUpperCase()).forEach(System.out::println);
		System.out.println("====================================================================");
		Arrays.asList(arr).stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase()).forEach(System.out::println);
	}

}
