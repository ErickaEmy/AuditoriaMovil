package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* compiled from: SerialDescriptor.kt */
/* loaded from: classes2.dex */
public interface SerialDescriptor {
    List getAnnotations();

    List getElementAnnotations(int i);

    SerialDescriptor getElementDescriptor(int i);

    int getElementIndex(String str);

    String getElementName(int i);

    int getElementsCount();

    SerialKind getKind();

    String getSerialName();

    boolean isElementOptional(int i);

    boolean isInline();

    boolean isNullable();

    /* compiled from: SerialDescriptor.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean isInline(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean isNullable(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static List getAnnotations(SerialDescriptor serialDescriptor) {
            return CollectionsKt.emptyList();
        }
    }
}
