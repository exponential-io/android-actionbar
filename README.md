# Android Toolbar as ActionBar with Material Design

Example Android project for learning how to use a Toolbar as the ActionBar. The ActionBar will be
styled using Material Design.

## Process overview

- Create a new project with that uses **API 14: Android 4.0 (IceCreamSandwich)**. The new project
  should have a blank Activity named `MainActivity`.
- Create `MainFragment` and insert the Fragment into `MainActivity`
- Create `BActivity` and `BFragment`. Insert `BFragment` into `BActivity`.
- Update the theme to disable the default ActionBar.
- Create the ActionBar
- Add menu items to the ActionBar
- Add the ActionBar to `BActivity`
- Add the up button to the ActionBar


## Architecture

- Activity's layout file uses an `&lt;include>` to include the `layouts/actionbar.xml` Toolbar
  layout
- `actionbar.xml` uses sizes defined in `dimens.xml` to set the height of the `ActionBar`. Android
  automatically uses the dimensions defined in `values/dimens.xml` when a device is in portrait mode
  and uses the dimensions defined in `values-land/dimens.xml` when a device is in landscape mode.
- `actionbar.xml` references the themes defined in `styles.xml`. Android automatically applies
  the `values/styles.xml` for devices with API < 21 or `values-v21/styles.xml` for devices with
  API >= 21.
- Both of the `styles.xml` files use colors defined in `values/colors.xml`.

- Activity's layout
    - includes Toolbar layout: `layouts/actionbar.xml`
        - refers to dimensions: `values/dimens.xml` or `values-land/dimens.xml`
        - refers to themes: `values/styles.xml` or `values-v21/styles.xml`
            - refers to colors: `values/colors.xml`

The following table shows the various combinations of `dimens.xml`, `styles.xml` and `colors.xml`.

<table style="border: 1px solid #c0c0c0;">
    <tr>
        <th></th>
        <th>Portrait</th>
        <th>Landscape</th>
    </tr>
    <tr>
        <td>API < 21</td>
        <td>
            values/dimens.xml<br/>
            values/styles.xml<br/>
            values/colors.xml
        </td>
        <td>
            values-land/dimens.xml<br/>
            values/styles.xml<br/>
            values/colors.xml
        </td>
    </tr>
    <tr>
        <td>API >= 21</td>
        <td>
            values/dimens.xml<br/>
            values-v21/styles.xml<br/>
            values/colors.xml
        </td>
        <td>
            values-land/dimens.xml<br/>
            values-v21/styles.xml<br/>
            values/colors.xml
        </td>
    </tr>
</table>


## Update MainActivity

- Change `ActionBarActivity` to `AppCompatActivity`

## Create `MainFragment`

- Create a new blank Fragment named `MainFragment`

### Update `fragment_main.xml`

- Set the TextView to display 'Main Fragment'.
- Change `FrameLayout` to `RelativeLayout`.
- Add a `Button`.

### Update `MainFragment.java`

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

### Update `activity_main.xml`.

- Delete the `TextView`
- Insert a `FrameLayout` in the `RelativeLayout`

### Update `MainActivity` to use `MainFragment`

- Add `implements MainFragment.Callbacks` to the method declaration.
- Override the `displayBActivity` Interface method.
- Create an instance of `MainFragment` in the `onCreate` method and insert it into the Activity


## Create `BActivity`

- Create a new blank Activity named `BActivity`
- `ActionBarActivity` to `AppCompatActivity`


## Create `BFragment`

- Create a new blank Fragment named `BFragment`
- When creating `BActivity`, set the parent to `MainActivity`

### Update `fragment_b.xml`

- Set the TextView to display 'B Fragment'.
- Change `FrameLayout` to `RelativeLayout`.


### Update `BFragment.java`

- Change `ActionBarActivity` to `AppCompatActivity`
- Change `import android.app.Fragment;` to `import android.support.v4.app.Fragment;`.
- Delete the `OnFragmentInteractionListener` Interface.
- Delete `mListener`.
- Delete `ARG_PARAM1` and `ARG_PARAM2`.
- Delete `mParam1` and `mParam1` and `param1` and `param2` from all parts of the code.
- Delete the `Bundle` related code from `newInstance`.
- Delete the `getArguments` related code from `onCreate`.
- Delete the Interface related code from `onAttach`.
- Delete the Interface related code from `onDetach`.
- In `onCreateView`, split the return statement into assignment and return.
- Delete the `onButtonPressed` method.
- Delete all of the `TODO` comments

