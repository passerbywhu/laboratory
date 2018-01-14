package com.passerbywhu.laboratory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.passerbywhu.laboratory.generictype.GenericSuperTest;
import com.passerbywhu.laboratory.generictype.TypePrinter;
import com.passerbywhu.laboratory.generictype.TypeToken;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //事实证明。RecyclerView不会响应onClick事件。只能用onTouch去处理。
                int id = v.getId();
            }
        });

//        GenericSuperTest.test();
//        TypePrinter.test();
        TypeToken.test();
    }
}
