package com.interview.intergallestic.parser;

public class RomanInputData {

	private String inputWord;
	private String  romanWord;

	public RomanInputData(String inputWord, String romanWord) {
		this.inputWord = inputWord;
		this.romanWord = romanWord;
	}

	public String getInputWord() {
		return inputWord;
	}

	public String getRomanWord(){
		return romanWord;
	}
}
