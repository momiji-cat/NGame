package com.example.ngame_

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game1.*
import java.util.Random
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import java.lang.Math.random


class game1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1)

        var ImageChange = findViewById<ImageView>(R.id.myHand)
        var MyHand = 1

        ImageChange.setOnClickListener {
            if (MyHand == 1) {
                myHand.setImageResource(R.drawable.jibun_peas)
                MyHand = 2
            } else if (MyHand == 2) {
                myHand.setImageResource(R.drawable.jibun_pa)
                MyHand = 3
            } else if (MyHand == 3) {
                myHand.setImageResource(R.drawable.jibun_gu)
                MyHand = 1
            }
        }
        val Gbt = findViewById<Button>(R.id.Gbt)
        var winc = 0;
        var lowc = 0;

        Gbt.setOnClickListener {
            val random = Random()
            val EnemyHand = random.nextInt(3)
            if (EnemyHand == 1) {
                enemyHand.setImageResource(R.drawable.teki_gu)
            } else if (EnemyHand == 2) {
                enemyHand.setImageResource(R.drawable.teki_peas)
            } else if (EnemyHand == 3) {
                enemyHand.setImageResource(R.drawable.teki_pa)
            }
            if (MyHand == 1) {
                if (EnemyHand == 2) {
                    judge.setText("あなたの勝ちです")
                    winc++
                } else if (EnemyHand == 3) {
                    judge.setText("あなたの負けです")
                    lowc++
                } else {
                    judge.setText("あいこです")
                }
            } else if (MyHand == 2) {
                if (EnemyHand == 3) {
                    judge.setText("あなたの勝ちです")
                    winc++
                } else if (EnemyHand == 1) {
                    judge.setText("あなたの負けです")
                    lowc++
                } else {
                    judge.setText("あいこです")
                }
            } else if (MyHand == 3) {
                if (EnemyHand == 1) {
                    judge.setText("あなたの勝ちです")
                    winc++
                } else if (EnemyHand == 2) {
                    judge.setText("あなたの負けです")
                    lowc++
                } else {
                    judge.setText("あいこです")
                }
            }
            my_Count.setText("勝ち数 : " + winc)
            enemy_Count.setText("勝ち数 : " + lowc)
            if (winc == 3) {
                Gbt.setText("--NEXT--")
                judge.setText("あなたの勝利です！")
                Handler().postDelayed(Runnable {
                    var intent = Intent(this, Game_Select::class.java)
                    startActivity(intent)
                }, 1150)
            } else if (lowc == 3) {
                Gbt.setText("--NEXT--")
                judge.setText("あなたの負けです！")
                Handler().postDelayed(Runnable {
                    var intent = Intent(this, Game_Select::class.java)
                    startActivity(intent)
                }, 1150)

            }
        }
    }
}
