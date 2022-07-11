package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        var mode= "man"

        rgGender.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rgBtnMan -> mode = "man"
                R.id.rgBtnWoman -> mode = "woman"
            }
        }

        btnStart.setOnClickListener {
            Log.d("Main","button clicked!")

            if(etHeight.text.isEmpty() || etWeight.text.isEmpty()){
                Toast.makeText(this,"입력되지 않은 사항이 있습니다!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            // 둘다 입력 되어야 함!

            val height : Int = etHeight.text.toString().toInt()
            val weight : Int = etWeight.text.toString().toInt()

            Log.d("Main", "height : $height, weight : $weight")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight",weight)
            intent.putExtra("gender",mode)
            startActivity(intent)
        }




    }
}