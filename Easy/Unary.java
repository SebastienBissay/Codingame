import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String answer = "";

        String MESSAGE = in.nextLine();

        // Transformation du message en binaire
        String binary = "";
        for (int i = 0; i < MESSAGE.length(); i++)
        {
            // Lecture du i-ème caractère
            char c = MESSAGE.charAt(i);
            // Transformation en binaire
            String binStr = Integer.toBinaryString(c);
            // Ajout des 0 initiaux si manquants
            while(binStr.length() < 7)
            {
                binStr = "0" + binStr;
            }
            binary += binStr;
        }

        // Conversion du binaire en unaire
        int position = 0;
        while (position < binary.length())
        {
            String current = binary.substring(position, position + 1);
            
            // 0 ou 00
            answer += "0";
            if (current.equals("0")) answer += "0";

            answer += " ";

            // Recherche de la taille du bloc de symboles identiques
            do
            {
                answer += "0";
                position ++;
            } while(position < binary.length() && current.equals(binary.substring(position, position + 1)));
            // Insertion d'un espace
            answer+=" ";
        }
        // Impression du résultat en enlevant les espaces en début et fin de string
        System.out.println(answer.trim());
        in.close();
    }
}