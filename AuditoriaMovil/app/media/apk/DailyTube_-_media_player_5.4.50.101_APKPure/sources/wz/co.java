package wz;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class co {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public TextClassifier f14704n3;
    @NonNull
    public TextView y;

    public co(@NonNull TextView textView) {
        this.y = (TextView) vl.s.fb(textView);
    }

    public void n3(@Nullable TextClassifier textClassifier) {
        this.f14704n3 = textClassifier;
    }

    @NonNull
    public TextClassifier y() {
        TextClassifier textClassifier = this.f14704n3;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.y.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
