package com.example.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayitahminetuygulama.databinding.ActivitySonucBinding
import com.example.sayitahminetuygulama.databinding.ActivityTahminBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sonuc = intent.getBooleanExtra("sonuç",false)
        if(sonuc){
            binding.textViewSonuc.text = "KAZANDINIZ"
            binding.imageViewSonuc.setImageResource(R.drawable.mutlu_resim)
        }else{
            binding.textViewSonuc.text = "KAYBETTİNİZ"
            binding.imageViewSonuc.setImageResource(R.drawable.uzgun_resim)
        }

        binding.buttonTekrar.setOnClickListener {
            finish()
            startActivity(Intent(this@SonucActivity,TahminActivity::class.java))
        }
    }
}