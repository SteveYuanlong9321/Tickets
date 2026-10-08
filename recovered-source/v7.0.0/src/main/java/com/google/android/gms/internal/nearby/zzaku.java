package com.google.android.gms.internal.nearby;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaku {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzaks zzaksVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzaksVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzd(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzalk.zzb((String) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzaik) {
            sb.append(": \"");
            int i3 = zzalk.zza;
            sb.append(zzalk.zza(((zzaik) obj).zzm()));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzajo) {
            sb.append(" {");
            zzc((zzajo) obj, sb, i + 2);
            sb.append("\n");
            zzd(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i4 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, "value", entry.getValue());
        sb.append("\n");
        zzd(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0200  */
    /* JADX WARN: Code duplicated, block: B:102:0x020e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0163  */
    /* JADX WARN: Code duplicated, block: B:59:0x017c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0184  */
    /* JADX WARN: Code duplicated, block: B:63:0x0188  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x0194  */
    /* JADX WARN: Code duplicated, block: B:68:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fe  */
    private static void zzc(zzaks zzaksVar, StringBuilder sb, int i) {
        int i2;
        Method method;
        Method method2;
        Object objZzO;
        boolean zBooleanValue;
        boolean zEquals;
        Method method3;
        Method method4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzaksVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method5 = declaredMethods[i3];
            if (!Modifier.isStatic(method5.getModifiers()) && method5.getName().length() >= 3) {
                if (method5.getName().startsWith("set")) {
                    hashSet.add(method5.getName());
                } else if (Modifier.isPublic(method5.getModifiers()) && method5.getParameterTypes().length == 0) {
                    if (method5.getName().startsWith("has")) {
                        map.put(method5.getName(), method5);
                    } else if (method5.getName().startsWith("get")) {
                        treeMap.put(method5.getName(), method5);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method4 = (Method) entry.getValue()) != null && method4.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzajo.zzO(method4, zzaksVar, new Object[0]));
            } else if (!strSubstring.endsWith("Map") || strSubstring.equals("Map") || (method3 = (Method) entry.getValue()) == null || !method3.getReturnType().equals(Map.class) || method3.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method3.getModifiers())) {
                String.valueOf(strSubstring);
                if (hashSet.contains("set".concat(String.valueOf(strSubstring)))) {
                    if (strSubstring.endsWith("Bytes")) {
                        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 5);
                        String.valueOf(strSubstring2);
                        if (!treeMap.containsKey("get".concat(String.valueOf(strSubstring2)))) {
                            method = (Method) entry.getValue();
                            String.valueOf(strSubstring);
                            method2 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                            if (method != null) {
                                objZzO = zzajo.zzO(method, zzaksVar, new Object[0]);
                                if (method2 == null) {
                                    zBooleanValue = ((Boolean) zzajo.zzO(method2, zzaksVar, new Object[0])).booleanValue();
                                } else if (objZzO instanceof Boolean) {
                                    if (((Boolean) objZzO).booleanValue()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = false;
                                    }
                                } else if (objZzO instanceof Integer) {
                                    if (((Integer) objZzO).intValue() == 0) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (objZzO instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) objZzO).floatValue()) == 0) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (objZzO instanceof Double) {
                                    if (objZzO instanceof String) {
                                        zEquals = objZzO.equals("");
                                    } else if (objZzO instanceof zzaik) {
                                        zEquals = objZzO.equals(zzaik.zza);
                                    } else if ((objZzO instanceof zzaks) ? !((objZzO instanceof Enum) && ((Enum) objZzO).ordinal() == 0) : objZzO != ((zzaks) objZzO).zzbg()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = false;
                                    }
                                    if (zEquals) {
                                        zBooleanValue = false;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                } else if (Double.doubleToRawLongBits(((Double) objZzO).doubleValue()) == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                                if (zBooleanValue) {
                                    zzb(sb, i, strSubstring, objZzO);
                                }
                            }
                        }
                    } else {
                        method = (Method) entry.getValue();
                        String.valueOf(strSubstring);
                        method2 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                        if (method != null) {
                            objZzO = zzajo.zzO(method, zzaksVar, new Object[0]);
                            if (method2 == null) {
                                zBooleanValue = ((Boolean) zzajo.zzO(method2, zzaksVar, new Object[0])).booleanValue();
                            } else if (objZzO instanceof Boolean) {
                                if (((Boolean) objZzO).booleanValue()) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzO instanceof Integer) {
                                if (((Integer) objZzO).intValue() == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzO instanceof Float) {
                                if (Float.floatToRawIntBits(((Float) objZzO).floatValue()) == 0) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (objZzO instanceof Double) {
                                if (objZzO instanceof String) {
                                    zEquals = objZzO.equals("");
                                } else if (objZzO instanceof zzaik) {
                                    zEquals = objZzO.equals(zzaik.zza);
                                } else if (objZzO instanceof zzaks) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                if (zEquals) {
                                    zBooleanValue = false;
                                } else {
                                    zBooleanValue = true;
                                }
                            } else if (Double.doubleToRawLongBits(((Double) objZzO).doubleValue()) == 0) {
                                zBooleanValue = false;
                            } else {
                                zBooleanValue = true;
                            }
                            if (zBooleanValue) {
                                zzb(sb, i, strSubstring, objZzO);
                            }
                        }
                    }
                }
            } else {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzajo.zzO(method3, zzaksVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zzaksVar instanceof zzajl) {
            Iterator itZzc = ((zzajl) zzaksVar).zzb.zzc();
            if (itZzc.hasNext()) {
                throw null;
            }
        }
        zzaln zzalnVar = ((zzajo) zzaksVar).zzc;
        if (zzalnVar != null) {
            zzalnVar.zzj(sb, i);
        }
    }

    private static void zzd(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }
}
