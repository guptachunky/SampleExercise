package sample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8StreamsExample {

	class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
			new Person("David", 12));

	public static void main(String... args) {
		Java8StreamsExample java8StreamsExample = new Java8StreamsExample();
//		java8StreamsExample.example1();
//		java8StreamsExample.example2();
//		java8StreamsExample.example3();
//		java8StreamsExample.example4();
//		java8StreamsExample.example5();
		java8StreamsExample.example6();
	}

	private void example1() {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).filter(s -> s.endsWith("1")).sorted().forEach(System.out::println);
	}

	private void example2() {
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
	}

	private void example3() {
		IntStream.range(1, 4).forEach(System.out::println);
	}

	private void example4() {
		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	}

	private void example5() {
		Map<Integer, String> map = persons.stream()
				.collect(Collectors.toMap(p -> p.age, p -> p.name, (name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
	}

	private void example6() {
		Person result = persons.parallelStream().filter((x) -> "Pamela".equals(x.name) && 23 == x.age).findAny().orElse(null);
		System.out.println("Person: " + result);
	}
}














