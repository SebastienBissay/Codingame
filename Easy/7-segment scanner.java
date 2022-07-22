import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        String answer = "";

        // Lecture des paraùètres
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();

        
        // On récupère les sous-Strings 3 par 3 :
        for (int i = 0; i < line1.length(); i +=3) {
            // On applique la méthode de décodage à la concaténation des sous-Strings
            answer += Solution.compute(line1.substring(i, i + 3), line2.substring(i, i + 3), line3.substring(i, i + 3));
        }
        System.out.println(answer);
        in.close();
    }

    // Méthode décodant une chaîne en l'entier correspondant
    static int compute(String l1, String l2, String l3) {
        // On switch sur les Strings concaténées
        switch(l1 + l2 + l3) {
            case "     |  |" : return 1;
            case " _  _||_ " : return 2;
            case " _  _| _|" : return 3;
            case "   |_|  |" : return 4;
            case " _ |_  _|" : return 5;
            case " _ |_ |_|" : return 6;
            case " _   |  |" : return 7;
            case " _ |_||_|" : return 8;
            case " _ |_| _|" : return 9;
            default : return 0;
        }
    }
}