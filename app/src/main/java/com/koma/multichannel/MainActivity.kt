package com.koma.multichannel

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.koma.multichannel.jpush.MainActivity
import com.lijun.net.BaseUrl
import kotlinx.android.synthetic.main.activity_main.*

import com.lxj.xpopup.XPopup
import com.bumptech.glide.Glide

import android.widget.ImageView

import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.lxj.xpopup.interfaces.XPopupImageLoader
import com.noober.background.BackgroundLibrary
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_base_url.setOnClickListener {
            XPopup.Builder(this).asConfirm(
                "BaseUrl", BaseUrl.getBaseUrl()
            ) { }
                .show()
        }
        tv_app_name.setOnClickListener {
            XPopup.Builder(this).asConfirm(
                "Appname", resources.getString(R.string.app_name)
            ) { }
                .show()

        }

        img.setImageResource(R.mipmap.ic_launcher)

        img.setOnClickListener {
            XPopup.Builder(this)
                .asImageViewer(img, R.drawable.img, ImageLoader())
                .show()
        }
        tv_push.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    internal inner class ImageLoader : XPopupImageLoader {
        override fun loadImage(position: Int, url: Any, imageView: ImageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(RequestOptions().override(Target.SIZE_ORIGINAL)).into(imageView)
        }

        override fun getImageFile(context: Context, uri: Any): File? {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }


    }
}
