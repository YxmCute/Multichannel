package com.lijun.net

/**
 * @author Koma
 * @date 2019/3/9 11:32
 * @des 许多mvp下的retrofit框架大多数用module集成，相应的baseurl也在里面，但我们调用一般是在app下
 */
object BaseUrl {
    fun getBaseUrl(): String {
        if (BuildConfig.NetIsDebug) {
            return BuildConfig.AppTestUrl
        } else {
            return BuildConfig.AppUrl
        }
    }
}