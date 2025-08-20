package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.6d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04226d {
    public static byte[] A02;
    public static String[] A03 = {"xEW9LSpkxtcMkiVkCjWXuTu5CJHPJiyq", "tTP", "A", "dhAFlm3SiPB0s9864OvgcmZEVzRtwwmX", "mnE9bSEHBlleLkXo6La2W5bpkmZqSUyN", "0jwmHWkFqK", "xBcWrb6s57BN1yke0uYkFqIHC7aAgPEb", "dL0KwaEpZdlIbw3ka3MpOkzONR5qkJY2"};
    public static final String A04;
    public static volatile C04226d A05;
    public final C1115Ym A00;
    public final Map<String, C04196a> A01 = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private Bitmap A02(C04447f c04447f, C04196a c04196a, String str) {
        Bitmap A01;
        String str2 = c04196a.A07;
        int i = c04196a.A03;
        int i5 = c04196a.A04;
        long currentTimeMillis = System.currentTimeMillis();
        IOException e2 = null;
        String A08 = A08(223, 9, 70);
        boolean startsWith = str2.startsWith(A08);
        String A082 = A08(239, 22, 123);
        if (startsWith || str2.startsWith(A082)) {
            String substring = str2.startsWith(A08) ? str2.substring(A08.length()) : str2.substring(A082.length());
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.A00.getAssets().open(substring);
                    if (A0C(i, i5)) {
                        try {
                            A01 = AbstractC04266h.A01(inputStream, i, i5);
                        } catch (IOException e3) {
                            e = e3;
                            A0B(e);
                            if (inputStream != null) {
                                A0A(inputStream);
                            }
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            A0B(e);
                            if (inputStream != null) {
                                A0A(inputStream);
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                A0A(inputStream);
                            }
                            throw th;
                        }
                    } else {
                        A01 = BitmapFactory.decodeStream(inputStream);
                    }
                    if (inputStream != null) {
                        A0A(inputStream);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e6) {
                e = e6;
            } catch (OutOfMemoryError e8) {
                e = e8;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            boolean A0C = A0C(i, i5);
            if (A03[2].length() == 5) {
                throw new RuntimeException();
            }
            A03[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
            if (A0C) {
                try {
                    A01 = A05(str2, i, i5);
                } catch (IOException e9) {
                    e2 = e9;
                    A0B(e2);
                    A01 = A03(str2);
                }
            } else {
                A01 = A03(str2);
            }
        }
        String th4 = e2 != null ? e2.toString() : null;
        if (A01 == null) {
            C04246f.A03(c04447f, c04196a, str, C04246f.A03, th4, null, null);
            return null;
        }
        long A00 = A00(str2, A01);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (A00 > 0) {
            C04246f.A03(c04447f, c04196a, str, C04246f.A02, th4, Long.valueOf(A00), Long.valueOf(currentTimeMillis2));
            return A01;
        }
        C04246f.A03(c04447f, c04196a, str, C04246f.A01, th4, null, null);
        if (C0705Ih.A0t(c04447f)) {
            return null;
        }
        return A01;
    }

    public static String A08(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 89);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{97, 102, 34, 124, 98, 107, 68, 103, 98, 38, 105, 115, 114, 118, 115, 114, 38, 98, 99, 117, 114, 111, 104, 103, 114, 111, 105, 104, 38, 46, 96, 111, 106, 99, 59, 26, 49, 44, 53, 57, 40, 120, 43, 49, 34, 61, 120, 61, 32, 59, 61, 61, 60, 43, 120, 53, 57, 32, 120, 43, 49, 34, 61, 120, 62, 55, 42, 120, 43, 44, 55, 42, 57, 63, 61, 98, 120, 103, 69, 71, 76, 65, 4, 65, 86, 86, 75, 86, 10, 4, 102, 77, 80, 73, 69, 84, 4, 77, 87, 4, 74, 81, 72, 72, 10, 57, 30, 22, 19, 26, 27, 95, 11, 16, 95, 28, 16, 15, 6, 95, 19, 16, 28, 30, 19, 95, 22, 18, 30, 24, 26, 95, 22, 17, 11, 16, 95, 28, 30, 28, 23, 26, 95, 87, 10, 13, 19, 66, 53, 14, 1, 2, 12, 5, 64, 20, 15, 64, 23, 18, 9, 20, 5, 64, 2, 9, 20, 13, 1, 16, 64, 20, 15, 64, 6, 9, 12, 5, 64, 72, 21, 18, 12, 93, 80, 107, 100, 103, 105, 96, 37, 113, 106, 37, 114, 119, 108, 113, 96, 37, 103, 108, 113, 104, 100, 117, 37, 113, 106, 37, 106, 112, 113, 117, 112, 113, 37, 118, 113, 119, 96, 100, 104, 126, 108, 108, 122, 107, 37, 48, 48, 48, 63, 48, 53, 60, 99, 118, 118, 68, 75, 78, 71, 24, 13, 13, 13, 67, 76, 70, 80, 77, 75, 70, 125, 67, 81, 81, 71, 86, 13, 27, 31, 19, 21, 23, 0, 3, 13, 8, 77, 86, 83, 86, 87, 79, 86};
    }

    static {
        A09();
        A04 = C04226d.class.getSimpleName();
    }

    public C04226d(C1115Ym c1115Ym) {
        this.A00 = c1115Ym;
    }

    private int A00(String str, Bitmap bitmap) {
        String A08 = A08(0, 2, 17);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            int size = byteArrayOutputStream.size();
            if (size >= C0705Ih.A0F(this.A00)) {
                A0B(new Throwable(A08(35, 42, 1) + size));
                return 0;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            A0A(byteArrayOutputStream);
            if (A03[7].charAt(22) != 'z') {
                throw new RuntimeException();
            }
            A03[4] = "r6vsbyQxsbBUkJdqjFKv7NMRisOUwCFh";
            A0A(fileOutputStream);
            return size;
        } catch (OutOfMemoryError e2) {
            A0B(e2);
            Log.e(A04, A08(184, 39, 92), e2);
            return 0;
        } catch (FileNotFoundException e3) {
            Log.e(A04, A08(6, 29, 95) + file.getPath() + A08, e3);
            A0B(e3);
            return 0;
        } catch (IOException e5) {
            A0B(e5);
            Log.e(A04, A08(148, 36, 57) + str + A08, e5);
            return 0;
        } finally {
            A0A(byteArrayOutputStream);
            A0A(null);
        }
    }

    private final Bitmap A01(C04447f c04447f, C04196a c04196a, int i, int i5, String str) {
        if (C04246f.A06(c04447f) && A08(266, 4, 53).equals(str)) {
            Map<String, C04196a> map = this.A01;
            if (A03[4].charAt(4) != 'b') {
                throw new RuntimeException();
            }
            A03[1] = "FHlvPh";
            map.put(c04196a.A07, c04196a);
        }
        String str2 = c04196a.A07;
        C04236e c04236e = new C04236e(c04196a.A05, c04196a.A06, A08(261, 5, 43), str, str2);
        File A07 = A07(this.A00);
        StringBuilder append = new StringBuilder().append(str2.hashCode());
        String url = A08(2, 4, 85);
        File file = new File(A07, append.append(url).toString());
        if (!file.exists()) {
            C04246f.A04(c04447f, c04236e, false);
            String url2 = A08(232, 7, 0);
            if (str2.startsWith(url2)) {
                String url3 = A08(239, 22, 123);
                if (!str2.startsWith(url3)) {
                    return A04(str2, i5, i);
                }
            }
            return A02(c04447f, c04196a, str);
        }
        C04246f.A04(c04447f, c04236e, true);
        try {
            if (A0C(i5, i)) {
                return AbstractC04266h.A02(file.getCanonicalPath(), i5, i, this.A00);
            }
            String url4 = file.getCanonicalPath();
            return BitmapFactory.decodeFile(url4);
        } catch (IOException e2) {
            A0B(e2);
            return null;
        }
    }

    private Bitmap A03(String str) {
        byte[] bytes;
        RJ ADy = C0927Rc.A00(this.A00).ADy(str, new RY());
        if (ADy != null && (bytes = ADy.A68()) != null) {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        return null;
    }

    private Bitmap A04(String str, int i, int i5) {
        Bitmap decodeStream;
        int A00;
        try {
            boolean A0C = A0C(i, i5);
            String A08 = A08(232, 7, 0);
            if (A0C) {
                decodeStream = AbstractC04266h.A02(str.substring(A08.length()), i, i5, this.A00);
            } else {
                decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring(A08.length())), null, null);
            }
            A00 = A00(str, decodeStream);
        } catch (IOException e2) {
            Log.e(A04, A08(105, 43, 38) + str + A08(0, 2, 17), e2);
        }
        if (C0705Ih.A0t(this.A00)) {
            if (A00 <= 0) {
                return null;
            }
            return decodeStream;
        }
        return decodeStream;
    }

    private Bitmap A05(String str, int i, int i5) throws IOException {
        URL urlObj = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Bitmap A01 = AbstractC04266h.A01(inputStream, i, i5);
        A0A(inputStream);
        return A01;
    }

    public static C04226d A06(C1115Ym c1115Ym) {
        if (A05 == null) {
            synchronized (C04226d.class) {
                if (A05 == null) {
                    A05 = new C04226d(c1115Ym);
                }
            }
        }
        return A05;
    }

    public static File A07(C04447f c04447f) {
        return c04447f.getCacheDir();
    }

    public static void A0A(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(Throwable th) {
        String A08 = A08(261, 5, 43);
        if (th != null) {
            this.A00.A07().A9a(A08, C8A.A1f, new C8B(th));
        } else {
            this.A00.A07().A9a(A08, C8A.A1f, new C8B(A08(77, 28, 125)));
        }
    }

    private boolean A0C(int i, int i5) {
        return i > 0 && i5 > 0 && C0705Ih.A1A(this.A00);
    }

    public final Bitmap A0D(C04196a c04196a) {
        return A01(this.A00, c04196a, c04196a.A04, c04196a.A03, c04196a.A01);
    }

    public final Bitmap A0E(C04447f c04447f, String str, int i, int i5, String str2) {
        C04196a c04196a = this.A01.get(str);
        return (!C04246f.A06(c04447f) || c04196a == null) ? A01(c04447f, new C04196a(str, i, i5, A08(270, 7, 97), A08(270, 7, 97)), i5, i, str2) : A01(c04447f, c04196a, i5, i, str2);
    }

    public final File A0F(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0G(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        return file.exists() ? file.getPath() : str;
    }
}
