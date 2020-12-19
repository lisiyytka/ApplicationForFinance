package com.example.mysecondproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_money.*


class MoneyActivity :AppCompatActivity() {
    var map: HashMap<String, String>? = null
    val arrayList: ArrayList<HashMap<String, String>> = ArrayList()
    private val TAG = "MoneyActivity"
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        Log.d(TAG, "onCreate")
        val db = DataBaseHandler(this)
        val data = db.readData()
//        val pie = findViewById<PieChart>(R.id.pieChart)
//        val pieDataSet = PieDataSet(DataDiagramma.create().toMutableList(), "Zalupa")
//        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS.toMutableList())
//        pieDataSet.setValueLineColor(R.color.colorPrimary)
//        pieDataSet.setValueTextSize(14f)
//        val pieData = PieData(pieDataSet)
//        pie.setData(pieData)
//        pie.setCenterText("Kozel")

//        val listView: ListView = findViewById(R.id.listView)
//

//        map = HashMap()
//        map["date"] = "07.06.2020"
//        map["category"] = "Food"
//        map["sum"] = "-220"
//        arrayList.add(map)
//
//        map = HashMap()
//        map["date"] = "08.06.2020"
//        map["category"] = "Food"
//        map["sum"] = "-220"
        for (i in 2..data.size-1){
            arrayList.add(0,createNewField(i))
        }

        val a = findViewById<TextView>(R.id.sum)

        val adapter = SimpleAdapter(
            this,
            arrayList,
            R.layout.fragment_diagram_line,
            arrayOf("date", "category", "sum","coment","image"),
            intArrayOf(R.id.date, R.id.category, R.id.sum, R.id.coment,R.id.image)
        )
        listView.adapter = adapter
        adapter.notifyDataSetChanged()

        val arrayAdapter =
            ArrayAdapter.createFromResource(this, R.array.periods, R.layout.spinner_item_period)
        period.adapter = arrayAdapter

        add_income.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            val text = "Доход"
            intent.putExtra("text", text)
            startActivity(intent)
        }

        add_expenses.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        app_settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
//        income.text = ""
//        income.append(data[data.size-1].income.toString())
        val inc = data[data.size - 1].income.toLong()
        if (data[data.size - 1].income == inc.toDouble())
            income.append(inc.toString())
        else
            income.append(data[data.size - 1].income.toString())
//        loss.text = ""
//        loss.append(data[data.size-1].loss.toString())
        val los = data[data.size - 1].loss.toLong()
        if (data[data.size - 1].loss == los.toDouble())
            loss.append(los.toString())
        else
            loss.append(data[data.size - 1].loss.toString())
//        balance1.text = ""
//        balance1.append(data[data.size-1].balance.toString())
        val bal = data[data.size - 1].balance.toLong()
        if (data[data.size - 1].balance == bal.toDouble()) {
            val a = bal.toString()
            balance1.text = "$a руб."
        }
//            balance1.append(bal.toString())
        else {
            val a = data[data.size - 1].balance.toString()
            balance1.text = "$a руб."
        }
    }

    fun createNewField(i:Int):HashMap<String, String>{
        val db = DataBaseHandler(this)
        val data = db.readData()
        var mDrawableName = "no_category"// файл cat1.png в папке drawable
        val cateGory = data[i].category
        if(cateGory == "Доход")
            mDrawableName = "ic_add_btn"
        if(cateGory == "Продукты")
            mDrawableName = "supermarket"
        if(cateGory == "Кафе")
            mDrawableName = "cafe_food"
        if(cateGory == "Транспорт")
            mDrawableName = "transport"
        if(cateGory == "Здоровье")
            mDrawableName = "health"
        if(cateGory == "Одежда")
            mDrawableName = "clothes"
        if(cateGory == "Досуг")
            mDrawableName = "entertainment"
        if(cateGory == "Дом")
            mDrawableName = "house"
        if(cateGory == "Бензин")
            mDrawableName = "petrol"
        if(cateGory == "Хобби")
            mDrawableName = "hobby"
        if(cateGory == "Машина")
            mDrawableName = "car"
        if(cateGory == "Сигареты")
            mDrawableName = "cigarettes"
        if(cateGory == "Забота о себе")
            mDrawableName = "spa"
        if(cateGory == "Техника")
            mDrawableName = "home_appliances"
        if(cateGory == "Животные")
            mDrawableName = "pets"
        if(cateGory == "Отпуск")
            mDrawableName = "relaxation"
        if(cateGory == "Образование")
            mDrawableName = "education"
        if(cateGory == "Продукты")
            mDrawableName = "supermarket"
        if(cateGory == "Спорт")
            mDrawableName = "sport"
        if(cateGory == "Платежи")
            mDrawableName = "money"
        if(cateGory == "Непредвиденные расходы")
            mDrawableName = "unexpected_spending"
        if(cateGory == "Другое")
            mDrawableName = "no_category"

        val resID = resources.getIdentifier(mDrawableName, "drawable", packageName)

        map = HashMap()
        map!!["date"] = data[i].date
        map!!["category"] = data[i].category
        map!!["coment"]= data[i].comment
        map!!["image"]=resID.toString()
        if (i == 2){
            if (data[i].category == "Доход")
                {map!!["sum"] = "+" + data[i].income.toString()}
            else{map!!["sum"] = "-" + data[i].loss.toString()}
        }
        else {
            if (data[i].category == "Доход")
            {map!!["sum"] = "+" + (data[i].income-data[i-1].income).toString()}
            else{map!!["sum"] = "-" + (data[i].loss-data[i-1].loss).toString()}
        }
        return map!!
    }
}
