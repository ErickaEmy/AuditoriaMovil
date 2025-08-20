package di;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v5.j5;
/* loaded from: classes.dex */
public final class r extends c5 {

    /* renamed from: w  reason: collision with root package name */
    public static final Pattern f7283w = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f7282p = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: co  reason: collision with root package name */
    public static final Pattern f7281co = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public r(String str, long j2, long j4, long j6, @Nullable File file) {
        super(str, j2, j4, j6, file);
    }

    @Nullable
    public static r a(File file, long j2, t tVar) {
        return v(file, j2, -9223372036854775807L, tVar);
    }

    public static File c5(File file, int i, long j2, long j4) {
        return new File(file, i + "." + j2 + "." + j4 + ".v3.exo");
    }

    @Nullable
    public static File f(File file, t tVar) {
        String str;
        String name = file.getName();
        Matcher matcher = f7282p.matcher(name);
        if (matcher.matches()) {
            str = j5.nd((String) v5.y.v(matcher.group(1)));
        } else {
            matcher = f7283w.matcher(name);
            if (matcher.matches()) {
                str = (String) v5.y.v(matcher.group(1));
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        File c52 = c5((File) v5.y.c5(file.getParentFile()), tVar.a(str), Long.parseLong((String) v5.y.v(matcher.group(2))), Long.parseLong((String) v5.y.v(matcher.group(3))));
        if (!file.renameTo(c52)) {
            return null;
        }
        return c52;
    }

    public static r fb(String str, long j2, long j4) {
        return new r(str, j2, j4, -9223372036854775807L, null);
    }

    public static r s(String str, long j2) {
        return new r(str, j2, -1L, -9223372036854775807L, null);
    }

    @Nullable
    public static r v(File file, long j2, long j4, t tVar) {
        File file2;
        String f4;
        long j6;
        long j7;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            File f6 = f(file, tVar);
            if (f6 == null) {
                return null;
            }
            file2 = f6;
            name = f6.getName();
        } else {
            file2 = file;
        }
        Matcher matcher = f7281co.matcher(name);
        if (!matcher.matches() || (f4 = tVar.f(Integer.parseInt((String) v5.y.v(matcher.group(1))))) == null) {
            return null;
        }
        if (j2 == -1) {
            j6 = file2.length();
        } else {
            j6 = j2;
        }
        if (j6 == 0) {
            return null;
        }
        long parseLong = Long.parseLong((String) v5.y.v(matcher.group(2)));
        if (j4 == -9223372036854775807L) {
            j7 = Long.parseLong((String) v5.y.v(matcher.group(3)));
        } else {
            j7 = j4;
        }
        return new r(f4, parseLong, j6, j7, file2);
    }

    public r gv(File file, long j2) {
        v5.y.fb(this.f7252s);
        return new r(this.y, this.f7254v, this.f7251fb, j2, file);
    }
}
