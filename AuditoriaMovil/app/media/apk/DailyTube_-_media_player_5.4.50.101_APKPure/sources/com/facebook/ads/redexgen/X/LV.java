package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.Writer;
/* loaded from: assets/audience_network.dex */
public class LV extends Writer {
    public static String[] A03 = {"m3VYVt1tyYlWEg8H2HS3pUr0VsrhpbIN", "rEdvzR", "IUQqTrakmjCy7RtoUebGZ8YLkwuKbv7t", "x1ufNW", "e7NtJ1", "AK7iWzpXctzvcUrQA38QQTSmPkrm2HP", "25DCnOqD1cr08G9nl6wTfczykol7NaSA", "0bM1VBntYb2o4FFsMu8yzxmwObMsLmHM"};
    public int A00;
    public char[] A01 = new char[1024];
    public final LU A02;

    public LV(LU lu) {
        this.A02 = lu;
    }

    private void A00() {
        this.A02.AE8(new String(this.A01, 0, this.A00));
        this.A00 = 0;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        flush();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        if (this.A00 > 0) {
            A00();
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i5) throws IOException {
        int i6 = i;
        while (true) {
            int i8 = i + i5;
            String[] strArr = A03;
            String str = strArr[3];
            String str2 = strArr[1];
            int length = str.length();
            int i10 = str2.length();
            if (length != i10) {
                throw new RuntimeException();
            }
            A03[5] = "5m1TKypG4e5yu";
            if (i6 < i8) {
                if (cArr[i6] != '\n') {
                    int i11 = this.A00;
                    char[] cArr2 = this.A01;
                    int i12 = cArr2.length;
                    if (i11 != i12) {
                        cArr2[i11] = cArr[i6];
                        int i13 = i11 + 1;
                        this.A00 = i13;
                        i6++;
                    }
                }
                A00();
                i6++;
            } else {
                return;
            }
        }
    }
}
