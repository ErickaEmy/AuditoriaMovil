package com.facebook.ads.redexgen.X;

import android.os.Looper;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: com.facebook.ads.redexgen.X.5I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5I {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 3);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{13, 72, 85, 89, 39, 107, 108, 123, 108, 106, 123, 108, 107, 65, -43, -31, -33, -96, -40, -45, -43, -41, -44, -31, -31, -35, -96, -45, -42, -27};
    }

    private String A00() {
        StackTraceElement[] stackTrace;
        Thread mainThread = Looper.getMainLooper().getThread();
        for (StackTraceElement element : mainThread.getStackTrace()) {
            if (element.getClassName().startsWith(A01(14, 16, R.styleable.AppCompatTheme_textColorSearchUrl))) {
                return element.toString();
            }
        }
        return null;
    }

    private Map<Thread, StackTraceElement[]> A02() {
        final Thread thread = Looper.getMainLooper().getThread();
        Map<Thread, StackTraceElement[]> stackTraces = new TreeMap<>(new Comparator<Thread>() { // from class: com.facebook.ads.redexgen.X.5H
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                Thread thread4 = thread;
                if (thread2 == thread4) {
                    return -1;
                }
                if (thread3 == thread4) {
                    return 1;
                }
                return thread3.getName().compareTo(thread2.getName());
            }
        });
        stackTraces.putAll(Thread.getAllStackTraces());
        return stackTraces;
    }

    public final String A04() {
        StackTraceElement[] value;
        StringBuilder sb = new StringBuilder();
        sb.append(A01(1, 13, 4));
        sb.append(A00());
        String A01 = A01(0, 1, 0);
        sb.append(A01);
        for (Map.Entry<Thread, StackTraceElement[]> entry : A02().entrySet()) {
            sb.append(entry.getKey().getName());
            sb.append(A01);
            for (StackTraceElement stackTraceElement : entry.getValue()) {
                sb.append('\t');
                sb.append(stackTraceElement.toString());
                sb.append(A01);
            }
        }
        return sb.toString();
    }

    public final boolean A05() {
        return A00() != null;
    }
}
