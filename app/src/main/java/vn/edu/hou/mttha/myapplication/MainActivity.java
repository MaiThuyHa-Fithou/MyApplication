package vn.edu.hou.mttha.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //khai bao cac doi tuong view can su dung
    TextView tvName;
    EditText edtUserName;
    Button btnShow, btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //goi phuogn getview o day
        getViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getViews(){
        tvName = findViewById(R.id.tvName);
        edtUserName = findViewById(R.id.edtUserName);
        btnShow = findViewById(R.id.btnShow);
        btnClose = findViewById(R.id.btnClose);
        btnShow.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        //xu ly su kien o day
        if(v.getId()==R.id.btnShow){
            //lay ra du lieu duoc nhap vao edtUserName
            String userName = edtUserName.getText().toString();
            //hien thi thong tin user name len thong bao Toast cho nguoi dung
            Toast.makeText(MainActivity.this,"User: "+ userName,Toast.LENGTH_LONG).show();
        }
    }

    public void onCloseButton(View view) {
        edtUserName.setText("");
    }
}