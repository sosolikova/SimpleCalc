package cz.utb.fai.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

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
    }
}