package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener(){
            callBMI()
        }

        btnReset.setOnClickListener ()
        {
            txtweight.text = null
            txtHeight.text=null
            tvBMI.text=null
            imgV.setImageResource(R.drawable.empty)

            txtweight.requestFocus()
        }
    }


    private fun callBMI() {
        try {
            val weight: Double = txtweight.text.toString().toDouble()
            val height: Double = txtHeight.text.toString().toDouble()

            val BMI: Double = weight / (height * height)


            if (BMI < 18.5) {
                imgV.setImageResource(R.drawable.under)
                tvBMI.text = "BMi %.2f".format(BMI) + " (Underweight)"
            } else if (BMI >= 18.5 && BMI <= 24.9) {
                imgV.setImageResource(R.drawable.normal)
                tvBMI.text = "%.2f".format(BMI) + " (Normal)"
            } else if (BMI >= 25) {
                imgV.setImageResource(R.drawable.over)
                tvBMI.text = "%.2f".format(BMI) + " (Overweight)"
            }
        }
        catch(e:Exception){
            val toast:Toast = Toast.makeText(this,"invalid input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0,0)
            toast.show()
        }
    }
}

