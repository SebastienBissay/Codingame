import java.util.*;

class Solution {

    // Stockage des String de réponse et de la hauteur maximale
    static String[] answer;
    static int maxHeight = 0;

    // Méthode de construction d'une montagne
    static void build(int height) {
        // Ajout des pentes descendants \ et espaces liés
        for (int h = 0; h < height; h++) {
            for (int j = 0; j < Solution.maxHeight; j++) {
                Solution.answer[j] = ((j == h) ? "\\" : " ") + Solution.answer[j];
            }
        }
        // Ajout des pentes montantes et espaces liés
        for (int h = height - 1; h >= 0; h--) {
            for (int j = 0; j < Solution.maxHeight; j++) {
                Solution.answer[j] = ((j == h) ? "/" : " ") + Solution.answer[j];
            }
        }
    }

    public static void main(String args[]) {
        // Stockage des hauteurs
        int[] heights;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Initialisaton du tableau des hauteurs maintenant qu'on en connaît la taille
        heights = new int[n];
        // Lecture et stockage des hauteurs
        for (int i = 0; i < n; i++) {
            int height = in.nextInt();
            heights[i] = height;
            // Mise à jour de la hauteur maximale si besoin
            Solution.maxHeight = Integer.max(Solution.maxHeight, height);
        }

        // On va devoir stocke maxHeight Strings
        Solution.answer = new String[maxHeight];
        // Initialisation des String
        for (int h = 0; h < maxHeight; h++) {
            Solution.answer[h] = "";
        }
        // Constrution ddes montagnes, à l'envers
        for (int i = n - 1; i >= 0; i--) {
            Solution.build(heights[i]);
        }
        // L'affichage s efait également à l'envers
        for (int h = Solution.maxHeight - 1; h >= 0; h--) {

            // Retrait des espaces finaux superflus
            int l = Solution.answer[h].length() - 1;
            while (Solution.answer[h].charAt(l) == ' ') {
                l--;
            }
            Solution.answer[h] = Solution.answer[h].substring(0, l + 1);

            // Impression de la ligne finalisée
            System.out.println(Solution.answer[h]);
        }
        in.close();
    }
}