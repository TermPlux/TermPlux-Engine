package io.termplux.engine.base

import android.app.Application
import io.termplux.engine.hybrid.HybridFlutter

abstract class TPBaseApplication : Application(), TPBaseApplicationWrapper {

    private lateinit var mHybridFlutter: HybridFlutter

    override fun onCreate() {
        super.onCreate()
        val hybrid = HybridFlutter.build()
        mHybridFlutter = hybrid.withApplication(
            application = this@TPBaseApplication
        ).build()
    }

    override val hybrid: HybridFlutter
        get() = mHybridFlutter
}