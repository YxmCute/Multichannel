package com.koma.multichannel

/**
 * @author Koma
 * @date 2019/3/9 11:32
 * @des
 */
object BaseUrl {
    fun getBaseUrl(): String {
        if (BuildConfig.IsDebug) {
            return BuildConfig.testUrl
        } else {
            return BuildConfig.onlineUrl
        }
    }
}