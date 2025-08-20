package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public abstract class BringIntoViewRequesterKt {
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return new BringIntoViewRequesterImpl();
    }

    public static final Modifier bringIntoViewRequester(Modifier modifier, BringIntoViewRequester bringIntoViewRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(bringIntoViewRequester, "bringIntoViewRequester");
        return modifier.then(new BringIntoViewRequesterElement(bringIntoViewRequester));
    }
}
