package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import static java.util.Arrays.asList;

public class OrderingExample {
	private final ImmutableList<String> languages = ImmutableList.of("java", "scala", "groovy", "clojure");
	
	
	@Test
	public void shouldProvideNaturalOrdering(){
		List<String> sortedLanguages = Ordering.natural().sortedCopy(languages);
		
		assertThat(sortedLanguages, equalTo(asList("clojure", "groovy", "java", "scala")));
	}
	
	@Test
	public void shouldProvideReverseOrdering(){
		List<String> sortedLanguages = Ordering.natural().reverse().sortedCopy(languages);
		
		assertThat(sortedLanguages, equalTo(asList("scala", "java", "groovy","clojure")));
	}
	
	@Test
	public void shouldOrderExplicitly(){
		List<String> sortedLanguages = Ordering.explicit("clojure", "scala", "groovy", "java").sortedCopy(languages);
		
		assertThat(sortedLanguages, equalTo(asList("clojure", "scala", "groovy", "java")));
	}
	@Test
	public void shouldFindMinAndMaxUsingOrdering(){
		Ordering<String> ordering = Ordering.explicit("clojure", "scala", "groovy", "java");
		
		assertThat(ordering.max("clojure", "java"), equalTo("java"));
		assertThat(ordering.min("scala", "java"), equalTo("scala"));
	}
	
}
