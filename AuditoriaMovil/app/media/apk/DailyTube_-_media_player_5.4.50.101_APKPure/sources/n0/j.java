package n0;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
import y5.w;
/* loaded from: classes.dex */
public final class j {
    public static final AtomicReference y = new AtomicReference(null);

    public static void n3(o oVar) {
        w.y(y, null, oVar);
    }

    @Nullable
    public static o y() {
        return (o) y.get();
    }
}
