import java.util.*;

class Solution {

    // Méthode retournant le carré de la longueur d'un segment AB
    static double squareLength(int xA, int yA, int xB, int yB) {
        return (xB - xA) * (xB - xA) + (yB - yA) * (yB - yA);
    }

    public static void main(String args[]) {
        String answer = "";
        Scanner in = new Scanner(System.in);

        // Lecture du nombre de triangles
        int n = in.nextInt();

        // Pour chaque triangle
        for (int i = 0; i < n; i++) {

            // Lecture des données du triangle
            String A, B, C = B = A = "";
            int xA, yA, xB, yB, xC, yC;
            A = in.next();
            xA = in.nextInt();
            yA = in.nextInt();
            B = in.next();
            xB = in.nextInt();
            yB = in.nextInt();
            C = in.next();
            xC = in.nextInt();
            yC = in.nextInt();

            // Nom du triangle
            answer += A + B + C + " is ";

            // Calcul des carrés des longueurs
            double AB, AC, BC;
            AB = Solution.squareLength(xA, yA, xB, yB);
            AC = Solution.squareLength(xA, yA, xC, yC);
            BC = Solution.squareLength(xC, yC, xB, yB);

            // Le triangle est-il isocèle ?
            if (AB == AC) {
                answer += "an isosceles in " + A;
            } else if (AB == BC) {
                answer += "an isosceles in " + B;
            } else if (AC == BC) {
                answer += "an isosceles in " + C;
            } else {
                answer += "a scalene";
            }

            answer += " and ";

            // Recherche d'angle droit (Pythagore)
            if (AB == AC + BC) {
                answer += "a right in " + C;
            } else if (AC == AB + BC) {
                answer += "a right in " + B;
            } else if (BC == AB + AC) {
                answer += "a right in " + A;
            } else {

                // Sinon on utilise Al-Kashi
                double angA, angB, angC;
                angA = Math.acos((AC + AB - BC) / (2. * Math.sqrt(AC * AB))) / Math.PI * 180;
                angB = Math.acos((AC - AB - BC) / (-2. * Math.sqrt(AB * BC))) / Math.PI * 180;
                angC = Math.acos((AB - BC - AC) / (-2. * Math.sqrt(AC * BC))) / Math.PI * 180;

                // Cas d'angle obtus
                if (angA > 90.) {
                    answer += "an obtuse in " + A + " (" + Math.round(angA) + "°)";
                } else if (angB > 90.) {
                    answer += "an obtuse in " + B + " (" + Math.round(angB) + "°)";
                } else if (angC > 90.) {
                    answer += "an obtuse in " + C + " (" + Math.round(angC) + "°)";
                } else {
                    answer += "an acute";
                }
            }

            // Fin d'affichage
            answer += " triangle.";
            // Saut de ligne si on n'est pas à la dernière ligne
            if (i < n - 1)
                answer += "\n";
        }

        // Affichage de la solution
        System.out.println(answer);
        in.close();
    }
}
