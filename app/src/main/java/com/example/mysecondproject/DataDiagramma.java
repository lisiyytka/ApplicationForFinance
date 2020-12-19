package com.example.mysecondproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import java.util.ArrayList;

public class DataDiagramma {

    public static ArrayList<PieEntry> create() {
        ArrayList<PieEntry> a = new ArrayList<PieEntry>();
        a.add(new PieEntry(20, "Pidaraz"));
        a.add(new PieEntry(10));
        return a;
    }

    public static String Date() {
        Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
// Форматирование времени как "часы:минуты:секунды"
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        String resultTime = dateText + " " + timeText;
        return resultTime;
    }

//    public void Change(View view) {
//        Fragment fragment = null;
//
//        switch (view.getId()) {
//            case R.id.diagram_circle:
//                fragment = new DiagramFragmentCircle();
//                break;
//            case R.id.diagram_line:
//                fragment = new DiagramFragmentLine();
//                break;
//        }
//
//        FragmentManager fm =
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragment_place, fragment);
//        ft.commit();
//    }

//    public static CreateLayout() {
//        // создание LinearLayout
//adasdasdasd
//    }
}
