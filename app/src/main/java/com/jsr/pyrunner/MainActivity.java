package com.jsr.pyrunner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // بدء محرك بايثون
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        final EditText tokenEdit = findViewById(R.id.tokenInput);
        final EditText idEdit = findViewById(R.id.idInput);
        Button runBtn = findViewById(R.id.btnRun);

        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = tokenEdit.getText().toString();
                String chatId = idEdit.getText().toString();
                
                try {
                    Python py = Python.getInstance();
                    PyObject pyObj = py.getModule("script"); // استدعاء ملف script.py
                    
                    // تشغيل دالة start_logic وإرسال التوكن والآيدي لها
                    PyObject result = pyObj.callAttr("start_logic", token, chatId);
                    
                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "خطأ: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
