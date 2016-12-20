package com.manifestcorp.IQityDiceGameAssessment;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceValidity {
			
	public String checkInvalidDiceRoll(String diceInput) throws InvalidDiceInputException {
		String regexPattern = "[1-6],[1-6],[1-6],[1-6],[1-6]";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(diceInput);
		if (!matcher.find()) {
			throw new InvalidDiceInputException("Invalid input with: " + diceInput);
		}
		return diceInput;
	}

}
