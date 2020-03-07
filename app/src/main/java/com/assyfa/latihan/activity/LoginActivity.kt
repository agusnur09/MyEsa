package com.assyfa.latihan.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assyfa.latihan.R
import com.assyfa.latihan.base.BaseActivity
import com.assyfa.latihan.model.LoginRequest
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.etEmail
import kotlinx.android.synthetic.main.activity_register.etPassword

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tombol_login.setOnClickListener {
            lakukanLogin()
        }

        tombol_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun lakukanLogin() {
        val data = LoginRequest(
                etEmail.text.toString(),
                etPassword.text.toString()
        )

        BaseActivity.apiService.lakukanLogin(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<com.assyfa.latihan.model.Response>> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(response: Response<com.assyfa.latihan.model.Response>) {
                        if (response.code() == 200) {
                            if (!response.body()!!.error) // jika data login benar
                            {
                                bukaHalamanHomepage()
                            } else
                                Toast.makeText(this@LoginActivity, "user atau password salah", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Register", e.message)
                    }

                    override fun onComplete() {
                        Log.e("Register", "complete")
                    }
                })
    }

    private fun bukaHalamanHomepage() {
        // todo startActivy halaman homepage
        startActivity(Intent(this, HomeActivity::class.java))
    }

}
