package io.termplux.engine

import com.blankj.utilcode.util.AppUtils
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import com.tencent.bugly.crashreport.CrashReport
import io.flutter.app.FlutterApplication
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine

class TermPluxApp : FlutterApplication(), FlutterBoostDelegate, FlutterBoost.Callback {

    override fun onCreate() {
        super.onCreate()
        // 初始化FlutterBoost
        FlutterBoost.instance().setup(
            this@TermPluxApp,
            this@TermPluxApp,
            this@TermPluxApp
        )
        // 初始化Bugly
        CrashReport.initCrashReport(
            this@TermPluxApp,
            buglyAppId,
            AppUtils.isAppDebug()
        )
    }

    override fun onStart(engine: FlutterEngine?) {

    }

    override fun pushNativeRoute(options: FlutterBoostRouteOptions?) {
//        //这里根据options.pageName来判断你想跳转哪个页面，这里简单给一个
//        val intent = Intent(
//            FlutterBoost.instance().currentActivity(),
//            YourTargetAcitvity::class.java
//        )
//        FlutterBoost.instance().currentActivity()
//            .startActivityForResult(intent, options!!.requestCode())
    }

    override fun pushFlutterRoute(options: FlutterBoostRouteOptions?) {
        val intent = FlutterBoostActivity.CachedEngineIntentBuilder(
            FlutterBoostActivity::class.java
        )
            .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
            .destroyEngineWithActivity(false)
            .uniqueId(options?.uniqueId())
            .url(options?.pageName())
            .urlParams(options?.arguments())
            .build(FlutterBoost.instance().currentActivity())
        FlutterBoost.instance().currentActivity().startActivity(intent)
    }

    companion object {
        const val buglyAppId: String = "c10f20dd8d"
    }
}