package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public abstract class CreationExtras {
    private final Map map = new LinkedHashMap();

    /* compiled from: CreationExtras.kt */
    /* loaded from: classes.dex */
    public interface Key {
    }

    public abstract Object get(Key key);

    public final Map getMap$lifecycle_viewmodel_release() {
        return this.map;
    }

    /* compiled from: CreationExtras.kt */
    /* loaded from: classes.dex */
    public static final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        public Object get(Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        private Empty() {
        }
    }
}
