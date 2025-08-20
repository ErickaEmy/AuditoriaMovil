package i2;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import br.fb;
/* loaded from: classes.dex */
public class y extends Paint {
    public y() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((fb.zn(i, 0, 255) << 24) | (getColor() & 16777215));
            return;
        }
        super.setAlpha(fb.zn(i, 0, 255));
    }

    public y(int i) {
        super(i);
    }

    public y(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public y(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }
}
