package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
/* loaded from: classes2.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {
    volatile boolean postInitialization = false;
    final Map loggers = new ConcurrentHashMap();
    final LinkedBlockingQueue eventQueue = new LinkedBlockingQueue();

    public LinkedBlockingQueue getEventQueue() {
        return this.eventQueue;
    }

    public void postInitialization() {
        this.postInitialization = true;
    }

    @Override // org.slf4j.ILoggerFactory
    public synchronized Logger getLogger(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = (SubstituteLogger) this.loggers.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.eventQueue, this.postInitialization);
            this.loggers.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    public List getLoggers() {
        return new ArrayList(this.loggers.values());
    }

    public void clear() {
        this.loggers.clear();
        this.eventQueue.clear();
    }
}
