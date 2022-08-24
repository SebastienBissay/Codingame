import java.util.*;

class Solution {

    public static void main(String args[]) {
        int minLength = Integer.MAX_VALUE;
        int answer = -1;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Parcours de chaque carte
        for (int i = 0; i < n; i++) {

            // Lecture de la carte
            String[] map = new String[h];
            for (int j = 0; j < h; j++) {
                map[j] = in.nextLine();
            }
            // Longueur de trajet initiale : 0
            int length = 0;
            int y = startRow;
            int x = startCol;
            // On part en considérant que la carte est valide
            boolean found = true;
            // Tant qu'on n'a pas trouvé le trésor
            while(map[y].charAt(x) != 'T') {
                // Le trajet parcouru augmente de 1
                length++;
                // Application de la case courante de la carte
                switch(map[y].charAt(x)) {
                    case '>' :
                        x++;
                        break;
                    case '<' :
                        x--;
                        break;
                    case '^' :
                        y--;
                        break;
                    case 'v' :
                       y++;
                       break;
                    // Piège => on sort de la carte
                    default :
                        x = -1; 
                }
                // Si on est sorti de la carte (chemin faux ou piège)
                if (x < 0 || x >= w || y < 0 || y >= h  || (x == startCol && y == startRow)) {
                    // On n'a pas trouvé le trésor
                    found = false;
                    // Et on cesse de chercher
                    break;
                }
            }
            
            // Si le trésor a été trouvé et que le chemin a été plus court que le plus court connu
            if (found && length < minLength) {
                // Le chemin actuel est stocké comme minimum
                minLength = length;
                answer = i;
            }
        }

        // Si answer est -1, aucune carte ne mène au trésor, c'est un piège, sinon c'est l'id de la bonne carte
        System.out.println(answer != -1 ? answer : "TRAP");
        in.close();
    }
}