package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        back.setOnClickListener {
            val intent = Intent(this, MoneyActivity::class.java)
            startActivity(intent)
        }

        ctgr1.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt1.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr2.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt2.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr3.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt3.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr4.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt4.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr5.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt5.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr6.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt6.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr7.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt7.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr8.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt8.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr9.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt9.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr10.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt10.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr11.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt11.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr12.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt12.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr13.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt13.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr14.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt14.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr15.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt15.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr16.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt16.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr17.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt17.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr18.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt18.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr19.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt19.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
        ctgr20.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = txt20.text.toString()
            intent.putExtra("text", text)
            startActivity(intent)
        }
    }
}

