import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String answer = "";

        // Lecture des largeur et hauteur
        int w = in.nextInt();
        int h = in.nextInt();

        // Matrice contenant la grille
        char[][] grid = new char[h][w];

        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Lecture de la grille de départ
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            for (int j = 0; j < w; j++)
            {
                grid[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                // Les mines deviennent des "."
                if (grid[i][j] == 'x') {
                    answer += ".";
                    continue;
                }

                // Pour chaque case non mine, on compte le nombre de voisins qui sont des mines
                int value = 0;
                for (int k = -1; k < 2; k++)
                {
                    if (i + k < 0 || i + k >= h) continue;
                    for (int l = -1; l < 2; l++)
                    {
                        if (k == 0 && l == 0) continue;
                        if (j + l < 0 || j + l >= w) continue;
                        if (grid[i + k][j + l] == 'x') value++;
                    }
                }

                // S'il n'y a pas de mine alentour, on a "."
                if (value > 0) {
                    answer += value;
                } else {
                    answer += ".";
                }
            }

            // Saut de ligne
            if (i < h - 1) answer += "\n";
        }

        // Ecriture de la solution
        System.out.println(answer);
        in.close();
    }
}