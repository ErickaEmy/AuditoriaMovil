package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import wz.f;
import wz.k5;
import wz.v;
import wz.x;
/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    private final v mBackgroundTintHelper;
    private final f mImageHelper;

    public AppCompatImageView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            vVar.n3();
        }
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.n3();
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            return vVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            return vVar.gv();
        }
        return null;
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        f fVar = this.mImageHelper;
        if (fVar != null) {
            return fVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        f fVar = this.mImageHelper;
        if (fVar != null) {
            return fVar.gv();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.v() && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            vVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            vVar.fb(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.n3();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.n3();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.fb(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.n3();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            vVar.c5(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        v vVar = this.mBackgroundTintHelper;
        if (vVar != null) {
            vVar.i9(mode);
        }
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.s(colorStateList);
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        f fVar = this.mImageHelper;
        if (fVar != null) {
            fVar.c5(mode);
        }
    }

    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        v vVar = new v(this);
        this.mBackgroundTintHelper = vVar;
        vVar.v(attributeSet, i);
        f fVar = new f(this);
        this.mImageHelper = fVar;
        fVar.a(attributeSet, i);
    }
}
