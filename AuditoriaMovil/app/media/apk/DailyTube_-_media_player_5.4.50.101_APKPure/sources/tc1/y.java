package tc1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc1.p;
import zc1.rz;
import zc1.ta;
/* loaded from: classes.dex */
public interface y {

    /* renamed from: n3  reason: collision with root package name */
    public static final C0218y f13957n3 = new C0218y(null);
    public static final y y = new C0218y.C0219y();

    /* renamed from: tc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0218y {

        /* renamed from: tc1.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0219y implements y {
            @Override // tc1.y
            public void a(File from, File to) throws IOException {
                Intrinsics.checkNotNullParameter(from, "from");
                Intrinsics.checkNotNullParameter(to, "to");
                fb(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @Override // tc1.y
            public void deleteContents(File directory) throws IOException {
                Intrinsics.checkNotNullParameter(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        if (file.isDirectory()) {
                            deleteContents(file);
                        }
                        if (!file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + directory);
            }

            @Override // tc1.y
            public void fb(File file) throws IOException {
                Intrinsics.checkNotNullParameter(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            @Override // tc1.y
            public ta gv(File file) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(file, "file");
                return p.f(file);
            }

            @Override // tc1.y
            public rz n3(File file) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return p.y(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return p.y(file);
                }
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }

            @Override // tc1.y
            public rz v(File file) throws FileNotFoundException {
                Intrinsics.checkNotNullParameter(file, "file");
                try {
                    return p.i9(file, false, 1, (Object) null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return p.i9(file, false, 1, (Object) null);
                }
            }

            @Override // tc1.y
            public boolean y(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.exists();
            }

            @Override // tc1.y
            public long zn(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return file.length();
            }
        }

        public C0218y() {
        }

        public /* synthetic */ C0218y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void a(File file, File file2) throws IOException;

    void deleteContents(File file) throws IOException;

    void fb(File file) throws IOException;

    ta gv(File file) throws FileNotFoundException;

    rz n3(File file) throws FileNotFoundException;

    rz v(File file) throws FileNotFoundException;

    boolean y(File file);

    long zn(File file);
}
