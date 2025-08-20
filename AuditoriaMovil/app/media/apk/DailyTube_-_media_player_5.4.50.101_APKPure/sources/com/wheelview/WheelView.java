package com.wheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import free.daily.tube.base_impl.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class WheelView extends FrameLayout {

    /* renamed from: ap  reason: collision with root package name */
    public int f6661ap;

    /* renamed from: b  reason: collision with root package name */
    public float f6662b;

    /* renamed from: c  reason: collision with root package name */
    public int f6663c;

    /* renamed from: co  reason: collision with root package name */
    public long f6664co;

    /* renamed from: ct  reason: collision with root package name */
    public boolean f6665ct;

    /* renamed from: d  reason: collision with root package name */
    public Paint f6666d;

    /* renamed from: d0  reason: collision with root package name */
    public int f6667d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f6668dm;

    /* renamed from: e  reason: collision with root package name */
    public HandlerThread f6669e;

    /* renamed from: eb  reason: collision with root package name */
    public int f6670eb;

    /* renamed from: ej  reason: collision with root package name */
    public Paint f6671ej;

    /* renamed from: en  reason: collision with root package name */
    public int f6672en;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<fb> f6673f;

    /* renamed from: f3  reason: collision with root package name */
    public int f6674f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f6675f7;

    /* renamed from: fb  reason: collision with root package name */
    public float f6676fb;

    /* renamed from: fh  reason: collision with root package name */
    public VelocityTracker f6677fh;

    /* renamed from: g  reason: collision with root package name */
    public int f6678g;

    /* renamed from: g3  reason: collision with root package name */
    public LinearGradient f6679g3;

    /* renamed from: j  reason: collision with root package name */
    public float f6680j;

    /* renamed from: j5  reason: collision with root package name */
    public float f6681j5;

    /* renamed from: jz  reason: collision with root package name */
    public s f6682jz;

    /* renamed from: k  reason: collision with root package name */
    public int f6683k;

    /* renamed from: kp  reason: collision with root package name */
    public Handler f6684kp;

    /* renamed from: lc  reason: collision with root package name */
    public int f6685lc;

    /* renamed from: m  reason: collision with root package name */
    public fb[] f6686m;

    /* renamed from: n  reason: collision with root package name */
    public int f6687n;

    /* renamed from: nf  reason: collision with root package name */
    public int f6688nf;

    /* renamed from: o  reason: collision with root package name */
    public float f6689o;

    /* renamed from: o4  reason: collision with root package name */
    public Interpolator f6690o4;

    /* renamed from: oz  reason: collision with root package name */
    public int f6691oz;

    /* renamed from: p  reason: collision with root package name */
    public int f6692p;

    /* renamed from: q9  reason: collision with root package name */
    public int f6693q9;

    /* renamed from: qn  reason: collision with root package name */
    public float f6694qn;

    /* renamed from: r  reason: collision with root package name */
    public int f6695r;

    /* renamed from: ra  reason: collision with root package name */
    public boolean f6696ra;

    /* renamed from: rb  reason: collision with root package name */
    public LinearGradient f6697rb;

    /* renamed from: rs  reason: collision with root package name */
    public int f6698rs;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6699s;

    /* renamed from: s8  reason: collision with root package name */
    public Handler f6700s8;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<String> f6701t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f6702u;

    /* renamed from: ut  reason: collision with root package name */
    public int f6703ut;

    /* renamed from: v  reason: collision with root package name */
    public float f6704v;

    /* renamed from: w  reason: collision with root package name */
    public int f6705w;

    /* renamed from: x  reason: collision with root package name */
    public int f6706x;

    /* renamed from: xg  reason: collision with root package name */
    public boolean f6707xg;
    public float y;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f6708y5;

    /* renamed from: yc  reason: collision with root package name */
    public EditText f6709yc;

    /* renamed from: yg  reason: collision with root package name */
    public boolean f6710yg;

    /* renamed from: z  reason: collision with root package name */
    public float f6711z;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            int i5;
            int i6;
            int i8 = WheelView.this.f6688nf;
            if (WheelView.this.f6700s8 == null) {
                return;
            }
            switch (message.what) {
                case 10010:
                    WheelView.fh(WheelView.this);
                    WheelView wheelView = WheelView.this;
                    wheelView.f6688nf = (int) (wheelView.f6690o4.getInterpolation(wheelView.f6670eb / 200.0f) * WheelView.this.f6698rs);
                    WheelView wheelView2 = WheelView.this;
                    if (wheelView2.f6685lc > 0) {
                        i = WheelView.this.f6688nf - i8;
                    } else {
                        i = (WheelView.this.f6688nf - i8) * (-1);
                    }
                    wheelView2.ud(i);
                    if (WheelView.this.f6670eb >= 200 || !WheelView.this.f6696ra || (WheelView.this.f6670eb >= 40 && Math.abs(i8 - WheelView.this.f6688nf) < WheelView.this.f6695r)) {
                        WheelView.this.f6696ra = false;
                        WheelView.this.f6700s8.sendEmptyMessage(10011);
                        return;
                    }
                    WheelView.this.f6700s8.sendEmptyMessageDelayed(10010, 10L);
                    return;
                case 10011:
                    WheelView wheelView3 = WheelView.this;
                    if (wheelView3.f6685lc > 0) {
                        i5 = WheelView.this.f6695r;
                    } else {
                        i5 = WheelView.this.f6695r * (-1);
                    }
                    wheelView3.q9(i5);
                    WheelView.this.f6699s = false;
                    WheelView.this.f6696ra = false;
                    WheelView.this.f6688nf = 0;
                    WheelView.this.f6698rs = 0;
                    return;
                case 10012:
                    WheelView wheelView4 = WheelView.this;
                    if (wheelView4.f6685lc > 0) {
                        i6 = WheelView.this.f6688nf - i8;
                    } else {
                        i6 = (WheelView.this.f6688nf - i8) * (-1);
                    }
                    WheelView.a(wheelView4, i6);
                    WheelView.this.f6688nf = 0;
                    WheelView.this.f6699s = false;
                    WheelView.this.f6696ra = false;
                    WheelView.this.yt();
                    WheelView.this.postInvalidate();
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c5 {
    }

    /* loaded from: classes.dex */
    public class gv implements Runnable {
        public gv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.f6682jz.n3(WheelView.this.f6686m[WheelView.this.f6691oz / 2].y, WheelView.this.f6686m[WheelView.this.f6691oz / 2].zn());
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements TextView.OnEditorActionListener {
        public n3() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            WheelView.this.f6709yc.setVisibility(8);
            WheelView.wz(WheelView.this);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface s {
        void n3(int i, String str);

        void y(int i, String str);
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {
        public final /* synthetic */ int y;

        public v(int i) {
            this.y = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i5;
            int i6;
            WheelView.this.yt();
            int selected = WheelView.this.getSelected();
            int i8 = 1;
            if (selected == -1) {
                synchronized (WheelView.this.f6686m) {
                    try {
                        i = 0;
                        if (this.y > 0) {
                            int i10 = 0;
                            while (true) {
                                if (i10 < WheelView.this.f6686m.length) {
                                    if (WheelView.this.f6686m[i10] != null && WheelView.this.f6686m[i10].y()) {
                                        i = (int) WheelView.this.f6686m[i10].a();
                                        break;
                                    }
                                    i10++;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            int length = WheelView.this.f6686m.length - 1;
                            while (true) {
                                if (length >= 0) {
                                    if (WheelView.this.f6686m[length] != null && WheelView.this.f6686m[length].y()) {
                                        i = (int) WheelView.this.f6686m[length].a();
                                        break;
                                    }
                                    length--;
                                } else {
                                    break;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                i5 = i;
            } else {
                i5 = (int) ((fb) WheelView.this.f6673f.get(selected)).a();
            }
            if (i5 > 0) {
                i6 = i5;
            } else {
                i6 = i5 * (-1);
            }
            if (i5 <= 0) {
                i8 = -1;
            }
            int i11 = WheelView.this.f6695r;
            while (true) {
                if (i6 == 0) {
                    break;
                }
                i6 -= i11;
                if (i6 < 0) {
                    WheelView.fb(WheelView.this, i6 * i8);
                    WheelView.this.yt();
                    WheelView.this.postInvalidate();
                    try {
                        Thread.sleep(10L);
                        break;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    WheelView.fb(WheelView.this, i11 * i8);
                    WheelView.this.yt();
                    WheelView.this.postInvalidate();
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            WheelView.this.j(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnFocusChangeListener {
        public final /* synthetic */ Context y;

        public y(Context context) {
            this.y = context;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            if (z2) {
                WheelView.this.f6709yc.setText(WheelView.this.getSelectedText());
                WheelView.this.ut(this.y);
                WheelView.wz(WheelView.this);
                WheelView.this.f6709yc.selectAll();
                return;
            }
            WheelView.this.f6709yc.setSelection(0, 0);
            WheelView.this.f6709yc.setVisibility(8);
            WheelView.wz(WheelView.this);
            WheelView.j5(WheelView.this.f6709yc);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public final /* synthetic */ fb y;

        public zn(fb fbVar) {
            this.y = fbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = WheelView.this.f6682jz;
            fb fbVar = this.y;
            sVar.y(fbVar.y, fbVar.zn());
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6673f = new ArrayList<>();
        this.f6701t = new ArrayList<>();
        this.f6664co = 0L;
        this.f6711z = 1.0f;
        this.f6695r = 1;
        this.f6674f3 = 2;
        this.f6687n = 100;
        this.f6706x = -16777216;
        this.f6662b = 2.0f;
        this.f6681j5 = -1.0f;
        this.f6694qn = 14.0f;
        this.f6689o = 22.0f;
        this.f6680j = 50.0f;
        this.f6691oz = 7;
        this.f6703ut = -16777216;
        this.f6693q9 = -1;
        this.f6683k = -65536;
        this.f6675f7 = -654311425;
        this.f6672en = -1056964609;
        this.f6702u = true;
        this.f6708y5 = true;
        this.f6707xg = true;
        this.f6668dm = true;
        this.f6665ct = false;
        this.f6690o4 = new DecelerateInterpolator(2.0f);
        this.f6670eb = 0;
        this.f6696ra = false;
        qn(context, attributeSet);
        o();
    }

    public static /* synthetic */ int a(WheelView wheelView, int i) {
        int i5 = wheelView.f6661ap + i;
        wheelView.f6661ap = i5;
        return i5;
    }

    public static /* synthetic */ int fb(WheelView wheelView, int i) {
        int i5 = wheelView.f6661ap - i;
        wheelView.f6661ap = i5;
        return i5;
    }

    public static /* synthetic */ int fh(WheelView wheelView) {
        int i = wheelView.f6670eb;
        wheelView.f6670eb = i + 1;
        return i;
    }

    public static void j5(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public static /* synthetic */ c5 wz(WheelView wheelView) {
        wheelView.getClass();
        return null;
    }

    public final void a8(int i) {
        this.f6661ap -= i;
        vl(false);
        postInvalidate();
    }

    public final synchronized void b(Canvas canvas) {
        fb[] fbVarArr;
        if (this.f6665ct) {
            return;
        }
        synchronized (this.f6686m) {
            for (fb fbVar : this.f6686m) {
                if (fbVar != null) {
                    fbVar.n3(canvas, getMeasuredWidth());
                }
            }
        }
    }

    public final void ej(int i) {
        this.f6661ap -= i;
        yt();
        invalidate();
    }

    public int getItemNumber() {
        return this.f6691oz;
    }

    public int getListSize() {
        ArrayList<fb> arrayList = this.f6673f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getSelected() {
        fb[] fbVarArr;
        synchronized (this.f6686m) {
            try {
                for (fb fbVar : this.f6686m) {
                    if (fbVar != null && fbVar.s()) {
                        return fbVar.y;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getSelectedText() {
        fb[] fbVarArr;
        synchronized (this.f6686m) {
            try {
                for (fb fbVar : this.f6686m) {
                    if (fbVar != null && fbVar.s()) {
                        return fbVar.zn();
                    }
                }
                return "";
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void hw(int i, long j2) {
        try {
            this.f6670eb = 0;
            int abs = Math.abs(i / 10);
            if (this.f6685lc * j2 > 0) {
                this.f6698rs += abs;
            } else {
                this.f6698rs = abs;
            }
            this.f6685lc = (int) j2;
            this.f6696ra = true;
            Handler handler = this.f6700s8;
            if (handler == null) {
                return;
            }
            handler.sendEmptyMessage(10010);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(int i) {
        fb[] fbVarArr;
        if (!this.f6708y5) {
            return;
        }
        synchronized (this.f6686m) {
            try {
                yt();
                int i5 = 0;
                for (fb fbVar : this.f6686m) {
                    if (fbVar != null && fbVar.s()) {
                        oz(fbVar);
                        a8((int) fbVar.a());
                        return;
                    }
                }
                if (i > 0) {
                    while (true) {
                        fb[] fbVarArr2 = this.f6686m;
                        if (i5 >= fbVarArr2.length) {
                            break;
                        }
                        fb fbVar2 = fbVarArr2[i5];
                        if (fbVar2 != null && fbVar2.y()) {
                            oz(this.f6686m[i5]);
                            a8((int) this.f6686m[i5].a());
                            return;
                        }
                        i5++;
                    }
                } else {
                    for (int length = this.f6686m.length - 1; length >= 0; length--) {
                        fb fbVar3 = this.f6686m[length];
                        if (fbVar3 != null && fbVar3.y()) {
                            oz(this.f6686m[length]);
                            a8((int) this.f6686m[length].a());
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k5(Canvas canvas) {
        if (this.f6671ej == null) {
            this.f6671ej = new Paint();
            float f4 = this.f6680j;
            int i = this.f6675f7;
            int i5 = this.f6672en;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f6697rb = new LinearGradient(0.0f, 0.0f, 0.0f, f4, i, i5, tileMode);
            float f6 = this.f6704v;
            this.f6679g3 = new LinearGradient(0.0f, f6 - this.f6680j, 0.0f, f6, this.f6672en, this.f6675f7, tileMode);
        }
        this.f6671ej.setShader(this.f6697rb);
        canvas.drawRect(0.0f, 0.0f, this.y, (this.f6691oz / 2) * this.f6680j, this.f6671ej);
        this.f6671ej.setShader(this.f6679g3);
        float f9 = this.f6704v;
        canvas.drawRect(0.0f, f9 - ((this.f6691oz / 2) * this.f6680j), this.y, f9, this.f6671ej);
    }

    public final void o() {
        this.f6665ct = true;
        this.f6673f.clear();
        for (int i = 0; i < this.f6701t.size(); i++) {
            fb fbVar = new fb(this, null);
            fbVar.y = i;
            fbVar.c5(this.f6701t.get(i));
            fbVar.f6715gv = 0;
            fbVar.f6719v = (int) (i * this.f6680j);
            this.f6673f.add(fbVar);
        }
        this.f6665ct = false;
        y(this.f6707xg);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = new HandlerThread("goOnHandlerThread");
        this.f6669e = handlerThread;
        handlerThread.setPriority(1);
        this.f6669e.start();
        this.f6700s8 = new a(this.f6669e.getLooper());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        HandlerThread handlerThread = this.f6669e;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.f6669e.quit();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.y = getWidth();
        x(canvas);
        b(canvas);
        k5(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        float f4;
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE) {
            int size = View.MeasureSpec.getSize(i5);
            float f6 = size;
            if (f6 < this.f6704v && size != 0) {
                this.f6704v = f6;
                this.f6680j = (int) (f6 / this.f6691oz);
            }
        } else if (mode == 1073741824) {
            this.f6704v = View.MeasureSpec.getSize(i5);
            this.f6680j = (int) (f4 / this.f6691oz);
        }
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode2 == Integer.MIN_VALUE) {
            int size3 = View.MeasureSpec.getSize(i);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(this.f6689o);
            Rect rect = new Rect();
            Iterator<String> it = this.f6701t.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                String str = it.next() + "PA";
                textPaint.getTextBounds(str, 0, str.length(), rect);
                if (i6 < rect.width()) {
                    i6 = rect.width();
                }
            }
            if (size3 > getPaddingLeft() + i6 + getPaddingRight() && i6 != 0) {
                size2 = i6 + getPaddingLeft() + getPaddingRight();
            }
        }
        float f9 = this.f6681j5;
        if (f9 != -1.0f && size2 > f9) {
            size2 = (int) f9;
        }
        setMeasuredDimension(size2, (int) this.f6704v);
        this.f6709yc.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - ((FrameLayout.LayoutParams) this.f6709yc.getLayoutParams()).leftMargin) - ((FrameLayout.LayoutParams) this.f6709yc.getLayoutParams()).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.f6704v / this.f6691oz), 1073741824));
        if (Math.abs(this.f6676fb - this.f6704v) > 0.1d) {
            int selected = getSelected();
            o();
            if (selected != -1) {
                setDefault(selected);
            } else {
                setDefault(this.f6678g);
            }
            this.f6676fb = this.f6704v;
            this.f6709yc.getLayoutParams().height = (int) (this.f6704v / this.f6691oz);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f6702u) {
            return true;
        }
        if (this.f6677fh == null) {
            this.f6677fh = VelocityTracker.obtain();
        }
        this.f6677fh.addMovement(motionEvent);
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f6696ra = false;
                    this.f6699s = true;
                    ej(y2 - this.f6692p);
                    this.f6692p = y2;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() - this.f6664co;
                VelocityTracker velocityTracker = this.f6677fh;
                velocityTracker.computeCurrentVelocity(1000, this.f6663c);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.f6667d0) {
                    hw(yVelocity, y2 - this.f6705w);
                } else {
                    if (Math.abs(y2 - this.f6705w) <= this.f6674f3 && currentTimeMillis <= this.f6687n) {
                        int i = this.f6705w;
                        float f4 = this.f6680j;
                        int i5 = this.f6691oz;
                        if (i < (i5 / 2) * f4 && i > 0) {
                            ej((int) (f4 / 3.0f));
                            q9((((int) this.f6680j) * 2) / 3);
                        } else {
                            float f6 = this.f6704v;
                            if (i > f6 - ((i5 / 2) * f4) && i < f6) {
                                ej(-((int) (f4 / 3.0f)));
                                q9(((-((int) this.f6680j)) * 2) / 3);
                            } else {
                                if (this.f6710yg) {
                                    this.f6709yc.setVisibility(0);
                                    this.f6709yc.requestFocus();
                                }
                                j(y2 - this.f6705w);
                            }
                        }
                    } else {
                        q9(y2 - this.f6705w);
                    }
                    this.f6699s = false;
                }
                this.f6677fh.recycle();
                this.f6677fh = null;
            }
        } else {
            this.f6709yc.setVisibility(8);
            this.f6709yc.clearFocus();
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.f6699s) {
                this.f6696ra = false;
                Handler handler = this.f6700s8;
                if (handler != null) {
                    handler.removeMessages(10010);
                    this.f6700s8.sendEmptyMessage(10012);
                }
            }
            this.f6699s = true;
            this.f6705w = (int) motionEvent.getY();
            this.f6692p = (int) motionEvent.getY();
            this.f6664co = System.currentTimeMillis();
        }
        return true;
    }

    public final void oz(fb fbVar) {
        if (this.f6682jz != null) {
            this.f6684kp.removeCallbacksAndMessages(null);
            this.f6684kp.post(new zn(fbVar));
        }
    }

    public final synchronized void q9(int i) {
        Handler handler = this.f6700s8;
        if (handler == null) {
            return;
        }
        handler.post(new v(i));
    }

    public final void qn(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sh);
        this.f6680j = (int) obtainStyledAttributes.getDimension(R.styleable.j4, this.f6680j);
        this.f6691oz = obtainStyledAttributes.getInt(R.styleable.i1, this.f6691oz);
        this.f6694qn = obtainStyledAttributes.getDimension(R.styleable.x0, this.f6694qn);
        this.f6689o = obtainStyledAttributes.getDimension(R.styleable.wb, this.f6689o);
        this.f6703ut = obtainStyledAttributes.getColor(R.styleable.mq, this.f6703ut);
        this.f6693q9 = obtainStyledAttributes.getColor(R.styleable.mc, this.f6693q9);
        this.f6683k = obtainStyledAttributes.getColor(R.styleable.ez, this.f6683k);
        this.f6706x = obtainStyledAttributes.getColor(R.styleable.eu, this.f6706x);
        this.f6662b = obtainStyledAttributes.getDimension(R.styleable.xu, this.f6662b);
        this.f6681j5 = obtainStyledAttributes.getDimension(R.styleable.hf, -1.0f);
        this.f6708y5 = obtainStyledAttributes.getBoolean(R.styleable.jm, true);
        this.f6702u = obtainStyledAttributes.getBoolean(R.styleable.nh, true);
        this.f6707xg = obtainStyledAttributes.getBoolean(R.styleable.yh, true);
        this.f6710yg = obtainStyledAttributes.getBoolean(R.styleable.t7, false);
        this.f6675f7 = obtainStyledAttributes.getColor(R.styleable.z8, -654311425);
        this.f6672en = obtainStyledAttributes.getColor(R.styleable.ih, -1056964609);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f6711z = f4;
        this.f6695r = (int) (1.0f * f4);
        this.f6674f3 = (int) (f4 * 2.0f);
        int i = this.f6691oz;
        this.f6704v = i * this.f6680j;
        this.f6686m = new fb[i + 2];
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6687n = ViewConfiguration.getTapTimeout();
        this.f6667d0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6663c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6684kp = new Handler(Looper.getMainLooper());
        int color = obtainStyledAttributes.getColor(R.styleable.e5, -16777216);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ou, 0);
        EditText editText = new EditText(context);
        this.f6709yc = editText;
        if (resourceId == 0) {
            editText.setBackgroundColor(0);
        } else {
            editText.setBackgroundResource(resourceId);
        }
        this.f6709yc.setTextColor(color);
        this.f6709yc.setTextSize(0, this.f6689o);
        this.f6709yc.setGravity(17);
        this.f6709yc.setPadding(0, 0, 0, 0);
        this.f6709yc.setOnFocusChangeListener(new y(context));
        this.f6709yc.setInputType(obtainStyledAttributes.getInt(R.styleable.w7, 0));
        this.f6709yc.setImeOptions(6);
        this.f6709yc.setOnEditorActionListener(new n3());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) this.f6680j);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.vi, 0);
        layoutParams.rightMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.l3, 0);
        Log.e("WheelView", "leftMargin=" + layoutParams.leftMargin);
        Log.e("WheelView", "rightMargin=" + layoutParams.rightMargin);
        addView(this.f6709yc, layoutParams);
        this.f6709yc.setVisibility(8);
        setWillNotDraw(false);
        obtainStyledAttributes.recycle();
    }

    public void setCyclic(boolean z2) {
        this.f6707xg = z2;
        y(z2);
    }

    public void setData(ArrayList<String> arrayList) {
        this.f6701t = arrayList;
        o();
        requestLayout();
    }

    public void setDefault(int i) {
        this.f6678g = i;
        if (this.f6673f.isEmpty() || i > this.f6673f.size() - 1) {
            return;
        }
        this.f6661ap = 0;
        Iterator<fb> it = this.f6673f.iterator();
        while (it.hasNext()) {
            it.next().f6712a = 0;
        }
        yt();
        float a2 = this.f6673f.get(i).a();
        oz(this.f6673f.get(i));
        a8((int) a2);
    }

    public void setEnable(boolean z2) {
        this.f6702u = z2;
    }

    public void setItemNumber(int i) {
        this.f6691oz = i;
        this.f6704v = i * this.f6680j;
        this.f6686m = new fb[i + 2];
        requestLayout();
    }

    public void setNormalColor(int i) {
        this.f6703ut = i;
        invalidate();
    }

    public void setOnInputListener(c5 c5Var) {
    }

    public void setOnSelectListener(s sVar) {
        this.f6682jz = sVar;
    }

    public void setSecondTextColor(int i) {
        this.f6693q9 = i;
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.f6683k = i;
        invalidate();
    }

    public void setWithInputText(boolean z2) {
        this.f6710yg = z2;
    }

    public final void ud(int i) {
        this.f6661ap -= i;
        yt();
        postInvalidate();
    }

    public final void ut(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(this.f6709yc, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x015c A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:42:0x0145, B:44:0x014a, B:51:0x015c, B:55:0x0180, B:54:0x0164, B:47:0x0151, B:56:0x0183), top: B:68:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0164 A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:42:0x0145, B:44:0x014a, B:51:0x015c, B:55:0x0180, B:54:0x0164, B:47:0x0151, B:56:0x0183), top: B:68:0x0145 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void vl(boolean r9) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wheelview.WheelView.vl(boolean):void");
    }

    public final void x(Canvas canvas) {
        if (this.f6666d == null) {
            Paint paint = new Paint();
            this.f6666d = paint;
            paint.setColor(this.f6706x);
            this.f6666d.setAntiAlias(true);
            this.f6666d.setStrokeWidth(this.f6662b);
        }
        float f4 = this.f6704v;
        float f6 = this.f6680j;
        float f9 = this.f6662b;
        canvas.drawLine(0.0f, ((f4 / 2.0f) - (f6 / 2.0f)) + f9, this.y, ((f4 / 2.0f) - (f6 / 2.0f)) + f9, this.f6666d);
        float f10 = this.f6704v;
        float f11 = this.f6680j;
        float f12 = this.f6662b;
        canvas.drawLine(0.0f, ((f10 / 2.0f) + (f11 / 2.0f)) - f12, this.y, ((f10 / 2.0f) + (f11 / 2.0f)) - f12, this.f6666d);
    }

    public final void y(boolean z2) {
        if (this.f6701t.size() < this.f6691oz + 2) {
            this.f6668dm = false;
        } else {
            this.f6668dm = z2;
        }
    }

    public final void yt() {
        vl(true);
    }

    /* loaded from: classes.dex */
    public class fb {

        /* renamed from: a  reason: collision with root package name */
        public int f6712a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f6713c5;

        /* renamed from: fb  reason: collision with root package name */
        public TextPaint f6714fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f6715gv;

        /* renamed from: n3  reason: collision with root package name */
        public String f6717n3;

        /* renamed from: s  reason: collision with root package name */
        public Rect f6718s;

        /* renamed from: v  reason: collision with root package name */
        public int f6719v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public String f6720zn;

        public fb() {
            this.f6717n3 = "";
            this.f6720zn = "";
            this.f6713c5 = true;
        }

        public synchronized float a() {
            return ((WheelView.this.f6704v / 2.0f) - (WheelView.this.f6680j / 2.0f)) - (this.f6719v + this.f6712a);
        }

        public void c5(String str) {
            this.f6713c5 = true;
            this.f6717n3 = str;
            this.f6720zn = new String(str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
            if ((r6.f6719v + r6.f6712a) < (((r6.f6716i9.f6691oz + 2) * r6.f6716i9.f6680j) / 2.0f)) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean fb() {
            /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = r6.y()     // Catch: java.lang.Throwable -> L45
                r1 = 0
                if (r0 == 0) goto La
                monitor-exit(r6)
                return r1
            La:
                int r0 = r6.f6719v     // Catch: java.lang.Throwable -> L45
                int r2 = r6.f6712a     // Catch: java.lang.Throwable -> L45
                int r0 = r0 + r2
                float r0 = (float) r0     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r2 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                int r2 = com.wheelview.WheelView.f(r2)     // Catch: java.lang.Throwable -> L45
                r3 = 1
                int r2 = r2 - r3
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r4 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                float r4 = com.wheelview.WheelView.mt(r4)     // Catch: java.lang.Throwable -> L45
                float r2 = r2 * r4
                r4 = 1073741824(0x40000000, float:2.0)
                float r2 = r2 / r4
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L47
                int r0 = r6.f6719v     // Catch: java.lang.Throwable -> L45
                int r2 = r6.f6712a     // Catch: java.lang.Throwable -> L45
                int r0 = r0 + r2
                float r0 = (float) r0     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r2 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                int r2 = com.wheelview.WheelView.f(r2)     // Catch: java.lang.Throwable -> L45
                int r2 = r2 + (-4)
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r5 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                float r5 = com.wheelview.WheelView.mt(r5)     // Catch: java.lang.Throwable -> L45
                float r2 = r2 * r5
                float r2 = r2 / r4
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 > 0) goto L7e
                goto L47
            L45:
                r0 = move-exception
                goto L82
            L47:
                int r0 = r6.f6719v     // Catch: java.lang.Throwable -> L45
                int r2 = r6.f6712a     // Catch: java.lang.Throwable -> L45
                int r0 = r0 + r2
                float r0 = (float) r0     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r2 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                int r2 = com.wheelview.WheelView.f(r2)     // Catch: java.lang.Throwable -> L45
                int r2 = r2 - r3
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r5 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                float r5 = com.wheelview.WheelView.mt(r5)     // Catch: java.lang.Throwable -> L45
                float r2 = r2 * r5
                float r2 = r2 / r4
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L80
                int r0 = r6.f6719v     // Catch: java.lang.Throwable -> L45
                int r2 = r6.f6712a     // Catch: java.lang.Throwable -> L45
                int r0 = r0 + r2
                float r0 = (float) r0     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r2 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                int r2 = com.wheelview.WheelView.f(r2)     // Catch: java.lang.Throwable -> L45
                int r2 = r2 + 2
                float r2 = (float) r2     // Catch: java.lang.Throwable -> L45
                com.wheelview.WheelView r5 = com.wheelview.WheelView.this     // Catch: java.lang.Throwable -> L45
                float r5 = com.wheelview.WheelView.mt(r5)     // Catch: java.lang.Throwable -> L45
                float r2 = r2 * r5
                float r2 = r2 / r4
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L80
            L7e:
                monitor-exit(r6)
                return r3
            L80:
                monitor-exit(r6)
                return r1
            L82:
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L45
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wheelview.WheelView.fb.fb():boolean");
        }

        public synchronized boolean gv() {
            if (this.f6719v + this.f6712a <= WheelView.this.f6704v) {
                if (this.f6719v + this.f6712a + WheelView.this.f6680j >= 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public void n3(Canvas canvas, int i) {
            if (!gv()) {
                return;
            }
            if (this.f6714fb == null) {
                TextPaint textPaint = new TextPaint();
                this.f6714fb = textPaint;
                textPaint.setAntiAlias(true);
            }
            if (this.f6718s == null) {
                this.f6718s = new Rect();
            }
            if (y()) {
                this.f6714fb.setColor(WheelView.this.f6683k);
                float a2 = a();
                if (a2 <= 0.0f) {
                    a2 *= -1.0f;
                }
                this.f6714fb.setTextSize(WheelView.this.f6694qn + ((WheelView.this.f6689o - WheelView.this.f6694qn) * (1.0f - (a2 / WheelView.this.f6680j))));
                this.f6714fb.setTypeface(Typeface.DEFAULT_BOLD);
            } else if (fb()) {
                this.f6714fb.setColor(WheelView.this.f6693q9);
                this.f6714fb.setTextSize(WheelView.this.f6694qn);
                this.f6714fb.setTypeface(Typeface.DEFAULT);
            } else {
                this.f6714fb.setColor(WheelView.this.f6703ut);
                this.f6714fb.setTextSize(WheelView.this.f6694qn);
                this.f6714fb.setTypeface(Typeface.DEFAULT);
            }
            if (WheelView.this.f6680j < Math.max(WheelView.this.f6689o, WheelView.this.f6694qn)) {
                float f4 = WheelView.this.f6680j - (WheelView.this.f6662b * 2.0f);
                this.f6714fb.setTextSize(f4);
                WheelView.this.f6709yc.setTextSize(0, f4);
            }
            if (this.f6713c5) {
                String str = (String) TextUtils.ellipsize(this.f6717n3, this.f6714fb, i, TextUtils.TruncateAt.END);
                this.f6717n3 = str;
                this.f6714fb.getTextBounds(str, 0, str.length(), this.f6718s);
                if (WheelView.this.f6689o == WheelView.this.f6694qn) {
                    this.f6713c5 = false;
                }
            }
            canvas.drawText(this.f6717n3, (this.f6715gv + (WheelView.this.y / 2.0f)) - (this.f6718s.width() / 2.0f), this.f6719v + this.f6712a + (WheelView.this.f6680j / 2.0f) + (this.f6718s.height() / 2.0f), this.f6714fb);
        }

        public synchronized boolean s() {
            boolean z2 = false;
            if (this.f6718s == null) {
                return false;
            }
            if (this.f6719v + this.f6712a >= (((WheelView.this.f6691oz / 2) * WheelView.this.f6680j) - (WheelView.this.f6680j / 2.0f)) + (this.f6718s.height() / 2.0f)) {
                if (this.f6719v + this.f6712a <= (((WheelView.this.f6691oz / 2) * WheelView.this.f6680j) + (WheelView.this.f6680j / 2.0f)) - (this.f6718s.height() / 2.0f)) {
                    z2 = true;
                }
            }
            return z2;
        }

        public synchronized void v(int i) {
            this.f6712a = i;
        }

        public synchronized boolean y() {
            if (this.f6719v + this.f6712a > ((WheelView.this.f6691oz - 2) * WheelView.this.f6680j) / 2.0f) {
                if (this.f6719v + this.f6712a < (WheelView.this.f6691oz * WheelView.this.f6680j) / 2.0f) {
                    return true;
                }
            }
            return false;
        }

        public String zn() {
            return this.f6720zn;
        }

        public /* synthetic */ fb(WheelView wheelView, y yVar) {
            this();
        }
    }
}
