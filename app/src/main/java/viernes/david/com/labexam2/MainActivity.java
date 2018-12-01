package viernes.david.com.labexam2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd,btnAdd2;
    private EditText editText,editText2,editText3,editText4;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText);
        editText3 = (EditText) findViewById(R.id.editText);
        editText4 = (EditText) findViewById(R.id.editText);
        textView6 = (TextView) findViewById(R.id.textView6);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd2 = (Button) findViewById(R.id.btnAdd2);
        mDatabaseHelper = new DatabaseHelper(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newEntry = editText.getText().toString();
                String newEntry2 = editText2.getText().toString();
                String newEntry3 = editText4.getText().toString();
                String newEntry4 = editText3.getText().toString();

                int exam1 = Integer.parseInt(newEntry3);
                int exam2 = Integer.parseInt(newEntry4);

                int average = (exam1+exam2)/2;
                textView6.setText(average);
                String avg = textView6.getText().toString();
                if (editText.length() != 0 && editText2.length() != 0) {
                    AddData(newEntry,newEntry2,avg);
                    editText.setText("");
                    editText2.setText("");
                    textView6.setText(average);
                } else {
                }

            }
        });
    }
    public void AddData(String newEntry,String newEntry2, String avg) {
        mDatabaseHelper.addData(newEntry,newEntry2,avg);

    }
}
