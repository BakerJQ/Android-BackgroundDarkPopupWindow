# Android-BackgroundDarkPopupWindow
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

Android PopupWindow with dark background

## Screenshot
![](https://github.com/BakerJQ/Android-BackgroundDarkPopupWindow/raw/master/Screenshots/show.gif)

## Gradle via JCenter
``` groovy
compile 'com.bakerj:backgrounddark-popupwindow:1.0.0'
```

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
### *License*

BackgroundDarkPopuoWindow is released under the [Apache 2.0 license](license.txt).

```
Copyright 2017 BakerJ.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at following link.

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
