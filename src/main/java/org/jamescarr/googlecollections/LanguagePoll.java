package org.jamescarr.googlecollections;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

public class LanguagePoll {
	private final Multiset<String> languages = LinkedHashMultiset.create();
	
	public void vote(String language) {
		languages.add(language);
	}

	public String getResults() {
		return "Results: " + languages.toString();
	}

	public Integer getNumberOfVotesFor(String language) {
		return languages.count(language);
	}

	public Integer getTotalVotes() {
		return languages.size();
	}

}
