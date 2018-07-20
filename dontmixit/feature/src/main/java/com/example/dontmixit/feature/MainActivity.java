package com.example.dontmixit.feature;

import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.CLIPBOARD_SERVICE;


public class MainActivity extends AppCompatActivity {

    public static RecyclerView mRecyclerView;
    public static MyAdapter mAdapter;
    public static Context mContext;
    private static ClipboardManager clipboard;

    public static ArrayList<Drug> drugList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(drugList);
        mRecyclerView.setAdapter(mAdapter);

        mContext = this;


        clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        clipboard.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener(){

            @Override
            public void onPrimaryClipChanged() {
                ClipData clipData = clipboard.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                String text = item.getText().toString();
                Drug d = DrugDB.lookup(text);
                if (d == null)
                    Toast.makeText( mContext, "Not found.", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(mContext, "Drug: " + d.name, Toast.LENGTH_LONG).show();
                    drugList.add(d);
                    mAdapter = new MyAdapter(drugList);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        });
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

        //drugList.add(new Drug("1","1"));
        mAdapter = new MyAdapter(drugList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static void onClickListItem(int index)
    {
        Intent intent = new Intent(mContext, DetailsActivity.class);
        intent.putExtra("DrugDetails", drugList.get(index).id);
        mContext.startActivity(intent);
    }

    public void onClickBtnSearch(android.view.View view)
    {
        //TextInputEditText searchBox = (TextInputEditText) findViewById(R.id.searchBox);
        //String searchValue = searchBox.getText().toString();
        //searchValue has the value typed into the box

        //TODO: code for adding/searching for drug. add new Drug(Name, details) to drugList
    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Drug> mDataset;
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
    public MyAdapter(ArrayList<Drug> myDataset) {
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
        holder.mTextView.setText(mDataset.get(position).name);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public Drug getItem(int index)
    {
        return mDataset.get(index);
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