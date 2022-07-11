package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.pow


class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvBmiNum = findViewById<TextView>(R.id.tvBmiNum)
        val tvBmiState = findViewById<TextView>(R.id.tvBmiState)
        val tvUserWeight = findViewById<TextView>(R.id.tvUserWeight)
        val tvUserHeight = findViewById<TextView>(R.id.tvUserHeight)
        val tvUserGender = findViewById<TextView>(R.id.tvUserGender)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        val gender = intent.getStringExtra("gender")
        val bmiNum = weight / (height/100.0).pow(2.0)

        val bmiState = when{
            bmiNum>=40.0 -> "3단계 비만"
            bmiNum>=35.0 -> "2단계 비만"
            bmiNum>=30.0 -> "1단계 비만"
            bmiNum>=25.0 -> "과체중"
            bmiNum>=18.5 -> "정상"
            bmiNum>=17.0 -> "저체중"
            bmiNum>=16.0 -> "심한 저체중"
            else -> "매우 심각한 저체중"

        }

        val returnBmi = DecimalFormat("##00.0")

        tvBmiNum.text = returnBmi.format(bmiNum)
        tvBmiState.text = bmiState
        tvUserGender.text = gender
        tvUserWeight.text = weight.toString() + "kg"
        tvUserHeight.text = height.toString() + "cm"

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}