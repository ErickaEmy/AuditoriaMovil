package org.acra.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
/* compiled from: StreamReader.kt */
/* loaded from: classes2.dex */
public final class StreamReader {
    public static final Companion Companion = new Companion(null);
    private static final Regex newline = new Regex("\\r?\\n");
    private Function1 filter;
    private final InputStream inputStream;
    private int limit;
    private int timeout;

    /* compiled from: StreamReader.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final StreamReader setFilter(Function1 function1) {
        this.filter = function1;
        return this;
    }

    public final StreamReader setLimit(int i) {
        this.limit = i;
        return this;
    }

    public final StreamReader setTimeout(int i) {
        this.timeout = i;
        return this;
    }

    public StreamReader(InputStream inputStream, int i, int i2, Function1 function1) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.inputStream = inputStream;
        this.limit = i;
        this.timeout = i2;
        this.filter = function1;
    }

    public /* synthetic */ StreamReader(InputStream inputStream, int i, int i2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? null : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamReader(String filename) {
        this(new File(filename));
        Intrinsics.checkNotNullParameter(filename, "filename");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamReader(File file) {
        this(new FileInputStream(file), 0, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public final String read() {
        List takeLast;
        String joinToString$default;
        String joinToString$default2;
        String readFully = this.timeout == -1 ? readFully() : readWithTimeout();
        Function1 function1 = this.filter;
        if (function1 != null) {
            List split = newline.split(readFully, 0);
            List arrayList = new ArrayList();
            for (Object obj : split) {
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            int i = this.limit;
            if (i != -1) {
                arrayList = CollectionsKt___CollectionsKt.takeLast(arrayList, i);
            }
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
            if (joinToString$default2 != null) {
                return joinToString$default2;
            }
        }
        if (this.limit == -1) {
            return readFully;
        }
        takeLast = CollectionsKt___CollectionsKt.takeLast(newline.split(readFully, 0), this.limit);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(takeLast, "\n", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final String readFully() {
        InputStreamReader inputStreamReader = new InputStreamReader(this.inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return readText;
        } finally {
        }
    }

    private final String readWithTimeout() {
        long currentTimeMillis = System.currentTimeMillis() + this.timeout;
        InputStream inputStream = this.inputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int readUntil = readUntil(inputStream, bArr, currentTimeMillis);
                if (readUntil != -1) {
                    byteArrayOutputStream.write(bArr, 0, readUntil);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    CloseableKt.closeFinally(inputStream, null);
                    Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream2, "use(...)");
                    return byteArrayOutputStream2;
                }
            }
        } finally {
        }
    }

    private final int readUntil(InputStream inputStream, byte[] bArr, long j) {
        int read;
        int i = 0;
        while (System.currentTimeMillis() < j && i < bArr.length && (read = inputStream.read(bArr, i, Math.min(this.inputStream.available(), bArr.length - i))) != -1) {
            i += read;
        }
        return i;
    }
}
