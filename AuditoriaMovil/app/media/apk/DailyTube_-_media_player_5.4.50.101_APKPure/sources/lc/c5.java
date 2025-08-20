package lc;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class c5 {

    /* renamed from: n3  reason: collision with root package name */
    public final String f10269n3;
    public final Uri y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f10270zn;

    public c5(@NonNull Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    @Nullable
    public String n3() {
        return this.f10270zn;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.y != null) {
            sb.append(" uri=");
            sb.append(this.y.toString());
        }
        if (this.f10269n3 != null) {
            sb.append(" action=");
            sb.append(this.f10269n3);
        }
        if (this.f10270zn != null) {
            sb.append(" mimetype=");
            sb.append(this.f10270zn);
        }
        sb.append(" }");
        return sb.toString();
    }

    @Nullable
    public String y() {
        return this.f10269n3;
    }

    @Nullable
    public Uri zn() {
        return this.y;
    }

    public c5(@Nullable Uri uri, @Nullable String str, @Nullable String str2) {
        this.y = uri;
        this.f10269n3 = str;
        this.f10270zn = str2;
    }
}
