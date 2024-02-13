package io.termplux.engine

import com.idlefish.flutterboost.containers.FlutterBoostActivity

class MainActivity: FlutterBoostActivity() {
    override fun getUrl(): String {
        return "/"
    }
}