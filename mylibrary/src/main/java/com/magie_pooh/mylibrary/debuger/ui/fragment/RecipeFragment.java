package com.magie_pooh.mylibrary.debuger.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.magie_pooh.mylibrary.R;
import com.magie_pooh.mylibrary.debuger.model.Clerk;
import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;
import com.magie_pooh.mylibrary.debuger.ui.adapter.RecipePrefFileHeader;
import com.magie_pooh.mylibrary.debuger.ui.adapter.RecipePrefHeader;
import com.magie_pooh.mylibrary.debuger.ui.adapter.RecipePrefItem;
import com.magie_pooh.mylibrary.debuger.ui.adapter.RecipeAdapter;

import java.util.List;

/**
 * Created by magie-pooh on 2015/03
 */
public class RecipeFragment extends Fragment implements AbsListView.OnItemClickListener {

    private RecipeAdapter mAdapter;

    public static RecipeFragment newInstance() {
        return new RecipeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_receipe, container, false);
        final ListView listView = (ListView) v.findViewById(R.id.fragment_recipe_listview);
        mAdapter = new RecipeAdapter(getActivity());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mAdapter.performItemClick(i, this);
    }

    public void refresh() {
        mAdapter.clear();

        mAdapter.add(RecipePrefHeader.create(mAdapter.getActivity()));

        final List<PrefData> dtoList = new Clerk().getPreferenceData(mAdapter.getActivity());
        String beforeFileName = "";
        for (final PrefData dto : dtoList) {
            if (!beforeFileName.equals(dto.fileName)) {
                mAdapter.add(RecipePrefFileHeader.create(mAdapter.getActivity(), dto.fileName));
                beforeFileName = dto.fileName;
            }
            mAdapter.add(RecipePrefItem.create(mAdapter.getActivity(), dto));
        }
    }
}
