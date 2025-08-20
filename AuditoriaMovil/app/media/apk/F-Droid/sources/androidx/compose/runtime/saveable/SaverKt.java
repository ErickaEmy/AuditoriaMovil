package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Saver.kt */
/* loaded from: classes.dex */
public abstract class SaverKt {
    private static final Saver AutoSaver = Saver(new Function2() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, Object obj) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return obj;
        }
    }, new Function1() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it;
        }
    });

    public static final Saver Saver(final Function2 save, final Function1 restore) {
        Intrinsics.checkNotNullParameter(save, "save");
        Intrinsics.checkNotNullParameter(restore, "restore");
        return new Saver() { // from class: androidx.compose.runtime.saveable.SaverKt$Saver$1
            @Override // androidx.compose.runtime.saveable.Saver
            public Object save(SaverScope saverScope, Object obj) {
                Intrinsics.checkNotNullParameter(saverScope, "<this>");
                return Function2.this.invoke(saverScope, obj);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Object restore(Object value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return restore.invoke(value);
            }
        };
    }

    public static final Saver autoSaver() {
        Saver saver = AutoSaver;
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return saver;
    }
}
