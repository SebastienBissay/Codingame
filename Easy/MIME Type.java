import java.util.*;

class Solution {

    public static void main(String args[]) {
        Hashtable<String, String> hT = new Hashtable<String, String>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        for (int i = 0; i < N; i++) {
            String EXT = in.next();
            String MT = in.next();
            // On associe dans la Hastable les extensions et les types MIME
            hT.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();

        //Parcous des entrées
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine();
            // Renvoie la position du dernier '.', -1 si non trouvé
            int dotIndex = FNAME.lastIndexOf(".");
            // On découpe après le dernier point
            String ext = FNAME.substring(dotIndex + 1).toLowerCase();
            String answer;

            // Si le nom ne contenait pas de point
            if (dotIndex == -1)
            {
                answer = "UNKNOWN";
            } else {
                // On cherche la correspondance dans la table
                answer = hT.get(ext);
            }

            // Si aucune correspondance n'a été trouvée
            if (answer == null) {
                answer = "UNKNOWN";
            }

            // Impression du résultat
            System.out.println(answer);
        }
        in.close();
    }
}
