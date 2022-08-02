import java.util.*;

class Solution {

    // Méthode de classe permetttant d'enlever la virgule si non nécessaire
    static String format(Double d) {
        if (d == Math.floor(d)) return String.valueOf((int) Math.floor(d));
        return String.valueOf(d);
    }

    public static void main(String args[]) {

        // Stockage des records par athlete
        HashMap<String, Record> records = new HashMap<>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);

        // Liste des gymnastes, découpée par ,
        String[] gymnasts = in.nextLine().split(",");

        // Liste des catégories, découpée par ,
        String[] categories = in.nextLine().split(",");

        // Passage à la ligne suivante
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Lecture des résultats de compétition et stockage 
        for (int i = 0; i < N; i++) {
            String[] row = in.nextLine().split(",");
            String name = row[0];
            if (!records.containsKey(name)) {
                records.put(name, new Record());
            }
            records.get(name).enterRecord(Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3]));
        }

        // Pour chaque gymnaste dont on veut les résultats
        for (String gym : gymnasts) {
            Record rec = records.get(gym);
            // Pour chaque catégorie dont on veut les résultats
            for (int i = 0; i < categories.length; i++) {
                String cat = categories[i];
                // On imprime le résultat
                System.out.print(Solution.format(rec.records.get(cat)));
                // S'il en reste, on ajoute une virgule
                if (i < categories.length - 1) {
                    System.out.print(",");
                }
            }
            // Changement de ligne entre chaque gymnaste
            System.out.print("\n");
        }
        in.close();
    }
}


// Classe gérant les records d'une gymnaste
class Record{

    // Stockage dans une map
    Map<String, Double> records = new HashMap<String, Double>();

    // On garde à chaque fois le maximum entre le record existant et la nouvelle valeur
    void enterRecord(double bars, double beam, double floor) {
        this.records.put("bars", Double.max(this.records.getOrDefault("bars", 0.D), bars));
        this.records.put("beam", Double.max(this.records.getOrDefault("beam", 0.D), beam));
        this.records.put("floor", Double.max(this.records.getOrDefault("floor", 0.D), floor));
    }
}