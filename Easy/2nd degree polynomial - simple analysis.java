import java.util.*;

class Solution {

    public static void main(String args[]) {

        // Lecture ds paramètres
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        // Contruction et travail sur le polynôme, qui fera l'impression
        Polynomial p = new Polynomial(a, b, c);
        p.solve();
        in.close();
    }
}

// Classe gérant un point du plan
class Point {
    double x, y;

    // Constructeur
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Méthode renvoyant une string arrondie à deux chiffres après la virgule
    // Sans virgule si non nécessaire
    String getRoundedValue(double d) {
        float tmp = Math.round(d * 100) / 100.f;
        // Si pas besoin, pas de virgule
        if (tmp == Math.floor(tmp)) {
            return String.valueOf((int) d);
        }
        return String.valueOf(tmp);
    }

    // Retour de la String
    String printValue() {
        return "(" + getRoundedValue(this.x) + "," + getRoundedValue(this.y) + ")";
    }
}

// Classe gérant un polynôme de degré <= 2
class Polynomial {
    double a, b, c;

    // Constructeur
    Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Méthode donnant les racines et l'intersection avec l'axe des ordonnées
    ArrayList<Point> getRoots() {
        // Liste des points
        ArrayList<Point> points = new ArrayList<>();

        // Intersection avec l'axe des ordonneés
        points.add(new Point(0, this.c));

        // Cas d'une droite
        if (a == 0) {

            // Le cas horizontal est déjà traité (intersection avec l'axe des ordonneés)
            if (b != 0) {
                points.add(new Point(-this.c / this.b, 0));
            }
        } else {
            // Cas d'un polynôme de degré 2
            // Calcul discriminant
            double delta = this.b * this.b - 4 * this.a * this.c;

            if (delta >= 0) {
                // Une seule racine
                if (delta == 0) {
                    points.add(new Point(-this.b / (2 * this.a), 0));
                } else {
                    // Deux racines
                    points.add(new Point((-this.b - Math.sqrt(delta)) / (2 * this.a), 0));
                    points.add(new Point((-this.b + Math.sqrt(delta)) / (2 * this.a), 0));
                }
            }
        }
        return points;
    }

    // Méthode imprimant les points, dans l'ordre des abscisses
    void solve() {
        // Récupération des points d'intérêt
        ArrayList<Point> points = this.getRoots();
        // Tri selon les abscisees
        Collections.sort(points, (Point a, Point b) -> Double.compare(a.x, b.x));

        // Construction de la réponse
        String answer = "";
        for (int i = 0; i < points.size(); i++) {
            answer += points.get(i).printValue();
            if (i < points.size() - 1)
                answer += ",";
        }

        // Impression de la réponse
        System.out.println(answer);
    }
}