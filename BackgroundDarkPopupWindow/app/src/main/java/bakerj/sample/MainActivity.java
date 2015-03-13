package bakerj.sample;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import bakerj.backgrounddarkpopupwindow.BackgroundDarkPopupWindow;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private BackgroundDarkPopupWindow mPopupWindow;
    private TextView mTextView;
    private Button mBtnTop, mBtnBottom, mBtnLeft, mBtnRight, mBtnCenter, mBtnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTop = (Button) findViewById(R.id.top);
        mBtnTop.setOnClickListener(this);
        mBtnBottom = (Button) findViewById(R.id.bottom);
        mBtnBottom.setOnClickListener(this);
        mBtnLeft = (Button) findViewById(R.id.left);
        mBtnLeft.setOnClickListener(this);
        mBtnRight = (Button) findViewById(R.id.right);
        mBtnRight.setOnClickListener(this);
        mBtnCenter = (Button) findViewById(R.id.center);
        mBtnCenter.setOnClickListener(this);
        mBtnAll = (Button) findViewById(R.id.all);
        mBtnAll.setOnClickListener(this);
        mTextView = new TextView(this);
        mTextView.setTextSize(30);
        mTextView.setTextColor(Color.RED);
        mPopupWindow = new BackgroundDarkPopupWindow(mTextView, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top:
                mTextView.setText("top");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.darkBelow(mBtnTop);
                mPopupWindow.showAsDropDown(mBtnTop, mBtnTop.getRight() / 2, 0);
                break;
            case R.id.left:
                mTextView.setText("left");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.darkRightOf(mBtnLeft);
                mPopupWindow.showAtLocation(mBtnLeft, Gravity.CENTER_VERTICAL | Gravity.LEFT, 0, 0);
                break;
            case R.id.right:
                mTextView.setText("right");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000088"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.drakLeftOf(mBtnRight);
                mPopupWindow.showAtLocation(mBtnRight, Gravity.CENTER_VERTICAL | Gravity.RIGHT, 0, 0);
                break;
            case R.id.bottom:
                mTextView.setText("bottom");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0008800"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.darkAbove(mBtnBottom);
                mPopupWindow.showAtLocation(mBtnBottom, Gravity.CENTER_HORIZONTAL, 0, mBtnBottom.getTop());
                break;
            case R.id.center:
                mTextView.setText("center");
                mPopupWindow.setDarkStyle(R.style.MyDarkStyle);
                mPopupWindow.setDarkColor(Color.parseColor("#a0880000"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.drakLeftOf(mBtnRight);
                mPopupWindow.darkRightOf(mBtnLeft);
                mPopupWindow.darkAbove(mBtnBottom);
                mPopupWindow.darkBelow(mBtnTop);
                mPopupWindow.showAtLocation(mBtnCenter, Gravity.CENTER, 0, 0);
                break;
            case R.id.all:
                mTextView.setText("all");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.darkFillScreen();
                mPopupWindow.showAtLocation(mBtnAll, Gravity.CENTER, 0, 0);
                break;
        }
    }
}
