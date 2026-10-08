package com.google.android.gms.nearby.internal.connection;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.internal.nearby.zzxd;
import com.google.android.gms.internal.nearby.zzyg;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgy {
    private static File zza;

    public static Payload zza(Context context, zzgq zzgqVar) {
        Uri uriZzb;
        String strZzc;
        String strZzc2;
        String strZza;
        if (zzgqVar.zzm() == null && zzgqVar.zzn() == null && zzgqVar.zzo() == null) {
            long jZza = zzgqVar.zza();
            int iZzb = zzgqVar.zzb();
            if (iZzb == 1) {
                byte[] bArrZze = zze(zzgqVar);
                zzxd.zzg(bArrZze, "Payload bytes cannot be null if type is BYTES.");
                return Payload.zza(bArrZze, jZza);
            }
            if (iZzb != 2) {
                if (iZzb != 3) {
                    Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzgqVar.zza()), Integer.valueOf(zzgqVar.zzb())));
                    return null;
                }
                ParcelFileDescriptor parcelFileDescriptorZzd = zzgqVar.zzd();
                zzxd.zzg(parcelFileDescriptorZzd, "Data ParcelFileDescriptor cannot be null for type STREAM");
                return Payload.zzd(Payload.Stream.zzb(parcelFileDescriptorZzd), jZza);
            }
            String strZze = zzgqVar.zze();
            Uri uriZzh = zzgqVar.zzh();
            if (strZze == null || uriZzh == null) {
                if (uriZzh != null && zzgqVar.zzd() == null) {
                    Log.d("NearbyConnections", "Created file payload based on uri instead pfd");
                    return Payload.zzb(uriZzh, zzgqVar.zzj(), jZza);
                }
                ParcelFileDescriptor parcelFileDescriptorZzd2 = zzgqVar.zzd();
                zzxd.zzg(parcelFileDescriptorZzd2, "Data ParcelFileDescriptor cannot be null for type FILE");
                return Payload.zzc(Payload.File.zzd(parcelFileDescriptorZzd2), jZza);
            }
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uriZzh, "r");
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    Log.w("NearbyConnections", String.format("Failed to get ParcelFileDescriptor for %s", uriZzh));
                    return null;
                }
                com.google.android.gms.internal.nearby.zzn.zza();
                int i = com.google.android.gms.internal.nearby.zzr.zza;
                Payload payloadZzc = Payload.zzc(Payload.File.zza(new File(strZze), parcelFileDescriptorOpenFileDescriptor, zzgqVar.zzf(), uriZzh), jZza);
                if (!TextUtils.isEmpty(zzgqVar.zzl())) {
                    payloadZzc.setParentFolder(zzgqVar.zzl());
                }
                if (!TextUtils.isEmpty(zzgqVar.zzk())) {
                    payloadZzc.setFileName(zzgqVar.zzk());
                }
                return payloadZzc;
            } catch (FileNotFoundException e) {
                Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZzh, strZze), e);
                return null;
            } catch (SecurityException e2) {
                Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZzh, strZze), e2);
                return null;
            }
        }
        zzgn zzgnVarZzo = zzgqVar.zzo();
        zzgt zzgtVarZzm = zzgqVar.zzm();
        zzgw zzgwVarZzn = zzgqVar.zzn();
        int iZzp = zzgqVar.zzp();
        int i2 = 0;
        if (iZzp == 1) {
            if (zzgtVarZzm == null || (uriZzb = zzgtVarZzm.zzb()) == null) {
                return null;
            }
            String strZzc3 = zzgtVarZzm.zzc();
            long jZza2 = zzgqVar.zza();
            ArrayMap arrayMap = null;
            long jZza3 = zzgtVarZzm.zza();
            byte[] bArrZze2 = zze(zzgqVar);
            zzgh[] zzghVarArrZzd = zzgtVarZzm.zzd();
            if (zzghVarArrZzd != null) {
                arrayMap = new ArrayMap();
                while (i2 < zzghVarArrZzd.length) {
                    zzgh zzghVar = zzghVarArrZzd[i2];
                    String strZza2 = zzghVar.zza();
                    String strZzb = zzghVar.zzb();
                    if (strZza2 != null && strZzb != null) {
                        arrayMap.put(strZza2, strZzb);
                    }
                    i2++;
                }
            }
            return com.google.android.gms.nearby.connection.v3.dct.zzj.zzj(uriZzb, jZza2, jZza3, strZzc3, bArrZze2, arrayMap);
        }
        if (iZzp == 2) {
            if (zzgwVarZzn == null || (strZzc = zzgwVarZzn.zzc()) == null) {
                return null;
            }
            long jZza4 = zzgqVar.zza();
            long jZzb = zzgwVarZzn.zzb();
            ParcelByteArray[] parcelByteArrayArrZzf = zzgwVarZzn.zzf();
            LinkedList linkedList = new LinkedList();
            int length = parcelByteArrayArrZzf.length;
            while (i2 < length) {
                linkedList.add(parcelByteArrayArrZzf[i2].zza());
                i2++;
            }
            return com.google.android.gms.nearby.connection.v3.dct.zzj.zzk(jZza4, jZzb, zzyg.zzs(linkedList), strZzc, zzgwVarZzn.zza(), zzgwVarZzn.zze());
        }
        if (iZzp != 3) {
            if (iZzp != 4 || zzgnVarZzo == null) {
                return null;
            }
            ParcelByteArray parcelByteArrayZzb = zzgnVarZzo.zzb();
            byte[] bArrZza = parcelByteArrayZzb != null ? parcelByteArrayZzb.zza() : null;
            if (bArrZza == null || (strZza = zzgnVarZzo.zza()) == null) {
                return null;
            }
            return com.google.android.gms.nearby.connection.v3.dct.zzj.zzi(zzgqVar.zza(), strZza, bArrZza);
        }
        if (zzgwVarZzn == null || (strZzc2 = zzgwVarZzn.zzc()) == null) {
            return null;
        }
        long jZza5 = zzgqVar.zza();
        long jZzb2 = zzgwVarZzn.zzb();
        zzgk[] zzgkVarArrZzd = zzgwVarZzn.zzd();
        LinkedList linkedList2 = new LinkedList();
        int length2 = zzgkVarArrZzd.length;
        while (i2 < length2) {
            zzgk zzgkVar = zzgkVarArrZzd[i2];
            Uri uriZzd = zzgkVar.zzd();
            ParcelFileDescriptor parcelFileDescriptorZzb = zzgkVar.zzb();
            byte[] bArrZza2 = zzgkVar.zza();
            zzxd.zzg(bArrZza2, "FileMetaData cannot be null for type FILE");
            linkedList2.add(new com.google.android.gms.nearby.connection.v3.dct.zze(uriZzd, parcelFileDescriptorZzb, bArrZza2, zzgkVar.zzc()));
            i2++;
        }
        return com.google.android.gms.nearby.connection.v3.dct.zzj.zzl(jZza5, jZzb2, zzyg.zzs(linkedList2), strZzc2, zzgwVarZzn.zza(), zzgwVarZzn.zze());
    }

    public static void zzb(File file) {
        if (file == null) {
            Log.e("NearbyConnections", "Cannot set null temp directory");
        } else {
            zza = file;
        }
    }

    static File zzc() {
        return zza;
    }

    public static void zzd(zzgp zzgpVar, byte[] bArr) {
        if (bArr == null || bArr.length <= 32768) {
            zzgpVar.zzc(bArr);
            return;
        }
        zzge zzgeVar = new zzge();
        zzgeVar.zza(bArr);
        zzgpVar.zzk(zzgeVar.zzb());
        zzgpVar.zzc(Arrays.copyOf(bArr, 32768));
    }

    public static byte[] zze(zzgq zzgqVar) {
        ParcelByteArray parcelByteArrayZzi = zzgqVar.zzi();
        return parcelByteArrayZzi != null ? parcelByteArrayZzi.zza() : zzgqVar.zzc();
    }
}
