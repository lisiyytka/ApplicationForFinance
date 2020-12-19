package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_step_one)

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
            val str=passsuka.text.toString()
            if(str.isNotEmpty()){
                passsuka.text=str.substring(0,str.length-1)
            }
//            val finalPass =
        }
    }

    fun setTextFields(str: String) {
        passsuka.append(str)
        checkPass()
    }

    @SuppressLint("ShowToast")
    fun checkPass() {

        next.setOnClickListener {
            if (passsuka.text.length == 4){
                val finalPassword  = passsuka.text
                var field = Field(
                    " ",
                    0.0,
                    0.0,
                    " ",
                    " ",
                    0.0,
                    finalPassword.toString()
                )
                var db = DataBaseHandler(this)
                db.insertData(field)
                startActivity(Intent(this,ActivityRegister2::class.java))
            }
            else {
                passsuka.text = ""
                Toast.makeText(this, "Неверный пароль",Toast.LENGTH_LONG).show()
            }
        }
    }
}

