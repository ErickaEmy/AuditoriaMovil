package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.mt;
import androidx.recyclerview.widget.n3;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.tl;
import androidx.recyclerview.widget.y;
import j5.zn;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements hw.f {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    static final boolean POST_UPDATES_ON_ANIMATION;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.tl mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    s mAdapter;
    androidx.recyclerview.widget.y mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private f mChildDrawingOrderCallback;
    androidx.recyclerview.widget.n3 mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    @NonNull
    private t mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.a mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private z mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    tl mItemAnimator;
    private tl.n3 mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<xc> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    w mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final n mObserver;
    private List<mt> mOnChildAttachStateListeners;
    private co mOnFlingListener;
    private final ArrayList<z> mOnItemTouchListeners;
    final List<ta> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    a.n3 mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final i4 mRecycler;
    f3 mRecyclerListener;
    final List<f3> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private r mScrollListener;
    private List<r> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private hw.t mScrollingChildHelper;
    final fh mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final mg mViewFlinger;
    private final mt.n3 mViewInfoProcessCallback;
    final androidx.recyclerview.widget.mt mViewInfoStore;

    /* loaded from: classes.dex */
    public class a implements y.InterfaceC0026y {
        public a() {
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public ta a(int i) {
            ta findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.wz(findViewHolderForPosition.itemView)) {
                return null;
            }
            return findViewHolderForPosition;
        }

        public void c5(y.n3 n3Var) {
            int i = n3Var.y;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 8) {
                            RecyclerView recyclerView = RecyclerView.this;
                            recyclerView.mLayout.ne(recyclerView, n3Var.f3330n3, n3Var.f3329gv, 1);
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mLayout.nd(recyclerView2, n3Var.f3330n3, n3Var.f3329gv, n3Var.f3331zn);
                    return;
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.q(recyclerView3, n3Var.f3330n3, n3Var.f3329gv);
                return;
            }
            RecyclerView recyclerView4 = RecyclerView.this;
            recyclerView4.mLayout.vn(recyclerView4, n3Var.f3330n3, n3Var.f3329gv);
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void fb(int i, int i5) {
            RecyclerView.this.offsetPositionRecordsForInsert(i, i5);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void gv(int i, int i5) {
            RecyclerView.this.offsetPositionRecordsForRemove(i, i5, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void n3(y.n3 n3Var) {
            c5(n3Var);
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void s(int i, int i5) {
            RecyclerView.this.offsetPositionRecordsForRemove(i, i5, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f3104gv += i5;
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void v(int i, int i5, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i5, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void y(int i, int i5) {
            RecyclerView.this.offsetPositionRecordsForMove(i, i5);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.y.InterfaceC0026y
        public void zn(y.n3 n3Var) {
            c5(n3Var);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements z {
        @Override // androidx.recyclerview.widget.RecyclerView.z
        public void onRequestDisallowInterceptTouchEvent(boolean z2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.z
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    /* loaded from: classes.dex */
    public static class c5 extends Observable<i9> {
        public void a(int i, int i5) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i5);
            }
        }

        public void fb(int i, int i5) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i5);
            }
        }

        public void gv(int i, int i5) {
            v(i, i5, null);
        }

        public void n3() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void s() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        public void v(int i, int i5, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i5, obj);
            }
        }

        public boolean y() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void zn(int i, int i5) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i9) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i5, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class co {
        public abstract boolean y(int i, int i5);
    }

    /* loaded from: classes.dex */
    public static abstract class d0 {

        /* renamed from: a  reason: collision with root package name */
        public View f3087a;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3089gv;

        /* renamed from: n3  reason: collision with root package name */
        public RecyclerView f3090n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f3091s;

        /* renamed from: v  reason: collision with root package name */
        public boolean f3092v;

        /* renamed from: zn  reason: collision with root package name */
        public w f3093zn;
        public int y = -1;

        /* renamed from: fb  reason: collision with root package name */
        public final y f3088fb = new y(0, 0);

        /* loaded from: classes.dex */
        public interface n3 {
            @Nullable
            PointF y(int i);
        }

        /* loaded from: classes.dex */
        public static class y {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3094a;

            /* renamed from: fb  reason: collision with root package name */
            public int f3095fb;

            /* renamed from: gv  reason: collision with root package name */
            public int f3096gv;

            /* renamed from: n3  reason: collision with root package name */
            public int f3097n3;

            /* renamed from: v  reason: collision with root package name */
            public Interpolator f3098v;
            public int y;

            /* renamed from: zn  reason: collision with root package name */
            public int f3099zn;

            public y(int i, int i5) {
                this(i, i5, Integer.MIN_VALUE, null);
            }

            public void gv(int i, int i5, int i6, @Nullable Interpolator interpolator) {
                this.y = i;
                this.f3097n3 = i5;
                this.f3099zn = i6;
                this.f3098v = interpolator;
                this.f3094a = true;
            }

            public void n3(int i) {
                this.f3096gv = i;
            }

            public final void v() {
                if (this.f3098v != null && this.f3099zn < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f3099zn >= 1) {
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public boolean y() {
                if (this.f3096gv >= 0) {
                    return true;
                }
                return false;
            }

            public void zn(RecyclerView recyclerView) {
                int i = this.f3096gv;
                if (i >= 0) {
                    this.f3096gv = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f3094a = false;
                } else if (this.f3094a) {
                    v();
                    recyclerView.mViewFlinger.v(this.y, this.f3097n3, this.f3099zn, this.f3098v);
                    int i5 = this.f3095fb + 1;
                    this.f3095fb = i5;
                    if (i5 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3094a = false;
                } else {
                    this.f3095fb = 0;
                }
            }

            public y(int i, int i5, int i6, @Nullable Interpolator interpolator) {
                this.f3096gv = -1;
                this.y = i;
                this.f3097n3 = i5;
                this.f3099zn = i6;
                this.f3098v = interpolator;
            }
        }

        public int a() {
            return this.y;
        }

        public void c5(@NonNull PointF pointF) {
            float f4 = pointF.x;
            float f6 = pointF.y;
            float sqrt = (float) Math.sqrt((f4 * f4) + (f6 * f6));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void f(View view) {
            if (gv(view) == a()) {
                this.f3087a = view;
            }
        }

        public boolean fb() {
            return this.f3089gv;
        }

        public int gv(View view) {
            return this.f3090n3.getChildLayoutPosition(view);
        }

        public void i9(int i, int i5) {
            PointF y2;
            RecyclerView recyclerView = this.f3090n3;
            if (this.y == -1 || recyclerView == null) {
                mt();
            }
            if (this.f3089gv && this.f3087a == null && this.f3093zn != null && (y2 = y(this.y)) != null) {
                float f4 = y2.x;
                if (f4 != 0.0f || y2.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f4), (int) Math.signum(y2.y), null);
                }
            }
            this.f3089gv = false;
            View view = this.f3087a;
            if (view != null) {
                if (gv(view) == this.y) {
                    xc(this.f3087a, recyclerView.mState, this.f3088fb);
                    this.f3088fb.zn(recyclerView);
                    mt();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f3087a = null;
                }
            }
            if (this.f3092v) {
                t(i, i5, recyclerView.mState, this.f3088fb);
                boolean y7 = this.f3088fb.y();
                this.f3088fb.zn(recyclerView);
                if (y7 && this.f3092v) {
                    this.f3089gv = true;
                    recyclerView.mViewFlinger.gv();
                }
            }
        }

        public final void mt() {
            if (!this.f3092v) {
                return;
            }
            this.f3092v = false;
            wz();
            this.f3090n3.mState.y = -1;
            this.f3087a = null;
            this.y = -1;
            this.f3089gv = false;
            this.f3093zn.c8(this);
            this.f3093zn = null;
            this.f3090n3 = null;
        }

        public View n3(int i) {
            return this.f3090n3.mLayout.yt(i);
        }

        public void p(RecyclerView recyclerView, w wVar) {
            recyclerView.mViewFlinger.a();
            if (this.f3091s) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f3090n3 = recyclerView;
            this.f3093zn = wVar;
            int i = this.y;
            if (i != -1) {
                recyclerView.mState.y = i;
                this.f3092v = true;
                this.f3089gv = true;
                this.f3087a = n3(a());
                tl();
                this.f3090n3.mViewFlinger.gv();
                this.f3091s = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public boolean s() {
            return this.f3092v;
        }

        public abstract void t(int i, int i5, @NonNull fh fhVar, @NonNull y yVar);

        public abstract void tl();

        @Nullable
        public w v() {
            return this.f3093zn;
        }

        public void w(int i) {
            this.y = i;
        }

        public abstract void wz();

        public abstract void xc(@NonNull View view, @NonNull fh fhVar, @NonNull y yVar);

        @Nullable
        public PointF y(int i) {
            w v2 = v();
            if (v2 instanceof n3) {
                return ((n3) v2).y(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + n3.class.getCanonicalName());
            return null;
        }

        public int zn() {
            return this.f3090n3.mLayout.oz();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        int y(int i, int i5);
    }

    /* loaded from: classes.dex */
    public interface f3 {
        void y(@NonNull ta taVar);
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class fb {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[s.y.values().length];
            y = iArr;
            try {
                iArr[s.y.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[s.y.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class fh {

        /* renamed from: a  reason: collision with root package name */
        public int f3100a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f3101c5;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3102f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f3103fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f3104gv;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f3105i9;

        /* renamed from: n3  reason: collision with root package name */
        public SparseArray<Object> f3106n3;

        /* renamed from: p  reason: collision with root package name */
        public int f3107p;

        /* renamed from: s  reason: collision with root package name */
        public boolean f3108s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f3109t;

        /* renamed from: tl  reason: collision with root package name */
        public int f3110tl;

        /* renamed from: w  reason: collision with root package name */
        public int f3112w;

        /* renamed from: wz  reason: collision with root package name */
        public long f3113wz;

        /* renamed from: xc  reason: collision with root package name */
        public int f3114xc;

        /* renamed from: zn  reason: collision with root package name */
        public int f3115zn;
        public int y = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f3111v = 1;

        public void a(s sVar) {
            this.f3111v = 1;
            this.f3100a = sVar.getItemCount();
            this.f3108s = false;
            this.f3101c5 = false;
            this.f3105i9 = false;
        }

        public boolean fb() {
            return this.f3109t;
        }

        public boolean gv() {
            if (this.y != -1) {
                return true;
            }
            return false;
        }

        public int n3() {
            if (this.f3108s) {
                return this.f3115zn - this.f3104gv;
            }
            return this.f3100a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.y + ", mData=" + this.f3106n3 + ", mItemCount=" + this.f3100a + ", mIsMeasuring=" + this.f3105i9 + ", mPreviousLayoutItemCount=" + this.f3115zn + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3104gv + ", mStructureChanged=" + this.f3103fb + ", mInPreLayout=" + this.f3108s + ", mRunSimpleAnimations=" + this.f3102f + ", mRunPredictiveAnimations=" + this.f3109t + '}';
        }

        public boolean v() {
            return this.f3108s;
        }

        public void y(int i) {
            if ((this.f3111v & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f3111v));
        }

        public int zn() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements mt.n3 {
        public gv() {
        }

        @Override // androidx.recyclerview.widget.mt.n3
        public void gv(ta taVar, @NonNull tl.zn znVar, @NonNull tl.zn znVar2) {
            taVar.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.n3(taVar, taVar, znVar, znVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.gv(taVar, znVar, znVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }

        @Override // androidx.recyclerview.widget.mt.n3
        public void n3(ta taVar) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.ic(taVar.itemView, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.mt.n3
        public void y(ta taVar, tl.zn znVar, tl.zn znVar2) {
            RecyclerView.this.animateAppearance(taVar, znVar, znVar2);
        }

        @Override // androidx.recyclerview.widget.mt.n3
        public void zn(ta taVar, @NonNull tl.zn znVar, @Nullable tl.zn znVar2) {
            RecyclerView.this.mRecycler.a8(taVar);
            RecyclerView.this.animateDisappearance(taVar, znVar, znVar2);
        }
    }

    /* loaded from: classes.dex */
    public final class i4 {

        /* renamed from: a  reason: collision with root package name */
        public int f3116a;

        /* renamed from: fb  reason: collision with root package name */
        public x4 f3117fb;

        /* renamed from: gv  reason: collision with root package name */
        public final List<ta> f3118gv;

        /* renamed from: n3  reason: collision with root package name */
        public ArrayList<ta> f3119n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3121v;
        public final ArrayList<ta> y;

        /* renamed from: zn  reason: collision with root package name */
        public final ArrayList<ta> f3122zn;

        public i4() {
            ArrayList<ta> arrayList = new ArrayList<>();
            this.y = arrayList;
            this.f3119n3 = null;
            this.f3122zn = new ArrayList<>();
            this.f3118gv = Collections.unmodifiableList(arrayList);
            this.f3121v = 2;
            this.f3116a = 2;
        }

        public int a(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.n3()) {
                if (!RecyclerView.this.mState.v()) {
                    return i;
                }
                return RecyclerView.this.mAdapterHelper.tl(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.n3() + RecyclerView.this.exceptionLabel());
        }

        public void a8(ta taVar) {
            if (taVar.mInChangeScrap) {
                this.f3119n3.remove(taVar);
            } else {
                this.y.remove(taVar);
            }
            taVar.mScrapContainer = null;
            taVar.mInChangeScrap = false;
            taVar.clearReturnedFromScrapFlag();
        }

        public boolean b(ta taVar) {
            if (taVar.isRemoved()) {
                return RecyclerView.this.mState.v();
            }
            int i = taVar.mPosition;
            if (i >= 0 && i < RecyclerView.this.mAdapter.getItemCount()) {
                if (!RecyclerView.this.mState.v() && RecyclerView.this.mAdapter.getItemViewType(taVar.mPosition) != taVar.getItemViewType()) {
                    return false;
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && taVar.getItemId() != RecyclerView.this.mAdapter.getItemId(taVar.mPosition)) {
                    return false;
                }
                return true;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + taVar + RecyclerView.this.exceptionLabel());
        }

        public void c() {
            for (int size = this.f3122zn.size() - 1; size >= 0; size--) {
                d0(size);
            }
            this.f3122zn.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.n3();
            }
        }

        public x4 c5() {
            if (this.f3117fb == null) {
                this.f3117fb = new x4();
            }
            return this.f3117fb;
        }

        public void co() {
            int size = this.f3122zn.size();
            for (int i = 0; i < size; i++) {
                p pVar = (p) this.f3122zn.get(i).itemView.getLayoutParams();
                if (pVar != null) {
                    pVar.f3129fb = true;
                }
            }
        }

        public void d(rz rzVar) {
        }

        public void d0(int i) {
            y(this.f3122zn.get(i), true);
            this.f3122zn.remove(i);
        }

        public final boolean ej(@NonNull ta taVar, int i, int i5, long j2) {
            taVar.mBindingAdapter = null;
            taVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = taVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f3117fb.t(itemViewType, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(taVar, i);
            this.f3117fb.gv(taVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            n3(taVar);
            if (RecyclerView.this.mState.v()) {
                taVar.mPreLayoutPosition = i5;
                return true;
            }
            return true;
        }

        @NonNull
        public List<ta> f() {
            return this.f3118gv;
        }

        public void f3(s sVar, s sVar2, boolean z2) {
            zn();
            c5().s(sVar, sVar2, z2);
        }

        public void fb(@NonNull ta taVar) {
            f3 f3Var = RecyclerView.this.mRecyclerListener;
            if (f3Var != null) {
                f3Var.y(taVar);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i = 0; i < size; i++) {
                RecyclerView.this.mRecyclerListeners.get(i).y(taVar);
            }
            s sVar = RecyclerView.this.mAdapter;
            if (sVar != null) {
                sVar.onViewRecycled(taVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.p(taVar);
            }
        }

        public void fh(@NonNull View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            rz(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.i9(childViewHolderInt);
            }
        }

        public void gv() {
            int size = this.f3122zn.size();
            for (int i = 0; i < size; i++) {
                this.f3122zn.get(i).clearOldPosition();
            }
            int size2 = this.y.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.y.get(i5).clearOldPosition();
            }
            ArrayList<ta> arrayList = this.f3119n3;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    this.f3119n3.get(i6).clearOldPosition();
                }
            }
        }

        public void i4(int i, int i5, boolean z2) {
            int i6 = i + i5;
            for (int size = this.f3122zn.size() - 1; size >= 0; size--) {
                ta taVar = this.f3122zn.get(size);
                if (taVar != null) {
                    int i8 = taVar.mPosition;
                    if (i8 >= i6) {
                        taVar.offsetPosition(-i5, z2);
                    } else if (i8 >= i) {
                        taVar.addFlags(8);
                        d0(size);
                    }
                }
            }
        }

        public int i9() {
            return this.y.size();
        }

        public void k5(int i, int i5) {
            int i6;
            int i8 = i5 + i;
            for (int size = this.f3122zn.size() - 1; size >= 0; size--) {
                ta taVar = this.f3122zn.get(size);
                if (taVar != null && (i6 = taVar.mPosition) >= i && i6 < i8) {
                    taVar.addFlags(2);
                    d0(size);
                }
            }
        }

        public void mg(View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f3119n3 == null) {
                    this.f3119n3 = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f3119n3.add(childViewHolderInt);
            } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            } else {
                childViewHolderInt.setScrapContainer(this, false);
                this.y.add(childViewHolderInt);
            }
        }

        public final void mt(ta taVar) {
            View view = taVar.itemView;
            if (view instanceof ViewGroup) {
                p((ViewGroup) view, false);
            }
        }

        public void n(View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            rz(childViewHolderInt);
        }

        public final void n3(ta taVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = taVar.itemView;
                if (hw.i4.rz(view) == 0) {
                    hw.i4.o0(view, 1);
                }
                androidx.recyclerview.widget.tl tlVar = RecyclerView.this.mAccessibilityDelegate;
                if (tlVar == null) {
                    return;
                }
                hw.y wz2 = tlVar.wz();
                if (wz2 instanceof tl.y) {
                    ((tl.y) wz2).xc(view);
                }
                hw.i4.g3(view, wz2);
            }
        }

        public final void p(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    p((ViewGroup) childAt, true);
                }
            }
            if (!z2) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void r(int i, int i5) {
            int size = this.f3122zn.size();
            for (int i6 = 0; i6 < size; i6++) {
                ta taVar = this.f3122zn.get(i6);
                if (taVar != null && taVar.mPosition >= i) {
                    taVar.offsetPosition(i5, false);
                }
            }
        }

        public void rz(ta taVar) {
            boolean z2;
            boolean z3;
            boolean z4 = false;
            boolean z5 = true;
            if (!taVar.isScrap() && taVar.itemView.getParent() == null) {
                if (!taVar.isTmpDetached()) {
                    if (!taVar.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = taVar.doesTransientStatePreventRecycling();
                        s sVar = RecyclerView.this.mAdapter;
                        if (sVar != null && doesTransientStatePreventRecycling && sVar.onFailedToRecycleView(taVar)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 || taVar.isRecyclable()) {
                            if (this.f3116a > 0 && !taVar.hasAnyOfTheFlags(526)) {
                                int size = this.f3122zn.size();
                                if (size >= this.f3116a && size > 0) {
                                    d0(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.gv(taVar.mPosition)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.mPrefetchRegistry.gv(this.f3122zn.get(i).mPosition)) {
                                            break;
                                        }
                                        i--;
                                    }
                                    size = i + 1;
                                }
                                this.f3122zn.add(size, taVar);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                y(taVar, true);
                                z4 = z3;
                                RecyclerView.this.mViewInfoStore.p(taVar);
                                if (z4 && !z5 && doesTransientStatePreventRecycling) {
                                    taVar.mBindingAdapter = null;
                                    taVar.mOwnerRecyclerView = null;
                                    return;
                                }
                                return;
                            }
                            z4 = z3;
                        }
                        z5 = false;
                        RecyclerView.this.mViewInfoStore.p(taVar);
                        if (z4) {
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + taVar + RecyclerView.this.exceptionLabel());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(taVar.isScrap());
            sb.append(" isAttached:");
            if (taVar.itemView.getParent() != null) {
                z4 = true;
            }
            sb.append(z4);
            sb.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }

        public ta s(int i) {
            int size;
            int tl2;
            ArrayList<ta> arrayList = this.f3119n3;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    ta taVar = this.f3119n3.get(i5);
                    if (!taVar.wasReturnedFromScrap() && taVar.getLayoutPosition() == i) {
                        taVar.addFlags(32);
                        return taVar;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (tl2 = RecyclerView.this.mAdapterHelper.tl(i)) > 0 && tl2 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(tl2);
                    for (int i6 = 0; i6 < size; i6++) {
                        ta taVar2 = this.f3119n3.get(i6);
                        if (!taVar2.wasReturnedFromScrap() && taVar2.getItemId() == itemId) {
                            taVar2.addFlags(32);
                            return taVar2;
                        }
                    }
                }
            }
            return null;
        }

        public ta t(long j2, int i, boolean z2) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                ta taVar = this.y.get(size);
                if (taVar.getItemId() == j2 && !taVar.wasReturnedFromScrap()) {
                    if (i == taVar.getItemViewType()) {
                        taVar.addFlags(32);
                        if (taVar.isRemoved() && !RecyclerView.this.mState.v()) {
                            taVar.setFlags(2, 14);
                        }
                        return taVar;
                    } else if (!z2) {
                        this.y.remove(size);
                        RecyclerView.this.removeDetachedView(taVar.itemView, false);
                        n(taVar.itemView);
                    }
                }
            }
            int size2 = this.f3122zn.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ta taVar2 = this.f3122zn.get(size2);
                if (taVar2.getItemId() == j2 && !taVar2.isAttachedToTransitionOverlay()) {
                    if (i == taVar2.getItemViewType()) {
                        if (!z2) {
                            this.f3122zn.remove(size2);
                        }
                        return taVar2;
                    } else if (!z2) {
                        d0(size2);
                        return null;
                    }
                }
            }
        }

        public void ta(x4 x4Var) {
            x4 x4Var2 = this.f3117fb;
            if (x4Var2 != null) {
                x4Var2.zn();
            }
            this.f3117fb = x4Var;
            if (x4Var != null && RecyclerView.this.getAdapter() != null) {
                this.f3117fb.y();
            }
        }

        public ta tl(int i, boolean z2) {
            View v2;
            int size = this.y.size();
            for (int i5 = 0; i5 < size; i5++) {
                ta taVar = this.y.get(i5);
                if (!taVar.wasReturnedFromScrap() && taVar.getLayoutPosition() == i && !taVar.isInvalid() && (RecyclerView.this.mState.f3108s || !taVar.isRemoved())) {
                    taVar.addFlags(32);
                    return taVar;
                }
            }
            if (!z2 && (v2 = RecyclerView.this.mChildHelper.v(i)) != null) {
                ta childViewHolderInt = RecyclerView.getChildViewHolderInt(v2);
                RecyclerView.this.mChildHelper.co(v2);
                int tl2 = RecyclerView.this.mChildHelper.tl(v2);
                if (tl2 != -1) {
                    RecyclerView.this.mChildHelper.gv(tl2);
                    mg(v2);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.f3122zn.size();
            for (int i6 = 0; i6 < size2; i6++) {
                ta taVar2 = this.f3122zn.get(i6);
                if (!taVar2.isInvalid() && taVar2.getLayoutPosition() == i && !taVar2.isAttachedToTransitionOverlay()) {
                    if (!z2) {
                        this.f3122zn.remove(i6);
                    }
                    return taVar2;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d4 A[ADDED_TO_REGION] */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.ta ud(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i4.ud(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ta");
        }

        public void v() {
            this.y.clear();
            ArrayList<ta> arrayList = this.f3119n3;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public View w(int i, boolean z2) {
            return ud(i, z2, Long.MAX_VALUE).itemView;
        }

        public View wz(int i) {
            return this.y.get(i).itemView;
        }

        public void x() {
            int i;
            w wVar = RecyclerView.this.mLayout;
            if (wVar != null) {
                i = wVar.f3152n;
            } else {
                i = 0;
            }
            this.f3116a = this.f3121v + i;
            for (int size = this.f3122zn.size() - 1; size >= 0 && this.f3122zn.size() > this.f3116a; size--) {
                d0(size);
            }
        }

        public void x4(int i, int i5) {
            int i6;
            int i8;
            int i10;
            int i11;
            if (i < i5) {
                i6 = -1;
                i10 = i;
                i8 = i5;
            } else {
                i6 = 1;
                i8 = i;
                i10 = i5;
            }
            int size = this.f3122zn.size();
            for (int i12 = 0; i12 < size; i12++) {
                ta taVar = this.f3122zn.get(i12);
                if (taVar != null && (i11 = taVar.mPosition) >= i10 && i11 <= i8) {
                    if (i11 == i) {
                        taVar.offsetPosition(i5 - i, false);
                    } else {
                        taVar.offsetPosition(i6, false);
                    }
                }
            }
        }

        @NonNull
        public View xc(int i) {
            return w(i, false);
        }

        public void y(@NonNull ta taVar, boolean z2) {
            hw.y yVar;
            RecyclerView.clearNestedRecyclerViewIfNotNested(taVar);
            View view = taVar.itemView;
            androidx.recyclerview.widget.tl tlVar = RecyclerView.this.mAccessibilityDelegate;
            if (tlVar != null) {
                hw.y wz2 = tlVar.wz();
                if (wz2 instanceof tl.y) {
                    yVar = ((tl.y) wz2).wz(view);
                } else {
                    yVar = null;
                }
                hw.i4.g3(view, yVar);
            }
            if (z2) {
                fb(taVar);
            }
            taVar.mBindingAdapter = null;
            taVar.mOwnerRecyclerView = null;
            c5().c5(taVar);
        }

        public void z() {
            int size = this.f3122zn.size();
            for (int i = 0; i < size; i++) {
                ta taVar = this.f3122zn.get(i);
                if (taVar != null) {
                    taVar.addFlags(6);
                    taVar.addChangePayload(null);
                }
            }
            s sVar = RecyclerView.this.mAdapter;
            if (sVar == null || !sVar.hasStableIds()) {
                c();
            }
        }

        public void z6(int i) {
            this.f3121v = i;
            x();
        }

        public void zn() {
            this.y.clear();
            c();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i9 {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i5) {
        }

        public void onItemRangeInserted(int i, int i5) {
        }

        public void onItemRangeMoved(int i, int i5, int i6) {
        }

        public void onItemRangeRemoved(int i, int i5) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i, int i5, @Nullable Object obj) {
            onItemRangeChanged(i, i5);
        }
    }

    /* loaded from: classes.dex */
    public class mg implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public boolean f3123f;

        /* renamed from: fb  reason: collision with root package name */
        public OverScroller f3124fb;

        /* renamed from: s  reason: collision with root package name */
        public Interpolator f3125s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f3126t;

        /* renamed from: v  reason: collision with root package name */
        public int f3127v;
        public int y;

        public mg() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f3125s = interpolator;
            this.f3124fb = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            RecyclerView.this.removeCallbacks(this);
            this.f3124fb.abortAnimation();
        }

        public void gv() {
            if (this.f3123f) {
                this.f3126t = true;
            } else {
                zn();
            }
        }

        public void n3(int i, int i5) {
            RecyclerView.this.setScrollState(2);
            this.f3127v = 0;
            this.y = 0;
            Interpolator interpolator = this.f3125s;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f3125s = interpolator2;
                this.f3124fb = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f3124fb.fling(0, 0, i, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            gv();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i5;
            boolean z2;
            boolean z3;
            boolean z4;
            int i6;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                a();
                return;
            }
            this.f3126t = false;
            this.f3123f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f3124fb;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i8 = currX - this.y;
                int i10 = currY - this.f3127v;
                this.y = currX;
                this.f3127v = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i8, i10, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i8 -= iArr2[0];
                    i10 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i8, i10);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i8, i10, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i5 = iArr4[0];
                    i = iArr4[1];
                    i8 -= i5;
                    i10 -= i;
                    d0 d0Var = recyclerView4.mLayout.f3158w;
                    if (d0Var != null && !d0Var.fb() && d0Var.s()) {
                        int n32 = RecyclerView.this.mState.n3();
                        if (n32 == 0) {
                            d0Var.mt();
                        } else if (d0Var.a() >= n32) {
                            d0Var.w(n32 - 1);
                            d0Var.i9(i5, i);
                        } else {
                            d0Var.i9(i5, i);
                        }
                    }
                } else {
                    i = 0;
                    i5 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i5, i, i8, i10, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i11 = i8 - iArr6[0];
                int i12 = i10 - iArr6[1];
                if (i5 != 0 || i != 0) {
                    recyclerView6.dispatchOnScrolled(i5, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!overScroller.isFinished() && ((!z2 && i11 == 0) || (!z3 && i12 == 0))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                d0 d0Var2 = RecyclerView.this.mLayout.f3158w;
                if ((d0Var2 == null || !d0Var2.fb()) && z4) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i11 < 0) {
                            i6 = -currVelocity;
                        } else if (i11 > 0) {
                            i6 = currVelocity;
                        } else {
                            i6 = 0;
                        }
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i6, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.n3();
                    }
                } else {
                    gv();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.a aVar = recyclerView7.mGapWorker;
                    if (aVar != null) {
                        aVar.a(recyclerView7, i5, i);
                    }
                }
            }
            d0 d0Var3 = RecyclerView.this.mLayout.f3158w;
            if (d0Var3 != null && d0Var3.fb()) {
                d0Var3.i9(0, 0);
            }
            this.f3123f = false;
            if (this.f3126t) {
                zn();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        public void v(int i, int i5, int i6, @Nullable Interpolator interpolator) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = y(i, i5);
            }
            int i8 = i6;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f3125s != interpolator) {
                this.f3125s = interpolator;
                this.f3124fb = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f3127v = 0;
            this.y = 0;
            RecyclerView.this.setScrollState(2);
            this.f3124fb.startScroll(0, 0, i, i5, i8);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3124fb.computeScrollOffset();
            }
            gv();
        }

        public final int y(int i, int i5) {
            boolean z2;
            int height;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i5);
            if (abs > abs2) {
                z2 = true;
            } else {
                z2 = false;
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (z2) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            if (!z2) {
                abs = abs2;
            }
            return Math.min((int) (((abs / height) + 1.0f) * 300.0f), 2000);
        }

        public final void zn() {
            RecyclerView.this.removeCallbacks(this);
            hw.i4.nf(RecyclerView.this, this);
        }
    }

    /* loaded from: classes.dex */
    public interface mt {
        void n3(@NonNull View view);

        void y(@NonNull View view);
    }

    /* loaded from: classes.dex */
    public class n extends i9 {
        public n() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f3103fb = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.w()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeChanged(int i, int i5, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.mt(i, i5, obj)) {
                y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeInserted(int i, int i5) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.co(i, i5)) {
                y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeMoved(int i, int i5, int i6) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.z(i, i5, i6)) {
                y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onItemRangeRemoved(int i, int i5) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.r(i, i5)) {
                y();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public void onStateRestorationPolicyChanged() {
            s sVar;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (sVar = recyclerView.mAdapter) != null && sVar.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void y() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    hw.i4.nf(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tl tlVar = RecyclerView.this.mItemAnimator;
            if (tlVar != null) {
                tlVar.r();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class r {
        public void n3(@NonNull RecyclerView recyclerView, int i, int i5) {
        }

        public void y(@NonNull RecyclerView recyclerView, int i) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class rz {
    }

    /* loaded from: classes.dex */
    public static abstract class s<VH extends ta> {
        private final c5 mObservable = new c5();
        private boolean mHasStableIds = false;
        private y mStateRestorationPolicy = y.ALLOW;

        /* loaded from: classes.dex */
        public enum y {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(@NonNull VH vh, int i) {
            boolean z2;
            if (vh.mBindingAdapter == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, 519);
                b.xc.y("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z2) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof p) {
                    ((p) layoutParams).f3129fb = true;
                }
                b.xc.n3();
            }
        }

        public boolean canRestoreState() {
            int i = fb.y[this.mStateRestorationPolicy.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2 && getItemCount() <= 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                b.xc.y("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                b.xc.n3();
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull s<? extends ta> sVar, @NonNull ta taVar, int i) {
            if (sVar == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        @NonNull
        public final y getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.y();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.n3();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.gv(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.a(i, 1);
        }

        public final void notifyItemMoved(int i, int i5) {
            this.mObservable.zn(i, i5);
        }

        public final void notifyItemRangeChanged(int i, int i5) {
            this.mObservable.gv(i, i5);
        }

        public final void notifyItemRangeInserted(int i, int i5) {
            this.mObservable.a(i, i5);
        }

        public final void notifyItemRangeRemoved(int i, int i5) {
            this.mObservable.fb(i, i5);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.fb(i, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull i9 i9Var) {
            this.mObservable.registerObserver(i9Var);
        }

        public void setHasStableIds(boolean z2) {
            if (!hasObservers()) {
                this.mHasStableIds = z2;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(@NonNull y yVar) {
            this.mStateRestorationPolicy = yVar;
            this.mObservable.s();
        }

        public void unregisterAdapterDataObserver(@NonNull i9 i9Var) {
            this.mObservable.unregisterObserver(i9Var);
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.mObservable.v(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i5, @Nullable Object obj) {
            this.mObservable.v(i, i5, obj);
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        @NonNull
        public EdgeEffect y(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ta {
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        @NonNull
        public final View itemView;
        s<? extends ta> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;
        i4 mScrapContainer;
        ta mShadowedHolder;
        ta mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        int mPendingAccessibilityState = -1;

        public ta(@NonNull View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0 && hw.i4.j(this.itemView)) {
                return true;
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int i, int i5, boolean z2) {
            addFlags(8);
            offsetPosition(i5, z2);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final s<? extends ta> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            s adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int i) {
            if ((i & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0 && !isInvalid()) {
                return false;
            }
            return true;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                return true;
            }
            return false;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0 && !hw.i4.j(this.itemView)) {
                return true;
            }
            return false;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public void offsetPosition(int i, boolean z2) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z2) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((p) this.itemView.getLayoutParams()).f3129fb = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = hw.i4.rz(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i5) {
            this.mFlags = (i & i5) | (this.mFlags & (~i5));
        }

        public final void setIsRecyclable(boolean z2) {
            int i;
            int i5 = this.mIsRecyclableCount;
            if (z2) {
                i = i5 - 1;
            } else {
                i = i5 + 1;
            }
            this.mIsRecyclableCount = i;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z2 && i == 1) {
                this.mFlags |= 16;
            } else if (z2 && i == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(i4 i4Var, boolean z2) {
            this.mScrapContainer = i4Var;
            this.mInChangeScrap = z2;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                return true;
            }
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb.append(str);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.a8(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class tl {
        public n3 y;

        /* renamed from: n3  reason: collision with root package name */
        public ArrayList<y> f3137n3 = new ArrayList<>();

        /* renamed from: zn  reason: collision with root package name */
        public long f3139zn = 120;

        /* renamed from: gv  reason: collision with root package name */
        public long f3136gv = 120;

        /* renamed from: v  reason: collision with root package name */
        public long f3138v = 250;

        /* renamed from: a  reason: collision with root package name */
        public long f3135a = 250;

        /* loaded from: classes.dex */
        public interface n3 {
            void y(@NonNull ta taVar);
        }

        /* loaded from: classes.dex */
        public interface y {
            void y();
        }

        /* loaded from: classes.dex */
        public static class zn {

            /* renamed from: gv  reason: collision with root package name */
            public int f3140gv;

            /* renamed from: n3  reason: collision with root package name */
            public int f3141n3;
            public int y;

            /* renamed from: zn  reason: collision with root package name */
            public int f3142zn;

            @NonNull
            public zn n3(@NonNull ta taVar, int i) {
                View view = taVar.itemView;
                this.y = view.getLeft();
                this.f3141n3 = view.getTop();
                this.f3142zn = view.getRight();
                this.f3140gv = view.getBottom();
                return this;
            }

            @NonNull
            public zn y(@NonNull ta taVar) {
                return n3(taVar, 0);
            }
        }

        public static int v(ta taVar) {
            int i = taVar.mFlags;
            int i5 = i & 14;
            if (taVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = taVar.getOldPosition();
                int absoluteAdapterPosition = taVar.getAbsoluteAdapterPosition();
                if (oldPosition != -1 && absoluteAdapterPosition != -1 && oldPosition != absoluteAdapterPosition) {
                    return i5 | 2048;
                }
                return i5;
            }
            return i5;
        }

        public abstract boolean a(@NonNull ta taVar);

        public void c(long j2) {
            this.f3136gv = j2;
        }

        public final void c5() {
            int size = this.f3137n3.size();
            for (int i = 0; i < size; i++) {
                this.f3137n3.get(i).y();
            }
            this.f3137n3.clear();
        }

        @NonNull
        public zn co(@NonNull fh fhVar, @NonNull ta taVar) {
            return p().y(taVar);
        }

        public abstract void f();

        public void f3(n3 n3Var) {
            this.y = n3Var;
        }

        public boolean fb(@NonNull ta taVar, @NonNull List<Object> list) {
            return a(taVar);
        }

        public abstract boolean gv(@NonNull ta taVar, @NonNull zn znVar, @NonNull zn znVar2);

        public void i4(long j2) {
            this.f3135a = j2;
        }

        public abstract void i9(@NonNull ta taVar);

        public void mt(@NonNull ta taVar) {
        }

        public void n(long j2) {
            this.f3138v = j2;
        }

        public abstract boolean n3(@NonNull ta taVar, @NonNull ta taVar2, @NonNull zn znVar, @NonNull zn znVar2);

        @NonNull
        public zn p() {
            return new zn();
        }

        public abstract void r();

        public final void s(@NonNull ta taVar) {
            mt(taVar);
            n3 n3Var = this.y;
            if (n3Var != null) {
                n3Var.y(taVar);
            }
        }

        public long t() {
            return this.f3139zn;
        }

        public long tl() {
            return this.f3135a;
        }

        public abstract boolean w();

        public long wz() {
            return this.f3138v;
        }

        public void x4(long j2) {
            this.f3139zn = j2;
        }

        public long xc() {
            return this.f3136gv;
        }

        public abstract boolean y(@NonNull ta taVar, @Nullable zn znVar, @NonNull zn znVar2);

        @NonNull
        public zn z(@NonNull fh fhVar, @NonNull ta taVar, int i, @NonNull List<Object> list) {
            return p().y(taVar);
        }

        public abstract boolean zn(@NonNull ta taVar, @NonNull zn znVar, @Nullable zn znVar2);
    }

    /* loaded from: classes.dex */
    public class v implements n3.InterfaceC0025n3 {
        public v() {
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void a() {
            int zn2 = zn();
            for (int i = 0; i < zn2; i++) {
                View y = y(i);
                RecyclerView.this.dispatchChildDetached(y);
                y.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void addView(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void c5(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public int fb(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public ta gv(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void i9(View view, int i, ViewGroup.LayoutParams layoutParams) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void n3(View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void s(View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public void v(int i) {
            ta childViewHolderInt;
            View y = y(i);
            if (y != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(y)) != null) {
                if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public View y(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.n3.InterfaceC0025n3
        public int zn() {
            return RecyclerView.this.getChildCount();
        }
    }

    /* loaded from: classes.dex */
    public class wz implements tl.n3 {
        public wz() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.tl.n3
        public void y(ta taVar) {
            taVar.setIsRecyclable(true);
            if (taVar.mShadowedHolder != null && taVar.mShadowingHolder == null) {
                taVar.mShadowedHolder = null;
            }
            taVar.mShadowingHolder = null;
            if (!taVar.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(taVar.itemView) && taVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(taVar.itemView, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class x4 {
        public SparseArray<y> y = new SparseArray<>();

        /* renamed from: n3  reason: collision with root package name */
        public int f3163n3 = 0;

        /* loaded from: classes.dex */
        public static class y {
            public final ArrayList<ta> y = new ArrayList<>();

            /* renamed from: n3  reason: collision with root package name */
            public int f3165n3 = 5;

            /* renamed from: zn  reason: collision with root package name */
            public long f3166zn = 0;

            /* renamed from: gv  reason: collision with root package name */
            public long f3164gv = 0;
        }

        @Nullable
        public ta a(int i) {
            y yVar = this.y.get(i);
            if (yVar != null && !yVar.y.isEmpty()) {
                ArrayList<ta> arrayList = yVar.y;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                        return arrayList.remove(size);
                    }
                }
                return null;
            }
            return null;
        }

        public void c5(ta taVar) {
            int itemViewType = taVar.getItemViewType();
            ArrayList<ta> arrayList = fb(itemViewType).y;
            if (this.y.get(itemViewType).f3165n3 <= arrayList.size()) {
                return;
            }
            taVar.resetInternal();
            arrayList.add(taVar);
        }

        public void f(int i, int i5) {
            y fb2 = fb(i);
            fb2.f3165n3 = i5;
            ArrayList<ta> arrayList = fb2.y;
            while (arrayList.size() > i5) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public final y fb(int i) {
            y yVar = this.y.get(i);
            if (yVar == null) {
                y yVar2 = new y();
                this.y.put(i, yVar2);
                return yVar2;
            }
            return yVar;
        }

        public void gv(int i, long j2) {
            y fb2 = fb(i);
            fb2.f3164gv = i9(fb2.f3164gv, j2);
        }

        public long i9(long j2, long j4) {
            if (j2 == 0) {
                return j4;
            }
            return ((j2 / 4) * 3) + (j4 / 4);
        }

        public void n3() {
            for (int i = 0; i < this.y.size(); i++) {
                this.y.valueAt(i).y.clear();
            }
        }

        public void s(s sVar, s sVar2, boolean z2) {
            if (sVar != null) {
                zn();
            }
            if (!z2 && this.f3163n3 == 0) {
                n3();
            }
            if (sVar2 != null) {
                y();
            }
        }

        public boolean t(int i, long j2, long j4) {
            long j6 = fb(i).f3164gv;
            if (j6 != 0 && j2 + j6 >= j4) {
                return false;
            }
            return true;
        }

        public boolean tl(int i, long j2, long j4) {
            long j6 = fb(i).f3166zn;
            if (j6 != 0 && j2 + j6 >= j4) {
                return false;
            }
            return true;
        }

        public void v(int i, long j2) {
            y fb2 = fb(i);
            fb2.f3166zn = i9(fb2.f3166zn, j2);
        }

        public void y() {
            this.f3163n3++;
        }

        public void zn() {
            this.f3163n3--;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class xc {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull fh fhVar) {
            getItemOffsets(rect, ((p) view.getLayoutParams()).y(), recyclerView);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull fh fhVar) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull fh fhVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface z {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z2);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public class zn implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f6 = f4 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }

    static {
        boolean z2;
        int i = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        if (i >= 23) {
            z2 = true;
        } else {
            z2 = false;
        }
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = z2;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new zn();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    private void addAnimatingView(ta taVar) {
        boolean z2;
        View view = taVar.itemView;
        if (view.getParent() == this) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mRecycler.a8(getChildViewHolder(view));
        if (taVar.isTmpDetached()) {
            this.mChildHelper.zn(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.mChildHelper.n3(view, true);
        } else {
            this.mChildHelper.f(view);
        }
    }

    private void animateChange(@NonNull ta taVar, @NonNull ta taVar2, @NonNull tl.zn znVar, @NonNull tl.zn znVar2, boolean z2, boolean z3) {
        taVar.setIsRecyclable(false);
        if (z2) {
            addAnimatingView(taVar);
        }
        if (taVar != taVar2) {
            if (z3) {
                addAnimatingView(taVar2);
            }
            taVar.mShadowedHolder = taVar2;
            addAnimatingView(taVar);
            this.mRecycler.a8(taVar);
            taVar2.setIsRecyclable(false);
            taVar2.mShadowingHolder = taVar;
        }
        if (this.mItemAnimator.n3(taVar, taVar2, znVar, znVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ta taVar) {
        WeakReference<RecyclerView> weakReference = taVar.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == taVar.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            taVar.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i5) {
        ClassLoader classLoader;
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(w.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i5)};
                    } catch (NoSuchMethodException e2) {
                        objArr = null;
                        try {
                            constructor = asSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((w) constructor.newInstance(objArr));
                } catch (ClassCastException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e5);
                } catch (ClassNotFoundException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e6);
                } catch (IllegalAccessException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e8);
                } catch (InstantiationException e9) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e9);
                } catch (InvocationTargetException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e10);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i, int i5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        if (iArr[0] == i && iArr[1] == i5) {
            return false;
        }
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            j5.n3.n3(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z2 = true;
        this.mState.y(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f3105i9 = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        fh fhVar = this.mState;
        fhVar.f3101c5 = (fhVar.f3102f && this.mItemsChanged) ? false : false;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        fhVar.f3108s = fhVar.f3109t;
        fhVar.f3100a = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f3102f) {
            int fb2 = this.mChildHelper.fb();
            for (int i = 0; i < fb2; i++) {
                ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.a(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.v(childViewHolderInt, this.mItemAnimator.z(this.mState, childViewHolderInt, tl.v(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f3101c5 && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.zn(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f3109t) {
            saveOldPositions();
            fh fhVar2 = this.mState;
            boolean z3 = fhVar2.f3103fb;
            fhVar2.f3103fb = false;
            this.mLayout.gf(this.mRecycler, fhVar2);
            this.mState.f3103fb = z3;
            for (int i5 = 0; i5 < this.mChildHelper.fb(); i5++) {
                ta childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.a(i5));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.c5(childViewHolderInt2)) {
                    int v2 = tl.v(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        v2 |= 4096;
                    }
                    tl.zn z4 = this.mItemAnimator.z(this.mState, childViewHolderInt2, v2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, z4);
                    } else {
                        this.mViewInfoStore.y(childViewHolderInt2, z4);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f3111v = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z2;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.y(6);
        this.mAdapterHelper.i9();
        this.mState.f3100a = this.mAdapter.getItemCount();
        this.mState.f3104gv = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f3086fb;
            if (parcelable != null) {
                this.mLayout.im(parcelable);
            }
            this.mPendingSavedState = null;
        }
        fh fhVar = this.mState;
        fhVar.f3108s = false;
        this.mLayout.gf(this.mRecycler, fhVar);
        fh fhVar2 = this.mState;
        fhVar2.f3103fb = false;
        if (fhVar2.f3102f && this.mItemAnimator != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        fhVar2.f3102f = z2;
        fhVar2.f3111v = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.y(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        fh fhVar = this.mState;
        fhVar.f3111v = 1;
        if (fhVar.f3102f) {
            for (int fb2 = this.mChildHelper.fb() - 1; fb2 >= 0; fb2--) {
                ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.a(fb2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    tl.zn co2 = this.mItemAnimator.co(this.mState, childViewHolderInt);
                    ta fb3 = this.mViewInfoStore.fb(changedHolderKey);
                    if (fb3 != null && !fb3.shouldIgnore()) {
                        boolean s2 = this.mViewInfoStore.s(fb3);
                        boolean s3 = this.mViewInfoStore.s(childViewHolderInt);
                        if (s2 && fb3 == childViewHolderInt) {
                            this.mViewInfoStore.gv(childViewHolderInt, co2);
                        } else {
                            tl.zn wz2 = this.mViewInfoStore.wz(fb3);
                            this.mViewInfoStore.gv(childViewHolderInt, co2);
                            tl.zn tl2 = this.mViewInfoStore.tl(childViewHolderInt);
                            if (wz2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fb3);
                            } else {
                                animateChange(fb3, childViewHolderInt, wz2, tl2, s2, s3);
                            }
                        }
                    } else {
                        this.mViewInfoStore.gv(childViewHolderInt, co2);
                    }
                }
            }
            this.mViewInfoStore.xc(this.mViewInfoProcessCallback);
        }
        this.mLayout.k3(this.mRecycler);
        fh fhVar2 = this.mState;
        fhVar2.f3115zn = fhVar2.f3100a;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        fhVar2.f3102f = false;
        fhVar2.f3109t = false;
        this.mLayout.f3153p = false;
        ArrayList<ta> arrayList = this.mRecycler.f3119n3;
        if (arrayList != null) {
            arrayList.clear();
        }
        w wVar = this.mLayout;
        if (wVar.f3143c) {
            wVar.f3152n = 0;
            wVar.f3143c = false;
            this.mRecycler.x();
        }
        this.mLayout.bv(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        z zVar = this.mInterceptingOnItemTouchListener;
        if (zVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        zVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            z zVar = this.mOnItemTouchListeners.get(i);
            if (zVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = zVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int fb2 = this.mChildHelper.fb();
        if (fb2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < fb2; i6++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.a(i6));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i5) {
                    i5 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i5;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        ta findViewHolderForAdapterPosition;
        fh fhVar = this.mState;
        int i = fhVar.f3110tl;
        if (i == -1) {
            i = 0;
        }
        int n32 = fhVar.n3();
        for (int i5 = i; i5 < n32; i5++) {
            ta findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i5);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(n32, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    public static ta getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).y;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f3131v;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private hw.t getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new hw.t(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, ta taVar, ta taVar2) {
        int fb2 = this.mChildHelper.fb();
        for (int i = 0; i < fb2; i++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.a(i));
            if (childViewHolderInt != taVar && getChangedHolderKey(childViewHolderInt) == j2) {
                s sVar = this.mAdapter;
                if (sVar != null && sVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + taVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + taVar + exceptionLabel());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + taVar2 + " cannot be found but it is necessary for " + taVar + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int fb2 = this.mChildHelper.fb();
        for (int i = 0; i < fb2; i++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.a(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (hw.i4.mg(this) == 0) {
            hw.i4.wf(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.n3(new v());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i5;
        int i6;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        if (this.mLayout.nf() == 1) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        Rect rect = this.mTempRect;
        int i8 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i10 = rect2.left;
        if ((i8 < i10 || rect.right <= i10) && rect.right < rect2.right) {
            i6 = 1;
        } else {
            int i11 = rect.right;
            int i12 = rect2.right;
            if ((i11 > i12 || i8 >= i12) && i8 > i10) {
                i6 = -1;
            } else {
                i6 = 0;
            }
        }
        int i13 = rect.top;
        int i14 = rect2.top;
        if ((i13 < i14 || rect.bottom <= i14) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i15 = rect.bottom;
            int i16 = rect2.bottom;
            if ((i15 <= i16 && i13 < i16) || i13 <= i14) {
                c2 = 0;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i == 130) {
                                if (c2 <= 0) {
                                    return false;
                                }
                                return true;
                            }
                            throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
                        } else if (i6 <= 0) {
                            return false;
                        } else {
                            return true;
                        }
                    } else if (c2 >= 0) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (i6 >= 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (c2 <= 0 && (c2 != 0 || i6 * i5 <= 0)) {
                return false;
            } else {
                return true;
            }
        } else if (c2 >= 0 && (c2 != 0 || i6 * i5 >= 0)) {
            return false;
        } else {
            return true;
        }
    }

    private void nestedScrollByInternal(int i, int i5, @Nullable MotionEvent motionEvent, int i6) {
        int i8;
        int i10;
        int i11;
        int i12;
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            int[] iArr = this.mReusableIntPair;
            int i13 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean r2 = wVar.r();
            boolean x42 = this.mLayout.x4();
            if (x42) {
                i8 = r2 | 2;
            } else {
                i8 = r2;
            }
            startNestedScroll(i8, i6);
            if (r2 != 0) {
                i10 = i;
            } else {
                i10 = 0;
            }
            if (x42) {
                i11 = i5;
            } else {
                i11 = 0;
            }
            if (dispatchNestedPreScroll(i10, i11, this.mReusableIntPair, this.mScrollOffset, i6)) {
                int[] iArr2 = this.mReusableIntPair;
                i -= iArr2[0];
                i5 -= iArr2[1];
            }
            if (r2 != 0) {
                i12 = i;
            } else {
                i12 = 0;
            }
            if (x42) {
                i13 = i5;
            }
            scrollByInternal(i12, i13, motionEvent, i6);
            androidx.recyclerview.widget.a aVar = this.mGapWorker;
            if (aVar != null && (i != 0 || i5 != 0)) {
                aVar.a(this, i, i5);
            }
            stopNestedScroll(i6);
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x2 = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null && this.mLayout.sx()) {
            return true;
        }
        return false;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.n();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.j3(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.i4();
        } else {
            this.mAdapterHelper.i9();
        }
        boolean z5 = true;
        if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
            z2 = false;
        } else {
            z2 = true;
        }
        fh fhVar = this.mState;
        if (this.mFirstLayoutComplete && this.mItemAnimator != null && (((z4 = this.mDataSetHasChangedAfterLayout) || z2 || this.mLayout.f3153p) && (!z4 || this.mAdapter.hasStableIds()))) {
            z3 = true;
        } else {
            z3 = false;
        }
        fhVar.f3102f = z3;
        fh fhVar2 = this.mState;
        fhVar2.f3109t = (fhVar2.f3102f && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) ? false : false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            j.s.zn(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            j.s.zn(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            j.s.zn(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            j.s.zn(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            hw.i4.lc(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        ta taVar;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.fb() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.mChildHelper.wz(focusedChild)) {
                        return;
                    }
                }
                View view = null;
                if (this.mState.f3113wz != -1 && this.mAdapter.hasStableIds()) {
                    taVar = findViewHolderForItemId(this.mState.f3113wz);
                } else {
                    taVar = null;
                }
                if (taVar != null && !this.mChildHelper.wz(taVar.itemView) && taVar.itemView.hasFocusable()) {
                    view = taVar.itemView;
                } else if (this.mChildHelper.fb() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i = this.mState.f3114xc;
                    if (i != -1 && (findViewById = view.findViewById(i)) != null && findViewById.isFocusable()) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            hw.i4.lc(this);
        }
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3;
        boolean z2;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f3129fb) {
                Rect rect = pVar.f3131v;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        w wVar = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z3 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        wVar.dp(this, view, rect3, z3, z2);
    }

    private void resetFocusInfo() {
        fh fhVar = this.mState;
        fhVar.f3113wz = -1L;
        fhVar.f3110tl = -1;
        fhVar.f3114xc = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View view;
        long j2;
        int absoluteAdapterPosition;
        ta taVar = null;
        if (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view != null) {
            taVar = findContainingViewHolder(view);
        }
        if (taVar == null) {
            resetFocusInfo();
            return;
        }
        fh fhVar = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j2 = taVar.getItemId();
        } else {
            j2 = -1;
        }
        fhVar.f3113wz = j2;
        fh fhVar2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            absoluteAdapterPosition = -1;
        } else if (taVar.isRemoved()) {
            absoluteAdapterPosition = taVar.mOldPosition;
        } else {
            absoluteAdapterPosition = taVar.getAbsoluteAdapterPosition();
        }
        fhVar2.f3110tl = absoluteAdapterPosition;
        this.mState.f3114xc = getDeepestFocusedViewWithId(taVar.itemView);
    }

    private void setAdapterInternal(@Nullable s sVar, boolean z2, boolean z3) {
        s sVar2 = this.mAdapter;
        if (sVar2 != null) {
            sVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.n();
        s sVar3 = this.mAdapter;
        this.mAdapter = sVar;
        if (sVar != null) {
            sVar.registerAdapterDataObserver(this.mObserver);
            sVar.onAttachedToRecyclerView(this);
        }
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.oa(sVar3, this.mAdapter);
        }
        this.mRecycler.f3(sVar3, this.mAdapter, z2);
        this.mState.f3103fb = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.a();
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.fq();
        }
    }

    public void absorbGlows(int i, int i5) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i5 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i5);
            }
        } else if (i5 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i5);
            }
        }
        if (i != 0 || i5 != 0) {
            hw.i4.lc(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i5) {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.w9(this, arrayList, i, i5)) {
            super.addFocusables(arrayList, i, i5);
        }
    }

    public void addItemDecoration(@NonNull xc xcVar, int i) {
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.p("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(xcVar);
        } else {
            this.mItemDecorations.add(i, xcVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull mt mtVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(mtVar);
    }

    public void addOnItemTouchListener(@NonNull z zVar) {
        this.mOnItemTouchListeners.add(zVar);
    }

    public void addOnScrollListener(@NonNull r rVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(rVar);
    }

    public void addRecyclerListener(@NonNull f3 f3Var) {
        boolean z2;
        if (f3Var != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        vl.s.n3(z2, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(f3Var);
    }

    public void animateAppearance(@NonNull ta taVar, @Nullable tl.zn znVar, @NonNull tl.zn znVar2) {
        taVar.setIsRecyclable(false);
        if (this.mItemAnimator.y(taVar, znVar, znVar2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(@NonNull ta taVar, @NonNull tl.zn znVar, @Nullable tl.zn znVar2) {
        addAnimatingView(taVar);
        taVar.setIsRecyclable(false);
        if (this.mItemAnimator.zn(taVar, znVar, znVar2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str + exceptionLabel());
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public boolean canReuseUpdatedViewHolder(ta taVar) {
        tl tlVar = this.mItemAnimator;
        if (tlVar != null && !tlVar.fb(taVar, taVar.getUnmodifiedPayloads())) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof p) && this.mLayout.i4((p) layoutParams)) {
            return true;
        }
        return false;
    }

    public void clearOldPositions() {
        int i92 = this.mChildHelper.i9();
        for (int i = 0; i < i92; i++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.gv();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<mt> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.r()) {
            return 0;
        }
        return this.mLayout.d0(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.r()) {
            return 0;
        }
        return this.mLayout.fh(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.r()) {
            return 0;
        }
        return this.mLayout.rz(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.x4()) {
            return 0;
        }
        return this.mLayout.mg(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.x4()) {
            return 0;
        }
        return this.mLayout.ta(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        w wVar = this.mLayout;
        if (wVar == null || !wVar.x4()) {
            return 0;
        }
        return this.mLayout.d(this.mState);
    }

    public void considerReleasingGlowsOnScroll(int i, int i5) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.mLeftGlow.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.mTopGlow.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.mBottomGlow.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            hw.i4.lc(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.w()) {
                return;
            }
            if (this.mAdapterHelper.xc(4) && !this.mAdapterHelper.xc(11)) {
                b.xc.y("RV PartialInvalidate");
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.i4();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.c5();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                b.xc.n3();
                return;
            } else if (this.mAdapterHelper.w()) {
                b.xc.y("RV FullInvalidate");
                dispatchLayout();
                b.xc.n3();
                return;
            } else {
                return;
            }
        }
        b.xc.y("RV FullInvalidate");
        dispatchLayout();
        b.xc.n3();
    }

    public void defaultOnMeasure(int i, int i5) {
        setMeasuredDimension(w.f3(i, getPaddingLeft() + getPaddingRight(), hw.i4.z6(this)), w.f3(i5, getPaddingTop() + getPaddingBottom(), hw.i4.d(this)));
    }

    public void dispatchChildAttached(View view) {
        ta childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        s sVar = this.mAdapter;
        if (sVar != null && childViewHolderInt != null) {
            sVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<mt> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).n3(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        ta childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        s sVar = this.mAdapter;
        if (sVar != null && childViewHolderInt != null) {
            sVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<mt> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).y(view);
            }
        }
    }

    public void dispatchLayout() {
        boolean z2;
        if (this.mAdapter == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.mState.f3105i9 = false;
            if (this.mLastAutoMeasureSkippedDueToExact && (this.mLastAutoMeasureNonExactMeasuredWidth != getWidth() || this.mLastAutoMeasureNonExactMeasuredHeight != getHeight())) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.f3111v == 1) {
                dispatchLayoutStep1();
                this.mLayout.jb(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.p() && !z2 && this.mLayout.g() == getWidth() && this.mLayout.rs() == getHeight()) {
                this.mLayout.jb(this);
            } else {
                this.mLayout.jb(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f6, boolean z2) {
        return getScrollingChildHelper().y(f4, f6, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f6) {
        return getScrollingChildHelper().n3(f4, f6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().zn(i, i5, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i5, int i6, int i8, int[] iArr) {
        return getScrollingChildHelper().a(i, i5, i6, i8, iArr);
    }

    public void dispatchOnScrollStateChanged(int i) {
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.n7(i);
        }
        onScrollStateChanged(i);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.y(this, i);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).y(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i5) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i5);
        onScrolled(i, i5);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.n3(this, i, i5);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).n3(this, i, i5);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ta taVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (taVar.itemView.getParent() == this && !taVar.shouldIgnore() && (i = taVar.mPendingAccessibilityState) != -1) {
                hw.i4.o0(taVar.itemView, i);
                taVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        int i5;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            this.mItemDecorations.get(i6).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z7 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i5 = getPaddingBottom();
            } else {
                i5 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i5, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z2 = true;
            } else {
                z2 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z4 = true;
            } else {
                z4 = false;
            }
            z2 |= z4;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(i, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 |= z3;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z2 |= z5;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.w()) {
            z7 = z2;
        }
        if (z7) {
            hw.i4.lc(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect y2 = this.mEdgeEffectFactory.y(this, 3);
        this.mBottomGlow = y2;
        if (this.mClipToPadding) {
            y2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            y2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect y2 = this.mEdgeEffectFactory.y(this, 0);
        this.mLeftGlow = y2;
        if (this.mClipToPadding) {
            y2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            y2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect y2 = this.mEdgeEffectFactory.y(this, 2);
        this.mRightGlow = y2;
        if (this.mClipToPadding) {
            y2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            y2.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect y2 = this.mEdgeEffectFactory.y(this, 1);
        this.mTopGlow = y2;
        if (this.mClipToPadding) {
            y2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            y2.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(fh fhVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f3124fb;
            fhVar.f3112w = overScroller.getFinalX() - overScroller.getCurrX();
            fhVar.f3107p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        fhVar.f3112w = 0;
        fhVar.f3107p = 0;
    }

    @Nullable
    public View findChildViewUnder(float f4, float f6) {
        for (int fb2 = this.mChildHelper.fb() - 1; fb2 >= 0; fb2--) {
            View a2 = this.mChildHelper.a(fb2);
            float translationX = a2.getTranslationX();
            float translationY = a2.getTranslationY();
            if (f4 >= a2.getLeft() + translationX && f4 <= a2.getRight() + translationX && f6 >= a2.getTop() + translationY && f6 <= a2.getBottom() + translationY) {
                return a2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    @Nullable
    public ta findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ta findViewHolderForAdapterPosition(int i) {
        ta taVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int i92 = this.mChildHelper.i9();
        for (int i5 = 0; i5 < i92; i5++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i5));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                if (this.mChildHelper.wz(childViewHolderInt.itemView)) {
                    taVar = childViewHolderInt;
                } else {
                    return childViewHolderInt;
                }
            }
        }
        return taVar;
    }

    public ta findViewHolderForItemId(long j2) {
        s sVar = this.mAdapter;
        ta taVar = null;
        if (sVar != null && sVar.hasStableIds()) {
            int i92 = this.mChildHelper.i9();
            for (int i = 0; i < i92; i++) {
                ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (this.mChildHelper.wz(childViewHolderInt.itemView)) {
                        taVar = childViewHolderInt;
                    } else {
                        return childViewHolderInt;
                    }
                }
            }
        }
        return taVar;
    }

    @Nullable
    public ta findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Nullable
    @Deprecated
    public ta findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i, int i5) {
        boolean z2;
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            int r2 = wVar.r();
            boolean x42 = this.mLayout.x4();
            i = (r2 == 0 || Math.abs(i) < this.mMinFlingVelocity) ? 0 : 0;
            i5 = (!x42 || Math.abs(i5) < this.mMinFlingVelocity) ? 0 : 0;
            if (i == 0 && i5 == 0) {
                return false;
            }
            float f4 = i;
            float f6 = i5;
            if (!dispatchNestedPreFling(f4, f6)) {
                if (r2 == 0 && !x42) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                dispatchNestedFling(f4, f6, z2);
                co coVar = this.mOnFlingListener;
                if (coVar != null && coVar.y(i, i5)) {
                    return true;
                }
                if (z2) {
                    if (x42) {
                        r2 = (r2 == true ? 1 : 0) | 2;
                    }
                    startNestedScroll(r2, 1);
                    int i6 = this.mMaxFlingVelocity;
                    int max = Math.max(-i6, Math.min(i, i6));
                    int i8 = this.mMaxFlingVelocity;
                    this.mViewFlinger.n3(max, Math.max(-i8, Math.min(i5, i8)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        boolean z2;
        View view2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        View i32 = this.mLayout.i3(view, i);
        if (i32 != null) {
            return i32;
        }
        boolean z7 = true;
        if (this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed) {
            z2 = true;
        } else {
            z2 = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.mLayout.x4()) {
                if (i == 2) {
                    i6 = 130;
                } else {
                    i6 = 33;
                }
                if (focusFinder.findNextFocus(this, view, i6) == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i6;
                }
            } else {
                z3 = false;
            }
            if (!z3 && this.mLayout.r()) {
                if (this.mLayout.nf() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 ^ z5) {
                    i5 = 66;
                } else {
                    i5 = 17;
                }
                if (focusFinder.findNextFocus(this, view, i5) != null) {
                    z7 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i5;
                }
                z3 = z7;
            }
            if (z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.mp(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.mp(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            requestChildOnScreen(view2, null);
            return view;
        } else if (!isPreferredNextFocus(view, view2, i)) {
            return super.focusSearch(view, i);
        } else {
            return view2;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        w wVar = this.mLayout;
        if (wVar != null) {
            return wVar.vl();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        w wVar = this.mLayout;
        if (wVar != null) {
            return wVar.hw(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public s getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ta taVar) {
        if (!taVar.hasAnyOfTheFlags(524) && taVar.isBound()) {
            return this.mAdapterHelper.v(taVar.mPosition);
        }
        return -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        w wVar = this.mLayout;
        if (wVar != null) {
            return wVar.qn();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(ta taVar) {
        if (this.mAdapter.hasStableIds()) {
            return taVar.getItemId();
        }
        return taVar.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ta childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i5) {
        f fVar = this.mChildDrawingOrderCallback;
        if (fVar == null) {
            return super.getChildDrawingOrder(i, i5);
        }
        return fVar.y(i, i5);
    }

    public long getChildItemId(@NonNull View view) {
        ta childViewHolderInt;
        s sVar = this.mAdapter;
        if (sVar == null || !sVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ta childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ta getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public androidx.recyclerview.widget.tl getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public t getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public tl getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f3129fb) {
            return pVar.f3131v;
        }
        if (this.mState.v() && (pVar.n3() || pVar.gv())) {
            return pVar.f3131v;
        }
        Rect rect = pVar.f3131v;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i5 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i5 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f3129fb = false;
        return rect;
    }

    @NonNull
    public xc getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public w getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public co getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public x4 getRecycledViewPool() {
        return this.mRecycler.c5();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.w()) {
            return false;
        }
        return true;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.y(new a());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.v(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.p("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isAnimating() {
        tl tlVar = this.mItemAnimator;
        if (tlVar != null && tlVar.w()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().tl();
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.xq(i);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int i92 = this.mChildHelper.i9();
        for (int i = 0; i < i92; i++) {
            ((p) this.mChildHelper.c5(i).getLayoutParams()).f3129fb = true;
        }
        this.mRecycler.co();
    }

    public void markKnownViewsInvalid() {
        int i92 = this.mChildHelper.i9();
        for (int i = 0; i < i92; i++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.z();
    }

    public void nestedScrollBy(int i, int i5) {
        nestedScrollByInternal(i, i5, null, 1);
    }

    public void offsetChildrenHorizontal(int i) {
        int fb2 = this.mChildHelper.fb();
        for (int i5 = 0; i5 < fb2; i5++) {
            this.mChildHelper.a(i5).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int fb2 = this.mChildHelper.fb();
        for (int i5 = 0; i5 < fb2; i5++) {
            this.mChildHelper.a(i5).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i5) {
        int i92 = this.mChildHelper.i9();
        for (int i6 = 0; i6 < i92; i6++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i6));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i5, false);
                this.mState.f3103fb = true;
            }
        }
        this.mRecycler.r(i, i5);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i5) {
        int i6;
        int i8;
        int i10;
        int i11;
        int i92 = this.mChildHelper.i9();
        if (i < i5) {
            i10 = -1;
            i8 = i;
            i6 = i5;
        } else {
            i6 = i;
            i8 = i5;
            i10 = 1;
        }
        for (int i12 = 0; i12 < i92; i12++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i12));
            if (childViewHolderInt != null && (i11 = childViewHolderInt.mPosition) >= i8 && i11 <= i6) {
                if (i11 == i) {
                    childViewHolderInt.offsetPosition(i5 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i10, false);
                }
                this.mState.f3103fb = true;
            }
        }
        this.mRecycler.x4(i, i5);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i5, boolean z2) {
        int i6 = i + i5;
        int i92 = this.mChildHelper.i9();
        for (int i8 = 0; i8 < i92; i8++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i8));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i10 = childViewHolderInt.mPosition;
                if (i10 >= i6) {
                    childViewHolderInt.offsetPosition(-i5, z2);
                    this.mState.f3103fb = true;
                } else if (i10 >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i5, z2);
                    this.mState.f3103fb = true;
                }
            }
        }
        this.mRecycler.i4(i, i5, z2);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r1 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$w r1 = r5.mLayout
            if (r1 == 0) goto L1e
            r1.x(r5)
        L1e:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<androidx.recyclerview.widget.a> r0 = androidx.recyclerview.widget.a.f3217f
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.a r1 = (androidx.recyclerview.widget.a) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.a r1 = new androidx.recyclerview.widget.a
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = hw.i4.f3(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.a r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f3219fb = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.a r0 = r5.mGapWorker
            r0.y(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.a aVar;
        super.onDetachedFromWindow();
        tl tlVar = this.mItemAnimator;
        if (tlVar != null) {
            tlVar.f();
        }
        stopScroll();
        this.mIsAttached = false;
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.b(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.i9();
        if (ALLOW_THREAD_GAP_WORK && (aVar = this.mGapWorker) != null) {
            aVar.i9(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$w r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L7a
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$w r0 = r5.mLayout
            boolean r0 = r0.x4()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$w r3 = r5.mLayout
            boolean r3 = r3.r()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = 0
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$w r3 = r5.mLayout
            boolean r3 = r3.x4()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$w r3 = r5.mLayout
            boolean r3 = r3.r()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = 0
            goto L64
        L62:
            r0 = 0
            goto L3c
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L7a
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.nestedScrollByInternal(r2, r0, r6, r3)
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        w wVar = this.mLayout;
        if (wVar == null) {
            return false;
        }
        boolean r2 = wVar.r();
        boolean x42 = this.mLayout.x4();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onPointerUp(motionEvent);
                            }
                        } else {
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x2;
                            this.mInitialTouchX = x2;
                            int y2 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.mLastTouchY = y2;
                            this.mInitialTouchY = y2;
                        }
                    } else {
                        cancelScroll();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y7 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i = x3 - this.mInitialTouchX;
                        int i5 = y7 - this.mInitialTouchY;
                        if (r2 && Math.abs(i) > this.mTouchSlop) {
                            this.mLastTouchX = x3;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (x42 && Math.abs(i5) > this.mTouchSlop) {
                            this.mLastTouchY = y7;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
            }
        } else {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x6 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x6;
            this.mInitialTouchX = x6;
            int y8 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y8;
            this.mInitialTouchY = y8;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i6 = r2;
            if (x42) {
                i6 = (r2 ? 1 : 0) | 2;
            }
            startNestedScroll(i6, 0);
        }
        if (this.mScrollState != 1) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        b.xc.y("RV OnLayout");
        dispatchLayout();
        b.xc.n3();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        w wVar = this.mLayout;
        if (wVar == null) {
            defaultOnMeasure(i, i5);
            return;
        }
        boolean z2 = false;
        if (wVar.tg()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.mLayout.fc(this.mRecycler, this.mState, i, i5);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z2;
            if (!z2 && this.mAdapter != null) {
                if (this.mState.f3111v == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.sw(i, i5);
                this.mState.f3105i9 = true;
                dispatchLayoutStep2();
                this.mLayout.zx(i, i5);
                if (this.mLayout.zh()) {
                    this.mLayout.sw(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f3105i9 = true;
                    dispatchLayoutStep2();
                    this.mLayout.zx(i, i5);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.fc(this.mRecycler, this.mState, i, i5);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                fh fhVar = this.mState;
                if (fhVar.f3109t) {
                    fhVar.f3108s = true;
                } else {
                    this.mAdapterHelper.i9();
                    this.mState.f3108s = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f3109t) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            s sVar = this.mAdapter;
            if (sVar != null) {
                this.mState.f3100a = sVar.getItemCount();
            } else {
                this.mState.f3100a = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.fc(this.mRecycler, this.mState, i, i5);
            stopInterceptRequestLayout(false);
            this.mState.f3108s = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.y());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.n3(savedState2);
        } else {
            w wVar = this.mLayout;
            if (wVar != null) {
                savedState.f3086fb = wVar.mh();
            } else {
                savedState.f3086fb = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i5) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        if (i != i6 || i5 != i8) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            hw.i4.nf(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ta taVar, tl.zn znVar) {
        taVar.setFlags(0, 8192);
        if (this.mState.f3101c5 && taVar.isUpdated() && !taVar.isRemoved() && !taVar.shouldIgnore()) {
            this.mViewInfoStore.zn(getChangedHolderKey(taVar), taVar);
        }
        this.mViewInfoStore.v(taVar, znVar);
    }

    public void removeAndRecycleViews() {
        tl tlVar = this.mItemAnimator;
        if (tlVar != null) {
            tlVar.f();
        }
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.hk(this.mRecycler);
            this.mLayout.k3(this.mRecycler);
        }
        this.mRecycler.zn();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean mt2 = this.mChildHelper.mt(view);
        if (mt2) {
            ta childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.a8(childViewHolderInt);
            this.mRecycler.rz(childViewHolderInt);
        }
        stopInterceptRequestLayout(!mt2);
        return mt2;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        ta childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(@NonNull xc xcVar) {
        boolean z2;
        w wVar = this.mLayout;
        if (wVar != null) {
            wVar.p("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(xcVar);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            setWillNotDraw(z2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull mt mtVar) {
        List<mt> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(mtVar);
    }

    public void removeOnItemTouchListener(@NonNull z zVar) {
        this.mOnItemTouchListeners.remove(zVar);
        if (this.mInterceptingOnItemTouchListener == zVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull r rVar) {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void removeRecyclerListener(@NonNull f3 f3Var) {
        this.mRecyclerListeners.remove(f3Var);
    }

    public void repositionShadowingViews() {
        ta taVar;
        int fb2 = this.mChildHelper.fb();
        for (int i = 0; i < fb2; i++) {
            View a2 = this.mChildHelper.a(i);
            ta childViewHolder = getChildViewHolder(a2);
            if (childViewHolder != null && (taVar = childViewHolder.mShadowingHolder) != null) {
                View view = taVar.itemView;
                int left = a2.getLeft();
                int top = a2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.uo(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.rv(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    public void saveOldPositions() {
        int i92 = this.mChildHelper.i9();
        for (int i = 0; i < i92; i++) {
            ta childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c5(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i5) {
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean r2 = wVar.r();
            boolean x42 = this.mLayout.x4();
            if (r2 || x42) {
                if (!r2) {
                    i = 0;
                }
                if (!x42) {
                    i5 = 0;
                }
                scrollByInternal(i, i5, null, 0);
            }
        }
    }

    public boolean scrollByInternal(int i, int i5, MotionEvent motionEvent, int i6) {
        int i8;
        int i10;
        int i11;
        int i12;
        boolean z2;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i5, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            i8 = i14;
            i10 = i13;
            i11 = i - i13;
            i12 = i5 - i14;
        } else {
            i8 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i10, i8, i11, i12, this.mScrollOffset, i6, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i15 = iArr4[0];
        int i16 = i11 - i15;
        int i17 = iArr4[1];
        int i18 = i12 - i17;
        if (i15 == 0 && i17 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        int i19 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i20 = iArr5[0];
        this.mLastTouchX = i19 - i20;
        int i21 = this.mLastTouchY;
        int i22 = iArr5[1];
        this.mLastTouchY = i21 - i22;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i20;
        iArr6[1] = iArr6[1] + i22;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !hw.i9.y(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i16, motionEvent.getY(), i18);
            }
            considerReleasingGlowsOnScroll(i, i5);
        }
        if (i10 != 0 || i8 != 0) {
            dispatchOnScrolled(i10, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z2 || i10 != 0 || i8 != 0) {
            return true;
        }
        return false;
    }

    public void scrollStep(int i, int i5, @Nullable int[] iArr) {
        int i6;
        int i8;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        b.xc.y("RV Scroll");
        fillRemainingScrollValues(this.mState);
        if (i != 0) {
            i6 = this.mLayout.hy(i, this.mRecycler, this.mState);
        } else {
            i6 = 0;
        }
        if (i5 != 0) {
            i8 = this.mLayout.jt(i5, this.mRecycler, this.mState);
        } else {
            i8 = 0;
        }
        b.xc.n3();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i8;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i5) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        wVar.xq(i);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable androidx.recyclerview.widget.tl tlVar) {
        this.mAccessibilityDelegate = tlVar;
        hw.i4.g3(this, tlVar);
    }

    public void setAdapter(@Nullable s sVar) {
        setLayoutFrozen(false);
        setAdapterInternal(sVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable f fVar) {
        boolean z2;
        if (fVar == this.mChildDrawingOrderCallback) {
            return;
        }
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        setChildrenDrawingOrderEnabled(z2);
    }

    public boolean setChildImportantForAccessibilityInternal(ta taVar, int i) {
        if (isComputingLayout()) {
            taVar.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(taVar);
            return false;
        }
        hw.i4.o0(taVar.itemView, i);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull t tVar) {
        vl.s.fb(tVar);
        this.mEdgeEffectFactory = tVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(@Nullable tl tlVar) {
        tl tlVar2 = this.mItemAnimator;
        if (tlVar2 != null) {
            tlVar2.f();
            this.mItemAnimator.f3(null);
        }
        this.mItemAnimator = tlVar;
        if (tlVar != null) {
            tlVar.f3(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.z6(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(@Nullable w wVar) {
        if (wVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            tl tlVar = this.mItemAnimator;
            if (tlVar != null) {
                tlVar.f();
            }
            this.mLayout.hk(this.mRecycler);
            this.mLayout.k3(this.mRecycler);
            this.mRecycler.zn();
            if (this.mIsAttached) {
                this.mLayout.b(this, this.mRecycler);
            }
            this.mLayout.l0(null);
            this.mLayout = null;
        } else {
            this.mRecycler.zn();
        }
        this.mChildHelper.xc();
        this.mLayout = wVar;
        if (wVar != null) {
            if (wVar.f3157v == null) {
                wVar.l0(this);
                if (this.mIsAttached) {
                    this.mLayout.x(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + wVar + " is already attached to a RecyclerView:" + wVar.f3157v.exceptionLabel());
            }
        }
        this.mRecycler.x();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().wz(z2);
    }

    public void setOnFlingListener(@Nullable co coVar) {
        this.mOnFlingListener = coVar;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable r rVar) {
        this.mScrollListener = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(@Nullable x4 x4Var) {
        this.mRecycler.ta(x4Var);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable f3 f3Var) {
        this.mRecyclerListener = f3Var;
    }

    public void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable rz rzVar) {
        this.mRecycler.d(rzVar);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        int i5 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i = j5.n3.y(accessibilityEvent);
        } else {
            i = 0;
        }
        if (i != 0) {
            i5 = i;
        }
        this.mEatenAccessibilityChangeFlags |= i5;
        return true;
    }

    public void smoothScrollBy(int i, int i5) {
        smoothScrollBy(i, i5, null);
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            wVar.ob(this, this.mState, i);
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().w(i);
    }

    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().mt();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(@Nullable s sVar, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(sVar, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i, int i5, Object obj) {
        int i6;
        int i92 = this.mChildHelper.i9();
        int i8 = i + i5;
        for (int i10 = 0; i10 < i92; i10++) {
            View c52 = this.mChildHelper.c5(i10);
            ta childViewHolderInt = getChildViewHolderInt(c52);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i6 = childViewHolderInt.mPosition) >= i && i6 < i8) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((p) c52.getLayoutParams()).f3129fb = true;
            }
        }
        this.mRecycler.k5(i, i5);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().gv(i, i5, iArr, iArr2, i6);
    }

    public boolean dispatchNestedScroll(int i, int i5, int i6, int i8, int[] iArr, int i10) {
        return getScrollingChildHelper().fb(i, i5, i6, i8, iArr, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.ta findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.n3 r0 = r5.mChildHelper
            int r0 = r0.i9()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.n3 r3 = r5.mChildHelper
            android.view.View r3 = r3.c5(r2)
            androidx.recyclerview.widget.RecyclerView$ta r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.n3 r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.wz(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$ta");
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().t(i);
    }

    public void onExitLayoutOrScroll(boolean z2) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i, int i5, @Nullable Interpolator interpolator) {
        smoothScrollBy(i, i5, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i, int i5) {
        return getScrollingChildHelper().p(i, i5);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().co(i);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public Parcelable f3086fb;

        /* loaded from: classes.dex */
        public class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: n3 */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3086fb = parcel.readParcelable(classLoader == null ? w.class.getClassLoader() : classLoader);
        }

        public void n3(SavedState savedState) {
            this.f3086fb = savedState.f3086fb;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3086fb, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new n();
        this.mRecycler = new i4();
        this.mViewInfoStore = new androidx.recyclerview.widget.mt();
        this.mUpdateChildViewsRunnable = new y();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new t();
        this.mItemAnimator = new androidx.recyclerview.widget.zn();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new mg();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new a.n3() : null;
        this.mState = new fh();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new wz();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new n3();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new gv();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = hw.n.zn(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = hw.n.v(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f3(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (hw.i4.rz(this) == 0) {
            hw.i4.o0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.tl(this));
        int[] iArr = R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        hw.i4.kp(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        hw.i4.kp(this, context, iArr2, attributeSet, obtainStyledAttributes2, i, 0);
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public final void dispatchNestedScroll(int i, int i5, int i6, int i8, int[] iArr, int i10, @NonNull int[] iArr2) {
        getScrollingChildHelper().v(i, i5, i6, i8, iArr, i10, iArr2);
    }

    public void smoothScrollBy(int i, int i5, @Nullable Interpolator interpolator, int i6) {
        smoothScrollBy(i, i5, interpolator, i6, false);
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f3129fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f3130s;

        /* renamed from: v  reason: collision with root package name */
        public final Rect f3131v;
        public ta y;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3131v = new Rect();
            this.f3129fb = true;
            this.f3130s = false;
        }

        public boolean gv() {
            return this.y.isInvalid();
        }

        public boolean n3() {
            return this.y.isUpdated();
        }

        public int y() {
            return this.y.getLayoutPosition();
        }

        public boolean zn() {
            return this.y.isRemoved();
        }

        public p(int i, int i5) {
            super(i, i5);
            this.f3131v = new Rect();
            this.f3129fb = true;
            this.f3130s = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3131v = new Rect();
            this.f3129fb = true;
            this.f3130s = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3131v = new Rect();
            this.f3129fb = true;
            this.f3130s = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f3131v = new Rect();
            this.f3129fb = true;
            this.f3130s = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        w wVar = this.mLayout;
        if (wVar != null) {
            return wVar.j5(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public void smoothScrollBy(int i, int i5, @Nullable Interpolator interpolator, int i6, boolean z2) {
        w wVar = this.mLayout;
        if (wVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            if (!wVar.r()) {
                i = 0;
            }
            if (!this.mLayout.x4()) {
                i5 = 0;
            }
            if (i == 0 && i5 == 0) {
                return;
            }
            if (i6 != Integer.MIN_VALUE && i6 <= 0) {
                scrollBy(i, i5);
                return;
            }
            if (z2) {
                int i8 = i != 0 ? 1 : 0;
                if (i5 != 0) {
                    i8 |= 2;
                }
                startNestedScroll(i8, 1);
            }
            this.mViewFlinger.v(i, i5, i6, interpolator);
        }
    }

    public void addItemDecoration(@NonNull xc xcVar) {
        addItemDecoration(xcVar, -1);
    }

    /* loaded from: classes.dex */
    public static abstract class w {

        /* renamed from: c  reason: collision with root package name */
        public boolean f3143c;

        /* renamed from: co  reason: collision with root package name */
        public boolean f3144co;

        /* renamed from: d  reason: collision with root package name */
        public int f3145d;

        /* renamed from: d0  reason: collision with root package name */
        public int f3146d0;

        /* renamed from: ej  reason: collision with root package name */
        public int f3147ej;

        /* renamed from: f  reason: collision with root package name */
        public androidx.recyclerview.widget.p f3148f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f3149f3;

        /* renamed from: fb  reason: collision with root package name */
        public final p.n3 f3150fb;

        /* renamed from: fh  reason: collision with root package name */
        public int f3151fh;

        /* renamed from: n  reason: collision with root package name */
        public int f3152n;

        /* renamed from: p  reason: collision with root package name */
        public boolean f3153p;

        /* renamed from: r  reason: collision with root package name */
        public boolean f3154r;

        /* renamed from: s  reason: collision with root package name */
        public final p.n3 f3155s;

        /* renamed from: t  reason: collision with root package name */
        public androidx.recyclerview.widget.p f3156t;

        /* renamed from: v  reason: collision with root package name */
        public RecyclerView f3157v;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public d0 f3158w;
        public androidx.recyclerview.widget.n3 y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f3159z;

        /* loaded from: classes.dex */
        public static class gv {

            /* renamed from: gv  reason: collision with root package name */
            public boolean f3160gv;

            /* renamed from: n3  reason: collision with root package name */
            public int f3161n3;
            public int y;

            /* renamed from: zn  reason: collision with root package name */
            public boolean f3162zn;
        }

        /* loaded from: classes.dex */
        public class n3 implements p.n3 {
            public n3() {
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int gv() {
                return w.this.rs() - w.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int n3(View view) {
                return w.this.ct(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int v(View view) {
                return w.this.en(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.p.n3
            public View y(int i) {
                return w.this.j(i);
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int zn() {
                return w.this.getPaddingTop();
            }
        }

        /* loaded from: classes.dex */
        public class y implements p.n3 {
            public y() {
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int gv() {
                return w.this.g() - w.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int n3(View view) {
                return w.this.u(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int v(View view) {
                return w.this.dm(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.p.n3
            public View y(int i) {
                return w.this.j(i);
            }

            @Override // androidx.recyclerview.widget.p.n3
            public int zn() {
                return w.this.getPaddingLeft();
            }
        }

        /* loaded from: classes.dex */
        public interface zn {
            void y(int i, int i5);
        }

        public w() {
            y yVar = new y();
            this.f3150fb = yVar;
            n3 n3Var = new n3();
            this.f3155s = n3Var;
            this.f3148f = new androidx.recyclerview.widget.p(yVar);
            this.f3156t = new androidx.recyclerview.widget.p(n3Var);
            this.f3153p = false;
            this.f3144co = false;
            this.f3159z = false;
            this.f3154r = true;
            this.f3149f3 = true;
        }

        public static int f3(int i, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return Math.max(i5, i6);
                }
                return size;
            }
            return Math.min(size, Math.max(i5, i6));
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (r5 == 1073741824) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int ut(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1e
                if (r7 < 0) goto L13
            L10:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L13:
                if (r7 != r1) goto L1b
                if (r5 == r2) goto L23
                if (r5 == 0) goto L1b
                if (r5 == r3) goto L23
            L1b:
                r5 = 0
                r7 = 0
                goto L31
            L1e:
                if (r7 < 0) goto L21
                goto L10
            L21:
                if (r7 != r1) goto L25
            L23:
                r7 = r4
                goto L31
            L25:
                if (r7 != r0) goto L1b
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2c
                goto L2e
            L2c:
                r5 = 0
                goto L23
            L2e:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L23
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.w.ut(int, int, int, int, boolean):int");
        }

        private static boolean xb(int i, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (i6 > 0 && i != i6) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != i) {
                    return false;
                }
                return true;
            } else if (size < i) {
                return false;
            } else {
                return true;
            }
        }

        public static gv yg(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
            gv gvVar = new gv();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i5);
            gvVar.y = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            gvVar.f3161n3 = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            gvVar.f3162zn = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            gvVar.f3160gv = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return gvVar;
        }

        public final void a8(int i, @NonNull View view) {
            this.y.gv(i);
        }

        public boolean ad(@NonNull View view, boolean z2, boolean z3) {
            boolean z4;
            if (this.f3148f.n3(view, 24579) && this.f3156t.n3(view, 24579)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z2) {
                return z4;
            }
            return !z4;
        }

        public int ap(@NonNull View view) {
            return ((p) view.getLayoutParams()).y();
        }

        public void b(RecyclerView recyclerView, i4 i4Var) {
            this.f3144co = false;
            q5(recyclerView, i4Var);
        }

        public boolean bk() {
            int oz2 = oz();
            for (int i = 0; i < oz2; i++) {
                ViewGroup.LayoutParams layoutParams = j(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        @Deprecated
        public boolean br(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            if (!wf() && !recyclerView.isComputingLayout()) {
                return false;
            }
            return true;
        }

        public void bv(fh fhVar) {
        }

        public void c(int i, zn znVar) {
        }

        public void c8(d0 d0Var) {
            if (this.f3158w == d0Var) {
                this.f3158w = null;
            }
        }

        public void co(@NonNull View view, int i, p pVar) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f3157v.mViewInfoStore.n3(childViewHolderInt);
            } else {
                this.f3157v.mViewInfoStore.w(childViewHolderInt);
            }
            this.y.zn(view, i, pVar, childViewHolderInt.isRemoved());
        }

        public boolean cr(@NonNull i4 i4Var, @NonNull fh fhVar) {
            return false;
        }

        public void cs(@NonNull i4 i4Var, @NonNull fh fhVar, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z2 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f3157v.canScrollVertically(-1) && !this.f3157v.canScrollHorizontally(-1) && !this.f3157v.canScrollHorizontally(1)) {
                    z2 = false;
                }
                accessibilityEvent.setScrollable(z2);
                s sVar = this.f3157v.mAdapter;
                if (sVar != null) {
                    accessibilityEvent.setItemCount(sVar.getItemCount());
                }
            }
        }

        public int ct(@NonNull View view) {
            return view.getTop() - g3(view);
        }

        public void cx() {
            this.f3153p = true;
        }

        public void cy(@NonNull View view, int i, int i5, int i6, int i8) {
            Rect rect = ((p) view.getLayoutParams()).f3131v;
            view.layout(i + rect.left, i5 + rect.top, i6 - rect.right, i8 - rect.bottom);
        }

        public int d(@NonNull fh fhVar) {
            return 0;
        }

        public int d0(@NonNull fh fhVar) {
            return 0;
        }

        public int dm(@NonNull View view) {
            return view.getRight() + yc(view);
        }

        public boolean dp(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
            int[] q92 = q9(view, rect);
            int i = q92[0];
            int i5 = q92[1];
            if ((z3 && !pz(recyclerView, i, i5)) || (i == 0 && i5 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i, i5);
            } else {
                recyclerView.smoothScrollBy(i, i5);
            }
            return true;
        }

        public int e() {
            return hw.i4.d(this.f3157v);
        }

        public int eb() {
            return this.f3151fh;
        }

        public void ej(@NonNull View view, @NonNull i4 i4Var) {
            vh(i4Var, this.y.tl(view), view);
        }

        public int en(@NonNull View view) {
            return view.getBottom() + o(view);
        }

        public int f7(@NonNull i4 i4Var, @NonNull fh fhVar) {
            return -1;
        }

        public void fc(@NonNull i4 i4Var, @NonNull fh fhVar, int i, int i5) {
            this.f3157v.defaultOnMeasure(i, i5);
        }

        public int fh(@NonNull fh fhVar) {
            return 0;
        }

        public void fq() {
            d0 d0Var = this.f3158w;
            if (d0Var != null) {
                d0Var.mt();
            }
        }

        public int g() {
            return this.f3145d;
        }

        public int g3(@NonNull View view) {
            return ((p) view.getLayoutParams()).f3131v.top;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return hw.i4.ud(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return hw.i4.a8(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void gf(i4 i4Var, fh fhVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void gi(Rect rect, int i, int i5) {
            v1(f3(i, rect.width() + getPaddingLeft() + getPaddingRight(), s8()), f3(i5, rect.height() + getPaddingTop() + getPaddingBottom(), e()));
        }

        public void gn(int i, @NonNull i4 i4Var) {
            View j2 = j(i);
            i(i);
            i4Var.fh(j2);
        }

        public void gq(int i) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public boolean h(int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f3157v;
            return ia(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean hb(View view, int i, int i5, p pVar) {
            if (this.f3154r && xb(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && xb(view.getMeasuredHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) {
                return false;
            }
            return true;
        }

        public void hk(@NonNull i4 i4Var) {
            for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
                if (!RecyclerView.getChildViewHolderInt(j(oz2)).shouldIgnore()) {
                    gn(oz2, i4Var);
                }
            }
        }

        public void hr() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public p hw(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public int hy(int i, i4 i4Var, fh fhVar) {
            return 0;
        }

        public void i(int i) {
            if (j(i) != null) {
                this.y.p(i);
            }
        }

        @Nullable
        public View i3(@NonNull View view, int i) {
            return null;
        }

        public boolean i4(p pVar) {
            return pVar != null;
        }

        public boolean ia(@NonNull i4 i4Var, @NonNull fh fhVar, int i, @Nullable Bundle bundle) {
            int i5;
            int g2;
            int i6;
            int i8;
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    i8 = 0;
                    i6 = 0;
                } else {
                    if (recyclerView.canScrollVertically(-1)) {
                        i5 = -((rs() - getPaddingTop()) - getPaddingBottom());
                    } else {
                        i5 = 0;
                    }
                    if (this.f3157v.canScrollHorizontally(-1)) {
                        g2 = -((g() - getPaddingLeft()) - getPaddingRight());
                        i6 = i5;
                        i8 = g2;
                    }
                    i6 = i5;
                    i8 = 0;
                }
            } else {
                if (recyclerView.canScrollVertically(1)) {
                    i5 = (rs() - getPaddingTop()) - getPaddingBottom();
                } else {
                    i5 = 0;
                }
                if (this.f3157v.canScrollHorizontally(1)) {
                    g2 = (g() - getPaddingLeft()) - getPaddingRight();
                    i6 = i5;
                    i8 = g2;
                }
                i6 = i5;
                i8 = 0;
            }
            if (i6 == 0 && i8 == 0) {
                return false;
            }
            this.f3157v.smoothScrollBy(i8, i6, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void ic(@NonNull View view, @NonNull i4 i4Var) {
            p1(view);
            i4Var.fh(view);
        }

        public void im(Parcelable parcelable) {
        }

        public void ix(j5.zn znVar) {
            RecyclerView recyclerView = this.f3157v;
            ro(recyclerView.mRecycler, recyclerView.mState, znVar);
        }

        @Nullable
        public View j(int i) {
            androidx.recyclerview.widget.n3 n3Var = this.y;
            if (n3Var != null) {
                return n3Var.a(i);
            }
            return null;
        }

        public void j3(@NonNull RecyclerView recyclerView) {
        }

        public p j5(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new p(layoutParams);
        }

        public void jb(RecyclerView recyclerView) {
            sw(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean jr(@NonNull i4 i4Var, @NonNull fh fhVar, @NonNull View view, int i, @Nullable Bundle bundle) {
            return false;
        }

        public int jt(int i, i4 i4Var, fh fhVar) {
            return 0;
        }

        public void jz(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public boolean k() {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null && recyclerView.mClipToPadding) {
                return true;
            }
            return false;
        }

        public void k3(i4 i4Var) {
            int i92 = i4Var.i9();
            for (int i = i92 - 1; i >= 0; i--) {
                View wz2 = i4Var.wz(i);
                ta childViewHolderInt = RecyclerView.getChildViewHolderInt(wz2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f3157v.removeDetachedView(wz2, false);
                    }
                    tl tlVar = this.f3157v.mItemAnimator;
                    if (tlVar != null) {
                        tlVar.i9(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    i4Var.n(wz2);
                }
            }
            i4Var.v();
            if (i92 > 0) {
                this.f3157v.invalidate();
            }
        }

        @Nullable
        public View k5(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.y.wz(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public int kp(@NonNull i4 i4Var, @NonNull fh fhVar) {
            return -1;
        }

        public void l(int i, int i5) {
            View j2 = j(i);
            if (j2 != null) {
                ud(i);
                mt(j2, i5);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f3157v.toString());
        }

        public void l0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3157v = null;
                this.y = null;
                this.f3145d = 0;
                this.f3147ej = 0;
            } else {
                this.f3157v = recyclerView;
                this.y = recyclerView.mChildHelper;
                this.f3145d = recyclerView.getWidth();
                this.f3147ej = recyclerView.getHeight();
            }
            this.f3146d0 = 1073741824;
            this.f3151fh = 1073741824;
        }

        public int lc() {
            s sVar;
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                sVar = recyclerView.getAdapter();
            } else {
                sVar = null;
            }
            if (sVar != null) {
                return sVar.getItemCount();
            }
            return 0;
        }

        public void le(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3157v;
            cs(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void m(@NonNull View view, boolean z2, @NonNull Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((p) view.getLayoutParams()).f3131v;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f3157v != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f3157v.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int mg(@NonNull fh fhVar) {
            return 0;
        }

        @Nullable
        public Parcelable mh() {
            return null;
        }

        @Nullable
        public View mp(@NonNull View view, int i, @NonNull i4 i4Var, @NonNull fh fhVar) {
            return null;
        }

        public void mt(@NonNull View view, int i) {
            co(view, i, (p) view.getLayoutParams());
        }

        public void n(int i, int i5, fh fhVar, zn znVar) {
        }

        public void n7(int i) {
        }

        public void nd(@NonNull RecyclerView recyclerView, int i, int i5, @Nullable Object obj) {
            wm(recyclerView, i, i5);
        }

        public void ne(@NonNull RecyclerView recyclerView, int i, int i5, int i6) {
        }

        public int nf() {
            return hw.i4.ta(this.f3157v);
        }

        public int o(@NonNull View view) {
            return ((p) view.getLayoutParams()).f3131v.bottom;
        }

        public boolean o0() {
            return this.f3154r;
        }

        @Nullable
        public View o4() {
            View focusedChild;
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.y.wz(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void oa(@Nullable s sVar, @Nullable s sVar2) {
        }

        public void ob(RecyclerView recyclerView, fh fhVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int oz() {
            androidx.recyclerview.widget.n3 n3Var = this.y;
            if (n3Var != null) {
                return n3Var.fb();
            }
            return 0;
        }

        public void p(String str) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void p1(View view) {
            this.y.w(view);
        }

        public final boolean pq() {
            return this.f3149f3;
        }

        public final boolean pz(RecyclerView recyclerView, int i, int i5) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int g2 = g() - getPaddingRight();
            int rs2 = rs() - getPaddingBottom();
            Rect rect = this.f3157v.mTempRect;
            jz(focusedChild, rect);
            if (rect.left - i >= g2 || rect.right - i <= paddingLeft || rect.top - i5 >= rs2 || rect.bottom - i5 <= paddingTop) {
                return false;
            }
            return true;
        }

        public void q(@NonNull RecyclerView recyclerView, int i, int i5) {
        }

        public void q5(RecyclerView recyclerView, i4 i4Var) {
            x5(recyclerView);
        }

        public final int[] q9(View view, Rect rect) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int g2 = g() - getPaddingRight();
            int rs2 = rs() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i5 = top - paddingTop;
            int min2 = Math.min(0, i5);
            int i6 = width - g2;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, height - rs2);
            if (nf() == 1) {
                if (max == 0) {
                    max = Math.max(min, i6);
                }
            } else {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            }
            if (min2 == 0) {
                min2 = Math.min(i5, max2);
            }
            return new int[]{max, min2};
        }

        public void qj(@NonNull View view, int i, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f3157v.getItemDecorInsetsForChild(view);
            int i6 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i8 = i5 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int ut2 = ut(g(), u0(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i6, ((ViewGroup.MarginLayoutParams) pVar).width, r());
            int ut3 = ut(rs(), eb(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i8, ((ViewGroup.MarginLayoutParams) pVar).height, x4());
            if (wo(view, ut2, ut3, pVar)) {
                view.measure(ut2, ut3);
            }
        }

        public void qk(@NonNull View view, int i, int i5, int i6, int i8) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f3131v;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i5 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i6 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i8 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public int qn() {
            return -1;
        }

        public boolean r() {
            return false;
        }

        public boolean r6(@NonNull View view, int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.f3157v;
            return jr(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public int ra(@NonNull View view) {
            return ((p) view.getLayoutParams()).f3131v.left;
        }

        public int rb(@NonNull i4 i4Var, @NonNull fh fhVar) {
            return 0;
        }

        public void ro(@NonNull i4 i4Var, @NonNull fh fhVar, @NonNull j5.zn znVar) {
            if (this.f3157v.canScrollVertically(-1) || this.f3157v.canScrollHorizontally(-1)) {
                znVar.y(8192);
                znVar.wf(true);
            }
            if (this.f3157v.canScrollVertically(1) || this.f3157v.canScrollHorizontally(1)) {
                znVar.y(4096);
                znVar.wf(true);
            }
            znVar.ap(zn.a.y(kp(i4Var, fhVar), f7(i4Var, fhVar), cr(i4Var, fhVar), rb(i4Var, fhVar)));
        }

        public int rs() {
            return this.f3147ej;
        }

        public boolean rv(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2) {
            return dp(recyclerView, view, rect, z2, false);
        }

        public int rz(@NonNull fh fhVar) {
            return 0;
        }

        public int s8() {
            return hw.i4.z6(this.f3157v);
        }

        public void sw(int i, int i5) {
            this.f3145d = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.f3146d0 = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f3145d = 0;
            }
            this.f3147ej = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.f3151fh = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f3147ej = 0;
            }
        }

        public boolean sx() {
            return false;
        }

        public void t(View view) {
            tl(view, -1);
        }

        public int ta(@NonNull fh fhVar) {
            return 0;
        }

        public boolean tg() {
            return this.f3159z;
        }

        public void tl(View view, int i) {
            w(view, i, true);
        }

        public int u(@NonNull View view) {
            return view.getLeft() - ra(view);
        }

        public int u0() {
            return this.f3146d0;
        }

        public void ud(int i) {
            a8(i, j(i));
        }

        public boolean uo(@NonNull RecyclerView recyclerView, @NonNull fh fhVar, @NonNull View view, @Nullable View view2) {
            return br(recyclerView, view, view2);
        }

        public void v1(int i, int i5) {
            this.f3157v.setMeasuredDimension(i, i5);
        }

        public void vb(d0 d0Var) {
            d0 d0Var2 = this.f3158w;
            if (d0Var2 != null && d0Var != d0Var2 && d0Var2.s()) {
                this.f3158w.mt();
            }
            this.f3158w = d0Var;
            d0Var.p(this.f3157v, this);
        }

        public boolean vc(Runnable runnable) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public final void vh(i4 i4Var, int i, View view) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.f3157v.mAdapter.hasStableIds()) {
                i(i);
                i4Var.rz(childViewHolderInt);
                return;
            }
            ud(i);
            i4Var.mg(view);
            this.f3157v.mViewInfoStore.f(childViewHolderInt);
        }

        public abstract p vl();

        public void vn(@NonNull RecyclerView recyclerView, int i, int i5) {
        }

        public void vp(int i) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public final void w(View view, int i, boolean z2) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!z2 && !childViewHolderInt.isRemoved()) {
                this.f3157v.mViewInfoStore.w(childViewHolderInt);
            } else {
                this.f3157v.mViewInfoStore.n3(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.f3157v) {
                    int tl2 = this.y.tl(view);
                    if (i == -1) {
                        i = this.y.fb();
                    }
                    if (tl2 != -1) {
                        if (tl2 != i) {
                            this.f3157v.mLayout.l(tl2, i);
                        }
                    } else {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3157v.indexOfChild(view) + this.f3157v.exceptionLabel());
                    }
                } else {
                    this.y.y(view, i, false);
                    pVar.f3129fb = true;
                    d0 d0Var = this.f3158w;
                    if (d0Var != null && d0Var.s()) {
                        this.f3158w.f(view);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.y.zn(view, i, view.getLayoutParams(), false);
            }
            if (pVar.f3130s) {
                childViewHolderInt.itemView.invalidate();
                pVar.f3130s = false;
            }
        }

        public void w2(RecyclerView recyclerView) {
        }

        public boolean w9(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i5) {
            return false;
        }

        public boolean wf() {
            d0 d0Var = this.f3158w;
            if (d0Var != null && d0Var.s()) {
                return true;
            }
            return false;
        }

        public void wm(@NonNull RecyclerView recyclerView, int i, int i5) {
        }

        public boolean wo(View view, int i, int i5, p pVar) {
            if (!view.isLayoutRequested() && this.f3154r && xb(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && xb(view.getHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) {
                return false;
            }
            return true;
        }

        public void wz(View view) {
            xc(view, -1);
        }

        public void x(RecyclerView recyclerView) {
            this.f3144co = true;
            w2(recyclerView);
        }

        public boolean x4() {
            return false;
        }

        @Deprecated
        public void x5(RecyclerView recyclerView) {
        }

        public void xc(View view, int i) {
            w(view, i, false);
        }

        public int xg(@NonNull View view) {
            Rect rect = ((p) view.getLayoutParams()).f3131v;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void xq(int i) {
        }

        public boolean y4() {
            return this.f3144co;
        }

        public int y5(@NonNull View view) {
            Rect rect = ((p) view.getLayoutParams()).f3131v;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int yc(@NonNull View view) {
            return ((p) view.getLayoutParams()).f3131v.right;
        }

        public void yk(View view, j5.zn znVar) {
            ta childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.y.wz(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.f3157v;
                i2(recyclerView.mRecycler, recyclerView.mState, view, znVar);
            }
        }

        @Nullable
        public View yt(int i) {
            int oz2 = oz();
            for (int i5 = 0; i5 < oz2; i5++) {
                View j2 = j(i5);
                ta childViewHolderInt = RecyclerView.getChildViewHolderInt(j2);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.f3157v.mState.v() || !childViewHolderInt.isRemoved())) {
                    return j2;
                }
            }
            return null;
        }

        public void z(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f3157v;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public void z6(@NonNull i4 i4Var) {
            for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
                vh(i4Var, oz2, j(oz2));
            }
        }

        public boolean zh() {
            return false;
        }

        public void zq() {
            for (int oz2 = oz() - 1; oz2 >= 0; oz2--) {
                this.y.p(oz2);
            }
        }

        public void zx(int i, int i5) {
            int oz2 = oz();
            if (oz2 == 0) {
                this.f3157v.defaultOnMeasure(i, i5);
                return;
            }
            int i6 = Integer.MIN_VALUE;
            int i8 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < oz2; i12++) {
                View j2 = j(i12);
                Rect rect = this.f3157v.mTempRect;
                jz(j2, rect);
                int i13 = rect.left;
                if (i13 < i10) {
                    i10 = i13;
                }
                int i14 = rect.right;
                if (i14 > i6) {
                    i6 = i14;
                }
                int i15 = rect.top;
                if (i15 < i11) {
                    i11 = i15;
                }
                int i16 = rect.bottom;
                if (i16 > i8) {
                    i8 = i16;
                }
            }
            this.f3157v.mTempRect.set(i10, i11, i6, i8);
            gi(this.f3157v.mTempRect, i, i5);
        }

        public void i2(@NonNull i4 i4Var, @NonNull fh fhVar, @NonNull View view, @NonNull j5.zn znVar) {
        }
    }
}
