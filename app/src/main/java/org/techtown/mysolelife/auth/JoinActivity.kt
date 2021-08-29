package org.techtown.mysolelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.mysolelife.MainActivity
import org.techtown.mysolelife.R
import org.techtown.mysolelife.databinding.ActivityIntroBinding
import org.techtown.mysolelife.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        binding.joinBtn.setOnClickListener {

            val email = binding.emailArea.text.toString()
            val password1 = binding.password.text.toString()
            val password2 = binding.passwordCheck.text.toString()

            var isGoToJoin = true

            //체크하기
            if(email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password1.isEmpty()) {
                Toast.makeText(this, "Password1을 입력하세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password2.isEmpty()) {
                Toast.makeText(this, "Password2을 입력하세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(!password1.equals(password2)) {
                Toast.makeText(this, "비밀번호를 똑같이 입력하세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password1.length < 6) {
                Toast.makeText(this, "비밀번호를 6자리 이상으로 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if (isGoToJoin) {
                auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()

                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)

                        } else {

                            Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()

                        }
                    }
            }



        }



    }
}