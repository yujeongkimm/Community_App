package org.techtown.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.mysolelife.auth.IntroActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        if(auth.currentUser?.uid == null){
            //로그인 X
            Log.d("SplashActivity", "null")
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            },3000)

        }else {
            //이미 로그인 O
            Log.d("SplashActivity","not null")
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },3000)
        }


    }
}