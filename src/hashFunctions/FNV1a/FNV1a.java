package hashFunctions.FNV1a;

public class FNV1a {
    private static final int OFFSET = 0x811c9dc5;

    public static String hash(String key) {
        byte[] data = key.getBytes();
        int hash = OFFSET;

        for (byte b : data) {
            hash ^= (b & 0xFF);
            hash *= 0x01000193;
        }

        return Integer.toUnsignedString(hash);
    }
}