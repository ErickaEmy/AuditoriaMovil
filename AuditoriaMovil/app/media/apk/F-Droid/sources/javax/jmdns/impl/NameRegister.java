package javax.jmdns.impl;

import ch.qos.logback.core.CoreConstants;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public interface NameRegister {

    /* loaded from: classes.dex */
    public enum NameType {
        HOST,
        SERVICE
    }

    String incrementName(InetAddress inetAddress, String str, NameType nameType);

    /* loaded from: classes.dex */
    public static abstract class BaseRegister implements NameRegister {
        protected String incrementNameWithDash(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int indexOf = str.indexOf(".local.");
            int lastIndexOf = str.lastIndexOf(45);
            int i = 1;
            if (lastIndexOf < 0) {
                sb.append(str.substring(0, indexOf));
            } else {
                try {
                    int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1, indexOf)) + 1;
                    sb.append(str.substring(0, lastIndexOf));
                    i = parseInt;
                } catch (Exception unused) {
                    sb.append(str.substring(0, indexOf));
                }
            }
            sb.append(CoreConstants.DASH_CHAR);
            sb.append(i);
            sb.append(".local.");
            return sb.toString();
        }

        protected String incrementNameWithParentesis(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            if (lastIndexOf >= 0 && lastIndexOf < lastIndexOf2) {
                try {
                    sb.append(str.substring(0, lastIndexOf));
                    sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
                    sb.append(Integer.parseInt(str.substring(lastIndexOf + 1, lastIndexOf2)) + 1);
                    sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
                } catch (NumberFormatException unused) {
                    sb.setLength(0);
                    sb.append(str);
                    sb.append(" (2)");
                }
            } else {
                sb.append(str);
                sb.append(" (2)");
            }
            return sb.toString();
        }
    }

    /* renamed from: javax.jmdns.impl.NameRegister$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$jmdns$impl$NameRegister$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$javax$jmdns$impl$NameRegister$NameType = iArr;
            try {
                iArr[NameType.HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$NameRegister$NameType[NameType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UniqueNamePerInterface extends BaseRegister {
        private final ConcurrentMap _hostNames = new ConcurrentHashMap();
        private final ConcurrentMap _serviceNames = new ConcurrentHashMap();

        @Override // javax.jmdns.impl.NameRegister
        public String incrementName(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
            if (i != 1) {
                return i != 2 ? str : incrementNameWithParentesis(str);
            }
            return incrementNameWithDash(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Factory {
        private static volatile NameRegister _register;

        public static NameRegister getRegistry() {
            if (_register == null) {
                _register = new UniqueNamePerInterface();
            }
            return _register;
        }
    }
}
