package disiiy.khaper.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_logout.*

class LogoutActivity : AppCompatActivity() {

    companion object{
        fun getLaunchService(from: Context) = Intent(from, LogoutActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
        setConfigurationUi()
    }

    private fun setConfigurationUi() {
        btn_sign_out.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        startActivity(LoginActivity.getLaunchService(this))
        FirebaseAuth.getInstance().signOut()
    }
}