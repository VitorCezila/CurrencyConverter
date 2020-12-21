package com.example.worldcoin

import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1: EditText = findViewById(R.id.txt_amount)
        edit1.inputType = InputType.TYPE_CLASS_NUMBER

        val spFrom: Spinner = findViewById(R.id.spfrom)
        val spTo: Spinner = findViewById(R.id.spto)

        val from = arrayOf("Real", "USD", "Canadian Dollar", "Euro")
        val ad: ArrayAdapter<String> = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, from)
        spFrom.adapter = ad

        val to = arrayOf("USD", "Real", "Canadian Dollar", "Euro")
        val ad1: ArrayAdapter<String> = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, to)
        spTo.adapter = ad1

        val btnConvert: Button = findViewById(R.id.convert_btn)
        btnConvert.setOnClickListener {

            val tot: Double
            val amount: Double = try {java.lang.Double.parseDouble(edit1.text.toString())} catch (e: NumberFormatException) {return@setOnClickListener}

            //USD conversion
            if(spFrom.selectedItem.toString() == "USD" && spTo.selectedItem.toString() == "Real") {
                tot = amount * 5.10
                Toast.makeText(applicationContext, "R$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "USD" && spTo.selectedItem.toString() == "Canadian Dollar") {
                tot = amount * 1.30
                Toast.makeText(applicationContext, "CAD $" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "USD" && spTo.selectedItem.toString() == "Euro") {
                tot = amount * 0.82
                Toast.makeText(applicationContext, "€" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "USD" && spTo.selectedItem.toString() == "USD") {
                tot = amount * 1
                Toast.makeText(applicationContext, "$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            //Real conversion
            else if(spFrom.selectedItem.toString() == "Real" && spTo.selectedItem.toString() == "Real") {
                tot = amount * 1
                Toast.makeText(applicationContext, "R$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Real" && spTo.selectedItem.toString() == "Canadian Dollar") {
                tot = amount / 4
                Toast.makeText(applicationContext, "CAD $" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Real" && spTo.selectedItem.toString() == "Euro") {
                tot = amount / 6.25
                Toast.makeText(applicationContext, "€" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Real" && spTo.selectedItem.toString() == "USD") {
                tot = amount / 5.10
                Toast.makeText(applicationContext, "$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            //Euro conversion
            else if(spFrom.selectedItem.toString() == "Euro" && spTo.selectedItem.toString() == "Real") {
                tot = amount * 6.25
                Toast.makeText(applicationContext, "R$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Euro" && spTo.selectedItem.toString() == "Canadian Dollar") {
                tot = amount * 1.57
                Toast.makeText(applicationContext, "CAD" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Euro" && spTo.selectedItem.toString() == "Euro") {
                tot = amount * 1
                Toast.makeText(applicationContext, "€" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Euro" && spTo.selectedItem.toString() == "USD") {
                tot = amount * 1.23
                Toast.makeText(applicationContext, "$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            //CAD conversion
            else if(spFrom.selectedItem.toString() == "Canadian Dollar" && spTo.selectedItem.toString() == "Real") {
                tot = amount * 4
                Toast.makeText(applicationContext, "R$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Canadian Dollar" && spTo.selectedItem.toString() == "Canadian Dollar") {
                tot = amount * 1
                Toast.makeText(applicationContext, "CAD $" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Canadian Dollar" && spTo.selectedItem.toString() == "Euro") {
                tot = amount * 0.64
                Toast.makeText(applicationContext, "€" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }

            else if(spFrom.selectedItem.toString() == "Canadian Dollar" && spTo.selectedItem.toString() == "USD") {
                tot = amount * 0.78
                Toast.makeText(applicationContext, "$" + String.format("%.2f", tot), Toast.LENGTH_LONG).show()
            }
        }
    }
}
