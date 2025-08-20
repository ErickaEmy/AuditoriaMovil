package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: ListSaver.kt */
/* loaded from: classes.dex */
public abstract class ListSaverKt {
    public static final Saver listSaver(final Function2 save, Function1 restore) {
        Intrinsics.checkNotNullParameter(save, "save");
        Intrinsics.checkNotNullParameter(restore, "restore");
        return SaverKt.Saver(new Function2() { // from class: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SaverScope Saver, Object obj) {
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                List list = (List) Function2.this.invoke(Saver, obj);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Object obj2 = list.get(i);
                    if (obj2 != null && !Saver.canBeSaved(obj2)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                if (!list.isEmpty()) {
                    return new ArrayList(list);
                }
                return null;
            }
        }, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(restore, 1));
    }
}
