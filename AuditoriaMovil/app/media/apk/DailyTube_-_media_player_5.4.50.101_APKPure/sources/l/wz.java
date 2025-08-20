package l;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface wz {
    @SuppressLint({"SyntheticAccessor"})
    public static final n3.zn y = new n3.zn();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: n3  reason: collision with root package name */
    public static final n3.C0145n3 f10229n3 = new n3.C0145n3();

    /* loaded from: classes.dex */
    public static abstract class n3 {

        /* renamed from: l.wz$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0145n3 extends n3 {
            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }

            public C0145n3() {
            }
        }

        /* loaded from: classes.dex */
        public static final class y extends n3 {
            public final Throwable y;

            public y(@NonNull Throwable th) {
                this.y = th;
            }

            @NonNull
            public String toString() {
                return String.format("FAILURE (%s)", this.y.getMessage());
            }

            @NonNull
            public Throwable y() {
                return this.y;
            }
        }

        /* loaded from: classes.dex */
        public static final class zn extends n3 {
            @NonNull
            public String toString() {
                return "SUCCESS";
            }

            public zn() {
            }
        }
    }
}
