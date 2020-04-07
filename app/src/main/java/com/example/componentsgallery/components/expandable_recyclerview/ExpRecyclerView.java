package com.example.componentsgallery.components.expandable_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.componentsgallery.R;

import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by nikolas on 24/12/2018.
 */

public class ExpRecyclerView extends RecyclerView.Adapter<ExpRecyclerView.UserViewHolder> {

    private int focusedItem = 0;
    private HashMap<Integer, Boolean> expandableItemsMap = new HashMap<>();
    private List<Item> data;

    public ExpRecyclerView(List<Item> data) {
        this.data = data;
    }

    @Override
    public ExpRecyclerView.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recycler_view_item, parent, false);

        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ExpRecyclerView.UserViewHolder holder, final int i) {
        if (holder instanceof UserViewHolder) {
            final UserViewHolder viewHolder = (UserViewHolder) holder;

            viewHolder.itemView.setSelected(focusedItem == i);
            try {
                viewHolder.txtDate.setText(data.get(i).getDate());
                viewHolder.txtLocation.setText(data.get(i).getLocation());
                viewHolder.txtEndDate.setText(data.get(i).getEndDate());
                viewHolder.txtStartDate.setText(data.get(i).getStartDate());

                // visibility
                final boolean isVisible = expandableItemsMap.containsKey(i) && expandableItemsMap.get(i);
                viewHolder.container.setVisibility(isVisible ? View.VISIBLE : View.GONE);
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
        }

    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView txtLocation;
        TextView txtStartDate;
        TextView txtEndDate;
        TextView txtDate;
        TextView txtTitle;
        View expBar;
        View container;

        public UserViewHolder(View view) {
            super(view);
            txtDate = (TextView) itemView.findViewById(R.id.txt_date);
            txtEndDate = (TextView) itemView.findViewById(R.id.txt_end_date);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtStartDate = (TextView) itemView.findViewById(R.id.txt_start_date);
            txtLocation = (TextView) itemView.findViewById(R.id.txt_location);
            expBar = itemView.findViewById(R.id.exp_bar);
            container = itemView.findViewById(R.id.view_container);

           expBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    if (container.getVisibility() == View.VISIBLE){
                        ExpandAnim.collapse(container);
                        expandableItemsMap.put(position, false);
                    }else{
                        ExpandAnim.expand(container);
                        expandableItemsMap.put(position, true);
                    }
                }
            });
        }
    }
}