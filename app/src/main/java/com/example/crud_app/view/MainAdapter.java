package com.example.crud_app.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud_app.R;
import com.example.crud_app.entity.DataMovie;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
   Context context;
   List<DataMovie> list;
   MainContact.view mView;

   public MainAdapter(Context context, List<DataMovie> list, MainContact.view mView){
       this.context = context;
       this.list = list;
       this.mView = mView;
   }

    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
       View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
       return new viewHolder(view);
    }

    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
       final DataMovie item = list.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvGenre.setText(item.getGenre());
        holder.tvYear.setText(item.getYear());
        holder.tvCast.setText(item.getCast());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mView.deleteData(item);
                return true;
            }
        });
    }

    public int getItemCount() {
       return  list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvGenre, tvYear, tvCast, id;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvCast = itemView.findViewById(R.id.tvCast);
            cardView = itemView.findViewById(R.id.cv_item);
        }

   }
}
