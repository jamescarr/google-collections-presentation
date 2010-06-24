package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;


public class UnmodifiableVsImmutable {
	private List<String> list;
	
	@Before
	public void beforeEach(){
		list = new ArrayList<String>();
		list.add("one");
		list.add("two");
	}
	@Test
	public void shouldUpdateViewOfListWithModifiedItems(){
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		list.add("three");
		
		assertThat(unmodifiableList.size(), equalTo(3));
	}
	
	@Test
	public void shouldNotUpdateContentsOfImmutableListWhenSourceListChanges(){
		List<String> immutableList = ImmutableList.copyOf(list);
		
		list.add("three");
		
		assertThat(immutableList.size(), equalTo(2));
	}
}
