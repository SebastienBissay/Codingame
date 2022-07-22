import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Initialisation du défribilateur le plus proche et de sa distance (inexistant / maximale)
        Defib closest = null;
        double minDist = Double.MAX_VALUE;

        //Lecture des paramètre
        Scanner in = new Scanner(System.in);
        double LON = Double.valueOf(in.next().replace(',', '.'));
        double LAT = Double.valueOf(in.next().replace(',', '.'));
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Pour chaque défibrillateur
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            // Création du défibrillateur
            Defib current = new Defib(DEFIB);
            // Calcul de sa distance
            double dist = current.dist(LAT, LON);
            // S'il est plus proche que celui actuellement en mémoire
            if (dist < minDist) {
                // La distance devient le nouveau minimum
                minDist = dist;
                // On le stocke en mémoire
                closest = current;
            }
        }

        // Impression du résultat
        System.out.println(closest.name);
        in.close();
    }
}

// Classe gérant un défibrillateur
class Defib {
    double longitude, latitude;
    String name;

    // Constructeur parsant une String
    Defib(String line) {
        // Découpage de la String selon les ";"
        String[] str = line.split(";");
        // Le nom est le deuxième élément
        this.name = str[1];
        // La longitude est l'avant-dernier élément, et il faut remplacer les ',' par des '.'
        this.longitude = Double.valueOf(str[str.length - 2].replace(',', '.'));
        // La latitude est le dernier élément, et il faut remplacer les ',' par des '.'
        this.latitude = Double.valueOf(str[str.length - 1].replace(',', '.'));
    }

    // Renvoie la distance à un point donné via la formule fournie
    double dist(double latitude, double longitude) {
        double x = (this.longitude - longitude) * Math.cos((this.latitude + latitude) / 2.);
        double y = this.latitude - latitude;
        return Math.sqrt(x * x + y * y) * 6371;
    }
}