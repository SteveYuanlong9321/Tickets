package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ParcelByteArray extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ParcelByteArray> CREATOR = new zzgd();
    private byte[] zza;
    private ParcelFileDescriptor zzb;

    private ParcelByteArray() {
        this.zza = new byte[0];
    }

    static byte[] zzb(ParcelFileDescriptor parcelFileDescriptor) {
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
        try {
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.read(bArr);
                zze(dataInputStream);
                return bArr;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            }
        } catch (Throwable th) {
            zze(dataInputStream);
            throw th;
        }
    }

    private static void zze(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("ParcelByteArray", "Could not close stream", e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParcelByteArray) {
            return Arrays.equals(this.zza, ((ParcelByteArray) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00c5: MOVE (r2 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:41:0x00c5 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) throws Throwable {
        DataOutputStream dataOutputStream;
        Closeable closeable;
        ParcelFileDescriptor parcelFileDescriptor;
        byte[] bArr = this.zza;
        Closeable closeable2 = null;
        if (bArr != null && this.zzb == null) {
            try {
                try {
                    try {
                        File fileZzc = zzgy.zzc();
                        if (fileZzc == null) {
                            throw new IllegalStateException("Must set temp dir before writing this object to a parcel");
                        }
                        try {
                            File fileCreateTempFile = File.createTempFile("teleporter" + SystemClock.elapsedRealtime(), ".tmp", fileZzc);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                                ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(fileCreateTempFile, GroupFlagsKt.IsMovableContentFlag);
                                fileCreateTempFile.delete();
                                Pair pairCreate = Pair.create(fileOutputStream, parcelFileDescriptorOpen);
                                dataOutputStream = new DataOutputStream(new BufferedOutputStream((OutputStream) pairCreate.first));
                                try {
                                    dataOutputStream.writeInt(bArr.length);
                                    dataOutputStream.write(bArr);
                                    parcelFileDescriptor = (ParcelFileDescriptor) pairCreate.second;
                                    zze(dataOutputStream);
                                } catch (IOException e) {
                                    e = e;
                                    String string = e.toString();
                                    StringBuilder sb = new StringBuilder(string.length() + 36);
                                    sb.append("Could not write into unlinked file. ");
                                    sb.append(string);
                                    Log.e("ParcelByteArray", sb.toString());
                                    if (dataOutputStream != null) {
                                        zze(dataOutputStream);
                                    }
                                    parcelFileDescriptor = null;
                                } catch (IllegalStateException e2) {
                                    e = e2;
                                    String string2 = e.toString();
                                    StringBuilder sb2 = new StringBuilder(string2.length() + 32);
                                    sb2.append("Could not create unlinked file. ");
                                    sb2.append(string2);
                                    Log.e("ParcelByteArray", sb2.toString());
                                    if (dataOutputStream != null) {
                                        zze(dataOutputStream);
                                    }
                                    parcelFileDescriptor = null;
                                }
                                this.zzb = parcelFileDescriptor;
                            } catch (FileNotFoundException e3) {
                                throw new IllegalStateException("Temporary file is somehow already deleted", e3);
                            }
                        } catch (IOException e4) {
                            throw new IllegalStateException("Could not create temporary file", e4);
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        if (closeable2 != null) {
                            zze(closeable2);
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    dataOutputStream = null;
                }
            } catch (IllegalStateException e6) {
                e = e6;
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (closeable2 != null) {
                    zze(closeable2);
                }
                throw th;
            }
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        this.zzb = null;
    }

    public final byte[] zza() {
        return this.zza;
    }

    final /* synthetic */ void zzc(byte[] bArr) {
        this.zza = bArr;
    }

    final /* synthetic */ ParcelFileDescriptor zzd() {
        return this.zzb;
    }

    ParcelByteArray(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = new byte[0];
        this.zzb = parcelFileDescriptor;
    }
}
