import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Hand {

	private final String cards;
        private boolean[] cardsOrdered;
	private Map<Card, Integer> pokerMap;
        private boolean sameDeck;

	public Hand(String cards) {
		this.cards = cards;
                pokerMap = new HashMap<Card,Integer>();
                cardsOrdered = new boolean[13];
                sameDeck = true;
                countHand();
	}

	public boolean isPoker() {
		return areThereTwoDifferentValues(pokerMap) && isTheSameValue4Times(pokerMap);
	}

    private boolean hasThreeDifferentCards() {
        return pokerMap.size() == 3;
    }

	private boolean isTheSameValue4Times(Map<Card, Integer> pokerMap) {
		return (pokerMap.containsValue(4));
	}

	private boolean areThereTwoDifferentValues(Map<Card, Integer> pokerMap) {
		return pokerMap.size() == 2;
	}

	public boolean isFull() {
		return (pokerMap.containsValue(3)) && (pokerMap.containsValue(2));
	}

	public boolean isThree() {
		return (hasThreeDifferentCards() && pokerMap.containsValue(3));
	}

	private void countHand() {
		String[] individualCards = cards.split(" ");
                
                char deck = individualCards[0].charAt(1);
                
		for (String cardString : individualCards) {
                    
                    sameDeck = sameDeck && (deck == cardString.charAt(1));
                    
                    Card card = Card.cardFromString(cardString); 
                    Integer cardsQuantity = pokerMap.get(card);
                    cardsOrdered[card.ordinal()] = true;
                    if (cardsQuantity == null) {
                            pokerMap.put(card, new Integer(1));
                    } else {
                            pokerMap.put(card, new Integer(++cardsQuantity));
                    }
		}
	}

	public boolean isPair() {
		return (pokerMap.size() == 4);
	}

	public boolean isTwoPair() {
		return (hasThreeDifferentCards() && pokerMap.containsValue(2));
	}

	public boolean isStraight() {
            int count = 0;
            int index = 0;
            
            while (index < cardsOrdered.length && count < 5) {
                if (cardsOrdered[index]) {
                    count++;
                    boolean aEsUno = index == 3 && cardsOrdered[Card.ACE.ordinal()];
                    if(count == 4 && aEsUno) {
                        count++;
                    }
                }
                else {
                    count = 0;
                }
                index++;
            }
	
            
            return hasFiveDifferentCards() && count==5;
	}
        
        public boolean isFlush() {
            
		return sameDeck && hasFiveDifferentCards();
	}
        
        private boolean hasFiveDifferentCards() {
            return pokerMap.size() == 5;
        }
        
        public boolean isStraightFlush(){
            return isStraight() && isFlush();
        }
        
        public boolean validHand(String cards){
            Pattern pattern = Pattern.compile("([23456789TJQKA][CHDS]){4}[23456789TJQKA][CHDS]");
            return pattern.matcher(cards).matches();
        }
        
}
