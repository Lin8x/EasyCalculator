package com.daneasycalculator.easycalculator

class EnterButton {

    private fun doTheMathLol(first: Double, symbol: String, last: Double): Double{
        var result = 0.0
        println("First: " + first)
        println("Last: " + last)
        println("Symbol: " + symbol)
        println("DO MATH IS WORKING")
        if(symbol == "DIV")
        {
            print("DOMATH DID DIVISION")
            result = first / last
            println("$result is the result!")
            return result
        }
        else{
            if(symbol == "MUL"){
                print("DOMATH DID MULTIPLICATION")
                result = first * last
                println("$result is the result!")
                return result
            }
            else
            {
                if(symbol == "ADD") {
                    print("DOMATH DID ADDITION")
                    result = (first + last)
                    println("$result is the result!")
                    return result
                }
                else
                {
                    if (symbol == "SUB") {
                        print("DOMATH DID SUBTRACTION" + (first - last))
                        result = (first - last)
                        println("$result is the result!")
                        return result
                    }
                    else
                    {
                        print("yeah this is broken lol")
                        println("$result is the result!")
                        return result
                    }
                }
            }
        }
        return 0.0
    }

    fun makeEnter(t: String, partsofequation: MutableList<String>) {
        //solving the actual equation
        partsofequation.toMutableList()
        var i = 0
        while(i<5 || partsofequation.size <= 1) {
            i += 1
            //identifying the indexes cause it's really annoying lol
            val divideindex = partsofequation.indexOf("/")
            val multiplyindex = partsofequation.indexOf("*")
            val minusindex = partsofequation.indexOf("-")
            val plusindex = partsofequation.indexOf("+")

            //this is for testing
            println("D:$divideindex | MP:$multiplyindex | MN:$minusindex | P:$plusindex")

            //to determine if / or * comes first, then do the math for it

            // this is for division if it is to the left most side before the multiplication
            if(partsofequation.indexOf("/") > -1 && partsofequation.indexOf("*") > -1) {
                if (divideindex < multiplyindex) {
                    print("This is for leftmost division lol")
                    val g = doTheMathLol(
                        (partsofequation[divideindex - 1]).toDouble(),
                        "DIV",
                        (partsofequation[divideindex + 1]).toDouble()
                    )
                    println("successfull here 1!")
                    partsofequation[divideindex] = g.toString()
                    println("successfull here 2!")
                    partsofequation.removeAt((divideindex + 1))
                    println("successfull here 3!")
                    partsofequation.removeAt((divideindex - 1))
                    println("successfully ended!")
                }
                // this is for multiplication if it is to the left most side before the divide
                else{
                    print("This is for leftmost multiplication lol")
                    val g = doTheMathLol((partsofequation[multiplyindex - 1]).toDouble(), "MUL", (partsofequation[multiplyindex + 1]).toDouble())
                    partsofequation[multiplyindex] = g.toString()
                    partsofequation.removeAt(multiplyindex+1)
                    partsofequation.removeAt(multiplyindex-1)
                }
                print(partsofequation)
            }

            else {
                // this is for division
                if(partsofequation.indexOf("/") > -1){
                    print("This is for regular division lol")
                    val g = doTheMathLol((partsofequation[divideindex - 1]).toDouble(), "DIV", (partsofequation[divideindex + 1]).toDouble())
                    partsofequation[divideindex] = g.toString()
                    partsofequation.removeAt(divideindex+1)
                    partsofequation.removeAt(divideindex-1)
                }
                else {

                    // this is for multiplication
                    print("This is for regular multiplication lol")
                    if (partsofequation.indexOf("*") > -1) {
                        println("before domath")
                        val g = doTheMathLol((partsofequation[multiplyindex - 1]).toDouble(), "MUL", (partsofequation[multiplyindex + 1]).toDouble())
                        partsofequation[multiplyindex] = g.toString()
                        partsofequation.removeAt(multiplyindex + 1)
                        partsofequation.removeAt(multiplyindex - 1)
                        println("after domath")
                    }

                    // now that division and multiplication is done
                    else
                    {
                        //to determine if - or + comes first, then do the math for it

                        if (partsofequation.indexOf("-") > -1 && partsofequation.indexOf("+") > -1) {

                            if (minusindex < plusindex) {
                                // this is for subtract if it is to the left most side before the multiplication
                                print("This is for leftmost subtraction lol")
                                val g = doTheMathLol((partsofequation[minusindex - 1]).toDouble(),"SUB", (partsofequation[minusindex + 1]).toDouble())
                                partsofequation[minusindex] = g.toString()
                                partsofequation.removeAt(minusindex + 1)
                                partsofequation.removeAt(minusindex - 1)
                            }

                            else {
                                // this is for subtract if it is to the left most side before the multiplication
                                print("This is for leftmost addition lol")
                                val g = doTheMathLol(
                                    (partsofequation[plusindex - 1]).toDouble(),
                                    "ADD",
                                    (partsofequation[plusindex + 1]).toDouble()
                                )
                                partsofequation[plusindex] = g.toString()
                                partsofequation.removeAt(plusindex + 1)
                                partsofequation.removeAt(plusindex - 1)
                            }
                        }

                        else {

                            if(partsofequation.indexOf("+") > -1) {
                                // this is for addition if it is to the left most side before the subtraction

                                print("This is for leftmost addition lol")
                                val g = doTheMathLol(
                                    (partsofequation[plusindex - 1]).toDouble(),
                                    "ADD",
                                    (partsofequation[plusindex + 1]).toDouble()
                                )
                                partsofequation[plusindex] = g.toString()
                                partsofequation.removeAt(plusindex + 1)
                                partsofequation.removeAt(plusindex - 1)

                            }

                            else
                            {
                                if(partsofequation.indexOf("-") > -1)
                                {

                                    print("This is for leftmost subtraction lol")
                                    val g = doTheMathLol((partsofequation[minusindex - 1]).toDouble(),"SUB", (partsofequation[minusindex + 1]).toDouble())
                                    partsofequation[minusindex] = g.toString()
                                    partsofequation.removeAt(minusindex + 1)
                                    partsofequation.removeAt(minusindex - 1)
                                }

                                else
                                {
                                    println("yeah there's nothing here lol")
                                    break
                                }
                            }
                        }
                    }
                }
            }
            println(partsofequation)

            //var final = partsofequation[0].toString()

            //if(partsofequation[0].toDouble() - partsofequation[0].toInt() <= 0){
                //final = (partsofequation[0].toInt()).toString()
            //}
            //print(final)
        }
    }

}