package blackjack;

public class Dealer{
	
	private CardDeck deck;
	
	public Dealer() {
		deck = new CardDeck();
	}

	public void dealOneTo(CardPlayer p) {
		p.receiveCard(deck.newCard());
	}

}
