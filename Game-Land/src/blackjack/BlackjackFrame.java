package blackjack;

import java.awt.*;
import javax.swing.*;

import gui.userInfo.UserInfo;

public class BlackjackFrame extends JFrame{
		
	private static final int max_cards = 11;
	
	private Dealer dealer;
	private HumanPlayer hand_player;
	private ComputerPlayer hand_dealer;
	private String n;
	private UserInfo user;
	private BlackjackStarter starter;
	
	private boolean myturn = true;
	private int p_cardcount;
	private int d_cardcount;
	private Card[] player_cards;
	private JPanel p_cardrank;
	private JPanel p_cardsuit;
	private JPanel d_cardrank;
	private JPanel d_cardsuit;
	private JPanel dealer_panel;
	private JPanel player_panel;
	private Card[] dealer_cards;
	
	private BlackjackHitButton hitButton;
	private BlackjackStandButton standButton;
	
	private JLabel[] p_cardranklabel = new JLabel[max_cards];
	private JLabel[] p_cardsuitlabel = new JLabel[max_cards];
	private JLabel[] d_cardranklabel = new JLabel[max_cards];
	private JLabel[] d_cardsuitlabel = new JLabel[max_cards];
	
	
	public BlackjackFrame(UserInfo u,BlackjackStarter b) {
		user = u;
		starter = b;
		hand_player = new HumanPlayer(max_cards,user.getUserName());
		hand_dealer = new ComputerPlayer(max_cards);
		dealer = new Dealer();
	}
	
	public void manageBlackjack() {
		
		for(int i=0;i<max_cards;i++) {
			p_cardranklabel[i] = new JLabel("");
			p_cardsuitlabel[i] = new JLabel("");
			d_cardranklabel[i] = new JLabel("");
			d_cardsuitlabel[i] = new JLabel("");
		}
		
		
		Container cp = new Container(); 
		cp = getContentPane();
		cp.setLayout(new GridLayout(2,1));
		JPanel d_panel = new JPanel();
		dealer_panel = d_panel;
		d_panel.setLayout(new GridLayout(5,1));
		JPanel p_panel = new JPanel();
		player_panel = p_panel;
		p_panel.setLayout(new GridLayout(5,1));
		
		dealer.dealOneTo(hand_player);
		dealer.dealOneTo(hand_dealer);
		dealer.dealOneTo(hand_player);
		dealer.dealOneTo(hand_dealer);
		
				
		// dealer
		JPanel d_name = new JPanel(new FlowLayout());
		JLabel d_x = new JLabel();
		d_x.setText("Dealer");
		d_name.add(d_x);
		d_panel.add(d_name);
		
		JPanel d_empty = new JPanel(new FlowLayout());
		JLabel d_empty1 = new JLabel();
		d_empty1.setText("");
		d_empty.add(d_empty1);
		d_panel.add(d_empty);
		
		int dealer_cardcount = hand_dealer.countCard();;
		Card[] dealer_cards = hand_dealer.showCards();;
		
		d_cardsuit = new JPanel(new FlowLayout());
		d_cardrank = new JPanel(new FlowLayout());
		d_cardsuitlabel[0].setText("?");
		d_cardranklabel[0].setText("?");
		d_cardsuit.add(d_cardsuitlabel[0]);
		d_cardrank.add(d_cardranklabel[0]);
		this.addCardSuit(d_cardsuit, dealer_cards[dealer_cardcount - 1],'d');
		this.addCardRank(d_cardrank, dealer_cards[dealer_cardcount - 1],'d');
		d_panel.add(d_cardsuit);
		d_panel.add(d_cardrank);
		
		
		
		JPanel x3 = new JPanel(new FlowLayout());
		JLabel x4 = new JLabel("===============================");
		x3.add(x4);
		d_panel.add(x3);
		
		// player
		JPanel x1 = new JPanel(new FlowLayout());
		JLabel x2 = new JLabel("===============================");
		x1.add(x2);
		p_panel.add(x1);
		
		Card[]	player_cards = hand_player.showCards();
		int player_cardcount = hand_player.countCard();
		
		
		p_cardrank = new JPanel();
		p_cardsuit = new JPanel();
		p_cardrank.setLayout(new GridLayout(1,11));
		p_cardsuit.setLayout(new GridLayout(1,11))/*FlowLayout(FlowLayout.CENTER)*/;
		p_cardcount = hand_player.countCard();
		
		p_cardranklabel[0].setText(showCardRank(player_cards[0]));
		p_cardranklabel[0].setMaximumSize(new Dimension(Integer.MAX_VALUE, p_cardranklabel[0].getMinimumSize().height));
		p_cardrank.add(p_cardranklabel[0]);
		p_cardsuitlabel[0].setText(player_cards[0].suit());
		p_cardsuitlabel[0].setMaximumSize(new Dimension(Integer.MAX_VALUE, p_cardsuitlabel[0].getMinimumSize().height));
		p_cardsuit.add(p_cardsuitlabel[0]);
		this.addCardSuit(p_cardsuit, player_cards[1],'p');
		this.addCardRank(p_cardrank, player_cards[1],'p');
		p_panel.add(p_cardrank, "North");
		p_panel.add(p_cardsuit, "Center");
		
		JPanel p_buttons = new JPanel(new FlowLayout());
		hitButton = new BlackjackHitButton(this, hand_player);
		standButton = new BlackjackStandButton(this, hand_dealer);
		p_buttons.add(hitButton);
		p_buttons.add(standButton);
		p_panel.add(p_buttons);
		
		JPanel p_name = new JPanel(new FlowLayout());
		JLabel p_x = new JLabel();
		p_x.setText(user.getUserName());
		p_name.add(p_x);
		p_panel.add(p_name, "South");
		
		cp.add(d_panel);
		cp.add(p_panel);
		
		
		setTitle("BlackJack");
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        if(hand_player.totalScore() == 21) {
			hand_player.youWinBlackjack();
			this.deleteQuestionmark();
			new RematchFrame(this,"Victory");
		}
        else if(hand_player.totalScore() > 21) {
        	hand_player.youLose();
        	this.deleteQuestionmark();
        	new RematchFrame(this,"Victory");
        }
	}
	
	
	public String showCardRank(Card c) {
			if(c.rank() <= 10) 
				return Integer.toString(c.rank());
			else if(c.rank() == 11) 
				return "Jack";
			else if(c.rank() == 12) 
				return "Queen";
			else 
				return "King";
	}
	
	
	public void addCardSuit(JPanel p, Card c, char s) {
		if(s == 'p') {
			p_cardcount = hand_player.countCard();
			p_cardsuitlabel[p_cardcount-1].setText(c.suit());;
			p_cardsuitlabel[p_cardcount-1].setMaximumSize(new Dimension(Integer.MAX_VALUE, p_cardsuitlabel[p_cardcount].getMinimumSize().height));
			p.add(p_cardsuitlabel[p_cardcount-1]);
		}
		else {
			d_cardcount = hand_dealer.countCard();
			d_cardsuitlabel[d_cardcount-1].setText(c.suit());;
			d_cardsuitlabel[d_cardcount-1].setMaximumSize(new Dimension(Integer.MAX_VALUE, d_cardranklabel[d_cardcount].getMinimumSize().height));
			p.add(d_cardsuitlabel[d_cardcount-1]);
		}
		p.updateUI();
	}
	
