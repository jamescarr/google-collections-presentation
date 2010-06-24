package org.jamescarr.googlecollections;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class YearRange implements Iterable<Integer>{
	private final ImmutableSet<Integer> years;

	private YearRange(ImmutableSet<Integer> years){
		this.years = years;
	}
	
	public static YearRange between(int start, int end) {
		Set<Integer> years = Sets.newLinkedHashSet();
		for(int year = start; year <= end; year++){
			years.add(year);
		}
		return new YearRange(ImmutableSet.copyOf(years));
	}

	@Override
	public Iterator<Integer> iterator() {
		return years.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int year : years){
			builder.append(year).append(", ");
			
		}
		return builder.delete(builder.length()-2, builder.length()).toString();
	}
	
	

}
