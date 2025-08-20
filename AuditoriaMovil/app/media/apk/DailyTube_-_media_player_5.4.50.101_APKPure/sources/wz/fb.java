package wz;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class fb extends CheckedTextView {

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f14712v = {16843016};
    public final z y;

    public fb(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z zVar = this.y;
        if (zVar != null) {
            zVar.n3();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i9.y(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(c5.y.gv(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.tl.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        z zVar = this.y;
        if (zVar != null) {
            zVar.p(context, i);
        }
    }

    public fb(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        z zVar = new z(this);
        this.y = zVar;
        zVar.tl(attributeSet, i);
        zVar.n3();
        hw x42 = hw.x4(getContext(), attributeSet, f14712v, i, 0);
        setCheckMarkDrawable(x42.fb(0));
        x42.i4();
    }
}
