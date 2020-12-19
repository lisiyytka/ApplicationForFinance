package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_change_code.*
import kotlinx.android.synthetic.main.register_step_two.*

class ChangeCodeActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_change_code)
        cancel.setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) }
        save.setOnClickListener {
            val changePass = password.text

            if (password.text.length == 4){
                val db = DataBaseHandler(this)
                val data = db.readData()
                var field = Field(
                    data[data.size-1].category,
                    data[data.size-1].loss,
                    data[data.size-1].income,
                    data[data.size-1].date,
                    data[data.size-1].comment,
                    data[data.size-1].balance,
                    changePass.toString()
                )
                startActivity(Intent(this, SettingsActivity::class.java))
                db.insertData(field)
            } else {
                Toast.makeText(this, "Пароль должен содержать 4 цифры",Toast.LENGTH_LONG).show()
            }
        }
    }
}