package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!z2 || !Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            return copyOf;
        }
        return tArr;
    }

    public static <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    public static <T> List<T> listOf(T t2) {
        List<T> singletonList = Collections.singletonList(t2);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static <T> T[] terminateCollectionToArray(int i, T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i < array.length) {
            array[i] = null;
        }
        return array;
    }

    public static <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }
}
