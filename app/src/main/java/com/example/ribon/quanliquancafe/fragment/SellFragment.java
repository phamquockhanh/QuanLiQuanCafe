package com.example.ribon.quanliquancafe.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.TableRecyclerAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.common.SimpleItemTouchHelperCallback;
import com.example.ribon.quanliquancafe.loader.TableDao;
import com.example.ribon.quanliquancafe.model.Table;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Ribon on 08/03/2017.
 */

public class SellFragment extends BaseFragment implements TableRecyclerAdapter.RecyclerListAdapterOnClickHandler  {
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;




    private ItemTouchHelper mItemTouchHelper;
    /*TableRecyclerAdapter adapter;*/
    TableRecyclerAdapter adapter;
   /* ManagerTable managerTable;*/
    @Override
    public int getResId() {
        return R.layout.fragment_sell;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        createtable();

        /*tables=Table.listAll(Table.class);*/
        /*table= (Table) Table.listAll(Table.class);*/
        /*connectDatabase();
*/
        /*managerTable=new ManagerTable(getActivity());
        tables = new ArrayList<Table>();
        tables = managerTable.tableList();*/

        /*adapter = new TableRecyclerAdapter(getActivity(),tables);*/
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

        /*for (Table table:tables)
        {
            table=new Table(Arrays.asList(plus,change,pay));
            tables.add(table);
        }*/

        /*mRecyclerView.setHasFixedSize(true);*/
        TableDao tableDao=new TableDao(getActivity());
        adapter = new TableRecyclerAdapter(getActivity(),tableDao.getAll(),this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRecyclerView.setHasFixedSize(true);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void createtable() {
        Log.i("OrmLite","######");
        TableDao tableDao=new TableDao(getActivity());
        if(tableDao.getAll().size()==0)
        {
            Table table=new Table();
            table.setTitle("Bàn 1");
            table.setSort(0);
            tableDao.create(table);
            Log.i("OrmLite","Id"+table.getId());

            Table table1=new Table();
            table1.setTitle("Bàn 2");
            table1.setSort(1);
            tableDao.create(table1);
            Log.i("OrmLite","Id"+table.getId());

            Table table2=new Table();
            table2.setTitle("Bàn 3");
            table2.setSort(2);
            tableDao.create(table2);
            Log.i("OrmLite","Id"+table.getId());

            Table table3=new Table();
            table3.setTitle("Bàn 4");
            table3.setSort(3);
            tableDao.create(table3);
            Log.i("OrmLite","Id"+table.getId());

            Table table4=new Table();
            table4.setTitle("Bàn 5");
            table4.setSort(4);
            tableDao.create(table4);
            Log.i("OrmLite","Id"+table.getId());

            Table table5=new Table();
            table5.setTitle("Bàn 6");
            table5.setSort(5);
            tableDao.create(table5);
            Log.i("OrmLite","Id"+table.getId());

            Table table6=new Table();
            table6.setTitle("Bàn 7");
            table6.setSort(6);
            tableDao.create(table6);
            Log.i("OrmLite","Id"+table.getId());

            Table table7=new Table();
            table7.setTitle("Bàn 8");
            table7.setSort(7);
            tableDao.create(table7);
            Log.i("OrmLite","Id"+table.getId());

            Table table8=new Table();
            table8.setTitle("Bàn 9");
            table8.setSort(8);
            tableDao.create(table8);
            Log.i("OrmLite","Id"+table.getId());

            Table table9=new Table();
            table9.setTitle("Bàn 10");
            table9.setSort(9);
            tableDao.create(table9);
            Log.i("OrmLite","Id"+table.getId());

            Table table10=new Table();
            table10.setTitle("Bàn 10");
            table10.setSort(10);
            tableDao.create(table10);
            Log.i("OrmLite","Id"+table.getId());
        }
    }



   /* private List<Table> initData() {
        Option order=new Option("Thêm món");
        Option change=new Option("Đổi món");
        Option pay=new Option("Thanh toán");
        List<Option> childList = new ArrayList<>();
        childList.add(order);
        childList.add(change);
        childList.add(pay);
        for(Table table: tables)
        {

            table.setChildList(childList);
            *//*tables.add(table);*//*
        }

        return tables;
    }*/
   /* private void connectDatabase() {
        managerTable = new ManagerTable(getActivity());
        try {
            managerTable.createDataBase();

        } catch (IOException e) {
            e.printStackTrace();
        }
        managerTable.close();
    }*/

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
    public void onAttach(Context context) {
        super.onAttach(context);
       /* ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final Dialog dialog=new Dialog(getActivity());
        final EditText mEdtInsert;
        if (id== R.id.action_insert_table)
        {


            dialog.setTitle("Thêm bàn");
            dialog.setContentView(R.layout.insert_customdialog_layout);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.show();
            Button mBtnOK = (Button) dialog.findViewById(R.id.btn_ok);
            Button mBtnCancel= (Button) dialog.findViewById(R.id.btn_cancel);
            mEdtInsert= (EditText) dialog.findViewById(R.id.edt_insert);
            mBtnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strNameTable=mEdtInsert.getText().toString();
                    if (TextUtils.isEmpty(strNameTable)) {
                        Toast.makeText(getActivity(), "Vui lòng nhập tên bàn", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        TableDao tableDao=new TableDao(getActivity());
                        Table table=new Table();
                        table.setTitle(strNameTable);
                        table.setSort(tableDao.sortMax());
                        Toast.makeText(getActivity(), tableDao.sortMax()+"", Toast.LENGTH_SHORT).show();
                        tableDao.create(table);
                        Toast.makeText(getActivity(), "Thêm bàn thành công", Toast.LENGTH_SHORT).show();
                        adapter.addTable(table);
                        mRecyclerView.setAdapter(adapter);
                        dialog.cancel();
                    }
                }
            });
            mBtnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });

        }

        if(id==R.id.action_save_reference) {
            TableDao tableDao=new TableDao(getActivity());
            boolean isSuccess = true;
            List<Table>tables = adapter.getmItems();
                for (int i = 0; i < tables.size(); i++) {
                    tableDao.update(tables.get(i).getId(),i);
                }
            Toast.makeText(getActivity(), "Update thành công!!", Toast.LENGTH_SHORT).show();
        }
        /*updateSort(tables.get(i).getId(), i);*/

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(Table item) {

    }

}
