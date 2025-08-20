package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ExtensionRegistryLite {

    /* renamed from: gv  reason: collision with root package name */
    public static volatile ExtensionRegistryLite f6394gv = null;

    /* renamed from: n3  reason: collision with root package name */
    public static volatile boolean f6395n3 = false;

    /* renamed from: v  reason: collision with root package name */
    public static final ExtensionRegistryLite f6396v = new ExtensionRegistryLite(true);

    /* renamed from: zn  reason: collision with root package name */
    public static boolean f6397zn = true;
    public final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> y;

    /* loaded from: classes.dex */
    public static class ExtensionClassHolder {
        public static final Class<?> y = y();

        public static Class<?> y() {
            try {
                return Class.forName("com.google.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class ObjectIntPair {

        /* renamed from: n3  reason: collision with root package name */
        public final int f6398n3;
        public final Object y;

        public ObjectIntPair(Object obj, int i) {
            this.y = obj;
            this.f6398n3 = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.y != objectIntPair.y || this.f6398n3 != objectIntPair.f6398n3) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.y) * 65535) + this.f6398n3;
        }
    }

    public ExtensionRegistryLite() {
        this.y = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        if (!f6397zn) {
            return f6396v;
        }
        ExtensionRegistryLite extensionRegistryLite = f6394gv;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                try {
                    extensionRegistryLite = f6394gv;
                    if (extensionRegistryLite == null) {
                        extensionRegistryLite = ExtensionRegistryFactory.createEmpty();
                        f6394gv = extensionRegistryLite;
                    }
                } finally {
                }
            }
        }
        return extensionRegistryLite;
    }

    public static boolean isEagerlyParseMessageSets() {
        return f6395n3;
    }

    public static ExtensionRegistryLite newInstance() {
        if (f6397zn) {
            return ExtensionRegistryFactory.create();
        }
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z2) {
        f6395n3 = z2;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.y.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.y.get(new ObjectIntPair(containingtype, i));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == f6396v) {
            this.y = Collections.emptyMap();
        } else {
            this.y = Collections.unmodifiableMap(extensionRegistryLite.y);
        }
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (f6397zn && ExtensionRegistryFactory.n3(this)) {
            try {
                getClass().getMethod("add", ExtensionClassHolder.y).invoke(this, extensionLite);
            } catch (Exception e2) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extensionLite), e2);
            }
        }
    }

    public ExtensionRegistryLite(boolean z2) {
        this.y = Collections.emptyMap();
    }
}
