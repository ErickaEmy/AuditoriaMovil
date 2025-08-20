package m1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import d9.rz;
import h3.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class tl implements gn {

    /* renamed from: c5  reason: collision with root package name */
    public boolean f11251c5;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f11252fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11255s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f11256v;
    public final Context y;

    /* renamed from: n3  reason: collision with root package name */
    public final h3.i9 f11254n3 = new h3.i9();

    /* renamed from: zn  reason: collision with root package name */
    public int f11257zn = 0;

    /* renamed from: gv  reason: collision with root package name */
    public long f11253gv = 5000;

    /* renamed from: a  reason: collision with root package name */
    public h3.p f11250a = h3.p.y;

    public tl(Context context) {
        this.y = context;
    }

    public tl c5() {
        this.f11254n3.n3();
        return this;
    }

    public t.n3 f() {
        return this.f11254n3;
    }

    public void fb(Context context, qh.w wVar, Looper looper, int i, ArrayList<zq> arrayList) {
        arrayList.add(new qh.p(wVar, looper));
    }

    public void gv(Context context, int i, ArrayList<zq> arrayList) {
        arrayList.add(new gk.n3());
    }

    public tl i9() {
        this.f11254n3.zn();
        return this;
    }

    public void n3(Context context, int i, h3.p pVar, boolean z2, d9.x4 x4Var, Handler handler, d9.z zVar, ArrayList<zq> arrayList) {
        int i5;
        int i6;
        int i8;
        arrayList.add(new d9.ej(context, f(), pVar, z2, handler, zVar, x4Var));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i5 = size + 1;
                try {
                    arrayList.add(size, (zq) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(null).newInstance(null));
                    v5.r.a("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i5;
                    i5 = size;
                    try {
                        i6 = i5 + 1;
                        arrayList.add(i5, (zq) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                        v5.r.a("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused2) {
                    }
                    try {
                        i8 = i6 + 1;
                        try {
                            arrayList.add(i6, (zq) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                            v5.r.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused3) {
                            i6 = i8;
                            i8 = i6;
                            arrayList.add(i8, (zq) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                            v5.r.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                    arrayList.add(i8, (zq) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                    v5.r.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating MIDI extension", e2);
            }
        } catch (ClassNotFoundException unused5) {
        }
        try {
            i6 = i5 + 1;
            try {
                try {
                    arrayList.add(i5, (zq) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                    v5.r.a("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused6) {
                    i5 = i6;
                    i6 = i5;
                    i8 = i6 + 1;
                    arrayList.add(i6, (zq) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                    v5.r.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    arrayList.add(i8, (zq) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                    v5.r.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
                i8 = i6 + 1;
                arrayList.add(i6, (zq) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                v5.r.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                try {
                    arrayList.add(i8, (zq) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, d9.z.class, d9.x4.class).newInstance(handler, zVar, x4Var));
                    v5.r.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused7) {
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e3);
                }
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating FLAC extension", e5);
            }
        } catch (Exception e6) {
            throw new RuntimeException("Error instantiating Opus extension", e6);
        }
    }

    public void s(Context context, int i, h3.p pVar, boolean z2, Handler handler, wn.n nVar, long j2, ArrayList<zq> arrayList) {
        String str;
        int i5;
        arrayList.add(new wn.s(context, f(), pVar, j2, z2, handler, nVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i5 = size + 1;
                try {
                    arrayList.add(size, (zq) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, wn.n.class, Integer.TYPE).newInstance(Long.valueOf(j2), handler, nVar, 50));
                    str = "DefaultRenderersFactory";
                    try {
                        v5.r.a(str, "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused) {
                        size = i5;
                        i5 = size;
                        arrayList.add(i5, (zq) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, wn.n.class, Integer.TYPE).newInstance(Long.valueOf(j2), handler, nVar, 50));
                        v5.r.a(str, "Loaded Libgav1VideoRenderer.");
                    }
                } catch (ClassNotFoundException unused2) {
                    str = "DefaultRenderersFactory";
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating VP9 extension", e2);
            }
        } catch (ClassNotFoundException unused3) {
            str = "DefaultRenderersFactory";
        }
        try {
            arrayList.add(i5, (zq) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, wn.n.class, Integer.TYPE).newInstance(Long.valueOf(j2), handler, nVar, 50));
            v5.r.a(str, "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused4) {
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating AV1 extension", e3);
        }
    }

    public tl t(boolean z2) {
        this.f11256v = z2;
        return this;
    }

    public tl tl(h3.p pVar) {
        this.f11250a = pVar;
        return this;
    }

    public void v(Context context, hd.v vVar, Looper looper, int i, ArrayList<zq> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.y(vVar, looper));
    }

    @Override // m1.gn
    public zq[] y(Handler handler, wn.n nVar, d9.z zVar, qh.w wVar, hd.v vVar) {
        ArrayList<zq> arrayList = new ArrayList<>();
        s(this.y, this.f11257zn, this.f11250a, this.f11256v, handler, nVar, this.f11253gv, arrayList);
        d9.x4 zn2 = zn(this.y, this.f11252fb, this.f11255s, this.f11251c5);
        if (zn2 != null) {
            n3(this.y, this.f11257zn, this.f11250a, this.f11256v, zn2, handler, zVar, arrayList);
        }
        fb(this.y, wVar, handler.getLooper(), this.f11257zn, arrayList);
        v(this.y, vVar, handler.getLooper(), this.f11257zn, arrayList);
        gv(this.y, this.f11257zn, arrayList);
        a(this.y, handler, this.f11257zn, arrayList);
        return (zq[]) arrayList.toArray(new zq[0]);
    }

    @Nullable
    public d9.x4 zn(Context context, boolean z2, boolean z3, boolean z4) {
        return new rz.fb().fb(d9.a.zn(context)).i9(z2).c5(z3).f(z4 ? 1 : 0).a();
    }

    public void a(Context context, Handler handler, int i, ArrayList<zq> arrayList) {
    }
}
