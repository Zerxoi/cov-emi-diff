package xyz.zerxoi.covemidiff.constant;

import org.springframework.lang.Nullable;

public enum EmiStatus {
    ERROR(0, "error"),
    DIFF(1, "diff");

    private static final EmiStatus[] VALUES;

    static {
        VALUES = values();
    }

    private final int value;
    private final String desc;

    EmiStatus(int value, String desc) {
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
    public static EmiStatus resolve(int value) {
        // Use cached VALUES instead of values() to prevent array allocation.
        for (EmiStatus status : VALUES) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

    public static EmiStatus valueOf(int value) {
        EmiStatus status = resolve(value);
        if (status == null) {
            throw new IllegalArgumentException("No matching status for [" + value + "]");
        }
        return status;
    }
}