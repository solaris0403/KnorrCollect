package tw.com.knorr.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import tw.com.knorr.R;
import tw.com.knorr.fragment.IndexFragment;
import tw.com.knorr.main.BaseActivity;

public class IndexActivity extends BaseActivity {
    private FragmentManager fm;
    private IndexFragment indexFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        fm = getSupportFragmentManager();
        if (indexFragment == null){
            indexFragment = new IndexFragment();
        }
        fm.beginTransaction().add(R.id.fragment_container, indexFragment).show(indexFragment).commit();
    }
}
