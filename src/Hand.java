import java.util.HashMap;
import java.util.Map;

public class Hand {

	private final String cards;

	public Hand(String cards) {
		this.cards = cards;
	}

	public boolean isPoker() {
		Map<Character, Integer> pokerMap = countHand();

		return areThereTwoDifferentValues(pokerMap) && isTheSameValue4Times(pokerMap);
	}

	private boolean isTheSameValue4Times(Map<Character, Integer> pokerMap) {
		return (pokerMap.containsValue(4));
	}

	private boolean areThereTwoDifferentValues(Map<Character, Integer> pokerMap) {
		return pokerMap.size() == 2;
	}

	public boolean isFull() {
		Map<Character, Integer> pokerMap = countHand();

		return (pokerMap.containsValue(3)) && (pokerMap.containsValue(2));
	}

	public boolean isThree() {
		Map<Character, Integer> pokerMap = countHand();

		return (pokerMap.size() == 3 && pokerMap.containsValue(3));
	}

	private Map<Character, Integer> countHand() {
		String[] individualCards = cards.split(" ");
		Map<Character, Integer> pokerMap = new HashMap<Character, Integer>();
		for (String card : individualCards) {
			Integer cardsQuantity = pokerMap.get(card.charAt(0));
			if (cardsQuantity == null) {
				pokerMap.put(card.charAt(0), new Integer(1));
			} else {
				pokerMap.put(card.charAt(0), new Integer(++cardsQuantity));
			}
		}
		return pokerMap;
	}

	public boolean isPair() {
		Map<Character, Integer> pokerMap = countHand();

		return (pokerMap.size() == 4);
	}

	public boolean isTwoPair() {
		Map<Character, Integer> pokerMap = countHand();

		return (pokerMap.size() == 3 && pokerMap.containsValue(2));
	}

	public boolean isStraight() {
		Map<Character, Integer> pokerMap = countHand();
		return pokerMap.size() == 5;
	}

}
