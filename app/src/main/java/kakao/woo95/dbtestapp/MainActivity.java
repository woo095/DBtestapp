package kakao.woo95.dbtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText foodName;
    private EditText foodId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodName = (EditText)findViewById(R.id.foodname);
        foodId = (EditText)findViewById(R.id.foodid);
        Button btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(v -> {
            DBHandler handler= new DBHandler(MainActivity.this);
            Food food = new Food();
            food.set_foodName(foodName.getText().toString());

            handler.addFood(food);

            Toast.makeText(getApplicationContext(),"삽입 실행 완료",Toast.LENGTH_LONG).show();
        });
        Button btnSelect = (Button)findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(v -> {
            String query = foodId.getText().toString();
            if(query == null && query.trim().length() == 0){
                return;
            }

            DBHandler handler = new DBHandler(MainActivity.this);
            Food food = handler.findFood(Integer.parseInt(query));
            if(food == null){
                Toast.makeText(getApplicationContext(),"일치하는 데이터가 없습니다.",Toast.LENGTH_LONG).show();;
            } else {
                foodName.setText(food.get_foodName());
            }
        });
        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(v -> {
            String query = foodId.getText().toString();
            if(query == null && query.trim().length() == 0){
                return;
            }

            DBHandler handler = new DBHandler(MainActivity.this);
            handler.deleteFood(Integer.parseInt(query));

            Toast.makeText(getApplicationContext(),"삭제 실행 완료",Toast.LENGTH_LONG).show();
        });
    }
}