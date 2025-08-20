package org.bouncycastle.pqc.crypto.sphincsplus;
/* loaded from: classes2.dex */
class SIG_FORS {
    final byte[][] authPath;
    final byte[] sk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SIG_FORS(byte[] bArr, byte[][] bArr2) {
        this.authPath = bArr2;
        this.sk = bArr;
    }

    public byte[][] getAuthPath() {
        return this.authPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getSK() {
        return this.sk;
    }
}
