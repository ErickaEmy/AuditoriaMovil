package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
/* compiled from: TextFieldImpl.kt */
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    private static final float Transition_DTcfvLk$lambda$1(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State state) {
        return ((Color) state.getValue()).m859unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State state) {
        return ((Color) state.getValue()).m859unboximpl();
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0200, code lost:
        if (r33 != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c1, code lost:
        if (r33 != false) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b1  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m580TransitionDTcfvLk(final androidx.compose.material.InputPhase r27, final long r28, final long r30, final kotlin.jvm.functions.Function3 r32, final boolean r33, final kotlin.jvm.functions.Function6 r34, androidx.compose.runtime.Composer r35, final int r36) {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m580TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }
}
