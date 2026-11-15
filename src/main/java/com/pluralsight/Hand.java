package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // Add a card to the hand
    public void deal(Card card) {
        cards.add(card);
    }

    // Return number of cards
    public int getSize() {
        return cards.size();
    }

    // Calculate total points
    public int getValue() {
        int value = 0;

        for (Card card : cards) {
            card.flip();
            value += card.getPointValue();
            card.flip();
        }

        return value;
    }

    // Display the player's cards
    public void showCards() {
        for (Card card : cards) {
            boolean wasFaceUp = card.isFaceUp();

            if (!wasFaceUp) {
                card.flip();
            }

            System.out.println(card.getValue() + " of " + card.getSuit());

            if (!wasFaceUp) {
                card.flip();
            }
        }
    }
}

