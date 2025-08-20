package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.bw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1272bw {
    public static byte[] A00;
    public static String[] A01 = {"Xi67YWaXLJZWqhRsB8SvZdkDn2uXCi1T", "X8XRpgZpu4J2FMNY2R0Im54Lc", "uAp3FxCXIvTUkclpRHbafTdd", "yWg", "kCaq3ZceSZ4xKH", "0ytorNMA8n21LRZOAZR41tORWa47tSnO", "V8IBWi2DfHR6SVI", "jzlGtxrHiOgIbEefJzDEiDs4vGk2Cgvb"};
    public static final Object[] A02;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{31, 43, 40, 40, 33, 31, 48, 37, 43, 42, -22, -10, -9, 0, -42, -19, -81, -75, -75, -75, -80, -17, -10, -19, -19, -95, -28, -30, -17, -17, -16, -11, -95, -29, -26, -95, -28, -30, -12, -11, -95, -11, -16, -95, -17, -16, -17, -82, -17, -10, -19, -19, -95, -11, -6, -15, -26, -95, -20, -16, -11, -19, -22, -17, -81, -62, -13, -13, -30, -6, -67, -20, -16, -11, -19, -22, -17, -81, -62, -17, -6, -64, -65};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:118)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:567)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:39)
     */
    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] A02(Collection<?> collection) {
        C1270bu.A07(collection, A00(0, 10, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
        int size = collection.size();
        if (size == 0) {
            return A02;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return A02;
        }
        Object[] objArr = new Object[size];
        String[] strArr = A01;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A01[7] = "RBKivIY57JQgqBCnQiuvt7rg8FSSFcvN";
        int i = 0;
        while (true) {
            int i5 = i + 1;
            objArr[i] = it.next();
            int length = objArr.length;
            String A002 = A00(10, 11, 59);
            if (i5 >= length) {
                boolean hasNext = it.hasNext();
                String[] strArr2 = A01;
                if (strArr2[5].charAt(0) == strArr2[0].charAt(0)) {
                    throw new RuntimeException();
                }
                A01[7] = "EivW1tnkzbwqNWBtsoIUxwnFoAaiYxH4";
                if (!hasNext) {
                    return objArr;
                }
                int i6 = ((i5 * 3) + 1) >>> 1;
                if (i6 <= i5) {
                    if (i5 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i6 = 2147483645;
                }
                objArr = Arrays.copyOf(objArr, i6);
                C1270bu.A06(objArr, A002);
                i = i5;
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr, i5);
                C1270bu.A06(copyOf, A002);
                return copyOf;
            } else {
                i = i5;
            }
        }
    }

    static {
        A01();
        A02 = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] A03(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        C1270bu.A07(collection, A00(0, 10, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
        if (objArr != null) {
            int size = collection.size();
            if (size == 0) {
                int $i$f$toArrayImpl = objArr.length;
                if ($i$f$toArrayImpl > 0) {
                    objArr[0] = null;
                }
            } else {
                Iterator<?> it = collection.iterator();
                boolean hasNext = it.hasNext();
                if (A01[3].length() != 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "YhRYCedHt9dN7q9AqXu4tWwm";
                strArr[6] = "Pu6AKl3cuGA7cYl";
                if (!hasNext) {
                    if (objArr.length > 0) {
                        objArr[0] = null;
                    }
                } else {
                    int $i$f$toArrayImpl2 = objArr.length;
                    if (size <= $i$f$toArrayImpl2) {
                        objArr2 = objArr;
                    } else {
                        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                        C1270bu.A05(newInstance, A00(21, 62, 53));
                        objArr2 = (Object[]) newInstance;
                    }
                    int size$iv = 0;
                    while (true) {
                        int i = size$iv + 1;
                        objArr2[size$iv] = it.next();
                        int length = objArr2.length;
                        String A002 = A00(10, 11, 59);
                        if (i >= length) {
                            if (!it.hasNext()) {
                                return objArr2;
                            }
                            int $i$f$toArrayImpl3 = i * 3;
                            int $i$f$toArrayImpl4 = ($i$f$toArrayImpl3 + 1) >>> 1;
                            if ($i$f$toArrayImpl4 <= i) {
                                if (i < 2147483645) {
                                    $i$f$toArrayImpl4 = 2147483645;
                                } else {
                                    throw new OutOfMemoryError();
                                }
                            }
                            objArr2 = Arrays.copyOf(objArr2, $i$f$toArrayImpl4);
                            C1270bu.A06(objArr2, A002);
                            String[] strArr2 = A01;
                            String str = strArr2[4];
                            String str2 = strArr2[1];
                            int size$iv2 = str.length();
                            int $i$f$toArrayImpl5 = str2.length();
                            if (size$iv2 == $i$f$toArrayImpl5) {
                                throw new RuntimeException();
                            }
                            Object[] result$iv = A01;
                            result$iv[7] = "t75y3a9XWSg9UWVOHsHEmPOwlRRgWpfZ";
                            size$iv = i;
                        } else if (!it.hasNext()) {
                            if (objArr2 == objArr) {
                                objArr[i] = null;
                            } else {
                                objArr = Arrays.copyOf(objArr2, i);
                                C1270bu.A06(objArr, A002);
                            }
                            return objArr;
                        } else {
                            size$iv = i;
                        }
                    }
                }
            }
            return objArr;
        }
        throw new NullPointerException();
    }
}
