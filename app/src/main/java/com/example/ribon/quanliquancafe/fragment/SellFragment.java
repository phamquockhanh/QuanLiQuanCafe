package com.example.ribon.quanliquancafe.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.MyAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.common.SimpleItemTouchHelperCallback;
import com.example.ribon.quanliquancafe.loader.ManagerTable;
import com.example.ribon.quanliquancafe.model.Table;
import com.example.ribon.quanliquancafe.model.TitleChild;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ribon on 08/03/2017.
 */

public class SellFragment extends BaseFragment  {
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    /*@Bind(R.id.edt_plus)EditText mEdtPlus;
    @Bind(R.id.btn_ok)Button mBtnOK;
    @Bind(R.id.btn_cancel)Button mBtnCancel;*/


    private ItemTouchHelper mItemTouchHelper;
    List<Table> tables;
    /*RecyclerListAdapter adapter;*/
    MyAdapter adapter;
    ManagerTable managerTable;
    @Override
    public int getResId() {
        return R.layout.fragment_sell;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        connectDatabase();

        managerTable=new ManagerTable(getActivity());
        tables = new ArrayList<Table>();
        tables = managerTable.tableList();

        /*adapter = new RecyclerListAdapter(getActivity(),tables);*/
        /*adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                //Log.d("demo",toPosition+"");
               // int idBan = tables.get(fromPosition).getId();
                //update lại sort table
                //UPDATE TABLE TableCoffee SET sort = <toPosition> WHERE id = <idBan>
                //managerTable.updateSort(idBan, toPosition);
                //Log.d("test", "from: "+fromPosition + " - to:"+toPosition);
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        int idBan = tables.get(i).getId();
                        managerTable.updateSort(idBan, i+1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        int idBan = tables.get(i).getId();
                        managerTable.updateSort(idBan, i-1);
                    }
                }
            }
        });*/
        /*mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);*/



        // have bug here
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        adapter = new MyAdapter(getActivity(),initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        mRecyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
    private List<ParentObject> initData() {
        List<ParentObject> parentObject = new ArrayList<>();
        for(Table table: tables)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("op1","op2","op3"));
            table.setChildObjectList(childList);
            parentObject.add(table);
        }
        return parentObject;

    }
    private void connectDatabase() {
        managerTable = new ManagerTable(getActivity());
        try {
            managerTable.createDataBase();

        } catch (IOException e) {
            e.printStackTrace();
        }
        managerTable.close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main,menu);
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onResume() {
        super.onResume();
//        SharedPreferences pref = getActivity().getSharedPreferences("luuPossition",Context.MODE_PRIVATE);
//        for(int i=0;i<tables.size();i++){
//            tables.add(pref.getString("index"+i,""));
//            Log.d("onresume",i+"");
//        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       /* if(id==android.R.id.home){
            getActivity().getSupportFragmentManager().popBackStack();
            Toast.makeText(getActivity(), "back", Toast.LENGTH_SHORT).show();
        }*/
        if (id== R.id.action_plus_table)
        {
            /*Toast.makeText(getActivity(), "Thêm bàn", Toast.LENGTH_SHORT).show();
            Table table=new Table("Bàn Vip",0);

            managerTable.insertData(table.getTableName(),table.getSort());
            tables.add(table);
            mRecyclerView.setAdapter(adapter);*/
            final Dialog dialog=new Dialog(getActivity());
            dialog.setTitle("Thêm bàn");

            dialog.setContentView(R.layout.insert_customdialog_layout);
            dialog.show();
            final EditText mEdtPlus= (EditText) dialog.findViewById(R.id.edt_plus);
            Button mBtnOK = (Button) dialog.findViewById(R.id.btn_ok);
            Button mBtnCancel= (Button) dialog.findViewById(R.id.btn_cancel);
            mBtnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Table table=new Table();
                    String nameTable=table.setTableName(String.valueOf(mEdtPlus.getText()));
                    int sort=table.setSort(managerTable.sortMax()+1);
                    managerTable.insertData(nameTable,sort);
                    tables.add(table);
                    /*adapter.notifyDataSetChanged();*/
                    mRecyclerView.setAdapter(adapter);

                    dialog.cancel();
                }
            });
            mBtnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });


        }
        return super.onOptionsItemSelected(item);
    }
}
