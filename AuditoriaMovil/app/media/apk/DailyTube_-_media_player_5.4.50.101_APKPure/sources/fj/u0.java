package fj;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: n3  reason: collision with root package name */
    public static final u0 f8130n3;
    @Nullable
    public final y y;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public static final y f8131n3 = new y(LogSessionId.LOG_SESSION_ID_NONE);
        public final LogSessionId y;

        public y(LogSessionId logSessionId) {
            this.y = logSessionId;
        }
    }

    static {
        u0 u0Var;
        if (v5.j5.y < 31) {
            u0Var = new u0();
        } else {
            u0Var = new u0(y.f8131n3);
        }
        f8130n3 = u0Var;
    }

    public u0() {
        this((y) null);
        v5.y.fb(v5.j5.y < 31);
    }

    public LogSessionId y() {
        return ((y) v5.y.v(this.y)).y;
    }

    public u0(LogSessionId logSessionId) {
        this(new y(logSessionId));
    }

    public u0(@Nullable y yVar) {
        this.y = yVar;
    }
}
