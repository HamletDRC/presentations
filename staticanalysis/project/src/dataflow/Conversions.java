package dataflow;



class Conversions {

    public static int toInt(String value) {
        return Integer.valueOf(value);
    }

    public static int toInt(Float left) {
        return left.intValue();
    }
}
