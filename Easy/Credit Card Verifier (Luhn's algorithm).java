import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Pour chaque carte de crédit
        for (int i = 0; i < n; i++) {
            String card = in.nextLine();
            // On la crée en supprimant les espaces
            CreditCard cc = new CreditCard(card.replace(" ", ""));
            // Et on la vérifie
            System.out.println(cc.verify() ? "YES" : "NO");
        }
    }
}


// Classe gérane une carte de crédit
class CreditCard {
    // Les valeurs sont stockées sous forme d'un tableau de chiffres
    int[] code = new int[16];

    // Constructeur parsant une string
    CreditCard(String s) {
        for (int i = 0; i < 16; i++) {
            code[i] = Integer.valueOf(s.substring(i, i + 1));
        }
    }

    // Méthode vérifiant la validité d'une carte
    boolean verify() {
        // Steps 1 & 2
        int test1 = 0;
        for (int i = 0; i < 16; i += 2) {
            int tmp = 2 * this.code[i];
            test1 += (tmp > 9) ? tmp - 9 : tmp;
        }
        // Step 3
        int test2 = 0;
        for (int i = 1; i < 16; i += 2) {
            test2 += this.code[i];
        }
        // Step 4 & 5
        return (test1 + test2) % 10 == 0;
    }
}