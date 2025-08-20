package hw;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class r {
    public final zn y;

    /* loaded from: classes.dex */
    public static class n3 extends y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public View f8986n3;

        public n3(@NonNull View view) {
            super(view);
            this.f8986n3 = view;
        }
    }

    /* loaded from: classes.dex */
    public static class y extends zn {
        @Nullable
        public final View y;

        public y(@Nullable View view) {
            this.y = view;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
    }

    public r(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.y = new n3(view);
        } else {
            this.y = new y(view);
        }
    }
}
