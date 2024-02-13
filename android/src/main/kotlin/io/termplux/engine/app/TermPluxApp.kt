package io.termplux.engine.app

import com.blankj.utilcode.util.AppUtils
import com.google.android.material.color.DynamicColors
import com.tencent.bugly.crashreport.CrashReport
import io.termplux.engine.base.TPBaseApplication

class TermPluxApp : TPBaseApplication() {

    override fun onCreate() {
        super.onCreate()
        // 启用动态取色
        DynamicColors.applyToActivitiesIfAvailable(
            this@TermPluxApp
        )
        // 初始化Bugly
        CrashReport.initCrashReport(
            this@TermPluxApp,
            buglyAppId,
            AppUtils.isAppDebug()
        )
    }

    companion object {
        const val buglyAppId: String = "c10f20dd8d"
    }
}