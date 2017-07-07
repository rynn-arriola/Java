public class CardsDeck {
    public static void main(String[] args) {
        int[] deck = new int[52];
        boolean [][][] cards;
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        initializeArray(deck);         //Creates array values
        cards = cardShuffle(deck);         //shuffles array values
        printHands(suits, ranks, cards);
    }

    public static void initializeArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = i;
    }

    public static boolean [][][] cardShuffle(int[] array) {
        boolean [][][] cards;
        for (int i = 0; i < array.length; i++) {
            //Generate an index randomly
            int index = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        cards = createCards(array);
        return cards;
    }

    public static boolean[][][] createCards(int[] deck) {
        boolean[][][] cards = new boolean[4][4][13];
        int suit;
        int rank;

        for (int player = 0; player < 4; player++) {
            for (int pSuit = 0; pSuit < 4; pSuit++) {
                for (int pRank = 0; pRank < 13; pRank++) {
                    if (player == 0) {
                        suit = deck[pRank] / 13;
                        rank = deck[pRank] % 13;
                    } else if (player == 1) {
                        suit = deck[pRank + 13] / 13;
                        rank = deck[pRank + 13] % 13;
                    } else if (player == 2) {
                        suit = deck[pRank + 26] / 13;
                        rank = deck[pRank + 26] % 13;
                    } else {
                        suit = deck[pRank + 39] / 13;
                        rank = deck[pRank + 39] % 13;
                    }
                    cards[player][suit][rank] = true;
                }
            }
            System.out.println("\n");
        }
        return cards;
    }

    public static void printHands (String [] suit, String [] rank, boolean [][][] cards){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 13; k++) {
                    if(cards[i][j][k])
                        System.out.println("Player " + (i+1) + " Card: " + rank[k] + " of " + suit[j] );
                }
            }
            System.out.println();
        }
    }
}