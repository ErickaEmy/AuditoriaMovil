package ie1;

import java.lang.annotation.Annotation;
/* loaded from: classes.dex */
public final class x4 implements r {
    public static final r y = new x4();

    public static Annotation[] y(Annotation[] annotationArr) {
        if (i4.tl(annotationArr, r.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = y;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return r.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof r;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + r.class.getName() + "()";
    }
}
