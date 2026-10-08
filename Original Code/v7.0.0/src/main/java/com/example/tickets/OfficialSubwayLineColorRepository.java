package com.example.tickets;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OfficialSubwayLineColorRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J)\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/tickets/OfficialSubwayLineColorRepository;", "", "<init>", "()V", "color", "Lcom/example/tickets/OfficialSubwayLineColorRepository$OfficialColor;", "hex", "", "sourceName", "sourceUrl", "nyc", "", "colorFor", "", "cityId", "shortName", "routeId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "metadataFor", "normalize", "value", "OfficialColor", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfficialSubwayLineColorRepository {
    public static final int $stable;
    public static final OfficialSubwayLineColorRepository INSTANCE;
    private static final Map<String, OfficialColor> nyc;

    private OfficialSubwayLineColorRepository() {
    }

    /* JADX INFO: compiled from: OfficialSubwayLineColorRepository.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/example/tickets/OfficialSubwayLineColorRepository$OfficialColor;", "", "argb", "", "sourceName", "", "sourceUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getArgb", "()I", "getSourceName", "()Ljava/lang/String;", "getSourceUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OfficialColor {
        public static final int $stable = 0;
        private final int argb;
        private final String sourceName;
        private final String sourceUrl;

        public static /* synthetic */ OfficialColor copy$default(OfficialColor officialColor, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = officialColor.argb;
            }
            if ((i2 & 2) != 0) {
                str = officialColor.sourceName;
            }
            if ((i2 & 4) != 0) {
                str2 = officialColor.sourceUrl;
            }
            return officialColor.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getArgb() {
            return this.argb;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSourceName() {
            return this.sourceName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        public final OfficialColor copy(int argb, String sourceName, String sourceUrl) {
            Intrinsics.checkNotNullParameter(sourceName, "sourceName");
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            return new OfficialColor(argb, sourceName, sourceUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfficialColor)) {
                return false;
            }
            OfficialColor officialColor = (OfficialColor) other;
            return this.argb == officialColor.argb && Intrinsics.areEqual(this.sourceName, officialColor.sourceName) && Intrinsics.areEqual(this.sourceUrl, officialColor.sourceUrl);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.argb) * 31) + this.sourceName.hashCode()) * 31) + this.sourceUrl.hashCode();
        }

        public String toString() {
            return "OfficialColor(argb=" + this.argb + ", sourceName=" + this.sourceName + ", sourceUrl=" + this.sourceUrl + ")";
        }

        public OfficialColor(int i, String sourceName, String sourceUrl) {
            Intrinsics.checkNotNullParameter(sourceName, "sourceName");
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            this.argb = i;
            this.sourceName = sourceName;
            this.sourceUrl = sourceUrl;
        }

        public final int getArgb() {
            return this.argb;
        }

        public final String getSourceName() {
            return this.sourceName;
        }

        public final String getSourceUrl() {
            return this.sourceUrl;
        }
    }

    private final OfficialColor color(String hex, String sourceName, String sourceUrl) {
        return new OfficialColor((int) (Long.parseLong(StringsKt.removePrefix(hex, (CharSequence) "#"), CharsKt.checkRadix(16)) | 4278190080L), sourceName, sourceUrl);
    }

    static {
        OfficialSubwayLineColorRepository officialSubwayLineColorRepository = new OfficialSubwayLineColorRepository();
        INSTANCE = officialSubwayLineColorRepository;
        nyc = MapsKt.mapOf(TuplesKt.to("1", officialSubwayLineColorRepository.color("#D82233", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to(ExifInterface.GPS_MEASUREMENT_2D, officialSubwayLineColorRepository.color("#D82233", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to(ExifInterface.GPS_MEASUREMENT_3D, officialSubwayLineColorRepository.color("#D82233", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("4", officialSubwayLineColorRepository.color("#009952", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("5", officialSubwayLineColorRepository.color("#009952", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("6", officialSubwayLineColorRepository.color("#009952", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("7", officialSubwayLineColorRepository.color("#9A38A1", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("a", officialSubwayLineColorRepository.color("#0062CF", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("c", officialSubwayLineColorRepository.color("#0062CF", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("e", officialSubwayLineColorRepository.color("#0062CF", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("b", officialSubwayLineColorRepository.color("#EB6800", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("d", officialSubwayLineColorRepository.color("#EB6800", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("f", officialSubwayLineColorRepository.color("#EB6800", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("m", officialSubwayLineColorRepository.color("#EB6800", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("g", officialSubwayLineColorRepository.color("#799534", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("j", officialSubwayLineColorRepository.color("#8E5C33", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("z", officialSubwayLineColorRepository.color("#8E5C33", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("l", officialSubwayLineColorRepository.color("#7C858C", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("n", officialSubwayLineColorRepository.color("#F6BC26", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("q", officialSubwayLineColorRepository.color("#F6BC26", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("r", officialSubwayLineColorRepository.color("#F6BC26", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("w", officialSubwayLineColorRepository.color("#F6BC26", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("s", officialSubwayLineColorRepository.color("#7C858C", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")), TuplesKt.to("sir", officialSubwayLineColorRepository.color("#08179C", "MTA Brand Colors / Subway, SIR & ADA", "https://www.mta.info/document/168976")));
        $stable = 8;
    }

    public static /* synthetic */ Integer colorFor$default(OfficialSubwayLineColorRepository officialSubwayLineColorRepository, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return officialSubwayLineColorRepository.colorFor(str, str2, str3);
    }

    public final Integer colorFor(String cityId, String shortName, String routeId) {
        OfficialColor officialColor;
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        String strNormalize = normalize(shortName);
        String lowerCase = cityId.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase, "nyc") || (officialColor = nyc.get(strNormalize)) == null) {
            return null;
        }
        return Integer.valueOf(officialColor.getArgb());
    }

    public static /* synthetic */ OfficialColor metadataFor$default(OfficialSubwayLineColorRepository officialSubwayLineColorRepository, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return officialSubwayLineColorRepository.metadataFor(str, str2, str3);
    }

    public final OfficialColor metadataFor(String cityId, String shortName, String routeId) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        String strNormalize = normalize(shortName);
        String lowerCase = cityId.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "nyc")) {
            return nyc.get(strNormalize);
        }
        return null;
    }

    private final String normalize(String value) {
        String lowerCase = new Regex("\\s+").replace(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((CharSequence) value).toString(), (CharSequence) "号线"), (CharSequence) "Line"), "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
