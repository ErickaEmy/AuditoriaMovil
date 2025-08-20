package rb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ta implements u0.s, c5 {

    /* renamed from: f  reason: collision with root package name */
    public final int f13259f;

    /* renamed from: fb  reason: collision with root package name */
    public final File f13260fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f13261p;

    /* renamed from: s  reason: collision with root package name */
    public final Callable<InputStream> f13262s;

    /* renamed from: t  reason: collision with root package name */
    public final u0.s f13263t;

    /* renamed from: v  reason: collision with root package name */
    public final String f13264v;

    /* renamed from: w  reason: collision with root package name */
    public s f13265w;
    public final Context y;

    public ta(Context context, String str, File file, Callable<InputStream> callable, int i, u0.s delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.y = context;
        this.f13264v = str;
        this.f13260fb = file;
        this.f13262s = callable;
        this.f13259f = i;
        this.f13263t = delegate;
    }

    @Override // u0.s, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        y().close();
        this.f13261p = false;
    }

    @Override // u0.s
    public String getDatabaseName() {
        return y().getDatabaseName();
    }

    @Override // u0.s
    public u0.fb getReadableDatabase() {
        if (!this.f13261p) {
            mt(false);
            this.f13261p = true;
        }
        return y().getReadableDatabase();
    }

    @Override // u0.s
    public u0.fb getWritableDatabase() {
        if (!this.f13261p) {
            mt(true);
            this.f13261p = true;
        }
        return y().getWritableDatabase();
    }

    public final void mt(boolean z2) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databaseFile = this.y.getDatabasePath(databaseName);
            s sVar = this.f13265w;
            s sVar2 = null;
            if (sVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                sVar = null;
            }
            boolean z3 = sVar.f13243co;
            File filesDir = this.y.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
            y4.y yVar = new y4.y(databaseName, filesDir, z3);
            try {
                y4.y.zn(yVar, false, 1, null);
                if (!databaseFile.exists()) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(databaseFile, "databaseFile");
                        v(databaseFile, z2);
                        yVar.gv();
                        return;
                    } catch (IOException e2) {
                        throw new RuntimeException("Unable to copy database file.", e2);
                    }
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(databaseFile, "databaseFile");
                    int zn2 = m.n3.zn(databaseFile);
                    if (zn2 == this.f13259f) {
                        yVar.gv();
                        return;
                    }
                    s sVar3 = this.f13265w;
                    if (sVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                    } else {
                        sVar2 = sVar3;
                    }
                    if (sVar2.y(zn2, this.f13259f)) {
                        yVar.gv();
                        return;
                    }
                    if (this.y.deleteDatabase(databaseName)) {
                        try {
                            v(databaseFile, z2);
                        } catch (IOException e3) {
                            Log.w("ROOM", "Unable to copy database file.", e3);
                        }
                    } else {
                        Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    yVar.gv();
                    return;
                } catch (IOException e5) {
                    Log.w("ROOM", "Unable to read database version.", e5);
                    yVar.gv();
                    return;
                }
            } catch (Throwable th) {
                yVar.gv();
                throw th;
            }
            yVar.gv();
            throw th;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void p(s databaseConfiguration) {
        Intrinsics.checkNotNullParameter(databaseConfiguration, "databaseConfiguration");
        this.f13265w = databaseConfiguration;
    }

    public final void s(File file, boolean z2) {
        s sVar = this.f13265w;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
            sVar = null;
        }
        sVar.getClass();
    }

    @Override // u0.s
    public void setWriteAheadLoggingEnabled(boolean z2) {
        y().setWriteAheadLoggingEnabled(z2);
    }

    public final void v(File file, boolean z2) throws IOException {
        ReadableByteChannel newChannel;
        if (this.f13264v != null) {
            newChannel = Channels.newChannel(this.y.getAssets().open(this.f13264v));
            Intrinsics.checkNotNullExpressionValue(newChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.f13260fb != null) {
            newChannel = new FileInputStream(this.f13260fb).getChannel();
            Intrinsics.checkNotNullExpressionValue(newChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.f13262s;
            if (callable != null) {
                try {
                    newChannel = Channels.newChannel(callable.call());
                    Intrinsics.checkNotNullExpressionValue(newChannel, "newChannel(inputStream)");
                } catch (Exception e2) {
                    throw new IOException("inputStreamCallable exception on call", e2);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File intermediateFile = File.createTempFile("room-copy-helper", ".tmp", this.y.getCacheDir());
        intermediateFile.deleteOnExit();
        FileChannel output = new FileOutputStream(intermediateFile).getChannel();
        Intrinsics.checkNotNullExpressionValue(output, "output");
        m.zn.y(newChannel, output);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        Intrinsics.checkNotNullExpressionValue(intermediateFile, "intermediateFile");
        s(intermediateFile, z2);
        if (intermediateFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + intermediateFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    @Override // rb.c5
    public u0.s y() {
        return this.f13263t;
    }
}
