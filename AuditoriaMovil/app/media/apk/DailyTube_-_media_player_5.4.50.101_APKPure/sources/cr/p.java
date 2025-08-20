package cr;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {

    /* renamed from: n3  reason: collision with root package name */
    public View f6778n3;
    public final Map<String, Object> y = new HashMap();

    /* renamed from: zn  reason: collision with root package name */
    public final ArrayList<f> f6779zn = new ArrayList<>();

    @Deprecated
    public p() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f6778n3 == pVar.f6778n3 && this.y.equals(pVar.y)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f6778n3.hashCode() * 31) + this.y.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f6778n3 + "\n") + "    values:";
        for (String str2 : this.y.keySet()) {
            str = str + "    " + str2 + ": " + this.y.get(str2) + "\n";
        }
        return str;
    }

    public p(@NonNull View view) {
        this.f6778n3 = view;
    }
}
