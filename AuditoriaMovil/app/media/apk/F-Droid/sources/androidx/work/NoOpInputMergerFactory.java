package androidx.work;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputMergerFactory.kt */
/* loaded from: classes.dex */
public final class NoOpInputMergerFactory extends InputMergerFactory {
    public static final NoOpInputMergerFactory INSTANCE = new NoOpInputMergerFactory();

    /* renamed from: createInputMerger  reason: collision with other method in class */
    public Void m2016createInputMerger(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return null;
    }

    private NoOpInputMergerFactory() {
    }

    @Override // androidx.work.InputMergerFactory
    public /* bridge */ /* synthetic */ InputMerger createInputMerger(String str) {
        return (InputMerger) m2016createInputMerger(str);
    }
}
