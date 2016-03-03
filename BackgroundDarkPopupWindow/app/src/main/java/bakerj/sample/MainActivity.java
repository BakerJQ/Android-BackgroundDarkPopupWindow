package bakerj.sample;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import bakerj.backgrounddarkpopupwindow.BackgroundDarkPopupWindow;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private BackgroundDarkPopupWindow mPopupWindow;
    private TextView mTextView;
    private View mBtnTop, mBtnBottom, mBtnLeft, mBtnRight, mBtnCenter, mBtnAll, mBtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTop = findViewById(R.id.top);
        mBtnTop.setOnClickListener(this);
        mBtnBottom = findViewById(R.id.bottom);
        mBtnBottom.setOnClickListener(this);
        mBtnLeft = findViewById(R.id.left);
        mBtnLeft.setOnClickListener(this);
        mBtnRight = findViewById(R.id.right);
        mBtnRight.setOnClickListener(this);
        mBtnCenter = findViewById(R.id.center);
        mBtnCenter.setOnClickListener(this);
        mBtnAll = findViewById(R.id.all);
        mBtnAll.setOnClickListener(this);
        mBtnView = findViewById(R.id.view);
        mBtnView.setOnClickListener(this);
        mTextView = new TextView(this);
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        mTextView.setBackgroundResource(R.drawable.poppup_bg);
        mTextView.setPadding(10, 10, 10, 10);
        mTextView.setGravity(Gravity.CENTER);
        mPopupWindow = new BackgroundDarkPopupWindow(mTextView, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
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
                mTextView.setText("This is a popupwindow\n\ndark on bottom");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.darkBelow(mBtnTop);
                mPopupWindow.showAsDropDown(mBtnTop, mBtnTop.getRight() / 2, 0);
                break;
            case R.id.left:
                mTextView.setText("This is a popupwindow\n\ndark on right");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.darkRightOf(mBtnLeft);
                mPopupWindow.showAtLocation(mBtnLeft, Gravity.CENTER_VERTICAL | Gravity.LEFT, 0, 0);
                break;
            case R.id.right:
                mTextView.setText("This is a popupwindow\n\ndark on left");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000088"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.drakLeftOf(mBtnRight);
                mPopupWindow.showAtLocation(mBtnRight, Gravity.CENTER_VERTICAL | Gravity.RIGHT, 0, 0);
                break;
            case R.id.bottom:
                mTextView.setText("This is a popupwindow\n\ndark on top");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0008800"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.darkAbove(mBtnBottom);
                mPopupWindow.showAtLocation(mBtnBottom, Gravity.CENTER_HORIZONTAL, 0, mBtnBottom.getTop());
                break;
            case R.id.center:
                mTextView.setText("This is a popupwindow\n\ndark in center");
                mPopupWindow.setDarkStyle(R.style.MyDarkStyle);
                mPopupWindow.setDarkColor(Color.parseColor("#a0880000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.drakLeftOf(mBtnRight);
                mPopupWindow.darkRightOf(mBtnLeft);
                mPopupWindow.darkAbove(mBtnBottom);
                mPopupWindow.darkBelow(mBtnTop);
                mPopupWindow.showAtLocation(mBtnCenter, Gravity.CENTER, 0, 0);
                break;
            case R.id.all:
                mTextView.setText("This is a popupwindow\n\ndark fill all");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.darkFillScreen();
                mPopupWindow.showAtLocation(mBtnAll, Gravity.CENTER, 0, 0);
                break;
            case R.id.view:
                mTextView.setText("This is a popupwindow\n\ndark fill view");
                mPopupWindow.setDarkStyle(-1);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.drakFillView(mBtnView);
                mPopupWindow.showAtLocation(mBtnView, Gravity.CENTER, 0, 0);
                break;
        }
    }
}
