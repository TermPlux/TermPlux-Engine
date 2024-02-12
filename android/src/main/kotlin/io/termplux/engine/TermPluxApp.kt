package io.termplux.engine

import com.tencent.bugly.crashreport.CrashReport
import io.flutter.app.FlutterApplication

class TermPluxApp : FlutterApplication() {

    override fun onCreate() {
        super.onCreate()
        CrashReport.initCrashReport(
            applicationContext,
            "c10f20dd8d",
            true
        )
    }
}