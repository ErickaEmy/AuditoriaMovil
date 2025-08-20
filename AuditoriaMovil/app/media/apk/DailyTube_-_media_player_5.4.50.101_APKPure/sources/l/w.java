package l;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import java.util.concurrent.TimeUnit;
import l.x4;
/* loaded from: classes.dex */
public final class w extends x4 {
    public w(y yVar) {
        super(yVar.f10233n3, yVar.f10235zn, yVar.f10232gv);
    }

    /* loaded from: classes.dex */
    public static final class y extends x4.y<y, w> {
        public y(@NonNull Class<? extends ListenableWorker> cls, long j2, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.f10235zn.v(timeUnit.toMillis(j2));
        }

        @Override // l.x4.y
        @NonNull
        /* renamed from: fb */
        public w zn() {
            if (this.y && Build.VERSION.SDK_INT >= 23 && this.f10235zn.f10336i9.s()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (!this.f10235zn.f10339p) {
                return new w(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
        }

        @Override // l.x4.y
        @NonNull
        /* renamed from: s */
        public y gv() {
            return this;
        }
    }
}
