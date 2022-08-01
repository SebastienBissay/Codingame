import java.util.*;

class Solution {

    public static void main(String args[]) {

        // Tableau de stockage des résultats
        EncodedLine[] answer;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        // Initialisation du tableau des résultats maintenant qu'on en connaît la taille
        answer = new EncodedLine[h];
        // Passage à la ligne suivante
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Stockage de la longueur de ligne
        int length = 0;
        // Pour chaque ligne encodée
        for (int i = 0; i < h; i++) {
            // Lecture et décodage de la ligne
            String row = in.nextLine();
            answer[i] = new EncodedLine(row);
            // Si c'est la première ligne, on stocke sa longueur
            if (i == 0)
                length = answer[i].line.length();
            // Si la longueur n'est pas égale à celle de la première ligne, il y a une erreur
            if (answer[i].line.length() != length) {
                System.out.println("INVALID");
                in.close();
                return;
            }
        }

        // Affichage du résultat
        for (int i = 0; i < h; i++) {
            System.out.println(answer[i].line);
        }
        in.close();
    }
}

// Classe gérant une ligne encodée
class EncodedLine {
    String line;

    // Constructeur prenant une String en entrée
    EncodedLine(String str) {

        // Découpage de l'entrée selon les espaces
        String[] split = str.split(" ");
        // Décodage et stockage des valeurs numériques
        int[] values = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.parseInt(split[i]);
        }

        // Initialisation du contenu
        this.line = "";
        // On démarre par du blanc
        boolean isWhite = true;
        // On ajoute le nombre de caractères voulus
        for (int i : values) {
            this.line += ((isWhite) ? "." : "O").repeat(i);
            // Et on inverse la couleur
            isWhite = !isWhite;
        }
    }

}