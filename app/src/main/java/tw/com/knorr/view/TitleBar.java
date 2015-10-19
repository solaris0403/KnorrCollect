package tw.com.knorr.view;

import android.content.Context;
import android.view.View;

/**
 * Common title bar
 */
public class TitleBar{
   private Context mContext;
   private View mView;
   private View mBtnBack;
   private String mTitle;
   private View mBtnOther;

   public TitleBar(Context context, View view){
      this.mContext = context;
      this.mView = view;
   }
   public TitleBar setTitle(String title){
      this.mTitle = title;
      return this;
   }
   public TitleBar setBackButton(){
      return this;
   }
   public void build(){

   }
}
