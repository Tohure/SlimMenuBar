package pe.elcomercio.slimmenubar;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tohure on 4/07/17.
 */

public class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_MENU = 0;
    private static final int TYPE_LOGO = 1;
    private List<DrawerItem> drawerMenuList;

    //Listener for onClick in Item Menu adapter
    private DrawerAdapter.OnItemClickListener listener;
    interface OnItemClickListener { void onItemMenuClick(DrawerItem item, int adapterPosition); }
    void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    //Listener for onClick in Item Heaer Menu
    private DrawerAdapter.OnHeadClickListener listenerHeader;
    interface OnHeadClickListener { void onHeadClick(); }
    void setOnHeadClickListener(OnHeadClickListener listener) { this.listenerHeader = listener; }

    public void addData(List<DrawerItem> mDrawerItemList) {
        /*drawerMenuList.clear();
        drawerMenuList.addAll(mDrawerItemList);
        notifyDataSetChanged();*/
        this.drawerMenuList = mDrawerItemList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_LOGO;
        }else{
            return TYPE_ITEM_MENU;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_ITEM_MENU){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
            return new DrawerViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logo_menu, parent, false);
            return new DrawerHeaderViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM_MENU){
            DrawerViewHolder itemHolder = (DrawerViewHolder) holder;

            if (drawerMenuList.get(position).isSelected()){
                itemHolder.iconMenu.setImageResource(drawerMenuList.get(position).getIconActivate());
            }else{
                itemHolder.iconMenu.setImageResource(drawerMenuList.get(position).getIconDeactivate());
            }

            if (drawerMenuList.get(position).getBadge()>0){
                itemHolder.badgeValue.setVisibility(View.VISIBLE);
                itemHolder.badgeValue.setText(String.valueOf(drawerMenuList.get(position).getBadge()));
            }else{
                itemHolder.badgeValue.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }


    public void setSelected(int position)
    {
        for (int i = 0; i < drawerMenuList.size(); i++) {
            drawerMenuList.get(i).setSelected(i == position);
        }

        this.notifyDataSetChanged();
    }

    public void setBadge(int position,int newBadge)
    {
        drawerMenuList.get(position).setBadge(newBadge);

        this.notifyDataSetChanged();
    }

    public class DrawerViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iconMenu;
        AppCompatTextView badgeValue;

        public DrawerViewHolder(View itemView) {
            super(itemView);
            iconMenu = itemView.findViewById(R.id.icon);
            badgeValue = itemView.findViewById(R.id.lblFilterCount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemMenuClick(drawerMenuList.get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }
    }

    public class DrawerHeaderViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iconMenu;

        public DrawerHeaderViewHolder(View itemView) {
            super(itemView);
            iconMenu = itemView.findViewById(R.id.icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenerHeader.onHeadClick();
                }
            });
        }
    }
}