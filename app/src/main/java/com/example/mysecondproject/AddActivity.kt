package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.zxing.Result
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_money.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import java.util.jar.Manifest


class AddActivity : AppCompatActivity() {
    private val Gag = null
    private val TAG = "AddActivity"
    private var mScannerView: ZXingScannerView? = null
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        Log.d(TAG, "onCreate")
        val text = intent.getStringExtra("text")
        val categoryName = findViewById<TextView>(R.id.category_text)
//        categoryName.text = text
        val text228 = intent.getStringExtra("text228")
        if (text228==null)
            categoryName.text = text
        else{categoryName.text = text228}
        //////////////////////////////////////////////////
        val db = DataBaseHandler(this)
        val data = db.readData()
//        sum.append(data[data.size-1].balance.toString())
        val su = data[data.size-1].balance.toLong()
        if (data[data.size-1].balance == su.toDouble())
            sum.append(su.toString())
        else
            sum.append(data[data.size-1].balance.toString())
        ////////////////////////////////////////////////////

        val barcode = intent.getStringExtra("code")
        if(barcode == ""){
            Toast.makeText(this@AddActivity,Constants.BAR_CODE_NOT_FOUND,Toast.LENGTH_LONG).show()
        }else{
            if(parserStr(barcode) !="0")
            incomeOrLoss.text = parserStr(barcode).toDouble().toString()
        }

//        val inc = barcode.toLong()
//        if (barcode.toDouble() == inc.toDouble())
//            incomeOrLoss.append(inc.toString())
//        else
//            incomeOrLoss.append(data[data.size - 1].income.toString())

        qr_code.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java )
            intent.putExtra("text",text)
            startActivity(Intent(this,QrActivity::class.java))
        }
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_multiply.setOnClickListener { setTextFields("*") }
        btn_divide.setOnClickListener { setTextFields("/") }
        btn_minus.setOnClickListener { setTextFields("-") }
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
        btn_dott.setOnClickListener { setTextFields(".") }
        btn_delete.setOnClickListener {
            val str = incomeOrLoss.text.toString()
            if (str.isNotEmpty()) {
                incomeOrLoss.text = str.substring(0, str.length - 1)
            }
        }


        //Основнаые действия калькулятора
        btn_equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(incomeOrLoss.text.toString()).build()//библиотека калькулятора
                val result = ex.evaluate()
                val longres = result.toLong()// Убирание 0 после точки
                if (result == longres.toDouble())
                    incomeOrLoss.text = longres.toString()
                else
                    incomeOrLoss.text = result.toString()

            } catch (e: Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }

        }
        val context = this
        check.setOnClickListener {
            val intent = Intent(this, MoneyActivity::class.java)
            startActivity(intent)

            if (text == "Доход") {
                val sumInt = findViewById<TextView>(R.id.sum)
                val ex = ExpressionBuilder(incomeOrLoss.text.toString()).build()//библиотека калькулятора
                val result = ex.evaluate()
                val longRes = result.toLong()// Убирание 0 после точки
                if (result == longRes.toDouble())
                    incomeOrLoss.text = longRes.toString()
                else
                    incomeOrLoss.text = result.toString()
                val finalRes = sumInt.text.toString().toDouble() + result
                val date = DataDiagramma.Date()
                var income = 0.0
                for (i in 0..data.size-1){
                    if(i==0)
                    {
                        income += data[i].income
                    }else{
                        income+=(data[i].income - data[i-1].income)
                    }
                }
                var finalIncome = result + income

                var loss = 0.0
                for (i in 0..data.size-1){
                    if(i==0)
                    {
                        loss += data[i].loss
                    }else{
                        loss+=(data[i].loss - data[i-1].loss)
                    }
                }
                var finalLoss = loss

                if (incomeOrLoss.text.toString().length > 0) {
                    var field = Field(
                        categoryName.text.toString(),
                        finalLoss,
                        finalIncome,
                        date,
                        massageTextEdit.text.toString(),
                        finalRes,
                        data[data.size-1].password
                    )
                    var db = DataBaseHandler(context)
                    db.insertData(field)
                } else {
                    Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
                }

            } else {
                val sumInt = findViewById<TextView>(R.id.sum)
                val ex = ExpressionBuilder(incomeOrLoss.text.toString()).build()//библиотека калькулятора
                val result = ex.evaluate()
                val longRes = result.toLong()// Убирание 0 после точки
                if (result == longRes.toDouble())
                    incomeOrLoss.text = longRes.toString()
                else
                    incomeOrLoss.text = result.toString()
                val finalRes = sumInt.text.toString().toDouble() - result
                val date = DataDiagramma.Date()

                var loss = 0.0
                for (i in 0..data.size-1){
                    if(i==0)
                    {
                        loss += data[i].loss
                    }else{
                        loss+=(data[i].loss - data[i-1].loss)
                    }
                }
                var finalLoss = result + loss

                var income = 0.0
                for (i in 0..data.size-1){
                    if(i==0)
                    {
                        income += data[i].income
                    }else{
                        income+=(data[i].income - data[i-1].income)
                    }
                }
                var finalIncome = income

                if (incomeOrLoss.text.toString().length > 0) {
                    var field = Field(
                        categoryName.text.toString(),
                        finalLoss,
                        finalIncome,
                        date,
                        massageTextEdit.text.toString(),
                        finalRes,
                        data[data.size-1].password
                    )
                    var db = DataBaseHandler(context)
                    db.insertData(field)
                } else {
                    Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
                }
            }
        }

        back.setOnClickListener {
            if (text == "Доход") {
                val intent = Intent(this, MoneyActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    fun setTextFields(str: String) {
        incomeOrLoss.append(str)
    }

    fun parserStr(str: String?): String {
        if(str == null){
            return "0"
        }
        val a = str.indexOf("s=")
        var b = a.plus(2)
        var result = ""
        var char = str[b]
        val v: Array<Char> = arrayOf('1','2','3','4','5','6','7','8','9','0','.')
        while (char in v){
            result += char
            b = b+1
            char = str[b]
        }
        return result
    }


}


