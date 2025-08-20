package m1;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public class gf extends Exception implements s {
    public final int errorCode;
    public final long timestampMs;
    public static final String y = v5.j5.g3(0);

    /* renamed from: v  reason: collision with root package name */
    public static final String f10762v = v5.j5.g3(1);

    /* renamed from: fb  reason: collision with root package name */
    public static final String f10759fb = v5.j5.g3(2);

    /* renamed from: s  reason: collision with root package name */
    public static final String f10760s = v5.j5.g3(3);

    /* renamed from: f  reason: collision with root package name */
    public static final String f10758f = v5.j5.g3(4);

    /* renamed from: t  reason: collision with root package name */
    public static final s.y<gf> f10761t = new s.y() { // from class: m1.nd
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            return new gf(bundle);
        }
    };

    public gf(Bundle bundle) {
        this(bundle.getString(f10759fb), v(bundle), bundle.getInt(y, 1000), bundle.getLong(f10762v, SystemClock.elapsedRealtime()));
    }

    public static Throwable gv(Class<?> cls, @Nullable String str) throws Exception {
        return (Throwable) cls.getConstructor(String.class).newInstance(str);
    }

    public static String i9(int i) {
        if (i != 5001) {
            if (i != 5002) {
                switch (i) {
                    case 1000:
                        return "ERROR_CODE_UNSPECIFIED";
                    case 1001:
                        return "ERROR_CODE_REMOTE_ERROR";
                    case 1002:
                        return "ERROR_CODE_BEHIND_LIVE_WINDOW";
                    case 1003:
                        return "ERROR_CODE_TIMEOUT";
                    case 1004:
                        return "ERROR_CODE_FAILED_RUNTIME_CHECK";
                    default:
                        switch (i) {
                            case 2000:
                                return "ERROR_CODE_IO_UNSPECIFIED";
                            case 2001:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                            case 2002:
                                return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                            case 2003:
                                return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                            case 2004:
                                return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                            case 2005:
                                return "ERROR_CODE_IO_FILE_NOT_FOUND";
                            case 2006:
                                return "ERROR_CODE_IO_NO_PERMISSION";
                            case 2007:
                                return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                            case 2008:
                                return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                            default:
                                switch (i) {
                                    case 3001:
                                        return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                                    case 3002:
                                        return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                                    case 3003:
                                        return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                                    case 3004:
                                        return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                                    default:
                                        switch (i) {
                                            case 4001:
                                                return "ERROR_CODE_DECODER_INIT_FAILED";
                                            case 4002:
                                                return "ERROR_CODE_DECODER_QUERY_FAILED";
                                            case 4003:
                                                return "ERROR_CODE_DECODING_FAILED";
                                            case 4004:
                                                return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                            case 4005:
                                                return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                            default:
                                                switch (i) {
                                                    case 6000:
                                                        return "ERROR_CODE_DRM_UNSPECIFIED";
                                                    case 6001:
                                                        return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                                    case 6002:
                                                        return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                                    case 6003:
                                                        return "ERROR_CODE_DRM_CONTENT_ERROR";
                                                    case 6004:
                                                        return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                                    case 6005:
                                                        return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                                    case 6006:
                                                        return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                                    case 6007:
                                                        return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                                    case 6008:
                                                        return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                                    default:
                                                        if (i >= 1000000) {
                                                            return "custom error code";
                                                        }
                                                        return "invalid error code";
                                                }
                                        }
                                }
                        }
                }
            }
            return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
        }
        return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
    }

    @Nullable
    public static Throwable v(Bundle bundle) {
        String string = bundle.getString(f10760s);
        String string2 = bundle.getString(f10758f);
        Throwable th = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, gf.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                th = gv(cls, string2);
            }
            if (th != null) {
                return th;
            }
        } catch (Throwable unused) {
        }
        return y(string2);
    }

    public static RemoteException y(@Nullable String str) {
        return new RemoteException(str);
    }

    public final String s() {
        return i9(this.errorCode);
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(y, this.errorCode);
        bundle.putLong(f10762v, this.timestampMs);
        bundle.putString(f10759fb, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(f10760s, cause.getClass().getName());
            bundle.putString(f10758f, cause.getMessage());
        }
        return bundle;
    }

    public gf(@Nullable String str, @Nullable Throwable th, int i, long j2) {
        super(str, th);
        this.errorCode = i;
        this.timestampMs = j2;
    }
}
