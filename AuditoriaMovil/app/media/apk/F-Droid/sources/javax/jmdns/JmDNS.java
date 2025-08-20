package javax.jmdns;

import java.io.Closeable;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.impl.JmDNSImpl;
/* loaded from: classes.dex */
public abstract class JmDNS implements Closeable {
    public static String VERSION;

    /* loaded from: classes.dex */
    public interface Delegate {
    }

    public abstract void addServiceListener(String str, ServiceListener serviceListener);

    public abstract void registerService(ServiceInfo serviceInfo);

    public abstract void unregisterAllServices();

    public abstract void unregisterService(ServiceInfo serviceInfo);

    static {
        try {
            InputStream resourceAsStream = JmDNS.class.getClassLoader().getResourceAsStream("version.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            VERSION = properties.getProperty("jmdns.version");
            resourceAsStream.close();
        } catch (Exception unused) {
            VERSION = "VERSION MISSING";
        }
    }

    public static JmDNS create(InetAddress inetAddress) {
        return new JmDNSImpl(inetAddress, null);
    }
}
