package kellinwood.zipio;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
/* loaded from: classes.dex */
public class ZipInput implements Closeable {
    static LoggerInterface log;
    CentralEnd centralEnd;
    long fileLength;
    RandomAccessFile in;
    public String inputFilename;
    int scanIterations = 0;
    Map zioEntries = new LinkedHashMap();

    public Map getEntries() {
        return this.zioEntries;
    }

    public ZipInput(String str) {
        this.in = null;
        this.inputFilename = str;
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.inputFilename), "r");
        this.in = randomAccessFile;
        this.fileLength = randomAccessFile.length();
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipInput.class.getName());
        }
        return log;
    }

    public static ZipInput read(String str) {
        ZipInput zipInput = new ZipInput(str);
        zipInput.doRead();
        return zipInput;
    }

    public long scanForEOCDR(int i) {
        long j = i;
        long j2 = this.fileLength;
        if (j > j2 || i > 65536) {
            throw new IllegalStateException("End of central directory not found in " + this.inputFilename);
        }
        int min = (int) Math.min(j2, j);
        byte[] bArr = new byte[min];
        long j3 = min;
        this.in.seek(this.fileLength - j3);
        this.in.readFully(bArr);
        for (int i2 = min - 22; i2 >= 0; i2--) {
            this.scanIterations++;
            if (bArr[i2] == 80 && bArr[i2 + 1] == 75 && bArr[i2 + 2] == 5 && bArr[i2 + 3] == 6) {
                return (this.fileLength - j3) + i2;
            }
        }
        return scanForEOCDR(i * 2);
    }

    private void doRead() {
        try {
            long length = this.in.length();
            this.in.seek(scanForEOCDR(length < ((long) 256) ? (int) length : 256));
            this.centralEnd = CentralEnd.read(this);
            boolean isDebugEnabled = getLogger().isDebugEnabled();
            if (isDebugEnabled) {
                LoggerInterface logger = getLogger();
                Locale locale = Locale.ENGLISH;
                logger.debug(String.format(locale, "EOCD found in %d iterations", Integer.valueOf(this.scanIterations)));
                getLogger().debug(String.format(locale, "Directory entries=%d, size=%d, offset=%d/0x%08x", Short.valueOf(this.centralEnd.totalCentralEntries), Integer.valueOf(this.centralEnd.centralDirectorySize), Integer.valueOf(this.centralEnd.centralStartOffset), Integer.valueOf(this.centralEnd.centralStartOffset)));
                ZipListingHelper.listHeader(getLogger());
            }
            this.in.seek(this.centralEnd.centralStartOffset);
            for (int i = 0; i < this.centralEnd.totalCentralEntries; i++) {
                ZioEntry read = ZioEntry.read(this);
                this.zioEntries.put(read.getName(), read);
                if (isDebugEnabled) {
                    ZipListingHelper.listEntry(getLogger(), read);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RandomAccessFile randomAccessFile = this.in;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public long getFilePointer() {
        return this.in.getFilePointer();
    }

    public void seek(long j) {
        this.in.seek(j);
    }

    public int readInt() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i |= this.in.readUnsignedByte() << (i2 * 8);
        }
        return i;
    }

    public short readShort() {
        short s = 0;
        for (int i = 0; i < 2; i++) {
            s = (short) (s | (this.in.readUnsignedByte() << (i * 8)));
        }
        return s;
    }

    public String readString(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = this.in.readByte();
        }
        return new String(bArr);
    }

    public byte[] readBytes(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = this.in.readByte();
        }
        return bArr;
    }
}
