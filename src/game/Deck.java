package game;

import java.util.ArrayList;

import java.util.Collections;

import modelo.Card;

import utils.CardFactory;
import utils.IncorrectCardException;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public Deck() {
        try {
            cards.add(CardFactory.newCard("attack", "MicroDancer", 2, -30));
            cards.add(CardFactory.newCard("attack", "Firyus", 2, -50));
            cards.add(CardFactory.newCard("attack", "Daga de fuego", 2, 30));
            cards.add(CardFactory.newCard("attack", "Daga de fuego", 2, 30));
            cards.add(CardFactory.newCard("attack", "Daga de fuego", 2, 30));
            cards.add(CardFactory.newCard("attack", "Daga de fuego", 2, 30));
            cards.add(CardFactory.newCard("util", "Curacion menor", 2, 30));
            cards.add(CardFactory.newCard("util", "Curacion menor", 2, 30));
            cards.add(CardFactory.newCard("util", "Curacion menor", 2, 30));
            cards.add(CardFactory.newCard("util", "Curacion mayor", 4, 80));
            cards.add(CardFactory.newCard("attack", "Sable Igneo", 6, 80));
            cards.add(CardFactory.newCard("attack", "Sable Igneo", 6, 80));
            cards.add(CardFactory.newCard("attack", "Sable Igneo", 6, 80));
            cards.add(CardFactory.newCard("attack", "Volcano", 10, 150));
            cards.add(CardFactory.newCard("util", "Elixir Sagrado", 11, 200));
        } catch (IncorrectCardException e) {
        }
        Collections.shuffle(cards);
    }

    /**Draw and remove a card from the deck. 
     * @return - returns the Card drawed.
     */
    public Card draw(){
        Card aux = cards.remove(0);
        return aux;
    }

    /**Returns the size of the deck.
     * @return
     */
    public int getSize() {
        return cards.size();
    }
}
