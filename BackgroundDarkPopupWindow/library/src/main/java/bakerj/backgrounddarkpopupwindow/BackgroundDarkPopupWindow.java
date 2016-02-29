package bakerj.backgrounddarkpopupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

/**
 * @author BakerJ
 */
public class BackgroundDarkPopupWindow extends PopupWindow {

    private View mDarkView;
    private WindowManager.LayoutParams mDarkLP;
    private WindowManager mWindowManager;
    private int mScreenWidth, mScreenHeight;
    private int mRightOf, mLeftOf, mBelow, mAbove;
    private int[] mLocationInWindowPosition = new int[2];
    private int mDarkStyle = -1;

    public BackgroundDarkPopupWindow(View contentView, int width, int height) {
        super(contentView, width, height);
        if (contentView != null) {
            mWindowManager = (WindowManager) contentView.getContext().getSystemService(Context.WINDOW_SERVICE);
            mDarkLP = createDarkLayout(contentView.getWindowToken());
            mDarkView = new View(contentView.getContext());
            mDarkView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            mDarkView.setBackgroundColor(Color.parseColor("#a0000000"));
            DisplayMetrics dm = new DisplayMetrics();
            mWindowManager.getDefaultDisplay().getMetrics(dm);
            mScreenWidth = dm.widthPixels;
            mScreenHeight = dm.heightPixels;
        }
    }

    /**
     * create dark layout
     * @param token
     * @return
     */
    private WindowManager.LayoutParams createDarkLayout(IBinder token) {
        WindowManager.LayoutParams p = new WindowManager.LayoutParams();
        p.gravity = Gravity.START | Gravity.TOP;
        p.width = WindowManager.LayoutParams.MATCH_PARENT;
        p.height = WindowManager.LayoutParams.MATCH_PARENT;
        p.format = PixelFormat.TRANSLUCENT;
        p.flags = computeFlags(p.flags);
        p.type = WindowManager.LayoutParams.LAST_SUB_WINDOW;
        p.token = token;
        p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
        return p;
    }

    private int computeFlags(int curFlags) {
        curFlags &= ~(
                WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES |
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                        WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM |
                        WindowManager.LayoutParams.FLAG_SPLIT_TOUCH);
        curFlags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        curFlags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        return curFlags;
    }

    /**
     * get dark animation
     * @return
     */
    private int computeDarkAnimation() {
        if (mDarkStyle == -1) {
            return R.style.DarkAnimation;
        }
        return mDarkStyle;
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        invokeBgCover();
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        invokeBgCover();
        super.showAtLocation(parent, gravity, x, y);
    }

    /**
     * show dark background
     */
    private void invokeBgCover() {
        if (isShowing() || getContentView() == null) {
            return;
        }
        if (mDarkView != null) {
            computeDarkLayout();
            mDarkLP.windowAnimations = computeDarkAnimation();
            mWindowManager.addView(mDarkView, mDarkLP);
        }
    }

    /**
     * reset dark position
     */
    private void computeDarkLayout() {
        mDarkLP.x = mRightOf;
        mDarkLP.y = mBelow;
        mDarkLP.width = mLeftOf - mRightOf;
        mDarkLP.height = mAbove - mBelow;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (mDarkView != null) {
            mWindowManager.removeViewImmediate(mDarkView);
        }
    }

    /**
     * set dark color
     * @param color
     */
    public void setDarkColor(int color) {
        if (mDarkView != null) {
            mDarkView.setBackgroundColor(color);
        }
    }

    /**
     * fill screen
     */
    public void darkFillScreen() {
        mRightOf = 0;
        mLeftOf = mScreenWidth;
        mAbove = mScreenHeight;
        mBelow = 0;
    }

    /**
     * dark right of target view
     * @param view
     */
    public void darkRightOf(View view) {
        view.getLocationInWindow(mLocationInWindowPosition);
        mRightOf = mLocationInWindowPosition[0] + view.getWidth();
    }

    /**
     * dark left of target view
     * @param view
     */
    public void drakLeftOf(View view) {
        view.getLocationInWindow(mLocationInWindowPosition);
        mLeftOf = mLocationInWindowPosition[0];
    }

    /**
     * dark above target view
     * @param view
     */
    public void darkAbove(View view) {
        view.getLocationInWindow(mLocationInWindowPosition);
        mAbove = mLocationInWindowPosition[1];
    }

    /**
     * dark below target view
     * @param view
     */
    public void darkBelow(View view) {
        view.getLocationInWindow(mLocationInWindowPosition);
        mBelow = mLocationInWindowPosition[1] + view.getHeight();
    }

    /**
     * get dark anim style
     * @return
     */
    public int getDarkStyle() {
        return mDarkStyle;
    }

    /**
     * set dark anim style
     * @param darkStyle
     */
    public void setDarkStyle(int darkStyle) {
        this.mDarkStyle = darkStyle;
    }
}
