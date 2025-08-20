package g3;

import androidx.annotation.NonNull;
import u0.fb;
/* loaded from: classes.dex */
public abstract class y {
    public final int endVersion;
    public final int startVersion;

    public y(int i, int i5) {
        this.startVersion = i;
        this.endVersion = i5;
    }

    public abstract void migrate(@NonNull fb fbVar);
}
