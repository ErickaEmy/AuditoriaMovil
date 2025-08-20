package org.fdroid.fdroid.views.apps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.views.categories.CategoryController;
/* loaded from: classes2.dex */
public class CategorySpan extends ReplacementSpan {
    private static final int CORNER_RADIUS = 16;
    private static final float DROP_SHADOW_HEIGHT = 1.5f;
    private static final int HEIGHT = 32;
    private static final int ICON_BACKGROUND_SIZE = 32;
    private static final int ICON_PADDING = 8;
    private static final int ICON_SIZE = 16;
    private static final int TEXT_BELOW_PADDING = 2;
    private static final int TEXT_LEADING_PADDING = 8;
    private static final int TEXT_TRAILING_PADDING = 12;
    private static final int WHITE_SPACE_PADDING_AT_END = 4;
    private final Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CategorySpan(Context context) {
        this.context = context;
    }

    private static CharSequence getCategoryName(CharSequence charSequence, int i, int i2) {
        int i3;
        if (charSequence != null && i + 1 < i2 - 1) {
            return charSequence.subSequence(i, i3);
        }
        return null;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        CharSequence categoryName = getCategoryName(charSequence, i, i2);
        if (categoryName == null) {
            return 0;
        }
        float f = this.context.getResources().getDisplayMetrics().density;
        return ((int) (32.0f * f)) + ((int) (8.0f * f)) + ((int) paint.measureText(categoryName.toString())) + ((int) (12.0f * f)) + ((int) (f * 4.0f));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence categoryName = getCategoryName(charSequence, i, i2);
        if (categoryName == null) {
            return;
        }
        float f2 = this.context.getResources().getDisplayMetrics().density;
        int i6 = (int) (32.0f * f2);
        int i7 = (int) (16.0f * f2);
        int i8 = (int) (8.0f * f2);
        int i9 = (int) (2.0f * f2);
        canvas.save();
        canvas.translate(f, (i5 - i6) + i9);
        int i10 = i6 + i8;
        float f3 = i6;
        RectF rectF = new RectF(0.0f, 0.0f, ((int) paint.measureText(categoryName.toString())) + i10 + ((int) (12.0f * f2)), f3);
        int backgroundColour = CategoryController.getBackgroundColour(this.context, categoryName.toString());
        canvas.save();
        canvas.translate(0.0f, f2 * DROP_SHADOW_HEIGHT);
        Paint paint2 = new Paint();
        paint2.setColor(1711276032);
        paint2.setAntiAlias(true);
        float f4 = i7;
        canvas.drawRoundRect(rectF, f4, f4, paint2);
        canvas.restore();
        Paint paint3 = new Paint();
        paint3.setColor(backgroundColour);
        paint3.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f4, f4, paint3);
        Paint paint4 = new Paint();
        paint4.setColor(-2565928);
        paint4.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f3, f3), f4, f4, paint4);
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.ic_categories);
        int i11 = i7 + i8;
        drawable.setBounds(i8, i8, i11, i11);
        drawable.draw(canvas);
        double red = (Color.red(backgroundColour) * 0.299d) + (Color.green(backgroundColour) * 0.587d) + (Color.blue(backgroundColour) * 0.114d);
        Paint paint5 = new Paint(paint);
        paint5.setColor(red < 186.0d ? -1 : -16777216);
        canvas.drawText(categoryName.toString(), i10, i5 - i9, paint5);
        canvas.restore();
    }
}
