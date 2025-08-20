package javax.jmdns.impl;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;
import javax.jmdns.impl.tasks.DNSTask;
import javax.jmdns.impl.util.ByteWrangler;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes.dex */
public class ServiceInfoImpl extends ServiceInfo implements DNSListener, DNSStatefulObject {
    private static Logger logger = LoggerFactory.getLogger(ServiceInfoImpl.class.getName());
    private String _application;
    private String _domain;
    private final Set _ipv4Addresses;
    private final Set _ipv6Addresses;
    private transient String _key;
    private String _name;
    private boolean _needTextAnnouncing;
    private boolean _persistent;
    private int _port;
    private int _priority;
    private Map _props;
    private String _protocol;
    private String _server;
    private final ServiceInfoState _state;
    private String _subtype;
    private byte[] _text;
    private int _weight;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void _setText(byte[] bArr) {
        this._text = bArr;
        this._props = null;
    }

    @Override // javax.jmdns.ServiceInfo
    public String getApplication() {
        String str = this._application;
        return str != null ? str : "";
    }

    @Override // javax.jmdns.ServiceInfo
    public String getDomain() {
        String str = this._domain;
        return str != null ? str : "local";
    }

    @Override // javax.jmdns.ServiceInfo
    public String getName() {
        String str = this._name;
        return str != null ? str : "";
    }

    @Override // javax.jmdns.ServiceInfo
    public int getPort() {
        return this._port;
    }

    @Override // javax.jmdns.ServiceInfo
    public int getPriority() {
        return this._priority;
    }

    @Override // javax.jmdns.ServiceInfo
    public String getProtocol() {
        String str = this._protocol;
        return str != null ? str : "tcp";
    }

    @Override // javax.jmdns.ServiceInfo
    public String getServer() {
        String str = this._server;
        return str != null ? str : "";
    }

    @Override // javax.jmdns.ServiceInfo
    public String getSubtype() {
        String str = this._subtype;
        return str != null ? str : "";
    }

    @Override // javax.jmdns.ServiceInfo
    public int getWeight() {
        return this._weight;
    }

    @Override // javax.jmdns.ServiceInfo
    public boolean isPersistent() {
        return this._persistent;
    }

