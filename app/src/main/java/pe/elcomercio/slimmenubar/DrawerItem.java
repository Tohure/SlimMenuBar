package pe.elcomercio.slimmenubar;

/**
 * Created by tohure on 4/07/17.
 */

public class DrawerItem {

    private String title;
    private int iconActivate;
    private int iconDeactivate;
    private int badge;
    private boolean selected;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconActivate() {
        return iconActivate;
    }

    public void setIconActivate(int iconActivate) {
        this.iconActivate = iconActivate;
    }

    public int getIconDeactivate() {
        return iconDeactivate;
    }

    public void setIconDeactivate(int iconDeactivate) {
        this.iconDeactivate = iconDeactivate;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}