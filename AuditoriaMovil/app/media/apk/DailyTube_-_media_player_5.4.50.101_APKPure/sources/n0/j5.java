package n0;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public enum j5 implements ud {
    INSTANCE;
    

    /* renamed from: v  reason: collision with root package name */
    public static final AtomicReference f11800v = new AtomicReference(null);

    public final void y(a8 a8Var) {
        f11800v.set(a8Var);
    }

    @Override // n0.ud
    @Nullable
    public final a8 zza() {
        return (a8) f11800v.get();
    }
}
