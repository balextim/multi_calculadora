package com.example.calculadora_horizontal

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Long.parseLong


class MainActivity : AppCompatActivity() {
    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private var operacion: Int = 0
    private var datos3: Long = 0
    private var operacionHex=""
    private var datosHex=""
    private var datosHex2=""
    private var num1 = 0.0
    private var num2 = 0.0
    private var bin1: Long=0
    private var bin2: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orientacion = resources.configuration.orientation
        supportActionBar?.hide()
        if (orientacion == Configuration.ORIENTATION_LANDSCAPE){
            calcularDecimales()
        }
        else{
            calcularDecimales()
        }
    }

    fun calcularHexadecimal(){
        buttonN2.isEnabled = true
        buttonN3.isEnabled = true
        buttonN4.isEnabled = true
        buttonN5.isEnabled = true
        buttonN6.isEnabled = true
        buttonN7.isEnabled = true
        buttonN8.isEnabled = true
        buttonN9.isEnabled = true
        buttonA.isEnabled = true
        buttonB.isEnabled = true
        buttonCHex.isEnabled = true
        buttonD.isEnabled = true
        buttonE.isEnabled = true
        buttonF.isEnabled = true

        buttonClear.setOnClickListener{
            datosHex=""
            datosHex2=""
            operacion= NO_OPERACION
            textViewResultado.setText("")
            
        }
        buttonbinario.setOnClickListener{
            calcularbinario()
        }

        buttonDecimal.setOnClickListener{
            calcularDecimales()
            desactvarBotnoesHexadecimales()

        }
        buttonN1.setOnClickListener{
            datosHex+="1"
            textViewResultado.setText(datosHex)
        }
        buttonN2.setOnClickListener{
            datosHex+="2"
            textViewResultado.setText(datosHex)
        }
        buttonN3.setOnClickListener{
            datosHex+="3"
            textViewResultado.setText(datosHex)
        }
        buttonN4.setOnClickListener{
            datosHex+="4"
            textViewResultado.setText(datosHex)
        }
        buttonN5.setOnClickListener{
            datosHex+="5"
            textViewResultado.setText(datosHex)
        }
        buttonN6.setOnClickListener{
            datosHex+="6"
            textViewResultado.setText(datosHex) }
        buttonN7.setOnClickListener{
            datosHex+="7"
            textViewResultado.setText(datosHex)
        }
        buttonN8.setOnClickListener{
            datosHex+="8"
            textViewResultado.setText(datosHex)
        }
        buttonN9.setOnClickListener{
            datosHex+="9"
            textViewResultado.setText(datosHex)
        }
        buttonNcero.setOnClickListener{
            datosHex+="0"
            textViewResultado.setText(datosHex)
        }
        buttonA.setOnClickListener{
            datosHex+="A"
            textViewResultado.setText(datosHex)
        }
        buttonB.setOnClickListener{
            datosHex+="B"
            textViewResultado.setText(datosHex)
        }
        buttonCHex.setOnClickListener{
            datosHex+="C"
            textViewResultado.setText(datosHex)
        }
        buttonD.setOnClickListener{
            datosHex+="D"
            textViewResultado.setText(datosHex)
        }
        buttonE.setOnClickListener{
            datosHex+="E"
            textViewResultado.setText(datosHex)
        }
        buttonF.setOnClickListener{
            datosHex+="F"
            textViewResultado.setText(datosHex) }
        buttonPunto.setOnClickListener{}
        buttonSumar.setOnClickListener{
            operacionHex="+"
            datosHex2=datosHex
            datosHex=""
            textViewResultado.setText(datosHex2+ "+")
        }
        buttonRestar.setOnClickListener{
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
            textViewResultado.setText(datosHex2+ "-")
        }
        buttonMultiplicar.setOnClickListener{
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
            textViewResultado.setText(datosHex2+ "x")
        }
        buttonDividir.setOnClickListener{
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
            textViewResultado.setText(datosHex2+ "/")
        }
        buttonIgual.setOnClickListener{
            if(datosHex2=="") datosHex2="0"
            try {
                execHex(convertiraHex(datosHex2),convertiraHex(datosHex))
            }catch (e: ArithmeticException){
                textViewResultado.setText("No se puede dividir por 0")
            }
        }
    }

    fun calcularDecimales(){
        buttonN2.isEnabled = true
        buttonN3.isEnabled = true
        buttonN4.isEnabled = true
        buttonN5.isEnabled = true
        buttonN6.isEnabled = true
        buttonN7.isEnabled = true
        buttonN8.isEnabled = true
        buttonN9.isEnabled = true
        buttonClear.setOnClickListener(View.OnClickListener {
            numero1 = 0.0
            numero2 = 0.0
            operacion = NO_OPERACION

            textViewResultado.setText("")})
        buttonbinario.setOnClickListener{
            calcularbinario()
        }
        buttonN1.setOnClickListener{numeroPresionado("1") }
        buttonN2.setOnClickListener{numeroPresionado("2")}
        buttonN3.setOnClickListener{numeroPresionado("3")}
        buttonN4.setOnClickListener{numeroPresionado("4")}
        buttonN5.setOnClickListener{numeroPresionado("5")}
        buttonN6.setOnClickListener{numeroPresionado("6")}
        buttonN7.setOnClickListener{numeroPresionado("7")}
        buttonN8.setOnClickListener{numeroPresionado("8")}
        buttonN9.setOnClickListener{numeroPresionado("9")}
        buttonNcero.setOnClickListener{numeroPresionado("0")}
        buttonPunto.setOnClickListener{numeroPresionado(".")}
        buttonSumar.setOnClickListener{operacionpresionada(SUMA)}
        buttonRestar.setOnClickListener{operacionpresionada(RESTA)}
        buttonMultiplicar.setOnClickListener{operacionpresionada(MULTIPLICACION)}
        buttonDividir.setOnClickListener{operacionpresionada(DIVISION)}
        buttonHex.setOnClickListener{
            calcularHexadecimal()

        }
        buttonIgual.setOnClickListener{
            var resultado = when (operacion){
                SUMA -> numero1 + numero2
                RESTA -> numero1 - numero2
                MULTIPLICACION -> numero1 * numero2
                DIVISION -> numero1 / numero2
                else -> 0
            }
            textViewResultado.text = resultado.toString()
            numero1 = textViewResultado.text.toString().toDouble()
        }

    }
    private fun numeroPresionado(numero: String) {
        textViewResultado.text = "${textViewResultado.text}$numero"
        if (operacion == NO_OPERACION){
            numero1 = textViewResultado.text.toString().toDouble()
        }
        else{
            numero2 = textViewResultado.text.toString().toDouble()
        }
    }
    private fun convertiraHex(numerohex :String ): Long{
        return parseLong(numerohex,16)
    }
    fun execHex(hex1: Long,hex2: Long){
        when(operacionHex){
            "+" -> datos3=(hex1+hex2)
            "-" -> datos3=(hex1-hex2)
            "x" -> datos3=(hex1*hex2)
            "/" -> datos3=(hex1/hex2)
        }
        var hexString=java.lang.Long.toHexString(datos3)
        textViewResultado.setText(hexString.toUpperCase())
    }

    private fun operacionpresionada(operacion: Int ){
        this.operacion = operacion

        textViewResultado.text=""
    }
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 5
        const val Suma = 1
        const val Resta = 2
        const val Multiplicacion = 3
        const val Division = 4
        const val No_Operacion = 0
    }

    private fun desactvarBotnoesHexadecimales(){
        buttonA.isEnabled = false
        buttonB.isEnabled = false
        buttonCHex.isEnabled = false
        buttonD.isEnabled = false
        buttonE.isEnabled = false
        buttonF.isEnabled = false
    }
    private fun calcularbinario(){
        buttonN2.isEnabled = false
        buttonN3.isEnabled = false
        buttonN4.isEnabled = false
        buttonN5.isEnabled = false
        buttonN6.isEnabled = false
        buttonN7.isEnabled = false
        buttonN8.isEnabled = false
        buttonN9.isEnabled = false
        buttonA.isEnabled = false
        buttonB.isEnabled = false
        buttonCHex.isEnabled = false
        buttonD.isEnabled = false
        buttonE.isEnabled = false
        buttonF.isEnabled = false

        buttonClear.setOnClickListener{
            clearBin()
        }

        buttonHex.setOnClickListener{
            calcularHexadecimal()
        }
        buttonDecimal.setOnClickListener{
            calcularDecimales()
        }
        buttonN1.setOnClickListener{
            buttonBinario("1")
        }
        buttonNcero.setOnClickListener{
            buttonBinario("0")
        }
        buttonSumar.setOnClickListener{
            operaciones(Suma)
        }
        buttonRestar.setOnClickListener{
            operaciones(Resta)
        }
        buttonMultiplicar.setOnClickListener{
            operaciones(Multiplicacion)
        }
        buttonDividir.setOnClickListener{
            operaciones(Division)
        }
        buttonIgual.setOnClickListener{
           opcion()
        }

    }
    private fun buttonBinario(num: String) {
        textViewResultado.setText("${textViewResultado.text}$num")

        if (operacion == No_Operacion ) {
            bin1 = textViewResultado.text.toString().toLong();
            num1 = conversorDecimalaBinario(bin1)

        } else {
            bin2 = textViewResultado.text.toString().toLong();
            num2 = conversorDecimalaBinario(bin2)
        }
    }
    fun clearBin(){
        num1=0.0
        num2=0.0
        bin1=0
        bin2=0
        operacion=0
        textViewResultado.setText("")
    }
    private  fun opcion() {

        var resultado = when (operacion) {
            Suma -> num1 + num2
            Resta -> num1 - num2
            Multiplicacion -> num1 * num2
            Division -> num1 / num2
            else -> 0
        }

        textViewResultado.setText(conversorBinario(resultado.toInt()).toString()) //Respuesta
        num1 = resultado as Double
    }
    fun conversorBinario(n: Int): Long {
        var n = n
        var numBinario: Long = 0
        var remainder: Int
        var i = 1
        var step = 1

        while (n != 0) {
            remainder = n % 2
            System.out.printf("Step %d: %d/2, Remainder = %d, Quotient = %d\n", step++, n, remainder, n / 2)
            n /= 2
            numBinario += (remainder * i).toLong()
            i *= 10
        }
        return numBinario
    }

    private fun operaciones(operacion: Int) {
        this.operacion = operacion
        textViewResultado.setText("")
    }
    fun conversorDecimalaBinario(binario: Long): Double {
        var binario = binario
        var decimal = 0.0
        var i = 0
        var remainder: Long

        while (binario.toInt() != 0) {
            remainder = binario % 10
            binario /= 10
            decimal += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimal
    }

}

