package kellinwood.zipio;

import java.io.OutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* loaded from: classes.dex */
public class ZipOutput {
    static LoggerInterface log;
    OutputStream out;
    int filePointer = 0;
    List entriesWritten = new LinkedList();
    Set namesWritten = new HashSet();

    public int getFilePointer() {
        return this.filePointer;
    }

    public ZipOutput(OutputStream outputStream) {
        this.out = null;
        this.out = outputStream;
    }

    private static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZipOutput.class.getName());
        }
        return log;
    }

    public void write(ZioEntry zioEntry) {
        String name = zioEntry.getName();
        if (this.namesWritten.contains(name)) {
            LoggerInterface logger = getLogger();
            logger.warning("Skipping duplicate file in output: " + name);
            return;
        }
        zioEntry.writeLocalEntry(this);
        this.entriesWritten.add(zioEntry);
        this.namesWritten.add(name);
        if (getLogger().isDebugEnabled()) {
            ZipListingHelper.listEntry(getLogger(), zioEntry);
        }
    }

    public void close() {
        CentralEnd centralEnd = new CentralEnd();
        centralEnd.centralStartOffset = getFilePointer();
        short size = (short) this.entriesWritten.size();
        centralEnd.totalCentralEntries = size;
        centralEnd.numCentralEntries = size;
        for (ZioEntry zioEntry : this.entriesWritten) {
            zioEntry.write(this);
        }
        centralEnd.centralDirectorySize = getFilePointer() - centralEnd.centralStartOffset;
        centralEnd.fileComment = "";
        centralEnd.write(this);
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public void writeInt(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i & GF2Field.MASK);
            i >>= 8;
        }
        this.out.write(bArr);
        this.filePointer += 4;
    }

    public void writeShort(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr[i] = (byte) (s & 255);
            s = (short) (s >> 8);
        }
        this.out.write(bArr);
        this.filePointer += 2;
    }

    public void writeString(String str) {
        byte[] bytes = str.getBytes();
        this.out.write(bytes);
        this.filePointer += bytes.length;
    }

    public void writeBytes(byte[] bArr) {
        this.out.write(bArr);
        this.filePointer += bArr.length;
    }

    public void writeBytes(byte[] bArr, int i, int i2) {
        this.out.write(bArr, i, i2);
        this.filePointer += i2;
    }
}
