package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
/* compiled from: ImageVector.kt */
/* loaded from: classes.dex */
public abstract class ImageVectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean push(ArrayList arrayList, Object obj) {
        return arrayList.add(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object pop(ArrayList arrayList) {
        return arrayList.remove(arrayList.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object peek(ArrayList arrayList) {
        return arrayList.get(arrayList.size() - 1);
    }
}
