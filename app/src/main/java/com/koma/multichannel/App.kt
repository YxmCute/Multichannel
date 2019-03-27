package com.koma.multichannel

import android.app.Application
import cn.jpush.android.api.JPushInterface
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure

/**
 * @author Koma
 * @date 25 21:43
 * @des
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey  多渠道配置
         * 参数3:【友盟+】 Channel 由于已经配置了 这里可传 null 或者 ""
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        /*注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，
        也需要在App代码中调用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
        UMConfigure.init调用中appkey和channel参数请置为null）。*/
        // 初始化SDK  必须在调用任何统计SDK接口之前调用初始化函数
        UMConfigure.init(this, BuildConfig.UMEG_APPKEY, null, UMConfigure.DEVICE_TYPE_PHONE, null)
        // 页面自动采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)
        //初始化时可以通过该方法设置组件化的Log是否输出，默认关闭Log输出。
        UMConfigure.setLogEnabled(BuildConfig.IsDebug)


        JPushInterface.setDebugMode(BuildConfig.IsDebug)
        JPushInterface.init(this)
    }
}