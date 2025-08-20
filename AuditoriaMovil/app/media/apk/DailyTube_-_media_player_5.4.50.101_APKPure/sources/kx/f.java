package kx;

import java.io.IOException;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface y {
        f y();
    }

    void close() throws IOException;

    void write(byte[] bArr, int i, int i5) throws IOException;

    void y(p pVar) throws IOException;
}
