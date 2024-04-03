package rs.ac.metropolitan.cs330_dz06_2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var editText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        val buttonYes = findViewById<Button>(R.id.buttonYes)
        val buttonNo = findViewById<Button>(R.id.buttonNo)
        buttonYes.setOnClickListener { confirmChoice(true) }
        buttonNo.setOnClickListener { confirmChoice(false) }
    }

    private fun confirmChoice(isYesSelected: Boolean) {
        val faculty = editText!!.text.toString().trim { it <= ' ' }
        if (faculty.isEmpty()) {
            Toast.makeText(this, "Molimo unesite fakultet", Toast.LENGTH_SHORT).show()
            return
        }
        val message: String
        message = if (isYesSelected) {
            "Vi ste student fakulteta $faculty"
        } else {
            "Niste student fakulteta $faculty"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_fit -> {
                confirmFaculty("FIT")
                true
            }

            R.id.menu_management -> {
                confirmFaculty("Fakultet za menadžment")
                true
            }

            R.id.menu_digital_arts -> {
                confirmFaculty("Fakultet digitalnih umetnosti")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun confirmFaculty(faculty: String) {
        editText!!.setText(faculty)
    }
}

