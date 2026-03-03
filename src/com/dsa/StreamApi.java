package com.dsa;

import java.util.Arrays;
import java.util.List;

public class StreamApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("mohit", "prashant", "abhay", "mandeep", "ankit");

		long namesLength = names.stream().filter(name -> name.length() >= 5).count();
		System.out.println(namesLength);
	}

}
