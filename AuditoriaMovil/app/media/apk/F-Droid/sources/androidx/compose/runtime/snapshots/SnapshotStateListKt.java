package androidx.compose.runtime.snapshots;

import ch.qos.logback.core.CoreConstants;
/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public abstract class SnapshotStateListKt {
    private static final Object sync = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateRange(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i2 + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
    }
}
