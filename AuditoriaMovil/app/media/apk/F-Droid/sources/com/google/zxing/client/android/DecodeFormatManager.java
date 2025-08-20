package com.google.zxing.client.android;

import android.content.Intent;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class DecodeFormatManager {
    static final Set AZTEC_FORMATS;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    static final Set DATA_MATRIX_FORMATS;
    private static final Map FORMATS_FOR_MODE;
    static final Set INDUSTRIAL_FORMATS;
    private static final Set ONE_D_FORMATS;
    static final Set PDF417_FORMATS;
    static final Set PRODUCT_FORMATS;
    static final Set QR_CODE_FORMATS;

    static {
        EnumSet of = EnumSet.of(BarcodeFormat.QR_CODE);
        QR_CODE_FORMATS = of;
        EnumSet of2 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        DATA_MATRIX_FORMATS = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.AZTEC);
        AZTEC_FORMATS = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.PDF_417);
        PDF417_FORMATS = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        PRODUCT_FORMATS = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        INDUSTRIAL_FORMATS = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of5);
        ONE_D_FORMATS = copyOf;
        copyOf.addAll(of6);
        HashMap hashMap = new HashMap();
        FORMATS_FOR_MODE = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of5);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("DATA_MATRIX_MODE", of2);
        hashMap.put("AZTEC_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }

    public static Set parseDecodeFormats(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return parseDecodeFormats(stringExtra != null ? Arrays.asList(COMMA_PATTERN.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set parseDecodeFormats(Iterable iterable, String str) {
        if (iterable != null) {
            EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    noneOf.add(BarcodeFormat.valueOf((String) it.next()));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return (Set) FORMATS_FOR_MODE.get(str);
        }
        return null;
    }
}
