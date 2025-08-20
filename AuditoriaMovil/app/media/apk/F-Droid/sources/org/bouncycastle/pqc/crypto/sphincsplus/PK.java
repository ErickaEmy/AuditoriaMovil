package org.bouncycastle.pqc.crypto.sphincsplus;
/* loaded from: classes2.dex */
class PK {
    final byte[] root;
    final byte[] seed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.root = bArr2;
    }
}
