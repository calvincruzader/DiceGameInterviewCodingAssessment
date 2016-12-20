package com.manifestcorp.IQityDiceGameAssessment;

public class DiceScore {
	
	DiceValidity diceValidity;
	
	public DiceScore() {
		diceValidity = new DiceValidity();
	}
		
	public int computeScore(String diceRoll) throws Exception {
		diceValidity.checkInvalidDiceRoll(diceRoll);
		int score = 0;
		int[] diceCountByFaceValue = numberOfEachDie(diceRoll);
		for (int dieValue = 1; dieValue < diceCountByFaceValue.length; dieValue++) {
			score += scoreTable(diceCountByFaceValue[dieValue], dieValue);	
		}
		return score;
	}

	private int scoreTable(int numDice, int dieValue) {
		int score = 0;
		switch(dieValue) {
		case 1: 
			if(numDice >= 3) {
				score += 1000;
				numDice -= 3; 
			}
			while (numDice > 0) {
				score += 100;
				numDice--;
			}
			break;
		case 2:
			if(numDice >= 3) {
				score += 200;
			}
			break;
		case 3:
			if (numDice >= 3){ 
				score += 300;
			}
			break;
		case 4:
			if (numDice >= 3) {
				score += 400;
				numDice -=3;
			}
			while (numDice > 0) {
				score += 40;
				numDice--;
			}
			break;
		case 5:
			if(numDice >= 3) {
				score += 500;
			}
			break;
		
		case 6:
			if(numDice >= 3) {
				score += 600;
			}
			break;
		}
		return score;
	}

	private int[] numberOfEachDie(String input) { 
		int[] result = new int[7];
		for(int i = 0; i < input.length(); i++) {
			if(isDieValue(input.charAt(i))) {
				result[Character.getNumericValue(input.charAt(i))]++;
			}
		}
		return result;
	}

	private boolean isDieValue(char c) {
		if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6') {
			return true;
		} 
		return false;
	}
}
