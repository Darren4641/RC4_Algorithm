public class RC4_main {

    public static void main(String[] args) {
        String plainText = "Darren";
        String key = "keyRC4";
        RC4 rc4 = new RC4(plainText, key);

        String E = rc4.encryptionRC4(plainText);

        System.out.println("encryption : " + E);

        System.out.println("decryption : " + rc4.encryptionRC4(E));



    }

}
