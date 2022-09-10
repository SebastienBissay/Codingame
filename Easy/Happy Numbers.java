import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String x = in.nextLine();
            // Création du nombre correspondant à l'entrée
            Number n = new Number(x);
            // Impression du nombre
            n.print();
        }
        // Clôture du flux de lecture
        in.close();
    }
}

// Classe gérant un nombre
class Number {
    // Nombre potentiellement très grand (contrainte : n <= 10^26)
    BigInteger value;
    // On part du principe que le nombre est happy
    boolean isHappy = true;

    // Constructeur à partir d'une string
    Number(String value) {
        // Converstion de la string en BigInteger
        this.value = new BigInteger(value);
        // Calcul de la "happyness" du nombre
        this.computeHappyness();
    }

    // Méthode calculant si un nombre est happy
    void computeHappyness(){
        // On crée un HashSet des nombres déjà vus
        HashSet<BigInteger> seenValues = new HashSet<>();
        // On initialise n à value
        BigInteger n = this.value;
        // On sait que ça s'arrête à 1
        // 7 est aussi une bonne condition d'arrêt :
        // 7 -> 49 -> 16 + 81 = 97 -> 81 + 49 = 130 -> 1 + 9 = 10 -> 1
        while (!n.equals(new BigInteger("1")) && !n.equals(new BigInteger("7"))) {
            // On ajoute n aux valeurs déjà vues (pour détecter les boucles)
            seenValues.add(n);
            // n devient le prochain élément selon l'algorithme des nombres happy
            n = nextStep(n);
            // Si n a déjà été croisé, value n'est pas happy
            if (seenValues.contains(n)) {
                isHappy = false;
                break;
            }
        }
    }

    // Calcul de la somme des chiffres composants un nombre
    BigInteger nextStep(BigInteger n){
        // Initialisation de la somme à 0
        BigInteger s = new BigInteger("0");
        // Tant que n > 0
        while (n.compareTo(new BigInteger("0")) > 0) {
            // On prend le dernier chiffre via un modulo 10
            BigInteger d = n.mod(new BigInteger("10"));
            // On ajoute son carré à la somme
            s = s.add(d.pow(2));
            // On divise n par 10 (sans garder le reste)
            n = n.divide(new BigInteger("10"));
        }
        return s;
    }

    // Impression du nombre
    void print(){
        // On imprime la valeur suivie du smiley correspondant
        System.out.println(this.value.toString() + " :" + (this.isHappy ? ")" : "("));
    }
}