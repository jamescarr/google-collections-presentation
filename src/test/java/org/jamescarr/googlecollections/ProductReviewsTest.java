package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class ProductReviewsTest {
	private Products products;
	@Before
	public void beforeEach(){
		products = new Products();
	}
	@Test
	public void shouldBeAbleToGetDescriptionForProduct(){
		products.addProduct("Kindle", "ebook reader");
		
		assertThat(products.getDescription("Kindle"), equalTo("ebook reader"));
	}
	
	@Test
	public void shouldBeAbleToGetProductNameForDescription(){
		products.addProduct("Kindle", "ebook reader");
		
		assertThat(products.getNameForDescription("ebook reader"), equalTo("Kindle"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenAddingProductWithSameDescription(){
		products.addProduct("Kindle", "ebook reader");
		
		products.addProduct("Nook", "ebook reader");
	}
	
	@Test
	public void shouldRemoveExistingProductWhenAddingOneWithSameDescription(){
		products.addProduct("Kindle", "ebook reader");
		
		products.forceAddProduct("Nook", "ebook reader");
		
		assertThat(products.getNameForDescription("ebook reader"), equalTo("Nook"));
	}
	
	@Test
	public void forcedAddShouldRemoveExistingProduct(){
		products.addProduct("Kindle", "ebook reader");
		
		products.forceAddProduct("Nook", "ebook reader");
		
		assertThat(products.getDescription("Kindle"), equalTo(null));
		
	}
}
