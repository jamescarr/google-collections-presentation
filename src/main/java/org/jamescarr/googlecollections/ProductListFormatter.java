package org.jamescarr.googlecollections;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class ProductListFormatter {

	public String format(List<String> products) {
		return Joiner.on(", ").skipNulls().join(products);
	}

	public String formatWithNulls(ArrayList<String> products) {
		return Joiner.on(", ").useForNull("Unknown").join(products);
	}

}
