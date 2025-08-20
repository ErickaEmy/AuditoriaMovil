package y6;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class zn implements TypeEvaluator<Integer> {
    public static final zn y = new zn();

    @NonNull
    public static zn n3() {
        return y;
    }

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: y */
    public Integer evaluate(float f4, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f6 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = pow3 + (f4 * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f4), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f6 + (((((intValue2 >> 24) & 255) / 255.0f) - f6) * f4)) * 255.0f) << 24) | (Math.round(((float) Math.pow(pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f4), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f));
    }
}
