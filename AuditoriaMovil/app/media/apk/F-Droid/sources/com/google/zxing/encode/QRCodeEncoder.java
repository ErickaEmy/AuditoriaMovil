package com.google.zxing.encode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import ch.qos.logback.core.CoreConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class QRCodeEncoder {
    private String contents;
    private final int dimension;
    private String displayContents;
    private final boolean encoded;
    private BarcodeFormat format;
    private String title;

    public QRCodeEncoder(String str, Bundle bundle, String str2, String str3, int i) {
        this.dimension = i;
        this.encoded = encodeContents(str, bundle, str2, str3);
    }

    private boolean encodeContents(String str, Bundle bundle, String str2, String str3) {
        this.format = null;
        if (str3 != null) {
            try {
                this.format = BarcodeFormat.valueOf(str3);
            } catch (IllegalArgumentException unused) {
            }
        }
        BarcodeFormat barcodeFormat = this.format;
        if (barcodeFormat == null || barcodeFormat == BarcodeFormat.QR_CODE) {
            this.format = BarcodeFormat.QR_CODE;
            encodeQRCodeContents(str, bundle, str2);
        } else if (str != null && str.length() > 0) {
            this.contents = str;
            this.displayContents = str;
            this.title = "Text";
        }
        String str4 = this.contents;
        return str4 != null && str4.length() > 0;
    }

    private void encodeQRCodeContents(String str, Bundle bundle, String str2) {
        str2.hashCode();
        int i = 0;
        char c = 65535;
        switch (str2.hashCode()) {
            case -1309271157:
                if (str2.equals("PHONE_TYPE")) {
                    c = 0;
                    break;
                }
                break;
            case -670199783:
                if (str2.equals("CONTACT_TYPE")) {
                    c = 1;
                    break;
                }
                break;
            case 709220992:
                if (str2.equals("SMS_TYPE")) {
                    c = 2;
                    break;
                }
                break;
            case 1349204356:
                if (str2.equals("LOCATION_TYPE")) {
                    c = 3;
                    break;
                }
                break;
            case 1778595596:
                if (str2.equals("TEXT_TYPE")) {
                    c = 4;
                    break;
                }
                break;
            case 1833351709:
                if (str2.equals("EMAIL_TYPE")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String trim = trim(str);
                if (trim != null) {
                    this.contents = "tel:" + trim;
                    this.displayContents = PhoneNumberUtils.formatNumber(trim);
                    this.title = "Phone";
                    return;
                }
                return;
            case 1:
                if (bundle == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder(100);
                StringBuilder sb2 = new StringBuilder(100);
                sb.append("MECARD:");
                String trim2 = trim(bundle.getString("name"));
                if (trim2 != null) {
                    sb.append("N:");
                    sb.append(escapeMECARD(trim2));
                    sb.append(';');
                    sb2.append(trim2);
                }
                String trim3 = trim(bundle.getString("postal"));
                if (trim3 != null) {
                    sb.append("ADR:");
                    sb.append(escapeMECARD(trim3));
                    sb.append(';');
                    sb2.append('\n');
                    sb2.append(trim3);
                }
                HashSet<String> hashSet = new HashSet(Contents.PHONE_KEYS.length);
                int i2 = 0;
                while (true) {
                    String[] strArr = Contents.PHONE_KEYS;
                    if (i2 < strArr.length) {
                        String trim4 = trim(bundle.getString(strArr[i2]));
                        if (trim4 != null) {
                            hashSet.add(trim4);
                        }
                        i2++;
                    } else {
                        for (String str3 : hashSet) {
                            sb.append("TEL:");
                            sb.append(escapeMECARD(str3));
                            sb.append(';');
                            sb2.append('\n');
                            sb2.append(PhoneNumberUtils.formatNumber(str3));
                        }
                        HashSet<String> hashSet2 = new HashSet(Contents.EMAIL_KEYS.length);
                        while (true) {
                            String[] strArr2 = Contents.EMAIL_KEYS;
                            if (i < strArr2.length) {
                                String trim5 = trim(bundle.getString(strArr2[i]));
                                if (trim5 != null) {
                                    hashSet2.add(trim5);
                                }
                                i++;
                            } else {
                                for (String str4 : hashSet2) {
                                    sb.append("EMAIL:");
                                    sb.append(escapeMECARD(str4));
                                    sb.append(';');
                                    sb2.append('\n');
                                    sb2.append(str4);
                                }
                                String trim6 = trim(bundle.getString("URL_KEY"));
                                if (trim6 != null) {
                                    sb.append("URL:");
                                    sb.append(trim6);
                                    sb.append(';');
                                    sb2.append('\n');
                                    sb2.append(trim6);
                                }
                                String trim7 = trim(bundle.getString("NOTE_KEY"));
                                if (trim7 != null) {
                                    sb.append("NOTE:");
                                    sb.append(escapeMECARD(trim7));
                                    sb.append(';');
                                    sb2.append('\n');
                                    sb2.append(trim7);
                                }
                                if (sb2.length() <= 0) {
                                    this.contents = null;
                                    this.displayContents = null;
                                    return;
                                }
                                sb.append(';');
                                this.contents = sb.toString();
                                this.displayContents = sb2.toString();
                                this.title = "Contact";
                                return;
                            }
                        }
                    }
                }
            case 2:
                String trim8 = trim(str);
                if (trim8 != null) {
                    this.contents = "sms:" + trim8;
                    this.displayContents = PhoneNumberUtils.formatNumber(trim8);
                    this.title = "SMS";
                    return;
                }
                return;
            case 3:
                if (bundle != null) {
                    float f = bundle.getFloat("LAT", Float.MAX_VALUE);
                    float f2 = bundle.getFloat("LONG", Float.MAX_VALUE);
                    if (f == Float.MAX_VALUE || f2 == Float.MAX_VALUE) {
                        return;
                    }
                    this.contents = "geo:" + f + CoreConstants.COMMA_CHAR + f2;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(f);
                    sb3.append(",");
                    sb3.append(f2);
                    this.displayContents = sb3.toString();
                    this.title = "Location";
                    return;
                }
                return;
            case 4:
                if (str == null || str.length() <= 0) {
                    return;
                }
                this.contents = str;
                this.displayContents = str;
                this.title = "Text";
                return;
            case 5:
                String trim9 = trim(str);
                if (trim9 != null) {
                    this.contents = "mailto:" + trim9;
                    this.displayContents = trim9;
                    this.title = "E-Mail";
                    return;
                }
                return;
            default:
                return;
        }
    }

    public Bitmap encodeAsBitmap() {
        EnumMap enumMap = null;
        if (this.encoded) {
            String guessAppropriateEncoding = guessAppropriateEncoding(this.contents);
            if (guessAppropriateEncoding != null) {
                enumMap = new EnumMap(EncodeHintType.class);
                enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) guessAppropriateEncoding);
            }
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            String str = this.contents;
            BarcodeFormat barcodeFormat = this.format;
            int i = this.dimension;
            BitMatrix encode = multiFormatWriter.encode(str, barcodeFormat, i, i, enumMap);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 * width;
                for (int i4 = 0; i4 < width; i4++) {
                    iArr[i3 + i4] = encode.get(i4, i2) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        }
        return null;
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    private static String trim(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    private static String escapeMECARD(String str) {
        if (str != null) {
            if (str.indexOf(58) >= 0 || str.indexOf(59) >= 0) {
                int length = str.length();
                StringBuilder sb = new StringBuilder(length);
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == ':' || charAt == ';') {
                        sb.append(CoreConstants.ESCAPE_CHAR);
                    }
                    sb.append(charAt);
                }
                return sb.toString();
            }
            return str;
        }
        return str;
    }
}
