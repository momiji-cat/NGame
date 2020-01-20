package com.example.ngame_

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import kotlinx.android.synthetic.main.activity_game__mode.*
import kotlinx.android.synthetic.main.activity_game__select.*

class Game_Select : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game__select)

        //val intent = getIntent()


        Game1.setOnClickListener {
            val intent = Intent(this,game1::class.java)
            startActivity(intent)
        }
        Game2.setOnClickListener {
            val intent = Intent(this,Game2::class.java)
            startActivity(intent)
        }
        Game3.setOnClickListener{
            val intent = Intent(this,Game3::class.java)
            startActivity(intent)
        }
        Game4.setOnClickListener {
            val intent = Intent(this,Game4::class.java)
            startActivity(intent)
        }
        back_bt.setOnClickListener {
            val intent = Intent (this,Game_Mode::class.java)
            startActivity(intent)
        }
    }
}
