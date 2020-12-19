package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_delete_history.*

class DeleteHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_history)
        val db = DataBaseHandler(this)
        yes.setOnClickListener {
            Toast.makeText(this,"История удалена", Toast.LENGTH_LONG).show()
            db.deleteData()
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        no.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
