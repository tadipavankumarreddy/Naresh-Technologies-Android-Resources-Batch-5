package `in`.nareshtechnologies.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t: TextView = findViewById(R.id.textView)
        var b1: Button = findViewById(R.id.button);
        var b2: Button = findViewById(R.id.button2);

        var count: Int = 0;
        b1.setOnClickListener(){
            count++;
            t.text = count.toString();
        }

        b2.setOnClickListener(){
            count--;
            t.text = count.toString();
        }
    }
}