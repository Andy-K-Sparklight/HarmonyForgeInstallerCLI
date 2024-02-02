package rarityeg.alicorn;

public class Util {
    public static boolean wantClass(String[] clazz) {
        try {
            for (String c : clazz) {
                Class.forName(c);
            }
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
