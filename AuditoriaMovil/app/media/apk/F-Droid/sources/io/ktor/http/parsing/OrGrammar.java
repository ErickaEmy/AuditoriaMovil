package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParserDsl.kt */
/* loaded from: classes.dex */
public final class OrGrammar extends Grammar implements ComplexGrammar {
    private final List grammars;

    @Override // io.ktor.http.parsing.ComplexGrammar
    public List getGrammars() {
        return this.grammars;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrGrammar(List sourceGrammars) {
        super(null);
        Intrinsics.checkNotNullParameter(sourceGrammars, "sourceGrammars");
        ArrayList arrayList = new ArrayList();
        Iterator it = sourceGrammars.iterator();
        while (it.hasNext()) {
            Grammar grammar = (Grammar) it.next();
            if (grammar instanceof OrGrammar) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((ComplexGrammar) grammar).getGrammars());
            } else {
                arrayList.add(grammar);
            }
        }
        this.grammars = arrayList;
    }
}
