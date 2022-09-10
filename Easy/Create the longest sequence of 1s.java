import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        in.close();

        // Longueur maximale initialisée à 0
        int maxL = 0;
        // Parcours de la chaîne de caractères
        for (int i = 0; i < b.length(); i++) {
            // Si le ième élément est un 0
            if (b.charAt(i) == '0') {
                // On calcule la longueur de la chaîne la plus longue en changeant cet élément par un 1
                // Et on garde le maximum entre cette longueur et celle qu'on avait déjà
                maxL = Math.max(maxL, Solution.computeLongest(b.substring(0, i) + "1" + b.substring(i + 1)));
            }
        }

        // Impression du résultat
        System.out.println(maxL);
    }

    // Méthode retournant la longueur de la plus longue sous-chaîne de "1" dans une string
    static int computeLongest(String s) {
        // On initialise la longueur maximale, l'index courant et la longueur courante à 0
        int maxL = 0;
        int index = 0;
        int currentL = 0;
        // Tant que l'index est dans la string
        while (index < s.length()) {
            // Si on rencontre un 0
            if (s.charAt(index) == '0') {
                // On peut incrémenter l'index
                index++;
                // La longueur maximale rencontrée est le maximum entre la courante et celle déjà stockée
                maxL = Math.max(maxL, currentL);
                // On réinitialise la longueur courante
                currentL = 0;
                // On repart en début de boucle
                continue;
            }
            // Sinon on incrémente l'index et la longueur courante
            currentL++;
            index++;
        }
        // A la fin de la boucle, il faut encore une fois vérifier que la longueur maximale n'est pas la longueur courante
        maxL = Math.max(maxL, currentL);
        // Et on renvoie la longueur maximale
        return maxL;
    }
}