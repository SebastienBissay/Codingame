import java.util.*;

class Solution {
    // Données pour le générateur de nombres pseudo-aléatoires
    static int a, b, m;

    public static void main(String args[]) {

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        Solution.a = in.nextInt();
        Solution.b = in.nextInt();
        Solution.m = in.nextInt();

        // Etat initial
        int x = 0, y = 0;
        int d = 0;
        int counter = 0;

        do {
            // Incémentation du compteur
            counter++;
            // Génération du nombre pseudo aléatoire
            d = Solution.pRNG(d);
            // Mouvement selon d % 4
            switch (d % 4) {
                case 0:
                    y++;
                    break;
                case 1:
                    y--;
                    break;
                case 2:
                    x++;
                    break;
                default:
                    x--;
            }
            // Arrêt quand on revient à la case de départ
        } while (x != 0 || y != 0);

        // Impression du résultat
        System.out.println(counter);
        in.close();
    }

    // Méthode de génération de nombres pseudo-aléatoires fournie dans l'énoncé
    static int pRNG(int d) {
        return (Solution.a * d + Solution.b) % Solution.m;
    }
}