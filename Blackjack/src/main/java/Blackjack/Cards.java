package Blackjack;

public class Cards {

    FaceCards faceCards;
    Suit suit;

    public Cards(FaceCards faceCards, Suit suit) {
        this.faceCards = faceCards;
        this.suit = suit;
    }

    public FaceCards getFaceCards() {
        return faceCards;
    }

    public Suit getSuit() {
        return suit;
    }
}

enum FaceCards {

    TWO("2",2),
    THREE("3",3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6",6),
    SEVEN("7",7),
    EIGHT("8",8),
    NINE("9",9),
    TEN("10",10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    ACE("Ace", 11);

    String faceCards;
    int value;

    FaceCards(String faceCards, int value) {
        this.faceCards = faceCards;
        this.value = value;
    }

    public String getFaceCards() {
        return faceCards;
    }

    public int getValue() {
        return value;
    }
}

enum Suit {

    CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
