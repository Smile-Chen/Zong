package co.example.hp.ykmn1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.example.hp.ykmn1.mvp.Much.view.activity.RecyclerMuch;
import co.example.hp.ykmn1.mvp.fclass.view.activity.ClassIfy;
import co.example.hp.ykmn1.mvp.flow.FlowActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnRecyclerView,btnFlow,btnShoppingCar,btnClassify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRecyclerView = findViewById(R.id.btn_recyclerview);
        btnFlow = findViewById(R.id.btn_flow);
        btnShoppingCar = findViewById(R.id.btn_shoppingcar);
        btnClassify = findViewById(R.id.btn_classify);

     //多条目加载
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerMuch.class);
                startActivity(intent);
            }
        });
        //流式布局
       btnFlow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, FlowActivity.class);
               startActivity(intent);
           }
       });
       //分类
        btnClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClassIfy.class);
                startActivity(intent);
            }
        });


    }



}
