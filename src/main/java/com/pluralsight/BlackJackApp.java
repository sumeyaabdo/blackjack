package com.pluralsight;

import java.util.Scanner;

public class BlackJackApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask for player names
        System.out.print("Enter Player 1 name: ");
        String player1 = scanner.nextLine();

        System.out.print("Enter Player 2 name: ");
        String player2 = scanner.nextLine();

        // Create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // Create hands
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        // Deal two cards to each player
        hand1.deal(deck.deal());
        hand1.deal(deck.deal());

        hand2.deal(deck.deal());
        hand2.deal(deck.deal());

        // Display player hands and scores
        System.out.println("\n--- Blackjack Results ---");

        System.out.println(player1 + "'s Hand:");
        hand1.showCards();
        int score1 = hand1.getValue();
        System.out.println("Total: " + score1);

        System.out.println();

        System.out.println(player2 + "'s Hand:");
        hand2.showCards();
        int score2 = hand2.getValue();
        System.out.println("Total: " + score2);

        // Determine the winner
        System.out.println("\n--- Winner ---");

        if (score1 > 21 && score2 > 21) {
            System.out.println("Both players busted! No winner.");
        } else if (score1 > 21) {
            System.out.println(player2 + " wins!");
        } else if (score2 > 21) {
            System.out.println(player1 + " wins!");
        } else if (score1 > score2) {
            System.out.println(player1 + " wins!");
        } else if (score2 > score1) {
            System.out.println(player2 + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}

