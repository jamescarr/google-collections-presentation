package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class LanguagePollTest {
	private LanguagePoll poll;
	
	@Before
	public void beforeEach(){
		poll = new LanguagePoll();
	}
	
	@Test
	public void shouldTallyVotesAndDisplayThem(){
		poll.vote("clojure");
		poll.vote("clojure");
		poll.vote("scala");
		poll.vote("scala");
		poll.vote("scala");
		poll.vote("java");
		poll.vote("java");
		poll.vote("jaskell");
		poll.vote("jaskell");
		poll.vote("jaskell");
		
		String results = poll.getResults();
		
		assertThat(results, equalTo("Results: [clojure x 2, scala x 3, java x 2, jaskell x 3]"));
	}
	
	@Test
	public void shouldBeAbleToGetNumberOfVotesForParticularLanguage(){
		poll.vote("java");
		poll.vote("java");
		poll.vote("java");
		
		assertThat(poll.getNumberOfVotesFor("java"), equalTo(3));
	}
	
	@Test
	public void shouldReturnZeroIfNoVotesCastForParticularLanguage(){
		assertThat(poll.getNumberOfVotesFor("java"), equalTo(0));
	}
	
	@Test
	public void shouldBeAbleToGetTotalNumberOfVotes(){
		poll.vote("clojure");
		poll.vote("clojure");
		poll.vote("scala");
		poll.vote("scala");
		
		assertThat(poll.getTotalVotes(), equalTo(4));
	}
}
