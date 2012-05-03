import static org.junit.Assert.*;

import org.junit.Test;



public class HandTest {
	
	@Test
	public void isPokerShouldBeTrueForAPokerHand(){
		Hand hand = new Hand("2H 2D 2C 2S JC");
		Hand unorderedHand = new Hand("2H 2D 2C JS 2S");
		
		assertTrue(hand.isPoker());
		assertTrue(unorderedHand.isPoker());
	}
	
	@Test
	public void isPokerShouldBeFalseForANonPokerHand(){
		Hand hand = new Hand("2H 3D 2C 2S JC");
		assertFalse(hand.isPoker());
	}
	@Test
	public void isFullShouldBeTrueForAFullHand(){
		Hand hand=new Hand("2H 2D 4D 4H 4C");
		assertTrue(hand.isFull());
	}
	@Test 
	public void isFullShouldBeFalseForANonFullHand(){
		Hand hand=new Hand("2H 2D 4D 4H 6C");
		assertFalse(hand.isFull());
	}
	
	@Test 
	public void isThreeShouldBeTrueForAThreeHand(){
		Hand hand=new Hand("2H 2S 2D 4H 6C");
		assertTrue(hand.isThree());
	}
	
	@Test
	public void isThreeShouldBeFalseForAFullHand(){
		Hand hand=new Hand("2H 2D 2S 4H 4C");
		assertFalse(hand.isThree());
	}
	
	@Test
	public void isPairShouldBeTrueForAPairHand(){
		Hand hand=new Hand("2H 2D 5S 6H 4C");
		assertTrue(hand.isPair());
	}
	
	@Test
	public void isTwoPairShouldBeTrueForATwoPairHand(){
		Hand hand=new Hand("2H 2D 4S 6H 4C");
		assertTrue(hand.isTwoPair());
	}
	
	@Test
	public void isTwoPairShouldBeFalseForPokerHand(){
		Hand hand=new Hand("2H 2D 2S 2C 4C");
		assertFalse(hand.isTwoPair());
	}
	
	@Test
	public void isTwoPairShouldBeFalseForThreeHand(){
		Hand hand=new Hand("2H 2D 2S 3C 4C");
		assertFalse(hand.isTwoPair());
	}
	
	@Test
	public void isStraightShouldBeTrueForStraightHand(){
		Hand hand=new Hand("2H 3D 4S 5C 6C");
		assertTrue(hand.isStraight());
                hand=new Hand("7H 6D 5S 4C 3C");
		assertTrue(hand.isStraight());
                hand=new Hand("AH 2D 5S 4C 3C");
		assertTrue(hand.isStraight());
                hand=new Hand("AH QD JS KC TC");
		assertTrue(hand.isStraight());
	}
	
	@Test
	public void isStraightShouldBeFalseForHighCardHand(){
		Hand hand=new Hand("7H 6D 2S 3C 4C");
		assertFalse(hand.isStraight());

	}
        
        @Test 
        public void isFlushHandShouldbeTrueForFlushHand() {
            Hand hand=new Hand("7H 6H 2H 3H 4H");
            assertTrue(hand.isFlush());
        }
        
        @Test 
        public void isFlushHandShouldbeFalseForNonFlushHand() {
            Hand hand=new Hand("7H 6H 2H 3H 4C");
            assertFalse(hand.isFlush());
        }
        @Test 
        public void isStraightFlushHandShouldbeTrueForStraightFlushHand() {
            Hand hand=new Hand("AH 2H 3H 4H 5H");
            assertTrue(hand.isStraightFlush());
        }
        
        @Test 
        public void isStraightFlushHandShouldbeFalseForNonStraightFlushHand() {
            Hand hand=new Hand("KH TH 9H JH QC");
            assertFalse(hand.isStraightFlush());
        }
        
        
}
