import java.util.*;

class Solution {

    public static void main(String args[]) {
        int countErrors = 0;
        ArrayList<String> errors = new ArrayList<>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String ISBN = in.nextLine();
            ISBN isbn = new ISBN(ISBN);
            // Test de validité : si faux, on ajoute une erreur et on stocke le code fautif
            if (!isbn.checkValidity()) {
                countErrors++;
                errors.add(ISBN);
            }
        }

        // Impression des résultats
        System.out.println(countErrors + " invalid:");
        for (String s : errors) {
            System.out.println(s);
        }
        in.close();
    }
}

// Classe gérant un ISBN
class ISBN {
    String value;

    // Constructeur
    ISBN (String value) {
        this.value = value;
    }

    // Test de validité
    boolean checkValidity() {

        // Si la longueur est 10, on fait le test approprié
        if (this.value.length() == 10) {
            return check10();
        }
        // Si la longueur est 13, on fait le test approprié
        if (this.value.length() == 13) {
            return check13();
        }
        // Si la longueur n'est ni 10, ni 13, on sait déjà qu'il est faux
        return false;
    }

    // Test pour 10 caractères
    boolean check10() {
        // Somme des chiffres
        int sum = 0;
        // Pour les 9 premiers chiffres
        for (int i = 0; i < 9; i++) {
            // Récupération du ième chiffre
            String current = this.value.substring(i, i+ 1);
            // Si ça n'est pas un entier, l'ISBN est faux
            if (!current.matches("[0-9]")) {
                return false;
            }
            // Ajout à la somme du chiffre pondéré par sa position
            sum += Integer.valueOf(current) * (10 - i);
        }
        // Pour le dernier caractère
        String last = this.value.substring(9);
        // Si ça n'est pas un chiffre
        if (!last.matches("[0-9]")) {
            // X vaut dix
            if (last.equals("X")) {
                sum += 10;
            } else {
                // Sinon l'ISBN est invalide
                return false;
            }
        } else {
            // Si c'est un chiffre, on peut l'ajouter directement
            sum += Integer.valueOf(last);
        }
        // L'ISBN est valide si la somme pondérée est un multiple de 11
        return sum % 11 == 0;
    }

    // Test de validité sur 13 caractères
    boolean check13() {
        // S'il y a autre chose qu'un chiffre, c'est invalide
        if(!this.value.matches("[0-9]*")) {
            return false;
        }
        // Initialsation de la somme à 0
        int sum = 0;
        // Ajout des poids pondérés
        for (int i = 0; i < 13; i++) {
            // Le i % 2 == 0 correspond à la parité de l"indice et permet d'alterner entre les poids 1 et 3
            sum += Integer.valueOf(this.value.substring(i, i+ 1)) * ((i % 2 == 0) ? 1 : 3);
        }
        // L'ISBN est valide si la somme pondérée est un multiple de 10
        return sum % 10 == 0;
    }
}