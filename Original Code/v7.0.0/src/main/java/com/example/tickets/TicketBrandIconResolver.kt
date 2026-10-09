package com.example.tickets;

import android.content.Context;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketBrandIconResolver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001d\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/tickets/TicketBrandIconResolver;", "", "<init>", "()V", "aliases", "", "", "normalize", "value", "resolveBrandNotificationRes", "", "context", "Landroid/content/Context;", "brand", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "drawableForBrand", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketBrandIconResolver {
    public static final TicketBrandIconResolver INSTANCE = new TicketBrandIconResolver();
    private static final Map<String, String> aliases = MapsKt.mapOf(TuplesKt.to("dq", "ic_brand_dq"), TuplesKt.to("dairyqueen", "ic_brand_dq"), TuplesKt.to("dairy queen", "ic_brand_dq"), TuplesKt.to("冰雪皇后", "ic_brand_dq"), TuplesKt.to("pizzahut", "ic_brand_pizzahut"), TuplesKt.to("pizza hut", "ic_brand_pizzahut"), TuplesKt.to("必胜客", "ic_brand_pizzahut"), TuplesKt.to("burgerking", "ic_brand_burgerking"), TuplesKt.to("burger king", "ic_brand_burgerking"), TuplesKt.to("汉堡王", "ic_brand_burgerking"), TuplesKt.to("mcdonalds", "ic_brand_mcdonalds"), TuplesKt.to("mcdonald", "ic_brand_mcdonalds"), TuplesKt.to("mcd", "ic_brand_mcdonalds"), TuplesKt.to("麦当劳", "ic_brand_mcdonalds"), TuplesKt.to("金拱门", "ic_brand_mcdonalds"), TuplesKt.to("dominos", "ic_brand_dominos"), TuplesKt.to("domino", "ic_brand_dominos"), TuplesKt.to("domino's", "ic_brand_dominos"), TuplesKt.to("达美乐", "ic_brand_dominos"), TuplesKt.to("达美乐披萨", "ic_brand_dominos"), TuplesKt.to("starbucks", "ic_brand_starbucks"), TuplesKt.to("星巴克", "ic_brand_starbucks"), TuplesKt.to("煌上煌", "ic_brand_huangshanghuang"), TuplesKt.to("huangshanghuang", "ic_brand_huangshanghuang"), TuplesKt.to("古茗", "ic_brand_guming"), TuplesKt.to("guming", "ic_brand_guming"), TuplesKt.to("coco", "ic_brand_coco"), TuplesKt.to("coco都可", "ic_brand_coco"), TuplesKt.to("都可", "ic_brand_coco"), TuplesKt.to("蜜雪冰城", "ic_brand_mixue"), TuplesKt.to("蜜雪", "ic_brand_mixue"), TuplesKt.to("mixue", "ic_brand_mixue"), TuplesKt.to("益禾堂", "ic_brand_yihetang"), TuplesKt.to("yihetang", "ic_brand_yihetang"), TuplesKt.to("书亦烧仙草", "ic_brand_shuyi"), TuplesKt.to("书亦", "ic_brand_shuyi"), TuplesKt.to("shuyi", "ic_brand_shuyi"), TuplesKt.to("shuyishaoxiancao", "ic_brand_shuyi"), TuplesKt.to("奈雪的茶", "ic_brand_naixue"), TuplesKt.to("奈雪", "ic_brand_naixue"), TuplesKt.to("naixue", "ic_brand_naixue"), TuplesKt.to("沪上阿姨", "ic_brand_hushang_ayi"), TuplesKt.to("hushangayi", "ic_brand_hushang_ayi"), TuplesKt.to("茶颜悦色", "ic_brand_chayan_yuese"), TuplesKt.to("茶颜", "ic_brand_chayan_yuese"), TuplesKt.to("chayan", "ic_brand_chayan_yuese"), TuplesKt.to("一点点", "ic_brand_yidiandian"), TuplesKt.to("1点点", "ic_brand_yidiandian"), TuplesKt.to("yidiandian", "ic_brand_yidiandian"), TuplesKt.to("timhortons", "ic_brand_tim_hortons"), TuplesKt.to("tim hortons", "ic_brand_tim_hortons"), TuplesKt.to("tim", "ic_brand_tim_hortons"), TuplesKt.to("tims", "ic_brand_tim_hortons"), TuplesKt.to("tims咖啡", "ic_brand_tim_hortons"), TuplesKt.to("mstand", "ic_brand_mstand"), TuplesKt.to("m stand", "ic_brand_mstand"), TuplesKt.to("mstand咖啡", "ic_brand_mstand"), TuplesKt.to("manner", "ic_brand_manner"), TuplesKt.to("mannercoffee", "ic_brand_manner"), TuplesKt.to("manner咖啡", "ic_brand_manner"), TuplesKt.to("costa", "ic_brand_costa"), TuplesKt.to("costa coffee", "ic_brand_costa"), TuplesKt.to("costa咖啡", "ic_brand_costa"), TuplesKt.to("瑞幸", "ic_brand_ruixing"), TuplesKt.to("瑞幸咖啡", "ic_brand_ruixing"), TuplesKt.to("luckin", "ic_brand_ruixing"), TuplesKt.to("luckin coffee", "ic_brand_ruixing"), TuplesKt.to("luckincoffee", "ic_brand_ruixing"), TuplesKt.to("喜茶", "ic_brand_xicha"), TuplesKt.to("xicha", "ic_brand_xicha"), TuplesKt.to("heytea", "ic_brand_xicha"), TuplesKt.to("hey tea", "ic_brand_xicha"), TuplesKt.to("kfc", "ic_brand_kfc"), TuplesKt.to("肯德基", "ic_brand_kfc"), TuplesKt.to("鹿角巷", "ic_brand_the_alley"), TuplesKt.to("thealley", "ic_brand_the_alley"), TuplesKt.to("the alley", "ic_brand_the_alley"), TuplesKt.to("seesaw", "ic_brand_seesaw"), TuplesKt.to("seesaw coffee", "ic_brand_seesaw"), TuplesKt.to("seesaw咖啡", "ic_brand_seesaw"), TuplesKt.to("nowwa", "ic_brand_nowwa"), TuplesKt.to("挪瓦", "ic_brand_nowwa"), TuplesKt.to("挪瓦咖啡", "ic_brand_nowwa"));
    public static final int $stable = 8;

    private TicketBrandIconResolver() {
    }

    private final String normalize(String value) {
        String lowerCase = StringsKt.trim((CharSequence) value).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, " ", "", false, 4, (Object) null), "\u3000", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), "_", "", false, 4, (Object) null), "'", "", false, 4, (Object) null), "’", "", false, 4, (Object) null), "．", ".", false, 4, (Object) null), "·", "", false, 4, (Object) null), "/", "", false, 4, (Object) null), "\\", "", false, 4, (Object) null);
    }

    public final Integer resolveBrandNotificationRes(Context context, String brand) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brand, "brand");
        return drawableForBrand(context, brand);
    }

    public final Integer drawableForBrand(Context context, String brand) {
        Object next;
        String strNormalize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brand, "brand");
        String strNormalize2 = normalize(brand);
        String str = strNormalize2;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        Map<String, String> map = aliases;
        String str2 = map.get(strNormalize2);
        if (str2 == null) {
            Iterator<T> it = map.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                strNormalize = INSTANCE.normalize((String) ((Map.Entry) next).getKey());
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) strNormalize, false, 2, (Object) null)) {
                    break;
                }
            } while (!StringsKt.contains$default((CharSequence) strNormalize, (CharSequence) str, false, 2, (Object) null));
            Map.Entry entry = (Map.Entry) next;
            str2 = entry != null ? (String) entry.getValue() : null;
            if (str2 == null) {
                return null;
            }
        }
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier(str2, "drawable", context.getPackageName()));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }
}
