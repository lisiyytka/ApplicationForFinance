package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.btn_0
import kotlinx.android.synthetic.main.activity_add.btn_1
import kotlinx.android.synthetic.main.activity_add.btn_2
import kotlinx.android.synthetic.main.activity_add.btn_3
import kotlinx.android.synthetic.main.activity_add.btn_4
import kotlinx.android.synthetic.main.activity_add.btn_5
import kotlinx.android.synthetic.main.activity_add.btn_6
import kotlinx.android.synthetic.main.activity_add.btn_7
import kotlinx.android.synthetic.main.activity_add.btn_8
import kotlinx.android.synthetic.main.activity_add.btn_9
import kotlinx.android.synthetic.main.activity_add.btn_delete
import kotlinx.android.synthetic.main.fragment_register_code.*
import kotlinx.android.synthetic.main.fragment_register_code.password
import kotlinx.android.synthetic.main.register_step_one.*
import kotlinx.android.synthetic.main.register_step_two.*

class ActivityRegister2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_step_two)

        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        btn_delete.setOnClickListener {
            val str=balance11.text.toString()
            if(str.isNotEmpty()){
                balance11.text=str.substring(0,str.length-1)
            }
        }
        nextcig.setOnClickListener {
            val db = DataBaseHandler(this)
            val data = db.readData()
            val balanciaga  = balance11.text
            var field = Field(
                " ",
                0.0,
                0.0,
                " ",
                " ",
                balanciaga.toString().toDouble(),
                data[data.size-1].password
            )
            db.insertData(field)
            startActivity(Intent(this, MoneyActivity::class.java))
        }
    }

    fun setTextFields(str: String) {
        balance11.append(str)
    }
}

