package com.example.ngame_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_game__select.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Next_Button.setOnClickListener {
            val intent = Intent(this, Game_Mode::class.java)
            startActivity(intent)
        }
        option_bt.setOnClickListener{
            val intent = Intent(this,App_Settings::class.java)
            startActivity(intent)
        }
        results_bt.setOnClickListener {
            val intent = Intent(this,Results::class.java)
            startActivity(intent)
        }
    }
}
