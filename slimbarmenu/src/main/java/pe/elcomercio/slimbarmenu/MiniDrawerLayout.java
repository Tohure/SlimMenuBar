package pe.elcomercio.slimbarmenu;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * Created by tohure on 4/07/17.
 */

public class MiniDrawerLayout extends DrawerLayout {

    public MiniDrawerLayout(Context context) {
        super(context);
    }

    public MiniDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0,0);
    }

    public MiniDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,defStyle,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MiniDrawerLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,defStyleAttr,defStyle);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyle) {

    }


}
