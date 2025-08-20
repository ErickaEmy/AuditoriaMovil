package k5;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class fb {

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f9581gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9582n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f9583v;
        public final Uri y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f9584zn;

        @Deprecated
        public n3(@NonNull Uri uri, int i, int i5, boolean z2, int i6) {
            this.y = (Uri) vl.s.fb(uri);
            this.f9582n3 = i;
            this.f9584zn = i5;
            this.f9581gv = z2;
            this.f9583v = i6;
        }

        public static n3 y(@NonNull Uri uri, int i, int i5, boolean z2, int i6) {
            return new n3(uri, i, i5, z2, i6);
        }

        public boolean a() {
            return this.f9581gv;
        }

        @NonNull
        public Uri gv() {
            return this.y;
        }

        public int n3() {
            return this.f9583v;
        }

        public int v() {
            return this.f9584zn;
        }

        public int zn() {
            return this.f9582n3;
        }
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public final n3[] f9585n3;
        public final int y;

        @Deprecated
        public y(int i, @Nullable n3[] n3VarArr) {
            this.y = i;
            this.f9585n3 = n3VarArr;
        }

        public static y y(int i, @Nullable n3[] n3VarArr) {
            return new y(i, n3VarArr);
        }

        public n3[] n3() {
            return this.f9585n3;
        }

        public int zn() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public void n3(Typeface typeface) {
            throw null;
        }

        public void y(int i) {
            throw null;
        }
    }

    @Nullable
    public static Typeface y(@NonNull Context context, @NonNull v vVar, int i, boolean z2, int i5, @NonNull Handler handler, @NonNull zn znVar) {
        k5.y yVar = new k5.y(znVar, handler);
        if (z2) {
            return a.v(context, vVar, yVar, i, i5);
        }
        return a.gv(context, vVar, i, null, yVar);
    }
}
