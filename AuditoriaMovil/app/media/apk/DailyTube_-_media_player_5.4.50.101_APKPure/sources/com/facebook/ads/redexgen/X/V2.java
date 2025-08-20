package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.uv.v7.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
/* loaded from: assets/audience_network.dex */
public final class V2 implements com.facebook.ads.Ad, NativeAdBaseApi, Repairable, JX {
    public static C04216c A0k;
    public static byte[] A0l;
    public static String[] A0m = {"Bl7Z7O36thNMsAQG86cT5hXAswukL2TU", "w0l3kgVUfrf8f1EzcfbBJ9JqF1JIQyF1", "3FYeVZ4P9Hva0brxRfDXnSutu97odoaf", "TkemScCQ72wM3yeu7V5OcaIZTlgQuG0T", "aV5nfdXEnoj7uvLi", "brDFWAS69jf159nGVdOYVvf", "WGIwYSb5Wjcv", "W7skGFSknqdZoaqu210O1mF"};
    public static final String A0n;
    public static final WeakHashMap<View, WeakReference<V2>> A0o;
    public long A00;
    public Drawable A01;
    public View.OnTouchListener A02;
    public View A03;
    public View A04;
    public View A05;
    public View A06;
    public NativeAdLayout A07;
    public AnonymousClass12 A08;
    public C1224bA A09;
    public FO A0A;
    public C1194ag A0B;
    public C6i A0C;
    public C8T A0D;
    public JL A0E;
    public V4 A0F;
    public V1 A0G;
    public JR A0H;
    public JS A0I;
    public EnumC0726Jg A0J;
    public C0803Mi A0K;
    public C0827Ng A0L;
    public PB A0M;
    public C0896Px A0N;
    public RD A0O;
    public RD A0P;
    public RE A0Q;
    public RE A0R;
    public String A0S;
    public String A0T;
    public WeakReference<ZX> A0U;
    public WeakReference<RD> A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public C1234bK A0a;
    public final C04216c A0b;
    public final C1116Yn A0c;
    public final JO A0d;
    public final JZ A0e;
    public final C0775Lg A0f;
    public final String A0g;
    public final String A0h;
    public final List<View> A0i;
    public volatile boolean A0j;

