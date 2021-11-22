package com.mil.en2fr.dynamic_box_create;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button ok;
    EditText enter_value;
    ArrayList<RecycleDataModel> myList=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ok=findViewById(R.id.btn_ok);
        enter_value=findViewById(R.id.txt_enter_value);
        mRecyclerView=findViewById(R.id.recycle);
        mRecyclerAdapter=new RecyclerAdapter(myList,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mRecyclerAdapter);

//        final ViewGroup layout = (ViewGroup) findViewById(R.id.demo);
//        ScrollView sv=new ScrollView(this);
//        ll= new LinearLayout(this);
//        ll.setOrientation(LinearLayout.VERTICAL);
//        sv.addView(ll);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    for (int i=1;i<=times;i++) {
//                    view = new CheckBox(MainActivity.this);
//                    ll.addView(view);
//                }
//                layout.addView(ll);
                myList.clear();
                if (enter_value.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Please enter value", Toast.LENGTH_SHORT).show();
                }else {
                    int value = Integer.parseInt(enter_value.getText().toString());
                    RecycleDataModel dModel = new RecycleDataModel();
                    dModel.setTitle("Paras");
                    for (int i = 1; i <= value; i++) {
                        myList.add(dModel);
                        mRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}