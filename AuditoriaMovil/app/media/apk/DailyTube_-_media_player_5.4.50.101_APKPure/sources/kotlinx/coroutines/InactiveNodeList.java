package kotlinx.coroutines;
/* loaded from: classes.dex */
public final class InactiveNodeList implements Incomplete {
    private final NodeList list;

    public InactiveNodeList(NodeList nodeList) {
        this.list = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this.list;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return false;
    }

    public String toString() {
        if (DebugKt.getDEBUG()) {
            return getList().getString("New");
        }
        return super.toString();
    }
}
