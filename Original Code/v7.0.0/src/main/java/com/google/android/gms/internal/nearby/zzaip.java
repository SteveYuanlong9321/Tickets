package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaip {
    private final zzaio zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzaip(zzaio zzaioVar) {
        this.zza = zzaioVar;
        zzaioVar.zzd = this;
    }

    private final void zzQ(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
    }

    private final void zzR(Object obj, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        zzaio zzaioVar = this.zza;
        int iZzx = zzaioVar.zzx();
        zzaioVar.zzN();
        int iZzC = zzaioVar.zzC(iZzx);
        zzaioVar.zza++;
        zzaldVar.zzg(obj, this, zzaizVar);
        zzaioVar.zzb(0);
        zzaioVar.zza--;
        if (zzaioVar.zzE() != 0) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        zzaioVar.zzD(iZzC);
    }

    private final Object zzS(zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        Object objZza = zzaldVar.zza();
        zzR(objZza, zzaldVar, zzaizVar);
        zzaldVar.zzk(objZza);
        return objZza;
    }

    private final void zzT(Object obj, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        zzaio zzaioVar = this.zza;
        zzaioVar.zzN();
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        zzaioVar.zzb++;
        try {
            zzaldVar.zzg(obj, this, zzaizVar);
            if (this.zzb != this.zzc) {
                throw new zzakf("Failed to parse the message.");
            }
            this.zza.zzb--;
            this.zzc = i;
        } catch (Throwable th) {
            this.zza.zzb--;
            this.zzc = i;
            throw th;
        }
    }

    private final Object zzU(zzalz zzalzVar, Class cls, zzaiz zzaizVar) throws IOException {
        zzalz zzalzVar2 = zzalz.DOUBLE;
        switch (zzalzVar) {
            case DOUBLE:
                return Double.valueOf(zze());
            case FLOAT:
                return Float.valueOf(zzf());
            case INT64:
                return Long.valueOf(zzh());
            case UINT64:
                return Long.valueOf(zzg());
            case INT32:
                return Integer.valueOf(zzi());
            case FIXED64:
                return Long.valueOf(zzj());
            case FIXED32:
                return Integer.valueOf(zzk());
            case BOOL:
                return Boolean.valueOf(zzl());
            case STRING:
                return zzn();
            case GROUP:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case MESSAGE:
                zzQ(2);
                return zzS(zzala.zza().zzb(cls), zzaizVar);
            case BYTES:
                return zzq();
            case UINT32:
                return Integer.valueOf(zzr());
            case ENUM:
                return Integer.valueOf(zzs());
            case SFIXED32:
                return Integer.valueOf(zzt());
            case SFIXED64:
                return Long.valueOf(zzu());
            case SINT32:
                return Integer.valueOf(zzv());
            case SINT64:
                return Long.valueOf(zzw());
        }
    }

    private final void zzV(int i) throws IOException {
        if (this.zza.zzG() != i) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final void zzW(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzakf("Failed to parse the message.");
        }
    }

    private static final void zzX(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzakf("Failed to parse the message.");
        }
    }

    public static zzaip zza(zzaio zzaioVar) {
        Object obj = zzaioVar.zzd;
        return obj != null ? (zzaip) obj : new zzaip(zzaioVar);
    }

    public final void zzA(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzakk) {
            zzakk zzakkVar = (zzakk) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzakkVar.zze(zzaioVar.zzg());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzakkVar.zze(zzaioVar2.zzg());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Long.valueOf(zzaioVar3.zzg()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Long.valueOf(zzaioVar4.zzg()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzB(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzajpVar.zzh(zzaioVar.zzh());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzh());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzh()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzh()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzC(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzakk) {
            zzakk zzakkVar = (zzakk) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzX(iZzp);
                int iZzG = iZzp + zzaioVar.zzG();
                do {
                    zzakkVar.zze(zzaioVar.zzi());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzakkVar.zze(zzaioVar2.zzi());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzX(iZzp2);
                int iZzG2 = iZzp2 + zzaioVar3.zzG();
                do {
                    list.add(Long.valueOf(zzaioVar3.zzi()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Long.valueOf(zzaioVar4.zzi()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzD(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzW(iZzp);
                int iZzG = zzaioVar.zzG() + iZzp;
                do {
                    zzajpVar.zzh(zzaioVar.zzj());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            if (i != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzj());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzW(iZzp2);
                int iZzG2 = zzaioVar3.zzG() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzj()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            if (i2 != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzj()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzE(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaib) {
            zzaib zzaibVar = (zzaib) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzaibVar.zzf(zzaioVar.zzk());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzaibVar.zzf(zzaioVar2.zzk());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Boolean.valueOf(zzaioVar3.zzk()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Boolean.valueOf(zzaioVar4.zzk()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzF(List list, boolean z) throws IOException {
        int iZza;
        int iZza2;
        if ((this.zzb & 7) != 2) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzakh) && !z) {
            zzakh zzakhVar = (zzakh) list;
            do {
                zzq();
                zzakhVar.zza();
                zzaio zzaioVar = this.zza;
                if (zzaioVar.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            do {
                list.add(z ? zzn() : zzm());
                zzaio zzaioVar2 = this.zza;
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar2.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzG(List list, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzS(zzaldVar, zzaizVar));
            zzaio zzaioVar = this.zza;
            if (zzaioVar.zzF() || this.zzd != 0) {
                return;
            } else {
                iZza = zzaioVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    @Deprecated
    public final void zzH(List list, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        int iZza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
        do {
            Object objZza = zzaldVar.zza();
            zzT(objZza, zzaldVar, zzaizVar);
            zzaldVar.zzk(objZza);
            list.add(objZza);
            zzaio zzaioVar = this.zza;
            if (zzaioVar.zzF() || this.zzd != 0) {
                return;
            } else {
                iZza = zzaioVar.zza();
            }
        } while (iZza == i);
        this.zzd = iZza;
    }

    public final void zzJ(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzajpVar.zzh(zzaioVar.zzp());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzp());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzp()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzp()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzK(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzajpVar.zzh(zzaioVar.zzq());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzq());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzq()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzq()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzL(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzW(iZzp);
                int iZzG = zzaioVar.zzG() + iZzp;
                do {
                    zzajpVar.zzh(zzaioVar.zzr());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            if (i != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzr());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzW(iZzp2);
                int iZzG2 = zzaioVar3.zzG() + iZzp2;
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzr()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            if (i2 != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzr()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzM(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzakk) {
            zzakk zzakkVar = (zzakk) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzX(iZzp);
                int iZzG = iZzp + zzaioVar.zzG();
                do {
                    zzakkVar.zze(zzaioVar.zzs());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzakkVar.zze(zzaioVar2.zzs());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzX(iZzp2);
                int iZzG2 = iZzp2 + zzaioVar3.zzG();
                do {
                    list.add(Long.valueOf(zzaioVar3.zzs()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Long.valueOf(zzaioVar4.zzs()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzN(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajp) {
            zzajp zzajpVar = (zzajp) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzajpVar.zzh(zzaioVar.zzt());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajpVar.zzh(zzaioVar2.zzt());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Integer.valueOf(zzaioVar3.zzt()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Integer.valueOf(zzaioVar4.zzt()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzO(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzakk) {
            zzakk zzakkVar = (zzakk) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzakkVar.zze(zzaioVar.zzu());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzakkVar.zze(zzaioVar2.zzu());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Long.valueOf(zzaioVar3.zzu()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Long.valueOf(zzaioVar4.zzu()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzP(Map map, zzakl zzaklVar, zzaiz zzaizVar) throws IOException {
        zzQ(2);
        zzaio zzaioVar = this.zza;
        int iZzC = zzaioVar.zzC(zzaioVar.zzp());
        Object objZzU = zzaklVar.zzb;
        Object obj = zzaklVar.zzd;
        Object objZzU2 = obj;
        while (true) {
            try {
                int iZzb = zzb();
                if (iZzb == Integer.MAX_VALUE || zzaioVar.zzF()) {
                    break;
                }
                if (iZzb == 1) {
                    objZzU = zzU(zzaklVar.zza, null, null);
                } else if (iZzb != 2) {
                    try {
                        if (!zzd()) {
                            throw new zzakf("Unable to parse map entry.");
                        }
                    } catch (zzake e) {
                        if (!zzd()) {
                            throw new zzakf("Unable to parse map entry.", e);
                        }
                    }
                } else {
                    objZzU2 = zzU(zzaklVar.zzc, obj.getClass(), zzaizVar);
                }
            } catch (Throwable th) {
                this.zza.zzD(iZzC);
                throw th;
            }
        }
        map.put(objZzU, objZzU2);
        zzaio zzaioVar2 = this.zza;
        if (zzaioVar2.zzE() != 0) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        zzaioVar2.zzD(iZzC);
    }

    public final int zzb() throws IOException {
        int iZza = this.zzd;
        if (iZza != 0) {
            this.zzb = iZza;
            this.zzd = 0;
        } else {
            iZza = this.zza.zza();
            this.zzb = iZza;
        }
        if (iZza == 0 || iZza == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZza >>> 3;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        zzaio zzaioVar = this.zza;
        if (zzaioVar.zzF() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzaioVar.zzc(i);
    }

    public final double zze() throws IOException {
        zzQ(1);
        return this.zza.zzd();
    }

    public final float zzf() throws IOException {
        zzQ(5);
        return this.zza.zze();
    }

    public final long zzg() throws IOException {
        zzQ(0);
        return this.zza.zzf();
    }

    public final long zzh() throws IOException {
        zzQ(0);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzQ(0);
        return this.zza.zzh();
    }

    public final long zzj() throws IOException {
        zzQ(1);
        return this.zza.zzi();
    }

    public final int zzk() throws IOException {
        zzQ(5);
        return this.zza.zzj();
    }

    public final boolean zzl() throws IOException {
        zzQ(0);
        return this.zza.zzk();
    }

    public final String zzm() throws IOException {
        zzQ(2);
        return this.zza.zzl();
    }

    public final String zzn() throws IOException {
        zzQ(2);
        return this.zza.zzm();
    }

    public final void zzo(Object obj, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        zzQ(2);
        zzR(obj, zzaldVar, zzaizVar);
    }

    public final void zzp(Object obj, zzald zzaldVar, zzaiz zzaizVar) throws IOException {
        zzQ(3);
        zzT(obj, zzaldVar, zzaizVar);
    }

    public final zzaik zzq() throws IOException {
        zzQ(2);
        return this.zza.zzn();
    }

    public final int zzr() throws IOException {
        zzQ(0);
        return this.zza.zzp();
    }

    public final int zzs() throws IOException {
        zzQ(0);
        return this.zza.zzq();
    }

    public final int zzt() throws IOException {
        zzQ(5);
        return this.zza.zzr();
    }

    public final long zzu() throws IOException {
        zzQ(1);
        return this.zza.zzs();
    }

    public final int zzv() throws IOException {
        zzQ(0);
        return this.zza.zzt();
    }

    public final long zzw() throws IOException {
        zzQ(0);
        return this.zza.zzu();
    }

    public final void zzx(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzaiw) {
            zzaiw zzaiwVar = (zzaiw) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzX(iZzp);
                int iZzG = iZzp + zzaioVar.zzG();
                do {
                    zzaiwVar.zzf(zzaioVar.zzd());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzaiwVar.zzf(zzaioVar2.zzd());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzX(iZzp2);
                int iZzG2 = iZzp2 + zzaioVar3.zzG();
                do {
                    list.add(Double.valueOf(zzaioVar3.zzd()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Double.valueOf(zzaioVar4.zzd()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzy(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzajg) {
            zzajg zzajgVar = (zzajg) list;
            int i = this.zzb & 7;
            if (i == 2) {
                zzaio zzaioVar = this.zza;
                int iZzp = zzaioVar.zzp();
                zzW(iZzp);
                int iZzG = zzaioVar.zzG() + iZzp;
                do {
                    zzajgVar.zzf(zzaioVar.zze());
                } while (zzaioVar.zzG() < iZzG);
                return;
            }
            if (i != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzajgVar.zzf(zzaioVar2.zze());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzaio zzaioVar3 = this.zza;
                int iZzp2 = zzaioVar3.zzp();
                zzW(iZzp2);
                int iZzG2 = zzaioVar3.zzG() + iZzp2;
                do {
                    list.add(Float.valueOf(zzaioVar3.zze()));
                } while (zzaioVar3.zzG() < iZzG2);
                return;
            }
            if (i2 != 5) {
                throw new zzake("Protocol message tag had invalid wire type.");
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Float.valueOf(zzaioVar4.zze()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzz(List list) throws IOException {
        int iZza;
        int iZza2;
        if (list instanceof zzakk) {
            zzakk zzakkVar = (zzakk) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar = this.zza;
                int iZzG = zzaioVar.zzG() + zzaioVar.zzp();
                do {
                    zzakkVar.zze(zzaioVar.zzf());
                } while (zzaioVar.zzG() < iZzG);
                zzV(iZzG);
                return;
            }
            do {
                zzaio zzaioVar2 = this.zza;
                zzakkVar.zze(zzaioVar2.zzf());
                if (zzaioVar2.zzF()) {
                    return;
                } else {
                    iZza2 = zzaioVar2.zza();
                }
            } while (iZza2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzake("Protocol message tag had invalid wire type.");
                }
                zzaio zzaioVar3 = this.zza;
                int iZzG2 = zzaioVar3.zzG() + zzaioVar3.zzp();
                do {
                    list.add(Long.valueOf(zzaioVar3.zzf()));
                } while (zzaioVar3.zzG() < iZzG2);
                zzV(iZzG2);
                return;
            }
            do {
                zzaio zzaioVar4 = this.zza;
                list.add(Long.valueOf(zzaioVar4.zzf()));
                if (zzaioVar4.zzF()) {
                    return;
                } else {
                    iZza = zzaioVar4.zza();
                }
            } while (iZza == this.zzb);
            iZza2 = iZza;
        }
        this.zzd = iZza2;
    }

    public final void zzI(List list) throws IOException {
        int iZza;
        if ((this.zzb & 7) != 2) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzq());
            zzaio zzaioVar = this.zza;
            if (zzaioVar.zzF()) {
                return;
            } else {
                iZza = zzaioVar.zza();
            }
        } while (iZza == this.zzb);
        this.zzd = iZza;
    }
}
