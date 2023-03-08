package com.ejada.vhs.core.util.log

import android.util.Log
import com.ejada.vhs.BuildConfig


fun showLog(tag: String, msg: String) {
    if (BuildConfig.DEBUG) {
        Log.e(tag, msg)
    }
}
