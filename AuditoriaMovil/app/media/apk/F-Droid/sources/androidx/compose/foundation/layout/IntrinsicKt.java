package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public abstract class IntrinsicKt {

    /* compiled from: Intrinsic.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntrinsicSize.values().length];
            try {
                iArr[IntrinsicSize.Min.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntrinsicSize.Max.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier width(Modifier modifier, IntrinsicSize intrinsicSize) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return modifier.then(MaxIntrinsicWidthModifier.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }
        return modifier.then(MinIntrinsicWidthModifier.INSTANCE);
    }
}
