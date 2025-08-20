package kotlin.io;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class TextStreamsKt {
    public static final long copyTo(Reader reader, Writer out, int i) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j2 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j2 += read;
            read = reader.read(cArr);
        }
        return j2;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
