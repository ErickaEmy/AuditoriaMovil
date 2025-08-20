package javax.jmdns.impl.constants;
/* loaded from: classes.dex */
public abstract class DNSConstants {
    public static final int ANNOUNCED_RENEWAL_TTL_INTERVAL;
    public static final int DNS_TTL;
    public static final int MDNS_PORT = Integer.getInteger("net.mdns.port", 5353).intValue();

    static {
        int intValue = Integer.getInteger("net.dns.ttl", 3600).intValue();
        DNS_TTL = intValue;
        ANNOUNCED_RENEWAL_TTL_INTERVAL = intValue * 500;
    }
}
