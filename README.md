
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

# JoJo Launcher 


  - For Samsung Tablets 
  - Tested & Working On Android 8.1.0




### Add a new app

* Get the app package name using app from Google Play called 'Package Names Viewer'. 
* Package name will be in the format com.something.whatever
* You will need both the long and short versions 

Paste the following code in MainActivity.java under the comment 'Set Icons'. 
Replace com.something.whatever.appname with the package name you acquired from previous step 



```sh
 ImageView mailIcon = (ImageView) findViewById(R.id.imageViewEmail);
        mailIcon.setImageDrawable(getActivityIcon(this,"com.something.whatever.appname","com.something.whatever.appname.MainActivity"));
```

Paste the following code under  'Button Actions' comment 

```sh
$
```
