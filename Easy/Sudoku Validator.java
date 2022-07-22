import java.util.*;

class Solution {
    public static void main(String args[]) {
        boolean isValid = true;
        Scanner in = new Scanner(System.in);

        // Parce que Java refuse les HashSet<>[], ce vilain :(
        ArrayList<HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> subSquares = new ArrayList<HashSet<Integer>>();

        // Initialisation des Sets
        for (int i = 0; i < 9; i++) {
            columns.add(new HashSet<>());
            rows.add(new HashSet<>());
            subSquares.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Lecture du chiffre courant
                int n = in.nextInt();

                // Ajout au Set de la ligne courante
                rows.get(i).add(n);

                // Ajout au Set de la colonne courante
                columns.get(j).add(n);

                // Ajout au Set du sous-carré courant
                int subSquareIndex = i / 3 + 3 * (j / 3);
                subSquares.get(subSquareIndex).add(n);
            }
        }

        // Test de validité
        for (int i = 0; i < 9; i++) {
            // S'il n'y a pas 9 éléments différents (Set), alors c'est invalide
            isValid = rows.get(i).size() == 9;
            isValid = isValid && columns.get(i).size() == 9;
            isValid = isValid && subSquares.get(i).size() == 9;

            // Dès que la grille n'est pas valide, on peut s'arrêter || accessoire
            if (!isValid) break;
        }

        // Impression du résultat
        System.out.println(isValid);
        in.close();
    }
}