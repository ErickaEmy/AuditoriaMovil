package com.google.zxing;

import ch.qos.logback.core.CoreConstants;
/* loaded from: classes.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public boolean isRotateSupported() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LuminanceSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.width;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.height * (i + 1));
        for (int i2 = 0; i2 < this.height; i2++) {
            bArr = getRow(i2, bArr);
            for (int i3 = 0; i3 < this.width; i3++) {
                int i4 = bArr[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? CoreConstants.DOT : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
