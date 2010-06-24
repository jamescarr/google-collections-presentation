package org.jamescarr.googlecollections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Products {
	private final BiMap<String, String> products = HashBiMap.create();
	
	public void addProduct(String name, String description) {
		products.put(name, description);
	}

	public String getDescription(String name) {
		return products.get(name);
	}

	public String getNameForDescription(String desc) {
		return products.inverse().get(desc);
	}

	public void forceAddProduct(String name, String description) {
		products.forcePut(name, description);
	}

}
