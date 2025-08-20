package qj;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: zn  reason: collision with root package name */
    public static final Set<f> f12929zn = new HashSet();

    /* renamed from: n3  reason: collision with root package name */
    public final String f12930n3;
    public final String y;

    /* loaded from: classes.dex */
    public static class n3 extends f {
        public n3(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }
    }

    /* loaded from: classes.dex */
    public static class y extends f {
        public y(@NonNull String str, @NonNull String str2) {
            super(str, str2);
        }
    }

    public f(@NonNull String str, @NonNull String str2) {
        this.y = str;
        this.f12930n3 = str2;
        f12929zn.add(this);
    }
}
