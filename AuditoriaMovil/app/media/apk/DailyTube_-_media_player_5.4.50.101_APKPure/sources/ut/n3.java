package ut;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: ut.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0233n3<T, V> {
        int n3(T t2);

        V y(T t2, int i);
    }

    /* loaded from: classes.dex */
    public interface y<T> {
        void y(T t2, Rect rect);
    }

    /* loaded from: classes.dex */
    public static class zn<T> implements Comparator<T> {

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f14262fb;

        /* renamed from: s  reason: collision with root package name */
        public final y<T> f14263s;
        public final Rect y = new Rect();

        /* renamed from: v  reason: collision with root package name */
        public final Rect f14264v = new Rect();

        public zn(boolean z2, y<T> yVar) {
            this.f14262fb = z2;
            this.f14263s = yVar;
        }

        @Override // java.util.Comparator
        public int compare(T t2, T t3) {
            Rect rect = this.y;
            Rect rect2 = this.f14264v;
            this.f14263s.y(t2, rect);
            this.f14263s.y(t3, rect2);
            int i = rect.top;
            int i5 = rect2.top;
            if (i < i5) {
                return -1;
            }
            if (i > i5) {
                return 1;
            }
            int i6 = rect.left;
            int i8 = rect2.left;
            if (i6 < i8) {
                if (!this.f14262fb) {
                    return -1;
                }
                return 1;
            } else if (i6 > i8) {
                if (this.f14262fb) {
                    return -1;
                }
                return 1;
            } else {
                int i10 = rect.bottom;
                int i11 = rect2.bottom;
                if (i10 < i11) {
                    return -1;
                }
                if (i10 > i11) {
                    return 1;
                }
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 < i13) {
                    if (!this.f14262fb) {
                        return -1;
                    }
                    return 1;
                } else if (i12 > i13) {
                    if (this.f14262fb) {
                        return -1;
                    }
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static <T> T a(T t2, ArrayList<T> arrayList, boolean z2) {
        int indexOf;
        int size = arrayList.size();
        if (t2 == null) {
            indexOf = size;
        } else {
            indexOf = arrayList.indexOf(t2);
        }
        int i = indexOf - 1;
        if (i >= 0) {
            return arrayList.get(i);
        }
        if (z2 && size > 0) {
            return arrayList.get(size - 1);
        }
        return null;
    }

    public static boolean c5(@NonNull Rect rect, @NonNull Rect rect2, int i) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        int i5 = rect.top;
                        int i6 = rect2.top;
                        if ((i5 >= i6 && rect.bottom > i6) || rect.bottom >= rect2.bottom) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i8 = rect.left;
                int i10 = rect2.left;
                if ((i8 >= i10 && rect.right > i10) || rect.right >= rect2.right) {
                    return false;
                }
                return true;
            }
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && rect.top < i12) || rect.top <= rect2.top) {
                return false;
            }
            return true;
        }
        int i13 = rect.right;
        int i14 = rect2.right;
        if ((i13 <= i14 && rect.left < i14) || rect.left <= rect2.left) {
            return false;
        }
        return true;
    }

    public static int f(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, t(i, rect, rect2));
    }

    public static int fb(int i, int i5) {
        return (i * 13 * i) + (i5 * i5);
    }

    public static <L, T> T gv(@NonNull L l2, @NonNull InterfaceC0233n3<L, T> interfaceC0233n3, @NonNull y<T> yVar, @Nullable T t2, int i, boolean z2, boolean z3) {
        int n32 = interfaceC0233n3.n3(l2);
        ArrayList arrayList = new ArrayList(n32);
        for (int i5 = 0; i5 < n32; i5++) {
            arrayList.add(interfaceC0233n3.y(l2, i5));
        }
        Collections.sort(arrayList, new zn(z2, yVar));
        if (i != 1) {
            if (i == 2) {
                return (T) v(t2, arrayList, z3);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return (T) a(t2, arrayList, z3);
    }

    public static boolean i9(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        if (rect.bottom > rect2.top) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                } else if (rect.right > rect2.left) {
                    return false;
                } else {
                    return true;
                }
            } else if (rect.top < rect2.bottom) {
                return false;
            } else {
                return true;
            }
        } else if (rect.left < rect2.right) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean n3(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static boolean s(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!c5(rect, rect2, i)) {
            return false;
        }
        if (!c5(rect, rect3, i) || y(i, rect, rect2, rect3)) {
            return true;
        }
        if (y(i, rect, rect3, rect2) || fb(f(i, rect, rect2), xc(i, rect, rect2)) >= fb(f(i, rect, rect3), xc(i, rect, rect3))) {
            return false;
        }
        return true;
    }

    public static int t(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        i5 = rect2.top;
                        i6 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i5 = rect2.left;
                    i6 = rect.right;
                }
            } else {
                i5 = rect.top;
                i6 = rect2.bottom;
            }
        } else {
            i5 = rect.left;
            i6 = rect2.right;
        }
        return i5 - i6;
    }

    public static int tl(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, wz(i, rect, rect2));
    }

    public static <T> T v(T t2, ArrayList<T> arrayList, boolean z2) {
        int lastIndexOf;
        int size = arrayList.size();
        if (t2 == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = arrayList.lastIndexOf(t2);
        }
        int i = lastIndexOf + 1;
        if (i < size) {
            return arrayList.get(i);
        }
        if (z2 && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public static int wz(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5;
        int i6;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        i5 = rect2.bottom;
                        i6 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i5 = rect2.right;
                    i6 = rect.right;
                }
            } else {
                i5 = rect.top;
                i6 = rect2.top;
            }
        } else {
            i5 = rect.left;
            i6 = rect2.left;
        }
        return i5 - i6;
    }

    public static int xc(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }

    public static boolean y(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean n32 = n3(i, rect, rect2);
        if (n3(i, rect, rect3) || !n32) {
            return false;
        }
        if (i9(i, rect, rect3) && i != 17 && i != 66 && f(i, rect, rect2) >= tl(i, rect, rect3)) {
            return false;
        }
        return true;
    }

    public static <L, T> T zn(@NonNull L l2, @NonNull InterfaceC0233n3<L, T> interfaceC0233n3, @NonNull y<T> yVar, @Nullable T t2, @NonNull Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130) {
                        rect2.offset(0, -(rect.height() + 1));
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        int n32 = interfaceC0233n3.n3(l2);
        Rect rect3 = new Rect();
        T t3 = null;
        for (int i5 = 0; i5 < n32; i5++) {
            T y2 = interfaceC0233n3.y(l2, i5);
            if (y2 != t2) {
                yVar.y(y2, rect3);
                if (s(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t3 = y2;
                }
            }
        }
        return t3;
    }
}
