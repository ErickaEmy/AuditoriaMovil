package d9;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: a  reason: collision with root package name */
    public long f7041a;

    /* renamed from: gv  reason: collision with root package name */
    public long f7042gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f7043n3;

    /* renamed from: v  reason: collision with root package name */
    public long f7044v;
    @Nullable
    public final y y;

    /* renamed from: zn  reason: collision with root package name */
    public long f7045zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public long f7046gv;

        /* renamed from: n3  reason: collision with root package name */
        public final AudioTimestamp f7047n3 = new AudioTimestamp();

        /* renamed from: v  reason: collision with root package name */
        public long f7048v;
        public final AudioTrack y;

        /* renamed from: zn  reason: collision with root package name */
        public long f7049zn;

        public y(AudioTrack audioTrack) {
            this.y = audioTrack;
        }

        public long n3() {
            return this.f7047n3.nanoTime / 1000;
        }

        public long y() {
            return this.f7048v;
        }

        public boolean zn() {
            boolean timestamp = this.y.getTimestamp(this.f7047n3);
            if (timestamp) {
                long j2 = this.f7047n3.framePosition;
                if (this.f7046gv > j2) {
                    this.f7049zn++;
                }
                this.f7046gv = j2;
                this.f7048v = j2 + (this.f7049zn << 32);
            }
            return timestamp;
        }
    }

    public i4(AudioTrack audioTrack) {
        if (j5.y >= 19) {
            this.y = new y(audioTrack);
            fb();
            return;
        }
        this.y = null;
        s(3);
    }

    public void a() {
        s(4);
    }

    public void fb() {
        if (this.y != null) {
            s(0);
        }
    }

    public boolean gv() {
        if (this.f7043n3 == 2) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    public long n3() {
        y yVar = this.y;
        if (yVar != null) {
            return yVar.y();
        }
        return -1L;
    }

    public final void s(int i) {
        this.f7043n3 = i;
        if (i != 0) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i == 4) {
                        this.f7042gv = 500000L;
                        return;
                    }
                    throw new IllegalStateException();
                }
                this.f7042gv = 10000000L;
                return;
            }
            this.f7042gv = 10000L;
            return;
        }
        this.f7044v = 0L;
        this.f7041a = -1L;
        this.f7045zn = System.nanoTime() / 1000;
        this.f7042gv = 10000L;
    }

    @TargetApi(19)
    public boolean v(long j2) {
        y yVar = this.y;
        if (yVar == null || j2 - this.f7044v < this.f7042gv) {
            return false;
        }
        this.f7044v = j2;
        boolean zn2 = yVar.zn();
        int i = this.f7043n3;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zn2) {
                        fb();
                    }
                } else if (!zn2) {
                    fb();
                }
            } else if (zn2) {
                if (this.y.y() > this.f7041a) {
                    s(2);
                }
            } else {
                fb();
            }
        } else if (zn2) {
            if (this.y.n3() < this.f7045zn) {
                return false;
            }
            this.f7041a = this.y.y();
            s(1);
        } else if (j2 - this.f7045zn > 500000) {
            s(3);
        }
        return zn2;
    }

    public void y() {
        if (this.f7043n3 == 4) {
            fb();
        }
    }

    @TargetApi(19)
    public long zn() {
        y yVar = this.y;
        if (yVar != null) {
            return yVar.n3();
        }
        return -9223372036854775807L;
    }
}
