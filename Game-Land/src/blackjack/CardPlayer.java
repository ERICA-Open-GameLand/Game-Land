package blackjack;

public class CardPlayer{

	private Card[] hand; // 갖고 있는 카드
    private int card_count; // 갖고 있는 카드의 장 수

    /** Constructor CardPlayer - max_cards 카드를 수용가능한 Card 배열 객체를 만들어 CardPlayer 생성
     * @param max_cards - 들고 있을 수 있는 카드의 최대 장수 */
    public CardPlayer(int max_cards) {
        hand = new Card[max_cards];
        card_count = 0;
    }

    /** receiveCard - 카드를 한장 받는다. 한도(배열 hand의 크기)를 초과하면 받을 수 없다.
     * @param c - 카드
     * @return 성공적으로 받았으면 true, 그렇지 않으면 false */
    public boolean receiveCard(Card c) {
        if (card_count < hand.length) {
            hand[card_count] = c;
            card_count += 1;
            return true;
        }
        else
            return false;
    }

    /** showCards - 들고 있는 카드를 내준다.
     * @return 들고 있는 카드 전체  */
    public Card[] showCards() {
        Card[] card = new Card[card_count];
        for (int i = 0; i < card_count; i++)
            card[i] = hand[i];
        return card;
    }
    
    public int totalScore() {
    	int sum=0,ace=0;
    	for(int i=0;i<card_count;i++) {
    		if(hand[i].rank() > 10) {
    			sum+=10;
    		}
    		else {
    			sum+=hand[i].rank();
    		}
    		if(hand[i].rank() == 1) {ace++;}
    	}
    	while(sum - 1 <= 10 && ace > 0) {
    		sum = (sum - 1) + 11;
    	}
    	return sum;
    		
    }

    public void reset() {
    	for(int i=0;i<card_count;i++) {
    		hand[i] = null;
    	}
    	card_count = 0;
    }
    
    public int countCard() {
    	return card_count;
    }
}