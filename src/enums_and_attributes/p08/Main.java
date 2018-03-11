package enums_and_attributes.p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 24.11.2017 г..
 */
public class Main {
    private static final String ENUM_PATH_PACKAGE = "p06.";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deck deck = new Deck();
        deck.cardGenerator();

        String p1Name = reader.readLine();
        String p2Name = reader.readLine();
        Player p1 = new Player(p1Name);
        Player p2 = new Player(p2Name);

        fillPlayersHand(reader, deck, p1, p2);
        andTheWinnerIS(p1, p2);
    }

    private static void andTheWinnerIS(Player p1, Player p2) {
        Card p1HighestCard = p1.highestPoweredCard();
        Card p2HighestCard = p2.highestPoweredCard();
        if ((p1HighestCard.getRank().getPower() + p1HighestCard.getSuit().getPower()) > (p2HighestCard.getRank().getPower() + p2HighestCard.getSuit().getPower())) {
            System.out.println(String.format("%s wins with %s of %s.", p1.getName(), p1HighestCard.getRank(), p1HighestCard.getSuit()));
        } else if ((p1HighestCard.getRank().getPower() + p1HighestCard.getSuit().getPower()) < (p2HighestCard.getRank().getPower() + p2HighestCard.getSuit().getPower())) {
            System.out.println(String.format("%s wins with %s of %s.", p2.getName(), p2HighestCard.getRank(), p2HighestCard.getSuit()));
        }
    }

    private static void fillPlayersHand(BufferedReader reader, Deck deck, Player p1, Player p2) throws IOException {
        while (true) {
            if (p1.isReady() && p2.isReady()){
                break;
            }
            String[] tokens = reader.readLine().split("\\s+");
            Card card = null;
            try {
                card = new Card(Suit.valueOf(tokens[2]), Rank.valueOf(tokens[0]));
                if (deck.containCard(card) < 0) {
                    System.out.println("Card is not in the deck.");
                }
            } catch (IllegalArgumentException eae) {
                System.out.println("No such card exists.");
            }
            if (card != null && deck.containCard(card) >= 0) {
                if (!p1.isReady()) {
                    p1.addCardInHand(card);
                    deck.removeFromDeck(card);
                } else if (!p2.isReady()) {
                    p2.addCardInHand(card);
                    deck.removeFromDeck(card);
                }
            }
        }
    }
}