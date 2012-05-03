public enum Card {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    
    static Card cardFromString(String cardString) {
        Card card = null;
        char firstChar = cardString.charAt(0);
        
        switch(firstChar){
            case '2':
                card = TWO;
                break;
            case '3':
                card = THREE;
                break;
            case '4':
                card = FOUR;
                break;
            case '5':
                card = FIVE;
                break;
            case '6':
                card = SIX;
                break;
            case '7':
                card = SEVEN;
                break;
            case '8':
                card = EIGHT;
                break;
            case '9':
                card = NINE;
                break;
            case 'T':
                card = TEN;
                break;
            case 'J':
                card = JACK;
                break;
            case 'Q':
                card = QUEEN;
                break;
            case 'K':
                card = KING;
                break;
            case 'A':
                card = ACE;
                break;
        }
        
        return card;
    }
}
