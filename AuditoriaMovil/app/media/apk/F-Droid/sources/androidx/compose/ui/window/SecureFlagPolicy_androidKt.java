package androidx.compose.ui.window;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SecureFlagPolicy.android.kt */
/* loaded from: classes.dex */
public abstract class SecureFlagPolicy_androidKt {

    /* compiled from: SecureFlagPolicy.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return z;
                }
                throw new NoWhenBranchMatchedException();
            }
            return true;
        }
        return false;
    }
}
