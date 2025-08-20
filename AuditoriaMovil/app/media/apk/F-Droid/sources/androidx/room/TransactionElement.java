package androidx.room;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RoomDatabaseExt.kt */
/* loaded from: classes.dex */
public abstract class TransactionElement implements CoroutineContext.Element {
    public static final Key Key = new Key(null);

    /* compiled from: RoomDatabaseExt.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
