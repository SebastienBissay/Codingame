import java.util.*;

class Solution {

    public static void main(String args[]) {
        ArrayList<Arrow> arrows = new ArrayList<>();

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        //Création des flèches
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            for (int j = 0; j < W; j++) {
                if (line.charAt(j) != '.') {           
                    arrows.add(new Arrow(j, i, line.charAt(j)));
                }
            }
        }
        in.close();

        // Initialisation du compteur
        int counter = 0;

        //Tant qu'il y a encore des flèches
        while(arrows.size() > 0) {
            counter++;
            // On fait bouger toutes les flèches
            for (Arrow arrow : arrows) {
                arrow.move(W, H);
            }

            // On regarde sur des flèches collisionnent
            for (int i = 0; i < arrows.size(); i++) {
                Arrow current = arrows.get(i);
                boolean hasCollided = false;
                for (int j = arrows.size() - 1; j > i; j--) {
                    Arrow next = arrows.get(j);
                    if (current.x == next.x && current.y == next.y) {
                        hasCollided = true;
                        arrows.remove(j);
                    }
                }
                // On retire 
                if (hasCollided) {
                    arrows.remove(i);
                    i--;
                }
            }
        }
        System.out.println(counter);
    }
}

// Classe gérant une flèche
class Arrow
{
    // Position de la flèche
    int x, y;
    // Direction de mouvement de la flèche
    int vx, vy;

    // Constructeur
    Arrow(int x, int y, char d) {
        this.x = x;
        this.y = y;
        // Suivant le caractère, on définit la direction
        switch (d) {
            case '^' :
                this.vy = -1;
                this.vx =0;
                break;
            case 'v' :
                this.vy = 1;
                this.vx =0;
                break;
            case '<' :
                this.vx = -1;
                this.vy =0;
                break;
            case '>' :
                this.vx = 1;
                this.vy =0;
                break;
        }
    }

    // Mouvement de la flèche
    void move(int width, int height) {
        this.x += vx;
        this.y += vy;

        // Si on atteint un bord, on fait le tour
        if (this.x < 0) this.x = width - 1;
        if (this.x == width) this.x = 0;
        if (this.y < 0) this.y = height - 1;
        if (this.y == height) this.y = 0;
    }
}