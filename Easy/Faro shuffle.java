import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String deckStr = in.nextLine();
        in.close();

        // Découpage de la String d'entrée
        String[] tokens = deckStr.split(" ");
        int deckSize = tokens.length;
        // Création et population du paquet de cartes en fonction des entrées
        Card[] deck = new Card[deckSize];
        for (int i = 0; i < deckSize; i++) {
            deck[i] = new Card(tokens[i]);
        }

        // On applique les n Faro shuffles
        for (int i = 0; i < n; i++) {
            deck = Solution.faroSplit(deck);
        }

        // Ecriture de la réponse
        String answer = "";
        for (int i = 0; i < deckSize; i++) {
            answer += deck[i].name;
            if (i < deckSize - 1)
                answer += " ";
        }
        System.out.println(answer);
    }

    // Méthode effectuant le Faro shuffle d'un paquet de cartes
    public static Card[] faroSplit(Card[] deck) {
        int deckSize = deck.length;
        // On crée les deux nouveaux paquets en découpant en deux
        Card[] subDeck1 = new Card[deckSize / 2 + deckSize % 2];
        Card[] subDeck2 = new Card[deckSize / 2];

        // On les peuple
        for (int i = 0; i < subDeck1.length; i++) {
            subDeck1[i] = deck[i];
        }

        for (int i = 0; i < subDeck2.length; i++) {
            subDeck2[i] = deck[subDeck1.length + i];
        }

        // On crée le nouveau paquet qui recevra le mélange
        Card[] newDeck = new Card[deckSize];
        // Indice de la position dans le nouveau paquet
        int c = 0;
        for (int i = 0; i < deckSize / 2; i++) {
            // On insère la ième carte du premier sous paquet puis du second
            newDeck[c++] = subDeck1[i];
            newDeck[c++] = subDeck2[i];
        }
        // Si le nombre de cartes était impair, il reste une carte à insérer :
        // la dernière du premier sous-paquet
        if (deckSize % 2 == 1) {
            newDeck[deckSize - 1] = subDeck1[subDeck1.length - 1];
        }
        // On renvoie le nouveau paquet
        return newDeck;
    }
}

// Classe représentant une carte
class Card {
    String name;

    // Constructeur
    Card(String name) {
        this.name = name;
    }
}