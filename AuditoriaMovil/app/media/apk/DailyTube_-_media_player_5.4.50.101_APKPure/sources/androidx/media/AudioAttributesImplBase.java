package androidx.media;

import androidx.annotation.NonNull;
import java.util.Arrays;
/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: gv  reason: collision with root package name */
    public int f2672gv = -1;

    /* renamed from: n3  reason: collision with root package name */
    public int f2673n3;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f2674zn;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f2673n3 != audioAttributesImplBase.y() || this.f2674zn != audioAttributesImplBase.n3() || this.y != audioAttributesImplBase.gv() || this.f2672gv != audioAttributesImplBase.f2672gv) {
            return false;
        }
        return true;
    }

    public int gv() {
        return this.y;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2673n3), Integer.valueOf(this.f2674zn), Integer.valueOf(this.y), Integer.valueOf(this.f2672gv)});
    }

    public int n3() {
        int i = this.f2674zn;
        int zn2 = zn();
        if (zn2 == 6) {
            i |= 4;
        } else if (zn2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2672gv != -1) {
            sb.append(" stream=");
            sb.append(this.f2672gv);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.n3(this.y));
        sb.append(" content=");
        sb.append(this.f2673n3);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2674zn).toUpperCase());
        return sb.toString();
    }

    public int y() {
        return this.f2673n3;
    }

    public int zn() {
        int i = this.f2672gv;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.y(false, this.f2674zn, this.y);
    }
}
