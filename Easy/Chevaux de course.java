import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int minDiff = Integer.MAX_VALUE;
        // Liste contenant les puissances des chevaux
        ArrayList<Integer> puissances = new ArrayList<Integer>();

        // Lecture du nombre de chevaux
        int N = in.nextInt();
        
        // Lecture des puissances des chevaux
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            puissances.add(pi);
        }

        // Tri de la liste par ordre croissant
        puissances.sort(null);

        
        // Recherche de la différence minimale antre deux chevaux consécutifs (la liste étant triée)
        for (int i = 1; i < N; i++)
        {
            minDiff = Math.min(minDiff, puissances.get(i) - puissances.get(i - 1));
        }

        // Impression du résultat
        System.out.println(minDiff);
        in.close();
    }
}