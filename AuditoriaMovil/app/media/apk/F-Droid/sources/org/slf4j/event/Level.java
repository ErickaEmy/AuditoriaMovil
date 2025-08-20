package org.slf4j.event;
/* loaded from: classes2.dex */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");
    
    private final int levelInt;
    private final String levelStr;

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }

    Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }
}
