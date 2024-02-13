package io.termplux.engine.app

import com.idlefish.flutterboost.containers.FlutterBoostActivity

class TermPluxActivity: FlutterBoostActivity() {
    override fun getUrl(): String {
        return "/"
    }
}