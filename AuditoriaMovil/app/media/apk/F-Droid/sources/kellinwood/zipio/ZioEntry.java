package kellinwood.zipio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Date;
import java.util.Locale;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kellinwood.logging.LoggerInterface;
import kellinwood.logging.LoggerManager;
/* loaded from: classes.dex */
public class ZioEntry implements Cloneable {
    private static byte[] alignBytes = new byte[4];
    private static LoggerInterface log;
    private int compressedSize;
    private short compression;
    private int crc32;
    private byte[] data;
    private long dataPosition;
    private short diskNumberStart;
    private ZioEntryOutputStream entryOut;
    private int externalAttributes;
    private byte[] extraData;
    private String fileComment;
    private String filename;
    private short generalPurposeBits;
    private short internalAttributes;
    private int localHeaderOffset;
    private short modificationDate;
    private short modificationTime;
    private short numAlignBytes;
    private int size;
    private short versionMadeBy;
    private short versionRequired;
    private ZipInput zipInput;

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public short getCompression() {
        return this.compression;
    }

    public int getCrc32() {
        return this.crc32;
    }

    public long getDataPosition() {
        return this.dataPosition;
    }

    public String getName() {
        return this.filename;
    }

    public int getSize() {
        return this.size;
    }

    public ZipInput getZipInput() {
        return this.zipInput;
    }

    public ZioEntry(ZipInput zipInput) {
        this.numAlignBytes = (short) 0;
        this.dataPosition = -1L;
        this.data = null;
        this.entryOut = null;
        this.zipInput = zipInput;
    }

    public static LoggerInterface getLogger() {
        if (log == null) {
            log = LoggerManager.getLogger(ZioEntry.class.getName());
        }
        return log;
    }

    public ZioEntry(String str) {
        this.numAlignBytes = (short) 0;
        this.dataPosition = -1L;
        this.data = null;
        this.entryOut = null;
        this.filename = str;
        this.fileComment = "";
        this.compression = (short) 8;
        this.extraData = new byte[0];
        setTime(System.currentTimeMillis());
    }

