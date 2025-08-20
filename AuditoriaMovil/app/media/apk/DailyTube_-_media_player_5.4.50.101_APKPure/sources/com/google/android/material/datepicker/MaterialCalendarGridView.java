package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$id;
import hw.i4;
import java.util.Calendar;
import ur.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: v  reason: collision with root package name */
    public final boolean f5637v;
    public final Calendar y;

    /* loaded from: classes.dex */
    public class y extends hw.y {
        public y() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            znVar.ap(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean gv(@Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5) {
        if (l2 == null || l3 == null || l4 == null || l5 == null || l4.longValue() > l3.longValue() || l5.longValue() < l2.longValue()) {
            return true;
        }
        return false;
    }

    public static int zn(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: n3 */
    public zn getAdapter2() {
        return (zn) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int y2;
        int zn2;
        int y7;
        int zn3;
        int i;
        int i5;
        int i6;
        int i8;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        zn adapter2 = getAdapter2();
        DateSelector<?> dateSelector = adapter2.f5703v;
        qg.n3 n3Var = adapter2.f5702s;
        Long item = adapter2.getItem(adapter2.n3());
        Long item2 = adapter2.getItem(adapter2.c5());
        for (vl.gv<Long, Long> gvVar : dateSelector.o4()) {
            Long l2 = gvVar.y;
            if (l2 != null) {
                if (gvVar.f14456n3 != null) {
                    Long l3 = l2;
                    long longValue = l3.longValue();
                    Long l4 = gvVar.f14456n3;
                    long longValue2 = l4.longValue();
                    if (!gv(item, item2, l3, l4)) {
                        boolean gv2 = f.gv(this);
                        if (longValue < item.longValue()) {
                            y2 = adapter2.n3();
                            if (adapter2.a(y2)) {
                                zn2 = 0;
                            } else if (!gv2) {
                                zn2 = materialCalendarGridView.getChildAt(y2 - 1).getRight();
                            } else {
                                zn2 = materialCalendarGridView.getChildAt(y2 - 1).getLeft();
                            }
                        } else {
                            materialCalendarGridView.y.setTimeInMillis(longValue);
                            y2 = adapter2.y(materialCalendarGridView.y.get(5));
                            zn2 = zn(materialCalendarGridView.getChildAt(y2));
                        }
                        if (longValue2 > item2.longValue()) {
                            y7 = Math.min(adapter2.c5(), getChildCount() - 1);
                            if (adapter2.fb(y7)) {
                                zn3 = getWidth();
                            } else if (!gv2) {
                                zn3 = materialCalendarGridView.getChildAt(y7).getRight();
                            } else {
                                zn3 = materialCalendarGridView.getChildAt(y7).getLeft();
                            }
                        } else {
                            materialCalendarGridView.y.setTimeInMillis(longValue2);
                            y7 = adapter2.y(materialCalendarGridView.y.get(5));
                            zn3 = zn(materialCalendarGridView.getChildAt(y7));
                        }
                        int itemId = (int) adapter2.getItemId(y2);
                        int itemId2 = (int) adapter2.getItemId(y7);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + n3Var.y.zn();
                            int bottom = childAt.getBottom() - n3Var.y.n3();
                            if (!gv2) {
                                if (numColumns > y2) {
                                    i8 = 0;
                                } else {
                                    i8 = zn2;
                                }
                                if (y7 > numColumns2) {
                                    i6 = getWidth();
                                } else {
                                    i6 = zn3;
                                }
                            } else {
                                if (y7 > numColumns2) {
                                    i = 0;
                                } else {
                                    i = zn3;
                                }
                                if (numColumns > y2) {
                                    i5 = getWidth();
                                } else {
                                    i5 = zn2;
                                }
                                int i10 = i;
                                i6 = i5;
                                i8 = i10;
                            }
                            canvas.drawRect(i8, top, i6, bottom, n3Var.f12824s);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter2 = adapter2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z2, int i, Rect rect) {
        if (z2) {
            y(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().n3()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter2().n3());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i5) {
        if (this.f5637v) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i5);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter2().n3()) {
            super.setSelection(getAdapter2().n3());
        } else {
            super.setSelection(i);
        }
    }

    public final void y(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter2().c5());
        } else if (i == 130) {
            setSelection(getAdapter2().n3());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = qg.f.f();
        if (n3.ni(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f5637v = n3.r3(getContext());
        i4.g3(this, new y());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof zn) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), zn.class.getCanonicalName()));
    }
}
