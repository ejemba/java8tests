package org.dlresende.kata.foobarqix;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 
 * This class implements the FooBarQix Kata.
 * 
 * 
 * 
 * 
 * 
 * @author ejemba
 *
 */
public class FooBarQix {

	public String doFooBarQix(Integer candidate) {

		StringBuilder builder = new StringBuilder();

		if (candidate == null) {
			return "";
		}

		if (isDivisibleByX(candidate, 3)) {
			builder.append("Foo");
		}
		if (isDivisibleByX(candidate, 5)) {
			builder.append("Bar");
		}
		if (isDivisibleByX(candidate, 7)) {
			builder.append("Qix");
		}
		
		TreeMap<Integer,String> m = new TreeMap<>();
		Result r;
		int index;
		if (( r = containsX(candidate, 3)).result() ) {
			r.populate(m , "Foo");
			//m.put(index, "Foo");
			
		}
		// if (( index = containsX(candidate, 5)) != 0) {
	    if (( r = containsX(candidate, 5)).result()) {
	    	r.populate(m , "Bar");
			// m.put(index, "Bar");
		}
		if (( r = containsX(candidate, 7)).result()) {
			r.populate(m , "Qix");
			//m.put(index, "Qix");
		}
		
		m.descendingMap().forEach((i , s)  -> { builder.append(s) ;} ) ;
		
		
		
		if (builder.length() == 0) {
			builder.append(candidate);
		}
		

		return builder.toString();
	}

	protected boolean isDivisibleByX ( Integer candidate, Integer x) {

		return candidate % x == 0;
	}

	public class Result {
		
		private List<Integer> feedbacks = new ArrayList<>();
		
		public void addFeedback(int feedback) {
			feedbacks.add(feedback);
		}
		
		public void populate(TreeMap<Integer, String> m, String string) {
			feedbacks.stream().forEach((i) -> {  m.put(i , string); } );
		}

		public boolean result() {
			return feedbacks.stream().anyMatch( (i)  -> {  return i.intValue() != 0 ; } );
		}
	}
	
	
	/**
	 * 
	 * 
	 * @param candidate
	 * @param digitToFind
	 * 
	 * @return an integer which is 0 if digitToFind is not in candidate and a positive number if it is.
	 */
	protected Result containsX ( Integer candidate , Integer digitToFind ) {
		
		int feedback = 0	;
		Result r = new Result();
		
		int thisNumber = candidate >= 0 ? candidate : -candidate; // ?: => Conditional
															// Operator
		int thisDigit;
		
        int counter = 0;
		
        while (thisNumber != 0) {
		    counter++;	
			thisDigit = thisNumber % 10; // Always equal to the last digit of
											// thisNumber
			thisNumber = thisNumber / 10; // Always equal to thisNumber with the
											// last digit chopped off, or 0 if
											// thisNumber is less than 10
			if (thisDigit == digitToFind) {
				feedback = counter;
				r.addFeedback(feedback);
				
			}
		}
        
		return r;
	}
	
	
	public static void main(String[] args) {
		FooBarQix fbq = new FooBarQix();
		
		IntStream.rangeClosed(1, 100).forEachOrdered( (i) -> {  System.out.printf("%s\n", fbq.doFooBarQix(i)); } ) ;
	}

}
