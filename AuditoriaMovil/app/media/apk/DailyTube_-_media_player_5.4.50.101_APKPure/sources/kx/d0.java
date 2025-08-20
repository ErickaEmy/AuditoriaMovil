package kx;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kx.tl;
/* loaded from: classes.dex */
public interface d0 extends tl {

    /* loaded from: classes.dex */
    public static final class a {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public Map<String, String> f10024n3;
        public final Map<String, String> y = new HashMap();

        public synchronized Map<String, String> y() {
            try {
                if (this.f10024n3 == null) {
                    this.f10024n3 = Collections.unmodifiableMap(new HashMap(this.y));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f10024n3;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv extends zn {
        public final String contentType;

        public gv(String str, p pVar) {
            super("Invalid content type: " + str, pVar, 2003, 1);
            this.contentType = str;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 extends tl.y {
        @Override // kx.tl.y
        d0 y();
    }

    /* loaded from: classes.dex */
    public static final class v extends zn {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        @Nullable
        public final String responseMessage;

        public v(int i, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, p pVar, byte[] bArr) {
            super("Response code: " + i, iOException, pVar, 2004, 1);
            this.responseCode = i;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends zn {
        public y(IOException iOException, p pVar) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, pVar, 2007, 1);
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends wz {
        public final p dataSpec;
        public final int type;

        public zn(p pVar, int i, int i5) {
            super(gv(i, i5));
            this.dataSpec = pVar;
            this.type = i5;
        }

        public static int gv(int i, int i5) {
            if (i == 2000 && i5 == 1) {
                return 2001;
            }
            return i;
        }

        public static zn v(IOException iOException, p pVar, int i) {
            int i5;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i5 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i5 = 1004;
            } else if (message != null && w0.zn.v(message).matches("cleartext.*not permitted.*")) {
                i5 = 2007;
            } else {
                i5 = 2001;
            }
            if (i5 == 2007) {
                return new y(iOException, pVar);
            }
            return new zn(iOException, pVar, i5, i);
        }

        public zn(String str, p pVar, int i, int i5) {
            super(str, gv(i, i5));
            this.dataSpec = pVar;
            this.type = i5;
        }

        public zn(IOException iOException, p pVar, int i, int i5) {
            super(iOException, gv(i, i5));
            this.dataSpec = pVar;
            this.type = i5;
        }

        public zn(String str, @Nullable IOException iOException, p pVar, int i, int i5) {
            super(str, iOException, gv(i, i5));
            this.dataSpec = pVar;
            this.type = i5;
        }
    }
}
