import java.util.*;
class Solution {

    public static void main(String args[]) {
        int min = Integer.MAX_VALUE;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // Ajout des valeurs dans une liste
        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bags.add(in.nextInt());
        }

        // Tri de la liste
        Collections.sort(bags);

        // Recherche de la différence minimale entre 2 sacs séparés par (m - 1) dans une liste triée
        for (int i = 0; i < n - m + 1; i++) {
            min = Integer.min(min, bags.get(i + m - 1) - bags.get(i));
        }

        // Impression du résultat
        System.out.println(min);
        in.close();
    }
}