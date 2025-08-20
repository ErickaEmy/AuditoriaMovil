package v5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final File f14383n3;
    public final File y;

    /* loaded from: classes.dex */
    public static final class y extends OutputStream {

        /* renamed from: v  reason: collision with root package name */
        public boolean f14384v;
        public final FileOutputStream y;

        public y(File file) throws FileNotFoundException {
            this.y = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f14384v) {
                return;
            }
            this.f14384v = true;
            flush();
            try {
                this.y.getFD().sync();
            } catch (IOException e2) {
                r.i9("AtomicFile", "Failed to sync file descriptor:", e2);
            }
            this.y.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.y.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.y.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.y.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i5) throws IOException {
            this.y.write(bArr, i, i5);
        }
    }

    public n3(File file) {
        this.y = file;
        this.f14383n3 = new File(file.getPath() + ".bak");
    }

    public OutputStream a() throws IOException {
        if (this.y.exists()) {
            if (!this.f14383n3.exists()) {
                if (!this.y.renameTo(this.f14383n3)) {
                    r.c5("AtomicFile", "Couldn't rename file " + this.y + " to backup file " + this.f14383n3);
                }
            } else {
                this.y.delete();
            }
        }
        try {
            return new y(this.y);
        } catch (FileNotFoundException e2) {
            File parentFile = this.y.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new y(this.y);
                } catch (FileNotFoundException e3) {
                    throw new IOException("Couldn't create " + this.y, e3);
                }
            }
            throw new IOException("Couldn't create " + this.y, e2);
        }
    }

    public InputStream gv() throws FileNotFoundException {
        v();
        return new FileInputStream(this.y);
    }

    public void n3(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.f14383n3.delete();
    }

    public final void v() {
        if (this.f14383n3.exists()) {
            this.y.delete();
            this.f14383n3.renameTo(this.y);
        }
    }

    public void y() {
        this.y.delete();
        this.f14383n3.delete();
    }

    public boolean zn() {
        if (!this.y.exists() && !this.f14383n3.exists()) {
            return false;
        }
        return true;
    }
}
