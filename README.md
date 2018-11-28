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

**app > java > io.your_name.hackerpad > MainActivity**
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



## Now Let's Start Building our Note Taking App - *HackerPad*

Let's define our app design. It will be two activity application - 

- **MainActivity**: This will show the list of all the notes already added and also will include a button to add a new note. Finally, it would look like this - 

  ![](/docs_assets/mnaT.png) 

- **NotesActivity**: This will be the details activity where title and details of note can be added. Finally, it would look like this - 

  ![](/docs_assets/ntact.png)

### Lets build our User Interface (UI)

UI in android is build by using Design editor (Preferred way) or by using text editor. All the UI in android is declared using XML and can be found in **app > res > layout**.

Edit **app > res > layout > activity_main.xml ** as follows and let's see what we are doing

```html
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.MainActivity">

    <ListView
        android:id="@+id/noteListView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </ListView>

    <android.support.v7.widget.CardView xmlns:card_view="http://schemas.android.com/apk/res-auto"
        android:id="@+id/card_view"
        android:layout_width="match_parent"
        android:layout_height="@dimen/cardview_height"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        card_view:cardCornerRadius="4dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.982">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/takeNote"
                android:layout_width="269dp"
                android:layout_height="44dp"
                android:layout_margin="2dp"
                android:layout_weight="3"
                android:gravity="center_vertical|start"
                android:padding="2dp"
                android:text="@string/add_note_placeholder"
                android:textColor="@color/gray"
                android:textSize="14sp" />

            <ImageView
                android:id="@+id/takeAudioNoteView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="2dp"
                android:layout_weight="1"
                android:adjustViewBounds="true"
                android:contentDescription="@string/audio_note_placeholder"
                android:cropToPadding="false"
                android:tint="@color/colorPrimary"
                android:padding="2dp"
                android:scaleType="center"
                android:visibility="visible"
                app:srcCompat="@drawable/ic_action_name" />
        </LinearLayout>
    </android.support.v7.widget.CardView>
</android.support.constraint.ConstraintLayout>
```

In this layout, we have added a **\<ListView> tag** which is a view that can show list of elements in scrollable fashion. (Note that presently Google recommend **\<RecyclerView>** for showing scrollable list, but for simplicity sake, we are using ListView and also it fulfills our purpose easily.) We will use ListView to show list of already added notes and we have given it **id as noteListView** so as to get its reference later.

Also there is **card view widget** added which includes a **Linear Layout** which layouts its children in linear fashion. This part of code builds our **Take a Note** action button along with **Speech icon**.  All these codes are generated using design editor which is a simple intuitve drag and drop editor for building UI.

Similary, for notes activity, create a new activity by **File > New > Activity > Empty Activity** , name the activity to NotesAcitivity and selecting all the other default values. This will generate two files:-

- **NotesActivity.java** in app > java > io.your_name.hackerpad 
- **activity_notes** in app > res > layout

Edit activity_notes with this repository's activity_notes file. Its a simple layout file with two field to take user inputs as title & note along with a button to add/update the note.

































