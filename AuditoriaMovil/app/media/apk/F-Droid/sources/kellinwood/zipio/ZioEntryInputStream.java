package kellinwood.zipio;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Locale;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
/* loaded from: classes.dex */
public class ZioEntryInputStream extends InputStream {
    boolean debug;
    LoggerInterface log;
    int offset;
    RandomAccessFile raf;
    int size;
    boolean returnDummyByte = false;
    OutputStream monitor = null;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public void setMonitorStream(OutputStream outputStream) {
        this.monitor = outputStream;
    }

    public void setReturnDummyByte(boolean z) {
        this.returnDummyByte = z;
    }

    public ZioEntryInputStream(ZioEntry zioEntry) {
        LoggerInterface logger = LoggerManager.getLogger(getClass().getName());
        this.log = logger;
        this.debug = logger.isDebugEnabled();
        this.offset = 0;
        this.size = zioEntry.getCompressedSize();
        this.raf = zioEntry.getZipInput().in;
        if (zioEntry.getDataPosition() >= 0) {
            if (this.debug) {
                this.log.debug(String.format(Locale.ENGLISH, "Seeking to %d", Long.valueOf(zioEntry.getDataPosition())));
            }
            this.raf.seek(zioEntry.getDataPosition());
            return;
        }
        zioEntry.readLocalHeader();
    }

    @Override // java.io.InputStream
    public int available() {
        int i = this.size - this.offset;
        if (this.debug) {
            this.log.debug(String.format(Locale.ENGLISH, "Available = %d", Integer.valueOf(i)));
        }
        if (i == 0 && this.returnDummyByte) {
            return 1;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.size - this.offset == 0) {
            if (this.returnDummyByte) {
                this.returnDummyByte = false;
                return 0;
            }
            return -1;
        }
        int read = this.raf.read();
        if (read >= 0) {
            OutputStream outputStream = this.monitor;
            if (outputStream != null) {
                outputStream.write(read);
            }
            if (this.debug) {
                this.log.debug("Read 1 byte");
            }
            this.offset++;
        } else if (this.debug) {
            this.log.debug("Read 0 bytes");
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return readBytes(bArr, i, i2);
    }

    private int readBytes(byte[] bArr, int i, int i2) {
        if (this.size - this.offset == 0) {
            if (this.returnDummyByte) {
                this.returnDummyByte = false;
                bArr[i] = 0;
                return 1;
            }
            return -1;
        }
        int read = this.raf.read(bArr, i, Math.min(i2, available()));
        if (read > 0) {
            OutputStream outputStream = this.monitor;
            if (outputStream != null) {
                outputStream.write(bArr, i, read);
            }
            this.offset += read;
        }
        if (this.debug) {
            this.log.debug(String.format(Locale.ENGLISH, "Read %d bytes for read(b,%d,%d)", Integer.valueOf(read), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return readBytes(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long min = Math.min(j, available());
        RandomAccessFile randomAccessFile = this.raf;
        randomAccessFile.seek(randomAccessFile.getFilePointer() + min);
        if (this.debug) {
            this.log.debug(String.format(Locale.ENGLISH, "Skipped %d bytes", Long.valueOf(min)));
        }
        return min;
    }
}
