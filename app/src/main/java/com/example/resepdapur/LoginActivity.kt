package com.example.resepdapur

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.resepdapur.`interface`.LoginRequest
import com.example.resepdapur.`interface`.LoginResponse
import com.example.resepdapur.`interface`.RegisRequest
import com.example.resepdapur.`interface`.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvLogin : TextView
    private lateinit var tvSignup : TextView
    private lateinit var vwLogin : View
    private lateinit var vwSignup : View
    private lateinit var clLogin : ConstraintLayout
    private lateinit var clSignUp : ConstraintLayout
    private lateinit var edtEmail : EditText
    private lateinit var edtPwd : EditText
    private lateinit var edtEmailSignUp : EditText
    private lateinit var edtPwdSignUp : EditText
    private lateinit var edtFullNameSignUp : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignup : Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        tvLogin.setOnClickListener(this)
        tvSignup.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        btnSignup.setOnClickListener(this)
    }

    private fun init(){
        edtEmail = findViewById(R.id.edtEmail)
        edtPwd = findViewById(R.id.edtPwd)
        vwLogin = findViewById(R.id.vwLogin)
        vwSignup = findViewById(R.id.vwSignup)
        tvLogin = findViewById(R.id.tvLogin)
        tvSignup = findViewById(R.id.tvSignup)
        clLogin = findViewById(R.id.clLogin)
        clSignUp = findViewById(R.id.clSignup)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignup = findViewById(R.id.btnSignUp)
        edtFullNameSignUp = findViewById(R.id.edtFullName)
        edtEmailSignUp = findViewById(R.id.edtEmailSignup)
        edtPwdSignUp = findViewById(R.id.edtPwdSignUp)
        sharedPreferences = getSharedPreferences("id", MODE_PRIVATE)

    }

    override fun onClick(p0: View?) {
        var editor = sharedPreferences.edit()
        when(p0?.id){
            R.id.tvLogin ->showView(vwLogin, vwSignup, 1)
            R.id.tvSignup ->showView(vwLogin, vwSignup, 2)
            R.id.btnLogin -> login(edtEmail.text.toString(), edtPwd.text.toString(), editor)
            R.id.btnSignUp -> regis(edtFullNameSignUp.text.toString(), edtEmailSignUp.text.toString(), edtPwdSignUp.text.toString(), editor)
        }
    }

    private fun showView(vwLogin: View, vwSignup: View, i: Int) {
        if (i == 1){
            clSignUp.visibility = View.GONE
            val closed = TranslateAnimation(0F, 0F, 0F, clSignUp.height.toFloat())
            closed.duration = 0
            clSignUp.startAnimation(closed)

            val animate = TranslateAnimation(0F, 0F, clLogin.height.toFloat(), 0F)
            animate.duration = 600
            clLogin.startAnimation(animate)
            vwLogin.visibility = View.VISIBLE
            vwSignup.visibility = View.INVISIBLE
            clLogin.visibility = View.VISIBLE



        }
        else if (i == 2){
            val closed = TranslateAnimation(0F, 0F, 0F, clLogin.height.toFloat())
            closed.duration = 0
            clLogin.startAnimation(closed)

            val animate = TranslateAnimation(0F, 0F, clSignUp.height.toFloat(), 0F)
            animate.duration = 600
            clSignUp.startAnimation(animate)
            vwSignup.visibility = View.VISIBLE
            vwLogin.visibility = View.GONE
            clLogin.visibility = View.GONE
            clSignUp.visibility = View.VISIBLE


        }
    }

    private fun regis(name: String,email: String, password: String, editor: Editor){
        validateFormRegis(name.trim(), email.trim(), password.trim())
        val regisRequest = RegisRequest(name, email, password)
        RetrofitClient.instance.regis(regisRequest).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    commitEditor(response.body()!!.access_token, editor)
                    Toast.makeText(this@LoginActivity, "Login berhasil", Toast.LENGTH_LONG).show()
                    intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun login(email: String, password: String, editor: Editor){
        validateFormLogin(email, password)
        val request = LoginRequest(email.trim(), password.trim())
        RetrofitClient.instance.login(request).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
               if (response.isSuccessful){
                   Toast.makeText(this@LoginActivity, "Login berhasil", Toast.LENGTH_LONG).show()
                   commitEditor(response.body()!!.access_token, editor)
                  intent = Intent(this@LoginActivity, MainActivity::class.java)
                   startActivity(intent)

               }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun commitEditor(accessToken: String, editor: Editor) {
        editor.putString("token", accessToken)
        editor.commit()
    }

    private fun validateFormLogin(email: String, password: String) : Boolean{
        val result: Boolean = if (email.isEmpty() && password.isEmpty()){
            Toast.makeText(this@LoginActivity, "Silahkan lengkapi form terlebih dahulu", Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }
        return result
    }

    private fun validateFormRegis(name: String,email: String, password: String) : Boolean{
        val result: Boolean = if (email.isEmpty() && password.isEmpty() && name.isEmpty()){
            Toast.makeText(this@LoginActivity, "Silahkan lengkapi form terlebih dahulu", Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }
        return result
    }


}