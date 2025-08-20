package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.R$id;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RippleContainer.android.kt */
/* loaded from: classes.dex */
public final class RippleContainer extends ViewGroup {
    private final int MaxRippleHosts;
    private int nextHostIndex;
    private final RippleHostMap rippleHostMap;
    private final List rippleHosts;
    private final List unusedRippleHosts;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MaxRippleHosts = 5;
        ArrayList arrayList = new ArrayList();
        this.rippleHosts = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.unusedRippleHosts = arrayList2;
        this.rippleHostMap = new RippleHostMap();
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        addView(rippleHostView);
        arrayList.add(rippleHostView);
        arrayList2.add(rippleHostView);
        this.nextHostIndex = 1;
        setTag(R$id.hide_in_inspector_tag, Boolean.TRUE);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public final RippleHostView getRippleHostView(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        Object removeFirstOrNull;
        int lastIndex;
        Intrinsics.checkNotNullParameter(androidRippleIndicationInstance, "<this>");
        RippleHostView rippleHostView = this.rippleHostMap.get(androidRippleIndicationInstance);
        if (rippleHostView != null) {
            return rippleHostView;
        }
        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(this.unusedRippleHosts);
        RippleHostView rippleHostView2 = (RippleHostView) removeFirstOrNull;
        if (rippleHostView2 == null) {
            int i = this.nextHostIndex;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.rippleHosts);
            if (i > lastIndex) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                rippleHostView2 = new RippleHostView(context);
                addView(rippleHostView2);
                this.rippleHosts.add(rippleHostView2);
            } else {
                rippleHostView2 = (RippleHostView) this.rippleHosts.get(this.nextHostIndex);
                AndroidRippleIndicationInstance androidRippleIndicationInstance2 = this.rippleHostMap.get(rippleHostView2);
                if (androidRippleIndicationInstance2 != null) {
                    androidRippleIndicationInstance2.resetHostView();
                    this.rippleHostMap.remove(androidRippleIndicationInstance2);
                    rippleHostView2.disposeRipple();
                }
            }
            int i2 = this.nextHostIndex;
            if (i2 < this.MaxRippleHosts - 1) {
                this.nextHostIndex = i2 + 1;
            } else {
                this.nextHostIndex = 0;
            }
        }
        this.rippleHostMap.set(androidRippleIndicationInstance, rippleHostView2);
        return rippleHostView2;
    }

    public final void disposeRippleIfNeeded(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        Intrinsics.checkNotNullParameter(androidRippleIndicationInstance, "<this>");
        androidRippleIndicationInstance.resetHostView();
        RippleHostView rippleHostView = this.rippleHostMap.get(androidRippleIndicationInstance);
        if (rippleHostView != null) {
            rippleHostView.disposeRipple();
            this.rippleHostMap.remove(androidRippleIndicationInstance);
            this.unusedRippleHosts.add(rippleHostView);
        }
    }
}
