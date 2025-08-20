package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
/* compiled from: ValueClassRepresentation.kt */
/* loaded from: classes2.dex */
public abstract class ValueClassRepresentation {
    private ValueClassRepresentation() {
    }

    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean containsPropertyWithName(Name name);

    public abstract List getUnderlyingPropertyNamesToTypes();

    public final ValueClassRepresentation mapUnderlyingType(Function1 transform) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (this instanceof InlineClassRepresentation) {
            InlineClassRepresentation inlineClassRepresentation = (InlineClassRepresentation) this;
            return new InlineClassRepresentation(inlineClassRepresentation.getUnderlyingPropertyName(), (SimpleTypeMarker) transform.invoke(inlineClassRepresentation.getUnderlyingType()));
        } else if (this instanceof MultiFieldValueClassRepresentation) {
            List<Pair> underlyingPropertyNamesToTypes = getUnderlyingPropertyNamesToTypes();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(underlyingPropertyNamesToTypes, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Pair pair : underlyingPropertyNamesToTypes) {
                arrayList.add(TuplesKt.to((Name) pair.component1(), transform.invoke((SimpleTypeMarker) pair.component2())));
            }
            return new MultiFieldValueClassRepresentation(arrayList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
