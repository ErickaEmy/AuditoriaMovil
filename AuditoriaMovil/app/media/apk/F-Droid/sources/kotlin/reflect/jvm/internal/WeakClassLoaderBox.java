package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: moduleByClassLoader.kt */
/* loaded from: classes2.dex */
final class WeakClassLoaderBox {
    private final int identityHashCode;
    private final WeakReference ref;
    private ClassLoader temporaryStrongRef;

    public int hashCode() {
        return this.identityHashCode;
    }

    public final void setTemporaryStrongRef(ClassLoader classLoader) {
        this.temporaryStrongRef = classLoader;
    }

    public WeakClassLoaderBox(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.ref = new WeakReference(classLoader);
        this.identityHashCode = System.identityHashCode(classLoader);
        this.temporaryStrongRef = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WeakClassLoaderBox) && this.ref.get() == ((WeakClassLoaderBox) obj).ref.get();
    }

    public String toString() {
        String obj;
        ClassLoader classLoader = (ClassLoader) this.ref.get();
        return (classLoader == null || (obj = classLoader.toString()) == null) ? "<null>" : obj;
    }
}
