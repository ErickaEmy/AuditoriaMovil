package w0;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class s {
    public final String y;

    public static s a(char c2) {
        return new s(String.valueOf(c2));
    }

    public static s fb(String str) {
        return new s(str);
    }

    public s c5(String str) {
        xc.wz(str);
        return new y(this, this, str);
    }

    public final String gv(Iterable<? extends Object> iterable) {
        return v(iterable.iterator());
    }

    public final StringBuilder n3(StringBuilder sb, Iterable<? extends Object> iterable) {
        return zn(sb, iterable.iterator());
    }

    public CharSequence s(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final String v(Iterator<? extends Object> it) {
        return zn(new StringBuilder(), it).toString();
    }

    public <A extends Appendable> A y(A a2, Iterator<? extends Object> it) throws IOException {
        xc.wz(a2);
        if (it.hasNext()) {
            a2.append(s(it.next()));
            while (it.hasNext()) {
                a2.append(this.y);
                a2.append(s(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder zn(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            y(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public s(String str) {
        this.y = (String) xc.wz(str);
    }

    public s(s sVar) {
        this.y = sVar.y;
    }
}
