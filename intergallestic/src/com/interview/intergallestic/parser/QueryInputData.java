package com.interview.intergallestic.parser;

import java.util.ArrayList;
import java.util.List;

public class QueryInputData {
	
	private List<String> words;
	
	protected QueryInputData(List<String> words) {
		this.words = words;
	}
	
	public List<String> getElements() {
		return new ArrayList<String>(this.words);
	}
}
