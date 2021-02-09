package disiiy.khaper.recipeapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_password
import kotlinx.android.synthetic.main.activity_login.et_email
import kotlinx.android.synthetic.main.activity_login2.*

class Login2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        supportActionBar?.hide()

        btn_sign_up.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            val username = et_username.text.toString()

            if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
                Toast.makeText(this, "Insert Username, Email, and Password", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        return@addOnCompleteListener
                    } else {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                }.addOnFailureListener {
                    Log.d("Main", "LoginFailed : ${it.message}")
                    Toast.makeText(this, "Username/Email/Password incorrect", Toast.LENGTH_SHORT).show()
                    val progressCheck =
                        ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
                    progressCheck.hide()
                }
        }

        iv_get_started.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        tv_sign_in.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}