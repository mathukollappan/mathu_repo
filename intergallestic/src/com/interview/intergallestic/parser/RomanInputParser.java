package com.interview.intergallestic.parser;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class RomanInputParser {
	
	private String ROMAN_STRING_SEPARATOR = "is";

	public RomanInputData parse(String inputString)
			throws IllegalArgumentException {

		if (inputString == null || inputString == " ") {
			throw new IllegalArgumentException(
					"Input cannot be null || empty space");
		}
		StringTokenizer tokenizer = new StringTokenizer(inputString);
		String oldString = "";
		while (tokenizer.hasMoreTokens()) {
			String value = tokenizer.nextToken();
			if(ROMAN_STRING_SEPARATOR.equals(value) && !oldString.equals(""))
			{
				try{
				return new RomanInputData(oldString,tokenizer.nextToken());
				}
				catch(NoSuchElementException ex)
				{
					throw new IllegalArgumentException("Input should be \"word is roman char \"");
				}
			}
			oldString = value;
		}
		throw new IllegalArgumentException("Input should be \"word is roman char \"");
	}

}
