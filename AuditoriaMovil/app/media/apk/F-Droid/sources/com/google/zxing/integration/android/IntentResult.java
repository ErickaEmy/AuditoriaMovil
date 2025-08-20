package com.google.zxing.integration.android;

import android.content.Intent;
/* loaded from: classes.dex */
public final class IntentResult {
    private final String barcodeImagePath;
    private final String contents;
    private final String errorCorrectionLevel;
    private final String formatName;
    private final Integer orientation;
    private final Intent originalIntent;
    private final byte[] rawBytes;

    public String getContents() {
        return this.contents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntentResult(Intent intent) {
        this(null, null, null, null, null, null, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntentResult(String str, String str2, byte[] bArr, Integer num, String str3, String str4, Intent intent) {
        this.contents = str;
        this.formatName = str2;
        this.rawBytes = bArr;
        this.orientation = num;
        this.errorCorrectionLevel = str3;
        this.barcodeImagePath = str4;
        this.originalIntent = intent;
    }

    public String toString() {
        byte[] bArr = this.rawBytes;
        int length = bArr == null ? 0 : bArr.length;
        return "Format: " + this.formatName + "\nContents: " + this.contents + "\nRaw bytes: (" + length + " bytes)\nOrientation: " + this.orientation + "\nEC level: " + this.errorCorrectionLevel + "\nBarcode image: " + this.barcodeImagePath + "\nOriginal intent: " + this.originalIntent + '\n';
    }
}
