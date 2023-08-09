package p7coder;

public final class HashCoder {

    private HashCoder() {}

    public static int getHash(String password) {
        return password.hashCode();
    }
}
