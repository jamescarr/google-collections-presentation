package org.jamescarr.googlecollections;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;


public class MapMakerExample {
	@Test
	public void anExampleOfMapMaker(){
		ConcurrentMap<String, String> map = new MapMaker()
			.weakKeys()
			.weakValues()
			.expiration(1, TimeUnit.NANOSECONDS)
			.makeComputingMap(new Function<String, String>() {
				@Override
				public String apply(String input) {
					return new StringBuffer(input).reverse().toString() 
								+ System.currentTimeMillis();
				}
			});
		
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
		System.out.println(map.get("one"));
	}
}
