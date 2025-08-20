package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@CheckReturnValue
/* loaded from: classes.dex */
abstract class ListFieldSchema {
    public static final ListFieldSchema y = new ListFieldSchemaFull();

    /* renamed from: n3  reason: collision with root package name */
    public static final ListFieldSchema f6467n3 = new ListFieldSchemaLite();

    /* loaded from: classes.dex */
    public static final class ListFieldSchemaFull extends ListFieldSchema {

        /* renamed from: zn  reason: collision with root package name */
        public static final Class<?> f6468zn = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public ListFieldSchemaFull() {
            super();
        }

        public static <E> List<E> a(Object obj, long j2) {
            return (List) UnsafeUtil.ej(obj, j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> fb(Object obj, long j2, int i) {
            LazyStringArrayList lazyStringArrayList;
            List<L> arrayList;
            List<L> a2 = a(obj, j2);
            if (a2.isEmpty()) {
                if (a2 instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(i);
                } else if ((a2 instanceof PrimitiveNonBoxingCollection) && (a2 instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) a2).mutableCopyWithCapacity(i);
                } else {
                    arrayList = new ArrayList<>(i);
                }
                UnsafeUtil.f7(obj, j2, arrayList);
                return arrayList;
            }
            if (f6468zn.isAssignableFrom(a2.getClass())) {
                ArrayList arrayList2 = new ArrayList(a2.size() + i);
                arrayList2.addAll(a2);
                UnsafeUtil.f7(obj, j2, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (a2 instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(a2.size() + i);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) a2);
                UnsafeUtil.f7(obj, j2, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else if ((a2 instanceof PrimitiveNonBoxingCollection) && (a2 instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) a2;
                if (!protobufList.isModifiable()) {
                    Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(a2.size() + i);
                    UnsafeUtil.f7(obj, j2, mutableCopyWithCapacity);
                    return mutableCopyWithCapacity;
                }
                return a2;
            } else {
                return a2;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        public <E> void gv(Object obj, Object obj2, long j2) {
            List a2 = a(obj2, j2);
            List fb2 = fb(obj, j2, a2.size());
            int size = fb2.size();
            int size2 = a2.size();
            if (size > 0 && size2 > 0) {
                fb2.addAll(a2);
            }
            if (size > 0) {
                a2 = fb2;
            }
            UnsafeUtil.f7(obj, j2, a2);
        }

        @Override // com.google.protobuf.ListFieldSchema
        public <L> List<L> v(Object obj, long j2) {
            return fb(obj, j2, 10);
        }

        @Override // com.google.protobuf.ListFieldSchema
        public void zn(Object obj, long j2) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.ej(obj, j2);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else if (f6468zn.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.f7(obj, j2, unmodifiableList);
        }
    }

    /* loaded from: classes.dex */
    public static final class ListFieldSchemaLite extends ListFieldSchema {
        public ListFieldSchemaLite() {
            super();
        }

        public static <E> Internal.ProtobufList<E> a(Object obj, long j2) {
            return (Internal.ProtobufList) UnsafeUtil.ej(obj, j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        @Override // com.google.protobuf.ListFieldSchema
        public <E> void gv(Object obj, Object obj2, long j2) {
            Internal.ProtobufList<E> a2 = a(obj, j2);
            Internal.ProtobufList<E> a3 = a(obj2, j2);
            int size = a2.size();
            int size2 = a3.size();
            Internal.ProtobufList<E> protobufList = a2;
            protobufList = a2;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = a2.isModifiable();
                Internal.ProtobufList<E> protobufList2 = a2;
                if (!isModifiable) {
                    protobufList2 = a2.mutableCopyWithCapacity(size2 + size);
                }
                protobufList2.addAll(a3);
                protobufList = protobufList2;
            }
            if (size > 0) {
                a3 = protobufList;
            }
            UnsafeUtil.f7(obj, j2, a3);
        }

        @Override // com.google.protobuf.ListFieldSchema
        public <L> List<L> v(Object obj, long j2) {
            int i;
            Internal.ProtobufList a2 = a(obj, j2);
            if (!a2.isModifiable()) {
                int size = a2.size();
                if (size == 0) {
                    i = 10;
                } else {
                    i = size * 2;
                }
                Internal.ProtobufList mutableCopyWithCapacity = a2.mutableCopyWithCapacity(i);
                UnsafeUtil.f7(obj, j2, mutableCopyWithCapacity);
                return mutableCopyWithCapacity;
            }
            return a2;
        }

        @Override // com.google.protobuf.ListFieldSchema
        public void zn(Object obj, long j2) {
            a(obj, j2).makeImmutable();
        }
    }

    public static ListFieldSchema n3() {
        return f6467n3;
    }

    public static ListFieldSchema y() {
        return y;
    }

    public abstract <L> void gv(Object obj, Object obj2, long j2);

    public abstract <L> List<L> v(Object obj, long j2);

    public abstract void zn(Object obj, long j2);

    public ListFieldSchema() {
    }
}
