import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Lecture des largeur et longueur
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Création et lecture de la grille
        String[] grid = new String[H];
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            grid[i] = line;
        }

        // Parcours des départs de gauche à droite
        for (int i = 0; i < W; i++)
        {
            // S'il n'y a pas de caractère de départ, on passe à la colonne suivante
            if (grid[0].charAt(i) == ' ')
            {
                continue;
            }

            // On écrit le nom du départ et on récupère notre position actuelle dans la grille
            String answer = String.valueOf(grid[0].charAt(i));
            int position = i;
            int direction = 0;

            // Tant qu'on n'est pas descendu tout en bas
            for (int j = 1; j < H - 1; j++)
            {
                // Si on rencontre une ligne horizontale, on regarde dans quel sens aller
                if (position > 0 && grid[j].charAt(position - 1) == '-') {
                    direction = -1;
                    position--;
                }
                if (position < W - 1 && grid[j].charAt(position + 1) == '-') {
                    direction = 1;
                    position++;
                }

                // On suit la ligne horizontale jusqu'à son terme
                while (grid[j].charAt(position) == '-') {
                    position += direction;
                }
            }

            // Mise à jouer et écriture de la réponse
            answer += String.valueOf(grid[H - 1].charAt(position));
            System.out.println(answer);
        }
        in.close();
    }
}