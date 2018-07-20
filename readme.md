# Custom Array Adapter

Simple Kotlin Library to help create custom array adapters for views like spinners

Read [Customer Array Adapter](https://android.jlelse.eu/creating-custom-array-adapters-in-android-a-better-way-dc492c89512https://android.jlelse.eu/creating-custom-array-adapters-in-android-a-better-way-dc492c89512) for reasons, see sample code for too

# Setup

## Gradle
```
implementation "co.enoobong:customarrayadapter:$custom_array_adapter_version"
```

## Usage
1. Make your model class that you intend to display in adapter implement `ModelDisplayName`. This will require you to override the `displayName` property; which is the value that will be displayed in your adapter.
2. In your `Activity` or `Fragment` where you use the `AdapterView` set it's adapter to `CustomArrayAdapter(context, layoutResource, listOfValues)` eg

```kotlin
spinner.adapter = CustomArrayAdapter(context, android.R.layout.simple_spinner_item, values = listOfValues)
```

# Contributing


I'm more than welcome to contributions that improve the library and make it easier to use.
If you are willing to contribute to the project feel free to make a fork and submit a pull request.
You can hit me up on [@IEnoobong](http://twitter.com/IEnoobong) on Twitter

# Donate

Want to buy me Jollof-Rice? Send here's my link https://payme.ng/ienoobong Thanks