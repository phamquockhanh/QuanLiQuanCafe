package com.example.ribon.quanliquancafe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.RecyclerListAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.common.SimpleItemTouchHelperCallback;
import com.example.ribon.quanliquancafe.loader.ManagerTable;
import com.example.ribon.quanliquancafe.model.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Ribon on 08/03/2017.
 */

public class SellFragment extends BaseFragment  {
    @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
    /*@Bind(R.id.toolbar)
    Toolbar mSellToolbar;*/
    private ItemTouchHelper mItemTouchHelper;
    List<Table> list;
    RecyclerListAdapter adapter;
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
        list = new ArrayList<Table>();
        list= managerTable.tableList();

        adapter = new RecyclerListAdapter(getActivity(),list);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }

            @Override
            public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                //Log.d("demo",toPosition+"");
               // int idBan = list.get(fromPosition).getId();
                //update lại sort table
                //UPDATE TABLE TableCoffee SET sort = <toPosition> WHERE id = <idBan>
                //managerTable.updateSort(idBan, toPosition);
                //Log.d("test", "from: "+fromPosition + " - to:"+toPosition);
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        int idBan = list.get(i).getId();
                        managerTable.updateSort(idBan, i+1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        int idBan = list.get(i).getId();
                        managerTable.updateSort(idBan, i-1);
                    }
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);


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
//        for(int i=0;i<list.size();i++){
//            list.add(pref.getString("index"+i,""));
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
        if (id== R.id.action_settings)
        {
            Toast.makeText(getActivity(), "Thêm bàn", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
