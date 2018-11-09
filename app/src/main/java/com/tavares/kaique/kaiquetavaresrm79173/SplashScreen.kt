package com.tavares.kaique.kaiquetavaresrm79173

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils

class SplashScreen : AppCompatActivity() {

    private val splash_delay = 3500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        carregar()
    }
    fun carregar(){
        val anim = AnimationUtils.loadAnimation(this,R.anim.animacao_splash)
        anim.reset()

        Handler().postDelayed({
            val intent = Intent(this,PesquisaActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this@SplashScreen.finish()

        }, splash_delay)
    }
}
