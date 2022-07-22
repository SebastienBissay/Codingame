import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Stockage des parenthèses ouvertes
        ArrayList<String> heap = new ArrayList<>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String expression = in.next();
        in.close();

        // On parcourt la chaîne de caractères
        for (int i = 0; i < expression.length(); i++) {
            // Extraction du caractère courrant en tant que String
            String current = expression.substring(i, i + 1);
            // Si ce n'est pas une parenthèse/accolade/crochet, on ignore
            if (!current.matches("[\\[\\]\\(\\)\\{\\}]")) continue;

            // S'il n'y a rien dans le stockage, on stocke
            if (heap.isEmpty()) {
                heap.add(current);
                continue;
            }

            // Si il y a correspondance entre le haut du stock et l'actuel
            if (Solution.matches(heap.get(0), current)) {
                // On retire les deux
                heap.remove(0);
            } else {
                // Sinon on ajoute au stock
                heap.add(0, current);
            }
        }

        // C'est bon si le stock est vide
        System.out.println(heap.size() == 0);
    }

    // Test de correspondance : si on a un ouvrant à gauche correspondant avec un fermant à droite
    static boolean matches(String left, String right) {
        return (left.equals("(") && right.equals(")")) ||
                (left.equals("[") && right.equals("]")) ||
                (left.equals("{") && right.equals("}"));
    }
}