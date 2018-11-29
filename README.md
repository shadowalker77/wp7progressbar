# Windows Phone Awsome Progress Bar
This library aims to bring awsome windows phone 7 and windows 10 progress bar to android applications. Here is the example:

Windows 10                 |  Windows Phone 7
:-------------------------:|:-------------------------:
![](https://github.com/shadowalker77/wp7progressbar/raw/master/ScreenShots/wp10.gif)  |  ![](https://github.com/shadowalker77/wp7progressbar/raw/master/ScreenShots/wp7.gif)

Add jitPack maven to your project level repositories:
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
Then put this line in your module level gradle:
```
implementation 'com.github.shadowalker77:wp7progressbar:1.0.4'
```
Now you can use these two awesome progress bar:

  - WP7ProgressBar
  - WP10ProgressBar

# WP7ProgressBar
Add this lines to your layout:
```
<ir.alirezabdn.wp7progress.WP7ProgressBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
# WP10ProgressBar
Add this lines to your layout:
```
<ir.alirezabdn.wp7progress.WP10ProgressBar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```
# Customization
Features of both of these views can be customzied, for example for WP7ProgressBar:
```
<ir.alirezabdn.wp7progress.WP7ProgressBar
        android:id="@+id/wp7progressBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        app:animationDuration="2300"
        app:indicatorColor="@color/colorProgressBar"
        app:indicatorHeight="7"
        app:indicatorRadius="5"
        app:interval="100" />
```
# Show and Hide them
There are two methods which you will use to show and hide these views. For both of them, in your java code:
```
WP7ProgressBar progressBar = findViewById(R.id.progressBar);
// for showing
progressBar.showProgressBar();
// for hiding
progressBar.hideProgressBar();
```
# Extra Feature
You can use these progress bars for api calls easly. How? 

   - Parallel API call:
In case of parallel api call, if you call showProgressBar() method x times, you have to call hideProgressBar() method x times as well. So progress bar will continue to show until you call exactly x time.
   - Series API call:
In this case, if you call hideProgressBar() method then call showProgressBar() method after that immediately, progress bar will not hide and show itself in order to give user a better experience.
# Contact
If you had any question or problem, please do not hesitate to contact me:
email address: alireza.bdn@gmail.com
