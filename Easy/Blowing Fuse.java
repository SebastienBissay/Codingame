import java.util.*;

class Solution {

    public static void main(String args[]) {
        PowerLine powerLine;
        int maxConsumption = 0;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // Créatin d'une nouvelle ligne de n appareils
        powerLine = new PowerLine(n);
        int m = in.nextInt();
        int c = in.nextInt();
        for (int i = 0; i < n; i++) {
            int nx = in.nextInt();
            // Création d'un nouvel appareil de nx Watts sur la ligne
            powerLine.devices[i] = new Device(nx);
        }
        for (int i = 0; i < m; i++) {
            int mx = in.nextInt();
            // On opère sur l'interrupteur mx - 1 (indices commençant à 0)
            powerLine.devices[mx - 1].click();
            // On garde le maximum de consommation en mémoire
            maxConsumption = Integer.max(maxConsumption, powerLine.consumption());
        }
        in.close();

        // Si le maximum est supérieur à la capacité, ça a sauté
        if (maxConsumption > c) {
            System.out.println("Fuse was blown.");
        } else {
            // Sinon on peut donner les résultats
            System.out.println("Fuse was not blown.");
            System.out.println("Maximal consumed current was " + maxConsumption + " A.");
        }
    }
}

// Classe gérant un appareil
class Device {
    boolean status;
    int consumption;
    
    // Constructeur
    Device (int consumption) {
        this.consumption = consumption;
        // Tout démarrent éteint
        this.status = false;
    }

    // Changement du statut
    void click() {
        this.status = !this.status;
    }

    // La consommation est de 0 si éteint et de consumption si allumé
    int getConsumption() {
        return this.status ? this.consumption : 0;
    }
}

// Classe gérant la ligne électrique
class PowerLine {
    Device[] devices;

    // Constructeur
    PowerLine(int n) {
        devices = new Device[n];
    }

    // Calcul de la consommation à un instant t
    int consumption() {
        int consumption = 0;
        for (Device d : devices) {
            consumption += d.getConsumption();
        }
        return consumption;
    }
}