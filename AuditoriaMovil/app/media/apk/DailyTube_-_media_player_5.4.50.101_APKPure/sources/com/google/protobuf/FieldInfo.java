package com.google.protobuf;

import com.google.protobuf.Internal;
import java.lang.reflect.Field;
@CheckReturnValue
/* loaded from: classes.dex */
final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: co  reason: collision with root package name */
    public final OneofInfo f6400co;

    /* renamed from: f  reason: collision with root package name */
    public final Field f6401f;

    /* renamed from: f3  reason: collision with root package name */
    public final Object f6402f3;

    /* renamed from: fb  reason: collision with root package name */
    public final Class<?> f6403fb;

    /* renamed from: n  reason: collision with root package name */
    public final Internal.EnumVerifier f6404n;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f6405p;

    /* renamed from: r  reason: collision with root package name */
    public final Class<?> f6406r;

    /* renamed from: s  reason: collision with root package name */
    public final int f6407s;

    /* renamed from: t  reason: collision with root package name */
    public final int f6408t;

    /* renamed from: v  reason: collision with root package name */
    public final FieldType f6409v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f6410w;
    public final Field y;

    /* renamed from: z  reason: collision with root package name */
    public final Field f6411z;

    /* renamed from: com.google.protobuf.FieldInfo$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[FieldType.values().length];
            y = iArr;
            try {
                iArr[FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[FieldType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[FieldType.MESSAGE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[FieldType.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6412a;

        /* renamed from: c5  reason: collision with root package name */
        public Class<?> f6413c5;

        /* renamed from: f  reason: collision with root package name */
        public Internal.EnumVerifier f6414f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f6415fb;

        /* renamed from: gv  reason: collision with root package name */
        public Field f6416gv;

        /* renamed from: i9  reason: collision with root package name */
        public Object f6417i9;

        /* renamed from: n3  reason: collision with root package name */
        public FieldType f6418n3;

        /* renamed from: s  reason: collision with root package name */
        public OneofInfo f6419s;

        /* renamed from: t  reason: collision with root package name */
        public Field f6420t;

        /* renamed from: v  reason: collision with root package name */
        public int f6421v;
        public Field y;

        /* renamed from: zn  reason: collision with root package name */
        public int f6422zn;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public FieldInfo build() {
            OneofInfo oneofInfo = this.f6419s;
            if (oneofInfo != null) {
                return FieldInfo.forOneofMemberField(this.f6422zn, this.f6418n3, oneofInfo, this.f6413c5, this.f6415fb, this.f6414f);
            }
            Object obj = this.f6417i9;
            if (obj != null) {
                return FieldInfo.forMapField(this.y, this.f6422zn, obj, this.f6414f);
            }
            Field field = this.f6416gv;
            if (field != null) {
                if (this.f6412a) {
                    return FieldInfo.forLegacyRequiredField(this.y, this.f6422zn, this.f6418n3, field, this.f6421v, this.f6415fb, this.f6414f);
                }
                return FieldInfo.forExplicitPresenceField(this.y, this.f6422zn, this.f6418n3, field, this.f6421v, this.f6415fb, this.f6414f);
            }
            Internal.EnumVerifier enumVerifier = this.f6414f;
            if (enumVerifier != null) {
                Field field2 = this.f6420t;
                if (field2 == null) {
                    return FieldInfo.forFieldWithEnumVerifier(this.y, this.f6422zn, this.f6418n3, enumVerifier);
                }
                return FieldInfo.forPackedFieldWithEnumVerifier(this.y, this.f6422zn, this.f6418n3, enumVerifier, field2);
            }
            Field field3 = this.f6420t;
            if (field3 == null) {
                return FieldInfo.forField(this.y, this.f6422zn, this.f6418n3, this.f6415fb);
            }
            return FieldInfo.forPackedField(this.y, this.f6422zn, this.f6418n3, field3);
        }

        public Builder withCachedSizeField(Field field) {
            this.f6420t = field;
            return this;
        }

        public Builder withEnforceUtf8(boolean z2) {
            this.f6415fb = z2;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier) {
            this.f6414f = enumVerifier;
            return this;
        }

        public Builder withField(Field field) {
            if (this.f6419s == null) {
                this.y = field;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int i) {
            this.f6422zn = i;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.f6417i9 = obj;
            return this;
        }

        public Builder withOneof(OneofInfo oneofInfo, Class<?> cls) {
            if (this.y == null && this.f6416gv == null) {
                this.f6419s = oneofInfo;
                this.f6413c5 = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(Field field, int i) {
            this.f6416gv = (Field) Internal.n3(field, "presenceField");
            this.f6421v = i;
            return this;
        }

        public Builder withRequired(boolean z2) {
            this.f6412a = z2;
            return this;
        }

        public Builder withType(FieldType fieldType) {
            this.f6418n3 = fieldType;
            return this;
        }

        public Builder() {
        }
    }

    public FieldInfo(Field field, int i, FieldType fieldType, Class<?> cls, Field field2, int i5, boolean z2, boolean z3, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, Field field3) {
        this.y = field;
        this.f6409v = fieldType;
        this.f6403fb = cls;
        this.f6407s = i;
        this.f6401f = field2;
        this.f6408t = i5;
        this.f6410w = z2;
        this.f6405p = z3;
        this.f6400co = oneofInfo;
        this.f6406r = cls2;
        this.f6402f3 = obj;
        this.f6404n = enumVerifier;
        this.f6411z = field3;
    }

    public static FieldInfo forExplicitPresenceField(Field field, int i, FieldType fieldType, Field field2, int i5, boolean z2, Internal.EnumVerifier enumVerifier) {
        y(i);
        Internal.n3(field, "field");
        Internal.n3(fieldType, "fieldType");
        Internal.n3(field2, "presenceField");
        if (field2 != null && !n3(i5)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i5);
        }
        return new FieldInfo(field, i, fieldType, null, field2, i5, false, z2, null, null, null, enumVerifier, null);
    }

    public static FieldInfo forField(Field field, int i, FieldType fieldType, boolean z2) {
        y(i);
        Internal.n3(field, "field");
        Internal.n3(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i, fieldType, null, null, 0, false, z2, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forFieldWithEnumVerifier(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        y(i);
        Internal.n3(field, "field");
        return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, null);
    }

    public static FieldInfo forLegacyRequiredField(Field field, int i, FieldType fieldType, Field field2, int i5, boolean z2, Internal.EnumVerifier enumVerifier) {
        y(i);
        Internal.n3(field, "field");
        Internal.n3(fieldType, "fieldType");
        Internal.n3(field2, "presenceField");
        if (field2 != null && !n3(i5)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i5);
        }
        return new FieldInfo(field, i, fieldType, null, field2, i5, true, z2, null, null, null, enumVerifier, null);
    }

    public static FieldInfo forMapField(Field field, int i, Object obj, Internal.EnumVerifier enumVerifier) {
        Internal.n3(obj, "mapDefaultEntry");
        y(i);
        Internal.n3(field, "field");
        return new FieldInfo(field, i, FieldType.MAP, null, null, 0, false, true, null, null, obj, enumVerifier, null);
    }

    public static FieldInfo forOneofMemberField(int i, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z2, Internal.EnumVerifier enumVerifier) {
        y(i);
        Internal.n3(fieldType, "fieldType");
        Internal.n3(oneofInfo, "oneof");
        Internal.n3(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo(null, i, fieldType, null, null, 0, false, z2, oneofInfo, cls, null, enumVerifier, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i + " is of type " + fieldType);
    }

    public static FieldInfo forPackedField(Field field, int i, FieldType fieldType, Field field2) {
        y(i);
        Internal.n3(field, "field");
        Internal.n3(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo forPackedFieldWithEnumVerifier(Field field, int i, FieldType fieldType, Internal.EnumVerifier enumVerifier, Field field2) {
        y(i);
        Internal.n3(field, "field");
        return new FieldInfo(field, i, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, field2);
    }

    public static FieldInfo forRepeatedMessageField(Field field, int i, FieldType fieldType, Class<?> cls) {
        y(i);
        Internal.n3(field, "field");
        Internal.n3(fieldType, "fieldType");
        Internal.n3(cls, "messageClass");
        return new FieldInfo(field, i, fieldType, cls, null, 0, false, false, null, null, null, null, null);
    }

    public static boolean n3(int i) {
        return i != 0 && (i & (i + (-1))) == 0;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static void y(int i) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException("fieldNumber must be positive: " + i);
    }

    public Field getCachedSizeField() {
        return this.f6411z;
    }

    public Internal.EnumVerifier getEnumVerifier() {
        return this.f6404n;
    }

    public Field getField() {
        return this.y;
    }

    public int getFieldNumber() {
        return this.f6407s;
    }

    public Class<?> getListElementType() {
        return this.f6403fb;
    }

    public Object getMapDefaultEntry() {
        return this.f6402f3;
    }

    public Class<?> getMessageFieldClass() {
        int i = AnonymousClass1.y[this.f6409v.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                return null;
            }
            return this.f6403fb;
        }
        Field field = this.y;
        if (field != null) {
            return field.getType();
        }
        return this.f6406r;
    }

    public OneofInfo getOneof() {
        return this.f6400co;
    }

    public Class<?> getOneofStoredType() {
        return this.f6406r;
    }

    public Field getPresenceField() {
        return this.f6401f;
    }

    public int getPresenceMask() {
        return this.f6408t;
    }

    public FieldType getType() {
        return this.f6409v;
    }

    public boolean isEnforceUtf8() {
        return this.f6405p;
    }

    public boolean isRequired() {
        return this.f6410w;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        return this.f6407s - fieldInfo.f6407s;
    }
}
