import java.util.*;

class Solution {

    // Méthode récursive mettant à jour une grille selon une lampe placée
    // aux coordonnées x, y et d'intensité donnée
    public static void recLight(int x, int y, int intensity, int[][] grid)
    {
        // La valeur de la grille est toujours le maximum entre la valeur actuelle et la valeur d'éclairage
        grid[x][y] = Integer.max(grid[x][y], intensity);
        int N = grid.length;
        // Si l'intensité était de 1, on sort. Sinon on réduit l'intensité de 1
        if (--intensity == 0) return;

        // On regarde les voisins directs
        for (int k = -1; k < 2; k++)
        {
            for (int l = -1; l < 2; l++)
            {
                // On ignore la cellule courante
                if (k == 0 && l == 0) continue;

                // Si on est toujours dans la grille
                if (x + k >= 0 && x + k < N && y + l >= 0 && y + l < N)
                {
                    // On appelle la méthode avec le nouveau centre et une intensité réduite de 1
                    recLight(x+ k, y + l, intensity, grid);
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int count = 0;

        // Lecture des paramètres
        int N = in.nextInt();
        int L = in.nextInt();
        // Création de la grille
        int[][] grid = new int[N][N];

        // Lecture de la grille avec gestion des lampes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String cell = in.next();
                if (cell.charAt(0) == 'C') {
                    recLight(i, j, L, grid);
                }
            }
        }
        
        // Compte des cases à l'ombre
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0) count++;
            }
        }

        // Impression du résultat
        System.out.println(count);
        in.close();
    }
}