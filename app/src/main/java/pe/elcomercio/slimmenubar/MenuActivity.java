package pe.elcomercio.slimmenubar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerAdapter.OnItemClickListener, DrawerAdapter.OnHeadClickListener {

    private List<DrawerItem> mDrawerItemList;
    private RecyclerView drawerRecyclerView;
    private Toast toast;
    private DrawerLayout drawer;
    private DrawerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerRecyclerView = (RecyclerView) findViewById(R.id.drawerRecyclerView);

        populateMenu();
    }

    private void populateMenu() {
        mDrawerItemList = new ArrayList<>();

        DrawerItem item0 = new DrawerItem();
        item0.setTitle("Home");
        item0.setBadge(0);
        mDrawerItemList.add(item0);

        DrawerItem item = new DrawerItem();
        item.setIconActivate(R.drawable.ic_menu_item_active);
        item.setIconDeactivate(R.drawable.ic_menu_item_deactive);
        item.setTitle("Home");
        item.setBadge(0);
        mDrawerItemList.add(item);

        DrawerItem item2 = new DrawerItem();
        item2.setIconActivate(R.drawable.ic_bell_activate);
        item2.setIconDeactivate(R.drawable.ic_bell_deactivate);
        item2.setTitle("Notification");
        item2.setBadge(2);
        mDrawerItemList.add(item2);

        DrawerItem item3 = new DrawerItem();
        item3.setIconActivate(R.drawable.ic_heart_activate);
        item3.setIconDeactivate(R.drawable.ic_heart_deactivate);
        item3.setTitle("Favorite");
        item3.setBadge(0);
        mDrawerItemList.add(item3);

        DrawerItem item4 = new DrawerItem();
        item4.setIconActivate(R.drawable.ic_alarm_activate);
        item4.setIconDeactivate(R.drawable.ic_alarm_deactivate);
        item4.setTitle("Alarm");
        item4.setBadge(0);
        mDrawerItemList.add(item4);

        DrawerItem item5 = new DrawerItem();
        item5.setIconActivate(R.drawable.ic_setup_activate);
        item5.setIconDeactivate(R.drawable.ic_setup_deactivate);
        item5.setTitle("Setup");
        item5.setBadge(0);
        mDrawerItemList.add(item5);

        adapter = new DrawerAdapter();
        adapter.addData(mDrawerItemList);
        adapter.setSelected(1);

        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        drawerRecyclerView.setHasFixedSize(true);
        drawerRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this);
        adapter.setOnHeadClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        /*int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemMenuClick(DrawerItem drawerItem, int adapterPosition) {
        adapter.setSelected(adapterPosition);
        adapter.setBadge(2,0);
        if (toast != null) toast.cancel();
        toast = Toast.makeText(this, drawerItem.getTitle()+" / "+drawerItem.getBadge()+" ---------- "+mDrawerItemList.get(adapterPosition).getBadge(), Toast.LENGTH_SHORT);
        toast.show();
        closeNavigationDrawer();
    }

    public void closeNavigationDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onHeadClick() {
        closeNavigationDrawer();
    }
}
