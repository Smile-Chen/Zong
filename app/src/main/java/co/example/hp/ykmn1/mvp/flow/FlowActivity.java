package co.example.hp.ykmn1.mvp.flow;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.example.hp.ykmn1.R;

/**
 * Created by hp on 2018/6/28.
 */

public class FlowActivity extends AppCompatActivity{

    private EditText flowEtEdit;
    private Button flowBtnAdd;
    private FlowLayout flowFlow;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn02_flowlayout);

        flowEtEdit = findViewById(R.id.flow_et_edit);
        flowBtnAdd = findViewById(R.id.flow_btn_add);
        flowFlow = findViewById(R.id.flow_flow);

        flowBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = flowEtEdit.getText().toString();
                Button button = new Button(FlowActivity.this);
                button.setText(edit+"");
                button.setBackgroundColor(Color.YELLOW);
                flowFlow.addView(button);
            }
        });


    }



}
