package androidx.room.util;

import android.os.Build;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.fdroid.Preferences;
/* compiled from: FileUtil.kt */
/* loaded from: classes.dex */
public abstract class FileUtil {
    public static final void copy(ReadableByteChannel input, FileChannel output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        try {
            if (Build.VERSION.SDK_INT > 23) {
                output.transferFrom(input, 0L, Preferences.UPDATE_INTERVAL_DISABLED);
            } else {
                InputStream newInputStream = Channels.newInputStream(input);
                OutputStream newOutputStream = Channels.newOutputStream(output);
                byte[] bArr = new byte[PKIFailureInfo.certConfirmed];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            }
            output.force(false);
            input.close();
            output.close();
        } catch (Throwable th) {
            input.close();
            output.close();
            throw th;
        }
    }
}
