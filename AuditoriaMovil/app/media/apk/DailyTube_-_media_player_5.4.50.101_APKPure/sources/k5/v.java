package k5;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final String f9591a;

    /* renamed from: gv  reason: collision with root package name */
    public final List<List<byte[]>> f9592gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f9593n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f9594v = 0;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f9595zn;

    public v(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.y = (String) vl.s.fb(str);
        this.f9593n3 = (String) vl.s.fb(str2);
        this.f9595zn = (String) vl.s.fb(str3);
        this.f9592gv = (List) vl.s.fb(list);
        this.f9591a = y(str, str2, str3);
    }

    @NonNull
    public String a() {
        return this.f9593n3;
    }

    @NonNull
    public String fb() {
        return this.f9595zn;
    }

    @NonNull
    public String gv() {
        return this.f9591a;
    }

    @Nullable
    public List<List<byte[]>> n3() {
        return this.f9592gv;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.y + ", mProviderPackage: " + this.f9593n3 + ", mQuery: " + this.f9595zn + ", mCertificates:");
        for (int i = 0; i < this.f9592gv.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f9592gv.get(i);
            for (int i5 = 0; i5 < list.size(); i5++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i5), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f9594v);
        return sb.toString();
    }

    @NonNull
    public String v() {
        return this.y;
    }

    public final String y(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public int zn() {
        return this.f9594v;
    }
}
