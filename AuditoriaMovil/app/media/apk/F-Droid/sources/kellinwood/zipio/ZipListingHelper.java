package kellinwood.zipio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kellinwood.logging.LoggerInterface;
/* loaded from: classes.dex */
public abstract class ZipListingHelper {
    static DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH:mm", Locale.ENGLISH);

    public static void listHeader(LoggerInterface loggerInterface) {
        loggerInterface.debug(" Length   Method    Size  Ratio   Date   Time   CRC-32    Name");
        loggerInterface.debug("--------  ------  ------- -----   ----   ----   ------    ----");
    }

    public static void listEntry(LoggerInterface loggerInterface, ZioEntry zioEntry) {
        int size = zioEntry.getSize() > 0 ? ((zioEntry.getSize() - zioEntry.getCompressedSize()) * 100) / zioEntry.getSize() : 0;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(zioEntry.getSize());
        objArr[1] = zioEntry.getCompression() == 0 ? "Stored" : "Defl:N";
        objArr[2] = Integer.valueOf(zioEntry.getCompressedSize());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = dateFormat.format(new Date(zioEntry.getTime()));
        objArr[5] = Integer.valueOf(zioEntry.getCrc32());
        objArr[6] = zioEntry.getName();
        loggerInterface.debug(String.format(locale, "%8d  %6s %8d %4d%% %s  %08x  %s", objArr));
    }
}
