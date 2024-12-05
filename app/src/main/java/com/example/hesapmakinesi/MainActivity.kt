package com.example.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var sonuc: TextView
    private var ilkSayi = 0.0
    private var ikinciSayi = 0.0
    private var islem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sonuc = findViewById(R.id.sonuc)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Sayı seçildiğinde tetiklenen metot
    fun sayisec(view: View) {
        val buton = view as Button
        val mevcutDeger = sonuc.text.toString()

        if (mevcutDeger == "0") {
            sonuc.text = buton.text
        } else {
            sonuc.text = mevcutDeger + buton.text
        }
    }

    // İşlem seçildiğinde tetiklenen metot
    fun islem(view: View) {
        val buton = view as Button
        ilkSayi = sonuc.text.toString().toDouble()
        islem = buton.text.toString()
        sonuc.text = "0"
    }

    // "=" tuşuna basıldığında işlemi gerçekleştirir
    fun esittir(view: View) {
        ikinciSayi = sonuc.text.toString().toDouble()

        when (islem) {
            "+" -> sonuc.text = (ilkSayi + ikinciSayi).toString()
            "-" -> sonuc.text = (ilkSayi - ikinciSayi).toString()
            "*" -> sonuc.text = (ilkSayi * ikinciSayi).toString()
            "/" -> sonuc.text = (ilkSayi / ikinciSayi).toString()
        }
    }

    // "AC" tuşuna basıldığında her şeyi sıfırlar
    fun ac(view: View) {
        ilkSayi = 0.0
        ikinciSayi = 0.0
        islem = ""
        sonuc.text = "0"
    }
}