package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoArraysUsingStream {

	public static void main(String[] args) {

		String[] MaleNames = { "Ashok", "Sanjay", "Bheem", "Chetan", "Eshaan" };
		String[] FemaleNames = { "Aishu", "Chaitra", "Barani", "Sanchita", "Neelam" };

		List<String> name1 = Arrays.asList(MaleNames);
		List<String> name2 = Arrays.asList(FemaleNames);

		Stream<String> newStream1 = Stream.concat(name1.stream(), name2.stream());

		newStream1.sorted().forEach(System.out::println);

		boolean flag = Stream.concat(name1.stream(), name2.stream()).anyMatch(i -> i.equalsIgnoreCase("Sanjay"));

		if (flag == true) {
			System.out.println("Matching string found");
		}else {
			System.out.println("Matching string not Sfound");
		}
	}

}
