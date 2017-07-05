package pe.elcomercio.slimmenubar;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tohure on 4/07/17.
 */

public class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_MENU = 0;
    private static final int TYPE_LOGO = 1;
    private List<DrawerItem> drawerMenuList;

    public void addData(List<DrawerItem> mDrawerItemList) {
        this.drawerMenuList = mDrawerItemList;
    }

    @Override
    public int getItemViewType(int position) {
        // TODO: De haber otro tipo de vistas agregarlas aquí cambiando de if else a switch
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

            itemHolder.iconMenu.setImageResource(drawerMenuList.get(position).getIcon());
            if (drawerMenuList.get(position).getBadge()>0){
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



    public class DrawerViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iconMenu;
        AppCompatTextView badgeValue;

        public DrawerViewHolder(View itemView) {
            super(itemView);
            iconMenu = (AppCompatImageView) itemView.findViewById(R.id.icon);
            badgeValue = (AppCompatTextView) itemView.findViewById(R.id.lblFilterCount);
        }
    }

    public class DrawerHeaderViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iconMenu;

        public DrawerHeaderViewHolder(View itemView) {
            super(itemView);
            iconMenu = (AppCompatImageView) itemView.findViewById(R.id.icon);
        }
    }
}
