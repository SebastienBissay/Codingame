import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        //On initialiser la réponse au plus grand entier possible
        int answer = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);

        //Nombre de températures à analyser
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            //Lecture de la température en cours
            int t = in.nextInt();

            //La température actuelle et la plus proche ont même valeur absolue
            //mais signe différent
            if (answer == -t){
                //Le minimum devient la valeur absolue
                answer = Math.abs(t);
            }
            //Si la valeur absolue de la température est inférieure à la plus petite déjà croisée
            if (Math.abs(t) < Math.abs(answer)) {
                //Ca devient la nouvelle température minimale
                answer = t;
                
            }
        }

        //Si aucune valeur n'a été entrée on renvoie 0, sinon le min trouvé
        System.out.println(n == 0 ? 0 : answer);
    }
}