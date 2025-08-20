package androidx.work;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputMergerFactory.kt */
/* loaded from: classes.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String str);

    public final InputMerger createInputMergerWithDefaultFallback(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        InputMerger createInputMerger = createInputMerger(className);
        return createInputMerger == null ? InputMergerKt.fromClassName(className) : createInputMerger;
    }
}
