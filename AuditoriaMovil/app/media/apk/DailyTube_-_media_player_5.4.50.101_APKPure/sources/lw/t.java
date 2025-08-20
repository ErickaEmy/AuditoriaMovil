package lw;

import af.b;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import kx.mg;
/* loaded from: classes.dex */
public interface t {

    /* loaded from: classes.dex */
    public static final class gv extends IOException {
        public final Uri url;

        public gv(Uri uri) {
            this.url = uri;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void a();

        boolean n3(Uri uri, mg.zn znVar, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface v {
        void w(fb fbVar);
    }

    /* loaded from: classes.dex */
    public interface y {
        t y(h4.fb fbVar, mg mgVar, f fVar);
    }

    /* loaded from: classes.dex */
    public static final class zn extends IOException {
        public final Uri url;

        public zn(Uri uri) {
            this.url = uri;
        }
    }

    void a(Uri uri);

    void c5() throws IOException;

    @Nullable
    fb f(Uri uri, boolean z2);

    boolean fb(Uri uri);

    long gv();

    void i9(n3 n3Var);

    boolean isLive();

    void n3(Uri uri) throws IOException;

    boolean s(Uri uri, long j2);

    void stop();

    @Nullable
    s v();

    void y(n3 n3Var);

    void zn(Uri uri, b.y yVar, v vVar);
}
