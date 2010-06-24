package org.jamescarr.googlecollections;

import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import static org.junit.matchers.JUnitMatchers.hasItems;

import static org.hamcrest.CoreMatchers.*;
public class MultiMapExample {

	@Test
	public void exampleOfMultipleValues(){
		Multimap<String, String> map = LinkedHashMultimap.create();
		
		map.put("foo", "bar");
		map.put("foo", "baz");
		map.put("foo", "baz");
		map.put("foo", "foobar");
		
		assertThat(map.get("foo"), hasItems("baz", "bar", "baz", "foobar"));
	}
	
	@Test
	public void shouldBeAbleToCheckIfSpecificValueIsPresent(){
		Multimap<String, String> map = LinkedHashMultimap.create();
		map.put("foo", "bar");
		map.put("foo", "baz");
		
		assertThat(map.containsEntry("foo", "bar"), is(true));
	}
	
	@Test
	public void shouldRemoveSpecificValue(){
		Multimap<String, String> map = LinkedHashMultimap.create();
		map.put("foo", "bar");
		map.put("foo", "baz");
		
		map.remove("foo", "bar");
		
		assertThat(map.containsEntry("foo", "bar"), is(false));
	}
	
	@Test
	public void wellWeDecidedWeWantThatRawMapBack(){
		Multimap<String, String> map = LinkedHashMultimap.create();
		map.put("foo", "bar");
		map.put("foo", "baz");
		
		Map<String, Collection<String>> uglyMultiMap = map.asMap();
		
		assertThat(uglyMultiMap.get("foo"), hasItems("bar", "baz"));
	}
	
	@Test
	public void shouldRemoveAllElements(){
		Multimap<String, String> map = LinkedHashMultimap.create();
		map.put("foo", "bar");
		map.put("foo", "baz");

		map.removeAll("foo");
		
		assertThat(map.get("foo").isEmpty(), is(true));
	}
	
}
