package com.interview.intergallectic.controller;

import java.util.List;

import com.interview.intergallectic.InputReceiver.EventHandler;
import com.interview.intergallectic.InputReceiver.InputReceiver;
import com.interview.intergallestic.dataStore.DataStore;
import com.interview.intergallestic.parser.CreditsInputData;
import com.interview.intergallestic.parser.CreditsInputParser;
import com.interview.intergallestic.parser.QueryInputData;
import com.interview.intergallestic.parser.QueryInputParser;
import com.interview.intergallestic.parser.RomanInputData;
import com.interview.intergallestic.parser.RomanInputParser;

public class InterGallesticController {

	private static final InterGallesticController interGallesticController = new InterGallesticController();
	private RomanInputParser romanInputParser;
	private CreditsInputParser creditsInputParser;
	private QueryInputParser queryInputParser;
	private DataStore dataStore;
	private InputReceiver inputReceiver;

	private InterGallesticController() {
		romanInputParser = new RomanInputParser();
		creditsInputParser = new CreditsInputParser();
		queryInputParser = new QueryInputParser();
		dataStore = new DataStore();
		inputReceiver = new InputReceiver();
	}

	public static InterGallesticController getInstance() {
		return interGallesticController;
	}

	public void init() {
		dataStore.init();
		inputReceiver.addInputEventListener(new InputHandler());
		inputReceiver.init();
	}

	class InputHandler implements EventHandler {

		public void inputReceived(String lineInput) {
			System.out.println("Input received ");
			if (lineInput.lastIndexOf("?") != -1) {
				QueryInputData query = null;
				try{
				 query = queryInputParser.parse(lineInput);
				}
				catch(IllegalArgumentException ex)
				{
					System.out.println("NO IDEA");
					return;
				}
				List<String> elements = query.getElements();
				String metalName = null;
				StringBuilder romanBuilder = new StringBuilder();
				for (String element : elements) {
					if (dataStore.isMetal(element)) {
						metalName = element;
					} else if (dataStore.isValidRomanAlaisWord(element)) {
						String value = dataStore.getValueOfRomanAlais(element);
						romanBuilder.append(value);
					}
				}
				String romanNumeral = romanBuilder.toString();
				if (metalName != null && !romanNumeral.equals("")) {
					int romanValue = dataStore.getNumbericalValue(romanNumeral);
					float metalValue = dataStore.getValueOfMetal(metalName);
					System.out.println("The value is " + (romanValue * metalValue));
				}
				else if(!romanNumeral.equals("")) {
					System.out.println("The value is " + dataStore.getNumbericalValue(romanNumeral));
				}
				else {
					System.out.println("No idea ");
				}

			} else if (lineInput.lastIndexOf("Credits") != -1) {
				System.out.println("Credits parser");
				CreditsInputData creditInput = creditsInputParser
						.parse(lineInput);
				List<String> elements = creditInput.getCompleteList();
				String metalName = creditInput.getMetal();
				System.out.println("Metal name"+metalName);
				StringBuilder romanBuilder = new StringBuilder();
				boolean isInvalidEntry = false;
				for (String element : elements) {
					System.out.println(element);
					if (!metalName.equals(element)) {
						String value = dataStore.getValueOfRomanAlais(element);
						if(value != null){
							romanBuilder.append(value);
						}
						else {
							isInvalidEntry = true;
							break;
						}
					} 
				}
				if(!isInvalidEntry && dataStore.isRomanNumberValid(romanBuilder.toString())){
//					/System.out.println("metal name added"+creditInput.getCredits()/dataStore.getNumbericalValue(romanBuilder.toString()));
					dataStore.addMetalWord(metalName, creditInput.getCredits()/dataStore.getNumbericalValue(romanBuilder.toString()));
				}
				
			} else {
				RomanInputData romanInput = romanInputParser.parse(lineInput);
				if (dataStore.isRomanNumberValid(romanInput.getRomanWord())) {
					System.out.println(romanInput.getInputWord());
					System.out.println(romanInput.getRomanWord());
					dataStore.addRomanWord(romanInput.getInputWord(), romanInput.getRomanWord());
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InterGallesticController.getInstance().init();
		//RomanNumeral numeral = new RomanNumeral();
		//System.out.println("InterGallesticController.main()"+numeral.getRomanString(1));
	}

}
