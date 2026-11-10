package ro.pub.cs.systems.eim.lab04.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.savedstate.serialization.saved

class MainActivity : AppCompatActivity() {
    public lateinit var res_public: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buttonListener = ButtonListener()

        findViewById<Button>(R.id.plus_button).setOnClickListener(buttonListener)
        findViewById<Button>(R.id.minus_button).setOnClickListener(buttonListener)
        findViewById<Button>(R.id.sec_activity_button).setOnClickListener(buttonListener)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("first", findViewById<EditText>(R.id.first_number).text.toString())
        outState.putString("second", findViewById<EditText>(R.id.second_number).text.toString())
        outState.putString("result", findViewById<TextView>(R.id.result_text).text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        findViewById<TextView>(R.id.first_number).setText(savedInstanceState.getString("first")?: "0")
        findViewById<TextView>(R.id.second_number).setText(savedInstanceState.getString("second")?: "0")
        findViewById<TextView>(R.id.result_text).setText(savedInstanceState.getString("result")?: "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            when(resultCode) {
                RESULT_OK -> Toast.makeText(this@MainActivity, "Rezultat: OK", Toast.LENGTH_LONG).show()
                RESULT_CANCELED -> Toast.makeText(this@MainActivity, "Rezultat: CANCEL", Toast.LENGTH_LONG).show()
            }
        }
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
                    res_public = res
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
                    res_public = res
                    val result = findViewById<TextView>(R.id.result_text)
                    result.setText(res)
                }
                R.id.sec_activity_button -> {
                    val intent = Intent(this@MainActivity, PracticalTest01Var03SecondaryActivity::class.java)
                    intent.putExtra("result", res_public)
                    startActivityForResult(intent, 1)
                }
            }
        }
    }
}