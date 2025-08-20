package le;

import android.os.Build;
import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import l.z;
import l.zn;
/* loaded from: classes.dex */
public class x4 {

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {

        /* renamed from: gv  reason: collision with root package name */
        public static final /* synthetic */ int[] f10354gv;

        /* renamed from: n3  reason: collision with root package name */
        public static final /* synthetic */ int[] f10355n3;
        public static final /* synthetic */ int[] y;

        /* renamed from: zn  reason: collision with root package name */
        public static final /* synthetic */ int[] f10356zn;

        static {
            int[] iArr = new int[l.xc.values().length];
            f10354gv = iArr;
            try {
                iArr[l.xc.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10354gv[l.xc.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[l.t.values().length];
            f10356zn = iArr2;
            try {
                iArr2[l.t.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10356zn[l.t.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10356zn[l.t.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10356zn[l.t.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10356zn[l.t.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[l.y.values().length];
            f10355n3 = iArr3;
            try {
                iArr3[l.y.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10355n3[l.y.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[z.y.values().length];
            y = iArr4;
            try {
                iArr4[z.y.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[z.y.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[z.y.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                y[z.y.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                y[z.y.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                y[z.y.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    @NonNull
    public static l.xc a(int i) {
        if (i != 0) {
            if (i == 1) {
                return l.xc.DROP_WORK_REQUEST;
            }
            throw new IllegalArgumentException("Could not convert " + i + " to OutOfQuotaPolicy");
        }
        return l.xc.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    public static int c5(@NonNull l.xc xcVar) {
        int i = y.f10354gv[xcVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new IllegalArgumentException("Could not convert " + xcVar + " to int");
        }
        return 0;
    }

    public static z.y fb(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return z.y.CANCELLED;
                            }
                            throw new IllegalArgumentException("Could not convert " + i + " to State");
                        }
                        return z.y.BLOCKED;
                    }
                    return z.y.FAILED;
                }
                return z.y.SUCCEEDED;
            }
            return z.y.RUNNING;
        }
        return z.y.ENQUEUED;
    }

    public static l.y gv(int i) {
        if (i != 0) {
            if (i == 1) {
                return l.y.LINEAR;
            }
            throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
        }
        return l.y.EXPONENTIAL;
    }

    public static int i9(z.y yVar) {
        switch (y.y[yVar.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + yVar + " to int");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x003c -> B:34:0x0058). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l.zn n3(byte[] r6) {
        /*
            l.zn r0 = new l.zn
            r0.<init>()
            if (r6 != 0) goto L8
            return r0
        L8:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L44
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L44
            int r6 = r2.readInt()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        L17:
            if (r6 <= 0) goto L2f
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            boolean r4 = r2.readBoolean()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r0.y(r3, r4)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            int r6 = r6 + (-1)
            goto L17
        L2b:
            r6 = move-exception
            goto L59
        L2d:
            r6 = move-exception
            goto L48
        L2f:
            r2.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r6 = move-exception
            r6.printStackTrace()
        L37:
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L58
        L3b:
            r6 = move-exception
            r6.printStackTrace()
            goto L58
        L40:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L59
        L44:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L48:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L55
            r2.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r6 = move-exception
            r6.printStackTrace()
        L55:
            r1.close()     // Catch: java.io.IOException -> L3b
        L58:
            return r0
        L59:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L5f
            goto L63
        L5f:
            r0 = move-exception
            r0.printStackTrace()
        L63:
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r0 = move-exception
            r0.printStackTrace()
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: le.x4.n3(byte[]):l.zn");
    }

    public static int s(l.t tVar) {
        int i = y.f10356zn[tVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            if (i == 4) {
                return 3;
            }
            if (i == 5) {
                return 4;
            }
            if (Build.VERSION.SDK_INT >= 30 && tVar == l.t.TEMPORARILY_UNMETERED) {
                return 5;
            }
            throw new IllegalArgumentException("Could not convert " + tVar + " to int");
        }
        return 0;
    }

    public static l.t v(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (Build.VERSION.SDK_INT >= 30 && i == 5) {
                                return l.t.TEMPORARILY_UNMETERED;
                            }
                            throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
                        }
                        return l.t.METERED;
                    }
                    return l.t.NOT_ROAMING;
                }
                return l.t.UNMETERED;
            }
            return l.t.CONNECTED;
        }
        return l.t.NOT_REQUIRED;
    }

    public static int y(l.y yVar) {
        int i = y.f10355n3[yVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new IllegalArgumentException("Could not convert " + yVar + " to int");
        }
        return 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:34:0x006a). Please submit an issue!!! */
    public static byte[] zn(l.zn znVar) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (znVar.zn() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            objectOutputStream.writeInt(znVar.zn());
            for (zn.y yVar : znVar.n3()) {
                objectOutputStream.writeUTF(yVar.y().toString());
                objectOutputStream.writeBoolean(yVar.n3());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            byteArrayOutputStream.close();
        } catch (IOException e6) {
            e = e6;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
