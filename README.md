# Android HackPack Tutorial

### Overview
For the Android Hackpack, we are going to develop **HackerPad** - A Simple Note taking application. In this tutorial, you'll learn basic process behind making android apps such as developing an UI, storing data locally, opening activity from another activity and much more. 
So Let's get started!

### Create an Android Project
* If you don't have [Android Project](https://developer.android.com/studio/) installed on your computer, install it from [here](https://developer.android.com/studio/).

* In the **Welcome to Android Studio** window, click **Start a new Android Studio project**.
![Android Studio](/docs_assets/as.png)
Or if you have a project opened, select **File > New Project**.

* In the **Create New Project** window, enter the following values.
	* **Application Name** : "HackerPad"
	* **Company Domain** : "your_name.io"
	Leave the other options as they are.
	
* For all the other setup screens **select default values** and hit next.

After some processing, Android Studio opens the IDE.

![](/docs_assets/fs.png)

Now let's take a moment to review the most important files.

First, be sure the **Project window is open (select View > Tool Windows > Project)** and the Android view is selected from the drop-down list at the top of that window. You can then see the following files:

**app > java > com.example.myfirstapp > MainActivity**
This is the main activity (the entry point for your app). When you build and run the app, the system launches an instance of this Activity and loads its layout.

**app > res > layout > activity_main.xml**
This XML file defines the layout for the activity's UI. It contains a TextView element with the text "Hello world!".

**app > manifests > AndroidManifest.xml**
The manifest file describes the fundamental characteristics of the app and defines each of its components.

**Gradle Scripts > build.gradle**
You'll see two files with this name: one for the project and one for the "app" module. Each module has its own build.gradle file, but this project currently has just one module. You'll mostly work with the module's build.gradle file to configure how the Gradle tools compile and build your app. 

### Run the "Hello World" app
Press the run button (circled in following figure) and you will see a hello world written in middle of screen. You will need to add a emulator/device to run the app. Just follow the default steps to add emulator or plug your android device using usb.
![](/docs_assets/run.png)

### Now Let's Start Building our Note Taking App - *HackerPad*



















