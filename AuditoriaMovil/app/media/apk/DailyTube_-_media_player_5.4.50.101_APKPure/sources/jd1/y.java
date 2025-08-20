package jd1;

import android.content.ComponentCallbacks;
import kotlin.jvm.internal.Intrinsics;
import rd1.n3;
/* loaded from: classes.dex */
public final class y {
    public static final be1.y y(ComponentCallbacks componentCallbacks) {
        Intrinsics.checkNotNullParameter(componentCallbacks, "<this>");
        if (componentCallbacks instanceof md1.y) {
            return ((md1.y) componentCallbacks).y();
        }
        if (componentCallbacks instanceof n3) {
            return ((n3) componentCallbacks).y();
        }
        if (componentCallbacks instanceof rd1.y) {
            return ((rd1.y) componentCallbacks).n3().v().n3();
        }
        return sd1.n3.y.zn().v().n3();
    }
}
