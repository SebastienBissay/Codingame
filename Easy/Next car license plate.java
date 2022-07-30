import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        int n = in.nextInt();

        // Création de la plaque
        Plate plate = new Plate(x);
        // On augmente de n plaques
        for (int i = 0; i < n; i++) {
            plate.increment();
        }
        // Impression du résultat
        plate.read();
        in.close();
    }
}

// Classe gérant un plaque d'immatriculation au format PP-NNN-SS
class Plate
{
    // Stockage des 2 lettres PP comme prefix, des deux lettres SS comme suffix
    String prefix, suffix;
    // Stockage des trois chiffres NNN comme entier number
    int number;

    // Constructeur parsant une String
    Plate(String str) {
        this.prefix = str.substring(0, 2);
        this.suffix = str.substring(7);
        this.number = Integer.valueOf(str.substring(3, 6));
    }

    // Fonction augmentant la valeur d'une plaque de 1 :
    void increment() {
        // On augmente la valeur numérique en premier
        this.number++;
        // Si elle atteint 1000
        if (this.number == 1000) {
            // Elle repasse à 1
            this.number = 1;
            // On doit augmenter la dernière lettre du suffixe
            // Si elle vaut Z
            if (this.suffix.charAt(1) == 'Z')
            {
                // Si la lettre d'avant vaut Z aussi
                if (this.suffix.charAt(0) == 'Z') {
                    // Alors le suffixe devient AA et on augment le préfixe
                    this.suffix = "AA";
                    // Si la dernière lettre du préfixe est Z
                    if (this.prefix.charAt(1) == 'Z') {
                        // On la remet à A et on augmente la première lettre du préfixe
                        this.prefix = (char) ((int) this.prefix.charAt(0) + 1) + "A";
                    } else {
                        // Sinon on augmente la dernière lettre du préfixe
                        this.prefix = String.valueOf(this.prefix.charAt(0)) + (char)((int) this.prefix.charAt(1) + 1);
                    }
                } else {
                    // Sinon on met la dernière lettre du suffixe à A et on augmente celle d'avant
                    this.suffix = (char) ((int) this.suffix.charAt(0) + 1) + "A";
                }
            } else
            {
                // Sinon on augmente la dernière lettre du suffixe
                this.suffix = String.valueOf(this.suffix.charAt(0)) + (char)((int) this.suffix.charAt(1) + 1);
            }
        }
    }

    // Renvoie la plaque au format PP-NNN-SS
    void read() {
        System.out.printf("%s-%03d-%s\n", this.prefix, this.number, this.suffix);
    }
}