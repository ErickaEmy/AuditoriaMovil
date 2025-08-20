package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public abstract class Updater {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Composer m624constructorimpl(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m625setimpl(Composer composer, Object obj, Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), obj)) {
            composer.updateRememberedValue(obj);
            composer.apply(obj, block);
        }
    }
}
