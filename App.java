import aes.AES;

public class App {
    public static void main(String[] args) {
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tristique magna id sodales porttitor. Nunc ut orci ullamcorper, cursus tellus nec, ultrices dolor. Suspendisse sagittis risus finibus biam.";
        String key = "SCNV9LhZKzQ9uIkqiOh5MnMqiGW3aWepAXATlUVBDpOzNwb4jTb2gUkGMuawEmRw96DpCF4fZRCozwtjQ0QgUHQy7hvROGBAXoy0A5OfWp0KzGzSTC9b7jM74AeFSOEd";

        AES aes = new AES(message);

        aes.getKey();

        aes.encrypt();
        // System.out.println("CryptedMessage:\n" + cryptedMessage);

    }
}
