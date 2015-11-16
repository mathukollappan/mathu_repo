package com.interview.intergallestic.parser;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CreditsInputParser {

	private String CREDIT_STRING_SEPARATOR = "is";

	public CreditsInputData parse(String inputString)
			throws IllegalArgumentException {
		if (inputString == null || inputString == " ") {
			throw new IllegalArgumentException(
					"Input cannot be null || empty space");
		}
		StringTokenizer tokenizer = new StringTokenizer(inputString);
		CreditsInputData inputData = new CreditsInputData();
		while (tokenizer.hasMoreTokens()) {
			String value = tokenizer.nextToken();
			if (CREDIT_STRING_SEPARATOR.equals(value)) {
				try {
					float credit = Float.parseFloat(tokenizer.nextToken());
					inputData.setCredit(credit);
				} catch (NoSuchElementException ex) {
					throw new IllegalArgumentException(
							"Input should be \"word1 word2 word3 metal is (int/float) credits \"");
				} catch (NumberFormatException nfe) {
					throw new IllegalArgumentException(
							"Input should be \"word1 word2 word3 metal is (int/float) credits \"");
				}
				break;

			} else {
				inputData.addWord(value);
			}
		}
		return inputData;
	}

}
