package com.google.common.collect;

import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
abstract class AbstractMultimap implements Multimap {
    private transient Map asMap;
    private transient Set keySet;

    abstract Map createAsMap();

    abstract Set createKeySet();

    public Set keySet() {
        Set set = this.keySet;
        if (set == null) {
            Set createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }
        return set;
    }

    @Override // com.google.common.collect.Multimap
    public Map asMap() {
        Map map = this.asMap;
        if (map == null) {
            Map createAsMap = createAsMap();
            this.asMap = createAsMap;
            return createAsMap;
        }
        return map;
    }

    public boolean equals(Object obj) {
        return Multimaps.equalsImpl(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
