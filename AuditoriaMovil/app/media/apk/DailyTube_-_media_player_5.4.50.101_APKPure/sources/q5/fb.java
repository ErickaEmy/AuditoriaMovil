package q5;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class fb {

    /* renamed from: v  reason: collision with root package name */
    public static fb f12756v;

    /* renamed from: gv  reason: collision with root package name */
    public a f12757gv;

    /* renamed from: n3  reason: collision with root package name */
    public n3 f12758n3;
    public y y;

    /* renamed from: zn  reason: collision with root package name */
    public v f12759zn;

    public fb(@NonNull Context context, @NonNull ix.y yVar) {
        Context applicationContext = context.getApplicationContext();
        this.y = new y(applicationContext, yVar);
        this.f12758n3 = new n3(applicationContext, yVar);
        this.f12759zn = new v(applicationContext, yVar);
        this.f12757gv = new a(applicationContext, yVar);
    }

    @NonNull
    public static synchronized fb zn(Context context, ix.y yVar) {
        fb fbVar;
        synchronized (fb.class) {
            try {
                if (f12756v == null) {
                    f12756v = new fb(context, yVar);
                }
                fbVar = f12756v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fbVar;
    }

    @NonNull
    public v gv() {
        return this.f12759zn;
    }

    @NonNull
    public n3 n3() {
        return this.f12758n3;
    }

    @NonNull
    public a v() {
        return this.f12757gv;
    }

    @NonNull
    public y y() {
        return this.y;
    }
}
