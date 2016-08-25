package example.saadat.com.ewldemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Tarana on 8/22/2016.
 */
public class CartActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.cart);
    }
}
