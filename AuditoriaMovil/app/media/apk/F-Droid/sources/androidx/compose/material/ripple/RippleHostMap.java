package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RippleContainer.android.kt */
/* loaded from: classes.dex */
public final class RippleHostMap {
    private final Map indicationToHostMap = new LinkedHashMap();
    private final Map hostToIndicationMap = new LinkedHashMap();

    public final void set(AndroidRippleIndicationInstance indicationInstance, RippleHostView rippleHostView) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        Intrinsics.checkNotNullParameter(rippleHostView, "rippleHostView");
        this.indicationToHostMap.put(indicationInstance, rippleHostView);
        this.hostToIndicationMap.put(rippleHostView, indicationInstance);
    }

    public final RippleHostView get(AndroidRippleIndicationInstance indicationInstance) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        return (RippleHostView) this.indicationToHostMap.get(indicationInstance);
    }

    public final AndroidRippleIndicationInstance get(RippleHostView rippleHostView) {
        Intrinsics.checkNotNullParameter(rippleHostView, "rippleHostView");
        return (AndroidRippleIndicationInstance) this.hostToIndicationMap.get(rippleHostView);
    }

    public final void remove(AndroidRippleIndicationInstance indicationInstance) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        RippleHostView rippleHostView = (RippleHostView) this.indicationToHostMap.get(indicationInstance);
        if (rippleHostView != null) {
            AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) this.hostToIndicationMap.remove(rippleHostView);
        }
        this.indicationToHostMap.remove(indicationInstance);
    }
}
