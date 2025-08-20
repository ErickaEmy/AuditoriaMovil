package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageLiteToString {
    public static final char[] y;

    static {
        char[] cArr = new char[80];
        y = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String a(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        v(messageLite, sb, 0);
        return sb.toString();
    }

    public static void gv(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                gv(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                gv(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            y(i, sb);
            sb.append(zn(str));
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.zn((String) obj));
                sb.append('\"');
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.y((ByteString) obj));
                sb.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                v((GeneratedMessageLite) obj, sb, i + 2);
                sb.append("\n");
                y(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i + 2;
                gv(sb, i5, "key", entry2.getKey());
                gv(sb, i5, "value", entry2.getValue());
                sb.append("\n");
                y(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    public static boolean n3(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (Float.floatToRawIntBits(((Float) obj).floatValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if ((obj instanceof Enum) && ((Enum) obj).ordinal() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void v(MessageLite messageLite, StringBuilder sb, int i) {
        int i5;
        boolean booleanValue;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i6 = 0;
        while (true) {
            i5 = 3;
            if (i6 >= length) {
                break;
            }
            Method method3 = declaredMethods[i6];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i6++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i5);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                gv(sb, i, substring.substring(0, substring.length() - 4), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                gv(sb, i, substring.substring(0, substring.length() - 3), GeneratedMessageLite.invokeOrDie(method, messageLite, new Object[0]));
            } else {
                if (hashSet.contains("set" + substring)) {
                    if (substring.endsWith("Bytes")) {
                        if (treeMap.containsKey("get" + substring.substring(0, substring.length() - 5))) {
                        }
                    }
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has" + substring);
                    if (method4 != null) {
                        Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0]);
                        if (method5 == null) {
                            if (!n3(invokeOrDie)) {
                                booleanValue = true;
                            } else {
                                booleanValue = false;
                            }
                        } else {
                            booleanValue = ((Boolean) GeneratedMessageLite.invokeOrDie(method5, messageLite, new Object[0])).booleanValue();
                        }
                        if (booleanValue) {
                            gv(sb, i, substring, invokeOrDie);
                        }
                    }
                }
            }
            i5 = 3;
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next = it.next();
                gv(sb, i, "[" + next.getKey().getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.tl(sb, i);
        }
    }

    public static void y(int i, StringBuilder sb) {
        int i5;
        while (i > 0) {
            char[] cArr = y;
            if (i > cArr.length) {
                i5 = cArr.length;
            } else {
                i5 = i;
            }
            sb.append(cArr, 0, i5);
            i -= i5;
        }
    }

    public static String zn(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
