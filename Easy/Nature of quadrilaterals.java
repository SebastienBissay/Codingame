import java.util.*;

class Solution {

    public static void main(String args[]) {

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String A = in.next();
            int xA = in.nextInt();
            int yA = in.nextInt();
            String B = in.next();
            int xB = in.nextInt();
            int yB = in.nextInt();
            String C = in.next();
            int xC = in.nextInt();
            int yC = in.nextInt();
            String D = in.next();
            int xD = in.nextInt();
            int yD = in.nextInt();

            System.out.print(A + B + C + D + " is a ");

            // Si les côtés opposés sont de même longueur
            if ((xB - xA == xC - xD) && (yB - yA == yC - yD)) {

                // Si AB = BC
                if ((xB - xA) * (xB - xA) + (yB - yA) * (yB - yA) == (xC - xB) * (xC - xB) + (yC - yB) * (yC - yB)) {

                    // Si ABC est droit
                    if ((xB - xA) * (xC - xB) + (yB - yA) * (yC - yB) == 0) {
                        // Carré
                        System.out.println("square.");
                    } else {
                        // Losange
                        System.out.println("rhombus.");
                    }
                } else {
                    // SI ABC est droit
                    if ((xB - xA) * (xC - xB) + (yB - yA) * (yC - yB) == 0) {
                        // Rectangle
                        System.out.println("rectangle.");
                    } else {
                        // Parallelogramme
                        System.out.println("parallelogram.");
                    }
                }
            } else {
                // Cas général
                System.out.println("quadrilateral.");
            }
        }
        in.close();
    }
}