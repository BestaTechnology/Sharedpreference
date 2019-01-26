package voice_to_text.sandy148101.com.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submitbtn, previousbtn;

    EditText  editTextA, editTextB;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitbtn =(Button)findViewById(R.id.subBtn);

        previousbtn =(Button)findViewById(R.id.PreBtn);

        editTextA =(EditText)findViewById(R.id.editText_a);

        editTextB =(EditText)findViewById(R.id.editText_b);

        sp =getSharedPreferences("key",MODE_PRIVATE);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = editTextA.getText().toString();

                String b=  editTextB.getText().toString();
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("name",a);
                editor.putString("pass",b);
                editor.commit();

                editTextA.setText("");
                editTextB.setText("");

            }
        });

        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = sp.getString("name","");
                String b1 = sp.getString("pass","");

                editTextA.setText(a1);
                editTextB.setText(b1);

            }
        });
    }
}
