package androidx.fragment.app;

import androidx.core.app.NotificationCompat;
import java.io.Writer;
/* loaded from: classes.dex */
final class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
    private final String mTag;

    public LogWriter(String str) {
        this.mTag = str;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            char c2 = cArr[i + i6];
            if (c2 == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c2);
            }
        }
    }
}
