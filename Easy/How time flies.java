import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class Solution {

    public static void main(String args[]) {
        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        String BEGIN = in.next();
        String END = in.next();

        // Découpage et parsing des dates
        String[] str = BEGIN.split("[.]");
        LocalDate beginDate = LocalDate.parse(str[2] + "-" + str[1] + "-" + str[0]);
        str = END.split("[.]");
        LocalDate endDate = LocalDate.parse(str[2] + "-" + str[1] + "-" + str[0]);
        in.close();

        // Calcl de la différence entre les dates
        Period diff = beginDate.until(endDate);

        // Création de la réponse
        String answer = "";
        if (diff.getYears() > 0) {
            // Si la différence contient des années, on les met dans la réponse
            answer += diff.getYears() + " year" + (diff.getYears() > 1 ? "s" : "") + ", ";
        }
        if (diff.getMonths() > 0) {
            // Si la différence contient des mois, on les met dans la réponse
            answer += diff.getMonths() + " month" + (diff.getMonths() > 1 ? "s" : "") + ", ";
        }
        // On met les jours dans la réponse
        answer += "total " + beginDate.until(endDate, ChronoUnit.DAYS) + " days";

        // Impression de la réponse
        System.out.println(answer);
    }
}