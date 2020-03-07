package com.assyfa.latihan.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.assyfa.latihan.R
import com.assyfa.latihan.base.BaseActivity
import com.assyfa.latihan.model.RegisterRequest
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tombol_register.setOnClickListener {
            lakukanPendaftaran()
        }

        tombol_login.setOnClickListener {
            // todo buka halaman login
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    fun lakukanPendaftaran() {
        val data = RegisterRequest(
                etNama.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString()
        )

        apiService.lakukanRegister(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<com.assyfa.latihan.model.RegisterResponse>> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(response: Response<com.assyfa.latihan.model.RegisterResponse>) {
                        if (response.code() == 200) {
                            bukaHalamanHomepage()
                            Toast.makeText(this@RegisterActivity, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
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