package org.jamescarr.googlecollections;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;


public class MapMakerExample {
	private ConcurrentMap<String, String> map = new MapMaker()
		.weakKeys()
		.weakValues()
		.expiration(1, TimeUnit.NANOSECONDS)
		.concurrencyLevel(32)
		.makeComputingMap(new Function<String, String>() {
			@Override
			public String apply(String input) {
				return new StringBuffer(input).reverse().toString() 
				+ System.currentTimeMillis();
			}
		});
	
	
	@Test
	public void anExampleOfMapMaker(){
		map.put("one", "two");
		
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
	}
	
}
