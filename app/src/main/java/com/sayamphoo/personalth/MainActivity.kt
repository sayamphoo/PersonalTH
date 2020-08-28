package com.sayamphoo.personalth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sayamphoo.th_personal_id.Personal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val vv = Personal().checkPersonalTH(text.text.toString())
            Log.d("000000sss",vv.toString())
        }

    }
}