import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int startingScore = in.nextInt();
        in.close();

        // Calcul et impression des résultats
        System.out.println(getPossibilities("", 50 - startingScore, 0));
    }

    // Fonction récursive calculant le nombre de possibilités
    static int getPossibilities(String current, int remaining, int round) {
        // Si le reste est 0, la solution actuelle est valide
        if (remaining == 0) {
            return 1;
        }
        // Si on a dépassé le nombre de rounds autorisé, la solution est invalide
        if (round == 4) {
            return 0;
        }
        // Compte des solutions valides
        int s = 0;
        // On teste toutes les solutions allant de 12 à 2, toutes obtenables de 2 façons : Pk et k
        for (int k = 12; k > 1; k--) {
            if (remaining >= k) {
                s += getPossibilities(current + (current.isEmpty() ? "" : " ") + "P" + Integer.toString(k), remaining - k, round + 1);
                s += getPossibilities(current + (current.isEmpty() ? "" : " ") + Integer.toString(k), remaining - k, round + 1);
            }
        }
        // Enfin, 1 n'est obtenable qu'en faisant P1
        return s + getPossibilities(current + (current.isEmpty() ? "" : " ") + "P1", remaining - 1, round + 1);
    }
}
