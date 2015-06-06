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

### Update `fragment_main.xml`

- Set the TextView to display 'Main Fragment'.
- Change `FrameLayout` to `RelativeLayout`.
- Add a `Button`.

### Create the Fragment

- Create a new blank Fragment named `MainFragment`
- Change `import android.app.Fragment;` to `import android.support.v4.app.Fragment;`
- Change `OnFragmentInteractionListener` to `Callbacks`
- Change `mListener` to `callbacks`
- Change `ARG_PARAM1` to `ARG_MESSAGE` and set the value to `MainFragment.MESSAGE`
- Change `mParam1` to `message`
- In `onCreateView`, split the return statement into assignment and return.
- Delete the `onButtonPressed` method.
- Change the Callbacks Interface method name to `displayBActivity`.
- Delete `param2` and associated constants, local variables, everywhere in the Fragment.
- Delete all of the `TODO` comments
- Set the click listener for the `Button` in `fragment_main.xml`. Call the `displayBActivity` method
  when the button is clicked.


## Update `activity_main.xml`.

- Delete the `TextView`
- Insert a `FrameLayout` in the `RelativeLayout`

### Update `MainActivity` to use `MainFragment`

- Add `implements MainFragment.Callbacks` to the method declaration.
- Override the `displayBActivity` Interface method.
- Create an instance of `MainFragment` in the `onCreate` method and insert it into the Activity

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