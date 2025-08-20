package h3;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import h3.x4;
import java.util.List;
import m1.m;
import v5.j5;
import v5.n;
/* loaded from: classes.dex */
public final class wz {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8466a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f8467c5;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8468f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f8469fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f8470gv;

    /* renamed from: i9  reason: collision with root package name */
    public final boolean f8471i9;

    /* renamed from: n3  reason: collision with root package name */
    public final String f8472n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f8473s;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f8474v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f8475zn;

    /* loaded from: classes.dex */
    public static final class y {
        public static int y(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i5, double d2) {
            List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty() || wz.y()) {
                return 0;
            }
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i5, (int) d2);
            for (int i6 = 0; i6 < supportedPerformancePoints.size(); i6++) {
                if (supportedPerformancePoints.get(i6).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    public wz(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8) {
        this.y = (String) v5.y.v(str);
        this.f8472n3 = str2;
        this.f8475zn = str3;
        this.f8470gv = codecCapabilities;
        this.f8473s = z2;
        this.f8467c5 = z3;
        this.f8471i9 = z4;
        this.f8474v = z5;
        this.f8466a = z7;
        this.f8469fb = z8;
        this.f8468f = n.co(str2);
    }

    public static int c5(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    public static boolean d(String str, int i) {
        if ("video/hevc".equals(str) && 2 == i) {
            String str2 = j5.f14363n3;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static wz ej(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7) {
        boolean z8;
        boolean z9;
        boolean z10;
        if (!z5 && codecCapabilities != null && f(codecCapabilities) && !mg(str)) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (codecCapabilities != null && i4(codecCapabilities)) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z7 && (codecCapabilities == null || !r(codecCapabilities))) {
            z10 = false;
        } else {
            z10 = true;
        }
        return new wz(str, str2, str3, codecCapabilities, z2, z3, z4, z8, z9, z10);
    }

    public static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (j5.y >= 19 && t(codecCapabilities)) {
            return true;
        }
        return false;
    }

    public static boolean f3(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static MediaCodecInfo.CodecProfileLevel[] fb(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i;
        int i5;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            i = videoCapabilities.getBitrateRange().getUpper().intValue();
        } else {
            i = 0;
        }
        if (i >= 180000000) {
            i5 = 1024;
        } else if (i >= 120000000) {
            i5 = 512;
        } else if (i >= 60000000) {
            i5 = 256;
        } else if (i >= 30000000) {
            i5 = NotificationCompat.FLAG_HIGH_PRIORITY;
        } else if (i >= 18000000) {
            i5 = 64;
        } else if (i >= 12000000) {
            i5 = 32;
        } else if (i >= 7200000) {
            i5 = 16;
        } else if (i >= 3600000) {
            i5 = 8;
        } else if (i >= 1800000) {
            i5 = 4;
        } else if (i >= 800000) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i5;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public static boolean fh(String str) {
        return "audio/opus".equals(str);
    }

    public static Point gv(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i5) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(j5.t(i, widthAlignment) * widthAlignment, j5.t(i5, heightAlignment) * heightAlignment);
    }

    public static boolean i4(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (j5.y >= 21 && f3(codecCapabilities)) {
            return true;
        }
        return false;
    }

    public static boolean mg(String str) {
        if (j5.y <= 22) {
            String str2 = j5.f14361gv;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static int n3(String str, String str2, int i) {
        int i5;
        if (i <= 1 && ((j5.y < 26 || i <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
            if ("audio/ac3".equals(str2)) {
                i5 = 6;
            } else if ("audio/eac3".equals(str2)) {
                i5 = 16;
            } else {
                i5 = 30;
            }
            v5.r.c5("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i5 + "]");
            return i5;
        }
        return i;
    }

    public static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (j5.y >= 21 && x4(codecCapabilities)) {
            return true;
        }
        return false;
    }

    public static boolean rz(String str) {
        if (j5.f14361gv.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean ta() {
        String str = j5.f14363n3;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = j5.f14361gv;
            if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i5, double d2) {
        Point gv2 = gv(videoCapabilities, i, i5);
        int i6 = gv2.x;
        int i8 = gv2.y;
        if (d2 != -1.0d && d2 >= 1.0d) {
            return videoCapabilities.areSizeAndRateSupported(i6, i8, Math.floor(d2));
        }
        return videoCapabilities.isSizeSupported(i6, i8);
    }

    public static boolean x4(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static /* synthetic */ boolean y() {
        return ta();
    }

    public static boolean z6(String str) {
        if ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(j5.f14363n3)) {
            return false;
        }
        return true;
    }

    public a9.c5 a(m mVar, m mVar2) {
        int i;
        int i5;
        if (!j5.zn(mVar.f10948f3, mVar2.f10948f3)) {
            i = 8;
        } else {
            i = 0;
        }
        if (this.f8468f) {
            if (mVar.f10940b != mVar2.f10940b) {
                i |= 1024;
            }
            if (!this.f8474v && (mVar.f10943d != mVar2.f10943d || mVar.f10945ej != mVar2.f10945ej)) {
                i |= 512;
            }
            if (!j5.zn(mVar.f10952j, mVar2.f10952j)) {
                i |= 2048;
            }
            if (rz(this.y) && !mVar.fb(mVar2)) {
                i |= 2;
            }
            if (i == 0) {
                String str = this.y;
                if (mVar.fb(mVar2)) {
                    i5 = 3;
                } else {
                    i5 = 2;
                }
                return new a9.c5(str, mVar, mVar2, i5, 0);
            }
        } else {
            if (mVar.f10958oz != mVar2.f10958oz) {
                i |= 4096;
            }
            if (mVar.f10966ut != mVar2.f10966ut) {
                i |= 8192;
            }
            if (mVar.f10960q9 != mVar2.f10960q9) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.f8472n3)) {
                Pair<Integer, Integer> p2 = x4.p(mVar);
                Pair<Integer, Integer> p3 = x4.p(mVar2);
                if (p2 != null && p3 != null) {
                    int intValue = ((Integer) p2.first).intValue();
                    int intValue2 = ((Integer) p3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new a9.c5(this.y, mVar, mVar2, 3, 0);
                    }
                }
            }
            if (!mVar.fb(mVar2)) {
                i |= 32;
            }
            if (fh(this.f8472n3)) {
                i |= 2;
            }
            if (i == 0) {
                return new a9.c5(this.y, mVar, mVar2, 1, 0);
            }
        }
        return new a9.c5(this.y, mVar, mVar2, 0, i);
    }

    public final void c(String str) {
        v5.r.n3("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.y + ", " + this.f8472n3 + "] [" + j5.f14367v + "]");
    }

    public final boolean co(m mVar) {
        if (!this.f8472n3.equals(mVar.f10948f3) && !this.f8472n3.equals(x4.tl(mVar))) {
            return false;
        }
        return true;
    }

    public final void d0(String str) {
        v5.r.n3("MediaCodecInfo", "NoSupport [" + str + "] [" + this.y + ", " + this.f8472n3 + "] [" + j5.f14367v + "]");
    }

    public MediaCodecInfo.CodecProfileLevel[] i9() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8470gv;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return codecProfileLevelArr;
    }

    public boolean mt() {
        if (j5.y >= 29 && "video/x-vnd.on2.vp9".equals(this.f8472n3)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i9()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean n(int i, int i5, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8470gv;
        if (codecCapabilities == null) {
            d0("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            d0("sizeAndRate.vCaps");
            return false;
        }
        if (j5.y >= 29) {
            int y2 = y.y(videoCapabilities, i, i5, d2);
            if (y2 == 2) {
                return true;
            }
            if (y2 == 1) {
                d0("sizeAndRate.cover, " + i + "x" + i5 + "@" + d2);
                return false;
            }
        }
        if (!v(videoCapabilities, i, i5, d2)) {
            if (i < i5 && z6(this.y) && v(videoCapabilities, i5, i, d2)) {
                c("sizeAndRate.rotated, " + i + "x" + i5 + "@" + d2);
            } else {
                d0("sizeAndRate.support, " + i + "x" + i5 + "@" + d2);
                return false;
            }
        }
        return true;
    }

    public boolean p(m mVar) throws x4.zn {
        int i;
        boolean z2 = false;
        if (!co(mVar) || !xc(mVar, true)) {
            return false;
        }
        if (this.f8468f) {
            int i5 = mVar.f10943d;
            if (i5 <= 0 || (i = mVar.f10945ej) <= 0) {
                return true;
            }
            if (j5.y >= 21) {
                return n(i5, i, mVar.f10969x);
            }
            if (i5 * i <= x4.yt()) {
                z2 = true;
            }
            if (!z2) {
                d0("legacyFrameSize, " + mVar.f10943d + "x" + mVar.f10945ej);
            }
            return z2;
        }
        if (j5.y >= 21) {
            int i6 = mVar.f10966ut;
            if (i6 != -1 && !wz(i6)) {
                return false;
            }
            int i8 = mVar.f10958oz;
            if (i8 != -1 && !tl(i8)) {
                return false;
            }
        }
        return true;
    }

    public int s() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (j5.y >= 23 && (codecCapabilities = this.f8470gv) != null) {
            return c5(codecCapabilities);
        }
        return -1;
    }

    public boolean tl(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8470gv;
        if (codecCapabilities == null) {
            d0("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            d0("channelCount.aCaps");
            return false;
        } else if (n3(this.y, this.f8472n3, audioCapabilities.getMaxInputChannelCount()) < i) {
            d0("channelCount.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return this.y;
    }

    public boolean w(m mVar) {
        if (!co(mVar) || !xc(mVar, false)) {
            return false;
        }
        return true;
    }

    public boolean wz(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8470gv;
        if (codecCapabilities == null) {
            d0("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            d0("sampleRate.aCaps");
            return false;
        } else if (!audioCapabilities.isSampleRateSupported(i)) {
            d0("sampleRate.support, " + i);
            return false;
        } else {
            return true;
        }
    }

    public final boolean xc(m mVar, boolean z2) {
        Pair<Integer, Integer> p2 = x4.p(mVar);
        if (p2 == null) {
            return true;
        }
        int intValue = ((Integer) p2.first).intValue();
        int intValue2 = ((Integer) p2.second).intValue();
        if ("video/dolby-vision".equals(mVar.f10948f3)) {
            if ("video/avc".equals(this.f8472n3)) {
                intValue = 8;
            } else {
                intValue = "video/hevc".equals(this.f8472n3) ? 2 : 2;
            }
            intValue2 = 0;
        }
        if (!this.f8468f && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] i92 = i9();
        if (j5.y <= 23 && "video/x-vnd.on2.vp9".equals(this.f8472n3) && i92.length == 0) {
            i92 = fb(this.f8470gv);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i92) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z2) && !d(this.f8472n3, intValue))) {
                return true;
            }
        }
        d0("codec.profileLevel, " + mVar.f10942co + ", " + this.f8475zn);
        return false;
    }

    public boolean z(m mVar) {
        if (this.f8468f) {
            return this.f8474v;
        }
        Pair<Integer, Integer> p2 = x4.p(mVar);
        if (p2 != null && ((Integer) p2.first).intValue() == 42) {
            return true;
        }
        return false;
    }

    @Nullable
    public Point zn(int i, int i5) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f8470gv;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return gv(videoCapabilities, i, i5);
    }
}
