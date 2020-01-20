package com.example.ngame_

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.media.MediaBrowserCompat
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game__mode.*

class Game_Mode : AppCompatActivity() {

    //var sflag = true
    //var cflag = true
    //open class Flag(val sflag:String,val cflag:String)
/*@Override
    protected override fun onResume() {
        super.onResume()
        this.onCreate(null)
    }
 */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game__mode)

        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

        server.setOnClickListener {
            //sflag = true
            //BluetoothAdapter.ACTION_DISCOVERY_STARTED
            //Bluetooth Server通信開始フラグ？？
            textView2.setText("オンライン・サーバーモードで開始します")

            //Bluetooth機能使用確認ダイアログ
            if (bluetoothAdapter == null) {
                AlertDialog.Builder(this)
                    .setTitle("システムエラー")
                    .setMessage("お使いの端末はBluetooth機能が使用できません")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()
                //当ダイアログ閉
            } else {
                Handler().postDelayed(Runnable {
                    val intent = Intent(this, Game_Select::class.java)
                    intent.putExtra("s-start", 1)
                    startActivity(intent)
                }, 500)
            }
        }
        crient.setOnClickListener {
            //cflag = true
            //BluetoothAdapter.ACTION_DISCOVERY_STARTED
            //BluetoothSocket.TYPE_RFCOMM
            //Blurtooth Crient通信開始フラグ？？
            textView2.setText("オンライン・クライアントモードで開始します")

            //Bluetooth機能使用確認ダイアログ
            if (bluetoothAdapter == null) {
                AlertDialog.Builder(this)
                    .setTitle("システムエラー")
                    .setMessage("お使いの端末はBluetooth機能が使用できません")
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()
                //当ダイアログ閉
            } else {
                Handler().postDelayed(Runnable {
                    val intent = Intent(this, Select_Server::class.java)
                    intent.putExtra("c-start", 1)
                    startActivity(intent)
                }, 500)
            }
        }
        Off_bt.setOnClickListener {
            textView2.setText(getString(R.string.bluetooth))
            Handler().postDelayed(Runnable {
                val intent = Intent(this, Game_Select::class.java)
               // intent.putExtra("off-line", 1)
                startActivity(intent)
            }, 500)
        }
    }
/*
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            recreate()
        }
        return super.onKeyDown(keyCode, event)
    }

 */
}
