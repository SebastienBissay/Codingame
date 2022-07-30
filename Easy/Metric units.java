import java.util.*;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();

        // Parsing pour récupérer les distances
        String str1 = expression.substring(0, expression.indexOf(" "));
        String str2 = expression.substring(expression.lastIndexOf(" ") + 1);

        // Construction des distances
        Distance d1 = new Distance(str1);
        Distance d2 = new Distance(str2);
        // Récupération de l'unité la plus petite
        Unit minUnit = d1.getMinUnit(d2);
        // Conversion dans cette unité
        d1.convertTo(minUnit);
        d2.convertTo(minUnit);

        String answer;
        // Gestion de la somme avec l'affichage de virgule ou non
        if (Math.floor(d1.value + d2.value) == d1.value + d2.value) {
            answer = String.valueOf((int) Math.floor(d1.value + d2.value));
        } else {
            answer = String.valueOf(d1.value + d2.value);
        }
        // Affichage avec l'unité minimale
        System.out.println(answer + minUnit.name);
        in.close();
    }
}

// Classe gérant une distance (valeur et unité)
class Distance {
    float value;
    Unit unit;

    // Constructeur à partir d'une String
    Distance(String str) {
        // Recherche de l'index de fin de valeur numérique dans la String
        int index = 0;
        while(String.valueOf(str.charAt(index)).matches("[\\d.]")) {
            index++;
        }
        // Parsing de la valeur numérique en valeur
        this.value = Float.valueOf(str.substring(0, index));
        // Parsing de l'unité
        String s = str.substring(index);
        // Via comparaison avec les unités de l'enum Unit
        for (Unit u : Unit.values()) {
            if (s.equals(u.name)) {
                this.unit = u;
                break;
            }
        }
    }

    // Récupération de l'unité la plus petite entre deux distances
    Unit getMinUnit(Distance d) {
        if (this.unit.compare(d.unit) <= 0) return this.unit;
        return d.unit;
    }

    // Conversion vers une nouvelle unité
    void convertTo(Unit unit) {
        this.value *= this.unit.multiplier / unit.multiplier;
    }
}

// Ensemble des unités uitilisées, avec leurs noms et le multiplicateur à appliquer pour les conversions
enum Unit{
    UM(1, "um"),
    MM(1000, "mm"),
    CM(10000, "cm"),
    DM(100000, "dm"),
    M( 1000000, "m"),
    KM(1000000000, "km");

    // Attributs
    int multiplier;
    String name;

    // Constructeur
    private Unit(int multiplier, String name) {
        this.multiplier = multiplier;
        this.name = name;
    }

    // Comparateur d'unités : négatif si l'unité courante est plus petite, positif si elle esty plus grande, 0 si c'est la même
    public int compare(Unit u) {
        return Integer.compare(this.multiplier, u.multiplier);
    }
}