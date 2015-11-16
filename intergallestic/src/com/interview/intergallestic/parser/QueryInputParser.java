package com.interview.intergallestic.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class QueryInputParser 
{
	private String QUERY_STRING_START_INDICATOR = "is";
	private String QUERY_STRING_END_INDICATOR = "?";
	
	public QueryInputData parse(String inputString)
			throws IllegalArgumentException {
		if (inputString == null || inputString == " ") {
			throw new IllegalArgumentException(
					"Input cannot be null || empty space");
		}
		StringTokenizer tokenizer = new StringTokenizer(inputString);
		List<String> wordList = new ArrayList<String>();
		QueryInputData inputData = new QueryInputData(wordList);
		boolean isStartQueryDetected = false;
		while (tokenizer.hasMoreTokens()) {
			String value = tokenizer.nextToken();
			if(QUERY_STRING_START_INDICATOR.equals(value) )
			{
				isStartQueryDetected = true;
			}
			else if(isStartQueryDetected && !value.equals(QUERY_STRING_END_INDICATOR))
			{
				wordList.add(value);
			}
		}
		if(!isStartQueryDetected)
		{
			throw new IllegalArgumentException("Query string should be <Any question word> followed by is romanword <...> metalname ?");
		}
		return inputData;
	}

}
