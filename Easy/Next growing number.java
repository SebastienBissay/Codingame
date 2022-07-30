import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();

        // On incrémente n
        n = Solution.increment(n);
        // Recherche du prochain growing (peut être lui même)
        n = Solution.nextGrowing(n);
        // Impression de la solution
        System.out.println(n);
        in.close();
    }

    // Incrémentation d'en entier sous forme de String
    public static String increment(String s) {
        return String.valueOf(Long.valueOf(s) + 1);
    }

    // Fonction donnant le prochain entier "growing"
    public static String nextGrowing(String s) {
        String growing = s;
        for (int i = 0; i < growing.length() - 1; i++) {
            // valeur courante
            int current = Integer.valueOf(growing.substring(i, i + 1));
            // Si la veleur courante est inféreieure à la suivante
            if (current > Integer.valueOf(growing.substring(i + 1, i + 2))) {
                // On remplace toute la fin par cette valeur
                growing = growing.substring(0, i + 1) + String.valueOf(current).repeat(growing.length() - i - 1);
                return growing;
            }
        }
        return growing;
    }
}