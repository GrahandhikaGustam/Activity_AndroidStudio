package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtwidth  : EditText
    private lateinit var edtheight : EditText
    private lateinit var edtlength : EditText
    private lateinit var btncalculate : Button
    private lateinit var tvresult : TextView
    
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtwidth = findViewById(R.id.edt_width)
        edtheight = findViewById(R.id.edt_height)
        edtlength = findViewById(R.id.edt_length)
        btncalculate = findViewById(R.id.btn_calculate)
        tvresult = findViewById(R.id.tv_result)

        btncalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result:String = savedInstanceState.getString(STATE_RESULT) as String
            tvresult.text = result
        }
    }

    override fun onClick( v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_calculate) {
                val inputLength = edtlength.text.toString().trim()
                val inputWidth = edtwidth.text.toString().trim()
                val inputHeight = edtheight.text.toString().trim()

                var isEmptyFields = false

                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    edtlength.error = "Field tidak boleh kosong"
                }

                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    edtwidth.error = "Field tidak boleh kosong"
                }

                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    edtheight.error = "Field tidak boleh kosong"
                }

                if (!isEmptyFields) {
                    val volume =
                        inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    tvresult.text = volume.toString()


                }
            }
        }
        
        }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putString(STATE_RESULT, tvresult.text.toString())

        }
    }

