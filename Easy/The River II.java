import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        in.close();

        // Tableau des valeurs inférieurs à r1 dont on a visité les rivières
        boolean[] map = new boolean[r1];

        // On regarde chaque rivière de 1 à r1 - 1
        for (int i = 1; i < r1; i++) {
            River r = new River(i);
            int v = i;
            // Tant que la rivière est inférieure à r1, on avance
            while(v < r1) {
                // Si on rejoint une rivière déjà visitée, on peut s'arrêter
                if (map[v]) break;
                // On marque la valeur comme visitée
                map[v] = true;
                // On calcule la prochaine valeur
                v = r.next();
            }

            // Si on tombe sur r1, r1 est un point de rencontre
            if (v == r1) {
                System.out.println("YES");
                return;
            }
        }

        // Si on n'est jamais tombé sur r1, r1 n'est pas un point de rencontre
        System.out.println("NO");
    }
}

// Classe gérant une rivière
class River {
    int value;

    River(int start) {
        this.value = start;
    }

    // Méthode calculant le prochain élément d'une rivière et le retournant
    int next() {
        int c = 0;
        // On passe la valeur de la rivière en String
        String s = String.valueOf(this.value);
        for (int i = 0; i < s.length(); i++)
        {
            // On ajoute la valeur des chiffre
            c += Integer.valueOf(s.substring(i, i + 1));            
        }
        // Mise à jour et retour de la rivière
        this.value += c;
        return this.value;
    }
}