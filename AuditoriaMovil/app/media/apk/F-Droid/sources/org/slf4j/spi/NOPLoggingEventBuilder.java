package org.slf4j.spi;
/* loaded from: classes2.dex */
public class NOPLoggingEventBuilder implements LoggingEventBuilder {
    static final NOPLoggingEventBuilder SINGLETON = new NOPLoggingEventBuilder();

    public static LoggingEventBuilder singleton() {
        return SINGLETON;
    }

    private NOPLoggingEventBuilder() {
    }
}
