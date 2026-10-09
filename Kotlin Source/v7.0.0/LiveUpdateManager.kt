package com.example.tickets

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.widget.RemoteViews

import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.content.ContextCompat
import androidx.compose.runtime.LaunchedEffect

import kotlin.math.roundToInt

/**
 * Live Update 数据载体。
 */
data class LiveUpdatePayload(
    val ticketId: Int,
    val ticketType: String,
    val title: String,
    val code: String,
    val date: String,
    val time: String,

    val departureDate: String = "",
    val arrivalDate: String = "",

    val from: String,
    val to: String,
    val departurePlatform: String = "",
    val arrivalPlatform: String = "",
    val hall: String,
    val seat: String,
    val venue: String,
    // 仅补充演出 / 门票展示字段；不改变任何通知时序或运行链。
    val area: String = "",
    val entry: String = "",
    val startTime: String,
    val endTime: String,
    val takeoffTime: String,
    val landingTime: String,
    val brand: String = ""
)

object LiveUpdateManager {

    const val ACTION_START =
        "com.example.tickets.action.START_LIVE_UPDATE"

    const val ACTION_STOP =
        "com.example.tickets.action.STOP_LIVE_UPDATE"

    const val ACTION_OPEN_TICKET =
        "com.example.tickets.action.OPEN_TICKET_FROM_NOTIFICATION"

    // 5.0.0 新版详情页专用动作：避免旧 PendingIntent 被系统继续复用。
    const val ACTION_OPEN_TICKET_V2 =
        "com.example.tickets.action.OPEN_TICKET_FROM_NOTIFICATION_V2"

    const val ACTION_MARK_TICKET_USED =
        "com.example.tickets.action.MARK_TICKET_USED"

    const val EXTRA_TICKET_ID =
        "ticket_id"

    const val EXTRA_TICKET_TYPE =
        "ticket_type"

    const val EXTRA_TITLE =
        "ticket_title"

    const val EXTRA_CODE =
        "ticket_code"

    const val EXTRA_DATE =
        "ticket_date"

    const val EXTRA_DEPARTURE_DATE =
        "ticket_departure_date"

    const val EXTRA_ARRIVAL_DATE =
        "ticket_arrival_date"

    const val EXTRA_TIME =
        "ticket_time"

    const val EXTRA_FROM =
        "ticket_from"

    const val EXTRA_TO =
        "ticket_to"

    const val EXTRA_DEPARTURE_PLATFORM =
        "ticket_departure_platform"

    const val EXTRA_ARRIVAL_PLATFORM =
        "ticket_arrival_platform"

    const val EXTRA_HALL =
        "ticket_hall"

    const val EXTRA_AREA =
        "ticket_area"

    const val EXTRA_ENTRY =
        "ticket_entry"

    const val EXTRA_SEAT =
        "ticket_seat"

    const val EXTRA_VENUE =
        "ticket_venue"

    const val EXTRA_START_TIME =
        "ticket_start_time"

    const val EXTRA_END_TIME =
        "ticket_end_time"

    const val EXTRA_TAKEOFF_TIME =
        "ticket_takeoff_time"

    const val EXTRA_LANDING_TIME =
        "ticket_landing_time"

    const val EXTRA_BRAND =
        "ticket_brand"

    private const val CHANNEL_BASE_ID =
        "ticket_live_updates"

    private const val CHANNEL_NAME =
        "票据实时动态"

    private const val BASE_NOTIFICATION_ID =
        41000

    private const val REQUEST_SCHEDULE_BASE =
        83000

    const val ACTION_SCHEDULED_START =
        "com.example.tickets.action.SCHEDULED_START_LIVE_UPDATE"

    fun createNotificationChannel(
        context: Context
    ) {

        if (
            Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.O
        ) {

            val manager =
                context.getSystemService(
                    Context.NOTIFICATION_SERVICE
                ) as NotificationManager

            RealtimeNotificationVisibilityController
                .createVisibilityChannels(
                    manager = manager,
                    baseId = CHANNEL_BASE_ID,
                    channelName = CHANNEL_NAME,
                    description = "显示票据实时进度与状态",
                    showBadge = true
                )
        }
    }

