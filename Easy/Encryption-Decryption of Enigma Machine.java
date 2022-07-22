import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Création des 3 rotors
        Rotor r1, r2, r3;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Initialisation des rotors
        r1 = new Rotor(in.nextLine());
        r2 = new Rotor(in.nextLine());
        r3 = new Rotor(in.nextLine());

        String message = in.nextLine();
        in.close();

        // Initialisation de la réponse et d'un stockage temporaire
        String answer = "";
        String str = "";
        // Encodage
        if (operation.equals("ENCODE")) {
            // On encode message via chiffrement de César dans str
            for (int i = 0; i < message.length(); i++) {
                Rotor r = new Rotor(pseudoRandomNumber + i);
                str += r.encode(message.charAt(i));
            }
            
            // On encode str via le rotor 1 dans answer
            for (int i = 0; i < str.length(); i++) {
                answer += r1.encode(str.charAt(i));
            }

            // On encode answer via le rotor 2 dans str
            str = "";
            for (int i = 0; i < answer.length(); i++) {
                str += r2.encode(answer.charAt(i));
            }

            // On encode str via le rotor 3 dans answer
            answer = "";
            for (int i = 0; i < str.length(); i++) {
                answer += r3.encode(str.charAt(i));
            }
        } else {
            // Décodage
            // On décode message via le rotor 3 dans str
            for (int i = 0; i < message.length(); i++) {
                str += r3.decode(message.charAt(i));
            }

            // On décode str via le rotor 2 dans answer
            for (int i = 0; i < str.length(); i++) {
                answer += r2.decode(str.charAt(i));
            }

            // On décode answer via le rotor 1 dans str
            str = "";
            for (int i = 0; i < answer.length(); i++) {
                str += r1.decode(answer.charAt(i));
            }

            // On décode str via le chiffrement de César dans answer
            answer = "";
            for (int i = 0; i < str.length(); i++) {
                Rotor r = new Rotor(pseudoRandomNumber + i);
                answer += r.decode(str.charAt(i));
            }
        }

        // Impression de la réponse
        System.out.println(answer);
    }
}

// Classe gérant un rotor
class Rotor {
    // Constante contenant l'alphabet
    final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String position;

    // Constructeur à partir d'une string
    public Rotor(String position) {
        this.position = position;
    }

    // Constructeur à partir d'un entier
    public Rotor(int n) {
        this.position = ALPHABET.substring(n % 26) + ALPHABET.substring(0, n % 26);
    }

    // Méthode encodant un caractère
    char encode(char c) {
        return position.charAt(ALPHABET.indexOf(c));
    }

    // Méthode décodant un caractère
    char decode(char c) {
        return ALPHABET.charAt(position.indexOf(c));
    }
}