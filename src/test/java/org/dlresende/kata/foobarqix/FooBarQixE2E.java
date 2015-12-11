package org.dlresende.kata.foobarqix;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class FooBarQixE2E {

	private FooBarQix underTest;
	
	private Integer input;
	private String expected;



	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 
                 { 1, "1" }, 
                 { 2, "2" }, 
                 { 3, "FooFoo" }, 
                 { 4,  "4"}, 
                 { 5,  "BarBar" }, 
                 { 6,  "Foo" }  ,
                 { 53,  "BarFoo" }  ,
                 { 13,  "Foo" }  ,
                 { 15,  "FooBarBar" }  ,
                 { 33, "FooFooFoo"} ,
                 { 51, "FooBar"}
           });
    }
    
    
    public FooBarQixE2E(Integer input, String expected) {
		this.input = input;
		this.expected = expected;
		underTest = new FooBarQix();
	}

	
	
	@Test
	public void test() {
		assertThat(underTest.doFooBarQix(input)).isEqualTo(expected);

	}

}
