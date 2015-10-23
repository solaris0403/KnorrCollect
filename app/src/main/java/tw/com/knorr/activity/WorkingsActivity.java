package tw.com.knorr.activity;

import android.os.Bundle;

import tw.com.knorr.R;
import tw.com.knorr.fragment.WorkingsFragment;
import tw.com.knorr.main.BaseActivity;

/**
 * 活动办法
 */
public class WorkingsActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workings);
        showFragment(R.id.fragment_container, new WorkingsFragment());
    }
}
