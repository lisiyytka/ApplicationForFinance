package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_register_code.*


class CodeActivity : AppCompatActivity() {
    var brainFuck = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register_code)
        val MY_SETTINGS = " "
        val sp = getSharedPreferences(
            MY_SETTINGS,
            Context.MODE_PRIVATE
        )
        // проверяем, первый ли раз открывается программа
        // проверяем, первый ли раз открывается программа
        val hasVisited = sp.getBoolean("hasVisited", false)

        if (!hasVisited) { // выводим нужную активность
              startActivity(Intent(this, RegisterActivity::class.java));
            val e = sp.edit()
            e.putBoolean("hasVisited", true)
            e.apply() // не забудьте подтвердить изменения
        }

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
            val str=password.text.toString()
            if(str.isNotEmpty()){
                password.text=str.substring(0,str.length-1)
            }
        }
    }

    fun setTextFields(str: String) {
        brainFuck +=str
        password.append("*")
        checkPass(brainFuck)
    }

    @SuppressLint("ShowToast")
    fun checkPass(a: String) {
        val db = DataBaseHandler(this)
        val data = db.readData()
        var b = a
        val userPass = data[data.size-1].password
        if (password.text.length == 4){
            if (b == userPass){
                val intent = Intent(this, MoneyActivity::class.java)
                startActivity(intent)
            } else {
                password.text = ""
                Toast.makeText(this, "Неверный пароль",Toast.LENGTH_LONG).show()
            }
        }
    }
}
