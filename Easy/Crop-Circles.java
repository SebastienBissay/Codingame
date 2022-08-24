import java.util.*;

class Solution {

    public static final int WIDTH = 19, HEIGHT = 25;
    private static String[][] field = new String[WIDTH][HEIGHT];

    // Création d'un champ entièrement planté
    private static void initialize() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                field[x][y] = "{}";
            }
        }
    }

    // Affichage d'un champ
    private static void printField(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(field[x][y]);
            }
            System.out.print("\n");
        }
    }

    // Méthode principale
    public static void main(String args[]) {
        // Création d'un champ "neuf"
        initialize();
        Scanner in = new Scanner(System.in);
        // Lecture des paramètres
        String[] instructions = in.nextLine().split(" ");
        in.close();

        // Application des instructions, l'une après l'autre
        for (String s : instructions) {
            parseOperation(s);
        }

        // Affichage de l'état final du champ
        printField();
    }

    // Application d'une opération à une case particulière du champ
    static void applyOperationToCell(Operation op, int x, int y) {
        // Si la case est hors du champ, on ne fait rien
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) {
            return;
        }
        // On applique l'opération correspondante
        switch (op) {
            case MOW:
                field[x][y] = "  ";
                break;
            case PLANT:
                field[x][y] = "{}";
                break;
            default:
                if (field[x][y].equals("  ")) {
                    field[x][y] = "{}";
                } else {
                    field[x][y] = "  ";
                }
        }
    }

    // Application d'une opération à un cercle
    static void applyOperation(Operation op, int centerX, int centerY, int diameter) {
        // Rayon = diamètre / 2.
        double radius = diameter / 2.;
        // Pour toutes les cases du carré contenant le cercle
        for (int x = (int) Math.floor(centerX - radius) ; x <= centerX + radius; x++) {
            for (int y = (int) Math.floor(centerY - radius) ; y <= centerY + radius; y++) {
                // Si la case est dans le cercle
                if ((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY) < radius * radius)
                // On applique l'opération
                applyOperationToCell(op, x, y);
            }
        }
    }

    // Fonction permettant de déchiffrer une instruction
    static void parseOperation(String instruction) {
        // L'opération de base est MOW
        Operation op = Operation.MOW;
        String instr = instruction;
        // Gestion des autres cas
        if (instruction.startsWith("PLANT")) {
            op = Operation.PLANT;
            instr = instr.substring(5);
            if (instr.startsWith("MOW")) {
                op = Operation.PLANTMOW;
                instr = instr.substring(3);
            }
        }

        // Récupération des coordonnées du cerle et de son diamètre
        int centerX = (int) instr.charAt(0) - (int) ('a');
        int centerY = (int) instr.charAt(1) - (int) ('a');
        instr = instr.substring(2);
        int diameter = Integer.parseInt(instr);

        // Application de l'opération
        applyOperation(op, centerX, centerY, diameter);
    }
}

// Enumération gérant les différentes actions possibles
enum Operation {
    MOW(""), PLANT("PLANT"), PLANTMOW("PLANTMOW");

    private Operation(String label) {
        this.label = label;
    }

    public String label;

    public String getLabel() {
        return label;
    }
}