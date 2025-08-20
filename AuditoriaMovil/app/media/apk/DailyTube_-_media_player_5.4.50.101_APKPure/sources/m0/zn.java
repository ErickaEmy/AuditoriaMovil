package m0;

import androidx.annotation.NonNull;
import java.io.File;
/* loaded from: classes.dex */
public final class zn extends z {

    /* renamed from: n3  reason: collision with root package name */
    public final String f10567n3;
    public final File y;

    public zn(File file, String str) {
        if (file != null) {
            this.y = file;
            if (str != null) {
                this.f10567n3 = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.y.equals(zVar.y()) && this.f10567n3.equals(zVar.n3())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.y.hashCode() ^ 1000003) * 1000003) ^ this.f10567n3.hashCode();
    }

    @Override // m0.z
    @NonNull
    public final String n3() {
        return this.f10567n3;
    }

    public final String toString() {
        String obj = this.y.toString();
        String str = this.f10567n3;
        StringBuilder sb = new StringBuilder(obj.length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(obj);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // m0.z
    @NonNull
    public final File y() {
        return this.y;
    }
}
