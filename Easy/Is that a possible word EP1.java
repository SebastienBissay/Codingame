import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des données
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String states = in.nextLine();

        int numberOfTransitions = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Création des transitions
        ArrayList<Transition> transitions = new ArrayList<>();
        for (int i = 0; i < numberOfTransitions; i++) {
            String transition = in.nextLine();
            transitions.add(
                    new Transition(transition.substring(0, 1),
                            transition.substring(2, 3),
                            transition.substring(4, 5)));

        }
        String startState = in.nextLine();
        String endStates = in.nextLine();
        int numberOfWords = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Test mot par mot
        for (int i = 0; i < numberOfWords; i++) {
            String word = in.nextLine();
            String currentState = startState;
            for (int j = 0; j < word.length(); j++) {
                String currentChar = String.valueOf(word.charAt(j));
                // Boolean pour savoir si on a pu suivre une transition
                boolean hasMoved = false;
                // On parcourt les transition pour en trouver une valide
                for (Transition t : transitions) {
                    if (t.isValid(currentState, currentChar)) {
                        // Si on a trouvé une transition valide, on l'applique
                        hasMoved = true;
                        currentState = t.endState;
                        // et on peut sortir de la boucle
                        break;
                    }
                }

                // Si on n'a pas pu suivre une transition, le mot est invalide
                if (!hasMoved) {
                    currentState = "INVALID";
                    break;
                }
            }

            // Le mot est valide si l'état final est dans la liste des états finaux
            // autorisés
            System.out.println(endStates.contains(currentState));
        }
        in.close();
    }
}

// Classe gérant les transitions d'état
class Transition {
    String startState, endState;
    String rule;

    // Constructeur
    Transition(String startState, String rule, String endState) {
        this.startState = startState;
        this.rule = rule;
        this.endState = endState;
    }

    // Méthode retournant si une transition est valide ou non
    boolean isValid(String state, String str) {
        return (this.startState.equals(state) && rule.equals(str));
    }
}