package b;

import android.os.LocaleList;
import java.util.Locale;
/* loaded from: classes.dex */
public final class tl implements t {
    public final LocaleList y;

    public tl(Object obj) {
        this.y = (LocaleList) obj;
    }

    public boolean equals(Object obj) {
        return this.y.equals(((t) obj).y());
    }

    @Override // b.t
    public Locale get(int i) {
        return this.y.get(i);
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public String toString() {
        return this.y.toString();
    }

    @Override // b.t
    public Object y() {
        return this.y;
    }
}
