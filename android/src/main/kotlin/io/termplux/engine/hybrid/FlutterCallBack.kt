package io.termplux.engine.hybrid

import com.idlefish.flutterboost.FlutterBoost
import io.flutter.embedding.engine.FlutterEngine

internal class FlutterCallBack private constructor() : FlutterBoost.Callback {

    override fun onStart(engine: FlutterEngine?) {
        engine?.let { flutterEngine: FlutterEngine ->
            //GeneratedPluginRegistrant.registerWith(flutterEngine)
        }
    }

    companion object {
        fun build(): FlutterCallBack {
            return FlutterCallBack()
        }
    }
}