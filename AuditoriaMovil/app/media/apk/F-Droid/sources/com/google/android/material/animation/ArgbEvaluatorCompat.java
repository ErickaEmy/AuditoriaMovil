package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
/* loaded from: classes.dex */
public class ArgbEvaluatorCompat implements TypeEvaluator {
    private static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((intValue >> 24) & GF2Field.MASK) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow(((intValue >> 16) & GF2Field.MASK) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & GF2Field.MASK) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & GF2Field.MASK) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & GF2Field.MASK) / 255.0f, 2.2d);
        float pow5 = pow3 + (f * (((float) Math.pow((intValue2 & GF2Field.MASK) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f2 + (((((intValue2 >> 24) & GF2Field.MASK) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(((float) Math.pow(pow2 + ((((float) Math.pow(((intValue2 >> 8) & GF2Field.MASK) / 255.0f, 2.2d)) - pow2) * f), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f));
    }
}
