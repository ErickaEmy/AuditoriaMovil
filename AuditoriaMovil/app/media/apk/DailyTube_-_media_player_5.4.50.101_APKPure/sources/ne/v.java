package ne;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class v {

    /* renamed from: zn  reason: collision with root package name */
    public static final v f12023zn = new v("COMPOSITION");
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public a f12024n3;
    public final List<String> y;

    public v(String... strArr) {
        this.y = Arrays.asList(strArr);
    }

    public final boolean a(String str) {
        return "__container".equals(str);
    }

    public v c5(a aVar) {
        v vVar = new v(this);
        vVar.f12024n3 = aVar;
        return vVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (!this.y.equals(vVar.y)) {
            return false;
        }
        a aVar = this.f12024n3;
        a aVar2 = vVar.f12024n3;
        if (aVar != null) {
            return aVar.equals(aVar2);
        }
        if (aVar2 == null) {
            return true;
        }
        return false;
    }

    public boolean fb(String str, int i) {
        if (a(str)) {
            return true;
        }
        if (i >= this.y.size()) {
            return false;
        }
        if (this.y.get(i).equals(str) || this.y.get(i).equals("**") || this.y.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    @Nullable
    public a gv() {
        return this.f12024n3;
    }

    public int hashCode() {
        int i;
        int hashCode = this.y.hashCode() * 31;
        a aVar = this.f12024n3;
        if (aVar != null) {
            i = aVar.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final boolean n3() {
        List<String> list = this.y;
        return list.get(list.size() - 1).equals("**");
    }

    public boolean s(String str, int i) {
        if ("__container".equals(str) || i < this.y.size() - 1 || this.y.get(i).equals("**")) {
            return true;
        }
        return false;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.y);
        sb.append(",resolved=");
        if (this.f12024n3 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        sb.append('}');
        return sb.toString();
    }

    public int v(String str, int i) {
        if (a(str)) {
            return 0;
        }
        if (!this.y.get(i).equals("**")) {
            return 1;
        }
        if (i == this.y.size() - 1 || !this.y.get(i + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    @CheckResult
    public v y(String str) {
        v vVar = new v(this);
        vVar.y.add(str);
        return vVar;
    }

    public boolean zn(String str, int i) {
        boolean z2;
        boolean z3;
        if (i >= this.y.size()) {
            return false;
        }
        if (i == this.y.size() - 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String str2 = this.y.get(i);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if ((!z2 && (i != this.y.size() - 2 || !n3())) || !z3) {
                return false;
            }
            return true;
        } else if (!z2 && this.y.get(i + 1).equals(str)) {
            if (i != this.y.size() - 2 && (i != this.y.size() - 3 || !n3())) {
                return false;
            }
            return true;
        } else if (z2) {
            return true;
        } else {
            int i5 = i + 1;
            if (i5 < this.y.size() - 1) {
                return false;
            }
            return this.y.get(i5).equals(str);
        }
    }

    public v(v vVar) {
        this.y = new ArrayList(vVar.y);
        this.f12024n3 = vVar.f12024n3;
    }
}
