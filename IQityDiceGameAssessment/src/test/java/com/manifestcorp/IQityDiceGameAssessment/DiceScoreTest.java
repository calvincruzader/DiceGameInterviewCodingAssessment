package com.manifestcorp.IQityDiceGameAssessment;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;

public class DiceScoreTest {
	
	private static final String INVALID_DICE_INPUT = "[1,2,3,5,7]";
	private static final String SET_OF_3_1S = "[1,2,3,1,1]";
	private static final String FOUR_1S = "[1,1,2,1,1]";
	private static final String FIVE_1S = "[1,1,1,1,1]";
	private static final String THREE_2S = "[3,2,2,2,3]";
	private static final String FOUR_2S = "[5,2,2,2,2]";
	private static final String FIVE_2S = "[2,2,2,2,2]";
	private static final String THREE_2S_TWO_1S = "[1,2,1,2,2]";
	private static final String THREE_3S = "[2,3,5,3,3]";
	private static final String FOUR_3S = "[3,3,3,3,2]";
	private static final String FIVE_3S = "[3,3,3,3,3]";
	private static final String THREE_4S = "[4,4,4,3,3]";
	private static final String FOUR_4S = "[4,4,3,4,4]";
	private static final String FIVE_4S = "[4,4,4,4,4]";
	private static final String THREE_5S = "[5,3,5,3,5]";
	private static final String FOUR_5S = "[5,5,5,5,3]";
	private static final String FIVE_5S = "[5,5,5,5,5]";
	private static final String THREE_6S = "[6,5,6,5,6]";
	private static final String FOUR_6S = "[6,6,6,6,3]";
	private static final String FIVE_6S = "[6,6,6,6,6]";
	private static final String THREE_1S_TWO_4S = "[1,4,1,4,1]";
	private DiceScore diceScore;
	
	@Before
	public void before() {
		diceScore = new DiceScore();
	}
	
	@After
	public void after() {
		diceScore = null;
	}
	
	@Test(expected=InvalidDiceInputException.class)
	public void testInvalidInput() throws Exception {
		diceScore.computeScore(INVALID_DICE_INPUT);
	}
	
	@Test
	public void testSetOf3Matching1s() throws Exception {
		assertEquals("Checks if 3 ones gives 1000 points", 1000, diceScore.computeScore(SET_OF_3_1S));
	}
	
	@Test
	public void testSetOf4Or5Matching1s() throws Exception {
		assertEquals("Checks if 4 ones gives 1100 points", 1100, diceScore.computeScore(FOUR_1S));
		assertEquals("Checks if 5 ones gives 1200 points", 1200, diceScore.computeScore(FIVE_1S));
	}
	
	@Test 
	public void testSetOf3OrMoreMatching2s() throws Exception {
		assertEquals("Checks if 3 twos gives 200 points", 200, diceScore.computeScore(THREE_2S));
		assertEquals("Checks if 4 twos gives 200 points", 200, diceScore.computeScore(FOUR_2S));
		assertEquals("Checks if 5 twos gives 200 points", 200, diceScore.computeScore(FIVE_2S));
	}

	@Test
	public void testSetOf3Matching2sWith1s() throws Exception {
		assertEquals("Checks if 3 twos and 2 ones gives 400 points", 400, diceScore.computeScore(THREE_2S_TWO_1S));		
	}
	
	@Test 
	public void testSetOf3OrMoreMatching3s() throws Exception {
		assertEquals("Checks if 3 threes gives 300 points", 300, diceScore.computeScore(THREE_3S));
		assertEquals("Checks if 4 threes gives 300 points", 300, diceScore.computeScore(FOUR_3S));
		assertEquals("Checks if 5 threes gives 300 points", 300, diceScore.computeScore(FIVE_3S));
	}
	
	@Test 
	public void testSetOf3OrMoreMatching4s() throws Exception {
		assertEquals("Checks if 3 fours gives 400 points", 400, diceScore.computeScore(THREE_4S));
		assertEquals("Checks if 4 fours gives 440 points", 440, diceScore.computeScore(FOUR_4S));
		assertEquals("Checks if 4 fours gives 480 points", 480, diceScore.computeScore(FIVE_4S));	
	}
	
	@Test 
	public void testSetOf3OrMoreMatching5s() throws Exception {
		assertEquals("Checks if 3 fives gives 500 points", 500, diceScore.computeScore(THREE_5S));
		assertEquals("Checks if 4 fives gives 500 points", 500, diceScore.computeScore(FOUR_5S));
		assertEquals("Checks if 5 fives gives 500 points", 500, diceScore.computeScore(FIVE_5S));
	}
	
	@Test 
	public void testSetOf3OrMoreMatching6s() throws Exception {
		assertEquals("Checks if 3 sixes gives 600 points", 600, diceScore.computeScore(THREE_6S));
		assertEquals("Checks if 4 sixes gives 600 points", 600, diceScore.computeScore(FOUR_6S));
		assertEquals("Checks if 5 sixes gives 600 points", 600, diceScore.computeScore(FIVE_6S));
	}
	
	@Test
	public void test3Ones2Fours() throws Exception {
		assertEquals("Checks if 3 ones and 2 fours gives 1080 points", 1080, diceScore.computeScore(THREE_1S_TWO_4S));
	}
	
}
