package kellinwood.zipio;

import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
/* loaded from: classes.dex */
public class CentralEnd {
    private static LoggerInterface log;
    public int centralDirectorySize;
    public int centralStartOffset;
    public String fileComment;
    public short numCentralEntries;
    public short totalCentralEntries;
    public int signature = 101010256;
    public short numberThisDisk = 0;
    public short centralStartDisk = 0;

    public static CentralEnd read(ZipInput zipInput) {
        if (zipInput.readInt() != 101010256) {
            zipInput.seek(zipInput.getFilePointer() - 4);
            return null;
        }
        CentralEnd centralEnd = new CentralEnd();
        centralEnd.doRead(zipInput);
        return centralEnd;
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(CentralEnd.class.getName());
        }
        return log;
    }

    private void doRead(ZipInput zipInput) {
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        short readShort = zipInput.readShort();
        this.numberThisDisk = readShort;
        if (isDebugEnabled) {
            log.debug(String.format("This disk number: 0x%04x", Short.valueOf(readShort)));
        }
        short readShort2 = zipInput.readShort();
        this.centralStartDisk = readShort2;
        if (isDebugEnabled) {
            log.debug(String.format("Central dir start disk number: 0x%04x", Short.valueOf(readShort2)));
        }
        short readShort3 = zipInput.readShort();
        this.numCentralEntries = readShort3;
        if (isDebugEnabled) {
            log.debug(String.format("Central entries on this disk: 0x%04x", Short.valueOf(readShort3)));
        }
        short readShort4 = zipInput.readShort();
        this.totalCentralEntries = readShort4;
        if (isDebugEnabled) {
            log.debug(String.format("Total number of central entries: 0x%04x", Short.valueOf(readShort4)));
        }
        int readInt = zipInput.readInt();
        this.centralDirectorySize = readInt;
        if (isDebugEnabled) {
            log.debug(String.format("Central directory size: 0x%08x", Integer.valueOf(readInt)));
        }
        int readInt2 = zipInput.readInt();
        this.centralStartOffset = readInt2;
        if (isDebugEnabled) {
            log.debug(String.format("Central directory offset: 0x%08x", Integer.valueOf(readInt2)));
        }
        this.fileComment = zipInput.readString(zipInput.readShort());
        if (isDebugEnabled) {
            LoggerInterface loggerInterface = log;
            loggerInterface.debug(".ZIP file comment: " + this.fileComment);
        }
    }

    public void write(ZipOutput zipOutput) {
        getLogger().isDebugEnabled();
        zipOutput.writeInt(this.signature);
        zipOutput.writeShort(this.numberThisDisk);
        zipOutput.writeShort(this.centralStartDisk);
        zipOutput.writeShort(this.numCentralEntries);
        zipOutput.writeShort(this.totalCentralEntries);
        zipOutput.writeInt(this.centralDirectorySize);
        zipOutput.writeInt(this.centralStartOffset);
        zipOutput.writeShort((short) this.fileComment.length());
        zipOutput.writeString(this.fileComment);
    }
}
