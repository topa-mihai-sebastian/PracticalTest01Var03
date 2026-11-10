package ro.pub.cs.systems.eim.lab04.practicaltest01var03

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        findViewById<TextView>(R.id.result_secondary).setText(intent.getStringExtra("result"))
        val buttonListener = ButtonListener()
        findViewById<Button>(R.id.correct_button).setOnClickListener(buttonListener)
        findViewById<Button>(R.id.incorrect_button).setOnClickListener(buttonListener)
    }

    private inner class ButtonListener : View.OnClickListener {
        override fun onClick(view: View) {
            when(view.id) {
                R.id.correct_button -> {
                    setResult(Activity.RESULT_OK)
                    finish()
                }
                R.id.incorrect_button -> {
                    setResult(Activity.RESULT_CANCELED)
                    finish()
                }
            }
        }
    }
}