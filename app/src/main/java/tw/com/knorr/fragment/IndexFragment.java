package tw.com.knorr.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tw.com.knorr.R;
import tw.com.knorr.activity.MainActivity;
import tw.com.knorr.activity.WorkingsActivity;

/**
 * 初始界面
 */
public class IndexFragment extends Fragment {
    private Button mBtnScan, mBtnNews, mBtnActivity, mBtnAccount, mBtnRedeem, mBtnCookbook;
    public static final String TAB = "tab";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtnScan = (Button) getView().findViewById(R.id.btn_index_scan);
        mBtnNews = (Button) getView().findViewById(R.id.btn_index_news);
        mBtnActivity = (Button) getView().findViewById(R.id.btn_index_activity);
        mBtnAccount = (Button) getView().findViewById(R.id.btn_index_account);
        mBtnRedeem = (Button) getView().findViewById(R.id.btn_index_redeem);
        mBtnCookbook = (Button) getView().findViewById(R.id.btn_index_cookbook);

        mBtnScan.setOnClickListener(listener);
        mBtnNews.setOnClickListener(listener);
        mBtnActivity.setOnClickListener(listener);
        mBtnAccount.setOnClickListener(listener);
        mBtnRedeem.setOnClickListener(listener);
        mBtnCookbook.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(IndexFragment.this.getActivity(), MainActivity.class);
                switch (v.getId()){
                    case R.id.btn_index_scan:
                        intent.putExtra(TAB, 0);
                        break;
                    case R.id.btn_index_news:
                        intent.putExtra(TAB, 4);
                        break;
                    case R.id.btn_index_activity:
                        intent = new Intent(IndexFragment.this.getActivity(), WorkingsActivity.class);
                        break;
                    case R.id.btn_index_account:
                        intent.putExtra(TAB, 1);
                        break;
                    case R.id.btn_index_redeem:
                        intent.putExtra(TAB, 2);
                        break;
                    case R.id.btn_index_cookbook:
                        intent.putExtra(TAB, 3);
                        break;
                    default:
                        break;
                }
            startActivity(intent);
        }
    };
}
