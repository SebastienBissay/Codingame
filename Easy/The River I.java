import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        in.close();

        // Initialisation des deux rivières
        River riv1 = new River(r1);
        River riv2 = new River(r2);

        // Check de fin
        boolean isOver = false;

        // Tant qu'on n'a pas trouvé le point de rencontre
        while(!isOver) {
            // On récupère les derniers éléments des deux rivières
            Long l1 = riv1.value;
            long l2= riv2.value;

            // En cas d'égalité, on a trouvé
            if (l1 == l2) break;

            // Si le dernier élément de la rivière 1 est inférierur à celui de la rivière 2
            if (l1 < l2) {
                // C'est à la rivière 1 qu'on ajoute des éléments
                riv1.computeNext();
            } else {
                // Sinon c'est à la rivière 2 qu'on ajoute des éléments
                riv2.computeNext();
            }
        }

        // Impression du résultat
        String answer = String.valueOf(riv1.value);
        System.out.println(answer);
    }
}

// Classe gérant une rivière
class River
{
    Long value;

    // Constructeur
    River (Long start) {
        this.value = start;
    }

    // Méthode pour calculer l'élément suivant de la rivière
    void computeNext(){
        // On récupère le dernier élément de la rivière
        Long next = this.value;
        // On en fait une chaîne de caractères
        String s = String.valueOf(next);
        // Pour chaque chiffre, on l'ajoute au prochain élément
        for (int i = 0; i < s.length(); i++)
        {
            next += Long.parseLong(String.valueOf(s.charAt(i)));
        }
        // On peut enfin insérer le prochain élément
        this.value = next;
    }
}