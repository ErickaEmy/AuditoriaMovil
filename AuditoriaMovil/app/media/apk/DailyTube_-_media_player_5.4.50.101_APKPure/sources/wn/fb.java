package wn;

import android.view.Surface;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class fb extends h3.tl {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public fb(Throwable th, @Nullable h3.wz wzVar, @Nullable Surface surface) {
        super(th, wzVar);
        boolean z2;
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        if (surface != null && !surface.isValid()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.isSurfaceValid = z2;
    }
}
