package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkk {
    private static volatile zzxb zza;

    private zzkk() {
    }

    public static zzxb zza(Context context) {
        zzxb zzxbVarZze;
        zzxb zzxbVarZze2;
        zzxb zzxbVar = zza;
        if (zzxbVar != null) {
            return zzxbVar;
        }
        synchronized (zzkk.class) {
            zzxbVarZze = zza;
            if (zzxbVarZze == null) {
                String str = Build.TYPE;
                String str2 = Build.TAGS;
                int i = zzkl.zza;
                if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
                    Context contextZzd = zzkf.zzd(context);
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        StrictMode.allowThreadDiskWrites();
                        char c = 0;
                        try {
                            File file = new File(contextZzd.getDir("phenotype_hermetic", 0), "overrides.txt");
                            zzxbVarZze2 = file.exists() ? zzxb.zzf(file) : zzxb.zze();
                        } catch (RuntimeException e) {
                            Log.e("HermeticFileOverrides", "no data dir", e);
                            zzxbVarZze2 = zzxb.zze();
                        }
                        if (zzxbVarZze2.zza()) {
                            File file2 = (File) zzxbVarZze2.zzb();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                    HashMap map = new HashMap();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        String[] strArrSplit = line.split(" ", 3);
                                        if (strArrSplit.length != 3) {
                                            StringBuilder sb = new StringBuilder(line.length() + 9);
                                            sb.append("Invalid: ");
                                            sb.append(line);
                                            Log.e("HermeticFileOverrides", sb.toString());
                                        } else {
                                            String str3 = new String(strArrSplit[c]);
                                            String strDecode = Uri.decode(new String(strArrSplit[1]));
                                            String strDecode2 = (String) map.get(strArrSplit[2]);
                                            if (strDecode2 == null) {
                                                String str4 = new String(strArrSplit[2]);
                                                strDecode2 = Uri.decode(str4);
                                                if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                    map.put(str4, strDecode2);
                                                }
                                            }
                                            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                            if (simpleArrayMap2 == null) {
                                                simpleArrayMap2 = new SimpleArrayMap();
                                                simpleArrayMap.put(str3, simpleArrayMap2);
                                            }
                                            simpleArrayMap2.put(strDecode, strDecode2);
                                            c = 0;
                                        }
                                    }
                                    String string = file2.toString();
                                    String packageName = contextZzd.getPackageName();
                                    StringBuilder sb2 = new StringBuilder(string.length() + 28 + String.valueOf(packageName).length());
                                    sb2.append("Parsed ");
                                    sb2.append(string);
                                    sb2.append(" for Android package ");
                                    sb2.append(packageName);
                                    Log.w("HermeticFileOverrides", sb2.toString());
                                    zzkj zzkjVar = new zzkj(simpleArrayMap);
                                    bufferedReader.close();
                                    zzxbVarZze = zzxb.zzf(zzkjVar);
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                        throw th;
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                        throw th;
                                    }
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } else {
                            zzxbVarZze = zzxb.zze();
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    } catch (Throwable th3) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th3;
                    }
                } else {
                    zzxbVarZze = zzxb.zze();
                }
                zza = zzxbVarZze;
            }
        }
        return zzxbVarZze;
    }
}
