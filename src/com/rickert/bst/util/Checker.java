package com.rickert.bst.util;

public class Checker {

    public static boolean isConvertible(Object converter) {
        return converter instanceof Integer || converter instanceof Double || converter instanceof Float ||
                converter instanceof Character || converter instanceof Short || converter instanceof Byte ||
                converter instanceof Long;
    }

    public static float getFloat(Object value) {
        if (value instanceof Integer) {
            return (float) (int) value;
        } else if (value instanceof Double) {
            return (float) (double) value;
        } else if (value instanceof Float) {
            return (float) value;
        } else if (value instanceof Character) {
            return (float) (char) value;
        } else if (value instanceof Short) {
            return (float) (short) value;
        } else if (value instanceof Byte) {
            return (float) (byte) value;
        } else {
            return (float) (long) value;
        }
    }
}
