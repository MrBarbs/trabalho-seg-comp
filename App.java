import aes.AES;

public class App {
    public static void main(String[] args) {
        // get message
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tristique magna id sodales porttitor. Nunc ut orci ullamcorper, cursus tellus nec, ultrices dolor. Suspendisse sagittis risus finibus biam.";
        String key = "SCNV9LhZKzQ9uIkqiOh5MnMqiGW3aWepAXATlUVBDpOzNwb4jTb2gUkGMuawEmRw96DpCF4fZRCozwtjQ0QgUHQy7hvROGBAXoy0A5OfWp0KzGzSTC9b7jM74AeFSOEd";

        AES aes = new AES(message, key);

        String cryptedMessage = aes.encrypt();

        System.out.println("CryptedMessage:\n" + cryptedMessage);

    }

    public static void print2D(byte mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
                if (j % 4 == 3) {
                    System.out.println();
                }
            }
    }
}
