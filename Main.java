import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int n = scanner.nextInt();
            int k = scanner.nextInt();

            Map<Integer, Integer> shares = new HashMap<>();
            while (scanner.hasNext()) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                shares.put(index, value);
            }
            scanner.close();

            // Ensure we have enough shares to reconstruct the secret
            if (shares.size() < k) {
                System.out.println("Not enough shares to reconstruct the secret.");
                return;
            }

            // Reconstruct the secret
            int secret = interpolate(shares);

            System.out.println("The reconstructed secret is: " + secret);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int interpolate(Map<Integer, Integer> shares) {
        int prime = 257; // Prime number chosen arbitrarily
        int result = 0;

        for (Map.Entry<Integer, Integer> share : shares.entrySet()) {
            int term = share.getValue();
            for (Map.Entry<Integer, Integer> otherShare : shares.entrySet()) {
                if (!otherShare.getKey().equals(share.getKey())) {
                    int numerator = -otherShare.getKey();
                    int denominator = share.getKey() - otherShare.getKey();
                    term = (term * numerator * modInverse(denominator, prime)) % prime;
                }
            }
            result = (result + term + prime) % prime;
        }
        return result;
    }

    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // If modInverse does not exist
    }
}
