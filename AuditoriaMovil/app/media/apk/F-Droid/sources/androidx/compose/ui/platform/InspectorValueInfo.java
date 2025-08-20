package androidx.compose.ui.platform;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InspectableValue.kt */
/* loaded from: classes.dex */
public abstract class InspectorValueInfo {

    /* renamed from: info  reason: collision with root package name */
    private final Function1 f35info;

    public InspectorValueInfo(Function1 info2) {
        Intrinsics.checkNotNullParameter(info2, "info");
        this.f35info = info2;
    }
}
