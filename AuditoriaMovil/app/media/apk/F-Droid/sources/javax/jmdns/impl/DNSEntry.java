package javax.jmdns.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
/* loaded from: classes.dex */
public abstract class DNSEntry {
    private final DNSRecordClass _dnsClass;
    private final String _key;
    private final String _name;
    final Map _qualifiedNameMap;
    private final DNSRecordType _recordType;
    private final String _type;
    private final boolean _unique;

    public String getKey() {
        String str = this._key;
        return str != null ? str : "";
    }

    public String getName() {
        String str = this._name;
        return str != null ? str : "";
    }

    public String getType() {
        String str = this._type;
        return str != null ? str : "";
    }

    public abstract boolean isExpired(long j);

    public boolean isUnique() {
        return this._unique;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void toString(StringBuilder sb) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DNSEntry(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        String str2;
        String str3;
        this._name = str;
        this._recordType = dNSRecordType;
        this._dnsClass = dNSRecordClass;
        this._unique = z;
        Map decodeQualifiedNameMapForType = ServiceInfoImpl.decodeQualifiedNameMapForType(getName());
        this._qualifiedNameMap = decodeQualifiedNameMapForType;
        String str4 = (String) decodeQualifiedNameMapForType.get(ServiceInfo.Fields.Domain);
        String str5 = (String) decodeQualifiedNameMapForType.get(ServiceInfo.Fields.Protocol);
        String str6 = (String) decodeQualifiedNameMapForType.get(ServiceInfo.Fields.Application);
        String lowerCase = ((String) decodeQualifiedNameMapForType.get(ServiceInfo.Fields.Instance)).toLowerCase();
        StringBuilder sb = new StringBuilder();
        String str7 = "";
        if (str6.length() > 0) {
            str2 = "_" + str6 + ".";
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (str5.length() > 0) {
            str3 = "_" + str5 + ".";
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(str4);
        sb.append(".");
        String sb2 = sb.toString();
        this._type = sb2;
        StringBuilder sb3 = new StringBuilder();
        if (lowerCase.length() > 0) {
            str7 = lowerCase + ".";
        }
        sb3.append(str7);
        sb3.append(sb2);
        this._key = sb3.toString().toLowerCase();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DNSEntry) {
            DNSEntry dNSEntry = (DNSEntry) obj;
            return getKey().equals(dNSEntry.getKey()) && getRecordType().equals(dNSEntry.getRecordType()) && getRecordClass() == dNSEntry.getRecordClass();
        }
        return false;
    }

    public boolean isSameEntry(DNSEntry dNSEntry) {
        return getKey().equals(dNSEntry.getKey()) && matchRecordType(dNSEntry.getRecordType()) && matchRecordClass(dNSEntry.getRecordClass());
    }

    public boolean sameSubtype(DNSEntry dNSEntry) {
        return getSubtype().equals(dNSEntry.getSubtype());
    }

    public boolean matchRecordClass(DNSRecordClass dNSRecordClass) {
        DNSRecordClass dNSRecordClass2 = DNSRecordClass.CLASS_ANY;
        return dNSRecordClass2 == dNSRecordClass || dNSRecordClass2 == getRecordClass() || getRecordClass().equals(dNSRecordClass);
    }

    public boolean matchRecordType(DNSRecordType dNSRecordType) {
        return getRecordType().equals(dNSRecordType);
    }

    public String getSubtype() {
        String str = (String) getQualifiedNameMap().get(ServiceInfo.Fields.Subtype);
        return str != null ? str : "";
    }

    public DNSRecordType getRecordType() {
        DNSRecordType dNSRecordType = this._recordType;
        return dNSRecordType != null ? dNSRecordType : DNSRecordType.TYPE_IGNORE;
    }

    public DNSRecordClass getRecordClass() {
        DNSRecordClass dNSRecordClass = this._dnsClass;
        return dNSRecordClass != null ? dNSRecordClass : DNSRecordClass.CLASS_UNKNOWN;
    }

    public Map getQualifiedNameMap() {
        return Collections.unmodifiableMap(this._qualifiedNameMap);
    }

    public boolean isServicesDiscoveryMetaQuery() {
        return ((String) this._qualifiedNameMap.get(ServiceInfo.Fields.Application)).equals("dns-sd") && ((String) this._qualifiedNameMap.get(ServiceInfo.Fields.Instance)).equals("_services");
    }

    public boolean isDomainDiscoveryQuery() {
        if (((String) this._qualifiedNameMap.get(ServiceInfo.Fields.Application)).equals("dns-sd")) {
            String str = (String) this._qualifiedNameMap.get(ServiceInfo.Fields.Instance);
            return "b".equals(str) || "db".equals(str) || "r".equals(str) || "dr".equals(str) || "lb".equals(str);
        }
        return false;
    }

    public boolean isReverseLookup() {
        return isV4ReverseLookup() || isV6ReverseLookup();
    }

    public boolean isV4ReverseLookup() {
        return ((String) this._qualifiedNameMap.get(ServiceInfo.Fields.Domain)).endsWith("in-addr.arpa");
    }

    public boolean isV6ReverseLookup() {
        return ((String) this._qualifiedNameMap.get(ServiceInfo.Fields.Domain)).endsWith("ip6.arpa");
    }

    public boolean isSameRecordClass(DNSEntry dNSEntry) {
        return dNSEntry != null && dNSEntry.getRecordClass() == getRecordClass();
    }

    public boolean isSameType(DNSEntry dNSEntry) {
        return dNSEntry != null && dNSEntry.getRecordType() == getRecordType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void toByteArray(DataOutputStream dataOutputStream) {
        dataOutputStream.write(getName().getBytes("UTF8"));
        dataOutputStream.writeShort(getRecordType().indexValue());
        dataOutputStream.writeShort(getRecordClass().indexValue());
    }

    protected byte[] toByteArray() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            toByteArray(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new InternalError();
        }
    }

    public int compareTo(DNSEntry dNSEntry) {
        byte[] byteArray = toByteArray();
        byte[] byteArray2 = dNSEntry.toByteArray();
        int min = Math.min(byteArray.length, byteArray2.length);
        for (int i = 0; i < min; i++) {
            byte b = byteArray[i];
            byte b2 = byteArray2[i];
            if (b > b2) {
                return 1;
            }
            if (b < b2) {
                return -1;
            }
        }
        return byteArray.length - byteArray2.length;
    }

    public int hashCode() {
        return getKey().hashCode() + getRecordType().indexValue() + getRecordClass().indexValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append('[');
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(System.identityHashCode(this));
        sb.append(" type: ");
        sb.append(getRecordType());
        sb.append(", class: ");
        sb.append(getRecordClass());
        sb.append(this._unique ? "-unique," : ",");
        sb.append(" name: ");
        sb.append(this._name);
        toString(sb);
        sb.append(']');
        return sb.toString();
    }
}
