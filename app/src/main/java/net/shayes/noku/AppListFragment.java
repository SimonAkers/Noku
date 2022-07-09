package net.shayes.noku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AppListFragment extends Fragment {
    public static final int NUM_COLUMNS = 3;

    TVAppManager appManager;

    RecyclerView recycler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appManager = new TVAppManager(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.recycler_applist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler);

        recycler.setLayoutManager(new GridLayoutManager(requireContext(), NUM_COLUMNS));
        // TODO recycler.setAdapter();
    }
}
