package e4;

import java.io.IOException;
/* loaded from: classes.dex */
public interface tl extends kx.c5 {
    boolean co(int i, boolean z2) throws IOException;

    boolean f(byte[] bArr, int i, int i5, boolean z2) throws IOException;

    long getLength();

    long getPosition();

    void p(int i) throws IOException;

    @Override // kx.c5
    int read(byte[] bArr, int i, int i5) throws IOException;

    void readFully(byte[] bArr, int i, int i5) throws IOException;

    void s();

    long t();

    boolean v(byte[] bArr, int i, int i5, boolean z2) throws IOException;

    int w(byte[] bArr, int i, int i5) throws IOException;

    void wz(int i) throws IOException;

    int xc(int i) throws IOException;

    void z(byte[] bArr, int i, int i5) throws IOException;
}
