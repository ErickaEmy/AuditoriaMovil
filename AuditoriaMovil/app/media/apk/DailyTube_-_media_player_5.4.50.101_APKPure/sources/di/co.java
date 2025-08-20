package di;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import v5.j5;
/* loaded from: classes.dex */
public final class co extends BufferedOutputStream {
    public boolean y;

    public co(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.y = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            j5.le(th);
        }
    }

    public void y(OutputStream outputStream) {
        v5.y.fb(this.y);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.y = false;
    }

    public co(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
