package com.example.mysecondproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Finance"
val COL_CATEGORY = "Category"
val COL_LOSS = "Loss"
val COL_INCOME= "Income"
val COL_DATE = "Date"
val COL_COMMENT= "Comment"
val COL_ID = "id"
val COL_BAL = "Balance"
val COL_PAS = "Password"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CATEGORY + " VARCHAR(256), " +
                COL_LOSS + " REAL, " +
                COL_INCOME + " REAL, " +
                COL_DATE + " DATETIME, " +
                COL_COMMENT + " VARCHAR(256), " +
                COL_BAL + " REAL, " +
                COL_PAS + " VARCHAR(256))";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(field: Field) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_CATEGORY, field.category)
        cv.put(COL_LOSS, field.loss)
        cv.put(COL_INCOME, field.income)
        cv.put(COL_DATE, field.date)
        cv.put(COL_COMMENT, field.comment)
        cv.put(COL_BAL, field.balance)
        cv.put(COL_PAS, field.password)
        var result = db.insert(TABLE_NAME, null, cv)
//        if (result == -1.toLong())
//            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show()
//        else
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun readData(): MutableList<Field> {
        var list: MutableList<Field> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var field = Field()
                field.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                field.balance = result.getString(result.getColumnIndex(COL_BAL)).toDouble()
                field.category = result.getString(result.getColumnIndex(COL_CATEGORY))
                field.comment = result.getString(result.getColumnIndex(COL_COMMENT))
                field.date = result.getString(result.getColumnIndex(COL_DATE))
                field.loss = result.getString(result.getColumnIndex(COL_LOSS)).toDouble()
                field.income = result.getString(result.getColumnIndex(COL_INCOME)).toDouble()
                field.password = result.getString(result.getColumnIndex(COL_PAS))
                list.add(field)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,null,null)
        db.close()
    }
}