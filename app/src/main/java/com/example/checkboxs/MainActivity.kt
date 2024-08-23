package com.example.checkboxs

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var Lechuga : CheckBox
    private lateinit var Tomate : CheckBox
    private lateinit var Zanahoria : CheckBox
    private lateinit var Pepino : CheckBox
    private lateinit var Aderezo : CheckBox
    private lateinit var Calcular : Button
    private lateinit var Limpiar : Button
    private lateinit var Resultado : TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Lechuga= findViewById(R.id.cbLechuga)
        Tomate= findViewById(R.id.cbTomate)
        Zanahoria= findViewById(R.id.cbZanahoria)
        Pepino= findViewById(R.id.cbPepino)
        Aderezo= findViewById(R.id.cbAderezo)
        Calcular= findViewById(R.id.btnCalcular)
        Limpiar= findViewById(R.id.btnLimpiar)
        Resultado= findViewById(R.id.tvResult)

        Calcular.setOnClickListener {
            var TCalorias= 0

            //sumamos calorias de los checkbox seleccionado
            if(Lechuga.isChecked) TCalorias+=5
            if(Tomate.isChecked) TCalorias+=20
            if(Zanahoria.isChecked) TCalorias+=25
            if(Pepino.isChecked) TCalorias+=10
            if(Aderezo.isChecked) TCalorias+=50

            Resultado.text="Calorias Totales: $TCalorias"
        }
        Limpiar.setOnClickListener {
            Lechuga.isChecked = false
            Tomate.isChecked = false
            Zanahoria.isChecked = false
            Pepino.isChecked = false
            Aderezo.isChecked = false

            Resultado.text="Calorias Totales: 0"
        }
    }
}