    fun showTicketLiveUpdate(
        context: Context,
        ticketId: Int,
        ticketType: String,
        title: String,
        code: String,
        date: String,
        time: String,

        departureDate: String = "",
        arrivalDate: String = "",

        from: String,
        to: String,
        departurePlatform: String = "",
        arrivalPlatform: String = "",
        hall: String,
        seat: String,
        venue: String,
        area: String = "",
        entry: String = "",
        startTime: String = "",
        endTime: String = "",
        takeoffTime: String = "",
        landingTime: String = "",
        brand: String = ""
    ) {

        if (
            !isSupportedType(
                ticketType
            )
        ) {
            return
        }

        if (
            Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        createNotificationChannel(
            context
        )

        val payload =
            LiveUpdatePayload(
                ticketId = ticketId,
                ticketType = ticketType,
                title = title,
                code = code,
                date = date,
                time = time,

                departureDate =
                    departureDate.ifBlank {
                        date
                    },

                arrivalDate =
                    arrivalDate.ifBlank {
                        departureDate.ifBlank {
                            date
                        }
                    },

                from = from,
                to = to,
                departurePlatform = departurePlatform,
                arrivalPlatform = arrivalPlatform,
                hall = hall,
                seat = seat,
                venue = venue,
                area = area,
                entry = entry,
                startTime = startTime,
                endTime = endTime,
                takeoffTime = takeoffTime,
                landingTime = landingTime,
                brand = brand
            )

        val now =
            System.currentTimeMillis()

        val displayStart =
            if (isDayCountdownTicket(ticketType)) {
                resolveWindow(payload).first
            } else {
                RealtimeNotificationStateCalculator
                    .displayStartAt(
                        payload
                    )
            }

        if (
            displayStart !=
            Long.MAX_VALUE &&
            now < displayStart
        ) {

            scheduleLiveUpdateStart(
                context,
                payload,
                displayStart
            )

            return
        }

        cancelScheduledLiveUpdate(
            context,
            ticketId
        )

        try {

            NotificationManagerCompat
                .from(context)
                .notify(
                    notificationId(
                        ticketId
                    ),
                    buildNotification(
                        context,
                        payload
                    )
                )

        } catch (
            _: SecurityException
        ) {
            return
        }

        startLiveUpdateService(
            context,
            payload
        )
    }

    private fun scheduleLiveUpdateStart(
        context: Context,
        payload: LiveUpdatePayload,
        triggerAtMillis: Long
    ) {

        val alarmManager =
            context.getSystemService(
                Context.ALARM_SERVICE
            ) as AlarmManager

        val intent =
            Intent(
                context,
                LiveUpdateService::class.java
            ).apply {

                action =
                    ACTION_SCHEDULED_START

                putExtra(
                    EXTRA_TICKET_ID,
                    payload.ticketId
                )
                putExtra(
                    EXTRA_TICKET_TYPE,
                    payload.ticketType
                )
                putExtra(
                    EXTRA_TITLE,
                    payload.title
                )
                putExtra(
                    EXTRA_CODE,
                    payload.code
                )
                putExtra(
                    EXTRA_DATE,
                    payload.date
                )
                putExtra(
                    EXTRA_DEPARTURE_DATE,
                    payload.departureDate
                )
                putExtra(
                    EXTRA_ARRIVAL_DATE,
                    payload.arrivalDate
                )
                putExtra(
                    EXTRA_TIME,
                    payload.time
                )
                putExtra(
                    EXTRA_FROM,
                    payload.from
                )
                putExtra(
                    EXTRA_TO,
                    payload.to
                )
                putExtra(
                    EXTRA_DEPARTURE_PLATFORM,
                    payload.departurePlatform
                )
                putExtra(
                    EXTRA_ARRIVAL_PLATFORM,
                    payload.arrivalPlatform
                )
                putExtra(
                    EXTRA_HALL,
                    payload.hall
                )
                putExtra(
                    EXTRA_AREA,
                    payload.area
                )
                putExtra(
                    EXTRA_ENTRY,
                    payload.entry
                )
                putExtra(
                    EXTRA_SEAT,
                    payload.seat
                )
                putExtra(
                    EXTRA_VENUE,
                    payload.venue
                )
                putExtra(
                    EXTRA_START_TIME,
                    payload.startTime
                )
                putExtra(
                    EXTRA_END_TIME,
                    payload.endTime
                )
                putExtra(
                    EXTRA_TAKEOFF_TIME,
                    payload.takeoffTime
                )
                putExtra(
                    EXTRA_LANDING_TIME,
                    payload.landingTime
                )
                putExtra(
                    EXTRA_BRAND,
                    payload.brand
                )
            }

        val pendingIntent =
            PendingIntent.getService(
                context,
                REQUEST_SCHEDULE_BASE + payload.ticketId,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        PendingIntent.FLAG_IMMUTABLE
            )

        try {

            if (
                Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.M
            ) {

                alarmManager.setAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerAtMillis,
                    pendingIntent
                )

            } else {

                alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    triggerAtMillis,
                    pendingIntent
                )
            }

        } catch (
            _: SecurityException
        ) {
        }
    }

    private fun cancelScheduledLiveUpdate(
        context: Context,
        ticketId: Int
    ) {

        val alarmManager =
            context.getSystemService(
                Context.ALARM_SERVICE
            ) as AlarmManager

        val intent =
            Intent(
                context,
                LiveUpdateService::class.java
            ).apply {

                action =
                    ACTION_SCHEDULED_START
            }

        val pendingIntent =
            PendingIntent.getService(
                context,
                REQUEST_SCHEDULE_BASE + ticketId,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        PendingIntent.FLAG_IMMUTABLE
            )

        try {

            alarmManager.cancel(
                pendingIntent
            )

        } catch (
            _: Exception
        ) {
        }

        pendingIntent.cancel()
    }

    private fun startLiveUpdateService(
        context: Context,
        payload: LiveUpdatePayload
    ) {

        if (RealtimeNotificationVisibilityController.isAppForeground) {
            return
        }

        val intent =
            Intent(
                context,
                LiveUpdateService::class.java
            ).apply {

                action =
                    ACTION_START

                putExtra(
                    EXTRA_TICKET_ID,
                    payload.ticketId
                )
                putExtra(
                    EXTRA_TICKET_TYPE,
                    payload.ticketType
                )
                putExtra(
                    EXTRA_TITLE,
                    payload.title
                )
                putExtra(
                    EXTRA_CODE,
                    payload.code
                )
                putExtra(
                    EXTRA_DATE,
                    payload.date
                )
                putExtra(
                    EXTRA_DEPARTURE_DATE,
                    payload.departureDate
                )
                putExtra(
                    EXTRA_ARRIVAL_DATE,
                    payload.arrivalDate
                )
                putExtra(
                    EXTRA_TIME,
                    payload.time
                )
                putExtra(
                    EXTRA_FROM,
                    payload.from
                )
                putExtra(
                    EXTRA_TO,
                    payload.to
                )
                putExtra(
                    EXTRA_DEPARTURE_PLATFORM,
                    payload.departurePlatform
                )
                putExtra(
                    EXTRA_ARRIVAL_PLATFORM,
                    payload.arrivalPlatform
                )
                putExtra(
                    EXTRA_HALL,
                    payload.hall
                )
                putExtra(
                    EXTRA_SEAT,
                    payload.seat
                )
                putExtra(
                    EXTRA_VENUE,
                    payload.venue
                )
                putExtra(
                    EXTRA_START_TIME,
                    payload.startTime
                )
                putExtra(
                    EXTRA_END_TIME,
                    payload.endTime
                )
                putExtra(
                    EXTRA_TAKEOFF_TIME,
                    payload.takeoffTime
                )
                putExtra(
                    EXTRA_LANDING_TIME,
                    payload.landingTime
                )
            }

        try {

            if (
                Build.VERSION.SDK_INT < 34 ||
                (
                        ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.FOREGROUND_SERVICE
                        ) ==
                                PackageManager.PERMISSION_GRANTED &&
                                ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.FOREGROUND_SERVICE_SPECIAL_USE
                                ) ==
                                PackageManager.PERMISSION_GRANTED
                        )
            ) {

                ContextCompat
                    .startForegroundService(
                        context,
                        intent
                    )
            }

        } catch (
            _: Exception
        ) {
        }
    }

    fun cancelTicketLiveUpdate(
        context: Context,
        ticketId: Int
    ) {

        cancelScheduledLiveUpdate(
            context,
            ticketId
        )

        val intent =
            Intent(
                context,
                LiveUpdateService::class.java
            ).apply {

                action =
                    ACTION_STOP

                putExtra(
                    EXTRA_TICKET_ID,
                    ticketId
                )
            }

        try {
            context.startService(
                intent
            )
        } catch (
            _: Exception
        ) {
        }

        NotificationManagerCompat
            .from(context)
            .cancel(
                notificationId(
                    ticketId
                )
            )
    }

    fun cancelAll(
        context: Context,
        ticketIds: List<Int>
    ) {

        ticketIds.forEach { id ->
            cancelTicketLiveUpdate(
                context,
                id
            )
        }
    }

    fun notificationId(
        ticketId: Int
    ): Int =
        BASE_NOTIFICATION_ID + ticketId

    fun isSupportedType(
        ticketType: String
    ): Boolean =
        ticketType == "电影票" ||
                ticketType == "车票" ||
                ticketType == "火车票" ||
                ticketType == "机票" ||
                ticketType == "演出" ||
                ticketType == "门票" ||
                ticketType == "取餐码" ||
                ticketType == "取件码"

    fun buildPayload(
        intent: Intent
    ): LiveUpdatePayload {

        return LiveUpdatePayload(
            ticketId =
                intent.getIntExtra(
                    EXTRA_TICKET_ID,
                    0
                ),
            ticketType =
                intent.getStringExtra(
                    EXTRA_TICKET_TYPE
                ).orEmpty(),
            title =
                intent.getStringExtra(
                    EXTRA_TITLE
                ).orEmpty(),
            code =
                intent.getStringExtra(
                    EXTRA_CODE
                ).orEmpty(),
            date =
                intent.getStringExtra(
                    EXTRA_DATE
                ).orEmpty(),

            departureDate =
                intent.getStringExtra(
                    EXTRA_DEPARTURE_DATE
                ).orEmpty()
                    .ifBlank {
                        intent.getStringExtra(
                            EXTRA_DATE
                        ).orEmpty()
                    },

            arrivalDate =
                intent.getStringExtra(
                    EXTRA_ARRIVAL_DATE
                ).orEmpty()
                    .ifBlank {
                        intent.getStringExtra(
                            EXTRA_DEPARTURE_DATE
                        ).orEmpty()
                            .ifBlank {
                                intent.getStringExtra(
                                    EXTRA_DATE
                                ).orEmpty()
                            }
                    },

            time =
                intent.getStringExtra(
                    EXTRA_TIME
                ).orEmpty(),
            from =
                intent.getStringExtra(
                    EXTRA_FROM
                ).orEmpty(),
            to =
                intent.getStringExtra(
                    EXTRA_TO
                ).orEmpty(),
            departurePlatform =
                intent.getStringExtra(
                    EXTRA_DEPARTURE_PLATFORM
                ).orEmpty(),
            arrivalPlatform =
                intent.getStringExtra(
                    EXTRA_ARRIVAL_PLATFORM
                ).orEmpty(),
            hall =
                intent.getStringExtra(
                    EXTRA_HALL
                ).orEmpty(),
            area =
                intent.getStringExtra(
                    EXTRA_AREA
                ).orEmpty(),
            entry =
                intent.getStringExtra(
                    EXTRA_ENTRY
                ).orEmpty(),
            seat =
                intent.getStringExtra(
                    EXTRA_SEAT
                ).orEmpty(),
            venue =
                intent.getStringExtra(
                    EXTRA_VENUE
                ).orEmpty(),
            startTime =
                intent.getStringExtra(
                    EXTRA_START_TIME
                ).orEmpty(),
            endTime =
                intent.getStringExtra(
                    EXTRA_END_TIME
                ).orEmpty(),

            takeoffTime =
                intent.getStringExtra(
                    EXTRA_TAKEOFF_TIME
                ).orEmpty(),

            landingTime =
                intent.getStringExtra(
                    EXTRA_LANDING_TIME
                ).orEmpty(),
            brand =
                intent.getStringExtra(
                    EXTRA_BRAND
                ).orEmpty()
        )
    }

    private fun isDayCountdownTicket(
        ticketType: String
    ): Boolean =
        ticketType == "取餐码" ||
                ticketType == "取件码" ||
                ticketType == "演出" ||
                ticketType == "门票"


    fun resolveWindow(
        payload:
        LiveUpdatePayload
    ):
            Pair<Long, Long> {

        val isDayCountdownTicket =
            payload.ticketType == "取餐码" ||
                    payload.ticketType == "取件码" ||
                    payload.ticketType == "演出" ||
                    payload.ticketType == "门票"

        if (isDayCountdownTicket) {
            val start =
                parseDateTime(
                    payload.date,
                    "00:00"
                ) ?: return Pair(
                    Long.MAX_VALUE,
                    Long.MAX_VALUE
                )

            return Pair(
                start,
                start + 24L * 60L * 60L * 1000L
            )
        }

        val isTravel =
            payload.ticketType ==
                    "车票" ||
                    payload.ticketType ==
                    "火车票" ||
                    payload.ticketType ==
                    "机票"

        val departureDate =
            if (
                isTravel
            ) {
                payload.departureDate
                    .ifBlank {
                        payload.date
                    }
            } else {
                payload.date
            }

        val arrivalDate =
            if (
                isTravel
            ) {
                payload.arrivalDate
                    .ifBlank {
                        payload.departureDate
                            .ifBlank {
                                payload.date
                            }
                    }
            } else {
                payload.date
            }

        val start =
            parseDateTime(
                departureDate,
                payload.startTime.ifBlank {
                    payload.time
                }
            ) ?: Long.MAX_VALUE

        val explicitEnd =
            parseDateTime(
                arrivalDate,
                payload.endTime
            )

        val defaultDuration =
            when (
                payload.ticketType
            ) {

                "电影票" ->
                    150L *
                            60L *
                            1000L

                "车票",
                "火车票",
                "机票" ->
                    120L *
                            60L *
                            1000L

                else ->
                    120L *
                            60L *
                            1000L
            }

        val end =
            if (
                start ==
                Long.MAX_VALUE
            ) {
                Long.MAX_VALUE
            } else {
                explicitEnd
                    ?.takeIf {
                        it > start
                    }
                    ?: (
                            start +
                                    defaultDuration
                            )
            }

        return Pair(
            start,
            end
        )
    }

    fun buildNotification(
        context:
        Context,
        payload:
        LiveUpdatePayload
    ): android.app.Notification {

        createNotificationChannel(
            context
        )

        val codeTicket =
            payload.ticketType == "取餐码" ||
                    payload.ticketType == "取件码"

        val dayCountdownTicket =
            isDayCountdownTicket(payload.ticketType)

        val window =
            resolveWindow(
                payload
            )

        val startMillis =
            window.first

        val endMillis =
            window.second

        val now =
            System.currentTimeMillis()

        val state =
            if (dayCountdownTicket) {
                null
            } else {
                RealtimeNotificationStateCalculator
                    .calculate(
                        payload,
                        now
                    )
            }

        val progressPermille =
            if (
                dayCountdownTicket &&
                startMillis != Long.MAX_VALUE &&
                endMillis > startMillis
            ) {
                (
                        (
                                (now - startMillis)
                                    .coerceAtLeast(0L) *
                                        1000L
                                ) /
                                (endMillis - startMillis)
                                    .coerceAtLeast(1L)
                        )
                    .coerceIn(
                        0L,
                        1000L
                    )
                    .toInt()
            } else {
                state?.progressPermille ?: 0
            }

        val status =
            if (dayCountdownTicket) {
                val remainingMillis =
                    (
                            endMillis - now
                            ).coerceAtLeast(0L)

                val totalMinutes =
                    remainingMillis /
                            (60L * 1000L)

                val hours =
                    totalMinutes / 60L

                val minutes =
                    totalMinutes % 60L

                if (hours > 0L) {
                    "今日有效 · 距今天结束还有 ${hours}小时${minutes}分"
                } else {
                    "今日有效 · 距今天结束还有 ${minutes}分"
                }
            } else {
                state?.statusText.orEmpty()
            }

        val details =
            when (
                payload.ticketType
            ) {

                "电影票" -> listOf(
                    payload.date
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "日期 $it"
                        }
                        .orEmpty(),

                    payload.startTime
                        .ifBlank {
                            payload.time
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "开始 $it"
                        }
                        .orEmpty(),

                    payload.endTime
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "结束 $it"
                        }
                        .orEmpty(),

                    payload.hall
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "影厅 $it"
                        }
                        .orEmpty(),

                    payload.seat
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "座位 $it"
                        }
                        .orEmpty()
                )

                "车票",
                "火车票" -> listOf(
                    payload.departureDate
                        .ifBlank {
                            payload.date
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发日期 $it"
                        }
                        .orEmpty(),

                    payload.arrivalDate
                        .ifBlank {
                            payload.departureDate
                                .ifBlank {
                                    payload.date
                                }
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达日期 $it"
                        }
                        .orEmpty(),

                    payload.startTime
                        .ifBlank {
                            payload.time
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发 $it"
                        }
                        .orEmpty(),

                    payload.endTime
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达 $it"
                        }
                        .orEmpty(),

                    payload.departurePlatform
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发站台 $it"
                        }
                        .orEmpty(),

                    payload.arrivalPlatform
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达站台 $it"
                        }
                        .orEmpty(),

                    payload.seat
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "座位 $it"
                        }
                        .orEmpty()
                )

                "机票" -> listOf(
                    payload.departureDate
                        .ifBlank {
                            payload.date
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发日期 $it"
                        }
                        .orEmpty(),

                    payload.arrivalDate
                        .ifBlank {
                            payload.departureDate
                                .ifBlank {
                                    payload.date
                                }
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达日期 $it"
                        }
                        .orEmpty(),

                    payload.startTime
                        .ifBlank {
                            payload.time
                        }
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发 $it"
                        }
                        .orEmpty(),

                    payload.endTime
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达 $it"
                        }
                        .orEmpty(),

                    payload.departurePlatform
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "出发站台 $it"
                        }
                        .orEmpty(),

                    payload.arrivalPlatform
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "到达站台 $it"
                        }
                        .orEmpty(),

                    payload.seat
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "座位 $it"
                        }
                        .orEmpty()
                )

                "取餐码" -> listOf(
                    payload.title
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "名称 $it"
                        }
                        .orEmpty(),

                    payload.brand
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "品牌 $it"
                        }
                        .orEmpty(),

                    payload.venue
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "地点 $it"
                        }
                        .orEmpty(),

                    payload.date
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "日期 $it"
                        }
                        .orEmpty(),

                    payload.time
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "时间 $it"
                        }
                        .orEmpty()
                )

                "取件码" -> listOf(
                    payload.title
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "名称 $it"
                        }
                        .orEmpty(),

                    payload.brand
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "品牌 $it"
                        }
                        .orEmpty(),

                    payload.venue
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "地点 $it"
                        }
                        .orEmpty(),

                    payload.date
                        .takeIf {
                            it.isNotBlank()
                        }
                        ?.let {
                            "日期 $it"
                        }
                        .orEmpty()
                )

                "演出" -> listOf(
                    payload.startTime.ifBlank { payload.time }
                        .takeIf { it.isNotBlank() }?.let { "时间 $it" }.orEmpty(),
                    payload.venue.takeIf { it.isNotBlank() }?.let { "地点 $it" }.orEmpty(),
                    payload.area.takeIf { it.isNotBlank() }?.let { "区域 $it" }.orEmpty(),
                    payload.seat.takeIf { it.isNotBlank() }?.let { "座位 $it" }.orEmpty()
                )

                "门票" -> listOf(
                    payload.time.takeIf { it.isNotBlank() }?.let { "时间 $it" }.orEmpty(),
                    payload.venue.takeIf { it.isNotBlank() }?.let { "地点 $it" }.orEmpty(),
                    payload.entry.takeIf { it.isNotBlank() }?.let { "入口 $it" }.orEmpty(),
                    payload.seat.takeIf { it.isNotBlank() }?.let { "座位 $it" }.orEmpty()
                )

                else ->
                    emptyList()
            }

        val detailText =
            details
                .filter {
                    it.isNotBlank()
                }
                .joinToString(
                    "  ·  "
                )

        val content =
            if (detailText.isBlank()) {
                status
            } else {
                "$status  ·  $detailText"
            }

        val displayTitle =
            if (
                payload.ticketType == "车票" ||
                payload.ticketType == "机票" ||
                codeTicket
            ) {
                payload.code
                    .ifBlank {
                        payload.title
                    }
            } else {
                payload.title
            }.ifBlank {
                "票据"
            }

        val routeText =
            if (
                payload.from.isNotBlank() &&
                payload.to.isNotBlank()
            ) {
                "${payload.from} → ${payload.to}"
            } else {
                ""
            }

        val bigText =
            listOf(
                status,
                routeText,
                detailText
            )
                .filter {
                    it.isNotBlank()
                }
                .joinToString(
                    "\n"
                )

        val accentColor =
            notificationAccentColor(
                payload.ticketType
            )

        val builder =
            NotificationCompat.Builder(
                context,
                RealtimeNotificationVisibilityController.channelId(CHANNEL_BASE_ID)
            )
                .setSmallIcon(
                    selectSmallIcon(
                        context,
                        payload
                    )
                )
                .setColor(
                    accentColor
                )
                // 保持这个基础版本的普通通知背景行为：
                // 即使是取餐码/取件码，也不使用整卡 Colorized。
                .setColorized(
                    false
                )
                .setSubText(
                    payload.ticketType
                )
                .setContentTitle(
                    displayTitle
                )
                .setContentText(
                    content
                        .ifBlank {
                            status
                                .ifBlank {
                                    payload.ticketType
                                        .ifBlank { "票据" }
                                }
                        }
                )
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .setBigContentTitle(
                            displayTitle
                        )
                        .bigText(
                            bigText
                        )
                        .setSummaryText(
                            payload.ticketType
                        )
                )
                .setPriority(
                    NotificationCompat.PRIORITY_LOW
                )
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setAutoCancel(false)
                .setLocalOnly(true)
                .setVisibility(
                    NotificationCompat.VISIBILITY_PUBLIC
                )
                .setWhen(
                    now
                )
                .setShowWhen(
                    true
                )
                .setProgress(
                    1000,
                    progressPermille,
                    false
                )

        if (codeTicket) {
            val actionIntent =
                Intent(
                    context,
                    MainActivity::class.java
                ).apply {
                    action =
                        ACTION_MARK_TICKET_USED

                    putExtra(
                        EXTRA_TICKET_ID,
                        payload.ticketId
                    )

                    flags =
                        Intent.FLAG_ACTIVITY_SINGLE_TOP or
                                Intent.FLAG_ACTIVITY_CLEAR_TOP
                }

            val actionPendingIntent =
                PendingIntent.getActivity(
                    context,
                    91000 + payload.ticketId,
                    actionIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT or
                            PendingIntent.FLAG_IMMUTABLE
                )

            val actionText =
                if (
                    payload.ticketType == "取餐码"
                ) {
                    "我已取餐"
                } else {
                    "我已取件"
                }

            val actionIconRes =
                when (payload.ticketType) {
                    "取餐码" ->
                        selectTakeoutNotificationIconRes(
                            context,
                            payload.brand
                        )

                    "取件码" ->
                        R.drawable.ic_live_pickup

                    "演出" ->
                        R.drawable.ic_live_event

                    "门票" ->
                        R.drawable.ic_live_admission

                    else ->
                        R.drawable.ic_live_movie
                }

            builder.addAction(
                actionIconRes,
                actionText,
                actionPendingIntent
            )
        }

        /*
         * 所有实时通知统一提供“打开票据”。
         * 取餐码 / 取件码仍保留原来的“我已取餐 / 我已取件”，
         * 因此这两类通知拥有两个并排的 Notification action。
         */
        val openTicketIntent =
            Intent(
                context,
                MainActivity::class.java
            ).apply {
                action = ACTION_OPEN_TICKET_V2
                putExtra(
                    EXTRA_TICKET_ID,
                    payload.ticketId
                )
                flags =
                    Intent.FLAG_ACTIVITY_SINGLE_TOP or
                            Intent.FLAG_ACTIVITY_CLEAR_TOP
            }

        val openTicketPendingIntent =
            PendingIntent.getActivity(
                context,
                92000 + payload.ticketId,
                openTicketIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        PendingIntent.FLAG_IMMUTABLE
            )

        builder.setContentIntent(
            openTicketPendingIntent
        )

        builder.addAction(
            android.R.drawable.ic_menu_view,
            "打开票据",
            openTicketPendingIntent
        )

        if (
            Build.VERSION.SDK_INT >= 36
        ) {
            builder.setRequestPromotedOngoing(
                true
            )
        }

        return builder.build()
    }

    fun parseDateTime(
        date:
        String,

        time:
        String
    ):
            Long? {

        return parseFlexibleDateTime(
            date,
            time
        )
    }

    private fun parseFlexibleDateTime(
        date:
        String,

        time:
        String
    ):
            Long? {

        if (
            date.isBlank() ||
            time.isBlank()
        ) {
            return null
        }

        val dateMatch =
            Regex(
                """(\d{4})\D+(\d{1,2})\D+(\d{1,2})"""
            ).find(
                date.trim()
            )

        if (
            dateMatch == null
        ) {
            return null
        }

        val year =
            dateMatch.groupValues[1]
                .toIntOrNull()
                ?: return null

        val month =
            dateMatch.groupValues[2]
                .toIntOrNull()
                ?: return null

        val day =
            dateMatch.groupValues[3]
                .toIntOrNull()
                ?: return null

        val rawTime =
            time
                .trim()
                .replace(
                    "：",
                    ":"
                )
                .replace(
                    "．",
                    "."
                )
                .replace(
                    "a.m.",
                    "AM",
                    ignoreCase = true
                )
                .replace(
                    "p.m.",
                    "PM",
                    ignoreCase = true
                )
                .replace(
                    "a.m",
                    "AM",
                    ignoreCase = true
                )
                .replace(
                    "p.m",
                    "PM",
                    ignoreCase = true
                )
                .replace(
                    "上午",
                    "AM",
                    ignoreCase = true
                )
                .replace(
                    "下午",
                    "PM",
                    ignoreCase = true
                )
                .replace(
                    Regex(
                        """\s+"""
                    ),
                    ""
                )

        val chineseMeridiem =
            when {

                time.contains(
                    "下午"
                ) ->
                    "PM"

                time.contains(
                    "上午"
                ) ->
                    "AM"

                else ->
                    null
            }

        val meridiem =
            chineseMeridiem
                ?: Regex(
                    """(?i)(AM|PM)$"""
                )
                    .find(
                        rawTime
                    )
                    ?.groupValues
                    ?.getOrNull(1)
                    ?.uppercase(
                        java.util.Locale.US
                    )

        val clockText =
            if (
                meridiem != null
            ) {

                rawTime
                    .removeSuffix(
                        meridiem
                    )

            } else {

                rawTime
            }

        val timeMatch =
            Regex(
                """^(\d{1,2}):(\d{2})$"""
            ).matchEntire(
                clockText
            )
                ?: return null

        val rawHour =
            timeMatch.groupValues[1]
                .toIntOrNull()
                ?: return null

        val minute =
            timeMatch.groupValues[2]
                .toIntOrNull()
                ?: return null

        if (
            minute !in 0..59
        ) {
            return null
        }

        val hour =
            if (
                meridiem == null
            ) {

                if (
                    rawHour !in 0..23
                ) {
                    return null
                }

                rawHour

            } else {

                if (
                    rawHour !in 1..12
                ) {
                    return null
                }

                when (
                    meridiem
                ) {

                    "AM" ->
                        if (
                            rawHour == 12
                        ) {
                            0
                        } else {
                            rawHour
                        }

                    "PM" ->
                        if (
                            rawHour == 12
                        ) {
                            12
                        } else {
                            rawHour + 12
                        }

                    else ->
                        return null
                }
            }

        return try {

            java.util.Calendar
                .getInstance()
                .apply {

                    clear()

                    set(
                        java.util.Calendar.YEAR,
                        year
                    )

                    set(
                        java.util.Calendar.MONTH,
                        month - 1
                    )

                    set(
                        java.util.Calendar.DAY_OF_MONTH,
                        day
                    )

                    set(
                        java.util.Calendar.HOUR_OF_DAY,
                        hour
                    )

                    set(
                        java.util.Calendar.MINUTE,
                        minute
                    )

                    set(
                        java.util.Calendar.SECOND,
                        0
                    )

                    set(
                        java.util.Calendar.MILLISECOND,
                        0
                    )
                }
                .timeInMillis

        } catch (
            _: Exception
        ) {

            null
        }
    }

    private fun isCodeTicket(
        ticketType:
        String
    ): Boolean =
        ticketType == "取餐码" ||
                ticketType == "取件码"

    private fun notificationAccentColor(
        ticketType:
        String
    ):
            Int {

        return when (
            ticketType
        ) {

            "车票", "火车票" ->
                android.graphics.Color.rgb(
                    90,
                    145,
                    213
                )

            "机票" ->
                android.graphics.Color.rgb(
                    67,
                    184,
                    162
                )

            "电影票" ->
                android.graphics.Color.rgb(
                    232,
                    120,
                    104
                )

            "演出" ->
                android.graphics.Color.rgb(
                    161,
                    129,
                    215
                )

            "门票" ->
                android.graphics.Color.rgb(
                    211,
                    154,
                    84
                )

            "取餐码" ->
                android.graphics.Color.rgb(
                    123,
                    183,
                    232
                )

            "取件码" ->
                android.graphics.Color.rgb(
                    154,
                    154,
                    154
                )

            else ->
                android.graphics.Color.rgb(
                    74,
                    140,
                    255
                )
        }
    }


    private fun selectSmallIcon(
        context: Context,
        payload: LiveUpdatePayload
    ): Int {

        return when (payload.ticketType) {
            "车票", "火车票" ->
                R.drawable.ic_live_train

            "电影票" ->
                R.drawable.ic_live_movie

            "演出" ->
                R.drawable.ic_live_event

            "门票" ->
                R.drawable.ic_live_admission

            "机票" ->
                selectAirplaneIcon(payload)

            "取件码" ->
                R.drawable.ic_live_pickup

            "取餐码" ->
                selectTakeoutNotificationIconRes(
                    context,
                    payload.brand
                )

            else ->
                R.drawable.ic_live_movie
        }
    }

    /**
     * 直接沿用历史成功版本的 LiveUpdate 取餐码通知图标逻辑。
     * 这里故意返回 Int resource，不做 IconCompat/Bitmap 转换，
     * 因为历史成功版就是直接把 drawable resource 交给 setSmallIcon()。
     */
    /**
     * 取餐码通知图标直接复用票据品牌 drawable 资源。
     * TicketBrandIconResolver 返回的就是项目现有的 ic_brand_* 资源 ID。
     */
    private fun selectTakeoutNotificationIconRes(
        context: Context,
        brand: String
    ): Int {
        val normalizedBrand = brand.trim()

        if (normalizedBrand.isNotBlank()) {
            TicketBrandIconResolver
                .resolveBrandNotificationRes(
                    context,
                    normalizedBrand
                )
                ?.let { return it }
        }

        // 没有匹配到品牌时才回退默认取餐图标。
        return R.drawable.ic_live_takeout
    }

    private fun selectAirplaneIcon(
        payload:
        LiveUpdatePayload
    ):
            Int {

        val (
            start,
            end
        ) =
            resolveWindow(
                payload
            )

        if (
            start ==
            Long.MAX_VALUE
        ) {
            return R.drawable.ic_live_plane_departure
        }

        val explicitTakeoff =
            parseFlightPhaseDateTime(
                payload.date,
                payload.takeoffTime
            )

        val explicitLanding =
            parseFlightPhaseDateTime(
                payload.date,
                payload.landingTime
            )

        val now =
            System.currentTimeMillis()

        /*
         * 用户填写了起飞/降落时间：
         * 直接按照这两个时间切换图标。
         */
        if (
            explicitTakeoff != null ||
            explicitLanding != null
        ) {

            val takeoff =
                explicitTakeoff
                    ?: start

            val landing =
                explicitLanding
                    ?.takeIf {
                        it > takeoff
                    }
                    ?: end

            return when {

                now <
                        takeoff ->
                    R.drawable.ic_live_plane_departure

                now >=
                        landing ->
                    R.drawable.ic_live_plane_arrival

                else ->
                    R.drawable.ic_live_plane_airborne
            }
        }

        /*
         * 没有填写起飞/降落时间：
         * 实际开始后的前 20 分钟 = 起飞；
         * 实际结束前的后 20 分钟 = 降落；
         * 中间 = 行程中/飞行中。
         */
        val departureEnd =
            minOf(
                start +
                        20L *
                        60L *
                        1000L,
                end
            )

        val arrivalStart =
            maxOf(
                start,
                end -
                        20L *
                        60L *
                        1000L
            )

        return when {

            now <
                    departureEnd ->
                R.drawable.ic_live_plane_departure

            now >=
                    arrivalStart ->
                R.drawable.ic_live_plane_arrival

            else ->
                R.drawable.ic_live_plane_airborne
        }
    }

    private fun parseFlightPhaseDateTime(
        date:
        String,

        time:
        String
    ):
            Long? {

        return parseFlexibleDateTime(
            date,
            time
        )
    }

    private fun formatClock(
        millis: Long
    ): String {

        return java.text.SimpleDateFormat(
            "HH:mm",
            java.util.Locale.getDefault()
        ).format(
            java.util.Date(millis)
        )
    }

    /**
     * 智能地铁专用 Live Update。
     *
     * 这里刻意使用 Android 16 / AndroidX 1.17+ 的 ProgressStyle 系统模板：
     * - 不使用 RemoteViews；
     * - 系统负责整张通知卡片的外壳、排版和进度区域渲染；
     * - 三站路线由 ProgressStyle 的 Segments / Points 表达；
     * - 左侧大圆形线路徽章通过 LargeIcon 动态生成，由系统模板自动放置；
     * - 右上角 ETA / 时间刻意关闭，不设置 When。
     *
     * 除智能地铁外，不改变当前 LiveUpdateManager 中其它票据的通知链路。
     */
    fun showSmartSubway(
        context: Context,
        state: SmartSubwayRealtimeState
    ): Boolean {
        return runCatching {
            createNotificationChannel(context)

            val content = buildSmartSubwayHorizontalCardContent(state)

            val activeLineColor =
                if (state.isAfterTransfer()) {
                    state.secondaryLineColor
                } else {
                    state.primaryLineColor
                }

            val activeLineName =
                if (
                    state.isAfterTransfer() &&
                    state.transferLineName.isNotBlank()
                ) {
                    state.transferLineName
                } else {
                    state.lineName
                }.ifBlank {
                    "地铁"
                }

            val actionText =
                content.statusText.ifBlank {
                    when {
                        state.isDestination ->
                            "带齐物品准备下车"

                        else ->
                            "正在前往下一站"
                    }
                }

            val lineSummary =
                run {
                    val destination = state.destination.trim()
                    if (destination.isBlank()) {
                        activeLineName
                    } else {
                        "$activeLineName  ·  → $destination"
                    }
                }

            val previousStation =
                content.previousStation.ifBlank {
                    "无"
                }

            val currentStation =
                content.currentStation.ifBlank {
                    "当前站"
                }

            val nextStation =
                content.nextStation.ifBlank {
                    "下一站"
                }

            /*
             * Android ProgressStyle 的系统模板会把：
             * SubText → ContentTitle → ContentText → ProgressStyle
             * 按系统原生方式自动排版。
             *
             * 因为 Figma 中的三站文字无法直接附着到 ProgressStyle 的
             * point 下方，这里保留一行紧凑的站点路径作为系统 ContentText
             * 的第二行信息；真正的路线进度仍由 ProgressStyle 渲染。
             */
            val contentText =
                listOf(
                    "$lineSummary  ·  $actionText",
                    "$previousStation  →  $currentStation  →  $nextStation"
                ).joinToString("\n")

            val builder =
                NotificationCompat.Builder(
                    context,
                    RealtimeNotificationVisibilityController.channelId(CHANNEL_BASE_ID)
                )
                    .setSmallIcon(
                        IconCompat.createWithBitmap(
                            buildSmartSubwayStatusBarIcon(
                                context = context,
                                lineName = activeLineName
                            )
                        )
                    )
                    .setLargeIcon(
                        buildSmartSubwayAutoMatchedServiceIcon(
                            state = state,
                            sizePx = 96
                        )
                    )
                    .setColor(
                        activeLineColor
                    )
                    .setColorized(
                        false
                    )
                    .setSubText(
                        if (state.isDestination) {
                            "智能地铁 · 已到达"
                        } else {
                            "智能地铁 · 行程中"
                        }
                    )
                    .setContentTitle(
                        currentStation
                    )
                    .setContentText(
                        contentText
                    )
                    .setStyle(
                        buildSmartSubwayLiveUpdateProgressStyle(
                            state = state
                        )
                    )
                    .setOngoing(
                        true
                    )
                    .setOnlyAlertOnce(
                        true
                    )
                    .setShowWhen(
                        false
                    )
                    .setLocalOnly(
                        true
                    )
                    .setCategory(
                        NotificationCompat.CATEGORY_NAVIGATION
                    )
                    .setVisibility(
                        NotificationCompat.VISIBILITY_PUBLIC
                    )

            /*
             * Android 16+：请求系统将这条通知作为 Promoted Ongoing Live Update。
             * Android 16 以下则保留一个普通系统进度条作为降级表现。
             */
            if (
                Build.VERSION.SDK_INT >= 36
            ) {
                builder.setRequestPromotedOngoing(
                    true
                )
            } else {
                val fallbackProgress =
                    if (state.isDestination) {
                        200
                    } else {
                        100 +
                                kotlin.math.round(
                                    state.segmentProgress
                                        .coerceIn(0f, 1f) * 100f
                                ).toInt()
                    }

                builder.setProgress(
                    200,
                    fallbackProgress.coerceIn(0, 200),
                    false
                )
            }

            val notification =
                builder.build()

            if (
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                false
            } else {
                NotificationManagerCompat
                    .from(context)
                    .notify(
                        SmartSubwayNotificationSpec.NOTIFICATION_ID,
                        notification
                    )
                true
            }
        }.getOrDefault(false)
    }

    /**
     * 与 Samsung NowBar(6) 共用同一套“线路自动匹配”语义：
     * - 换乘后自动切换到当前实际线路的名称和颜色；
     * - Local / Express 只保留服务编号，并附加模式字母；
     * - 线路徽章本体使用与 NowBar 相同的圆角彩色服务牌。
     *
     * Live Update 本身仍完全使用系统模板；这里仅提供系统模板所需要的 Icon 数据。
     */
    private fun buildSmartSubwayAutoMatchedServiceIcon(
        state: SmartSubwayRealtimeState,
        sizePx: Int = 96
    ): Bitmap {
        val size = sizePx.coerceAtLeast(64)
        val bitmap = Bitmap.createBitmap(
            size,
            size,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        canvas.drawColor(android.graphics.Color.TRANSPARENT)

        val activeColor =
            if (state.isAfterTransfer()) {
                state.secondaryLineColor
            } else {
                state.primaryLineColor
            }

        val activeLineName =
            if (state.isAfterTransfer() && state.transferLineName.isNotBlank()) {
                state.transferLineName
            } else {
                state.lineName
            }.ifBlank { "地铁" }

        val badgeLabel = smartSubwayServiceBadgeLabel(activeLineName)
        val patternLabel = smartSubwayPatternBadge(activeLineName)

        val inset = size * 0.07f
        val rect = android.graphics.RectF(
            inset,
            inset,
            size - inset,
            size - inset
        )

        val fillPaint = android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
            color = activeColor
            style = android.graphics.Paint.Style.FILL
        }
        val outlinePaint = android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
            color = android.graphics.Color.WHITE
            alpha = 95
            style = android.graphics.Paint.Style.STROKE
            strokeWidth = size * 0.025f
        }
        val textPaint = android.graphics.Paint(
            android.graphics.Paint.ANTI_ALIAS_FLAG or
                    android.graphics.Paint.SUBPIXEL_TEXT_FLAG
        ).apply {
            color = smartSubwayIconTextColor(activeColor)
            textAlign = android.graphics.Paint.Align.CENTER
            textSize = when {
                badgeLabel.length == 1 -> size * 0.40f
                badgeLabel.length == 2 -> size * 0.31f
                else -> size * 0.25f
            }
            typeface = Typeface.create(
                "sans-serif",
                Typeface.BOLD
            )
        }

        canvas.drawRoundRect(
            rect,
            size * 0.24f,
            size * 0.24f,
            fillPaint
        )
        canvas.drawRoundRect(
            rect,
            size * 0.24f,
            size * 0.24f,
            outlinePaint
        )

        val center = size / 2f
        val metrics = textPaint.fontMetrics
        val baseline =
            center -
                    (metrics.ascent + metrics.descent) / 2f -
                    size * 0.015f

        canvas.drawText(
            badgeLabel,
            center,
            baseline,
            textPaint
        )

        if (patternLabel.isNotBlank()) {
            val patternPaint = android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG).apply {
                color = textPaint.color
                textAlign = android.graphics.Paint.Align.CENTER
                textSize = size * 0.15f
                typeface = Typeface.create(
                    "sans-serif",
                    Typeface.BOLD
                )
            }
            canvas.drawText(
                patternLabel,
                size * 0.82f,
                size * 0.25f,
                patternPaint
            )
        }

        return bitmap
    }

    /**
     * Live Update 的小图标位于状态栏 / status chip，系统会按小图标规则渲染，
     * 因此这里使用同一条线路自动匹配逻辑，但只绘制透明背景 + 白色字形。
     * 这样线路编号会跟随 NowBar 同步变化，同时避免把彩色圆角卡片误当成状态栏小图标。
     */
    private fun buildSmartSubwayStatusBarIcon(
        context: Context,
        lineName: String
    ): Bitmap {
        val density = context.resources.displayMetrics.density
        val size = (24f * density).roundToInt().coerceAtLeast(24)
        val bitmap = Bitmap.createBitmap(
            size,
            size,
            Bitmap.Config.ALPHA_8
        )
        val canvas = Canvas(bitmap)
        canvas.drawColor(android.graphics.Color.TRANSPARENT)

        val label = smartSubwayServiceBadgeLabel(lineName)
        val paint = android.graphics.Paint(
            android.graphics.Paint.ANTI_ALIAS_FLAG or
                    android.graphics.Paint.SUBPIXEL_TEXT_FLAG
        ).apply {
            color = android.graphics.Color.WHITE
            textAlign = android.graphics.Paint.Align.CENTER
            textSize = when {
                label.length == 1 -> size * 0.76f
                label.length == 2 -> size * 0.62f
                else -> size * 0.48f
            }
            typeface = Typeface.create(
                "sans-serif",
                Typeface.BOLD
            )
        }

        val metrics = paint.fontMetrics
        val baseline =
            size / 2f -
                    (metrics.ascent + metrics.descent) / 2f

        canvas.drawText(
            label,
            size / 2f,
            baseline,
            paint
        )

        return bitmap
    }

    private fun smartSubwayServiceBadgeLabel(
        lineName: String
    ): String {
        var label = lineName.trim()
            .removeSuffix("号线")
            .replace(Regex("(?i)\\bline\\b"), "")
            .trim()

        if (label.isBlank()) {
            label = "M"
        }

        val serviceToken =
            label.split(Regex("\\s+"))
                .firstOrNull()
                .orEmpty()

        if (serviceToken.isNotBlank() &&
            (label.contains("Local", ignoreCase = true) ||
                    label.contains("Express", ignoreCase = true))
        ) {
            label = serviceToken
        }

        return label.take(3)
    }

    private fun smartSubwayPatternBadge(
        lineName: String
    ): String =
        when {
            lineName.contains("Express", ignoreCase = true) -> "E"
            lineName.contains("Local", ignoreCase = true) -> "L"
            else -> ""
        }

    private fun smartSubwayIconTextColor(
        backgroundColor: Int
    ): Int {
        val r = android.graphics.Color.red(backgroundColor) / 255f
        val g = android.graphics.Color.green(backgroundColor) / 255f
        val b = android.graphics.Color.blue(backgroundColor) / 255f
        val luminance =
            0.2126f * r +
                    0.7152f * g +
                    0.0722f * b
        return if (luminance > 0.60f) {
            android.graphics.Color.BLACK
        } else {
            android.graphics.Color.WHITE
        }
    }

    /**
     * Live Update 自己的官方 ProgressStyle。
     * 三个节点严格表示：上一站 -> 当前站 -> 下一站。
     * 当前运行区间通过 segmentProgress 从当前站向下一站推进。
     * 不额外指定 Tracker Icon，让 Android 使用系统原生模板渲染。
     */
    private fun buildSmartSubwayLiveUpdateProgressStyle(
        state: SmartSubwayRealtimeState
    ): NotificationCompat.ProgressStyle {
        val activeLineColor =
            if (state.isAfterTransfer()) state.secondaryLineColor
            else state.primaryLineColor

        val firstSegment =
            NotificationCompat.ProgressStyle.Segment(100)
                .setColor(state.primaryLineColor)
                .setId(1)

        val secondSegment =
            NotificationCompat.ProgressStyle.Segment(100)
                .setColor(activeLineColor)
                .setId(2)

        // 给系统模板两端留出可见边距，避免首 / 尾 Point 贴到渲染边界后看起来像少了一个站点。
        // 三个站点仍然严格对应：上一站(20) -> 当前站(100) -> 下一站(180)。
        val points = listOf(
            NotificationCompat.ProgressStyle.Point(20)
                .setId(1)
                .setColor(android.graphics.Color.rgb(142, 145, 151)),
            NotificationCompat.ProgressStyle.Point(100)
                .setId(2)
                .setColor(state.primaryLineColor),
            NotificationCompat.ProgressStyle.Point(180)
                .setId(3)
                .setColor(activeLineColor)
        )

        val progress =
            if (state.isDestination) {
                180
            } else {
                100 +
                        kotlin.math.round(
                            state.segmentProgress.coerceIn(0f, 1f) * 80f
                        ).toInt()
            }

        return NotificationCompat.ProgressStyle()
            .setStyledByProgress(true)
            .setProgress(progress.coerceIn(0, 200))
            .setProgressSegments(
                listOf(firstSegment, secondSegment)
            )
            .setProgressPoints(points)
    }

    fun cancelSmartSubway(
        context: Context
    ) {
        runCatching {
            NotificationManagerCompat
                .from(context)
                .cancel(SmartSubwayNotificationSpec.NOTIFICATION_ID)
        }
    }
}