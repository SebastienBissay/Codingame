import java.util.*;

class Solution {

    public static void main(String args[]) {
        Grid grid;

        // Lecture des paramètres
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        // Initilisation de la grille maintenant que sa taille est connue
        grid = new Grid(W, H);
        int x = in.nextInt();
        int y = in.nextInt();
        // Remplissage de la grille
        for (int i = 0; i < H; i++) {
            String line = in.next();
            grid.addLine(i, line);
        }

        // Exécution de la méthode de résolution de la grille
        System.out.println(grid.compute(x, y));
        in.close();
    }
}


// Classe décrivant une flèche
class Arrow {

    // Direction : ^v<>
    char direction;

    // Constructeur
    Arrow(char direction) {
        this.direction = direction;
    }

    // Méthode de rotation dans le sens horaire
    void rotate() {
        switch (this.direction) {
            case '>':
                this.direction = 'v';
                break;
            case 'v':
                this.direction = '<';
                break;
            case '<':
                this.direction = '^';
                break;
            case '^':
                this.direction = '>';
        }
    }

    // Renvoie de combien la flèche nous fait bouger horizontalement
    int horizontalMove() {
        if (this.direction == '>')
            return 1;
        if (this.direction == '<')
            return -1;
        return 0;
    }

    // Renvoie de combien la flèche nous fait bouger verticalement
    int verticalMove() {
        if (this.direction == '^')
            return -1;
        if (this.direction == 'v')
            return 1;
        return 0;
    }
}


// Classe décrivant une grille
class Grid {
    int width, height;
    Arrow[][] arrows;

    // Constructeur
    Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.arrows = new Arrow[width][height];
    }

    // Ajout d'une ligne via son ordonnée et une String
    void addLine(int y, String line) {
        // On va lire l"ensemble de la String et l'intégrer en tant que flèches
        for (int x = 0; x < this.width; x++) {
            this.arrows[x][y] = new Arrow(line.charAt(x));
        }
    }

    // Méthode principale, effectuant les rotations et renvoyant le nombre de rotations effectuées
    int compute(int x0, int y0) {
        // Intialisation du comteur de rotations
        int counter = 0;
        // Flèche de départ passée en paramètres
        int x = x0, y = y0;

        // Condition d'arrêt : sortir de la grille
        while (x >= 0 && x < this.width && y >= 0 && y < this.height) {
            // Incrémentation du compteur
            counter++;
            // Rotation de la flèche courante
            arrows[x][y].rotate();
            
            // Récupération des modifications de coordonnées induites par la flèche courante
            int dx = arrows[x][y].horizontalMove();
            y += arrows[x][y].verticalMove();
            x += dx;

            // Si on est revenu à la flèche de départ, on s'arrête
            if (x == x0 && y == y0) {
                break;
            }
        }

        // Retour du nombre d'itérations
        return counter;
    }
}