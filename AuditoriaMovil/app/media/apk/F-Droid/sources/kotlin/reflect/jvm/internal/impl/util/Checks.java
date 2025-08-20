package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;
/* compiled from: modifierChecks.kt */
/* loaded from: classes2.dex */
public final class Checks {
    private final Function1 additionalCheck;
    private final Check[] checks;
    private final Name name;
    private final Collection nameList;
    private final Regex regex;

    private Checks(Name name, Regex regex, Collection collection, Function1 function1, Check... checkArr) {
        this.name = name;
        this.regex = regex;
        this.nameList = collection;
        this.additionalCheck = function1;
        this.checks = checkArr;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.name == null || Intrinsics.areEqual(functionDescriptor.getName(), this.name)) {
            if (this.regex != null) {
                String asString = functionDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                if (!this.regex.matches(asString)) {
                    return false;
                }
            }
            Collection collection = this.nameList;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public final CheckResult checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        for (Check check : this.checks) {
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String str = (String) this.additionalCheck.invoke(functionDescriptor);
        if (str != null) {
            return new CheckResult.IllegalSignature(str);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public /* synthetic */ Checks(Name name, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.2
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Name name, Check[] checks, Function1 additionalChecks) {
        this(name, (Regex) null, (Collection) null, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.3
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Regex regex, Check[] checks, Function1 additionalChecks) {
        this((Name) null, regex, (Collection) null, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.4
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FunctionDescriptor functionDescriptor) {
                Intrinsics.checkNotNullParameter(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(Collection nameList, Check[] checks, Function1 additionalChecks) {
        this((Name) null, (Regex) null, nameList, additionalChecks, (Check[]) Arrays.copyOf(checks, checks.length));
        Intrinsics.checkNotNullParameter(nameList, "nameList");
        Intrinsics.checkNotNullParameter(checks, "checks");
        Intrinsics.checkNotNullParameter(additionalChecks, "additionalChecks");
    }
}
