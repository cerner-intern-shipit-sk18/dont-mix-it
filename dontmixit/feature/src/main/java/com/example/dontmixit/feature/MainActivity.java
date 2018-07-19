package com.example.dontmixit.feature;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static RecyclerView mRecyclerView;
    public static MyAdapter mAdapter;
    public static Context mContext;

    public List<Drug> drugList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter((Drug[])drugList.toArray());
        mRecyclerView.setAdapter(mAdapter);

        mContext = this;
    }

    public void onClickBtnInteractions(android.view.View view) {
        //TODO: Put interaction details into this string
        String m_strInteractionDetails = "Put interaction details in this var";
        boolean boolInteractionOkay = false;

        Intent intent = new Intent(this, InteractionsActivity.class);
        intent.putExtra("InteractionDetails", m_strInteractionDetails);
        intent.putExtra("InteractionOkay", boolInteractionOkay);
        startActivity(intent);
    }

    public void onClickBtnScan(android.view.View view) {
        //TODO: code for scanning
    }

    public static void onClickListItem(int index)
    {
        //TODO: Put drug details into this string
        String m_strDrugDetails = "Put drug details in this var";

        Intent intent = new Intent(mContext, DetailsActivity.class);
        intent.putExtra("DrugDetails", m_strDrugDetails);
        mContext.startActivity(intent);
    }

    public void onClickBtnSearch(android.view.View view)
    {
        TextInputEditText searchBox = (TextInputEditText) findViewById(R.id.searchBox);
        String searchValue = searchBox.getText().toString();
        //searchValue has the value typed into the box

        //TODO: code for adding/searching for drug
    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Drug[] mDataset;
    private final View.OnClickListener mOnClickListener = new MyOnClickListener();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Drug[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        v.setOnClickListener(mOnClickListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position].m_strName);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public Drug getItem(int index)
    {
        return mDataset[index];
    }
}

class MyOnClickListener implements View.OnClickListener
{
    @Override
    public void onClick(View view)
    {
        int itemPosition = MainActivity.mRecyclerView.getChildLayoutPosition(view);
        MainActivity.onClickListItem(itemPosition);
    }
}