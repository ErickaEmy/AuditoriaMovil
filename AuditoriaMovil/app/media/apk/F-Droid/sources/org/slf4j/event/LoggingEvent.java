package org.slf4j.event;

import java.util.List;
/* loaded from: classes2.dex */
public interface LoggingEvent {
    Object[] getArgumentArray();

    Level getLevel();

    List getMarkers();

    String getMessage();

    Throwable getThrowable();
}