	public void addCardRank(JPanel p, Card c, char s) {
		if(s == 'p') {
			p_cardcount = hand_player.countCard();
			p_cardranklabel[p_cardcount-1].setText(showCardRank(c));
			p_cardranklabel[p_cardcount-1].setMaximumSize(new Dimension(Integer.MAX_VALUE, p_cardranklabel[p_cardcount].getMinimumSize().height));
			p.add(p_cardranklabel[p_cardcount-1]);
		}
		else {
			d_cardcount = hand_dealer.countCard();
		 	d_cardranklabel[d_cardcount-1].setText(showCardRank(c));
		 	d_cardranklabel[d_cardcount-1].setMaximumSize(new Dimension(Integer.MAX_VALUE, d_cardranklabel[d_cardcount].getMinimumSize().height));
		 	p.add(d_cardranklabel[d_cardcount-1]);
		}
		p.updateUI();
	}
	
	
	
	public void dealFreshOneTo(CardPlayer p) {
		dealer.dealOneTo(p);
		if(myturn) {
			Card[] player_cards = p.showCards();
			int player_cardcount = p.countCard();
			this.addCardSuit(p_cardsuit, player_cards[player_cardcount - 1],'p');
			this.addCardRank(p_cardrank, player_cards[player_cardcount - 1],'p');
		}
		else {
			Card[] player_cards = p.showCards();
			int player_cardcount = p.countCard();
			this.addCardSuit(d_cardsuit, player_cards[player_cardcount - 1],'d');
			this.addCardRank(d_cardrank, player_cards[player_cardcount - 1],'d');
			this.check();
		}
		
		
	}
	
	public boolean nowTurn() {
		return myturn;
	}
	
	public void yourTurn() {
		myturn = false;
	}
	
	public void check() {
		this.deleteQuestionmark();
		if(hand_player.totalScore() == 21) {
			hand_player.youWinBlackjack();
			new RematchFrame(this,"Victory");
		}
		else {
			if(hand_player.totalScore() > 21) {
				if(hand_dealer.totalScore() > 21) {
					hand_player.youDraw();
					new RematchFrame(this,"Draw");
				}
				else {
				hand_player.youLose();
				new RematchFrame(this,"Lose");
				}
			}
			else {
				int dealer_cardcount = hand_dealer.countCard();
				Card[] dealer_cards = hand_dealer.showCards();
				while(hand_dealer.totalScore() <= 16) {
					dealer.dealOneTo(hand_dealer);
					this.addCardSuit(d_cardsuit, dealer_cards[dealer_cardcount - 1],'d');
					this.addCardRank(d_cardrank, dealer_cards[dealer_cardcount - 1],'d');
				}
				this.deleteQuestionmark();
				if(hand_dealer.totalScore() > 21) {
					hand_player.youWin();
					new RematchFrame(this,"Victory");
				}
				else if(hand_dealer.totalScore() == hand_player.totalScore()) {
					hand_player.youDraw();
					new RematchFrame(this,"Draw");
				}
				else if(hand_dealer.totalScore() < hand_player.totalScore()) {
					hand_player.youWin();
					new RematchFrame(this,"Victory");
				}
				else {
					hand_player.youLose();
					new RematchFrame(this,"Lose");
				}
			}
		}
	}
	
	public void deleteQuestionmark() {
		Card[] dealer_cards = hand_dealer.showCards();
		d_cardsuitlabel[0].setText(dealer_cards[0].suit());
		d_cardranklabel[0].setText(this.showCardRank(dealer_cards[0]));
		
	}
	
	public void resetBlackjack() {
		this.dispose();
		new BlackjackFrame(user,starter).manageBlackjack();
		
	}
	
	public void exitProcedure() {
		this.dispose();
		if(hand_player.chips() >= 0) {
			starter.returncoin(hand_player.chips(), this);
		}
	}

}
