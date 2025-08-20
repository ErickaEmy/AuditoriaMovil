package androidx.compose.ui.autofill;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AutofillTree.kt */
/* loaded from: classes.dex */
public final class AutofillTree {
    private final Map children = new LinkedHashMap();

    public final Map getChildren() {
        return this.children;
    }

    public final Unit performAutofill(int i, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(this.children.get(Integer.valueOf(i)));
        return null;
    }
}
