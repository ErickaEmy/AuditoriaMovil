package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.compose.ui.unit.Density;
/* compiled from: PlatformMagnifier.kt */
/* loaded from: classes.dex */
public interface PlatformMagnifierFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    PlatformMagnifier create(MagnifierStyle magnifierStyle, View view, Density density, float f);

    boolean getCanUpdateZoom();

    /* compiled from: PlatformMagnifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final PlatformMagnifierFactory getForCurrentPlatform() {
            if (MagnifierKt.isPlatformMagnifierSupported$default(0, 1, null)) {
                if (Build.VERSION.SDK_INT == 28) {
                    return PlatformMagnifierFactoryApi28Impl.INSTANCE;
                }
                return PlatformMagnifierFactoryApi29Impl.INSTANCE;
            }
            throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
    }
}
