package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;


public class ProductListFormatterTest {
	private final ProductListFormatter formatter = new ProductListFormatter();
	
	@Test
	public void shouldNotIncludeNullsInFormattedOutput(){
		String output = formatter.format(newArrayList("apple", null, null, "orange", null));
		
		assertThat(output, equalTo("apple, orange"));
	}
	
	@Test
	public void shouldIncludeNullItemsAsUnknownProduct(){
		String output = formatter.formatWithNulls(newArrayList("apple", null, null, "orange", null));
		
		assertThat(output, equalTo("apple, Unknown, Unknown, orange, Unknown"));
	}
}
