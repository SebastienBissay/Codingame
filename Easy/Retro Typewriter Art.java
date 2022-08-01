import java.util.*;

class Solution {

    public static void main(String args[]) {

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        // Découpage en instructions via les espaces
        String[] instructions = line.split(" ");
        // Pour chaque intruction
        for (String instr : instructions) {
            // Retour ligne
            if (instr.equals("nl")) {
                System.out.println();
                continue;
            }
            String value;
            int number;
            // Cas espace
            if (instr.endsWith("sp")) {
                value = " ";
                number = Integer.parseInt(instr.substring(0, instr.length() - 2));
            } else if (instr.endsWith("bS")) {
                // Cas backslash
                value = "\\";
                number = Integer.parseInt(instr.substring(0, instr.length() - 2));
            } else if (instr.endsWith("sQ")) {
                // Cas apostrophe
                value = "'";
                number = Integer.parseInt(instr.substring(0, instr.length() - 2));
            } else {
                // Cas géénral
                value = String.valueOf(instr.charAt(instr.length() - 1));
                number = Integer.parseInt(instr.substring(0, instr.length() - 1));
            }
            // Ajout de la chaîne valuer number fois
            System.out.print(value.repeat(number));
        }
        in.close();
    }
}