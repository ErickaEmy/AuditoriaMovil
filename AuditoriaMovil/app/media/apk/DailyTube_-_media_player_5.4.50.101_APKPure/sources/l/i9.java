package l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class i9 {

    /* loaded from: classes.dex */
    public class y extends i9 {
        @Override // l.i9
        @Nullable
        public c5 y(@NonNull String str) {
            return null;
        }
    }

    @NonNull
    public static i9 zn() {
        return new y();
    }

    @Nullable
    public final c5 n3(@NonNull String str) {
        c5 y2 = y(str);
        if (y2 == null) {
            return c5.y(str);
        }
        return y2;
    }

    @Nullable
    public abstract c5 y(@NonNull String str);
}
