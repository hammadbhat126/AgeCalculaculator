package com.kashsoft.agecalculaculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import java.util.Calendar.DAY_OF_YEAR

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button =findViewById<Button>(R.id.button1)
        button.setOnClickListener {view ->

           printAge(view)
        }


    }

    fun printAge(view: View){

        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

      DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
              view,year,month,day ->
          Toast.makeText(this,"Selected date is $year $month $day",
          Toast.LENGTH_LONG).show()

          val selectedDate = "$year/${month+1}/$year"

             var textView1 = findViewById<TextView>(R.id.textView1)
          textView1.text=selectedDate



          var dob = Calendar.getInstance()
          dob.set(year,month,day)

          var age = myCalender.get(Calendar.YEAR) -dob.get(Calendar.YEAR)
          if (myCalender.get(Calendar.DAY_OF_YEAR) <dob.get(Calendar.DAY_OF_YEAR))
          {
              age--
          }
          var textview2 = findViewById<TextView>(R.id.textview2)
          textview2.text = "Your are $age year old."
                                                              }
            ,year
            ,month
            ,day).show()

    }
}