    public void readLocalHeader() {
        ZipInput zipInput = this.zipInput;
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        zipInput.seek(this.localHeaderOffset);
        if (isDebugEnabled) {
            getLogger().debug(String.format("FILE POSITION: 0x%08x", Long.valueOf(zipInput.getFilePointer())));
        }
        if (zipInput.readInt() != 67324752) {
            throw new IllegalStateException(String.format("Local header not found at pos=0x%08x, file=%s", Long.valueOf(zipInput.getFilePointer()), this.filename));
        }
        short readShort = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Version required: 0x%04x", Short.valueOf(readShort)));
        }
        short readShort2 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("General purpose bits: 0x%04x", Short.valueOf(readShort2)));
        }
        short readShort3 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Compression: 0x%04x", Short.valueOf(readShort3)));
        }
        short readShort4 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Modification time: 0x%04x", Short.valueOf(readShort4)));
        }
        short readShort5 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Modification date: 0x%04x", Short.valueOf(readShort5)));
        }
        int readInt = zipInput.readInt();
        if (isDebugEnabled) {
            log.debug(String.format("CRC-32: 0x%04x", Integer.valueOf(readInt)));
        }
        int readInt2 = zipInput.readInt();
        if (isDebugEnabled) {
            log.debug(String.format("Compressed size: 0x%04x", Integer.valueOf(readInt2)));
        }
        int readInt3 = zipInput.readInt();
        if (isDebugEnabled) {
            log.debug(String.format("Size: 0x%04x", Integer.valueOf(readInt3)));
        }
        short readShort6 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("File name length: 0x%04x", Short.valueOf(readShort6)));
        }
        short readShort7 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Extra length: 0x%04x", Short.valueOf(readShort7)));
        }
        String readString = zipInput.readString(readShort6);
        if (isDebugEnabled) {
            LoggerInterface loggerInterface = log;
            loggerInterface.debug("Filename: " + readString);
        }
        zipInput.readBytes(readShort7);
        long filePointer = zipInput.getFilePointer();
        this.dataPosition = filePointer;
        if (isDebugEnabled) {
            log.debug(String.format("Data position: 0x%08x", Long.valueOf(filePointer)));
        }
    }

    public void writeLocalEntry(ZipOutput zipOutput) {
        short filePointer;
        long j = 0;
        if (this.data == null && this.dataPosition < 0 && this.zipInput != null) {
            readLocalHeader();
        }
        this.localHeaderOffset = zipOutput.getFilePointer();
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        if (isDebugEnabled) {
            getLogger().debug(String.format("Writing local header at 0x%08x - %s", Integer.valueOf(this.localHeaderOffset), this.filename));
        }
        ZioEntryOutputStream zioEntryOutputStream = this.entryOut;
        if (zioEntryOutputStream != null) {
            zioEntryOutputStream.close();
            this.size = this.entryOut.getSize();
            byte[] byteArray = ((ByteArrayOutputStream) this.entryOut.getWrappedStream()).toByteArray();
            this.data = byteArray;
            this.compressedSize = byteArray.length;
            this.crc32 = this.entryOut.getCRC();
        }
        zipOutput.writeInt(67324752);
        zipOutput.writeShort(this.versionRequired);
        zipOutput.writeShort(this.generalPurposeBits);
        zipOutput.writeShort(this.compression);
        zipOutput.writeShort(this.modificationTime);
        zipOutput.writeShort(this.modificationDate);
        zipOutput.writeInt(this.crc32);
        zipOutput.writeInt(this.compressedSize);
        zipOutput.writeInt(this.size);
        zipOutput.writeShort((short) this.filename.length());
        this.numAlignBytes = (short) 0;
        if (this.compression == 0 && (filePointer = (short) ((((zipOutput.getFilePointer() + 2) + this.filename.length()) + this.extraData.length) % 4)) > 0) {
            this.numAlignBytes = (short) (4 - filePointer);
        }
        zipOutput.writeShort((short) (this.extraData.length + this.numAlignBytes));
        zipOutput.writeString(this.filename);
        zipOutput.writeBytes(this.extraData);
        short s = this.numAlignBytes;
        if (s > 0) {
            zipOutput.writeBytes(alignBytes, 0, s);
        }
        if (isDebugEnabled) {
            getLogger().debug(String.format(Locale.ENGLISH, "Data position 0x%08x", Integer.valueOf(zipOutput.getFilePointer())));
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            zipOutput.writeBytes(bArr);
            if (isDebugEnabled) {
                getLogger().debug(String.format(Locale.ENGLISH, "Wrote %d bytes", Integer.valueOf(this.data.length)));
                return;
            }
            return;
        }
        if (isDebugEnabled) {
            getLogger().debug(String.format("Seeking to position 0x%08x", Long.valueOf(this.dataPosition)));
        }
        this.zipInput.seek(this.dataPosition);
        int min = Math.min(this.compressedSize, 8096);
        byte[] bArr2 = new byte[min];
        while (true) {
            int i = this.compressedSize;
            if (j == i) {
                return;
            }
            int read = this.zipInput.in.read(bArr2, 0, (int) Math.min(i - j, min));
            if (read > 0) {
                zipOutput.writeBytes(bArr2, 0, read);
                if (isDebugEnabled) {
                    getLogger().debug(String.format(Locale.ENGLISH, "Wrote %d bytes", Integer.valueOf(read)));
                }
                j += read;
            } else {
                throw new IllegalStateException(String.format(Locale.ENGLISH, "EOF reached while copying %s with %d bytes left to go", this.filename, Long.valueOf(this.compressedSize - j)));
            }
        }
    }

    public static ZioEntry read(ZipInput zipInput) {
        if (zipInput.readInt() != 33639248) {
            zipInput.seek(zipInput.getFilePointer() - 4);
            return null;
        }
        ZioEntry zioEntry = new ZioEntry(zipInput);
        zioEntry.doRead(zipInput);
        return zioEntry;
    }

    private void doRead(ZipInput zipInput) {
        boolean isDebugEnabled = getLogger().isDebugEnabled();
        short readShort = zipInput.readShort();
        this.versionMadeBy = readShort;
        if (isDebugEnabled) {
            log.debug(String.format("Version made by: 0x%04x", Short.valueOf(readShort)));
        }
        short readShort2 = zipInput.readShort();
        this.versionRequired = readShort2;
        if (isDebugEnabled) {
            log.debug(String.format("Version required: 0x%04x", Short.valueOf(readShort2)));
        }
        short readShort3 = zipInput.readShort();
        this.generalPurposeBits = readShort3;
        if (isDebugEnabled) {
            log.debug(String.format("General purpose bits: 0x%04x", Short.valueOf(readShort3)));
        }
        if ((this.generalPurposeBits & 63473) != 0) {
            throw new IllegalStateException("Can't handle general purpose bits == " + String.format("0x%04x", Short.valueOf(this.generalPurposeBits)));
        }
        short readShort4 = zipInput.readShort();
        this.compression = readShort4;
        if (isDebugEnabled) {
            log.debug(String.format("Compression: 0x%04x", Short.valueOf(readShort4)));
        }
        short readShort5 = zipInput.readShort();
        this.modificationTime = readShort5;
        if (isDebugEnabled) {
            log.debug(String.format("Modification time: 0x%04x", Short.valueOf(readShort5)));
        }
        short readShort6 = zipInput.readShort();
        this.modificationDate = readShort6;
        if (isDebugEnabled) {
            log.debug(String.format("Modification date: 0x%04x", Short.valueOf(readShort6)));
        }
        int readInt = zipInput.readInt();
        this.crc32 = readInt;
        if (isDebugEnabled) {
            log.debug(String.format("CRC-32: 0x%04x", Integer.valueOf(readInt)));
        }
        int readInt2 = zipInput.readInt();
        this.compressedSize = readInt2;
        if (isDebugEnabled) {
            log.debug(String.format("Compressed size: 0x%04x", Integer.valueOf(readInt2)));
        }
        int readInt3 = zipInput.readInt();
        this.size = readInt3;
        if (isDebugEnabled) {
            log.debug(String.format("Size: 0x%04x", Integer.valueOf(readInt3)));
        }
        short readShort7 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("File name length: 0x%04x", Short.valueOf(readShort7)));
        }
        short readShort8 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("Extra length: 0x%04x", Short.valueOf(readShort8)));
        }
        short readShort9 = zipInput.readShort();
        if (isDebugEnabled) {
            log.debug(String.format("File comment length: 0x%04x", Short.valueOf(readShort9)));
        }
        short readShort10 = zipInput.readShort();
        this.diskNumberStart = readShort10;
        if (isDebugEnabled) {
            log.debug(String.format("Disk number start: 0x%04x", Short.valueOf(readShort10)));
        }
        short readShort11 = zipInput.readShort();
        this.internalAttributes = readShort11;
        if (isDebugEnabled) {
            log.debug(String.format("Internal attributes: 0x%04x", Short.valueOf(readShort11)));
        }
        int readInt4 = zipInput.readInt();
        this.externalAttributes = readInt4;
        if (isDebugEnabled) {
            log.debug(String.format("External attributes: 0x%08x", Integer.valueOf(readInt4)));
        }
        int readInt5 = zipInput.readInt();
        this.localHeaderOffset = readInt5;
        if (isDebugEnabled) {
            log.debug(String.format("Local header offset: 0x%08x", Integer.valueOf(readInt5)));
        }
        this.filename = zipInput.readString(readShort7);
        if (isDebugEnabled) {
            LoggerInterface loggerInterface = log;
            loggerInterface.debug("Filename: " + this.filename);
        }
        this.extraData = zipInput.readBytes(readShort8);
        this.fileComment = zipInput.readString(readShort9);
        if (isDebugEnabled) {
            LoggerInterface loggerInterface2 = log;
            loggerInterface2.debug("File comment: " + this.fileComment);
        }
        this.generalPurposeBits = (short) (this.generalPurposeBits & 2048);
        if (this.size == 0) {
            this.compressedSize = 0;
            this.compression = (short) 0;
            this.crc32 = 0;
        }
    }

    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[this.size];
        InputStream inputStream = getInputStream();
        int i = 0;
        while (true) {
            int i2 = this.size;
            if (i == i2) {
                return bArr2;
            }
            int read = inputStream.read(bArr2, i, i2 - i);
            if (read < 0) {
                throw new IllegalStateException(String.format(Locale.ENGLISH, "Read failed, expecting %d bytes, got %d instead", Integer.valueOf(this.size), Integer.valueOf(i)));
            }
            i += read;
        }
    }

    public InputStream getInputStream() {
        return getInputStream(null);
    }

    public InputStream getInputStream(OutputStream outputStream) {
        ZioEntryOutputStream zioEntryOutputStream = this.entryOut;
        if (zioEntryOutputStream != null) {
            zioEntryOutputStream.close();
            this.size = this.entryOut.getSize();
            byte[] byteArray = ((ByteArrayOutputStream) this.entryOut.getWrappedStream()).toByteArray();
            this.data = byteArray;
            this.compressedSize = byteArray.length;
            this.crc32 = this.entryOut.getCRC();
            this.entryOut = null;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
            return this.compression == 0 ? byteArrayInputStream : new InflaterInputStream(new SequenceInputStream(byteArrayInputStream, new ByteArrayInputStream(new byte[1])), new Inflater(true));
        }
        ZioEntryInputStream zioEntryInputStream = new ZioEntryInputStream(this);
        if (outputStream != null) {
            zioEntryInputStream.setMonitorStream(outputStream);
        }
        if (this.compression != 0) {
            zioEntryInputStream.setReturnDummyByte(true);
            return new InflaterInputStream(zioEntryInputStream, new Inflater(true));
        }
        return zioEntryInputStream;
    }

    public OutputStream getOutputStream() {
        ZioEntryOutputStream zioEntryOutputStream = new ZioEntryOutputStream(this.compression, new ByteArrayOutputStream());
        this.entryOut = zioEntryOutputStream;
        return zioEntryOutputStream;
    }

    public void write(ZipOutput zipOutput) {
        getLogger().isDebugEnabled();
        zipOutput.writeInt(33639248);
        zipOutput.writeShort(this.versionMadeBy);
        zipOutput.writeShort(this.versionRequired);
        zipOutput.writeShort(this.generalPurposeBits);
        zipOutput.writeShort(this.compression);
        zipOutput.writeShort(this.modificationTime);
        zipOutput.writeShort(this.modificationDate);
        zipOutput.writeInt(this.crc32);
        zipOutput.writeInt(this.compressedSize);
        zipOutput.writeInt(this.size);
        zipOutput.writeShort((short) this.filename.length());
        zipOutput.writeShort((short) (this.extraData.length + this.numAlignBytes));
        zipOutput.writeShort((short) this.fileComment.length());
        zipOutput.writeShort(this.diskNumberStart);
        zipOutput.writeShort(this.internalAttributes);
        zipOutput.writeInt(this.externalAttributes);
        zipOutput.writeInt(this.localHeaderOffset);
        zipOutput.writeString(this.filename);
        zipOutput.writeBytes(this.extraData);
        short s = this.numAlignBytes;
        if (s > 0) {
            zipOutput.writeBytes(alignBytes, 0, s);
        }
        zipOutput.writeString(this.fileComment);
    }

    public long getTime() {
        short s = this.modificationDate;
        int i = s & 31;
        short s2 = this.modificationTime;
        return new Date(((s >> 9) & 127) + 80, ((s >> 5) & 15) - 1, i, (s2 >> 11) & 31, (s2 >> 5) & 63, (s2 << 1) & 62).getTime();
    }

    public void setTime(long j) {
        Date date = new Date(j);
        int year = date.getYear();
        long month = year + 1900 < 1980 ? 2162688L : ((year - 80) << 25) | ((date.getMonth() + 1) << 21) | (date.getDate() << 16) | (date.getHours() << 11) | (date.getMinutes() << 5) | (date.getSeconds() >> 1);
        this.modificationDate = (short) (month >> 16);
        this.modificationTime = (short) (month & 65535);
    }

    public boolean isDirectory() {
        return this.filename.endsWith("/");
    }
}
