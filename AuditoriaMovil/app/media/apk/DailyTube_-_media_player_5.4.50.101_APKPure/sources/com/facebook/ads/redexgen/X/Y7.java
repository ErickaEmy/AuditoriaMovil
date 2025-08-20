package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class Y7 implements AC {
    public static byte[] A04;
    public final int A00;
    public final long A01;
    public final Context A02;
    public final InterfaceC0538Bc<FrameworkMediaCrypto> A03;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{113, 80, 83, 84, 64, 89, 65, 103, 80, 91, 81, 80, 71, 80, 71, 70, 115, 84, 86, 65, 90, 71, 76, Byte.MAX_VALUE, 72, 72, 85, 72, 26, 83, 84, 73, 78, 91, 84, 78, 83, 91, 78, 83, 84, 93, 26, 124, 124, 87, 74, 95, 93, 26, 95, 66, 78, 95, 84, 73, 83, 85, 84, 60, 11, 11, 22, 11, 89, 16, 23, 10, 13, 24, 23, 13, 16, 24, 13, 16, 23, 30, 89, 63, 53, 56, 58, 89, 28, 1, 13, 28, 23, 10, 16, 22, 23, 59, 12, 12, 17, 12, 94, 23, 16, 13, 10, 31, 16, 10, 23, 31, 10, 23, 16, 25, 94, 49, 14, 11, 13, 94, 27, 6, 10, 27, 16, 13, 23, 17, 16, 24, 47, 47, 50, 47, 125, 52, 51, 46, 41, 60, 51, 41, 52, 60, 41, 52, 51, 58, 125, 11, 13, 100, 125, 56, 37, 41, 56, 51, 46, 52, 50, 51, 93, 126, 112, 117, 116, 117, 49, 87, 119, 124, 97, 116, 118, 80, 100, 117, 120, 126, 67, 116, Byte.MAX_VALUE, 117, 116, 99, 116, 99, 63, 81, 114, 124, 121, 120, 121, 61, 81, 116, Byte.MAX_VALUE, 123, 113, 124, 126, 92, 104, 121, 116, 114, 79, 120, 115, 121, 120, 111, 120, 111, 51, 45, 14, 0, 5, 4, 5, 65, 45, 8, 3, 14, 17, 20, 18, 32, 20, 5, 8, 14, 51, 4, 15, 5, 4, 19, 4, 19, 79, 54, 21, 27, 30, 31, 30, 90, 54, 19, 24, 12, 10, 2, 44, 19, 30, 31, 21, 40, 31, 20, 30, 31, 8, 31, 8, 84, 75, 71, 69, 6, 78, 73, 75, 77, 74, 71, 71, 67, 6, 73, 76, 91, 6, 65, 70, 92, 77, 90, 70, 73, 68, 6, 77, 80, 71, 88, 68, 73, 81, 77, 90, 26, 6, 77, 80, 92, 6, 78, 78, 69, 88, 77, 79, 6, 110, 78, 69, 88, 77, 79, 105, 93, 76, 65, 71, 122, 77, 70, 76, 77, 90, 77, 90, 84, 88, 90, 25, 81, 86, 84, 82, 85, 88, 88, 92, 25, 86, 83, 68, 25, 94, 89, 67, 82, 69, 89, 86, 91, 25, 82, 79, 88, 71, 91, 86, 78, 82, 69, 5, 25, 82, 79, 67, 25, 81, 91, 86, 84, 25, 123, 94, 85, 81, 91, 86, 84, 118, 66, 83, 94, 88, 101, 82, 89, 83, 82, 69, 82, 69, 87, 91, 89, 26, 82, 85, 87, 81, 86, 91, 91, 95, 26, 85, 80, 71, 26, 93, 90, 64, 81, 70, 90, 85, 88, 26, 81, 76, 91, 68, 88, 85, 77, 81, 70, 6, 26, 81, 76, 64, 26, 91, 68, 65, 71, 26, 120, 93, 86, 91, 68, 65, 71, 117, 65, 80, 93, 91, 102, 81, 90, 80, 81, 70, 81, 70, 60, 48, 50, 113, 57, 62, 60, 58, 61, 48, 48, 52, 113, 62, 59, 44, 113, 54, 49, 43, 58, 45, 49, 62, 51, 113, 58, 39, 48, 47, 51, 62, 38, 58, 45, 109, 113, 58, 39, 43, 113, 41, 47, 102, 113, 19, 54, 61, 41, 47, 39, 9, 54, 59, 58, 48, 13, 58, 49, 59, 58, 45, 58, 45};
    }

    public Y7(Context context) {
        this(context, 0);
    }

    public Y7(Context context, int i) {
        this(context, null, i, 5000L);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bc != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    @Deprecated
    public Y7(Context context, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc, int i, long j2) {
        this.A02 = context;
        this.A00 = i;
        this.A01 = j2;
        this.A03 = interfaceC0538Bc;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bc != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    private final void A02(Context context, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc, long j2, Handler handler, InterfaceC0701Id interfaceC0701Id, int extensionRendererIndex, ArrayList<Y5> arrayList) {
        Class<?> cls;
        Class<?> clazz;
        Class<?> clazz2;
        Class<?> clazz3;
        arrayList.add(new C3F(context, DM.A00, j2, interfaceC0538Bc, false, handler, interfaceC0701Id, 50));
        if (extensionRendererIndex == 0) {
            return;
        }
        int size = arrayList.size();
        if (extensionRendererIndex == 2) {
            size--;
        }
        try {
            try {
                cls = Class.forName(A00(469, 64, 11));
                clazz = Boolean.TYPE;
                clazz2 = Long.TYPE;
                clazz3 = Integer.TYPE;
            } catch (Exception e2) {
                e = e2;
            }
            try {
                arrayList.add(size, (Y5) cls.getConstructor(clazz, clazz2, Handler.class, InterfaceC0701Id.class, clazz3).newInstance(true, Long.valueOf(j2), handler, interfaceC0701Id, 50));
                Log.i(A00(0, 23, 97), A00(243, 27, 46));
            } catch (Exception e3) {
                e = e3;
                throw new RuntimeException(A00(127, 33, 9), e);
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bc != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    private final void A03(Context context, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc, InterfaceC0511Ab[] interfaceC0511AbArr, Handler handler, InterfaceC0519Aj interfaceC0519Aj, int i, ArrayList<Y5> arrayList) {
        int extensionRendererIndex;
        int i5;
        String A00 = A00(0, 23, 97);
        arrayList.add(new C3G(context, DM.A00, interfaceC0538Bc, false, handler, interfaceC0519Aj, AU.A00(context), interfaceC0511AbArr));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            extensionRendererIndex = size + 1;
            try {
                arrayList.add(size, (Y5) Class.forName(A00(403, 66, 96)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
                Log.i(A00, A00(215, 28, 53));
            } catch (ClassNotFoundException unused) {
                size = extensionRendererIndex;
                extensionRendererIndex = size;
                i5 = extensionRendererIndex + 1;
                arrayList.add(extensionRendererIndex, (Y5) Class.forName(A00(337, 66, 99)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
                Log.i(A00, A00(187, 28, 73));
                try {
                    try {
                        arrayList.add(i5, (Y5) Class.forName(A00(270, 67, 124)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
                        Log.i(A00, A00(160, 27, 69));
                    } catch (Exception e2) {
                        e = e2;
                        throw new RuntimeException(A00(23, 36, R.styleable.AppCompatTheme_textColorAlertDialogListItem), e);
                    }
                } catch (ClassNotFoundException unused2) {
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                throw new RuntimeException(A00(93, 34, 42), e);
            }
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e5) {
            e = e5;
        }
        try {
            i5 = extensionRendererIndex + 1;
        } catch (ClassNotFoundException unused4) {
        } catch (Exception e6) {
            e = e6;
        }
        try {
            try {
                arrayList.add(extensionRendererIndex, (Y5) Class.forName(A00(337, 66, 99)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
                Log.i(A00, A00(187, 28, 73));
            } catch (ClassNotFoundException unused5) {
                extensionRendererIndex = i5;
                i5 = extensionRendererIndex;
                arrayList.add(i5, (Y5) Class.forName(A00(270, 67, 124)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
                Log.i(A00, A00(160, 27, 69));
            } catch (Exception e8) {
                e = e8;
                throw new RuntimeException(A00(59, 34, 45), e);
            }
            arrayList.add(i5, (Y5) Class.forName(A00(270, 67, 124)).getConstructor(Handler.class, InterfaceC0519Aj.class, InterfaceC0511Ab[].class).newInstance(handler, interfaceC0519Aj, interfaceC0511AbArr));
            Log.i(A00, A00(160, 27, 69));
        } catch (Exception e9) {
            e = e9;
        }
    }

    private final void A04(Context context, DZ dz, Looper looper, int i, ArrayList<Y5> arrayList) {
        arrayList.add(new C6W(dz, looper));
    }

    private final void A05(Context context, InterfaceC0639Fr interfaceC0639Fr, Looper looper, int i, ArrayList<Y5> arrayList) {
        arrayList.add(new AnonymousClass63(interfaceC0639Fr, looper));
    }

    private final InterfaceC0511Ab[] A06() {
        return new InterfaceC0511Ab[0];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bc != com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto> */
    @Override // com.facebook.ads.redexgen.X.AC
    public final Y5[] A4l(Handler handler, InterfaceC0701Id interfaceC0701Id, InterfaceC0519Aj interfaceC0519Aj, InterfaceC0639Fr interfaceC0639Fr, DZ dz, InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc) {
        InterfaceC0538Bc<FrameworkMediaCrypto> interfaceC0538Bc2 = interfaceC0538Bc;
        if (interfaceC0538Bc2 == null) {
            interfaceC0538Bc2 = null;
        }
        ArrayList<Y5> arrayList = new ArrayList<>();
        A02(this.A02, interfaceC0538Bc2, this.A01, handler, interfaceC0701Id, this.A00, arrayList);
        A03(this.A02, interfaceC0538Bc2, A06(), handler, interfaceC0519Aj, this.A00, arrayList);
        A05(this.A02, interfaceC0639Fr, handler.getLooper(), this.A00, arrayList);
        A04(this.A02, dz, handler.getLooper(), this.A00, arrayList);
        return (Y5[]) arrayList.toArray(new Y5[arrayList.size()]);
    }
}
