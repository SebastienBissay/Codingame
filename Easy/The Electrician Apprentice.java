import java.util.*;

class Solution {

    public static void main(String args[]) {
        Circuit circuit = new Circuit();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < c; i++) {
            String wiring = in.nextLine();
            circuit.addEquipment(wiring);
        }
        int a = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // On appuie sur les interrupteurs en suivant les instructions
        for (int i = 0; i < a; i++) {
            String swtch = in.nextLine();
            circuit.toggleSwitch(swtch);
        }

        // Et on regarde l'état du circuit
        circuit.compute();
        in.close();
    }
}


// Classe gérant un interrupteur
class Switch {
    boolean status;

    Switch() {
        status = false;
        // Tout démarre éteint
    }

    // Changement de statut
    void toggle() {
        status = !status;
    }
}


// Classe gérant un équipement
class Equipment {
    String name, wiring;

    // Constructeur
    Equipment(String name, String wiring) {
        this.name = name;
        this.wiring = wiring;
    }

    // Fonction renvoyant l'état d'un équipement selon la configuration des interrupteurs
    void compute(HashMap<String, Switch> switches) {
        // On part d'un circuit fermé (le courant passe)
        boolean state = true;
        // Découpage des instructions selon les espaces
        String[] instructions = wiring.split(" ");
        int index = 0;
        // Parcours de l'ensemble des instructions
        while (index < instructions.length) {
            // Cas en série
            if (instructions[index].equals("-")) {
                boolean cur = true;
                // Tant qu'on reste sur cette maille
                while (++index < instructions.length && !instructions[index].matches("[=-]")) {
                    // Le circuit reste fermé si tout est fermé
                    cur = cur && switches.get(instructions[index]).status;
                }
                state = state && cur;
            }

            // Si on a atteint la fin des instructions, on peut s'arrêter
            if (index == instructions.length) break;

            // Cas en parallèle
            if (instructions[index].equals("=")) {
                boolean cur = false;
                while (++index < instructions.length && !instructions[index].matches("[=-]")) {
                    // Le circuit reste fermé si une branche est fermée
                    cur = cur || switches.get(instructions[index]).status;
                }
                state = state && cur;
            }
        }

        // Impression du résultat pour cet équipement
        System.out.println(this.name + " is " + (state ? "ON" : "OFF"));
    }
}

// Classe gérant le circuit complet
class Circuit {
    HashMap<String, Switch> switches;
    ArrayList<Equipment> equipments;

    // Constructeur
    Circuit () {
        switches = new HashMap<>();
        equipments = new ArrayList<>();
    }

    // Changement d'état d'un interrupteur
    void toggleSwitch(String name)
    {
        switches.get(name).toggle();
    }

    // Ajout d'un équipement
    void addEquipment(String line) {
        // Extraction du nom de l'équipement : du début jusqu'au premier espace
        String name = line.substring(0, line.indexOf(" "));
        // Extraction du schéma électrique de l'équipement : du premier espace jusqu'à la fin
        String wiring = line.substring(line.indexOf(" ") + 1);
        equipments.add(new Equipment(name, wiring));

        // Extraction des noms des interrupteurs
        // On supprime tous les '=' et '-'
        wiring = wiring.replaceAll("[=-] ", "");
        // On découpe sur les espaces
        String[] swit = wiring.split(" ");
        for (String s : swit) {
            // Si l'interrupteur n'existe pas déjà dans la HashMap, on l'y ajoute
            if(!switches.containsKey(s)) {
                switches.put(s, new Switch());
            }
        }   
    }

    // Méthode donnant l'état de chaque équipement une fois l'état final de chaque interrupteur connu
    void compute() {
        for (Equipment e : equipments) {
            e.compute(this.switches);
        }
    }
}