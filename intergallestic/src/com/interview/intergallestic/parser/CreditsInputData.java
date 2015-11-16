package com.interview.intergallestic.parser;

import java.util.ArrayList;
import java.util.List;

public class CreditsInputData {
	
	private List<String> words = new ArrayList<>();
	private float credits;
	
	protected CreditsInputData() {
		
	}
	
	protected void addWord(String word)
	{
		words.add(word);
	}
	
	protected void setCredit(float credits)
	{
		this.credits = credits;
	}
	
	public String getMetal() {
		if(words.size() >= 1)
		{
			return words.get(words.size()-1);
		}
		return null;
	}
	
	public float getCredits()
	{
		return this.credits;
	}
	
	public List<String> getCompleteList()
	{
		return new ArrayList<String>(this.words);
	}
	

}
