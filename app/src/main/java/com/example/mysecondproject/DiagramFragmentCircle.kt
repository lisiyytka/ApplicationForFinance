package com.example.mysecondproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_diagram_circle.*

class DiagramFragmentCircle : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val pie = view?.findViewById<PieChart>(R.id.pieChart)
//        val pieDataSet = PieDataSet(DataDiagramma.create().toMutableList(), "Zalupa")
//        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS.toMutableList())
//        pieDataSet.setValueLineColor(R.color.colorPrimary)
//        pieDataSet.setValueTextSize(14f)
//        val pieData = PieData(pieDataSet)
//        pie?.setData(pieData)
//        pie?.setCenterText("Kozel")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diagram_circle, container, false)
    }

}