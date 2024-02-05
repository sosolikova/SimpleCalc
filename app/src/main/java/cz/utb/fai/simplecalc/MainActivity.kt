package cz.utb.fai.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var spinnerOperation: Spinner
    private lateinit var labelResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        spinnerOperation = findViewById(R.id.spinnerOperation)
        labelResult = findViewById(R.id.labelResult)

        val operatorsArray = resources.getStringArray(R.array.operators)
        val list = operatorsArray.toList()
        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperation.adapter = dataAdapter
    }

    fun calculate(view: View) {
        val number1: Double
        val number2: Double
        var result = 0.0

        try {
            number1 = etNumber1.text.toString().toDouble()
            number2 = etNumber2.text.toString().toDouble()

            if (spinnerOperation.selectedItem.equals("+")) {
                result = number1 + number2
            } else if (spinnerOperation.selectedItem.equals("-")) {
                result = number1 - number2
            } else if (spinnerOperation.selectedItem.equals("*")) {
                result = number1 * number2
            } else if (spinnerOperation.selectedItem.equals("/")) {
                if (number2 == 0.toDouble()) {
                    labelResult.text = "NULOU NELZE DĚLIT"
                    return;
                }
                result = number1 / number2;
            }
            val nf = DecimalFormat("#.##")
            labelResult.text = nf.format(result)
        } catch (e: java.lang.NumberFormatException) {
            labelResult.text = "Chybné zadání"
        }
    }
}