package ne;
/* loaded from: classes.dex */
public class s {

    /* renamed from: n3  reason: collision with root package name */
    public final float f12021n3;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final float f12022zn;

    public s(String str, float f4, float f6) {
        this.y = str;
        this.f12022zn = f6;
        this.f12021n3 = f4;
    }

    public boolean y(String str) {
        if (this.y.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.y.endsWith("\r")) {
            String str2 = this.y;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