    public static String A0W(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0l, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A0d() {
        A0l = new byte[]{86, -112, -100, -107, -108, -91, -84, -39, -41, -39, -92, -88, -41, -75, -77, -30, -78, -25, -75, -28, -29, -36, 12, -37, -39, -33, 9, 7, 12, 125, -96, 92, -86, -85, -80, 92, -88, -85, -99, -96, -95, -96, -67, -32, -48, -31, -23, -20, -24, -35, -16, -31, -100, -93, -95, -17, -93, -100, -27, -17, -100, -22, -21, -16, -100, -35, -100, -22, -35, -16, -27, -14, -31, -100, -35, -32, -105, -109, -110, -58, -75, -70, -74, -65, -76, -74, -97, -74, -59, -56, -64, -61, -68, -83, -56, -48, -45, -52, -53, -121, -37, -42, -121, -45, -42, -56, -53, -121, -76, -52, -53, -48, -56, -107, -96, -69, -61, -58, -65, -66, 122, -50, -55, 122, -55, -68, -50, -69, -61, -56, 122, -50, -65, -57, -54, -58, -69, -50, -65, 122, -93, -98, 122, -64, -52, -55, -57, 122, -68, -61, -66, 122, -54, -69, -45, -58, -55, -69, -66, 122, -127, Byte.MAX_VALUE, -51, -127, -79, -42, -36, -51, -38, -42, -55, -44, -120, -51, -38, -38, -41, -38, -106, 114, -47, -10, -2, -23, -12, -15, -20, -88, -5, -19, -4, -88, -9, -18, -88, -21, -12, -15, -21, -13, -23, -22, -12, -19, -88, -2, -15, -19, -1, -5, -73, -49, -50, -45, -53, -64, -45, -49, -31, -118, -48, -39, -36, -118, -45, -51, -39, -40, -118, -45, -35, -118, -45, -35, -118, -41, -45, -35, -35, -45, -40, -47, -104, -71, -47, -48, -43, -51, -62, -43, -47, -29, -116, -43, -33, -116, -39, -43, -33, -33, -43, -38, -45, -102, -117, -77, -79, -78, 94, -82, -80, -83, -76, -89, -94, -93, 94, -97, 94, -108, -89, -93, -75, -49, -30, -11, -22, -9, -26, -95, -62, -27, -95, -8, -30, -12, -95, -30, -19, -13, -26, -30, -27, -6, -95, -13, -26, -24, -22, -12, -11, -26, -13, -26, -27, -95, -8, -22, -11, -23, -95, -30, -95, -41, -22, -26, -8, -81, -95, -62, -10, -11, -16, -95, -10, -17, -13, -26, -24, -22, -12, -11, -26, -13, -22, -17, -24, -95, -30, -17, -27, -95, -15, -13, -16, -28, -26, -26, -27, -22, -17, -24, -81, -115, -96, -77, -88, -75, -92, 95, -96, -93, 95, -93, -92, -78, -77, -79, -82, -72, -92, -93, -40, -21, -2, -13, 0, -17, -86, -21, -18, -86, -10, -7, -21, -18, -86, -4, -17, -5, -1, -17, -3, -2, -17, -18, -115, -96, -100, -82, 87, -104, -93, -87, -100, -104, -101, -80, 87, -87, -100, -98, -96, -86, -85, -100, -87, -100, -101, 87, -82, -96, -85, -97, 87, -104, 87, -123, -104, -85, -96, -83, -100, 120, -101, 101, 87, 120, -84, -85, -90, 87, -84, -91, -87, -100, -98, -96, -86, -85, -100, -87, -96, -91, -98, 87, -104, -91, -101, 87, -89, -87, -90, -102, -100, -100, -101, -96, -91, -98, 101, -58, -39, -43, -25, -112, -34, -33, -28, -112, -30, -43, -41, -39, -29, -28, -43, -30, -43, -44, -112, -25, -39, -28, -40, -112, -28, -40, -39, -29, -112, -66, -47, -28, -39, -26, -43, -79, -44, -104, -101, 87, -92, -100, -101, -96, -104, 87, -85, -80, -89, -100, 87, -96, -86, 87, -91, -90, -85, 87, -86, -84, -89, -89, -90, -87, -85, -100, -101, 101, -116, -101, -108, -109, -108, -94, -93, -95, -98, -88, -94, -91, -105, -102, 119, -102, 7, 10, -4, -1, -36, -1, -61, -60, -69, -2, -4, 7, 7, 0, -1, -69, 8, 10, 13, 0, -69, 15, 3, -4, 9, -69, 10, 9, -2, 0, -17, -30, -11, -22, -9, -26};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0f(View view, View view2, List<View> list, boolean z2) {
        V1 v1;
        if (!A0q()) {
            this.A0c.A0E().AEU();
        }
        if (view == null) {
            String A0W = A0W(264, 19, 22);
            if (!A0q()) {
                this.A0c.A0E().AET(A0W);
            }
            throw new IllegalArgumentException(A0W);
        } else if (list == null || list.size() == 0) {
            String A0W2 = A0W(180, 30, 96);
            if (!A0q()) {
                this.A0c.A0E().AET(A0W2);
            }
            throw new IllegalArgumentException(A0W2);
        } else {
            C1234bK A0C = A0C();
            if (A0C == null) {
                String A0W3 = A0W(29, 13, 20);
                if (!A0q()) {
                    this.A0c.A0E().AET(A0W3);
                }
                Log.e(A0n, A0W3);
                C0722Jb c0722Jb = new C0722Jb(AdErrorType.NATIVE_AD_IS_NOT_LOADED, A0W3);
                A11().A0E().A2m(C0774Lf.A01(this.A00), c0722Jb.A03().getErrorCode(), c0722Jb.A04());
                if (!C0705Ih.A2F(this.A0c) || (v1 = this.A0G) == null) {
                    return;
                }
                v1.ABR(c0722Jb);
                return;
            }
            String str = this.A0T;
            boolean z3 = view instanceof FrameLayout;
            String[] strArr = A0m;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[0] = "EctJGKY0XxsuqG0UQd3u1zsk6i1LiKEB";
            strArr2[2] = "xfmrtxxFdZMJNwdY4ICwqytBKlocc6OO";
            if (z3 && str != null) {
                A0g((FrameLayout) view, str);
            }
            NativeAdLayout nativeAdLayout = this.A07;
            if (nativeAdLayout != null) {
                ((ZG) nativeAdLayout.getNativeAdLayoutApi()).A02();
            }
            ZX zx = this.A0U.get();
            if (zx != null && A0C.A08() == 1) {
                zx.A03(EnumC0791Lw.AN_INFO_ICON);
            }
            if (view2 == null) {
                if (this.A0J == EnumC0726Jg.A05) {
                    AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
                    String A0W4 = A0W(243, 21, 68);
                    C0722Jb c0722Jb2 = new C0722Jb(adErrorType, A0W4);
                    A11().A0E().A2m(C0774Lf.A01(this.A00), c0722Jb2.A03().getErrorCode(), c0722Jb2.A04());
                    V1 v12 = this.A0G;
                    if (v12 != null) {
                        v12.ABR(c0722Jb2);
                    }
                    if (AdInternalSettings.isDebugBuild()) {
                        Log.e(A0n, A0W4);
                        return;
                    }
                    return;
                }
                AdErrorType adErrorType2 = AdErrorType.NO_MEDIAVIEW_IN_NATIVEBANNERAD;
                String A0W5 = A0W(210, 33, 66);
                C0722Jb c0722Jb3 = new C0722Jb(adErrorType2, A0W5);
                A11().A0E().A2m(C0774Lf.A01(this.A00), c0722Jb3.A03().getErrorCode(), c0722Jb3.A04());
                V1 v13 = this.A0G;
                if (v13 != null) {
                    v13.ABR(c0722Jb3);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    Log.e(A0n, A0W5);
                    return;
                }
                return;
            }
            boolean z4 = (view2 instanceof AdNativeComponentView) && ((AdNativeComponentView) view2).getAdContentsView() != null;
            boolean z5 = z2 && (view2 instanceof ImageView);
            if (!z4 && !z5) {
                if (this.A0G != null) {
                    C0722Jb c0722Jb4 = new C0722Jb(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0W(519, 31, 15));
                    A11().A0E().A2m(C0774Lf.A01(this.A00), c0722Jb4.A03().getErrorCode(), c0722Jb4.A04());
                    this.A0G.ABR(c0722Jb4);
                    return;
                }
                return;
            }
            if (this.A04 != null) {
                Log.w(A0n, A0W(283, 80, 89));
                String[] strArr3 = A0m;
                if (strArr3[7].length() != strArr3[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0m;
                strArr4[7] = "Yitqb4l5O5wHhToyiUZG328";
                strArr4[5] = "n4uNZUYEyoiQJdMJgH58rRy";
                unregisterView();
            }
            WeakHashMap<View, WeakReference<V2>> weakHashMap = A0o;
            if (weakHashMap.containsKey(view) && weakHashMap.get(view).get() != null) {
                Log.w(A0n, A0W(406, 75, 15));
                weakHashMap.get(view).get().unregisterView();
            }
            this.A0F = new V4(this, this.A0c, null);
            this.A04 = view;
            this.A06 = view2;
            if (view instanceof ViewGroup) {
                C0803Mi c0803Mi = new C0803Mi(this.A0c, new V8(this));
                this.A0K = c0803Mi;
                ((ViewGroup) view).addView(c0803Mi);
            }
            if (A0C.A0S()) {
                this.A0O = new V7(this);
                RE re = new RE(view, 1, new WeakReference(this.A0O), this.A0c);
                this.A0Q = re;
                re.A0Y(false);
                this.A0Q.A0X(A0C.A09());
                this.A0Q.A0U();
                this.A0c.A0E().AAT();
            }
            ArrayList<View> arrayList = new ArrayList(list);
            View view3 = this.A05;
            if (view3 != null) {
                arrayList.add(view3);
            }
            for (View view4 : arrayList) {
                A1K(view4);
            }
            int A00 = A00();
            this.A0P = new V6(this, view2, z5, A0C);
            if (view2 instanceof AdNativeComponentView) {
                this.A03 = ((AdNativeComponentView) view2).getAdContentsView();
            } else {
                this.A03 = view2;
            }
            if (C0705Ih.A1W(this.A0c)) {
                String A1B = A1B();
                JE A0A = A11().A0A();
                View view5 = this.A03;
                if (A1B == null) {
                    A1B = A0W(0, 0, 21);
                }
                A0A.AGw(view5, A1B, view5 instanceof QJ, true);
            }
            RE re2 = new RE(this.A03, A00, A03(), true, new WeakReference(this.A0P), this.A0c);
            this.A0R = re2;
            re2.A0Y(true ^ A0q());
            this.A0R.A0W(A01());
            this.A0R.A0X(A02());
            View view6 = this.A03;
            if (view6 instanceof NW) {
                ((NW) view6).A06(this.A0R);
            }
            C1224bA c1224bA = new C1224bA(this.A0c, new V3(this, null), this.A0R, this.A0a);
            this.A09 = c1224bA;
            c1224bA.A0D(arrayList);
            A0o.put(view, new WeakReference<>(this));
            if (Build.VERSION.SDK_INT < 18 || !C0705Ih.A11(this.A0c)) {
                return;
            }
            C0827Ng c0827Ng = new C0827Ng();
            this.A0L = c0827Ng;
            c0827Ng.A0C(this.A0g);
            this.A0L.A0B(this.A0c.getPackageName());
            this.A0L.A0A(this.A0R);
            C1234bK c1234bK = this.A0a;
            if (c1234bK != null && c1234bK.A0E().A03() > 0) {
                AnonymousClass14 A0E = this.A0a.A0E();
                this.A0L.A08(A0E.A03(), A0E.A04());
            }
            C8T c8t = this.A0D;
            if (c8t != null) {
                this.A0L.A09(c8t.A0C());
            } else {
                FO fo = this.A0A;
                if (fo != null && fo.A0H() != null) {
                    this.A0L.A09(this.A0A.A0H().A0C());
                }
            }
            View view7 = this.A04;
            String[] strArr5 = A0m;
            if (strArr5[4].length() != strArr5[6].length()) {
                String[] strArr6 = A0m;
                strArr6[4] = "DFdj5aRKmThGOYGM";
                strArr6[6] = "4rU7VADNdisg";
                view7.getOverlay().add(this.A0L);
                return;
            }
            String[] strArr7 = A0m;
            strArr7[7] = "HovrQjOKGOU1glve9p8eAJs";
            strArr7[5] = "lnqkcQfVF9X2NaZpGo2NogE";
            view7.getOverlay().add(this.A0L);
        }
    }

    static {
        A0d();
        A0n = V2.class.getSimpleName();
        A0o = new WeakHashMap<>();
    }

    public V2(Context context, String str, JO jo, boolean z2) {
        this.A0h = UUID.randomUUID().toString();
        this.A0J = EnumC0726Jg.A05;
        this.A0E = JL.A04;
        this.A08 = AnonymousClass12.A03;
        this.A0U = new WeakReference<>(null);
        this.A0i = new ArrayList();
        this.A0f = new C0775Lg();
        this.A0Z = false;
        this.A0Y = false;
        this.A00 = -1L;
        if (context instanceof C1116Yn) {
            this.A0c = (C1116Yn) context;
        } else if (!z2) {
            this.A0c = C03955c.A04(context);
        } else {
            this.A0c = C03955c.A03(context);
        }
        this.A0c.A0L(this);
        this.A0g = str;
        this.A0d = jo;
        C04216c c04216c = A0k;
        if (c04216c != null) {
            this.A0b = c04216c;
        } else {
            this.A0b = new C04216c(this.A0c);
        }
        this.A05 = new View(context);
        this.A0e = new JZ(this.A0c, this);
    }

    public V2(V2 v2) {
        this((Context) v2.A0c, (String) null, v2.A0d, true);
        this.A0D = v2.A0D;
        this.A0a = v2.A0a;
        this.A0B = v2.A0B;
        this.A0j = true;
        this.A05 = new View(this.A0c);
    }

    public V2(C1116Yn c1116Yn, C1234bK c1234bK, C8T c8t, JO jo) {
        this((Context) c1116Yn, (String) null, jo, true);
        this.A0a = c1234bK;
        this.A0D = c8t;
        this.A0j = true;
        this.A05 = new View(c1116Yn);
    }

    public V2(C1116Yn c1116Yn, C1234bK c1234bK, C8T c8t, JO jo, C1194ag c1194ag) {
        this(c1116Yn, c1234bK, c8t, jo);
        this.A0B = c1194ag;
    }

    private int A00() {
        C8T c8t = this.A0D;
        if (c8t != null) {
            return c8t.A04();
        }
        FO fo = this.A0A;
        if (fo == null || fo.A0H() == null) {
            return 1;
        }
        return this.A0A.A0H().A04();
    }

    private int A01() {
        C8T c8t = this.A0D;
        if (c8t != null) {
            return c8t.A07();
        }
        C1234bK c1234bK = this.A0a;
        if (c1234bK != null) {
            int A0C = c1234bK.A0C();
            String[] strArr = A0m;
            if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                String[] strArr2 = A0m;
                strArr2[7] = "EUscbuPuA5cZxxPx7y6ncGc";
                strArr2[5] = "07NrZ6juCFttxvE5hiFlF8c";
                return A0C;
            }
            throw new RuntimeException();
        }
        FO fo = this.A0A;
        if (fo != null && fo.A0H() != null) {
            return this.A0A.A0H().A07();
        }
        return 0;
    }

    private int A02() {
        C8T c8t = this.A0D;
        if (c8t != null) {
            return c8t.A08();
        }
        C1234bK c1234bK = this.A0a;
        if (c1234bK != null) {
            int A0D = c1234bK.A0D();
            String[] strArr = A0m;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0m;
                strArr2[1] = "wlXrbCoONy6aNPfJSLZ4JGG9g8lWOQWJ";
                strArr2[3] = "zMDzXw8vWIk5v34E7N5RdIcOKoPIh5je";
                return A0D;
            }
            throw new RuntimeException();
        }
        FO fo = this.A0A;
        String[] strArr3 = A0m;
        if (strArr3[4].length() != strArr3[6].length()) {
            String[] strArr4 = A0m;
            strArr4[7] = "IJhE7OuQr9AUmHg0gZAU0NE";
            strArr4[5] = "Tpbr9nnLmrgR8Cas3OKWnYo";
            if (fo == null) {
                return 1000;
            }
        } else {
            String[] strArr5 = A0m;
            strArr5[0] = "x7i9CQzVOJPdqJX1dHOWNRL80PPtBuUS";
            strArr5[2] = "xh5QtfSCbDAINUU48h4MV8p0ljd4aaCa";
            if (fo == null) {
                return 1000;
            }
        }
        if (fo.A0H() != null) {
            return this.A0A.A0H().A08();
        }
        return 1000;
    }

    private int A03() {
        C8T c8t = this.A0D;
        if (c8t != null) {
            return c8t.A09();
        }
        FO fo = this.A0A;
        if (fo == null || fo.A0H() == null) {
            return 0;
        }
        return this.A0A.A0H().A09();
    }

    public static Drawable A05(C1116Yn c1116Yn, Bitmap bitmap, boolean z2, String str) {
        BitmapDrawable A00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c1116Yn.getResources(), bitmap);
        if (!z2 || (A00 = AbstractC0895Pw.A00(c1116Yn, str)) == null) {
            return bitmapDrawable;
        }
        Drawable iconViewDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, A00});
        return iconViewDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C0723Jc {
        EnumC0726Jg A00 = C0731Jl.A00(str2);
        if (A00 != null) {
            EnumC0726Jg enumC0726Jg = EnumC0726Jg.A04;
            String[] strArr = A0m;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[0] = "9sjWaS9CbZxjWOFrlYfgckD2h0ahWze6";
            strArr2[2] = "CgLfFBC4KJYZcdRIWMiGUMQeYT9XpqO1";
            if (A00 == enumC0726Jg) {
                return new NativeBannerAd(context, str);
            }
            EnumC0726Jg template = EnumC0726Jg.A05;
            if (A00 == template) {
                return new NativeAd(context, str);
            }
            throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(42, 34, 84), A00));
        }
        throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(R.styleable.AppCompatTheme_tooltipForegroundColor, 50, 50), str2));
    }

    private final C1234bK A0C() {
        C1234bK c1234bK = this.A0a;
        if (c1234bK != null && c1234bK.A0R()) {
            return c1234bK;
        }
        return null;
    }

    private AnonymousClass14 A0F() {
        return A0G(false);
    }

    private AnonymousClass14 A0G(boolean z2) {
        C1234bK c1234bK = this.A0a;
        if (c1234bK != null && c1234bK.A0R()) {
            if (z2) {
                this.A0a.A0I();
            }
            C1234bK c1234bK2 = this.A0a;
            String[] strArr = A0m;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0m;
                strArr2[7] = "bGIdjP48JCmqHZjd8yMcvy0";
                strArr2[5] = "TixE3qv3ULKos9kbBUakVg1";
                return c1234bK2.A0E();
            }
            throw new RuntimeException();
        }
        return new AnonymousClass14();
    }

    public static V5 A0K() {
        return new V5();
    }

    public static V2 A0L(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (V2) ((C5L) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (V2) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0M */
    public final JP getAdChoicesIcon() {
        return A0F().A0E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0O */
    public final JQ getAdStarRating() {
        return A0F().A0H();
    }

    private AdPlacementType A0R() {
        if (this.A0J == EnumC0726Jg.A05) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0Z() {
        for (View v2 : this.A0i) {
            v2.setOnClickListener(null);
            v2.setOnTouchListener(null);
            v2.setOnLongClickListener(null);
        }
        this.A0i.clear();
    }

    private void A0a() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            C0764Kv.A0M(new C0764Kv(), this.A0c, AbstractC0767Ky.A00(getAdChoicesLinkUrl()), A1B());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0b() {
        this.A0f.A05();
        this.A0e.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c() {
        RE re = this.A0Q;
        if (re != null) {
            re.A0V();
            this.A0c.A0E().AAU();
            this.A0Q = null;
        }
    }

    public static void A0e(Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(null);
        } else {
            imageView.setBackgroundDrawable(null);
        }
    }

    private void A0g(FrameLayout frameLayout, String str) {
        View view = this.A0N;
        if (view != null) {
            frameLayout.removeView(view);
        }
        C0896Px A01 = AbstractC0895Pw.A01(C03955c.A03(this.A0c), str);
        this.A0N = A01;
        if (A01 != null) {
            frameLayout.addView(A01, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0N);
        }
    }

    private void A0h(C1234bK c1234bK, boolean z2) {
        if (c1234bK == null) {
            return;
        }
        boolean equals = this.A0E.equals(JL.A04);
        String A0W = A0W(596, 6, 89);
        if (equals) {
            AnonymousClass14 A0E = c1234bK.A0E();
            String clientToken = c1234bK.A6T();
            if (!TextUtils.isEmpty(clientToken)) {
                this.A0b.A0d(new JA(clientToken, this.A0c.A09()));
            }
            if (A0E.A0G() != null) {
                C04196a c04196a = new C04196a(A0E.A0G().getUrl(), A0E.A0G().getHeight(), A0E.A0G().getWidth(), c1234bK.A0G(), A0W(596, 6, 89));
                c04196a.A00 = this.A0C;
                this.A0b.A0V();
                this.A0b.A0b(c04196a);
            }
            if (!this.A0J.equals(EnumC0726Jg.A04)) {
                if (A0E.A0F() != null) {
                    this.A0b.A0b(new C04196a(A0E.A0F().getUrl(), A0E.A0F().getHeight(), A0E.A0F().getWidth(), c1234bK.A0G(), A0W(596, 6, 89)));
                }
                List<V2> A0H = c1234bK.A0H();
                String[] strArr = A0m;
                if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0m;
                strArr2[1] = "BiVeVWtUTguxpSjeMqAkCwQXeKWOVTz4";
                strArr2[3] = "8sdR9nWPZ664Gt9BvBocaDJi5It1hBkX";
                if (A0H != null) {
                    for (V2 v2 : c1234bK.A0H()) {
                        if (v2.getAdCoverImage() != null) {
                            this.A0b.A0b(new C04196a(v2.getAdCoverImage().getUrl(), v2.getAdCoverImage().getHeight(), v2.getAdCoverImage().getWidth(), c1234bK.A0G(), A0W(596, 6, 89)));
                        }
                    }
                }
                String A0d = A0E.A0d();
                if (!TextUtils.isEmpty(A0d)) {
                    this.A0b.A0a(new C6Y(A0d, c1234bK.A0G(), A0W(596, 6, 89), A0E.A0A()));
                }
            }
            AbstractC1219b5 A0D = A0E.A0D();
            if (A0D != null && A0D.A0m()) {
                C6Y c6y = new C6Y(A0D.A0M(), A0D.A0S(), A0W);
                c6y.A04 = true;
                c6y.A03 = A0W(0, 5, 0);
                this.A0b.A0X(c6y);
            }
        }
        this.A0b.A0W(new V9(this, c1234bK, z2), new C6V(c1234bK.A0G(), A0W));
    }

    private void A0i(AnonymousClass15 anonymousClass15) {
        C1234bK c1234bK = this.A0a;
        if (c1234bK == null) {
            return;
        }
        c1234bK.A0K(anonymousClass15);
    }

    public static void A0j(NativeAdImageApi nativeAdImageApi, ImageView imageView, C1116Yn c1116Yn) {
        if (nativeAdImageApi != null && imageView != null) {
            new AsyncTaskC0993Tq(imageView, c1116Yn).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0m(V1 v1) {
        this.A0G = v1;
    }

    private final void A0n(String str) {
        this.A0S = str;
    }

    private void A0o(List<View> list, View view) {
        JO jo = this.A0d;
        if (jo != null && jo.AGK(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                String[] strArr = A0m;
                String str = strArr[7];
                String str2 = strArr[5];
                int i5 = str.length();
                if (i5 != str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0m;
                strArr2[1] = "SQxDsveS3BVeMl0nUnJayKxDlwKiSRwM";
                strArr2[3] = "CPUPH8uU8pe6dd8URnD7AGDEQ4lKFlLs";
                A0o(list, childAt);
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0p() {
        return A18() == JU.A05 || A18() == JU.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0q() {
        return A0F().A0h();
    }

    public final long A0x() {
        return this.A00;
    }

    public final C1234bK A0y() {
        return this.A0a;
    }

    public final AbstractC1219b5 A0z() {
        return A0F().A0D();
    }

    public final C04216c A10() {
        return this.A0b;
    }

    public final C1116Yn A11() {
        return this.A0c;
    }

    public final V4 A12() {
        return this.A0F;
    }

    /* renamed from: A13 */
    public final JP getAdCoverImage() {
        return A0F().A0F();
    }

    /* renamed from: A14 */
    public final JP getAdIcon() {
        return A0F().A0G();
    }

    public final V1 A15() {
        return this.A0G;
    }

    public final JR A16() {
        return this.A0H;
    }

    public final JS A17() {
        return this.A0I;
    }

    public final JU A18() {
        return A0F().A0I();
    }

    public final C0775Lg A19() {
        return this.A0f;
    }

    public final RE A1A() {
        return this.A0R;
    }

    public final String A1B() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A6T();
    }

    public final String A1C() {
        return this.A0T;
    }

    public final String A1D() {
        return A0G(true).A0O();
    }

    public final String A1E() {
        return A0G(true).A0P();
    }

    public final String A1F() {
        return A0F().A0c();
    }

    public final String A1G() {
        C1234bK c1234bK = this.A0a;
        if (c1234bK == null || TextUtils.isEmpty(c1234bK.A0E().A0d())) {
            return null;
        }
        return this.A0b.A0S(this.A0a.A0E().A0d());
    }

    public final List<V2> A1H() {
        if (this.A0a == null || !isAdLoaded()) {
            return null;
        }
        return this.A0a.A0H();
    }

    public final void A1I() {
        if (!C2T.A00(this.A0c.A01()).A0O(this.A0c, false)) {
            A0a();
            return;
        }
        C1116Yn c1116Yn = this.A0c;
        AbstractC0809Mo A01 = AbstractC0810Mp.A01(c1116Yn, c1116Yn.A09(), A1B(), this.A07);
        if (A01 == null) {
            A0a();
            return;
        }
        ((ZG) this.A07.getNativeAdLayoutApi()).A03(A01);
        A01.A0K();
    }

    public final void A1J(Drawable drawable) {
        this.A01 = drawable;
        A1c(drawable != null, true);
        String[] strArr = A0m;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0m;
        strArr2[4] = "Q96JEqttX0oIb74l";
        strArr2[6] = "mqYIcYUMJzEb";
    }

    public final void A1K(View view) {
        this.A0i.add(view);
        view.setOnClickListener(this.A0F);
        view.setOnTouchListener(this.A0F);
        if (Build.VERSION.SDK_INT >= 18) {
            boolean A11 = C0705Ih.A11(view.getContext());
            String[] strArr = A0m;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[4] = "GeTsVetQiODT9yUx";
            strArr2[6] = "UPeG8QvAHkrx";
            if (A11) {
                view.setOnLongClickListener(this.A0F);
            }
        }
    }

    public final void A1L(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0o(arrayList, view);
        A0f(view, imageView, arrayList, true);
    }

    public final void A1M(View view, ImageView imageView, List<View> clickableViews) {
        A0f(view, imageView, clickableViews, true);
    }

    public final void A1N(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0o(arrayList, view);
        A0f(view, adNativeComponentView, arrayList, false);
    }

    public final void A1O(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews) {
        A0f(view, adNativeComponentView, clickableViews, false);
    }

    public final void A1P(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Y = true;
        }
    }

    public final void A1Q(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Z = true;
        }
    }

    public final void A1R(NativeAdBase nativeAdBase, NativeAdListener nativeAdListener) {
        if (nativeAdListener == null) {
            return;
        }
        A0m(new C0545Bj(nativeAdListener, nativeAdBase));
    }

    public final void A1S(NativeAdLayout nativeAdLayout) {
        this.A07 = nativeAdLayout;
    }

    public final void A1T(C1234bK c1234bK) {
        A0h(c1234bK, true);
        if (this.A0G != null) {
            List<V2> A0H = c1234bK.A0H();
            String[] strArr = A0m;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[0] = "OfB2JsewzcYgCxMvn97l0AOaUV28WOmd";
            strArr2[2] = "fN7XzjPm8qHCAEGwTiZWrbsVWAwnjwvJ";
            if (A0H != null) {
                VB vb = new VB(this);
                for (V2 v2 : c1234bK.A0H()) {
                    v2.A0i(vb);
                }
            }
        }
    }

    public final void A1U(ZX zx) {
        this.A0U = new WeakReference<>(zx);
    }

    public final void A1V(JL jl, String str, C6i c6i) {
        if (str == null) {
            this.A0c.A0E().A2p();
        } else {
            this.A0c.A0E().A2o();
        }
        this.A00 = System.currentTimeMillis();
        if (this.A0j) {
            AdSettings.IntegrationErrorMode A00 = AbstractC03141x.A00(this.A0c);
            String A0W = A0W(566, 30, R.styleable.AppCompatTheme_tooltipFrameBackground);
            AdSettings.IntegrationErrorMode integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
            if (!integrationErrorMode.equals(A00)) {
                C0722Jb c0722Jb = new C0722Jb(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0W(566, 30, R.styleable.AppCompatTheme_tooltipFrameBackground));
                A11().A0E().A2m(C0774Lf.A01(this.A00), c0722Jb.A03().getErrorCode(), c0722Jb.A04());
                V1 v1 = this.A0G;
                if (v1 != null) {
                    v1.ABR(c0722Jb);
                } else {
                    Log.e(A0W(76, 17, 41), A0W);
                }
                C8B c8b = new C8B(A0W);
                A11().A07().A9a(A0W(550, 3, 3), C8A.A0c, c8b);
            } else {
                throw new AnonymousClass22(A0W);
            }
        }
        this.A0j = true;
        this.A0E = jl;
        if (jl.equals(JL.A05)) {
            this.A08 = AnonymousClass12.A05;
        }
        this.A0C = c6i;
        C03111u c03111u = new C03111u(this.A0g, this.A0J, A0R(), null, 1, new C1187aZ());
        c03111u.A05(jl);
        c03111u.A06(this.A0S);
        c03111u.A07(this.A0T);
        FO fo = new FO(this.A0c, c03111u);
        this.A0A = fo;
        fo.A0P(new VC(this));
        this.A0A.A0T(str);
    }

    public final void A1W(JR jr) {
        this.A0H = jr;
    }

    public final void A1X(JS js) {
        this.A0I = js;
    }

    public final void A1Y(EnumC0726Jg enumC0726Jg) {
        if (!A0q()) {
            if (EnumC0726Jg.A04.equals(enumC0726Jg)) {
                C1116Yn c1116Yn = this.A0c;
                String[] strArr = A0m;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0m;
                strArr2[7] = "er71GFUENUkH6mVEmd80tsw";
                strArr2[5] = "eRFgtOOg0hnVr16Te1PNaNs";
                c1116Yn.A0E().A2s(AdPlacementType.NATIVE_BANNER.toString(), this.A0g);
            } else {
                this.A0c.A0E().A2s(AdPlacementType.NATIVE.toString(), this.A0g);
            }
        }
        this.A0J = enumC0726Jg;
    }

    public final void A1Z(RD rd) {
        this.A0V = new WeakReference<>(rd);
    }

    public final void A1a(boolean z2) {
        this.A0W = z2;
    }

    public final void A1b(boolean z2) {
        this.A0X = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r3 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        r2 = r3.A0G();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e4, code lost:
        if (r3 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e7, code lost:
        r2 = A0W(0, 0, 21);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1c(boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V2.A1c(boolean, boolean):void");
    }

    public final boolean A1d() {
        return this.A07 == null;
    }

    @Override // com.facebook.ads.redexgen.X.JX
    public final int A6c() {
        AdNativeComponentView adNativeComponentView = this.A06;
        if (adNativeComponentView instanceof AdNativeComponentView) {
            View videoView = adNativeComponentView.getAdContentsView();
            if (videoView instanceof QJ) {
                return ((QJ) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new JV(this, nativeAdBase);
    }

    public final void destroy() {
        AbstractC0735Jp.A05(A0W(553, 7, 7), A0W(363, 19, 23), A0W(5, 8, 76));
        if (C0705Ih.A1W(this.A0c)) {
            A11().A0A().AGk(this.A03);
        }
        if (!A0q()) {
            this.A0c.A0E().A2t();
        }
        FO fo = this.A0A;
        if (fo != null) {
            fo.A0V(true);
            this.A0A = null;
        }
    }

    public final void downloadMedia() {
        if (this.A0E.equals(JL.A05)) {
            this.A08 = AnonymousClass12.A04;
        }
        this.A0E = JL.A04;
        A0h(this.A0a, false);
    }

    public final String getAdBodyText() {
        return A0G(true).A0J();
    }

    public final String getAdCallToAction() {
        return A0G(true).A0X();
    }

    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        JP adChoicesIcon = getAdChoicesIcon();
        String[] strArr = A0m;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0m;
            strArr2[7] = "MRTmAh7YnfwjJHGdoro5GGF";
            strArr2[5] = "5NAjexdbITBZf7E7VHPXfXw";
            return adChoicesIcon.getUrl();
        }
        throw new RuntimeException();
    }

    public final String getAdChoicesLinkUrl() {
        return A0F().A0K();
    }

    public final String getAdChoicesText() {
        return A0F().A0L();
    }

    public final String getAdHeadline() {
        return A0G(true).A0M();
    }

    public final String getAdLinkDescription() {
        return A0G(true).A0N();
    }

    public final String getAdSocialContext() {
        return A0G(true).A0R();
    }

    public final String getAdTranslation() {
        return A0G(true).A0U();
    }

    public final String getAdUntrimmedBodyText() {
        return A0G(true).A0V();
    }

    public final String getAdvertiserName() {
        return A0G(true).A0W();
    }

    public final float getAspectRatio() {
        C1234bK c1234bK = this.A0a;
        if (c1234bK != null) {
            AnonymousClass14 A0E = c1234bK.A0E();
            String[] strArr = A0m;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[1] = "Gk0JtmCCXYpL8dPDyrRdSPBqQO7pSw2M";
            strArr2[3] = "hZFl2ZrFl9W40ZKmdwMt57qcTxbjzHrP";
            JP nativeAdImage = A0E.A0F();
            if (nativeAdImage != null) {
                int width = nativeAdImage.getWidth();
                int height = nativeAdImage.getHeight();
                if (height > 0) {
                    return width / height;
                }
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        String str = this.A0h;
        String[] strArr = A0m;
        if (strArr[4].length() != strArr[6].length()) {
            String[] strArr2 = A0m;
            strArr2[7] = "iawtn5ImZtHDfKUJHK1ePg9";
            strArr2[5] = "61vZsTsWUXSHOR043CjOsZn";
            return str;
        }
        throw new RuntimeException();
    }

    public final String getPlacementId() {
        return this.A0g;
    }

    public final Drawable getPreloadedIconViewDrawable() {
        JP A0G;
        Bitmap A0M;
        C1234bK adapter = this.A0a;
        if (adapter != null && (A0G = A0F().A0G()) != null && (A0M = this.A0b.A0M(A0G.getUrl())) != null) {
            C1116Yn A11 = A11();
            boolean A1d = A1d();
            String[] strArr = A0m;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0m;
                strArr2[4] = "5rXv1LFjMRKkpcU7";
                strArr2[6] = "SFgDKFOuseBk";
                return A05(A11, A0M, A1d, A1C());
            }
            throw new RuntimeException();
        }
        return null;
    }

    public final String getPromotedTranslation() {
        return A0G(true).A0Q();
    }

    public final String getSponsoredTranslation() {
        return A0G(true).A0S();
    }

    public final boolean hasCallToAction() {
        C1234bK c1234bK = this.A0a;
        return c1234bK != null && c1234bK.A0Q();
    }

    public final boolean isAdInvalidated() {
        boolean z2 = true;
        FO fo = this.A0A;
        if (fo != null) {
            z2 = fo.A0W();
        } else {
            C1194ag c1194ag = this.A0B;
            String[] strArr = A0m;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0m;
            strArr2[7] = "v5uFzvuQ32LyebguaenlI2Y";
            strArr2[5] = "nsJGpwd0QPZOfVeZMyNRGWR";
            if (c1194ag != null) {
                z2 = c1194ag.A0A();
            }
        }
        this.A0c.A0E().A4s(z2);
        return z2;
    }

    public final boolean isAdLoaded() {
        C1234bK c1234bK = this.A0a;
        return c1234bK != null && c1234bK.A0R();
    }

    public final void loadAd() {
        AbstractC0735Jp.A05(A0W(560, 6, 14), A0W(382, 24, 98), A0W(13, 8, 89));
        A1V(JL.A00(NativeAdBase.MediaCacheFlag.ALL), null, new C6i(false, -1, -1));
    }

    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        AbstractC0735Jp.A05(A0W(560, 6, 14), A0W(382, 24, 98), A0W(21, 8, 126));
        ((JV) nativeLoadAdConfig).A00();
    }

    public final void onCtaBroadcast() {
        View view = this.A05;
        if (view != null) {
            view.performClick();
        }
    }

    public final void repair(Throwable th) {
        View view = this.A04;
        if (view != null) {
            view.post(new VD(this));
        }
        String str = A0W(164, 16, 64) + LW.A03(this.A0c, th);
        A11().A0E().A2m(C0774Lf.A01(this.A00), 2001, str);
        V1 v1 = this.A0G;
        if (v1 != null) {
            v1.ABR(new C0722Jb(2001, str));
        }
    }

    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0n(extraHints.getHints());
        this.A0T = extraHints.getMediationData();
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (com.facebook.ads.redexgen.X.C0705Ih.A1W(r4) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        A11().A0A().AGk(r7.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
        r4 = com.facebook.ads.redexgen.X.V2.A0o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (r4.containsKey(r7.A04) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (r4.get(r7.A04).get() != r7) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
        r5 = r7.A04;
        r6 = r5 instanceof android.view.ViewGroup;
        r2 = com.facebook.ads.redexgen.X.V2.A0m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
        if (r2[4].length() == r2[6].length()) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
        r2 = com.facebook.ads.redexgen.X.V2.A0m;
        r2[0] = "lVWmVGygxw0UbRbggHe19cSptvLLteak";
        r2[2] = "yD1YSLWVotW9RM3Ng5RpEu8J61bKeSm7";
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
        if (r6 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
        r0 = r7.A0K;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        ((android.view.ViewGroup) r5).removeView(r0);
        r7.A0K = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
        r0 = r7.A0a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c8, code lost:
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
        r0.A0J();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d1, code lost:
        if (android.os.Build.VERSION.SDK_INT < 18) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d5, code lost:
        if (r7.A0L == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
        if (com.facebook.ads.redexgen.X.C0705Ih.A11(r7.A0c) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:
        r7.A0L.A07();
        r7.A04.getOverlay().remove(r7.A0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
        r4.remove(r7.A04);
        A0Z();
        r7.A04 = null;
        r7.A06 = null;
        r0 = r7.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fd, code lost:
        if (r0 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ff, code lost:
        r0.A0V();
        r7.A0R = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0104, code lost:
        A0c();
        r7.A09 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0109, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
        if (r6 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0111, code lost:
        if (com.facebook.ads.redexgen.X.C0705Ih.A1W(r4) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0124, code lost:
        throw new java.lang.IllegalStateException(A0W(481, 38, 72));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void unregisterView() {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V2.unregisterView():void");
    }
}
