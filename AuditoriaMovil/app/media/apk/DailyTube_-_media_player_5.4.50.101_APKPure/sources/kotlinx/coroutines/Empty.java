package kotlinx.coroutines;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Empty implements Incomplete {
    private final boolean isActive;

    public Empty(boolean z2) {
        this.isActive = z2;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
