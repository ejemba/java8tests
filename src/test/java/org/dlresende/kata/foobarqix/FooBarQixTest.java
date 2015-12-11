package org.dlresende.kata.foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class FooBarQixTest {

	FooBarQix underTest;

	@Before
	public void Given() {
		// Given
		underTest = new FooBarQix();

	}
	
	@Test
	public void isDivisibleByX() {
		// When
		Integer input = 3;
		Integer quotient = 3;

		// Then
		assertThat(underTest.isDivisibleByX(input, quotient)).isTrue();
		// When
		input = 0;
		// Then
		assertThat(underTest.isDivisibleByX(input, quotient)).isTrue();

		// When
		input = 27;

		// Then
		assertThat(underTest.isDivisibleByX(input, quotient)).isTrue();

		// When
		input = 13;
		// Then
		assertThat(underTest.isDivisibleByX(input, quotient)).isFalse();

	}

	@Test
	public void containsDigit() {
		{
			// When
			Integer input = 457;
			Integer figureToFInd = 4;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			
			// .isEqualTo(3);
		}
		{
			// When
			Integer input = 457;
			Integer figureToFInd = 5;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			//.isEqualTo(2);
		}
		{
			// When
			Integer input = 457;
			Integer figureToFInd = 7;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			//.isEqualTo(1);
		}
		{
			// When
			Integer input = 457;
			Integer figureToFInd = 8;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isFalse();
		}
		{
			// When
			Integer input = 1234567890;
			Integer figureToFInd = 0;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			//.isEqualTo(1);
		}

		{
			// When
			Integer input = 1234567890;
			Integer figureToFInd = 9;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			//.isEqualTo(2);
		}
		{
			// When
			Integer input = 1234567890;
			Integer figureToFInd = 1;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			//.isEqualTo(10);
		}
				
		{
			// When
			Integer input = 33;
			Integer figureToFInd = 3;

			// Then
			assertThat(underTest.containsX(input, figureToFInd).result()).isTrue();
			
			//.isEqualTo(1);
		}
	}
	
	@Test
	public void test () {
		SortedMap<Integer,String> m = new TreeMap<>();
		
		m.put(7, "sept");
		m.put(97, "quatre vingt dix sept");
		m.put(0, "zero");
		
		m.forEach((i , s)  -> { System.out.printf("%d - %s \n" , i , s); } ) ;
	}

	@Test
	public void testDoFooBarQix() {
		// When
		Integer input = 3;
		// Then
		assertThat(underTest.doFooBarQix(input)).contains("Foo");

		// Wjen
		input = null;
		// Then
		assertThat(underTest.doFooBarQix(input)).isEmpty();

		// When

	}

}
