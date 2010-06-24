package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class YearRangeTest {
	private YearRange range;
	
	@Test
	public void shouldCreateRangeOfYearsBetweenTwoProvidedYears(){
		range = YearRange.between(2002, 2005);
		
		assertThat(range, hasItems(2002, 2003, 2004, 2005));
	}
	
	@Test
	public void shouldReturnYearsSeparatedByCommasOnToString(){
		range = YearRange.between(2000, 2004);
		
		assertThat(range.toString(), equalTo("2000, 2001, 2002, 2003, 2004"));
	}
}
