package h3;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import h3.x4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.m;
import v5.j5;
import v5.n;
@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class x4 {
    public static final Pattern y = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: n3  reason: collision with root package name */
    public static final HashMap<n3, List<wz>> f8476n3 = new HashMap<>();

    /* renamed from: zn  reason: collision with root package name */
    public static int f8477zn = -1;

    /* loaded from: classes.dex */
    public static final class a implements gv {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public MediaCodecInfo[] f8478n3;
        public final int y;

        public a(boolean z2, boolean z3) {
            int i;
            if (!z2 && !z3) {
                i = 0;
            } else {
                i = 1;
            }
            this.y = i;
        }

        public final void a() {
            if (this.f8478n3 == null) {
                this.f8478n3 = new MediaCodecList(this.y).getCodecInfos();
            }
        }

        @Override // h3.x4.gv
        public int gv() {
            a();
            return this.f8478n3.length;
        }

        @Override // h3.x4.gv
        public boolean n3(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // h3.x4.gv
        public boolean v() {
            return true;
        }

        @Override // h3.x4.gv
        public MediaCodecInfo y(int i) {
            a();
            return this.f8478n3[i];
        }

        @Override // h3.x4.gv
        public boolean zn(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }
    }

    /* loaded from: classes.dex */
    public interface fb<T> {
        int getScore(T t2);
    }

    /* loaded from: classes.dex */
    public interface gv {
        int gv();

        boolean n3(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean v();

        MediaCodecInfo y(int i);

        boolean zn(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f8479n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f8480zn;

        public n3(String str, boolean z2, boolean z3) {
            this.y = str;
            this.f8479n3 = z2;
            this.f8480zn = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != n3.class) {
                return false;
            }
            n3 n3Var = (n3) obj;
            if (TextUtils.equals(this.y, n3Var.y) && this.f8479n3 == n3Var.f8479n3 && this.f8480zn == n3Var.f8480zn) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (this.y.hashCode() + 31) * 31;
            int i5 = 1237;
            if (this.f8479n3) {
                i = 1231;
            } else {
                i = 1237;
            }
            int i6 = (hashCode + i) * 31;
            if (this.f8480zn) {
                i5 = 1231;
            }
            return i6 + i5;
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements gv {
        public v() {
        }

        @Override // h3.x4.gv
        public int gv() {
            return MediaCodecList.getCodecCount();
        }

        @Override // h3.x4.gv
        public boolean n3(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            if ("secure-playback".equals(str) && "video/avc".equals(str2)) {
                return true;
            }
            return false;
        }

        @Override // h3.x4.gv
        public boolean v() {
            return false;
        }

        @Override // h3.x4.gv
        public MediaCodecInfo y(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // h3.x4.gv
        public boolean zn(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends Exception {
        public zn(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return NotificationCompat.FLAG_HIGH_PRIORITY;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static /* synthetic */ int a8(wz wzVar) {
        String str = wzVar.y;
        if (!str.startsWith("OMX.google") && !str.startsWith("c2.android")) {
            if (j5.y < 26 && str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                return -1;
            }
            return 0;
        }
        return 1;
    }

    public static /* synthetic */ int b(m mVar, wz wzVar) {
        return wzVar.w(mVar) ? 1 : 0;
    }

    @Nullable
    public static Integer c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c2 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c2 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c2 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c2 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c2 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c2 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c2 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c2 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c2 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c2 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c2 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c2 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c2 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c2 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c2 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c2 = 25;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case '\b':
                return 64;
            case '\t':
                return 256;
            case '\n':
                return 2048;
            case 11:
                return 8192;
            case '\f':
                return 32768;
            case '\r':
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    public static int c5(int i) {
        if (i != 66) {
            if (i != 77) {
                if (i != 88) {
                    if (i != 100) {
                        if (i != 110) {
                            if (i != 122) {
                                if (i != 244) {
                                    return -1;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static synchronized List<wz> co(String str, boolean z2, boolean z3) throws zn {
        gv vVar;
        synchronized (x4.class) {
            try {
                n3 n3Var = new n3(str, z2, z3);
                HashMap<n3, List<wz>> hashMap = f8476n3;
                List<wz> list = hashMap.get(n3Var);
                if (list != null) {
                    return list;
                }
                int i = j5.y;
                if (i >= 21) {
                    vVar = new a(z2, z3);
                } else {
                    vVar = new v();
                }
                ArrayList<wz> z4 = z(n3Var, vVar);
                if (z2 && z4.isEmpty() && 21 <= i && i <= 23) {
                    z4 = z(n3Var, new v());
                    if (!z4.isEmpty()) {
                        v5.r.c5("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + z4.get(0).y);
                    }
                }
                v(str, z4);
                z0.x4 d2 = z0.x4.d(z4);
                hashMap.put(n3Var, d2);
                return d2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d(MediaCodecInfo mediaCodecInfo, String str) {
        if (j5.y >= 29) {
            return z6(mediaCodecInfo);
        }
        if (n.xc(str)) {
            return true;
        }
        String v2 = w0.zn.v(mediaCodecInfo.getName());
        if (v2.startsWith("arc.")) {
            return false;
        }
        if (v2.startsWith("omx.google.") || v2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((v2.startsWith("omx.sec.") && v2.contains(".sw.")) || v2.equals("omx.qcom.video.decoder.hevcswvdec") || v2.startsWith("c2.android.") || v2.startsWith("c2.google.")) {
            return true;
        }
        if (!v2.startsWith("omx.") && !v2.startsWith("c2.")) {
            return true;
        }
        return false;
    }

    public static boolean d0(MediaCodecInfo mediaCodecInfo) {
        if (j5.y >= 29 && fh(mediaCodecInfo)) {
            return true;
        }
        return false;
    }

    public static boolean ej(MediaCodecInfo mediaCodecInfo) {
        if (j5.y >= 29) {
            return ud(mediaCodecInfo);
        }
        String v2 = w0.zn.v(mediaCodecInfo.getName());
        if (!v2.startsWith("omx.google.") && !v2.startsWith("c2.android.") && !v2.startsWith("c2.google.")) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Integer f(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            case '\b':
                return 256;
            case '\t':
                return 512;
            default:
                return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> f3(String str, String[] strArr, @Nullable wn.zn znVar) {
        if (strArr.length < 4) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = y.matcher(strArr[1]);
        if (!matcher.matches()) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if ("2".equals(group)) {
                if (znVar != null && znVar.f14660fb == 6) {
                    i = 4096;
                } else {
                    i = 2;
                }
            } else {
                v5.r.c5("MediaCodecUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer c2 = c(str2);
        if (c2 == null) {
            v5.r.c5("MediaCodecUtil", "Unknown HEVC level string: " + str2);
            return null;
        }
        return new Pair<>(Integer.valueOf(i), c2);
    }

    public static int fb(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return NotificationCompat.FLAG_HIGH_PRIORITY;
                    default:
                        switch (i) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static boolean fh(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static <T> void hw(List<T> list, final fb<T> fbVar) {
        Collections.sort(list, new Comparator() { // from class: h3.z
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k52;
                k52 = x4.k5(x4.fb.this, obj, obj2);
                return k52;
            }
        });
    }

    @Nullable
    public static Pair<Integer, Integer> i4(String str, String[] strArr) {
        if (strArr.length < 3) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = y.matcher(strArr[1]);
        if (!matcher.matches()) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer f4 = f(group);
        if (f4 == null) {
            v5.r.c5("MediaCodecUtil", "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer i92 = i9(str2);
        if (i92 == null) {
            v5.r.c5("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
            return null;
        }
        return new Pair<>(f4, i92);
    }

    @Nullable
    public static Integer i9(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c2 = '\f';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return Integer.valueOf((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            case '\b':
                return 256;
            case '\t':
                return 512;
            case '\n':
                return 1024;
            case 11:
                return 2048;
            case '\f':
                return 4096;
            default:
                return null;
        }
    }

    public static int j5(int i) {
        if (i != 10) {
            if (i != 11) {
                if (i != 20) {
                    if (i != 21) {
                        if (i != 30) {
                            if (i != 31) {
                                if (i != 40) {
                                    if (i != 41) {
                                        if (i != 50) {
                                            if (i != 51) {
                                                switch (i) {
                                                    case 60:
                                                        return 2048;
                                                    case 61:
                                                        return 4096;
                                                    case 62:
                                                        return 8192;
                                                    default:
                                                        return -1;
                                                }
                                            }
                                            return 512;
                                        }
                                        return 256;
                                    }
                                    return NotificationCompat.FLAG_HIGH_PRIORITY;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static /* synthetic */ int k5(fb fbVar, Object obj, Object obj2) {
        return fbVar.getScore(obj2) - fbVar.getScore(obj);
    }

    public static boolean mg(MediaCodecInfo mediaCodecInfo, String str) {
        if (j5.y >= 29) {
            return ta(mediaCodecInfo);
        }
        return !d(mediaCodecInfo, str);
    }

    @Nullable
    public static wz mt(String str, boolean z2, boolean z3) throws zn {
        List<wz> co2 = co(str, z2, z3);
        if (co2.isEmpty()) {
            return null;
        }
        return co2.get(0);
    }

    @Nullable
    public static Pair<Integer, Integer> n(String str, String[] strArr) {
        if (strArr.length < 3) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int qn2 = qn(parseInt);
            if (qn2 == -1) {
                v5.r.c5("MediaCodecUtil", "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int j52 = j5(parseInt2);
            if (j52 == -1) {
                v5.r.c5("MediaCodecUtil", "Unknown VP9 level: " + parseInt2);
                return null;
            }
            return new Pair<>(Integer.valueOf(qn2), Integer.valueOf(j52));
        } catch (NumberFormatException unused) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    public static void o(String str, boolean z2, boolean z3) {
        try {
            co(str, z2, z3);
        } catch (zn e2) {
            v5.r.gv("MediaCodecUtil", "Codec warming failed", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if (r3.equals("av01") == false) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> p(m1.m r6) {
        /*
            r0 = 0
            java.lang.String r1 = r6.f10942co
            r2 = 0
            if (r1 != 0) goto L7
            return r2
        L7:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r6.f10948f3
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L1e
            java.lang.String r6 = r6.f10942co
            android.util.Pair r6 = i4(r6, r1)
            return r6
        L1e:
            r3 = r1[r0]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L6f;
                case 3006243: goto L64;
                case 3006244: goto L59;
                case 3199032: goto L4e;
                case 3214780: goto L43;
                case 3356560: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = -1
            goto L78
        L2d:
            java.lang.String r0 = "vp09"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L36
            goto L2b
        L36:
            r0 = 6
            goto L78
        L38:
            java.lang.String r0 = "mp4a"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L41
            goto L2b
        L41:
            r0 = 5
            goto L78
        L43:
            java.lang.String r0 = "hvc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L4c
            goto L2b
        L4c:
            r0 = 4
            goto L78
        L4e:
            java.lang.String r0 = "hev1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L57
            goto L2b
        L57:
            r0 = 3
            goto L78
        L59:
            java.lang.String r0 = "avc2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L62
            goto L2b
        L62:
            r0 = 2
            goto L78
        L64:
            java.lang.String r0 = "avc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6d
            goto L2b
        L6d:
            r0 = 1
            goto L78
        L6f:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L78
            goto L2b
        L78:
            switch(r0) {
                case 0: goto L9a;
                case 1: goto L93;
                case 2: goto L93;
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L83;
                case 6: goto L7c;
                default: goto L7b;
            }
        L7b:
            return r2
        L7c:
            java.lang.String r6 = r6.f10942co
            android.util.Pair r6 = n(r6, r1)
            return r6
        L83:
            java.lang.String r6 = r6.f10942co
            android.util.Pair r6 = t(r6, r1)
            return r6
        L8a:
            java.lang.String r0 = r6.f10942co
            wn.zn r6 = r6.f10952j
            android.util.Pair r6 = f3(r0, r1, r6)
            return r6
        L93:
            java.lang.String r6 = r6.f10942co
            android.util.Pair r6 = xc(r6, r1)
            return r6
        L9a:
            java.lang.String r0 = r6.f10942co
            wn.zn r6 = r6.f10952j
            android.util.Pair r6 = wz(r0, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.x4.p(m1.m):android.util.Pair");
    }

    public static int qn(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            if (i != 3) {
                return -1;
            }
            return 8;
        }
        return 4;
    }

    @CheckResult
    public static List<wz> r(List<wz> list, final m mVar) {
        ArrayList arrayList = new ArrayList(list);
        hw(arrayList, new fb() { // from class: h3.r
            @Override // h3.x4.fb
            public final int getScore(Object obj) {
                int b2;
                b2 = x4.b(m.this, (wz) obj);
                return b2;
            }
        });
        return arrayList;
    }

    public static boolean rz(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i = j5.y;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = j5.f14363n3;
            if ("a70".equals(str3) || ("Xiaomi".equals(j5.f14370zn) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = j5.f14363n3;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = j5.f14363n3;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(j5.f14370zn))) {
            String str6 = j5.f14363n3;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(j5.f14370zn)) {
            String str7 = j5.f14363n3;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && j5.f14363n3.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (i <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return false;
        }
        return true;
    }

    public static int s(int i) {
        if (i != 1 && i != 2) {
            switch (i) {
                case 8:
                case 16:
                case 32:
                    return 101376;
                case 64:
                    return 202752;
                case NotificationCompat.FLAG_HIGH_PRIORITY /* 128 */:
                case 256:
                    return 414720;
                case 512:
                    return 921600;
                case 1024:
                    return 1310720;
                case 2048:
                case 4096:
                    return 2097152;
                case 8192:
                    return 2228224;
                case 16384:
                    return 5652480;
                case 32768:
                case 65536:
                    return 9437184;
                case 131072:
                case 262144:
                case 524288:
                    return 35651584;
                default:
                    return -1;
            }
        }
        return 25344;
    }

    @Nullable
    public static Pair<Integer, Integer> t(String str, String[] strArr) {
        int vl2;
        if (strArr.length != 3) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(n.s(Integer.parseInt(strArr[1], 16))) && (vl2 = vl(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(vl2), 0);
            }
        } catch (NumberFormatException unused) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    public static boolean ta(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    @Nullable
    public static String tl(m mVar) {
        Pair<Integer, Integer> p2;
        if ("audio/eac3-joc".equals(mVar.f10948f3)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(mVar.f10948f3) && (p2 = p(mVar)) != null) {
            int intValue = ((Integer) p2.first).intValue();
            if (intValue != 16 && intValue != 256) {
                if (intValue == 512) {
                    return "video/avc";
                }
                return null;
            }
            return "video/hevc";
        }
        return null;
    }

    public static boolean ud(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static void v(String str, List<wz> list) {
        if ("audio/raw".equals(str)) {
            if (j5.y < 26 && j5.f14363n3.equals("R9") && list.size() == 1 && list.get(0).y.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(wz.ej("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            hw(list, new fb() { // from class: h3.mt
                @Override // h3.x4.fb
                public final int getScore(Object obj) {
                    int a82;
                    a82 = x4.a8((wz) obj);
                    return a82;
                }
            });
        }
        int i = j5.y;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).y;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                hw(list, new fb() { // from class: h3.co
                    @Override // h3.x4.fb
                    public final int getScore(Object obj) {
                        int x2;
                        x2 = x4.x((wz) obj);
                        return x2;
                    }
                });
            }
        }
        if (i < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).y)) {
            list.add(list.remove(0));
        }
    }

    public static int vl(int i) {
        int i5 = 17;
        if (i != 17) {
            i5 = 20;
            if (i != 20) {
                i5 = 23;
                if (i != 23) {
                    i5 = 29;
                    if (i != 29) {
                        i5 = 39;
                        if (i != 39) {
                            i5 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i5;
    }

    @Nullable
    public static String w(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        String[] supportedTypes;
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
                return "audio/lg-ac3";
            }
            return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> wz(String str, String[] strArr, @Nullable wn.zn znVar) {
        int i;
        if (strArr.length < 4) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i5 = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                v5.r.c5("MediaCodecUtil", "Unknown AV1 profile: " + parseInt);
                return null;
            } else if (parseInt3 != 8 && parseInt3 != 10) {
                v5.r.c5("MediaCodecUtil", "Unknown AV1 bit depth: " + parseInt3);
                return null;
            } else {
                if (parseInt3 != 8) {
                    if (znVar != null && (znVar.f14661s != null || (i = znVar.f14660fb) == 7 || i == 6)) {
                        i5 = 4096;
                    } else {
                        i5 = 2;
                    }
                }
                int a2 = a(parseInt2);
                if (a2 == -1) {
                    v5.r.c5("MediaCodecUtil", "Unknown AV1 level: " + parseInt2);
                    return null;
                }
                return new Pair<>(Integer.valueOf(i5), Integer.valueOf(a2));
            }
        } catch (NumberFormatException unused) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    public static /* synthetic */ int x(wz wzVar) {
        return wzVar.y.startsWith("OMX.google") ? 1 : 0;
    }

    @Nullable
    public static wz x4() throws zn {
        return mt("audio/raw", false, false);
    }

    @Nullable
    public static Pair<Integer, Integer> xc(String str, String[] strArr) {
        int parseInt;
        int i;
        if (strArr.length < 2) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i = Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt2 = Integer.parseInt(strArr[1]);
                parseInt = Integer.parseInt(strArr[2]);
                i = parseInt2;
            } else {
                v5.r.c5("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int c52 = c5(i);
            if (c52 == -1) {
                v5.r.c5("MediaCodecUtil", "Unknown AVC profile: " + i);
                return null;
            }
            int fb2 = fb(parseInt);
            if (fb2 == -1) {
                v5.r.c5("MediaCodecUtil", "Unknown AVC level: " + parseInt);
                return null;
            }
            return new Pair<>(Integer.valueOf(c52), Integer.valueOf(fb2));
        } catch (NumberFormatException unused) {
            v5.r.c5("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    public static int yt() throws zn {
        int i;
        if (f8477zn == -1) {
            int i5 = 0;
            wz mt2 = mt("video/avc", false, false);
            if (mt2 != null) {
                MediaCodecInfo.CodecProfileLevel[] i92 = mt2.i9();
                int length = i92.length;
                int i6 = 0;
                while (i5 < length) {
                    i6 = Math.max(s(i92[i5].level), i6);
                    i5++;
                }
                if (j5.y >= 21) {
                    i = 345600;
                } else {
                    i = 172800;
                }
                i5 = Math.max(i6, i);
            }
            f8477zn = i5;
        }
        return f8477zn;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(4:(2:72|73)|53|(9:56|57|58|59|60|61|62|64|65)|9)|32|33|34|36|9) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
        if (r1.f8479n3 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[Catch: Exception -> 0x012e, TRY_ENTER, TryCatch #1 {Exception -> 0x012e, blocks: (B:3:0x0008, B:5:0x001b, B:61:0x0124, B:8:0x002d, B:11:0x0038, B:55:0x00fd, B:58:0x0105, B:60:0x010b, B:64:0x0130, B:65:0x0153), top: B:71:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<h3.wz> z(h3.x4.n3 r24, h3.x4.gv r25) throws h3.x4.zn {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.x4.z(h3.x4$n3, h3.x4$gv):java.util.ArrayList");
    }

    public static boolean z6(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }
}