### Update `activity_b.xml`.

- Delete the `TextView`
- Insert a `FrameLayout` in the `RelativeLayout`

### Update `BActivity` to use `BFragment`

- Create an instance of `BFragment` in the `onCreate` method and insert it into the Activity


## Start `BActivity` in `MainActivity.displayBActivity()`

- Call `startActivity()` in `MainActivity.displayBActivity()`


## Update the theme

We must disable the default `ActionBar` before we can create a `Toolbar` and set it as the
`ActionBar`.

### Colors

- Create `res/values/colors.xml`

### Dimensions

- Update `res/values/dimens.xml`
- Create `res/values-land/dimens.xml`

### Styles

- Update `res/values/styles.xml`
- Create `res/values-v21/styles.xml`

### Set style in `AndroidManifest.xml`

- In `AndroidManifest.xml` change `android:theme="@style/AppTheme"` to
  `android:theme="@style/Exponential.Theme.Colors"`.


## Create the ActionBar

Next, we will create a Toolbar and set it as the ActionBar.

- Create layout/actionbar.xml
    - Set the root element to `android.support.v7.widget.Toolbar`.
    - Add `xmlns:app`
    - Set `android:layout_height="@dimen/actionbar_height"`
    - Add `app:theme`
    - Add `app:popupTheme`

## Set the `Toolbar` as the `ActionBar`

- In `layout/activity_main.xml`, include the `actionbar` layout.
- In `layout/activity_main.xml`, remove all of the padding from `RelativeLayout`.
- In `MainActivity.onCreate()` find the Toolbar and call `setSupportActionBar()`


## Use the ActionBar in `BActivity`

- In `layout/activity_b.xml`, include the `actionbar` layout.
- In `layout/activity_b.xml`, remove all of the padding from `RelativeLayout`.
- In `BActivity.onCreate()` find the Tool   bar and call `setSupportActionBar()`


## Add the up button to the ActionBar

- In `BActivity.onCreate()`, set `getSupportActionBar().setDisplayHomeAsUpEnabled(true);`

ref: https://developer.android.com/training/basics/actionbar/adding-buttons.html
ref: http://developer.android.com/training/implementing-navigation/ancestral.html


## Add option menu items for `MainActivity`

Adding option menu items to an `ActionBar` created via a `Toolbar` is the same as how you would add
items to the default `ActionBar`.

Each Activity can customize the "Actions" displayed in the `ActionBar` by adding `&lt;item>`
elements in it's `menu/menu_activity_name.xml` file.

> Buttons added to the menu should have global applicability, such as **Search**.

There are 3 key steps in defining `ActionBar` actions (aka option menu items):

1. Create an `&lt;item>` element in the Activity's menu xml file
2. Inflate the menu xml file in the Activity's `onCreateOptionsMenu` method (Note: This code is
   generated by Android Studio...so there's nothing to do here)
3. Handle click events for the menu item in the Activity's `onOptionsItemSelected` method

In this example, we will add an action that displays a `Toast` message.

- Add the search icon image asset from the Android Design Icons collection. Use the HOLO_DARK theme
  icons.
- Add an `&lt;item>` to `res/menu/menu_main.xml`.
- Update the Activity's `onOptionsItemSelected` method to handle the click event.

> If your icon is not visible, then it's likely that you selected the wrong theme (i.e. HOLO_LIGHT
> instead of HOLO_DARK).


## Add menu items for `BActivity`

Repeat the same steps to add an option menu item to BActivity's menu. In a production app, you can
support different ActionBar Actions per Activity.


## Additional reading

- ActionBar: http://developer.android.com/guide/topics/ui/actionbar.html
- Toolbar: http://developer.android.com/reference/android/support/v7/widget/Toolbar.html
- Menus: http://developer.android.com/guide/topics/ui/menus.html
- Material Design:
    - http://developer.android.com/training/material/index.html
    - http://www.google.com/design/spec/material-design/introduction.html