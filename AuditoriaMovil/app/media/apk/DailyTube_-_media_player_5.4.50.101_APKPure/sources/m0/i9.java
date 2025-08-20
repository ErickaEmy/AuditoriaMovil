package m0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class i9 implements t {

    /* renamed from: n3  reason: collision with root package name */
    public final /* synthetic */ z f10555n3;
    public final /* synthetic */ Set y;

    /* renamed from: zn  reason: collision with root package name */
    public final /* synthetic */ ZipFile f10556zn;

    public i9(wz wzVar, Set set, z zVar, ZipFile zipFile) {
        this.y = set;
        this.f10555n3 = zVar;
        this.f10556zn = zipFile;
    }

    @Override // m0.t
    public final void y(tl tlVar, File file, boolean z2) throws IOException {
        this.y.add(file);
        if (!z2) {
            this.f10555n3.n3();
            String str = tlVar.y;
            this.f10555n3.y().getAbsolutePath();
            tlVar.f10561n3.getName();
            file.getAbsolutePath();
            ZipFile zipFile = this.f10556zn;
            ZipEntry zipEntry = tlVar.f10561n3;
            byte[] bArr = new byte[4096];
            if (file.exists()) {
                file.delete();
            }
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                a.tl(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
    }
}
