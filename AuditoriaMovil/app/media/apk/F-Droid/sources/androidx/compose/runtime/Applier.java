package androidx.compose.runtime;
/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public interface Applier {

    /* compiled from: Applier.kt */
    /* renamed from: androidx.compose.runtime.Applier$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$onBeginChanges(Applier applier) {
        }

        public static void $default$onEndChanges(Applier applier) {
        }
    }

    void clear();

    void down(Object obj);

    Object getCurrent();

    void insertBottomUp(int i, Object obj);

    void insertTopDown(int i, Object obj);

    void move(int i, int i2, int i3);

    void onBeginChanges();

    void onEndChanges();

    void remove(int i, int i2);

    void up();
}
