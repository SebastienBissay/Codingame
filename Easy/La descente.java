import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Boucle de jeu
        while (true) {
            // Hauteur maximale et indice de cette montagne
            int maxHeight = 0;
            int index = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt();
                // Si la montagne est plus haute que le maximum actuel
                if (mountainH > maxHeight) {
                    //On met à jour le maximum et l'indice
                    maxHeight = mountainH;
                    index = i;
                }
            }

            // On renvoie l'indice de la montagne la plus haute
            System.out.println(index);
        }
    }
}