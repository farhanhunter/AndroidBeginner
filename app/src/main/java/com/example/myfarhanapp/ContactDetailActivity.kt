package com.example.myfarhanapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)
        val name = intent.getStringExtra("name")
        val detail = intent.getStringExtra("detail")
        val photo = intent.getIntExtra("p", 0)
        val phone = intent.getStringExtra("t")

        val tvName: TextView =  findViewById(R.id.idTVName)
        val img: ImageView =  findViewById(R.id.idIVContact)
        val tvDetail: TextView = findViewById(R.id.tv_detail)
        val tvPhone: TextView = findViewById(R.id.idTVPhone)
        println(photo)
        tvName.text = name
        tvDetail.text = detail
        tvPhone.text = phone
        img.setImageResource(photo)
    }
}