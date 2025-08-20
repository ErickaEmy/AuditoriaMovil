package ps;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final int f12604gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f12605n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f12606v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f12607zn;

    public n3(int i, int i5, int i6, int i8, int i10) {
        this.y = i;
        this.f12605n3 = i5;
        this.f12607zn = i6;
        this.f12604gv = i8;
        this.f12606v = i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static n3 y(String str) {
        char c2;
        v5.y.y(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i5 = -1;
        int i6 = -1;
        int i8 = -1;
        for (int i10 = 0; i10 < split.length; i10++) {
            String v2 = w0.zn.v(split[i10].trim());
            v2.hashCode();
            switch (v2.hashCode()) {
                case 100571:
                    if (v2.equals("end")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (v2.equals("text")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (v2.equals("start")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (v2.equals("style")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    i5 = i10;
                    break;
                case 1:
                    i8 = i10;
                    break;
                case 2:
                    i = i10;
                    break;
                case 3:
                    i6 = i10;
                    break;
            }
        }
        if (i != -1 && i5 != -1 && i8 != -1) {
            return new n3(i, i5, i6, i8, split.length);
        }
        return null;
    }
}
