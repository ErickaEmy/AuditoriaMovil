package kotlinx.coroutines;

import java.lang.Throwable;
import kotlinx.coroutines.CopyableThrowable;
/* loaded from: classes.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    T createCopy();
}
