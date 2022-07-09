package net.shayes.noku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.shayes.noku.R;
import net.shayes.noku.model.TVApp;

import java.util.List;

public class TVAppAdapter extends RecyclerView.Adapter<TVAppAdapter.ViewHolder> {
    private List<TVApp> data;
    private ItemClickListener itemClickListener;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            view = itemView;
        }

        public View getView() {
            return view;
        }

        @Override
        public void onClick(View view) {
            if (TVAppAdapter.this.itemClickListener != null) {
                itemClickListener.onClick(view, getLayoutPosition());
            }
        }
    }

    public interface ItemClickListener {
        void onClick(View v, int i);
    }

    public TVAppAdapter(Context context, List<TVApp> data) {
        this.context = context;
        this.data = data;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.adapter_app, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        View view = holder.getView();
        TVApp app = data.get(i);

        ImageView imv = view.findViewById(R.id.imageView);
        // TODO imv.setImageDrawable();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
