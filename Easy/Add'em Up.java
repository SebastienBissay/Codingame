import java.util.*;

class Solution {

    public static void main(String args[]) {
        int price = 0;
        ArrayList<Integer> cards = new ArrayList<Integer>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        // Ajout des cartes
        for (int i = 0; i < N; i++) {
            cards.add(in.nextInt());
        }
        in.close();

        // Tant qu'il y a plusieurs cartes
        while(cards.size() > 1) {
            // Tri des cartes : il faut merger les moins chères en premier !
            Collections.sort(cards);
            // Merge des deux cartes les moins chères en une nouvelle carte
            price += cards.get(0) + cards.get(1);
            cards.add(cards.get(0) + cards.get(1));
            cards.remove(0);
            cards.remove(0);
        }

        // Impression du résultat
        System.out.println(price);
    }
}