package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidAutofill.android.kt */
/* loaded from: classes.dex */
public final class AutofillApi23Helper {
    public static final AutofillApi23Helper INSTANCE = new AutofillApi23Helper();

    private AutofillApi23Helper() {
    }

    public final ViewStructure newChild(ViewStructure structure, int i) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        return structure.newChild(i);
    }

    public final int addChildCount(ViewStructure structure, int i) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        return structure.addChildCount(i);
    }

    public final void setId(ViewStructure structure, int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.setId(i, str, str2, str3);
    }

    public final void setDimens(ViewStructure structure, int i, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.setDimens(i, i2, i3, i4, i5, i6);
    }
}
