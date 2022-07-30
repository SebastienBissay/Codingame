import java.util.*;

class Solution {
    // Tableau pour le crible d'Eratosthène
    // (https://fr.wikipedia.org/wiki/Crible_d%27%C3%89ratosth%C3%A8ne)
    static boolean[] sieve;

    // Construction du crible
    static void buildSieve(int n) {
        Solution.sieve = new boolean[n + 1];

        // Intialisation à true
        for (int i = 0; i <= n; i++)
            sieve[i] = true;
        // 1 n'est pas premier
        Solution.sieve[0] = false;
        // 2 n'est pas premier non plus (mais il faut vérifier d'abord que n >= 2)
        if (n > 1)
            Solution.sieve[1] = false;
        // Les nombres pairs autres que 2 ne sont pas premiers
        for (int i = 4; i <= n; i += 2) {
            Solution.sieve[i] = false;
        }
        // Pour les nombres impairs
        for (int i = 3; i * i <= n; i += 2) {
            // S'il est déjà marqué comme non premier, on passe au suivant
            if (!Solution.sieve[i])
                continue;
            // Sinon il est premier et on marque ses multiples comme non premiers
            for (int j = i * i; j <= n; j += i) {
                Solution.sieve[j] = false;
            }
        }
    }

    // Fonction récursive donnant le nombre dérivé d'un entier n
    static int derivedNumber (int n) {
        // La dérivée de 1 est 0
        if (n == 1) return 0;
        // Si le nombre est premier, sa dérivée vaut 1
        if (sieve[n]) return 1;
        // Sinon on cherche le premier couple (div, m) tel que n = m * div et div premier
        int m = n;
        int div = 1;
        for (int i = 2; i * i <= n; i++) {
            if (Solution.sieve[i] && n % i == 0) {
                div = i;
                m = n / div;
                break;
            }
        }
        // Retour via la définition récursive (n * m)' = n'*m + n * m'
        return Solution.derivedNumber(m) * div + m * Solution.derivedNumber(div);
    }

    public static void main(String args[]) {
        // Lecture de l'entier
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Construction du criible
        Solution.buildSieve(n);
        // Calcul et impression du résultat
        System.out.println(Solution.derivedNumber(n));
        in.close();
    }
}