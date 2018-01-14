package com.passerbywhu.laboratory;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by hzwuwenchao on 2018/1/12.
 * https://stackoverflow.com/questions/37566303/edittext-giving-error-textview-does-not-support-text-selection-selection-canc
 * android已知BUG
 */

public class RecyclerViewEditTextTestActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_edittext_test_activity);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new TestAdapter());
    }

    class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            EditText editText = new EditText(parent.getContext());
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            editText.setLayoutParams(params);
            return new ViewHolder(editText);
        }

        @Override
        public void onViewAttachedToWindow(ViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            holder.itemView.setEnabled(false);
            holder.itemView.setEnabled(true);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            EditText editText = (EditText) holder.itemView;
            editText.setText("abcdefg   hijklmn");
            //如果不调用selection是没有问题
            editText.setSelection(editText.getText().length());
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
