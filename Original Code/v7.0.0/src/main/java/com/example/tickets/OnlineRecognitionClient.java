package com.example.tickets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.ServiceStarter;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OnlineRecognitionClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018J=\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018J(\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J(\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J(\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J(\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J(\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J(\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J4\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0012\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u0005H\u0002J\u0018\u00105\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u00106\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/example/tickets/OnlineRecognitionClient;", "", "<init>", "()V", "ZHIPU_ENDPOINT", "", "OPENAI_ENDPOINT", "GEMINI_ENDPOINT", "CLAUDE_ENDPOINT", "DEEPSEEK_ENDPOINT", "KIMI_ENDPOINT", "MIMO_ENDPOINT", "CONNECT_TIMEOUT_MS", "", "READ_TIMEOUT_MS", "recognizeTicket", "Lcom/example/tickets/OnlineRecognitionResult;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "apiKey", "model", "customPrompt", "recognizeTicket$app", "provider", "callZhipu", "systemPrompt", "imageDataUrl", "callOpenAi", "callGemini", "imageBase64", "callClaude", "callMiMo", "callDeepSeek", "callKimi", "postJson", "endpoint", "headers", "", "body", "Lorg/json/JSONObject;", "errorPrefix", "buildPrompt", "modelApiId", "parseProviderResponse", "responseText", "extractContent", "value", "extractJsonObject", "text", "mapType", "Lcom/example/tickets/TicketType;", "loadImageAsDataUrl", "renderFirstPdfPage", "Landroid/graphics/Bitmap;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnlineRecognitionClient {
    public static final int $stable = 0;
    private static final String CLAUDE_ENDPOINT = "https://api.anthropic.com/v1/messages";
    private static final int CONNECT_TIMEOUT_MS = 20000;
    private static final String DEEPSEEK_ENDPOINT = "https://api.deepseek.com/chat/completions";
    private static final String GEMINI_ENDPOINT = "https://generativelanguage.googleapis.com/v1beta/models/%s:generateContent?key=%s";
    public static final OnlineRecognitionClient INSTANCE = new OnlineRecognitionClient();
    private static final String KIMI_ENDPOINT = "https://api.moonshot.cn/v1/chat/completions";
    private static final String MIMO_ENDPOINT = "https://api.xiaomimimo.com/v1/chat/completions";
    private static final String OPENAI_ENDPOINT = "https://api.openai.com/v1/responses";
    private static final int READ_TIMEOUT_MS = 60000;
    private static final String ZHIPU_ENDPOINT = "https://open.bigmodel.cn/api/paas/v4/chat/completions";

    private OnlineRecognitionClient() {
    }

    public final OnlineRecognitionResult recognizeTicket$app(Context context, Uri uri, String apiKey, String model, String customPrompt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(customPrompt, "customPrompt");
        return recognizeTicket$app(context, uri, "智谱开放平台", apiKey, model, customPrompt);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x00ac  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final OnlineRecognitionResult recognizeTicket$app(Context context, Uri uri, String provider, String apiKey, String model, String customPrompt) throws JSONException, IOException {
        String strCallZhipu;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(customPrompt, "customPrompt");
        if (StringsKt.isBlank(apiKey)) {
            throw new IllegalArgumentException("请先填写 API Key。".toString());
        }
        if (StringsKt.isBlank(model)) {
            throw new IllegalArgumentException("请先选择模型。".toString());
        }
        String strLoadImageAsDataUrl = loadImageAsDataUrl(context, uri);
        String strSubstringAfter = StringsKt.substringAfter(strLoadImageAsDataUrl, ",", strLoadImageAsDataUrl);
        String strBuildPrompt = buildPrompt(customPrompt);
        switch (provider.hashCode()) {
            case -1926713326:
                if (provider.equals("OpenAI")) {
                    strCallZhipu = callOpenAi(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            case -246582110:
                if (provider.equals("小米MiMO")) {
                    strCallZhipu = callMiMo(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            case -127471796:
                if (provider.equals("Anthropic")) {
                    strCallZhipu = callClaude(apiKey, model, strBuildPrompt, strSubstringAfter);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            case 2338714:
                if (provider.equals("Kimi")) {
                    strCallZhipu = callKimi(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            case 2398327:
                if (provider.equals("Mini")) {
                    throw new IllegalStateException("Mini 当前的可用 API 模型不支持直接上传图片，暂不能用于票据图片识别。");
                }
                strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                return parseProviderResponse(strCallZhipu, provider);
            case 693128612:
                if (provider.equals("DeepSeek")) {
                    strCallZhipu = callDeepSeek(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            case 2129296981:
                if (provider.equals("Gemini")) {
                    strCallZhipu = callGemini(apiKey, model, strBuildPrompt, strSubstringAfter);
                } else {
                    strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                }
                return parseProviderResponse(strCallZhipu, provider);
            default:
                strCallZhipu = callZhipu(apiKey, model, strBuildPrompt, strLoadImageAsDataUrl);
                return parseProviderResponse(strCallZhipu, provider);
        }
    }

    private final String callZhipu(String apiKey, String model, String systemPrompt, String imageDataUrl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", model);
        jSONObject.put("temperature", 0);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("role", "system");
        jSONObject2.put("content", systemPrompt);
        jSONArray.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "image_url");
        jSONObject4.put("image_url", new JSONObject().put(ImagesContract.URL, imageDataUrl));
        jSONArray2.put(jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "text");
        jSONObject5.put("text", "请识别这张票据图片，并严格按照系统要求返回 JSON。");
        jSONArray2.put(jSONObject5);
        Unit unit = Unit.INSTANCE;
        jSONObject3.put("content", jSONArray2);
        jSONArray.put(jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("messages", jSONArray);
        return postJson(ZHIPU_ENDPOINT, MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + apiKey)), jSONObject, "智谱识别失败");
    }

    private final String callOpenAi(String apiKey, String model, String systemPrompt, String imageDataUrl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", model);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "input_text");
        jSONObject3.put("text", systemPrompt + "\n\n请识别这张票据图片，并严格按照系统要求返回 JSON。");
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "input_image");
        jSONObject4.put("image_url", imageDataUrl);
        jSONObject4.put("detail", "high");
        jSONArray2.put(jSONObject4);
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("content", jSONArray2);
        jSONArray.put(jSONObject2);
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("input", jSONArray);
        return postJson(OPENAI_ENDPOINT, MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + apiKey)), jSONObject, "OpenAI 识别失败");
    }

    private final String callGemini(String apiKey, String model, String systemPrompt, String imageBase64) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new JSONObject().put("text", systemPrompt + "\n\n请识别这张票据图片，并严格按照系统要求返回 JSON。"));
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("mime_type", "image/jpeg");
        jSONObject4.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, imageBase64);
        Unit unit = Unit.INSTANCE;
        jSONObject3.put("inline_data", jSONObject4);
        jSONArray2.put(jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObject2.put("parts", jSONArray2);
        jSONArray.put(jSONObject2);
        Unit unit3 = Unit.INSTANCE;
        jSONObject.put("contents", jSONArray);
        jSONObject.put("generationConfig", new JSONObject().put("temperature", 0));
        String str = String.format(GEMINI_ENDPOINT, Arrays.copyOf(new Object[]{modelApiId(model), URLEncoder.encode(apiKey, "UTF-8")}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return postJson(str, MapsKt.emptyMap(), jSONObject, "Gemini 识别失败");
    }

    private final String callClaude(String apiKey, String model, String systemPrompt, String imageBase64) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", model);
        jSONObject.put("max_tokens", 4096);
        jSONObject.put("temperature", 0);
        jSONObject.put("system", systemPrompt);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "image");
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "base64");
        jSONObject4.put("media_type", "image/jpeg");
        jSONObject4.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, imageBase64);
        Unit unit = Unit.INSTANCE;
        jSONObject3.put(Constants.ScionAnalytics.PARAM_SOURCE, jSONObject4);
        jSONArray2.put(jSONObject3);
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "text").put("text", "请识别这张票据图片，并严格按照系统要求返回 JSON。"));
        Unit unit2 = Unit.INSTANCE;
        jSONObject2.put("content", jSONArray2);
        jSONArray.put(jSONObject2);
        Unit unit3 = Unit.INSTANCE;
        jSONObject.put("messages", jSONArray);
        return postJson(CLAUDE_ENDPOINT, MapsKt.mapOf(TuplesKt.to("x-api-key", apiKey), TuplesKt.to("anthropic-version", "2023-06-01")), jSONObject, "Claude 识别失败");
    }

    private final String callMiMo(String apiKey, String model, String systemPrompt, String imageDataUrl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", INSTANCE.modelApiId(model));
        jSONObject.put("temperature", 0);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("role", "system");
        jSONObject2.put("content", systemPrompt);
        jSONArray.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "text").put("text", "请识别这张票据图片，并严格按照系统要求返回 JSON。"));
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "image_url").put("image_url", new JSONObject().put(ImagesContract.URL, imageDataUrl)));
        Unit unit = Unit.INSTANCE;
        jSONObject3.put("content", jSONArray2);
        jSONArray.put(jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("messages", jSONArray);
        return postJson(MIMO_ENDPOINT, MapsKt.mapOf(TuplesKt.to("api-key", apiKey)), jSONObject, "小米MiMO 识别失败");
    }

    private final String callDeepSeek(String apiKey, String model, String systemPrompt, String imageDataUrl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", model);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectPut = new JSONObject().put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "text").put("text", systemPrompt + "\n\n请识别这张票据图片，并严格按照要求返回 JSON。"));
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "image_url").put("image_url", new JSONObject().put(ImagesContract.URL, imageDataUrl)));
        Unit unit = Unit.INSTANCE;
        jSONArray.put(jSONObjectPut.put("content", jSONArray2));
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("messages", jSONArray);
        jSONObject.put("temperature", 0);
        return postJson(DEEPSEEK_ENDPOINT, MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + apiKey)), jSONObject, "DeepSeek 识别失败");
    }

    private final String callKimi(String apiKey, String model, String systemPrompt, String imageDataUrl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", model);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(new JSONObject().put("role", "system").put("content", systemPrompt));
        JSONObject jSONObjectPut = new JSONObject().put("role", "user");
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "image_url").put("image_url", new JSONObject().put(ImagesContract.URL, imageDataUrl)));
        jSONArray2.put(new JSONObject().put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "text").put("text", "请识别这张票据图片，并严格按照要求返回 JSON。"));
        Unit unit = Unit.INSTANCE;
        jSONArray.put(jSONObjectPut.put("content", jSONArray2));
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("messages", jSONArray);
        return postJson(KIMI_ENDPOINT, MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + apiKey)), jSONObject, "Kimi 识别失败");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f4  */
    private final String postJson(String endpoint, Map<String, String> headers, JSONObject body, String errorPrefix) throws IOException {
        String text;
        URLConnection uRLConnectionOpenConnection = new URL(endpoint).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(READ_TIMEOUT_MS);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                String string = body.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                outputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                int responseCode = httpURLConnection.getResponseCode();
                if (200 <= responseCode && responseCode < 300) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String text2 = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        httpURLConnection.disconnect();
                        return text2;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader, th);
                            throw th2;
                        }
                    }
                }
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream != null) {
                    Reader inputStreamReader2 = new InputStreamReader(errorStream, Charsets.UTF_8);
                    BufferedReader bufferedReader2 = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                    try {
                        text = TextStreamsKt.readText(bufferedReader2);
                        CloseableKt.closeFinally(bufferedReader2, null);
                        if (text == null) {
                            text = "";
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(bufferedReader2, th3);
                            throw th4;
                        }
                    }
                } else {
                    text = "";
                }
                throw new IllegalStateException(errorPrefix + "（HTTP " + responseCode + "）" + StringsKt.take(text, ServiceStarter.ERROR_UNKNOWN));
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(outputStream, th5);
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            httpURLConnection.disconnect();
            throw th7;
        }
        httpURLConnection.disconnect();
        throw th7;
    }

    private final String buildPrompt(String customPrompt) {
        String str = customPrompt;
        return StringsKt.isBlank(str) ? "你是“票据”的票据录入助手。请识别图片中所有独立票券，只返回 JSON，不要 Markdown 和解释。\n\n根格式必须是 {\"orders\":[...]}。type 只能是：电影票、火车票、飞机票、演出现场、核销券、取餐码、取件码。\n看不清的字段返回 null，不得猜测。价格只返回人民币数字，不要“¥”或“元”。日期优先使用 YYYY年M月D日，时间使用 HH:mm。\n如果能明确读取二维码原始内容，可在对应订单中返回 qrPayload；无法读取时返回 null。应用也会在本地解码二维码。\n\n各类允许字段：\n- 电影票：type, movieName, cinema, auditorium, seat, date, startTime, endTime, priceCny\n- 火车票：type, trainNumber, origin, destination, date, departureTime, arrivalTime, priceCny, seat\n- 飞机票：type, flightNumber, origin, destination, date, departureTime, arrivalTime, priceCny, seat, boardingGate\n- 演出现场：type, eventName, date, startTime, endTime, venue, seat, priceCny\n- 核销券：type, productName, brand, store, priceCny\n- 取餐码：type, pickupCode, brand, store, priceCny, productName\n- 取件码：type, pickupCode, carrier, store, priceCny, productName\n\n一张图有多张票时，在 orders 中分别返回，不得合并。" : StringsKt.trim((CharSequence) str).toString();
    }

    private final String modelApiId(String model) {
        if (StringsKt.equals(model, "Gemini-3.8-Flash", true)) {
            return "gemini-3.8-flash";
        }
        if (StringsKt.equals(model, "Gemini-3.7-Flash", true)) {
            return "gemini-3.7-flash";
        }
        if (StringsKt.equals(model, "Gemini-3.6-Flash", true)) {
            return "gemini-3.6-flash";
        }
        if (StringsKt.equals(model, "Gemini-3.5-Flash", true)) {
            return "gemini-3.5-flash";
        }
        if (StringsKt.equals(model, "Gemini-3.5-Flash-Lite", true)) {
            return "gemini-3.5-flash-lite";
        }
        if (StringsKt.equals(model, "DeepSeek-V4-Flash-Vision-Exp", true)) {
            return "deepseek-v4-flash-vision-exp";
        }
        if (StringsKt.equals(model, "Kimi-K2.6", true)) {
            return "kimi-k2.6";
        }
        return StringsKt.equals(model, "MiMo-V2.5-Omni", true) ? "mimo-v2.5-omni" : model;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fc  */
    private final OnlineRecognitionResult parseProviderResponse(String responseText, String provider) {
        String string;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String strOptString;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONArray jSONArrayOptJSONArray3;
        int iHashCode = provider.hashCode();
        if (iHashCode != -1926713326) {
            if (iHashCode != -127471796) {
                if (iHashCode == 2129296981 && provider.equals("Gemini")) {
                    JSONArray jSONArrayOptJSONArray4 = new JSONObject(responseText).optJSONArray("candidates");
                    if (jSONArrayOptJSONArray4 == null) {
                        throw new IllegalStateException("Gemini 没有返回 candidates。");
                    }
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(0);
                    if (jSONObjectOptJSONObject5 == null || (jSONObjectOptJSONObject4 = jSONObjectOptJSONObject5.optJSONObject("content")) == null || (jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("parts")) == null) {
                        throw new IllegalStateException("Gemini 返回格式异常。");
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = jSONArrayOptJSONArray3.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i);
                        String strOptString2 = jSONObjectOptJSONObject6 != null ? jSONObjectOptJSONObject6.optString("text") : null;
                        if (strOptString2 == null) {
                            strOptString2 = "";
                        }
                        sb.append(strOptString2);
                    }
                    string = sb.toString();
                } else {
                    jSONArrayOptJSONArray2 = new JSONObject(responseText).optJSONArray("choices");
                    if (jSONArrayOptJSONArray2 == null) {
                        throw new IllegalStateException("模型没有返回 choices。");
                    }
                    jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(0);
                    if (jSONObjectOptJSONObject != null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("message")) == null) {
                        throw new IllegalStateException("模型返回格式异常。");
                    }
                    string = extractContent(jSONObjectOptJSONObject2.opt("content"));
                }
            } else if (provider.equals("Anthropic")) {
                JSONArray jSONArrayOptJSONArray5 = new JSONObject(responseText).optJSONArray("content");
                if (jSONArrayOptJSONArray5 == null) {
                    throw new IllegalStateException("Claude 没有返回 content。");
                }
                StringBuilder sb2 = new StringBuilder();
                int length2 = jSONArrayOptJSONArray5.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray5.optJSONObject(i2);
                    String strOptString3 = jSONObjectOptJSONObject7 != null ? jSONObjectOptJSONObject7.optString("text") : null;
                    if (strOptString3 == null) {
                        strOptString3 = "";
                    }
                    sb2.append(strOptString3);
                }
                string = sb2.toString();
            } else {
                jSONArrayOptJSONArray2 = new JSONObject(responseText).optJSONArray("choices");
                if (jSONArrayOptJSONArray2 == null) {
                    throw new IllegalStateException("模型没有返回 choices。");
                }
                jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(0);
                if (jSONObjectOptJSONObject != null) {
                }
                throw new IllegalStateException("模型返回格式异常。");
            }
        } else if (provider.equals("OpenAI")) {
            JSONArray jSONArrayOptJSONArray6 = new JSONObject(responseText).optJSONArray("output");
            if (jSONArrayOptJSONArray6 == null) {
                throw new IllegalStateException("OpenAI 没有返回有效 output。");
            }
            StringBuilder sb3 = new StringBuilder();
            int length3 = jSONArrayOptJSONArray6.length();
            for (int i3 = 0; i3 < length3; i3++) {
                JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray6.optJSONObject(i3);
                if (jSONObjectOptJSONObject8 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject8.optJSONArray("content")) != null) {
                    int length4 = jSONArrayOptJSONArray.length();
                    for (int i4 = 0; i4 < length4; i4++) {
                        JSONObject jSONObjectOptJSONObject9 = jSONArrayOptJSONArray.optJSONObject(i4);
                        String strOptString4 = jSONObjectOptJSONObject9 != null ? jSONObjectOptJSONObject9.optString("text") : null;
                        if (strOptString4 == null) {
                            strOptString4 = "";
                        }
                        sb3.append(strOptString4);
                    }
                }
            }
            string = sb3.toString();
        } else {
            jSONArrayOptJSONArray2 = new JSONObject(responseText).optJSONArray("choices");
            if (jSONArrayOptJSONArray2 == null) {
                throw new IllegalStateException("模型没有返回 choices。");
            }
            jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(0);
            if (jSONObjectOptJSONObject != null) {
            }
            throw new IllegalStateException("模型返回格式异常。");
        }
        JSONObject jSONObject = new JSONObject(extractJsonObject(string));
        JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("orders");
        if (jSONArrayOptJSONArray7 != null && (jSONObjectOptJSONObject3 = jSONArrayOptJSONArray7.optJSONObject(0)) != null) {
            jSONObject = jSONObjectOptJSONObject3;
        }
        String strOptString5 = jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (jSONObject.has("movieName")) {
            strOptString = jSONObject.optString("movieName");
        } else if (jSONObject.has("eventName")) {
            strOptString = jSONObject.optString("eventName");
        } else if (jSONObject.has("productName")) {
            strOptString = jSONObject.optString("productName");
        } else {
            strOptString = jSONObject.optString("title");
        }
        String strOptString6 = jSONObject.optString("pickupCode");
        if (StringsKt.isBlank(strOptString6)) {
            strOptString6 = jSONObject.optString("code");
        }
        String str = strOptString6;
        String strOptString7 = jSONObject.optString("date");
        String strOptString8 = jSONObject.optString("departureTime");
        String strOptString9 = jSONObject.optString("arrivalTime");
        Intrinsics.checkNotNull(strOptString5);
        TicketType ticketTypeMapType = mapType(strOptString5);
        Intrinsics.checkNotNull(strOptString);
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(strOptString7);
        String strOptString10 = jSONObject.optString("startTime");
        if (StringsKt.isBlank(strOptString10)) {
            strOptString10 = strOptString8;
        }
        Intrinsics.checkNotNullExpressionValue(strOptString10, "ifBlank(...)");
        String str2 = strOptString10;
        String strOptString11 = jSONObject.optString("origin");
        Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
        String strOptString12 = jSONObject.optString("destination");
        Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
        String strOptString13 = jSONObject.optString("departurePlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
        String strOptString14 = jSONObject.optString("arrivalPlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
        String strOptString15 = jSONObject.optString("boardingGate");
        Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
        String strOptString16 = jSONObject.optString("venue");
        if (StringsKt.isBlank(strOptString16)) {
            strOptString16 = jSONObject.optString("store");
        }
        Intrinsics.checkNotNullExpressionValue(strOptString16, "ifBlank(...)");
        String str3 = strOptString16;
        String strOptString17 = jSONObject.optString("auditorium");
        Intrinsics.checkNotNullExpressionValue(strOptString17, "optString(...)");
        String strOptString18 = jSONObject.optString("seat");
        Intrinsics.checkNotNullExpressionValue(strOptString18, "optString(...)");
        String strOptString19 = jSONObject.optString("area");
        Intrinsics.checkNotNullExpressionValue(strOptString19, "optString(...)");
        String strOptString20 = jSONObject.optString("entry");
        Intrinsics.checkNotNullExpressionValue(strOptString20, "optString(...)");
        String strOptString21 = jSONObject.optString("startTime");
        if (StringsKt.isBlank(strOptString21)) {
            strOptString21 = strOptString8;
        }
        Intrinsics.checkNotNullExpressionValue(strOptString21, "ifBlank(...)");
        String str4 = strOptString21;
        String strOptString22 = jSONObject.optString("endTime");
        if (StringsKt.isBlank(strOptString22)) {
            strOptString22 = strOptString9;
        }
        Intrinsics.checkNotNullExpressionValue(strOptString22, "ifBlank(...)");
        String str5 = strOptString22;
        Intrinsics.checkNotNull(strOptString8);
        Intrinsics.checkNotNull(strOptString9);
        String strOptString23 = jSONObject.optString("brand");
        if (StringsKt.isBlank(strOptString23)) {
            strOptString23 = jSONObject.optString("carrier");
        }
        Intrinsics.checkNotNullExpressionValue(strOptString23, "ifBlank(...)");
        return new OnlineRecognitionResult(ticketTypeMapType, strOptString, str, strOptString7, null, null, str2, strOptString11, strOptString12, strOptString13, strOptString14, strOptString15, null, str3, strOptString17, strOptString18, strOptString19, strOptString20, str4, str5, strOptString8, strOptString9, strOptString23, responseText, 4144, null);
    }

    private final String extractContent(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof JSONArray) {
            StringBuilder sb = new StringBuilder();
            JSONArray jSONArray = (JSONArray) value;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object objOpt = jSONArray.opt(i);
                if (objOpt instanceof JSONObject) {
                    sb.append(((JSONObject) objOpt).optString("text"));
                } else if (objOpt instanceof String) {
                    sb.append((String) objOpt);
                }
            }
            return sb.toString();
        }
        String string = value != null ? value.toString() : null;
        return string == null ? "" : string;
    }

    private final String extractJsonObject(String text) {
        String string = StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(text, "```json", "", false, 4, (Object) null), "```", "", false, 4, (Object) null)).toString();
        String str = string;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '{', 0, false, 6, (Object) null);
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '}', 0, false, 6, (Object) null);
        if (iIndexOf$default < 0 || iLastIndexOf$default <= iIndexOf$default) {
            throw new IllegalStateException("模型没有返回有效 JSON。");
        }
        String strSubstring = string.substring(iIndexOf$default, iLastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final TicketType mapType(String value) {
        String str = value;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取餐", false, 2, (Object) null)) {
            return TicketType.TakeoutCode;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取件", false, 2, (Object) null)) {
            return TicketType.PickupCode;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "机票", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "航班", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "登机", false, 2, (Object) null)) {
            return TicketType.Airplane;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "车票", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "火车", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "高铁", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "列车", false, 2, (Object) null)) {
            return TicketType.Train;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "电影", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "影院", false, 2, (Object) null)) {
            return TicketType.Movie;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "演出", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "话剧", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "音乐会", false, 2, (Object) null)) {
            return TicketType.Event;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "门票", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "景区", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "活动", false, 2, (Object) null)) {
            return TicketType.Admission;
        }
        throw new IllegalStateException("无法确定票据类型，请检查图片。");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0063  */
    private final String loadImageAsDataUrl(Context context, Uri uri) throws IOException {
        Bitmap bitmapRenderFirstPdfPage;
        String type = context.getContentResolver().getType(uri);
        if (type == null) {
            type = "";
        }
        if (!StringsKt.equals(type, "application/pdf", true)) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".pdf", false, 2, (Object) null)) {
                bitmapRenderFirstPdfPage = renderFirstPdfPage(context, uri);
            } else {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    InputStream inputStream = inputStreamOpenInputStream;
                    if (inputStream == null) {
                        throw new IllegalArgumentException("无法读取图片文件。".toString());
                    }
                    bitmapRenderFirstPdfPage = BitmapFactory.decodeStream(inputStream);
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            }
        } else {
            bitmapRenderFirstPdfPage = renderFirstPdfPage(context, uri);
        }
        if (bitmapRenderFirstPdfPage == null) {
            throw new IllegalStateException("文件读取失败。");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            bitmapRenderFirstPdfPage.compress(Bitmap.CompressFormat.JPEG, 88, byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            if (!bitmapRenderFirstPdfPage.isRecycled()) {
                bitmapRenderFirstPdfPage.recycle();
            }
            return "data:image/jpeg;base64," + Base64.encodeToString(byteArray, 2);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(byteArrayOutputStream, th3);
                throw th4;
            }
        }
    }

    private final Bitmap renderFirstPdfPage(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new IllegalStateException("无法打开 PDF 文件。");
        }
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
        try {
            PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptor);
            try {
                PdfRenderer pdfRenderer2 = pdfRenderer;
                if (pdfRenderer2.getPageCount() <= 0) {
                    throw new IllegalStateException("PDF 没有可识别的页面。");
                }
                PdfRenderer.Page pageOpenPage = pdfRenderer2.openPage(0);
                try {
                    PdfRenderer.Page page = pageOpenPage;
                    int iCoerceIn = RangesKt.coerceIn(page.getWidth() * 2, WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND, 2400);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCoerceIn, RangesKt.coerceIn((int) ((page.getHeight() * iCoerceIn) / page.getWidth()), WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND, 3400), Bitmap.Config.ARGB_8888);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                    bitmapCreateBitmap.eraseColor(-1);
                    page.render(bitmapCreateBitmap, null, null, 1);
                    AutoCloseableKt.closeFinally(pageOpenPage, null);
                    AutoCloseableKt.closeFinally(pdfRenderer, null);
                    CloseableKt.closeFinally(parcelFileDescriptor, null);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(pageOpenPage, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(pdfRenderer, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            throw th5;
        }
        try {
            throw th5;
        } catch (Throwable th6) {
            CloseableKt.closeFinally(parcelFileDescriptor, th5);
            throw th6;
        }
    }
}
