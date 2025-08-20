package xg;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.wz;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import y5.b;
import y5.co;
import y5.d0;
import y5.fh;
import y5.ud;
import z.c5;
/* loaded from: classes.dex */
public class n3 extends xg.y {

    /* renamed from: zn  reason: collision with root package name */
    public static final /* synthetic */ int f14947zn = 0;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final C0250n3 f14948n3;
    @NonNull
    public final co y;

    /* renamed from: xg.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0250n3 extends ud {

        /* renamed from: fb  reason: collision with root package name */
        public static final wz.n3 f14949fb = new y();
        public c5<y> y = new c5<>();

        /* renamed from: v  reason: collision with root package name */
        public boolean f14950v = false;

        /* renamed from: xg.n3$n3$y */
        /* loaded from: classes.dex */
        public static class y implements wz.n3 {
            @Override // androidx.lifecycle.wz.n3
            @NonNull
            public <T extends ud> T create(@NonNull Class<T> cls) {
                return new C0250n3();
            }
        }

        @NonNull
        public static C0250n3 el(b bVar) {
            return (C0250n3) new wz(bVar, f14949fb).y(C0250n3.class);
        }

        public void g6() {
            int tl2 = this.y.tl();
            for (int i = 0; i < tl2; i++) {
                this.y.wz(i).mt();
            }
        }

        @Override // y5.ud
        public void onCleared() {
            super.onCleared();
            int tl2 = this.y.tl();
            for (int i = 0; i < tl2; i++) {
                this.y.wz(i).w(true);
            }
            this.y.zn();
        }

        public void st(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.y.tl() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.y.tl(); i++) {
                    y wz2 = this.y.wz(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.y.i9(i));
                    printWriter.print(": ");
                    printWriter.println(wz2.toString());
                    wz2.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public n3(@NonNull co coVar, @NonNull b bVar) {
        this.y = coVar;
        this.f14948n3 = C0250n3.el(bVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        vl.n3.y(this.y, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // xg.y
    @Deprecated
    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f14948n3.st(str, fileDescriptor, printWriter, strArr);
    }

    @Override // xg.y
    public void zn() {
        this.f14948n3.g6();
    }

    /* loaded from: classes.dex */
    public static class y<D> extends d0<D> {

        /* renamed from: t  reason: collision with root package name */
        public final int f14951t;
        @Nullable

        /* renamed from: tl  reason: collision with root package name */
        public final Bundle f14952tl;

        /* renamed from: wz  reason: collision with root package name */
        public co f14953wz;

        @Override // androidx.lifecycle.LiveData
        public void f() {
            int i = n3.f14947zn;
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void i9() {
            int i = n3.f14947zn;
            throw null;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f14951t);
            printWriter.print(" mArgs=");
            printWriter.println(this.f14952tl);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void tl(@NonNull fh<? super D> fhVar) {
            super.tl(fhVar);
            this.f14953wz = null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f14951t);
            sb.append(" : ");
            vl.n3.y(null, sb);
            sb.append("}}");
            return sb.toString();
        }

        public dm.y<D> w(boolean z2) {
            int i = n3.f14947zn;
            throw null;
        }

        @Override // y5.d0, androidx.lifecycle.LiveData
        public void xc(D d2) {
            super.xc(d2);
        }

        public void mt() {
        }
    }
}
