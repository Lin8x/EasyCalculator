package com.daneasycalculator.easycalculator

import android.annotation.SuppressLint
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.abs
import android.media.MediaPlayer
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null
    //var numberClick = MediaPlayer.create(this, R.raw.numberclick)
    //var equalClick = MediaPlayer.create(this, R.raw.equalclick)
    //var symbolClick = MediaPlayer.create(this, R.raw.symbolclick)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When clear button is pressed
        buttonclear.setOnClickListener {
            val a = ""
            //symbolClick.start()
            importanttext.setText(a)
            importanttext2.setText(a)
        }

        //When del button is pressed
        buttondel.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val length: Int = t.length
            var a = ""
            if(t.length > 1){
                a = t.substring(0,length-1)
            }
            //symbolClick.start()
            importanttext.setText(a)
        }

        //When divide button is pressed
        buttondivide.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val a = "$t/"
            importanttext.setText(a)
        }

        //When multiply button is pressed
        buttonmultiply.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val a = "$t*"
            //symbolClick.start()
            importanttext.setText(a)
        }

        //When plus button is pressed
        buttonplus.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val a = t + "+"
            //symbolClick.start()
            importanttext.setText(a)
        }

        //When subtract button is pressed
        buttonminus.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val a = t + "-"
            //symbolClick.start()
            importanttext.setText(a)
        }

        //When equal button is pressed
        buttoneuqal.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            println(t)
            var num = ""
            var symbol: Char
            val partsofequation = mutableListOf<String>()
            //equalClick.start()
            if(t.length >= 1) {
                if ((t[0].toString()).equals("/") || (t[t.length - 1].toString()).equals("/") || (t[0].toString()).equals(
                        "*"
                    ) || (t[t.length - 1].toString()).equals("*") || (t[0].toString()).equals("+") || (t[t.length - 1].toString()).equals(
                        "+"
                    ) || (t[0].toString()).equals("-") || (t[t.length - 1].toString()).equals("-") || (t[t.length - 1].toString()).equals(
                        "."
                    )
                ) {
                    println("ENTER MAKE IS NOT RUNNING LOL - SYMBOL ON SIDE")
                    importanttext2.setTextColor(Color.parseColor("#FF0000"))
                    importanttext2.setText("Err: SYMBL ON SIDE")
                    importanttext2.setTextColor(Color.parseColor("#FFFFFF"))
                } else {

                    if (t.contains("/0")) {
                        println("ENTER MAKE IS NOT RUNNING LOL - DIVIDE BY ZERO")
                        importanttext2.setText("Err: DIV BY 0")
                    } else {

                        for (i in t) {

                            println(i.toString())
                            println(partsofequation)

                            if (i in '0'..'9' || (i.toString()).equals('.'.toString())) {
                                num += i
                                println(num)
                            } else {
                                symbol = i
                                println(symbol.toString())
                                if (symbol == '/') {
                                    partsofequation.add(num)
                                    partsofequation.add("/")
                                }
                                if (symbol == '*') {
                                    partsofequation.add(num)
                                    partsofequation.add("*")
                                }
                                if (symbol == '+') {
                                    partsofequation.add(num)
                                    partsofequation.add("+")
                                }
                                if (symbol == '-') {
                                    partsofequation.add(num)
                                    partsofequation.add("-")
                                }
                                num = ""
                            }
                        }
                        println(partsofequation)
                        partsofequation.add(num)
                        println("ENTER MAKE IS STARTING TO RUn")
                        EnterButton().makeEnter(t, partsofequation)

                        println(partsofequation)

                        var b = partsofequation[0].toDouble()
                        println(b)
                        val f = b.toInt()

                        if ((abs(b)).rem(1).equals(0.0)) {

                            partsofequation[0] = f.toString()

                        }
                        importanttext2.setText(partsofequation[0])
                    }
                }
            }
        }

        //When dot button is pressed
        buttondot.setOnClickListener {
            val t: String = (importanttext.getText()).toString()
            val a = t + "."
            //numberClick.start()
            importanttext.setText(a)
        }

        //When 0 button is pressed
        button0.setOnClickListener {

            //setting the string to String + 0
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "0"
            println("button0 pressed!")
            //numberClick.start()
            importanttext.setText(a)

        }

        //When 1 button is pressed
        button1.setOnClickListener {

            //setting the string to String + 1
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "1"
            println("button1 pressed!")
            //numberClick.start()
            importanttext.setText(a)

        }

        //When 2 button is pressed
        button2.setOnClickListener {

            val t: String = (importanttext.getText()).toString()
            val a: String = t + "2"

            println("button2 pressed!")

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 3 button is pressed
        button3.setOnClickListener {

            val t: String = (importanttext.getText()).toString()
            val a: String = t + "3"

            println("button3 pressed!")

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 4 button is pressed
        button4.setOnClickListener {

            //setting the string to String + 4
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "4"

            println("button4 pressed!")

            //numberClick.start()
            importanttext.setText(a)

            println("button5 after: " + importanttext.getText())
        }

        //When 5 button is pressed
        button5.setOnClickListener {

            //setting the string to String + 5
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "5"

            println("button5 pressed!")

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 6 button is pressed
        button6.setOnClickListener {

            //setting the string to String + 6
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "6"

            println("button6 pressed!")

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 7 button is pressed
        button7.setOnClickListener {

            //setting the string to String + 7
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "7"

            println("button7 pressed!")

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 8 button is pressed
        button8.setOnClickListener {

            val t: String = (importanttext.getText()).toString()
            val a: String = t + "8"

            //numberClick.start()
            importanttext.setText(a)

        }

        //When 9 button is pressed
        button9.setOnClickListener {

            //setting the string to String + 9
            val t: String = (importanttext.getText()).toString()
            val a: String = t + "9"

            //numberClick.start()
            importanttext.setText(a)

        }

    }
    
}