package org.jamescarr.googlecollections;

import java.util.ArrayList;
import java.util.List;

public class ProductListFormatter {

	public String format(List<String> products) {
		StringBuilder builder = new StringBuilder();
		for(String product : products){
			if(product != null){
				builder.append(product).append(", ");
			}
		}
		return builder.delete(builder.length()-2, builder.length()).toString();
	}

	public String formatWithNulls(ArrayList<String> products) {
		StringBuilder builder = new StringBuilder();
		for(String product : products){
			if(product != null){
				builder.append(product).append(", ");
			}else{
				builder.append("Unknown").append(", ");
			}
		}
		return builder.delete(builder.length()-2, builder.length()).toString();
	}

}
