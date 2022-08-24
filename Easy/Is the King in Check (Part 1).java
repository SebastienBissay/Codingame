import java.util.*;

class Solution {

    public static void main(String args[]) {

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);

        // Création de l'échiquier
        String[][] grid = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String chessRow = in.nextLine();
            for (int j = 0; j < 8; j++){
                grid[i] = chessRow.split(" ");
            }
        }
        in.close();

        // Recherche des cas d'échec : parcours de l'échiquier
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // En fonction de la pièce présente
                switch (grid[i][j]) {
                    // Tour
                    case "R" :
                        // On regarde les lignes horizontales et verticales
                        for (int k = 0; k < 8; k++) {
                            // Si le roi est présent, échec
                            if (grid[i][k].equals("K") || grid[k][j].equals("K")) {
                                System.out.println("Check");
                                return;
                            }
                        }
                        break;

                    // Reine
                    case "Q" :
                        // Parcours sur les lignes comme la tour
                        for (int k = 0; k < 8; k++) {
                            if (grid[i][k].equals("K") || grid[k][j].equals("K")) {
                                System.out.println("Check");
                                return;
                            }
                        }
                        // Pas de break car elle agit aussi comme le fou
                    
                    // Fou
                    case "B" :
                        // Parcours des diagonales
                        for (int k = 0; k < 8; k++) {
                            if (i - k >= 0) {
                                if (j - k >= 0 && grid[i - k][j - k].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                                if (j + k < 8 && grid[i - k][j + k].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                            }
                            if (i + k < 8) {
                                if (j - k >= 0 && grid[i + k][j - k].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                                if (j + k < 8 && grid[i + k][j + k].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                            }
                        }
                        break;
                    
                    // Cavalier
                    case "N" :
                        // Parcours des cases respectant le mouvement du cavalier
                        for (int x = -2; x < 3; x++) {
                            if ( x == 0) continue;
                                if (i + x >= 0 && i + x < 8 &&  j - Math.abs(x) + 3 >= 0 && j  - Math.abs(x) + 3 < 8 && grid[i + x][j - Math.abs(x) + 3].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                                if (i + x >= 0 &&i + x < 8 &&  j + Math.abs(x) - 3 >= 0 && j  + Math.abs(x) - 3 < 8 && grid[i + x][j + Math.abs(x) - 3].equals("K")) {
                                    System.out.println("Check");
                                    return;
                                }
                        }
                    default :
                }
            }
        }

        // Si on arrive ici, le roi n'est pas en échec
        System.out.println("No Check");
    }
}