    public boolean needTextAnnouncing() {
        return this._needTextAnnouncing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this._name = str;
        this._key = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServer(String str) {
        this._server = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ServiceInfoState extends DNSStatefulObject.DefaultImplementation {
        private final ServiceInfoImpl _info;

        public ServiceInfoState(ServiceInfoImpl serviceInfoImpl) {
            this._info = serviceInfoImpl;
        }

        @Override // javax.jmdns.impl.DNSStatefulObject.DefaultImplementation
        protected void setTask(DNSTask dNSTask) {
            super.setTask(dNSTask);
            if (this._task == null && this._info.needTextAnnouncing()) {
                lock();
                try {
                    if (this._task == null && this._info.needTextAnnouncing()) {
                        if (this._state.isAnnounced()) {
                            setState(DNSState.ANNOUNCING_1);
                            if (getDns() != null) {
                                getDns().startAnnouncer();
                            }
                        }
                        this._info.setNeedTextAnnouncing(false);
                    }
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
        }

        @Override // javax.jmdns.impl.DNSStatefulObject.DefaultImplementation
        public void setDns(JmDNSImpl jmDNSImpl) {
            super.setDns(jmDNSImpl);
        }
    }

    public ServiceInfoImpl(String str, String str2, String str3, int i, int i2, int i3, boolean z, Map map) {
        this(decodeQualifiedNameMap(str, str2, str3), i, i2, i3, z, ByteWrangler.textFromProperties(map));
    }

    public ServiceInfoImpl(String str, String str2, String str3, int i, int i2, int i3, boolean z, byte[] bArr) {
        this(decodeQualifiedNameMap(str, str2, str3), i, i2, i3, z, bArr);
    }

    public ServiceInfoImpl(Map map, int i, int i2, int i3, boolean z, Map map2) {
        this(map, i, i2, i3, z, ByteWrangler.textFromProperties(map2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceInfoImpl(Map map, int i, int i2, int i3, boolean z, String str) {
        this(map, i, i2, i3, z, (byte[]) null);
        try {
            this._text = ByteWrangler.encodeText(str);
            this._server = str;
        } catch (IOException e) {
            throw new RuntimeException("Unexpected exception: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceInfoImpl(Map map, int i, int i2, int i3, boolean z, byte[] bArr) {
        Map checkQualifiedNameMap = checkQualifiedNameMap(map);
        this._domain = (String) checkQualifiedNameMap.get(ServiceInfo.Fields.Domain);
        this._protocol = (String) checkQualifiedNameMap.get(ServiceInfo.Fields.Protocol);
        this._application = (String) checkQualifiedNameMap.get(ServiceInfo.Fields.Application);
        this._name = (String) checkQualifiedNameMap.get(ServiceInfo.Fields.Instance);
        this._subtype = (String) checkQualifiedNameMap.get(ServiceInfo.Fields.Subtype);
        this._port = i;
        this._weight = i2;
        this._priority = i3;
        this._text = bArr;
        setNeedTextAnnouncing(false);
        this._state = new ServiceInfoState(this);
        this._persistent = z;
        this._ipv4Addresses = Collections.synchronizedSet(new LinkedHashSet());
        this._ipv6Addresses = Collections.synchronizedSet(new LinkedHashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceInfoImpl(ServiceInfo serviceInfo) {
        this._ipv4Addresses = Collections.synchronizedSet(new LinkedHashSet());
        this._ipv6Addresses = Collections.synchronizedSet(new LinkedHashSet());
        if (serviceInfo != null) {
            this._domain = serviceInfo.getDomain();
            this._protocol = serviceInfo.getProtocol();
            this._application = serviceInfo.getApplication();
            this._name = serviceInfo.getName();
            this._subtype = serviceInfo.getSubtype();
            this._port = serviceInfo.getPort();
            this._weight = serviceInfo.getWeight();
            this._priority = serviceInfo.getPriority();
            this._text = serviceInfo.getTextBytes();
            this._persistent = serviceInfo.isPersistent();
            for (Inet6Address inet6Address : serviceInfo.getInet6Addresses()) {
                this._ipv6Addresses.add(inet6Address);
            }
            for (Inet4Address inet4Address : serviceInfo.getInet4Addresses()) {
                this._ipv4Addresses.add(inet4Address);
            }
        }
        this._state = new ServiceInfoState(this);
    }

    public static Map decodeQualifiedNameMap(String str, String str2, String str3) {
        Map decodeQualifiedNameMapForType = decodeQualifiedNameMapForType(str);
        decodeQualifiedNameMapForType.put(ServiceInfo.Fields.Instance, str2);
        decodeQualifiedNameMapForType.put(ServiceInfo.Fields.Subtype, str3);
        return checkQualifiedNameMap(decodeQualifiedNameMapForType);
    }

    public static Map decodeQualifiedNameMapForType(String str) {
        String removeSeparators;
        String substring;
        String str2;
        int indexOf;
        String substring2;
        String str3;
        String str4;
        String lowerCase = str.toLowerCase();
        String str5 = "";
        if (lowerCase.contains("in-addr.arpa") || lowerCase.contains("ip6.arpa")) {
            int indexOf2 = lowerCase.contains("in-addr.arpa") ? lowerCase.indexOf("in-addr.arpa") : lowerCase.indexOf("ip6.arpa");
            removeSeparators = removeSeparators(str.substring(0, indexOf2));
            substring = str.substring(indexOf2);
        } else if (!lowerCase.contains("_") && lowerCase.contains(".")) {
            int indexOf3 = lowerCase.indexOf(46);
            removeSeparators = removeSeparators(str.substring(0, indexOf3));
            substring = removeSeparators(str.substring(indexOf3));
        } else {
            if ((!lowerCase.startsWith("_") || lowerCase.startsWith("_services")) && (indexOf = lowerCase.indexOf("._")) > 0) {
                substring2 = str.substring(0, indexOf);
                int i = indexOf + 1;
                if (i < lowerCase.length()) {
                    str3 = lowerCase.substring(i);
                    str = str.substring(i);
                } else {
                    str3 = lowerCase;
                }
            } else {
                str3 = lowerCase;
                substring2 = "";
            }
            int lastIndexOf = str3.lastIndexOf("._");
            if (lastIndexOf > 0) {
                int i2 = lastIndexOf + 2;
                str4 = str.substring(i2, str3.indexOf(46, i2));
            } else {
                str4 = "";
            }
            if (str4.length() > 0) {
                int indexOf4 = str3.indexOf("_" + str4.toLowerCase() + ".");
                int length = str4.length() + indexOf4 + 2;
                int length2 = str3.length() - (str3.endsWith(".") ? 1 : 0);
                String substring3 = length2 > length ? str.substring(length, length2) : "";
                if (indexOf4 > 0) {
                    lowerCase = str.substring(0, indexOf4 - 1);
                    substring = substring3;
                } else {
                    substring = substring3;
                    lowerCase = "";
                }
            } else {
                substring = "";
            }
            int indexOf5 = lowerCase.toLowerCase().indexOf("._sub");
            if (indexOf5 > 0) {
                str5 = removeSeparators(lowerCase.substring(0, indexOf5));
                lowerCase = lowerCase.substring(indexOf5 + 5);
            }
            removeSeparators = substring2;
            String str6 = str5;
            str5 = str4;
            str2 = str6;
            HashMap hashMap = new HashMap(5);
            hashMap.put(ServiceInfo.Fields.Domain, removeSeparators(substring));
            hashMap.put(ServiceInfo.Fields.Protocol, str5);
            hashMap.put(ServiceInfo.Fields.Application, removeSeparators(lowerCase));
            hashMap.put(ServiceInfo.Fields.Instance, removeSeparators);
            hashMap.put(ServiceInfo.Fields.Subtype, str2);
            return hashMap;
        }
        lowerCase = "";
        str2 = lowerCase;
        HashMap hashMap2 = new HashMap(5);
        hashMap2.put(ServiceInfo.Fields.Domain, removeSeparators(substring));
        hashMap2.put(ServiceInfo.Fields.Protocol, str5);
        hashMap2.put(ServiceInfo.Fields.Application, removeSeparators(lowerCase));
        hashMap2.put(ServiceInfo.Fields.Instance, removeSeparators);
        hashMap2.put(ServiceInfo.Fields.Subtype, str2);
        return hashMap2;
    }

    protected static Map checkQualifiedNameMap(Map map) {
        HashMap hashMap = new HashMap(5);
        ServiceInfo.Fields fields = ServiceInfo.Fields.Domain;
        String str = "local";
        String str2 = map.containsKey(fields) ? (String) map.get(fields) : "local";
        if (str2 != null && str2.length() != 0) {
            str = str2;
        }
        hashMap.put(fields, removeSeparators(str));
        ServiceInfo.Fields fields2 = ServiceInfo.Fields.Protocol;
        String str3 = "tcp";
        String str4 = map.containsKey(fields2) ? (String) map.get(fields2) : "tcp";
        if (str4 != null && str4.length() != 0) {
            str3 = str4;
        }
        hashMap.put(fields2, removeSeparators(str3));
        ServiceInfo.Fields fields3 = ServiceInfo.Fields.Application;
        String str5 = "";
        String str6 = map.containsKey(fields3) ? (String) map.get(fields3) : "";
        hashMap.put(fields3, removeSeparators((str6 == null || str6.length() == 0) ? "" : ""));
        ServiceInfo.Fields fields4 = ServiceInfo.Fields.Instance;
        String str7 = map.containsKey(fields4) ? (String) map.get(fields4) : "";
        hashMap.put(fields4, removeSeparators((str7 == null || str7.length() == 0) ? "" : ""));
        ServiceInfo.Fields fields5 = ServiceInfo.Fields.Subtype;
        String str8 = map.containsKey(fields5) ? (String) map.get(fields5) : "";
        if (str8 != null && str8.length() != 0) {
            str5 = str8;
        }
        hashMap.put(fields5, removeSeparators(str5));
        return hashMap;
    }

    private static String removeSeparators(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.startsWith(".")) {
            trim = trim.substring(1);
        }
        if (trim.startsWith("_")) {
            trim = trim.substring(1);
        }
        return trim.endsWith(".") ? trim.substring(0, trim.length() - 1) : trim;
    }

    @Override // javax.jmdns.ServiceInfo
    public String getType() {
        String str;
        String domain = getDomain();
        String protocol = getProtocol();
        String application = getApplication();
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (application.length() > 0) {
            str = "_" + application + ".";
        } else {
            str = "";
        }
        sb.append(str);
        if (protocol.length() > 0) {
            str2 = "_" + protocol + ".";
        }
        sb.append(str2);
        sb.append(domain);
        sb.append(".");
        return sb.toString();
    }

    public String getTypeWithSubtype() {
        String str;
        String subtype = getSubtype();
        StringBuilder sb = new StringBuilder();
        if (subtype.length() > 0) {
            str = "_" + subtype + "._sub.";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(getType());
        return sb.toString();
    }

    @Override // javax.jmdns.ServiceInfo
    public String getKey() {
        if (this._key == null) {
            this._key = getQualifiedName().toLowerCase();
        }
        return this._key;
    }

    @Override // javax.jmdns.ServiceInfo
    public String getQualifiedName() {
        String str;
        String str2;
        String domain = getDomain();
        String protocol = getProtocol();
        String application = getApplication();
        String name = getName();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        if (name.length() > 0) {
            str = name + ".";
        } else {
            str = "";
        }
        sb.append(str);
        if (application.length() > 0) {
            str2 = "_" + application + ".";
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (protocol.length() > 0) {
            str3 = "_" + protocol + ".";
        }
        sb.append(str3);
        sb.append(domain);
        sb.append(".");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAddress(Inet4Address inet4Address) {
        this._ipv4Addresses.add(inet4Address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAddress(Inet6Address inet6Address) {
        this._ipv6Addresses.add(inet6Address);
    }

    @Override // javax.jmdns.ServiceInfo
    public InetAddress[] getInetAddresses() {
        ArrayList arrayList = new ArrayList(this._ipv4Addresses.size() + this._ipv6Addresses.size());
        arrayList.addAll(this._ipv4Addresses);
        arrayList.addAll(this._ipv6Addresses);
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    @Override // javax.jmdns.ServiceInfo
    public Inet4Address[] getInet4Addresses() {
        Set set = this._ipv4Addresses;
        return (Inet4Address[]) set.toArray(new Inet4Address[set.size()]);
    }

    @Override // javax.jmdns.ServiceInfo
    public Inet6Address[] getInet6Addresses() {
        Set set = this._ipv6Addresses;
        return (Inet6Address[]) set.toArray(new Inet6Address[set.size()]);
    }

    @Override // javax.jmdns.ServiceInfo
    public byte[] getTextBytes() {
        byte[] bArr = this._text;
        return (bArr == null || bArr.length <= 0) ? ByteWrangler.EMPTY_TXT : bArr;
    }

    public String getURL() {
        return getURL("http");
    }

    public String getURL(String str) {
        String[] uRLs = getURLs(str);
        if (uRLs.length > 0) {
            return uRLs[0];
        }
        return str + "://null:" + getPort();
    }

    public String[] getURLs(String str) {
        InetAddress[] inetAddresses = getInetAddresses();
        ArrayList arrayList = new ArrayList(inetAddresses.length);
        for (InetAddress inetAddress : inetAddresses) {
            String hostAddress = inetAddress.getHostAddress();
            if (inetAddress instanceof Inet6Address) {
                hostAddress = "[" + hostAddress + "]";
            }
            String str2 = str + "://" + hostAddress + ":" + getPort();
            String propertyString = getPropertyString(BonjourPeer.PATH);
            if (propertyString != null) {
                if (propertyString.indexOf("://") >= 0) {
                    str2 = propertyString;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!propertyString.startsWith("/")) {
                        propertyString = "/" + propertyString;
                    }
                    sb.append(propertyString);
                    str2 = sb.toString();
                }
            }
            arrayList.add(str2);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized byte[] getPropertyBytes(String str) {
        return (byte[]) getProperties().get(str);
    }

    @Override // javax.jmdns.ServiceInfo
    public synchronized String getPropertyString(String str) {
        byte[] bArr = (byte[]) getProperties().get(str);
        if (bArr == null) {
            return null;
        }
        if (bArr == ByteWrangler.NO_VALUE) {
            return "true";
        }
        return ByteWrangler.readUTF(bArr, 0, bArr.length);
    }

    public Map getQualifiedNameMap() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(ServiceInfo.Fields.Domain, getDomain());
        hashMap.put(ServiceInfo.Fields.Protocol, getProtocol());
        hashMap.put(ServiceInfo.Fields.Application, getApplication());
        hashMap.put(ServiceInfo.Fields.Instance, getName());
        hashMap.put(ServiceInfo.Fields.Subtype, getSubtype());
        return hashMap;
    }

    synchronized Map getProperties() {
        Map map;
        if (this._props == null && getTextBytes() != null) {
            Hashtable hashtable = new Hashtable();
            try {
                ByteWrangler.readProperties(hashtable, getTextBytes());
            } catch (Exception e) {
                logger.warn("Malformed TXT Field ", (Throwable) e);
            }
            this._props = hashtable;
        }
        map = this._props;
        if (map == null) {
            map = Collections.emptyMap();
        }
        return map;
    }

    @Override // javax.jmdns.impl.DNSListener
    public void updateRecord(DNSCache dNSCache, long j, DNSEntry dNSEntry) {
        boolean handleUpdateRecord;
        if (!(dNSEntry instanceof DNSRecord)) {
            logger.trace("DNSEntry is not of type 'DNSRecord' but of type {}", dNSEntry == null ? "null" : dNSEntry.getClass().getSimpleName());
            return;
        }
        DNSRecord dNSRecord = (DNSRecord) dNSEntry;
        if (dNSRecord.isExpired(j)) {
            handleUpdateRecord = handleExpiredRecord(dNSRecord);
        } else {
            handleUpdateRecord = handleUpdateRecord(dNSCache, j, dNSRecord);
        }
        if (handleUpdateRecord) {
            JmDNSImpl dns = getDns();
            if (dns != null) {
                if (hasData()) {
                    dns.handleServiceResolved(new ServiceEventImpl(dns, getType(), getName(), clone()));
                }
            } else {
                logger.debug("JmDNS not available.");
            }
        }
        synchronized (this) {
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: javax.jmdns.impl.ServiceInfoImpl$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$jmdns$impl$constants$DNSRecordType;

        static {
            int[] iArr = new int[DNSRecordType.values().length];
            $SwitchMap$javax$jmdns$impl$constants$DNSRecordType = iArr;
            try {
                iArr[DNSRecordType.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_SRV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_TXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_PTR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private boolean handleExpiredRecord(DNSRecord dNSRecord) {
        int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$constants$DNSRecordType[dNSRecord.getRecordType().ordinal()];
        if (i == 1 || i == 2) {
            if (dNSRecord.getName().equalsIgnoreCase(getServer())) {
                DNSRecord.Address address = (DNSRecord.Address) dNSRecord;
                if (DNSRecordType.TYPE_A.equals(dNSRecord.getRecordType())) {
                    Inet4Address inet4Address = (Inet4Address) address.getAddress();
                    if (this._ipv4Addresses.remove(inet4Address)) {
                        logger.debug("Removed expired IPv4: {}", inet4Address);
                        return true;
                    }
                    logger.debug("Expired IPv4 not in this service: {}", inet4Address);
                    return false;
                }
                Inet6Address inet6Address = (Inet6Address) address.getAddress();
                if (this._ipv6Addresses.remove(inet6Address)) {
                    logger.debug("Removed expired IPv6: {}", inet6Address);
                    return true;
                }
                logger.debug("Expired IPv6 not in this service: {}", inet6Address);
                return false;
            }
            return false;
        }
        logger.trace("Unhandled expired record: {}", dNSRecord);
        return false;
    }

    private boolean handleUpdateRecord(DNSCache dNSCache, long j, DNSRecord dNSRecord) {
        int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$constants$DNSRecordType[dNSRecord.getRecordType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (dNSRecord.getName().equalsIgnoreCase(getQualifiedName())) {
                            this._text = ((DNSRecord.Text) dNSRecord).getText();
                            this._props = null;
                            return true;
                        }
                    } else if (i == 5 && getSubtype().length() == 0 && dNSRecord.getSubtype().length() != 0) {
                        this._subtype = dNSRecord.getSubtype();
                        return true;
                    }
                } else if (dNSRecord.getName().equalsIgnoreCase(getQualifiedName())) {
                    DNSRecord.Service service = (DNSRecord.Service) dNSRecord;
                    String str = this._server;
                    boolean z = str == null || !str.equalsIgnoreCase(service.getServer());
                    this._server = service.getServer();
                    this._port = service.getPort();
                    this._weight = service.getWeight();
                    this._priority = service.getPriority();
                    if (!z) {
                        return true;
                    }
                    this._ipv4Addresses.clear();
                    this._ipv6Addresses.clear();
                    for (DNSEntry dNSEntry : dNSCache.getDNSEntryList(this._server, DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN)) {
                        updateRecord(dNSCache, j, dNSEntry);
                    }
                    for (DNSEntry dNSEntry2 : dNSCache.getDNSEntryList(this._server, DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN)) {
                        updateRecord(dNSCache, j, dNSEntry2);
                    }
                }
            } else if (dNSRecord.getName().equalsIgnoreCase(getServer())) {
                DNSRecord.Address address = (DNSRecord.Address) dNSRecord;
                if (address.getAddress() instanceof Inet6Address) {
                    if (this._ipv6Addresses.add((Inet6Address) address.getAddress())) {
                        return true;
                    }
                }
            }
        } else if (dNSRecord.getName().equalsIgnoreCase(getServer())) {
            DNSRecord.Address address2 = (DNSRecord.Address) dNSRecord;
            if (address2.getAddress() instanceof Inet4Address) {
                if (this._ipv4Addresses.add((Inet4Address) address2.getAddress())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // javax.jmdns.ServiceInfo
    public synchronized boolean hasData() {
        boolean z;
        if (getServer() != null && hasInetAddress() && getTextBytes() != null) {
            z = getTextBytes().length > 0;
        }
        return z;
    }

    private final boolean hasInetAddress() {
        return this._ipv4Addresses.size() > 0 || this._ipv6Addresses.size() > 0;
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean advanceState(DNSTask dNSTask) {
        return this._state.advanceState(dNSTask);
    }

    public boolean revertState() {
        return this._state.revertState();
    }

    public boolean cancelState() {
        return this._state.cancelState();
    }

    public boolean recoverState() {
        return this._state.recoverState();
    }

    public void removeAssociationWithTask(DNSTask dNSTask) {
        this._state.removeAssociationWithTask(dNSTask);
    }

    public void associateWithTask(DNSTask dNSTask, DNSState dNSState) {
        this._state.associateWithTask(dNSTask, dNSState);
    }

    public boolean isAssociatedWithTask(DNSTask dNSTask, DNSState dNSState) {
        return this._state.isAssociatedWithTask(dNSTask, dNSState);
    }

    public boolean isProbing() {
        return this._state.isProbing();
    }

    public boolean isAnnouncing() {
        return this._state.isAnnouncing();
    }

    public boolean isAnnounced() {
        return this._state.isAnnounced();
    }

    public boolean waitForCanceled(long j) {
        return this._state.waitForCanceled(j);
    }

    public int hashCode() {
        return getQualifiedName().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ServiceInfoImpl) && getQualifiedName().equals(((ServiceInfoImpl) obj).getQualifiedName());
    }

    @Override // javax.jmdns.ServiceInfo
    public ServiceInfoImpl clone() {
        ServiceInfoImpl serviceInfoImpl = new ServiceInfoImpl(getQualifiedNameMap(), this._port, this._weight, this._priority, this._persistent, this._text);
        for (Inet6Address inet6Address : getInet6Addresses()) {
            serviceInfoImpl._ipv6Addresses.add(inet6Address);
        }
        for (Inet4Address inet4Address : getInet4Addresses()) {
            serviceInfoImpl._ipv4Addresses.add(inet4Address);
        }
        return serviceInfoImpl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(System.identityHashCode(this));
        sb.append(" name: '");
        if (getName().length() > 0) {
            sb.append(getName());
            sb.append(CoreConstants.DOT);
        }
        sb.append(getTypeWithSubtype());
        sb.append("' address: '");
        InetAddress[] inetAddresses = getInetAddresses();
        if (inetAddresses.length > 0) {
            for (InetAddress inetAddress : inetAddresses) {
                sb.append(inetAddress);
                sb.append(CoreConstants.COLON_CHAR);
                sb.append(getPort());
                sb.append(' ');
            }
        } else {
            sb.append("(null):");
            sb.append(getPort());
        }
        sb.append("' status: '");
        sb.append(this._state.toString());
        sb.append(isPersistent() ? "' is persistent," : "',");
        if (hasData()) {
            sb.append(" has data");
        } else {
            sb.append(" has NO data");
        }
        if (getTextBytes().length > 0) {
            Map properties = getProperties();
            if (!properties.isEmpty()) {
                for (Map.Entry entry : properties.entrySet()) {
                    String readUTF = ByteWrangler.readUTF((byte[]) entry.getValue());
                    sb.append("\n\t");
                    sb.append((String) entry.getKey());
                    sb.append(": ");
                    sb.append(readUTF);
                }
            } else {
                sb.append(", empty");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public Collection answers(DNSRecordClass dNSRecordClass, boolean z, int i, HostInfo hostInfo) {
        ArrayList arrayList = new ArrayList();
        if (dNSRecordClass == DNSRecordClass.CLASS_ANY || dNSRecordClass == DNSRecordClass.CLASS_IN) {
            if (getSubtype().length() > 0) {
                arrayList.add(new DNSRecord.Pointer(getTypeWithSubtype(), DNSRecordClass.CLASS_IN, false, i, getQualifiedName()));
            }
            String type = getType();
            DNSRecordClass dNSRecordClass2 = DNSRecordClass.CLASS_IN;
            arrayList.add(new DNSRecord.Pointer(type, dNSRecordClass2, false, i, getQualifiedName()));
            arrayList.add(new DNSRecord.Service(getQualifiedName(), dNSRecordClass2, z, i, this._priority, this._weight, this._port, hostInfo.getName()));
            arrayList.add(new DNSRecord.Text(getQualifiedName(), dNSRecordClass2, z, i, getTextBytes()));
        }
        return arrayList;
    }

    public void setDns(JmDNSImpl jmDNSImpl) {
        this._state.setDns(jmDNSImpl);
    }

    public JmDNSImpl getDns() {
        return this._state.getDns();
    }

    public void setNeedTextAnnouncing(boolean z) {
        this._needTextAnnouncing = z;
        if (z) {
            this._state.setTask(null);
        }
    }

    @Override // javax.jmdns.ServiceInfo
    public boolean hasSameAddresses(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            return false;
        }
        if (serviceInfo instanceof ServiceInfoImpl) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) serviceInfo;
            return this._ipv4Addresses.size() == serviceInfoImpl._ipv4Addresses.size() && this._ipv6Addresses.size() == serviceInfoImpl._ipv6Addresses.size() && this._ipv4Addresses.equals(serviceInfoImpl._ipv4Addresses) && this._ipv6Addresses.equals(serviceInfoImpl._ipv6Addresses);
        }
        InetAddress[] inetAddresses = getInetAddresses();
        InetAddress[] inetAddresses2 = serviceInfo.getInetAddresses();
        return inetAddresses.length == inetAddresses2.length && new HashSet(Arrays.asList(inetAddresses)).equals(new HashSet(Arrays.asList(inetAddresses2)));
    }
}
