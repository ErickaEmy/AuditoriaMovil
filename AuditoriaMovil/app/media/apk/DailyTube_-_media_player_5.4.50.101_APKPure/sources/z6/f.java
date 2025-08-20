package z6;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k5.fb;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class y {
        public static ParcelFileDescriptor y(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }

    @Nullable
    public static ByteBuffer a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull Uri uri) {
        try {
            ParcelFileDescriptor y2 = y.y(context.getContentResolver(), uri, "r", cancellationSignal);
            if (y2 == null) {
                if (y2 != null) {
                    y2.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(y2.getFileDescriptor());
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            fileInputStream.close();
            y2.close();
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    @Nullable
    public static ByteBuffer fb(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            fileInputStream.close();
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean gv(@NonNull File file, @NonNull InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    y(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            y(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            y(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    @Nullable
    public static ByteBuffer n3(@NonNull Context context, @NonNull Resources resources, int i) {
        File v2 = v(context);
        if (v2 == null) {
            return null;
        }
        try {
            if (!zn(v2, resources, i)) {
                return null;
            }
            return fb(v2);
        } finally {
            v2.delete();
        }
    }

    @NonNull
    public static Map<Uri, ByteBuffer> s(@NonNull Context context, @NonNull fb.n3[] n3VarArr, @Nullable CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (fb.n3 n3Var : n3VarArr) {
            if (n3Var.n3() == 0) {
                Uri gv2 = n3Var.gv();
                if (!hashMap.containsKey(gv2)) {
                    hashMap.put(gv2, a(context, cancellationSignal, gv2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @Nullable
    public static File v(@NonNull Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static void y(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean zn(@NonNull File file, @NonNull Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean gv2 = gv(file, inputStream);
                y(inputStream);
                return gv2;
            } catch (Throwable th) {
                th = th;
                y(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }
}
