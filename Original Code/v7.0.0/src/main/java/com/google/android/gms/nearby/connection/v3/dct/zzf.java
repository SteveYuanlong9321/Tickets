package com.google.android.gms.nearby.connection.v3.dct;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf extends zzi {
    private final List zza;

    /* synthetic */ zzf(long j, List list, String str, boolean z, boolean z2, byte[] bArr) {
        Payload.File fileZze;
        Payload.File fileZzc;
        super(j, str, z, z2, null);
        if (list == null) {
            throw new NullPointerException("Cannot create a DctPayload FilesResponse from null filesWithMetaData.");
        }
        this.zza = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zze zzeVar = (zze) it.next();
            ParcelFileDescriptor parcelFileDescriptor = zzeVar.zzb;
            Uri uri = zzeVar.zzd;
            if (parcelFileDescriptor == null) {
                if (uri != null) {
                    fileZzc = Payload.File.zzb(uri, zzeVar.zzc);
                } else {
                    fileZze = Payload.File.zzf();
                    fileZzc = fileZze;
                    uri = null;
                }
            } else if (uri != null) {
                fileZzc = Payload.File.zzc(uri, parcelFileDescriptor, zzeVar.zzc);
            } else {
                fileZze = Payload.File.zze(parcelFileDescriptor, zzeVar.zzc);
                fileZzc = fileZze;
                uri = null;
            }
            this.zza.add(Pair.create(zzeVar.zza, fileZzc));
            Log.i("NC_DctPayload", String.format("created multipart file with requestId:%s, pfd:%s, uri:%s", Long.valueOf(j), parcelFileDescriptor, uri));
        }
    }

    public final List zza() {
        return this.zza;
    }
}
