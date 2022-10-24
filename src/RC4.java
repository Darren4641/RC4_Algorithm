public class RC4 {
    public static final int BYTE_SIZE = 256;
    int[] init;
    byte[] keyArray;
    String plainText;
    String key;

    public RC4(String plainText, String key) {
        init = new int[BYTE_SIZE];
        keyArray = new byte[BYTE_SIZE];
        this.plainText = plainText;
        this.key = key;

    }

    public String encryptionRC4(String plainText) {
        initArray(init, keyArray, key);
        swapping(init, keyArray);
        return encryption(plainText);
    }

    private void initArray(int[] init, byte[] swap, String key) {
        for(int i = 0; i < BYTE_SIZE; i++) {
            init[i] = i;
            swap[i] = (byte) key.charAt(i % key.length());
        }
    }

    private void swapping(int[] init, byte[] swap) {
        int j = 0;
        for(int i =0; i < BYTE_SIZE; i++) {
            j = (j + init[i] + swap[i]) % BYTE_SIZE;
            swap(init, i, j);
        }
    }

    private void swap(int[] init, int i, int j) {
        int temp = init[i];
        init[i]=init[j];
        init[j]=temp;
    }

    private String encryption(String plainText) {
        char[] input = plainText.toCharArray();
        char[] keyStream = new char[input.length];
        int i = 0;
        int j = 0;
        for(int cnt = 0; cnt < plainText.length(); cnt++) {
            i = (i + 1) % BYTE_SIZE;
            j = (j + init[i]) % BYTE_SIZE;
            swap(init, i, j);

            int t = (init[i] + init[j]) % BYTE_SIZE;
            char stream = (char)init[t];
            keyStream[cnt] = (char) (input[cnt] ^ stream);

        }
        return new String(keyStream);
    }


}


