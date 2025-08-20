package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.Kj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0754Kj {
    public static byte[] A00;
    public static String[] A01 = {"R2O7PMYP6nkOeNui3I4WlXx4fu7rpRKA", "y", "n9RLgUbY6qPVyxnn4C2MCNq6tOX6tKMu", "KtI8XvYnNiAs4lVQz", "VIjGruAAxxfbDEfj8", "jnPluIPOifq7BY1vqnqKLiUetY3DHsfM", "J5aiTqmsNT2689NKU", "zCaDldCe0EtEl2h3W"};
    public static final Package A02;
    public static final String A03;
    public static final String A04;
    public static final String A05;
    public static final Set<C1116Yn> A06;
    public static final AtomicReference<InterfaceC0761Ks> A07;
    public static final AtomicReference<InterfaceC0763Ku> A08;

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 18);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-111, -92, -89, -79, -70, -62, -92, -89, -62, -78, -91, -83, -62, -84, -89, -62, -82, -88, -68, -68, -49, -46, -36, -27, -19, -35, -32, -41, -43, -41, -36, -49, -38, -19, -45, -26, -30, -32, -49, -31, 102, 121, 124, -122, -113, -105, -117, 121, -114, 125, 124, -105, -117, -116, 121, -116, 125, -105, 124, 121, -116, 121, -57, -43, -22, -39, -40, -108, -25, -24, -43, -24, -39, -108, -42, -23, -30, -40, -32, -39, -108, -35, -25, -108, -39, -31, -28, -24, -19, -107, -19, -17, 0, -21, 1, 0, -11, -8, -77, -64, -79, -75, -66, -69, -73, -64, -58, -79, -58, -63, -67, -73, -64, -80, -68, -70, 123, -77, -82, -80, -78, -81, -68, -68, -72, 123, -82, -79, -64, 123, -74, -69, -63, -78, -65, -69, -82, -71, 123, -74, -67, -80, 123, -114, -62, -79, -74, -78, -69, -80, -78, -101, -78, -63, -60, -68, -65, -72, -97, -78, -70, -68, -63, -78, -114, -80, -63, -74, -61, -74, -63, -58, -30, -37, -24, -34, -26, -33, -49, -20, -29, -64, -23, -20, -52, -33, -19, -17, -26, -18, -92, -91, -110, -93, -91, 114, -108, -91, -102, -89, -102, -91, -86, -53, -52, -71, -54, -52, -103, -69, -52, -63, -50, -63, -52, -47, -98, -57, -54, -86, -67, -53, -51, -60, -52};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A0B(Intent intent, Set<String> set) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String uri = data.toString();
        for (String str : set) {
            if (uri.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    static {
        A07();
        Package r42 = C0754Kj.class.getPackage();
        A02 = r42;
        A04 = r42 + A06(40, 22, 38);
        A03 = r42 + A06(0, 19, 81);
        A05 = r42 + A06(19, 21, 124);
        A06 = Collections.newSetFromMap(new WeakHashMap());
        A07 = new AtomicReference<>();
        A08 = new AtomicReference<>();
    }

    public static Intent A00(Intent intent) {
        Intent cloneFilter = intent.cloneFilter();
        cloneFilter.setFlags(intent.getFlags());
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(intent.getExtras());
        cloneFilter.putExtra(A05, obtain.marshall());
        obtain.recycle();
        return cloneFilter;
    }

    public static Intent A01(Intent intent, ClassLoader classLoader) {
        Intent cloneFilter = intent.cloneFilter();
        cloneFilter.setFlags(intent.getFlags());
        Bundle audienceNetworkActivityBundle = new Bundle();
        Parcel obtain = Parcel.obtain();
        byte[] byteArrayExtra = intent.getByteArrayExtra(A05);
        if (byteArrayExtra != null) {
            obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            obtain.setDataPosition(0);
            audienceNetworkActivityBundle = obtain.readBundle(classLoader);
            obtain.recycle();
        }
        cloneFilter.putExtras(audienceNetworkActivityBundle);
        return cloneFilter;
    }

    public static Bundle A02(Bundle bundle, ClassLoader classLoader) {
        Parcel obtain = Parcel.obtain();
        byte[] byteArray = bundle.getByteArray(A04);
        if (byteArray != null) {
            obtain.unmarshall(byteArray, 0, byteArray.length);
            obtain.setDataPosition(0);
            Bundle readBundle = obtain.readBundle(classLoader);
            obtain.recycle();
            String[] strArr = A01;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "08vXapB5qdF8q1e2g";
            strArr2[3] = "bPV7EQI3jYdBWJzP2";
            return readBundle;
        }
        throw new IllegalStateException(A06(62, 28, 98));
    }

    public static C1116Yn A03(Intent intent) {
        String stringExtra = intent.getStringExtra(A03);
        if (stringExtra != null) {
            for (C1116Yn c1116Yn : A06) {
                String adId = c1116Yn.A0E().getId();
                if (stringExtra.equals(adId)) {
                    return c1116Yn;
                }
            }
            return null;
        }
        return null;
    }

    public static AdActivityIntent A04(C1116Yn c1116Yn) {
        AdActivityIntent adActivityIntent = new AdActivityIntent(c1116Yn.getApplicationContext(), A05());
        adActivityIntent.putExtra(A03, c1116Yn.A0E().getId());
        A06.add(c1116Yn);
        return adActivityIntent;
    }

    public static Class A05() {
        boolean isRemoteRenderingProcess = ProcessUtils.isRemoteRenderingProcess();
        if (A01[1].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "4NnM5dRGBMW0KGxzs";
        strArr[3] = "N6FCbEqQMIqNBYuck";
        if (isRemoteRenderingProcess) {
            try {
                return Class.forName(A06(R.styleable.AppCompatTheme_toolbarStyle, 59, 59));
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return AudienceNetworkActivity.class;
    }

    public static void A08(Activity activity, Intent intent) throws C0752Kh {
        try {
            activity.startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e2) {
            throw new C0752Kh(e2);
        }
    }

    public static void A09(Bundle bundle, Bundle bundle2) {
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle2);
        bundle.putByteArray(A04, obtain.marshall());
        obtain.recycle();
    }

    public static void A0A(C1116Yn c1116Yn, AdActivityIntent adActivityIntent) throws C0752Kh {
        Context launchContext;
        Context applicationContext = c1116Yn.getApplicationContext();
        if (C0705Ih.A25(c1116Yn) && (launchContext = c1116Yn.A0D()) != null) {
            applicationContext = launchContext;
            if ((adActivityIntent.getFlags() & 268435456) == 268435456) {
                adActivityIntent.setFlags(adActivityIntent.getFlags() ^ 268435456);
            }
        }
        try {
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!A0J(c1116Yn, adActivityIntent)) {
                    c1116Yn.A0E().AF0();
                    return;
                }
                return;
            }
            applicationContext.startActivity(A00(adActivityIntent));
        } catch (ActivityNotFoundException e2) {
            throw new C0752Kh(e2);
        }
    }

    public static boolean A0C(C1116Yn c1116Yn, Intent intent) throws C0752Kh {
        A07.get();
        return A0G(c1116Yn, intent, null);
    }

    public static boolean A0D(C1116Yn c1116Yn, Intent intent) throws C0752Kh {
        A07.get();
        if (0 == 0 || c1116Yn.A0D() == null) {
            return false;
        }
        c1116Yn.A0B();
        try {
            c1116Yn.A0D();
            throw new NullPointerException(A06(203, 22, 70));
        } catch (ActivityNotFoundException e2) {
            throw new C0752Kh(e2);
        } catch (Exception e3) {
            c1116Yn.A07().A9a(A06(90, 8, 122), C8A.A07, new C8B(e3));
            return false;
        }
    }

    public static boolean A0E(C1116Yn c1116Yn, Intent intent) throws C0752Kh {
        return A0F(c1116Yn, A00(intent), -1);
    }

    public static boolean A0F(C1116Yn c1116Yn, Intent intent, int i) throws C0752Kh {
        try {
            Activity currentActivity = ActivityUtils.A00();
            if (currentActivity == null) {
                currentActivity = c1116Yn.A0D();
            }
            if (currentActivity != null) {
                if (i >= 0) {
                    currentActivity.startActivityForResult(intent, i);
                    return true;
                }
                currentActivity.startActivity(intent);
                return true;
            }
            return false;
        } catch (ActivityNotFoundException e2) {
            throw new C0752Kh(e2);
        }
    }

    public static boolean A0G(C1116Yn c1116Yn, Intent intent, InterfaceC0761Ks interfaceC0761Ks) throws C0752Kh {
        if (A0B(intent, C0705Ih.A0V(c1116Yn))) {
            return false;
        }
        Context context = c1116Yn;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A01[1] = "W";
        Context startContext = c1116Yn.A0D();
        if (startContext != null) {
            context = startContext;
        } else {
            intent.addFlags(268435456);
        }
        if (interfaceC0761Ks != null && !A0B(intent, C0705Ih.A0X(c1116Yn))) {
            c1116Yn.A0B();
            try {
                throw new NullPointerException(A06(190, 13, 31));
            } catch (ActivityNotFoundException e2) {
                throw new C0752Kh(e2);
            } catch (Exception e3) {
                c1116Yn.A07().A9a(A06(90, 8, 122), C8A.A08, new C8B(e3));
                return false;
            }
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e5) {
            throw new C0752Kh(e5);
        }
    }

    public static boolean A0H(C1116Yn c1116Yn, Uri uri, String str) throws ActivityNotFoundException {
        A08.get();
        return A0I(c1116Yn, uri, str, null);
    }

    public static boolean A0I(C1116Yn c1116Yn, Uri uri, String str, InterfaceC0763Ku interfaceC0763Ku) throws ActivityNotFoundException {
        if (interfaceC0763Ku == null || c1116Yn.A0D() == null) {
            return false;
        }
        new Bundle().putString(A06(98, 15, 64), str);
        uri.toString();
        c1116Yn.A0D();
        throw new NullPointerException(A06(172, 18, 104));
    }

    public static boolean A0J(C1116Yn c1116Yn, AdActivityIntent adActivityIntent) throws C0752Kh {
        return A0F(c1116Yn, A00(adActivityIntent), 0);
    }
}
