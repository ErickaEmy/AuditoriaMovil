package t;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class y {
    public Context y;

    public y(Context context) {
        this.y = context;
    }

    public static y n3(Context context) {
        return new y(context);
    }

    public int a() {
        TypedArray obtainStyledAttributes = this.y.obtainStyledAttributes(null, R$styleable.y, R$attr.f664zn, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.f849i9, 0);
        Resources resources = this.y.getResources();
        if (!fb()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R$dimen.y));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean fb() {
        return this.y.getResources().getBoolean(R$bool.y);
    }

    public int gv() {
        Configuration configuration = this.y.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i <= 600) {
            if (i <= 960 || i5 <= 720) {
                if (i <= 720 || i5 <= 960) {
                    if (i < 500) {
                        if (i <= 640 || i5 <= 480) {
                            if (i <= 480 || i5 <= 640) {
                                if (i >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public boolean s() {
        return true;
    }

    public int v() {
        return this.y.getResources().getDimensionPixelSize(R$dimen.f678n3);
    }

    public boolean y() {
        if (this.y.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int zn() {
        return this.y.getResources().getDisplayMetrics().widthPixels / 2;
    }
}
