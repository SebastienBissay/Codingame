import java.util.*;

class Solution {

    public static void main(String args[]) {

        Cube cube = new Cube();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        // Découpage des rotations via les espaces
        String[] rotations = in.nextLine().split(" ");
        String face1 = in.nextLine();
        String face2 = in.nextLine();

        // On effectue toutes les rotations
        for (String rotation : rotations) {
            cube.rotate(rotation);
        }

        // Impression des résultats
        System.out.println(String.valueOf(cube.getFace(face1)));
        System.out.println(String.valueOf(cube.getFace(face2)));
        in.close();
    }
}

// Interface fonctionnelle pour pouvoir décrire les lambda-expressions dans une Map
@FunctionalInterface
interface RotationCommand {
    void execute(Cube c);
}

class Cube {

    // Map des rotations (via des lambdas expressions) avec leurs commandes en String
    private Map<String, RotationCommand> commands = new HashMap<String, RotationCommand>() {
        {
            put("x", (c) -> {
                String tmp = c.faces.get("U");
                c.faces.replace("U", c.faces.get("F"));
                c.faces.replace("F", c.faces.get("D"));
                c.faces.replace("D", c.faces.get("B"));
                c.faces.replace("B", tmp);
            });
            // Une rotation anti-horaire, c'est 3 rotations horaires
            put("x'", (c) -> {
                for (int i = 0; i < 3; i++)
                    c.commands.get("x").execute(c);
            });
            put("y", (c) -> {
                String tmp = c.faces.get("F");
                c.faces.replace("F", c.faces.get("R"));
                c.faces.replace("R", c.faces.get("B"));
                c.faces.replace("B", c.faces.get("L"));
                c.faces.replace("L", tmp);
            });
            put("y'", (c) -> {
                for (int i = 0; i < 3; i++)
                    c.commands.get("y").execute(c);
            });
            put("z", (c) -> {
                String tmp = c.faces.get("U");
                c.faces.replace("U", c.faces.get("L"));
                c.faces.replace("L", c.faces.get("D"));
                c.faces.replace("D", c.faces.get("R"));
                c.faces.replace("R", tmp);
            });
            put("z'", (c) -> {
                for (int i = 0; i < 3; i++)
                    c.commands.get("z").execute(c);
            });
        }
    };

    // Map représentant les faces du cubes
    private Map<String, String> faces = new HashMap<String, String>() {
        {
            put("F", "F");
            put("B", "B");
            put("U", "U");
            put("D", "D");
            put("L", "L");
            put("R", "R");
        }
    };

    Cube() {
    }

    // Méthode permettant d'obtenir l'emplacement actuel d'une face donnée
    String getFace(String face) {
        for (Map.Entry<String, String> entry : faces.entrySet()) {
            if (face.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Méthode effectuant une rotation via son code
    void rotate(String rotation) {
        this.commands.get(rotation).execute(this);
    }
}