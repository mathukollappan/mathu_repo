package com.interview.intergallestic.dataStore;

import java.util.HashMap;
import java.util.Map;

import com.interview.intergallectic.utils.RomanNumeral;

public class DataStore {

	private Map<String, Integer> romanToNumericalMapping = new HashMap<String, Integer>();
	private Map<String, String> romanWordToRomanCharMapping = new HashMap<String, String>();
	private Map<String, Float> metalWordToMetalValueMapping = new HashMap<String, Float>();
	private RomanNumeral romanNumeral = new RomanNumeral();

	public void init() {
		for (int i = 1; i <= 3999; ++i) {
			String romanNumber = romanNumeral.getRomanString(i);
			romanToNumericalMapping.put(romanNumber, i);
		}
	}

	public void addMetalWord(String metalName, Float value) {
		if (metalName != null && value != null) {
			metalWordToMetalValueMapping.put(metalName, value);
		}
	}

	public void addRomanWord(String romanalais, String value) {
		if (romanalais != null && value != null) {
			romanWordToRomanCharMapping.put(romanalais, value);
		}
	}
	
	public String getValueOfRomanAlais(String romanalais)
	{
		return romanWordToRomanCharMapping.get(romanalais);
	}
	
	public float getValueOfMetal(String metalName)
	{
		return metalWordToMetalValueMapping.get(metalName);
	}
	
	public boolean isRomanNumberValid(String romanName)
	{
		return romanToNumericalMapping.containsKey(romanName);
	}
	public boolean isValidRomanAlaisWord(String name)
	{
		return romanWordToRomanCharMapping.containsKey(name);
	}
	public boolean isMetal(String name)
	{
		return metalWordToMetalValueMapping.containsKey(name);
	}
	public int getNumbericalValue(String romanName)
	{
		Integer value =  romanToNumericalMapping.get(romanName);
		if(value == null)
		{
			throw new NumberFormatException("ROMAN number is not valid");
		}
		return value;
	}

}
