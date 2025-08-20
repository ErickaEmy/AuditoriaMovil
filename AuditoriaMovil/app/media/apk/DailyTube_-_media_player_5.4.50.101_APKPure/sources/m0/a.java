package m0;

import android.content.Context;
import android.content.pm.PackageManager;
import j0.o4;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: n3  reason: collision with root package name */
    public final Context f10551n3;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public File f10552zn;

    public a(Context context) throws PackageManager.NameNotFoundException {
        this.f10551n3 = context;
        this.y = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static String f3(String str) {
        return String.valueOf(str).concat(".apk");
    }

    public static File p(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static File r(File file) throws IOException {
        String str;
        if (file.exists()) {
            if (file.isDirectory()) {
                return file;
            }
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
        file.mkdirs();
        if (!file.isDirectory()) {
            String valueOf = String.valueOf(file.getAbsolutePath());
            if (valueOf.length() != 0) {
                str = "Unable to create directory: ".concat(valueOf);
            } else {
                str = new String("Unable to create directory: ");
            }
            throw new IOException(str);
        }
        return file;
    }

    public static void t(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                t(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    public static void tl(File file) {
        file.setWritable(false, true);
        file.setWritable(false, false);
    }

    public static boolean w(File file) {
        if (!file.canWrite()) {
            return true;
        }
        return false;
    }

    public final File a(File file) throws IOException {
        return p(z(), file.getName());
    }

    public final Set c5(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = co(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    public final File co(String str) throws IOException {
        File p2 = p(mt(), str);
        r(p2);
        return p2;
    }

    public final void f() throws IOException {
        File x42 = x4();
        String[] list = x42.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.y))) {
                    File file = new File(x42, str);
                    new StringBuilder(file.toString().length() + 118);
                    t(file);
                }
            }
        }
    }

    public final File fb(String str) throws IOException {
        return p(z(), f3(str));
    }

    public final File gv() throws IOException {
        return new File(i4(), "lock.tmp");
    }

    public final File i4() throws IOException {
        File file = new File(x4(), Long.toString(this.y));
        r(file);
        return file;
    }

    public final Set i9() throws IOException {
        String name;
        File z2 = z();
        HashSet hashSet = new HashSet();
        File[] listFiles = z2.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk") && w(file)) {
                    hashSet.add(new zn(file, file.getName().substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    public final File mt() throws IOException {
        File file = new File(i4(), "native-libraries");
        r(file);
        return file;
    }

    public final File n3() throws IOException {
        File file = new File(i4(), "unverified-splits");
        r(file);
        return file;
    }

    public final List s() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = mt().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    public final File v(String str) throws IOException {
        return p(n3(), f3(str));
    }

    public final void wz(String str) throws IOException {
        t(co(str));
    }

    public final File x4() throws IOException {
        if (this.f10552zn == null) {
            Context context = this.f10551n3;
            if (context != null) {
                this.f10552zn = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f10552zn, "splitcompat");
        r(file);
        return file;
    }

    public final void xc(File file) throws IOException {
        o4.n3(file.getParentFile().getParentFile().equals(mt()), "File to remove is not a native library");
        t(file);
    }

    public final File y(String str) throws IOException {
        File file = new File(i4(), "dex");
        r(file);
        File p2 = p(file, str);
        r(p2);
        return p2;
    }

    public final File z() throws IOException {
        File file = new File(i4(), "verified-splits");
        r(file);
        return file;
    }

    public final File zn(String str, String str2) throws IOException {
        return p(co(str), str2);
    }
}
