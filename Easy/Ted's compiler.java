import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        // Initialisation
        int index = 0, length = 0, depth = 0;
        // Tant qu'on est dans la string et qu'on n'a pas fermé plus qu'on a ouvert
        while (index < line.length() && depth > -1) {
            // On incrément la longueur
            length++;
            // Dans le cas < on incrémente la profondeur
            if (line.charAt(index) == '<') {
                depth++;
            } else {
                // Dans le cas contraire, on la décrémente
                depth--;
            }
            // On avance dans la string
            index++;
        }
        // Si on a quitté pour cause de fermeture surnuméraire
        if (depth < 0) {
            // il faut réduire la longueur de 1
            length--;
        }
        // Si la profondeur est strictement positive, c'est qu'on a fini la chaîne sans tout fermer
        // C'est invalide
        if (depth > 0) {
            length = 0;
        }
        // Impression du résultat
        System.out.println(length);
    }
}