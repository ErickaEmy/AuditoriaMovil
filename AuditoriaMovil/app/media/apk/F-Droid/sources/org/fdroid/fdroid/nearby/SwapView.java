package org.fdroid.fdroid.nearby;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import org.fdroid.fdroid.R;
/* loaded from: classes2.dex */
public class SwapView extends RelativeLayout {
    public static final String TAG = "SwapView";
    protected String currentFilterString;
    private int layoutResId;
    public final int toolbarColor;
    public final String toolbarTitle;

    public String getCurrentFilterString() {
        return this.currentFilterString;
    }

    public int getLayoutResId() {
        return this.layoutResId;
    }

    public String getToolbarTitle() {
        return this.toolbarTitle;
    }

    public void setCurrentFilterString(String str) {
        this.currentFilterString = str;
    }

    public void setLayoutResId(int i) {
        this.layoutResId = i;
    }

    public SwapView(Context context) {
        this(context, null);
    }

    public SwapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.layoutResId = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwapView, 0, 0);
        this.toolbarColor = obtainStyledAttributes.getColor(R.styleable.SwapView_toolbarColor, ContextCompat.getColor(context, R.color.swap_blue));
        this.toolbarTitle = obtainStyledAttributes.getString(R.styleable.SwapView_toolbarTitle);
        obtainStyledAttributes.recycle();
    }

    public SwapView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.layoutResId = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwapView, 0, 0);
        this.toolbarColor = obtainStyledAttributes.getColor(R.styleable.SwapView_toolbarColor, ContextCompat.getColor(context, R.color.swap_blue));
        this.toolbarTitle = obtainStyledAttributes.getString(R.styleable.SwapView_toolbarTitle);
        obtainStyledAttributes.recycle();
    }

    public SwapWorkflowActivity getActivity() {
        return (SwapWorkflowActivity) getContext();
    }
}
