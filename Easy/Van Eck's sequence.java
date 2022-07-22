import java.util.*;

class Solution {
    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        Integer next = in.nextInt();
        Sequence seq = new Sequence();
        int N = in.nextInt();

        // Ajout des N termes à la séquence
        for (int i = 0; i < N - 1; i++){
            next = seq.add(next);
        }

        // Impression du résultat
        System.out.println(next);
    }
}

// Classe gérant la séquence
class Sequence {
    // Map où l'on va stocker la position de la dernière occurrence d'une valeur
    HashMap<Integer, Integer> past = new HashMap<>();
    int size = 0;

    // Constructeur
    Sequence() {}

    // Ajout de valeur
    void addIntern(Integer i) {
        this.size++;
        this.past.put(i, this.size);
    }

    // Ajout d'un terme
    Integer add(Integer i) {
        int s = this.size + 1;
        // Si le terme est déjà présent, on récupère sa position
        if (this.past.containsKey(i)) {
            s = this.past.get(i);
        }
        this.addIntern(i);
        // Vaut 0 si le terme n'était pas présent grâce à l'initialisation de s
        return this.size - s;
    }
}