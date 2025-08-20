package j5;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$id;
import androidx.core.app.NotificationCompat;
import j5.a;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: gv  reason: collision with root package name */
    public static int f9374gv;
    public final AccessibilityNodeInfo y;

    /* renamed from: n3  reason: collision with root package name */
    public int f9375n3 = -1;

    /* renamed from: zn  reason: collision with root package name */
    public int f9376zn = -1;

    /* loaded from: classes.dex */
    public static class a {
        public final Object y;

        public a(Object obj) {
            this.y = obj;
        }

        public static a y(int i, int i5, boolean z2, int i6) {
            return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i5, z2, i6));
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        public final Object y;

        public fb(Object obj) {
            this.y = obj;
        }

        public static fb y(int i, int i5, int i6, int i8, boolean z2, boolean z3) {
            return new fb(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i5, i6, i8, z2, z3));
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static zn a(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return zn.x5(accessibilityNodeInfo.getParent(i));
        }

        public static void c5(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setTextSelectable(z2);
        }

        public static String fb(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static String gv(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static void i9(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }

        public static zn n3(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i5) {
            return zn.x5(accessibilityNodeInfo.getChild(i, i5));
        }

        public static boolean s(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo v(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static fb y(boolean z2, int i, int i5, int i6, int i8, boolean z3, String str, String str2) {
            return new fb(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z2).setColumnIndex(i).setRowIndex(i5).setColumnSpan(i6).setRowSpan(i8).setSelected(z3).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static String zn(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static Object n3(int i, float f4, float f6, float f9) {
            return AccessibilityNodeInfo.RangeInfo.obtain(i, f4, f6, f9);
        }

        public static fb y(int i, int i5, int i6, int i8, boolean z2) {
            return new fb(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i5, i6, i8, z2));
        }

        public static Bundle zn(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static void a(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z2);
        }

        public static void c5(AccessibilityNodeInfo accessibilityNodeInfo, long j2) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j2));
        }

        public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z2);
        }

        public static void fb(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static boolean gv(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static void i9(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z2) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z2);
        }

        public static CharSequence n3(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static void s(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static boolean v(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void y(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static long zn(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        @NonNull

        /* renamed from: a8  reason: collision with root package name */
        public static final y f9378a8;

        /* renamed from: b  reason: collision with root package name */
        public static final y f9379b;

        /* renamed from: d  reason: collision with root package name */
        public static final y f9383d;

        /* renamed from: d0  reason: collision with root package name */
        public static final y f9384d0;
        @NonNull

        /* renamed from: ej  reason: collision with root package name */
        public static final y f9385ej;

        /* renamed from: fh  reason: collision with root package name */
        public static final y f9389fh;
        @NonNull

        /* renamed from: hw  reason: collision with root package name */
        public static final y f9390hw;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        public static final y f9393j;
        @NonNull

        /* renamed from: j5  reason: collision with root package name */
        public static final y f9394j5;

        /* renamed from: k5  reason: collision with root package name */
        public static final y f9395k5;

        /* renamed from: mg  reason: collision with root package name */
        public static final y f9396mg;
        @NonNull

        /* renamed from: o  reason: collision with root package name */
        public static final y f9399o;
        @NonNull

        /* renamed from: oz  reason: collision with root package name */
        public static final y f9400oz;
        @NonNull

        /* renamed from: qn  reason: collision with root package name */
        public static final y f9402qn;

        /* renamed from: rz  reason: collision with root package name */
        public static final y f9404rz;

        /* renamed from: ta  reason: collision with root package name */
        public static final y f9407ta;
        @NonNull

        /* renamed from: ud  reason: collision with root package name */
        public static final y f9409ud;
        @NonNull

        /* renamed from: ut  reason: collision with root package name */
        public static final y f9410ut;

        /* renamed from: vl  reason: collision with root package name */
        public static final y f9412vl;

        /* renamed from: x  reason: collision with root package name */
        public static final y f9415x;

        /* renamed from: yt  reason: collision with root package name */
        public static final y f9418yt;
        @NonNull

        /* renamed from: z6  reason: collision with root package name */
        public static final y f9420z6;

        /* renamed from: gv  reason: collision with root package name */
        public final j5.a f9421gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9422n3;
        public final Object y;

        /* renamed from: zn  reason: collision with root package name */
        public final Class<? extends a.y> f9423zn;

        /* renamed from: v  reason: collision with root package name */
        public static final y f9411v = new y(1, null);

        /* renamed from: a  reason: collision with root package name */
        public static final y f9377a = new y(2, null);

        /* renamed from: fb  reason: collision with root package name */
        public static final y f9388fb = new y(4, null);

        /* renamed from: s  reason: collision with root package name */
        public static final y f9405s = new y(8, null);

        /* renamed from: c5  reason: collision with root package name */
        public static final y f9381c5 = new y(16, null);

        /* renamed from: i9  reason: collision with root package name */
        public static final y f9392i9 = new y(32, null);

        /* renamed from: f  reason: collision with root package name */
        public static final y f9386f = new y(64, null);

        /* renamed from: t  reason: collision with root package name */
        public static final y f9406t = new y(NotificationCompat.FLAG_HIGH_PRIORITY, null);

        /* renamed from: tl  reason: collision with root package name */
        public static final y f9408tl = new y(256, (CharSequence) null, a.n3.class);

        /* renamed from: wz  reason: collision with root package name */
        public static final y f9414wz = new y(512, (CharSequence) null, a.n3.class);

        /* renamed from: xc  reason: collision with root package name */
        public static final y f9417xc = new y(1024, (CharSequence) null, a.zn.class);

        /* renamed from: w  reason: collision with root package name */
        public static final y f9413w = new y(2048, (CharSequence) null, a.zn.class);

        /* renamed from: p  reason: collision with root package name */
        public static final y f9401p = new y(4096, null);

        /* renamed from: mt  reason: collision with root package name */
        public static final y f9397mt = new y(8192, null);

        /* renamed from: co  reason: collision with root package name */
        public static final y f9382co = new y(16384, null);

        /* renamed from: z  reason: collision with root package name */
        public static final y f9419z = new y(32768, null);

        /* renamed from: r  reason: collision with root package name */
        public static final y f9403r = new y(65536, null);

        /* renamed from: x4  reason: collision with root package name */
        public static final y f9416x4 = new y(131072, (CharSequence) null, a.fb.class);

        /* renamed from: i4  reason: collision with root package name */
        public static final y f9391i4 = new y(262144, null);

        /* renamed from: f3  reason: collision with root package name */
        public static final y f9387f3 = new y(524288, null);

        /* renamed from: n  reason: collision with root package name */
        public static final y f9398n = new y(1048576, null);

        /* renamed from: c  reason: collision with root package name */
        public static final y f9380c = new y(2097152, (CharSequence) null, a.s.class);

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22 = null;
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            f9384d0 = new y(accessibilityAction, 16908342, null, null, null);
            if (i >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction2 = null;
            }
            f9389fh = new y(accessibilityAction2, 16908343, null, null, a.v.class);
            if (i >= 23) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                accessibilityAction3 = null;
            }
            f9404rz = new y(accessibilityAction3, 16908344, null, null, null);
            if (i >= 23) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                accessibilityAction4 = null;
            }
            f9396mg = new y(accessibilityAction4, 16908345, null, null, null);
            if (i >= 23) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                accessibilityAction5 = null;
            }
            f9407ta = new y(accessibilityAction5, 16908346, null, null, null);
            if (i >= 23) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                accessibilityAction6 = null;
            }
            f9383d = new y(accessibilityAction6, 16908347, null, null, null);
            if (i >= 29) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction7 = null;
            }
            f9420z6 = new y(accessibilityAction7, 16908358, null, null, null);
            if (i >= 29) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction8 = null;
            }
            f9385ej = new y(accessibilityAction8, 16908359, null, null, null);
            if (i >= 29) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction9 = null;
            }
            f9409ud = new y(accessibilityAction9, 16908360, null, null, null);
            if (i >= 29) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction10 = null;
            }
            f9378a8 = new y(accessibilityAction10, 16908361, null, null, null);
            if (i >= 23) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction11 = null;
            }
            f9415x = new y(accessibilityAction11, 16908348, null, null, null);
            if (i >= 24) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction12 = null;
            }
            f9379b = new y(accessibilityAction12, 16908349, null, null, a.C0127a.class);
            if (i >= 26) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction13 = null;
            }
            f9395k5 = new y(accessibilityAction13, 16908354, null, null, a.gv.class);
            if (i >= 28) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction14 = null;
            }
            f9418yt = new y(accessibilityAction14, 16908356, null, null, null);
            if (i >= 28) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction15 = null;
            }
            f9412vl = new y(accessibilityAction15, 16908357, null, null, null);
            if (i >= 30) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction16 = null;
            }
            f9390hw = new y(accessibilityAction16, 16908362, null, null, null);
            if (i >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            } else {
                accessibilityAction17 = null;
            }
            f9394j5 = new y(accessibilityAction17, 16908372, null, null, null);
            if (i >= 32) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction18 = null;
            }
            f9402qn = new y(accessibilityAction18, 16908373, null, null, null);
            if (i >= 32) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            } else {
                accessibilityAction19 = null;
            }
            f9399o = new y(accessibilityAction19, 16908374, null, null, null);
            if (i >= 32) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            } else {
                accessibilityAction20 = null;
            }
            f9393j = new y(accessibilityAction20, 16908375, null, null, null);
            if (i >= 33) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            } else {
                accessibilityAction21 = null;
            }
            f9400oz = new y(accessibilityAction21, 16908376, null, null, null);
            if (i >= 34) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
            }
            f9410ut = new y(accessibilityAction22, 16908382, null, null, null);
        }

        public y(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof y)) {
                return false;
            }
            y yVar = (y) obj;
            Object obj2 = this.y;
            if (obj2 == null) {
                if (yVar.y != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(yVar.y)) {
                return false;
            } else {
                return true;
            }
        }

        public boolean gv(View view, Bundle bundle) {
            String name;
            a.y newInstance;
            if (this.f9421gv != null) {
                Class<? extends a.y> cls = this.f9423zn;
                a.y yVar = null;
                if (cls != null) {
                    try {
                        newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        newInstance.y(bundle);
                        yVar = newInstance;
                    } catch (Exception e3) {
                        e = e3;
                        yVar = newInstance;
                        Class<? extends a.y> cls2 = this.f9423zn;
                        if (cls2 == null) {
                            name = "null";
                        } else {
                            name = cls2.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.f9421gv.y(view, yVar);
                    }
                }
                return this.f9421gv.y(view, yVar);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.y;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public int n3() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.y).getId();
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String i92 = zn.i9(this.f9422n3);
            if (i92.equals("ACTION_UNKNOWN") && zn() != null) {
                i92 = zn().toString();
            }
            sb.append(i92);
            return sb.toString();
        }

        public y y(CharSequence charSequence, j5.a aVar) {
            return new y(null, this.f9422n3, charSequence, aVar, this.f9423zn);
        }

        public CharSequence zn() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.y).getLabel();
        }

        public y(int i, CharSequence charSequence, j5.a aVar) {
            this(null, i, charSequence, aVar, null);
        }

        public y(Object obj) {
            this(obj, 0, null, null, null);
        }

        public y(int i, CharSequence charSequence, Class<? extends a.y> cls) {
            this(null, i, charSequence, null, cls);
        }

        public y(Object obj, int i, CharSequence charSequence, j5.a aVar, Class<? extends a.y> cls) {
            this.f9422n3 = i;
            this.f9421gv = aVar;
            if (obj == null) {
                this.y = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.y = obj;
            }
            this.f9423zn = cls;
        }
    }

    /* renamed from: j5.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0128zn {
        public static CharSequence n3(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static Object y(int i, float f4, float f6, float f9) {
            return new AccessibilityNodeInfo.RangeInfo(i, f4, f6, f9);
        }

        public static void zn(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    @Deprecated
    public zn(Object obj) {
        this.y = (AccessibilityNodeInfo) obj;
    }

    public static zn en() {
        return w2(AccessibilityNodeInfo.obtain());
    }

    public static String i9(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case NotificationCompat.FLAG_HIGH_PRIORITY /* 128 */:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908382:
                        return "ACTION_SCROLL_IN_DIRECTION";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i) {
                                            case 16908372:
                                                return "ACTION_IME_ENTER";
                                            case 16908373:
                                                return "ACTION_DRAG_START";
                                            case 16908374:
                                                return "ACTION_DRAG_DROP";
                                            case 16908375:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static zn jz(View view) {
        return w2(AccessibilityNodeInfo.obtain(view));
    }

    public static ClickableSpan[] mt(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static zn u(zn znVar) {
        return w2(AccessibilityNodeInfo.obtain(znVar.y));
    }

    public static zn w2(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new zn(accessibilityNodeInfo);
    }

    public static zn x5(Object obj) {
        if (obj != null) {
            return new zn(obj);
        }
        return null;
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            fb();
            ct(view);
            ClickableSpan[] mt2 = mt(charSequence);
            if (mt2 != null && mt2.length > 0) {
                x4().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.y);
                SparseArray<WeakReference<ClickableSpan>> f32 = f3(view);
                for (int i = 0; i < mt2.length; i++) {
                    int z62 = z6(mt2[i], f32);
                    f32.put(z62, new WeakReference<>(mt2[i]));
                    v(mt2[i], (Spanned) charSequence, z62);
                }
            }
        }
    }

    public boolean a8() {
        return this.y.isCheckable();
    }

    public void ad(boolean z2) {
        this.y.setSelected(z2);
    }

    public void ap(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.y;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((a) obj).y;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public boolean b() {
        return this.y.isClickable();
    }

    public void bk(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.y.setHintText(charSequence);
        } else {
            n3.zn(this.y).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> c(View view) {
        return (SparseArray) view.getTag(R$id.f2127ud);
    }

    public List<y> c5() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.y.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new y(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Nullable
    public CharSequence co() {
        if (Build.VERSION.SDK_INT >= 34) {
            return v.n3(this.y);
        }
        return n3.zn(this.y).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void cr(View view, int i) {
        this.f9375n3 = i;
        this.y.setParent(view, i);
    }

    public final void ct(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < c2.size(); i++) {
                if (c2.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                c2.remove(((Integer) arrayList.get(i5)).intValue());
            }
        }
    }

    public void cy(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.y.setShowingHintText(z2);
        } else {
            rs(4, z2);
        }
    }

    public final boolean d() {
        return !s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    @Nullable
    public CharSequence d0() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0128zn.n3(this.y);
        }
        return n3.zn(this.y).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public boolean dm(y yVar) {
        return this.y.removeAction((AccessibilityNodeInfo.AccessibilityAction) yVar.y);
    }

    public void e(CharSequence charSequence) {
        this.y.setClassName(charSequence);
    }

    @Deprecated
    public void eb(Rect rect) {
        this.y.setBoundsInParent(rect);
    }

    public boolean ej() {
        if (Build.VERSION.SDK_INT >= 34) {
            return v.v(this.y);
        }
        return t(64);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zn)) {
            return false;
        }
        zn znVar = (zn) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.y;
        if (accessibilityNodeInfo == null) {
            if (znVar.y != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(znVar.y)) {
            return false;
        }
        if (this.f9376zn == znVar.f9376zn && this.f9375n3 == znVar.f9375n3) {
            return true;
        }
        return false;
    }

    @Deprecated
    public int f() {
        return this.y.getActions();
    }

    public final SparseArray<WeakReference<ClickableSpan>> f3(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(R$id.f2127ud, sparseArray);
            return sparseArray;
        }
        return c2;
    }

    public boolean f7() {
        return this.y.isVisibleToUser();
    }

    public final void fb() {
        n3.zn(this.y).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        n3.zn(this.y).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        n3.zn(this.y).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        n3.zn(this.y).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public CharSequence fh() {
        if (d()) {
            List<Integer> s2 = s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> s3 = s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> s4 = s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> s5 = s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.y.getText(), 0, this.y.getText().length()));
            for (int i = 0; i < s2.size(); i++) {
                spannableString.setSpan(new j5.y(s5.get(i).intValue(), this, x4().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), s2.get(i).intValue(), s3.get(i).intValue(), s4.get(i).intValue());
            }
            return spannableString;
        }
        return this.y.getText();
    }

    public void g(boolean z2) {
        this.y.setFocused(z2);
    }

    public void g3(CharSequence charSequence) {
        this.y.setError(charSequence);
    }

    public void gq(CharSequence charSequence) {
        this.y.setText(charSequence);
    }

    public void gv(View view, int i) {
        this.y.addChild(view, i);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.y;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean hw() {
        return this.y.isFocused();
    }

    public int i4() {
        return this.y.getMaxTextLength();
    }

    public boolean j() {
        return this.y.isPassword();
    }

    public boolean j5() {
        return t(67108864);
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT >= 33) {
            return gv.s(this.y);
        }
        return t(8388608);
    }

    public boolean k5() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.y.isContextClickable();
        }
        return false;
    }

    public void kp(boolean z2) {
        this.y.setDismissable(z2);
    }

    public void l(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            C0128zn.zn(this.y, charSequence);
        } else {
            n3.zn(this.y).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void lc(Rect rect) {
        this.y.setBoundsInScreen(rect);
    }

    public void m(boolean z2) {
        this.y.setFocusable(z2);
    }

    @Nullable
    public String mg() {
        if (Build.VERSION.SDK_INT >= 33) {
            return gv.fb(this.y);
        }
        return n3.zn(this.y).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public CharSequence n() {
        return this.y.getPackageName();
    }

    public void n3(y yVar) {
        this.y.addAction((AccessibilityNodeInfo.AccessibilityAction) yVar.y);
    }

    public void nf(boolean z2) {
        this.y.setCheckable(z2);
    }

    public boolean o() {
        return this.y.isLongClickable();
    }

    public void o0(@Nullable CharSequence charSequence) {
        n3.zn(this.y).putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public void o4(boolean z2) {
        this.y.setAccessibilityFocused(z2);
    }

    public void oa(boolean z2) {
        this.y.setVisibleToUser(z2);
    }

    public boolean oz() {
        return this.y.isScrollable();
    }

    public CharSequence p() {
        return this.y.getClassName();
    }

    public void pq(View view) {
        this.f9375n3 = -1;
        this.y.setParent(view);
    }

    public void pz(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.y.setPaneTitle(charSequence);
        } else {
            n3.zn(this.y).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public boolean q9() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.y.isShowingHintText();
        }
        return t(4);
    }

    public void qj(View view, int i) {
        this.f9376zn = i;
        this.y.setSource(view, i);
    }

    public void qk(View view) {
        this.f9376zn = -1;
        this.y.setSource(view);
    }

    public boolean qn() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.y.isImportantForAccessibility();
        }
        return true;
    }

    public CharSequence r() {
        return this.y.getError();
    }

    public void ra(boolean z2) {
        this.y.setChecked(z2);
    }

    public void rb(boolean z2) {
        this.y.setEnabled(z2);
    }

    public final void rs(int i, boolean z2) {
        Bundle x42 = x4();
        if (x42 != null) {
            int i5 = x42.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z2) {
                i = 0;
            }
            x42.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i5);
        }
    }

    @Nullable
    public CharSequence rz() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.y.getTooltipText();
        }
        return n3.zn(this.y).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public final List<Integer> s(String str) {
        ArrayList<Integer> integerArrayList = n3.zn(this.y).getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            n3.zn(this.y).putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void s8(boolean z2) {
        this.y.setClickable(z2);
    }

    public final boolean t(int i) {
        Bundle x42 = x4();
        if (x42 == null || (x42.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) != i) {
            return false;
        }
        return true;
    }

    public String ta() {
        return this.y.getViewIdResourceName();
    }

    public void tg(CharSequence charSequence) {
        this.y.setPackageName(charSequence);
    }

    @Deprecated
    public void tl(Rect rect) {
        this.y.getBoundsInParent(rect);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        tl(rect);
        sb.append("; boundsInParent: " + rect);
        wz(rect);
        sb.append("; boundsInScreen: " + rect);
        xc(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(n());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(fh());
        sb.append("; error: ");
        sb.append(r());
        sb.append("; maxTextLength: ");
        sb.append(i4());
        sb.append("; stateDescription: ");
        sb.append(d0());
        sb.append("; contentDescription: ");
        sb.append(z());
        sb.append("; tooltipText: ");
        sb.append(rz());
        sb.append("; viewIdResName: ");
        sb.append(ta());
        sb.append("; uniqueId: ");
        sb.append(mg());
        sb.append("; checkable: ");
        sb.append(a8());
        sb.append("; checked: ");
        sb.append(x());
        sb.append("; focusable: ");
        sb.append(vl());
        sb.append("; focused: ");
        sb.append(hw());
        sb.append("; selected: ");
        sb.append(ut());
        sb.append("; clickable: ");
        sb.append(b());
        sb.append("; longClickable: ");
        sb.append(o());
        sb.append("; contextClickable: ");
        sb.append(k5());
        sb.append("; enabled: ");
        sb.append(yt());
        sb.append("; password: ");
        sb.append(j());
        sb.append("; scrollable: " + oz());
        sb.append("; containerTitle: ");
        sb.append(co());
        sb.append("; granularScrollingSupported: ");
        sb.append(j5());
        sb.append("; importantForAccessibility: ");
        sb.append(qn());
        sb.append("; visible: ");
        sb.append(f7());
        sb.append("; isTextSelectable: ");
        sb.append(k());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(ej());
        sb.append("; [");
        List<y> c52 = c5();
        for (int i = 0; i < c52.size(); i++) {
            y yVar = c52.get(i);
            String i92 = i9(yVar.n3());
            if (i92.equals("ACTION_UNKNOWN") && yVar.zn() != null) {
                i92 = yVar.zn().toString();
            }
            sb.append(i92);
            if (i != c52.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.y.setHeading(z2);
        } else {
            rs(2, z2);
        }
    }

    public boolean ud() {
        return this.y.isAccessibilityFocused();
    }

    public boolean ut() {
        return this.y.isSelected();
    }

    public final void v(ClickableSpan clickableSpan, Spanned spanned, int i) {
        s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        s("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    public boolean vl() {
        return this.y.isFocusable();
    }

    public void vp(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.y.setTraversalAfter(view);
        }
    }

    public int w() {
        return this.y.getChildCount();
    }

    public AccessibilityNodeInfo w9() {
        return this.y;
    }

    public void wf(boolean z2) {
        this.y.setScrollable(z2);
    }

    public void wz(Rect rect) {
        this.y.getBoundsInScreen(rect);
    }

    public boolean x() {
        return this.y.isChecked();
    }

    public Bundle x4() {
        return n3.zn(this.y);
    }

    public void xb(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.y.setScreenReaderFocusable(z2);
        } else {
            rs(1, z2);
        }
    }

    public void xc(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            v.y(this.y, rect);
            return;
        }
        Rect rect2 = (Rect) n3.zn(this.y).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void y(int i) {
        this.y.addAction(i);
    }

    public void y4(int i) {
        this.y.setMaxTextLength(i);
    }

    public boolean y5(int i, Bundle bundle) {
        return this.y.performAction(i, bundle);
    }

    public void yc(CharSequence charSequence) {
        this.y.setContentDescription(charSequence);
    }

    public void yg(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.y;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((fb) obj).y;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public boolean yt() {
        return this.y.isEnabled();
    }

    public CharSequence z() {
        return this.y.getContentDescription();
    }

    public final int z6(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i5 = f9374gv;
        f9374gv = i5 + 1;
        return i5;
    }

    public void zn(View view) {
        this.y.addChild(view);
    }

    public zn(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.y = accessibilityNodeInfo;
    }

    @Deprecated
    public void xg() {
    }
}
