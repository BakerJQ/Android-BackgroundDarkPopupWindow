# Android-BackgroundDarkPopupWindow
Android PopupWindow with dark background

## Screenshot
![](https://github.com/BakerJQ/Android-BackgroundDarkPopupWindow/raw/master/Screenshots/show.gif)

## How to use
### Init
Just use it as the same as the original PopupWindow
```java
mPopupWindow = new BackgroundDarkPopupWindow(mTextView, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
mPopupWindow.setFocusable(true);
mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
```
#### Set dark layer
```java
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
```

