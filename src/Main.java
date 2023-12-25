import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        int nonce = 0;
        int numZeroes = 0; // Number of leading zeros required
        int counter = 0;
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");

            while (true) {
                String data = "Demo" + nonce;
                byte[] hash = md.digest(data.getBytes());

                // Count leading zeros
                int leadingZeros = countLeadingZeros(hash);

                // Check if more leading zeros found
                if (leadingZeros > numZeroes) {
                    numZeroes = leadingZeros;
                    System.out.println("\nNonce: " + nonce);
                    System.out.println("Hash: " + bytesToHex(hash));
                    System.out.println("Hash bits: " + bytesToBinary(hash));
                    System.out.println("Leading Zeros: " + numZeroes);
                    System.out.println("Iterations: " + counter);
                    System.out.println("\nSearching...");
                }

                nonce++;
                counter++;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static int countLeadingZeros(byte[] hash) {
        int count = 0;
        for (byte b : hash) {
            if (b == 0) {
                count += 8;
            } else {
                int mask = 0x80;
                while ((b & mask) == 0) {
                    count++;
                    mask >>= 1;
                }
                break;
            }
        }
        return count;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }



    private static String bytesToBinary(byte[] bytes) {
        StringBuilder binaryString = new StringBuilder();
        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                binaryString.append((b >> i) & 1);
            }
        }
        return binaryString.toString();
    }
}
