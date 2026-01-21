
package com.example.toyboxrun

import android.app.Activity
import android.os.Bundle
import android.widget.*
import java.io.*

class MainActivity : Activity() {

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContentView(R.layout.activity_main)

        val e = findViewById<EditText>(R.id.e)
        val b = findViewById<Button>(R.id.b)
        val t = findViewById<TextView>(R.id.t)

        b.setOnClickListener {
            val c = e.text.toString().trim()
            if (c.isEmpty()) {
                t.text = "?"
                return@setOnClickListener
            }
            t.text = run(c)
        }
    }

    private fun run(c: String): String {
        return try {
            val p = Runtime.getRuntime().exec(c)
            val o = p.inputStream.bufferedReader().readText()
            val err = p.errorStream.bufferedReader().readText()
            p.waitFor()
            "Exit:${p.exitValue()}\nO:$o\nE:$err"
        } catch (x: Exception) {
            "X:${x.message}"
        }
    }
}