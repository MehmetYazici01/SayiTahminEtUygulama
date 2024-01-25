package com.example.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sayitahminetuygulama.databinding.ActivityMainBinding
import com.example.sayitahminetuygulama.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private var rastgeleSayi = 0
    private var sayac = 5
    private lateinit var binding: ActivityTahminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rastgeleSayi = Random.nextInt(101)
        Log.e("Rastgele Sayı",rastgeleSayi.toString())

        binding.buttonTahmin.setOnClickListener {
            sayac = sayac - 1
            val tahmin = binding.editTextGirdi.text.toString().toInt()
            if(tahmin == rastgeleSayi){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuç",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(tahmin > rastgeleSayi){
                binding.textViewYardim.text = "AZALT"
                binding.textViewKalanHak.text = "Kalan Hak: $sayac"
            }
            if(tahmin < rastgeleSayi){
                binding.textViewYardim.text = "ARTTIR"
                binding.textViewKalanHak.text = "Kalan Hak: $sayac"
            }
            if(sayac == 0){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuç",false)
                finish()
                startActivity(intent)
            }
            binding.editTextGirdi.setText("")
        }
    }
}