package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {
    public final Object y;

    public JsonPrimitive(Boolean bool) {
        this.y = C$Gson$Preconditions.checkNotNull(bool);
    }

    public static boolean y(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.y;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.y == null) {
            if (jsonPrimitive.y == null) {
                return true;
            }
            return false;
        } else if (y(this) && y(jsonPrimitive)) {
            if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
                return true;
            }
            return false;
        } else {
            Object obj2 = this.y;
            if ((obj2 instanceof Number) && (jsonPrimitive.y instanceof Number)) {
                double doubleValue = getAsNumber().doubleValue();
                double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
                if (doubleValue == doubleValue2) {
                    return true;
                }
                if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                    return true;
                }
                return false;
            }
            return obj2.equals(jsonPrimitive.y);
        }
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object obj = this.y;
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        return new BigDecimal(this.y.toString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object obj = this.y;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return new BigInteger(this.y.toString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.y).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (isNumber()) {
            return getAsNumber().byteValue();
        }
        return Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (isNumber()) {
            return getAsNumber().doubleValue();
        }
        return Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (isNumber()) {
            return getAsNumber().floatValue();
        }
        return Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (isNumber()) {
            return getAsNumber().intValue();
        }
        return Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (isNumber()) {
            return getAsNumber().longValue();
        }
        return Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object obj = this.y;
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        return (Number) obj;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (isNumber()) {
            return getAsNumber().shortValue();
        }
        return Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.y).toString();
        }
        return (String) this.y;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.y == null) {
            return 31;
        }
        if (y(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.y;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean isBoolean() {
        return this.y instanceof Boolean;
    }

    public boolean isNumber() {
        return this.y instanceof Number;
    }

    public boolean isString() {
        return this.y instanceof String;
    }

    public JsonPrimitive(Number number) {
        this.y = C$Gson$Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(String str) {
        this.y = C$Gson$Preconditions.checkNotNull(str);
    }

    public JsonPrimitive(Character ch) {
        this.y = ((Character) C$Gson$Preconditions.checkNotNull(ch)).toString();
    }
}
