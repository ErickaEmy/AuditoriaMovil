package ae1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, Object> f101n3;
    public final qd1.y y;

    public n3(qd1.y _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.y = _koin;
        this.f101n3 = fe1.y.y.gv();
    }

    public final <T> void n3(String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f101n3.put(key, value);
    }

    public final <T> T y(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.f101n3.get(key);
    }
}
