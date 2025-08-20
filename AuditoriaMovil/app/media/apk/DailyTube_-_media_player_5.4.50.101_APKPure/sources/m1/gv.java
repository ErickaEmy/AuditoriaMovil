package m1;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import m1.gv;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: a  reason: collision with root package name */
    public int f10768a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f10769c5;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public d9.v f10771gv;

    /* renamed from: n3  reason: collision with root package name */
    public final y f10772n3;

    /* renamed from: s  reason: collision with root package name */
    public AudioFocusRequest f10773s;
    public final AudioManager y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public n3 f10775zn;

    /* renamed from: fb  reason: collision with root package name */
    public float f10770fb = 1.0f;

    /* renamed from: v  reason: collision with root package name */
    public int f10774v = 0;

    /* loaded from: classes.dex */
    public interface n3 {
        void fh(float f4);

        void rz(int i);
    }

    /* loaded from: classes.dex */
    public class y implements AudioManager.OnAudioFocusChangeListener {
        public final Handler y;

        public y(Handler handler) {
            this.y = handler;
        }

        public final /* synthetic */ void n3(int i) {
            gv.this.s(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.y.post(new Runnable() { // from class: m1.zn
                @Override // java.lang.Runnable
                public final void run() {
                    gv.y.this.n3(i);
                }
            });
        }
    }

    public gv(Context context, Handler handler, n3 n3Var) {
        this.y = (AudioManager) v5.y.v((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f10775zn = n3Var;
        this.f10772n3 = new y(handler);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int v(@Nullable d9.v vVar) {
        if (vVar == null) {
            return 0;
        }
        switch (vVar.f7207fb) {
            case 0:
                v5.r.c5("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (vVar.y == 1) {
                    return 2;
                }
                break;
            case 15:
            default:
                v5.r.c5("AudioFocusManager", "Unidentified audio usage: " + vVar.f7207fb);
                return 0;
            case 16:
                if (v5.j5.y < 19) {
                    return 2;
                }
                return 4;
        }
        return 3;
    }

    public final void a(int i) {
        n3 n3Var = this.f10775zn;
        if (n3Var != null) {
            n3Var.rz(i);
        }
    }

    public void c5() {
        this.f10775zn = null;
        n3();
    }

    public final int f() {
        return this.y.requestAudioFocus(this.f10772n3, v5.j5.rs(((d9.v) v5.y.v(this.f10771gv)).f7207fb), this.f10768a);
    }

    public float fb() {
        return this.f10770fb;
    }

    public final int i9() {
        int f4;
        if (this.f10774v == 1) {
            return 1;
        }
        if (v5.j5.y >= 26) {
            f4 = t();
        } else {
            f4 = f();
        }
        if (f4 == 1) {
            wz(1);
            return 1;
        }
        wz(0);
        return -1;
    }

    public final void n3() {
        if (this.f10774v == 0) {
            return;
        }
        if (v5.j5.y >= 26) {
            zn();
        } else {
            y();
        }
        wz(0);
    }

    public final boolean p() {
        d9.v vVar = this.f10771gv;
        if (vVar != null && vVar.y == 1) {
            return true;
        }
        return false;
    }

    public final void s(int i) {
        if (i != -3 && i != -2) {
            if (i != -1) {
                if (i != 1) {
                    v5.r.c5("AudioFocusManager", "Unknown focus change type: " + i);
                    return;
                }
                wz(1);
                a(1);
                return;
            }
            a(-1);
            n3();
        } else if (i != -2 && !p()) {
            wz(3);
        } else {
            a(0);
            wz(2);
        }
    }

    public final int t() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.f10773s;
        if (audioFocusRequest == null || this.f10769c5) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.f10768a);
            } else {
                builder = new AudioFocusRequest.Builder(this.f10773s);
            }
            this.f10773s = builder.setAudioAttributes(((d9.v) v5.y.v(this.f10771gv)).n3().y).setWillPauseWhenDucked(p()).setOnAudioFocusChangeListener(this.f10772n3).build();
            this.f10769c5 = false;
        }
        return this.y.requestAudioFocus(this.f10773s);
    }

    public void tl(@Nullable d9.v vVar) {
        if (!v5.j5.zn(this.f10771gv, vVar)) {
            this.f10771gv = vVar;
            int v2 = v(vVar);
            this.f10768a = v2;
            boolean z2 = true;
            if (v2 != 1 && v2 != 0) {
                z2 = false;
            }
            v5.y.n3(z2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int w(boolean z2, int i) {
        if (xc(i)) {
            n3();
            if (!z2) {
                return -1;
            }
            return 1;
        } else if (!z2) {
            return -1;
        } else {
            return i9();
        }
    }

    public final void wz(int i) {
        float f4;
        if (this.f10774v == i) {
            return;
        }
        this.f10774v = i;
        if (i == 3) {
            f4 = 0.2f;
        } else {
            f4 = 1.0f;
        }
        if (this.f10770fb == f4) {
            return;
        }
        this.f10770fb = f4;
        n3 n3Var = this.f10775zn;
        if (n3Var != null) {
            n3Var.fh(f4);
        }
    }

    public final boolean xc(int i) {
        if (i == 1 || this.f10768a != 1) {
            return true;
        }
        return false;
    }

    public final void y() {
        this.y.abandonAudioFocus(this.f10772n3);
    }

    public final void zn() {
        AudioFocusRequest audioFocusRequest = this.f10773s;
        if (audioFocusRequest != null) {
            this.y.abandonAudioFocusRequest(audioFocusRequest);
        }
    }
}
