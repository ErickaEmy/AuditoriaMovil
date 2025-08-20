package di;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public interface y {

    /* loaded from: classes.dex */
    public interface n3 {
        void a(y yVar, c5 c5Var, c5 c5Var2);

        void n3(y yVar, c5 c5Var);

        void y(y yVar, c5 c5Var);
    }

    /* renamed from: di.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0084y extends IOException {
        public C0084y(String str) {
            super(str);
        }

        public C0084y(Throwable th) {
            super(th);
        }

        public C0084y(String str, Throwable th) {
            super(str, th);
        }
    }

    long a(String str, long j2, long j4);

    c5 c5(String str, long j2, long j4) throws InterruptedException, C0084y;

    void fb(c5 c5Var);

    long gv(String str, long j2, long j4);

    void i9(File file, long j2) throws C0084y;

    void n3(c5 c5Var);

    void s(String str, xc xcVar) throws C0084y;

    @Nullable
    c5 v(String str, long j2, long j4) throws C0084y;

    File y(String str, long j2, long j4) throws C0084y;

    wz zn(String str);
}
