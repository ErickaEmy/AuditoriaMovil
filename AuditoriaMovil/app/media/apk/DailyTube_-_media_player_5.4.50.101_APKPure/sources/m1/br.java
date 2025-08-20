package m1;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import m1.s;
/* loaded from: classes.dex */
public final class br implements s {

    /* renamed from: fb  reason: collision with root package name */
    public final int f10584fb;

    /* renamed from: v  reason: collision with root package name */
    public final float f10585v;
    public final float y;

    /* renamed from: s  reason: collision with root package name */
    public static final br f10581s = new br(1.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final String f10580f = v5.j5.g3(0);

    /* renamed from: t  reason: collision with root package name */
    public static final String f10582t = v5.j5.g3(1);

    /* renamed from: w  reason: collision with root package name */
    public static final s.y<br> f10583w = new s.y() { // from class: m1.fc
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            br zn2;
            zn2 = br.zn(bundle);
            return zn2;
        }
    };

    public br(float f4) {
        this(f4, 1.0f);
    }

    public static /* synthetic */ br zn(Bundle bundle) {
        return new br(bundle.getFloat(f10580f, 1.0f), bundle.getFloat(f10582t, 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || br.class != obj.getClass()) {
            return false;
        }
        br brVar = (br) obj;
        if (this.y == brVar.y && this.f10585v == brVar.f10585v) {
            return true;
        }
        return false;
    }

    @CheckResult
    public br gv(float f4) {
        return new br(f4, this.f10585v);
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.y)) * 31) + Float.floatToRawIntBits(this.f10585v);
    }

    public long n3(long j2) {
        return j2 * this.f10584fb;
    }

    @Override // m1.s
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(f10580f, this.y);
        bundle.putFloat(f10582t, this.f10585v);
        return bundle;
    }

    public String toString() {
        return v5.j5.rz("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.y), Float.valueOf(this.f10585v));
    }

    public br(float f4, float f6) {
        v5.y.y(f4 > 0.0f);
        v5.y.y(f6 > 0.0f);
        this.y = f4;
        this.f10585v = f6;
        this.f10584fb = Math.round(f4 * 1000.0f);
    }
}
