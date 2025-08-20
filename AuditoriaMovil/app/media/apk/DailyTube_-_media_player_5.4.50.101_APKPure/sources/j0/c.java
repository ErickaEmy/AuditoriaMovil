package j0;

import java.io.File;
/* loaded from: classes.dex */
public final class c implements d0 {
    @Override // j0.d0
    public final boolean y(Object obj, File file, File file2) {
        return new File((String) j.fb(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
