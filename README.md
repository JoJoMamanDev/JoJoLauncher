
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

# JoJo Launcher 


  - For Samsung Tablets 
  - Tested & Working On Android 8.1.0




### Add a new app

#### Get App Icon Using Package Name
* Get the app package name using app from Google Play called 'Package Names Viewer'. 
* Package name will be in the format com.something.whatever
* You will need both the long and short versions 

Paste the following code in MainActivity.java under the comment 'Set Icons'.
Replace com.something.whatever.appname with the package name you acquired from previous step 

```sh
 ImageView mailIcon = (ImageView) findViewById(R.id.imageViewEmail);
        mailIcon.setImageDrawable(getActivityIcon(this,"com.something.whatever.appname","com.something.whatever.appname.MainActivity"));
```

#### Create Button Action
Paste the following code under  'Button Actions' comment 

* Replace '*AppName*' with the name of your app 
* Replace com.whatever with the package name of your app

```sh
 public void on*AppName*ButtonClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatever");
        startActivity(launchIntent);
    }
```

#### ContentMain.xml

* Within ContentMain.xml
You will need to create an imageView with a Height & Width of 75dp, Then in the imageView onClick you shuld select your button function you created in the previous step.

** You will need to repeat this step within ContentMain.xml (land)




