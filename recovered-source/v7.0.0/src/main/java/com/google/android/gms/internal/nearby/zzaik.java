package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaik implements Iterable, Serializable {
    public static final zzaik zza = new zzaij(zzaka.zza);
    private int zzb = 0;

    static {
        int i = zzahy.zza;
    }

    zzaik() {
    }

    public static zzaik zzj(byte[] bArr, int i, int i2) {
        try {
            return zzk(bArr, i, i2, false);
        } catch (zzakf e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    static zzaik zzk(byte[] bArr, int i, int i2, boolean z) throws zzakf {
        if (i2 == 0) {
            return zza;
        }
        zzn(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzaij(bArr2);
    }

    static zzaik zzl(byte[] bArr, boolean z) throws zzakf {
        return bArr.length == 0 ? zza : new zzaij(bArr);
    }

    static /* synthetic */ boolean zzo(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i + i3;
        zzn(i, i4, bArr.length);
        zzn(i2, i3 + i2, bArr2.length);
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaik)) {
            return false;
        }
        zzaik zzaikVar = (zzaik) obj;
        int iZzb = zzb();
        if (iZzb != zzaikVar.zzb()) {
            return false;
        }
        if (iZzb == 0) {
            return true;
        }
        int i = this.zzb;
        int i2 = zzaikVar.zzb;
        if (i == 0 || i2 == 0 || i == i2) {
            return zzf(zzaikVar);
        }
        return false;
    }

    public final int hashCode() {
        int iZzg = this.zzb;
        if (iZzg == 0) {
            int iZzb = zzb();
            iZzg = zzg(iZzb, 0, iZzb);
            if (iZzg == 0) {
                iZzg = 1;
            }
            this.zzb = iZzg;
        }
        return iZzg;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzaid(this);
    }

    public final String toString() {
        String strConcat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            int i = zzalk.zza;
            strConcat = zzalk.zza(zzm());
        } else {
            zzaik zzaikVarZzc = zzc(0, 47);
            int i2 = zzalk.zza;
            strConcat = zzalk.zza(zzaikVarZzc.zzm()).concat("...");
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strConcat);
    }

    abstract byte zza(int i);

    public abstract int zzb();

    public abstract zzaik zzc(int i, int i2);

    protected abstract void zzd(byte[] bArr, int i, int i2, int i3);

    abstract void zze(zzaic zzaicVar) throws IOException;

    protected abstract boolean zzf(zzaik zzaikVar);

    protected abstract int zzg(int i, int i2, int i3);

    public final byte[] zzm() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzaka.zza;
        }
        byte[] bArr = new byte[iZzb];
        zzd(bArr, 0, 0, iZzb);
        return bArr;
    }

    static int zzn(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
