package androidx.compose.runtime;

import androidx.compose.runtime.Applier;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Applier.kt */
/* loaded from: classes.dex */
public abstract class AbstractApplier implements Applier {
    private Object current;
    private final Object root;
    private final List stack = new ArrayList();

    @Override // androidx.compose.runtime.Applier
    public Object getCurrent() {
        return this.current;
    }

    public final Object getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onBeginChanges() {
        Applier.CC.$default$onBeginChanges(this);
    }

    protected abstract void onClear();

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        Applier.CC.$default$onEndChanges(this);
    }

    protected void setCurrent(Object obj) {
        this.current = obj;
    }

    public AbstractApplier(Object obj) {
        this.root = obj;
        this.current = obj;
    }

    @Override // androidx.compose.runtime.Applier
    public void down(Object obj) {
        this.stack.add(getCurrent());
        setCurrent(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        if (!(!this.stack.isEmpty())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        List list = this.stack;
        setCurrent(list.remove(list.size() - 1));
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }
}
