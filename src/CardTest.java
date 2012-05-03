import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class CardTest {
    

    @Test
    public void testCardFromString() {
        
        String[] cardsString = {"2", "3", "4", "J", "T", "A"};
        Card[] cardsExpected = {Card.TWO, Card.THREE, Card.FOUR,Card.JACK, Card.TEN, Card.ACE};
        List<Card> cardsList = new ArrayList<Card>();
        for(String cardString : cardsString){
            cardsList.add(Card.cardFromString(cardString));
        }           
        assertArrayEquals(cardsExpected, cardsList.toArray());
    }
   
}
