# Android Toolbar as ActionBar with Material Design

Example Android project for learning how to use a Toolbar as the ActionBar. The ActionBar will be
styled using Material Design.

## Process overview

- Create a new project with that uses **API 14: Android 4.0 (IceCreamSandwich)**. The new project
  should have a blank Activity.
- Create `MainFragment` and insert the Fragment into `MainActivity`
- Create the ActionBar
- Add menu items to the ActionBar
- Create the CreateCompanyActivity
- Add the ActionBar to the CreateCompanyActivity
- Add the up button to the ActionBar

## Update MainActivity

- Change `ActionBarActivity` to `AppCompatActivity`

## Create `MainFragment`

- View

## Create `BActivity`

- Change `ActionBarActivity` to `AppCompatActivity`

## Create `BFragment`

-

## Create the ActionBar

We're going to create a Toolbar and set it as the ActionBar.

- Create theme files:
    - `res/values/styles.xml`
    - `res/values-land/styles.xml`
    - `res/values-v21/styles.xml`
- Create the dimens, colors and attrs resource files
    -
- Create layout/actionbar.xml
- in Activity.onCreate() find toolbar and call setSupportActionBar()
- Create strings, dimens, etc. resources
- update the layout structure of layout/activity_main.xml
    - include app bar in main_activity.xml