package d9;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import m1.m;
import v5.j5;
import z0.en;
import z0.f3;
import z0.x4;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: n3  reason: collision with root package name */
    public final int f6967n3;
    public final int[] y;

    /* renamed from: zn  reason: collision with root package name */
    public static final a f6966zn = new a(new int[]{2}, 8);

    /* renamed from: gv  reason: collision with root package name */
    public static final a f6964gv = new a(new int[]{2, 5, 6}, 8);

    /* renamed from: v  reason: collision with root package name */
    public static final z0.f3<Integer, Integer> f6965v = new f3.y().gv(5, 6).gv(17, 6).gv(7, 6).gv(18, 6).gv(6, 8).gv(8, 8).gv(14, 8).n3();

    /* loaded from: classes.dex */
    public static final class y {
        public static final AudioAttributes y = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        public static int n3(int i, int i5) {
            for (int i6 = 8; i6 > 0; i6--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i5).setChannelMask(j5.z6(i6)).build(), y)) {
                    return i6;
                }
            }
            return 0;
        }

        public static int[] y() {
            x4.y x42 = z0.x4.x4();
            en it = a.f6965v.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(48000).build(), y)) {
                    x42.y(num);
                }
            }
            x42.y(2);
            return d1.a.wz(x42.s());
        }
    }

    public a(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.y = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.y = new int[0];
        }
        this.f6967n3 = i;
    }

    public static int fb(int i, int i5) {
        if (j5.y >= 29) {
            return y.n3(i, i5);
        }
        return ((Integer) v5.y.v(f6965v.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    @SuppressLint({"InlinedApi"})
    public static a gv(Context context, @Nullable Intent intent) {
        if (n3() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f6964gv;
        }
        if (j5.y >= 29 && (j5.tg(context) || j5.m(context))) {
            return new a(y.y(), 8);
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new a(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return f6966zn;
    }

    public static boolean n3() {
        if (j5.y >= 17) {
            String str = j5.f14370zn;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int v(int i) {
        int i5 = j5.y;
        if (i5 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i5 <= 26 && "fugu".equals(j5.f14363n3) && i == 1) {
            i = 2;
        }
        return j5.z6(i);
    }

    public static a zn(Context context) {
        return gv(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @Nullable
    public Pair<Integer, Integer> a(m mVar) {
        int a2 = v5.n.a((String) v5.y.v(mVar.f10948f3), mVar.f10942co);
        if (!f6965v.containsKey(Integer.valueOf(a2))) {
            return null;
        }
        if (a2 == 18 && !c5(18)) {
            a2 = 6;
        } else if (a2 == 8 && !c5(8)) {
            a2 = 7;
        }
        if (!c5(a2)) {
            return null;
        }
        int i = mVar.f10958oz;
        if (i != -1 && a2 != 18) {
            if (i > this.f6967n3) {
                return null;
            }
        } else {
            int i5 = mVar.f10966ut;
            if (i5 == -1) {
                i5 = 48000;
            }
            i = fb(a2, i5);
        }
        int v2 = v(i);
        if (v2 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(a2), Integer.valueOf(v2));
    }

    public boolean c5(int i) {
        if (Arrays.binarySearch(this.y, i) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Arrays.equals(this.y, aVar.y) && this.f6967n3 == aVar.f6967n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6967n3 + (Arrays.hashCode(this.y) * 31);
    }

    public boolean s(m mVar) {
        if (a(mVar) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f6967n3 + ", supportedEncodings=" + Arrays.toString(this.y) + "]";
    }
}
