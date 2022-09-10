import java.util.*;

class Solution {
    // Opération entre deux booléens
    static boolean operationBoolenne(String op, char c1, char c2) {
        switch(op) {
            case "OR" : return c1 == '-' || c2 == '-';
            case "AND" : return c1 == '-' && c2 == '-';
            case "XOR" : return c1 != c2;
            // On commence par 'N', donc on prend la négation de l'opération qui suit
            default : return !operationBoolenne(op.substring(1), c1, c2);
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        //Nombre d'entrées et de sorties
        int nombreEntrees = in.nextInt();
        int nombreSorties = in.nextInt();

        // Map des signaux d'entrée et des futurs signaux de sortie
        HashMap<String, String> signaux = new HashMap<>();

        // Lecture des signaux d'entrée
        for (int i = 0; i < nombreEntrees; i++) {
            signaux.put(in.next(), in.next());
        }

        for (int i = 0; i < nombreSorties; i++) {
            // Affichage du nom de signal de sortie
            System.out.print(in.next() + " ");

            // Type d'opération à effectuer
            String type = in.next();

            // Signaux à utiliser
            String signal1 = signaux.get(in.next());
            String signal2 = signaux.get(in.next());

            // Pour chaque caractère, on affiche le résultat de l'opération booléenne voulue retraduit en signal
            for (int j = 0; j < signal1.length(); j++) {
                System.out.print(Solution.operationBoolenne(type, signal1.charAt(j), signal2.charAt(j)) ? "-" : "_");
            }

            // Fin de ligne
            System.out.print("\n");            
        }
        in.close();
    }
}