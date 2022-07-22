import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Découpage de la compression en fonction des espaces
        String[] compression = in.nextLine().split(" ");

        // true : noir | false : blanc
        boolean state = true;
        // Bord de page
        String answer = "|";
        int index = 0;

        // Pour chaque élément de compassion
        for (String str : compression) {
            // On transforme en entier
            int length = Integer.parseInt(str);
            // On ajoute les éléments
            for (int i = 0; i < length; i++) {
                // On va à la ligne si besoin
                if (index == W) {
                    answer += "|\n|";
                    index = 0;
                }
                answer += state ? "*" : " ";
                index++;
            }

            // Changment d'état noir <-> blanc
            state = !state;
        }

        // Fermture de page et impression
        System.out.println(answer + "|");
        in.close();
    }
}