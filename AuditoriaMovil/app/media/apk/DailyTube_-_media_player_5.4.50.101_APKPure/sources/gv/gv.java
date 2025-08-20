package gv;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class gv {
    private CopyOnWriteArrayList<y> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public gv(boolean z2) {
        this.mEnabled = z2;
    }

    public void addCancellable(@NonNull y yVar) {
        this.mCancellables.add(yVar);
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator<y> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public void removeCancellable(@NonNull y yVar) {
        this.mCancellables.remove(yVar);
    }

    public final void setEnabled(boolean z2) {
        this.mEnabled = z2;
    }
}
