package kellinwood.logging;

import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public abstract class LoggerManager {
    static LoggerFactory factory = new NullLoggerFactory();
    static Map loggers = new TreeMap();

    public static LoggerInterface getLogger(String str) {
        LoggerInterface loggerInterface = (LoggerInterface) loggers.get(str);
        if (loggerInterface == null) {
            LoggerInterface logger = factory.getLogger(str);
            loggers.put(str, logger);
            return logger;
        }
        return loggerInterface;
    }
}
