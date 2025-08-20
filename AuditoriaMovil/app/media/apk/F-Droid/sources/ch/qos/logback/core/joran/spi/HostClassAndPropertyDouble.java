package ch.qos.logback.core.joran.spi;
/* loaded from: classes.dex */
public class HostClassAndPropertyDouble {
    final Class<?> hostClass;
    final String propertyName;

    public HostClassAndPropertyDouble(Class<?> cls, String str) {
        this.hostClass = cls;
        this.propertyName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            HostClassAndPropertyDouble hostClassAndPropertyDouble = (HostClassAndPropertyDouble) obj;
            Class<?> cls = this.hostClass;
            if (cls == null) {
                if (hostClassAndPropertyDouble.hostClass != null) {
                    return false;
                }
            } else if (!cls.equals(hostClassAndPropertyDouble.hostClass)) {
                return false;
            }
            String str = this.propertyName;
            String str2 = hostClassAndPropertyDouble.propertyName;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Class<?> getHostClass() {
        return this.hostClass;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public int hashCode() {
        Class<?> cls = this.hostClass;
        int hashCode = ((cls == null ? 0 : cls.hashCode()) + 31) * 31;
        String str = this.propertyName;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
