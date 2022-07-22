import java.util.*;

class Solution {
    public static void main(String args[]) {
        String answer = "";
        Scanner in = new Scanner(System.in);

        // Récupération des données
        int l = in.nextInt();
        int h = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Tout en majuscules
        String T = in.nextLine().toUpperCase(); 
        for (int i = 0; i < h; i++) {
            String row = in.nextLine();

            // Encodage du texte
            for (int j = 0; j < T.length(); j++)
            {
                char current = T.charAt(j);
                // Encodage ASCII du caractère en cours
                int ascii = Integer.valueOf(current);
                // 65 == A <= current <= 90 == Z
                int index = ((ascii < 65 || ascii > 90) ? 26 : (ascii - 65)) * l;
                answer += row.substring(index, index + l);
            }
            // Fin de ligne
            answer += "\n";
        }

        // Impression du résultat
        System.out.println(answer);
        in.close();
    }
}