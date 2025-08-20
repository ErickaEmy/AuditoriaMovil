package p0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final List<y> f12370n3;
    public final long y;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final long f12371gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f12372n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f12373zn;

        public y(String str, String str2, long j2, long j4) {
            this.y = str;
            this.f12372n3 = str2;
            this.f12373zn = j2;
            this.f12371gv = j4;
        }
    }

    public n3(long j2, List<y> list) {
        this.y = j2;
        this.f12370n3 = list;
    }

    @Nullable
    public MotionPhotoMetadata y(long j2) {
        long j4;
        if (this.f12370n3.size() < 2) {
            return null;
        }
        long j6 = j2;
        long j7 = -1;
        long j8 = -1;
        long j9 = -1;
        long j10 = -1;
        boolean z2 = false;
        for (int size = this.f12370n3.size() - 1; size >= 0; size--) {
            y yVar = this.f12370n3.get(size);
            boolean equals = "video/mp4".equals(yVar.y) | z2;
            if (size == 0) {
                j6 -= yVar.f12371gv;
                j4 = 0;
            } else {
                j4 = j6 - yVar.f12373zn;
            }
            long j11 = j6;
            j6 = j4;
            if (equals && j6 != j11) {
                j10 = j11 - j6;
                j9 = j6;
                z2 = false;
            } else {
                z2 = equals;
            }
            if (size == 0) {
                j7 = j6;
                j8 = j11;
            }
        }
        if (j9 == -1 || j10 == -1 || j7 == -1 || j8 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j7, j8, this.y, j9, j10);
    }
}
