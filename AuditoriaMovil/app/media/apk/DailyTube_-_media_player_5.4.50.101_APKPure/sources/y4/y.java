package y4;

import android.annotation.SuppressLint;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public FileChannel f15281gv;

    /* renamed from: n3  reason: collision with root package name */
    public final File f15282n3;
    public final boolean y;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: zn  reason: collision with root package name */
    public final Lock f15283zn;

    /* renamed from: v  reason: collision with root package name */
    public static final C0251y f15280v = new C0251y(null);

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f15279a = new HashMap();

    /* renamed from: y4.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0251y {
        public /* synthetic */ C0251y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lock n3(String str) {
            Lock lock;
            synchronized (y.f15279a) {
                try {
                    Map map = y.f15279a;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        public C0251y() {
        }
    }

    public y(String name, File lockDir, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lockDir, "lockDir");
        this.y = z2;
        File file = new File(lockDir, name + ".lck");
        this.f15282n3 = file;
        C0251y c0251y = f15280v;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "lockFile.absolutePath");
        this.f15283zn = c0251y.n3(absolutePath);
    }

    public static /* synthetic */ void zn(y yVar, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = yVar.y;
        }
        yVar.n3(z2);
    }

    public final void gv() {
        try {
            FileChannel fileChannel = this.f15281gv;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f15283zn.unlock();
    }

    public final void n3(boolean z2) {
        this.f15283zn.lock();
        if (z2) {
            try {
                File parentFile = this.f15282n3.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f15282n3).getChannel();
                channel.lock();
                this.f15281gv = channel;
            } catch (IOException e2) {
                this.f15281gv = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e2);
            }
        }
    }
}
