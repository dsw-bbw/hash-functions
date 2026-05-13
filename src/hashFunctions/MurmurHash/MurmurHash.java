package hashFunctions.MurmurHash;

import java.util.Arrays;

public class MurmurHash {
    private static final int C1 = 0xcc9e2d51;
    private static final int C2 = 0x1b873593;

    private static final int SEED = 45;

    public static String hash(String key) {
        byte[] data = key.getBytes();
        int length = data.length;
        int seed = SEED;

        int i = 0;
        while (i + 4 <= length) {
            int n = get32BitNumber(Arrays.copyOfRange(data, i, i + 4));

            n *= C1;
            n = Integer.rotateLeft(n, 15);
            n *= C2;

            seed ^= n;
            seed = Integer.rotateLeft(seed, 13);
            seed = seed * 5 + 0xe6546b64;

            i += 4;
        }

        int remaining = 0;
        switch (length - i) {
            case 3: remaining ^= (data[i + 2] & 0xFF) << 16;
            case 2: remaining ^= (data[i + 1] & 0xFF) << 8;
            case 1: remaining ^= (data[i] & 0xFF);
            remaining *= C1;
            remaining = Integer.rotateLeft(remaining, 15);
            remaining *= C2;
            seed ^= remaining;
        }

        seed ^= length;
        seed ^= (seed >>> 16);
        seed *= 0x85ebca6b;
        seed ^= (seed >>> 13);
        seed *= 0xc2b2ae35;
        seed ^= (seed >>> 16);

        return String.valueOf(seed);
    }

    private static int get32BitNumber(byte[] data) {
        return  (data[0]     & 0xFF)
                | (data[1] & 0xFF) << 8
                | (data[2] & 0xFF) << 16
                | (data[3] & 0xFF) << 24;
    }
}