import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String bankCards = in.nextLine();
        String playerCards = in.nextLine();
        in.close();

        // Calcul des scores des mains
        int bankScore = score(bankCards);
        int playerScore = score(playerCards);

        // Si la banque dépasse
        if (bankScore > 21) {
            // Si le joueur dépasse aussi, égalité
            if (playerScore > 21) {
                System.out.println("Draw");
                return;
            }
            // Si le joueur a un Blackjack (score de 21 en 2 cartes uniquement), ça se fête !
            if (playerScore == 21 && playerCards.split(" ").length == 2) {
                System.out.println("Blackjack!");
                return;
            }
            // Sinon victoire normale du joueur
            System.out.println("Player");
            return;
        }
        // SI le joueur a dépassé ou bien qu'il a moins que la banque, il a perdu
        if (playerScore > 21 || bankScore > playerScore) {
            System.out.println("Bank");
            return;
        }
        // En cas d'égalité
        if (playerScore == bankScore) {
            // Sur un score de 21
            if (playerScore == 21) {
                // Sur un Blackjack du joueur
                if (playerCards.split(" ").length == 2) {
                    // Avec Blackjack de la banque, égalité
                    if (bankCards.split(" ").length == 2) {
                        System.out.println("Draw");
                        return;
                    }
                    // Sinon Blackjack du joueur
                    System.out.println("Blackjack!");
                    return;
                }
                // Sur un Blackjack de la banque (et pas du joueur donc), elle gagne
                if (bankCards.split(" ").length == 2) {
                    System.out.println("Bank");
                    return;
                }
            }
            // Sinon égalité
            System.out.println("Draw");
            return;
        }
        // Dans les cas restants, le joueur a gagné
        System.out.println("Player");

    }

    // Méthode calculant le score d'une main
    private static int score(String hand) {
        int score = 0;
        int aces = 0;
        // Pour chaque carte de la main
        for (String s : hand.split(" ")) {
            // On essaie de la lire en tant qu'entier
            try {
                // Si ça marche, c'est une carte valant de 2 à 10, et on l'ajoute au score
                score += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                // Si ça n'a pas marché, c'est une figure ou un as
                if (s.equals("A")) {
                    // Dans le cas d'un as, on traitera après
                    aces++;
                } else {
                    // Les figures valent 10 points
                    score += 10;
                }
            }
        }
        // S'il y a plusieurs as, les surnuméraires ne peuvent valoir que 1
        if (aces > 1) {
            score += aces - 1;
            aces = 1;
        }
        // S'il reste un seul as à traiter
        if (aces == 1) {
            // Si le score est inférieur ou égal à 10, l'as vaut 11
            if (score <= 10) {
                score += 11;
            } else {
                // Sinon il vaut 1
                score++;
            }
        }
        return score;
    }
}