package ro.pub.cs.systems.eim.lab04.practicaltest01var03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buttonListener = ButtonListener()

        findViewById<Button>(R.id.plus_button).setOnClickListener(buttonListener)
        findViewById<Button>(R.id.minus_button).setOnClickListener(buttonListener)
    }

    private inner class ButtonListener : View.OnClickListener {
        override fun onClick(view: View) {
            when(view.id) {
                R.id.plus_button -> {
                    val a = findViewById<EditText>(R.id.first_number)
                    val b = findViewById<EditText>(R.id.second_number)
                    if(a.text.toString().toIntOrNull() == null || b.text.toString().toIntOrNull() == null) {
                        Toast.makeText(this@MainActivity, "The input has non-numeric values!", Toast.LENGTH_LONG).show()
                        return
                    }
                    val total = a.text.toString().toInt() + b.text.toString().toInt()
                    val res = a.text.toString() + " + " + b.text.toString() + " = " + total.toString()

                    val result = findViewById<TextView>(R.id.result_text)
                    result.setText(res)
                }
                R.id.minus_button -> {
                    val a = findViewById<EditText>(R.id.first_number)
                    val b = findViewById<EditText>(R.id.second_number)
                    if(a.text.toString().toIntOrNull() == null || b.text.toString().toIntOrNull() == null) {
                        Toast.makeText(this@MainActivity, "The input has non-numeric values!", Toast.LENGTH_LONG).show()
                        return
                    }
                    val total = a.text.toString().toInt() - b.text.toString().toInt()
                    val res = a.text.toString() + " + " + b.text.toString() + " = " + total.toString()

                    val result = findViewById<TextView>(R.id.result_text)
                    result.setText(res)
                }
            }
        }
    }
}