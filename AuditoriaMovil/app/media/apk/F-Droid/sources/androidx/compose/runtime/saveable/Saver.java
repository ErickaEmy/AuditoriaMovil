package androidx.compose.runtime.saveable;
/* compiled from: Saver.kt */
/* loaded from: classes.dex */
public interface Saver {
    Object restore(Object obj);

    Object save(SaverScope saverScope, Object obj);
}
