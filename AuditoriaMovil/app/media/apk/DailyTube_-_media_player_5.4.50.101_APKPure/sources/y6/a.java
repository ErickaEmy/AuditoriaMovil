package y6;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class a extends Property<ImageView, Matrix> {
    public final Matrix y;

    public a() {
        super(Matrix.class, "imageMatrixProperty");
        this.y = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: n3 */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: y */
    public Matrix get(@NonNull ImageView imageView) {
        this.y.set(imageView.getImageMatrix());
        return this.y;
    }
}
