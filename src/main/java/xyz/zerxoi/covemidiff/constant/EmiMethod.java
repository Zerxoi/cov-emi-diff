package xyz.zerxoi.covemidiff.constant;

import org.springframework.lang.Nullable;

public enum EmiMethod {
    PRE(0, "pre"),
    POST(1, "post");

    private static final EmiMethod[] VALUES;

    static {
        VALUES = values();
    }

    private final int value;
    private final String desc;

    EmiMethod(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    @Nullable
    public static EmiMethod resolve(int value) {
        // Use cached VALUES instead of values() to prevent array allocation.
        for (EmiMethod method : VALUES) {
            if (method.value == value) {
                return method;
            }
        }
        return null;
    }

    public static EmiMethod valueOf(int value) {
        EmiMethod method = resolve(value);
        if (method == null) {
            throw new IllegalArgumentException("No matching method for [" + value + "]");
        }
        return method;
    }
}