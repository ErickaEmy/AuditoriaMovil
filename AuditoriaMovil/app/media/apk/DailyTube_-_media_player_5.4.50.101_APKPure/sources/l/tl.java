package l;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.OverwritingInputMerger;
import l.x4;
/* loaded from: classes.dex */
public final class tl extends x4 {
    public tl(y yVar) {
        super(yVar.f10233n3, yVar.f10235zn, yVar.f10232gv);
    }

    @NonNull
    public static tl gv(@NonNull Class<? extends ListenableWorker> cls) {
        return new y(cls).n3();
    }

    /* loaded from: classes.dex */
    public static final class y extends x4.y<y, tl> {
        public y(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f10235zn.f10335gv = OverwritingInputMerger.class.getName();
        }

        @Override // l.x4.y
        @NonNull
        /* renamed from: fb */
        public tl zn() {
            if (this.y && Build.VERSION.SDK_INT >= 23 && this.f10235zn.f10336i9.s()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new tl(this);
        }

        @Override // l.x4.y
        @NonNull
        /* renamed from: s */
        public y gv() {
            return this;
        }
    }
}
