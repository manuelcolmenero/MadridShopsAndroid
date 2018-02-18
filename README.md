# **Práctica Android Avanzado**
## **KeepCoding Startup Engineering Master V (2018)**
- - -

## **Synopsis**
Create a mobile application to display information of shops and activities in Madrid, even when the user has no Internet connection. shops and activities should be shown in a Map.

## **Requeriments**
1. When starting the App for the first time, if there's Internet connection it will download all information from the shops and activities access point (see below), including all images.
1. The App will cache everything locally: images, data, etc. Even images of the maps. See below for tips
1. Cache is never invalidated, so once everything has been saved, set a flag and never ever access to the network again
1. If there's no Internet connection a message will be shown to the user.
1. While caching the App will show an Activity indicator or other loader. Until you finish caching you don't get to the Main menu.
1. The app will have a main menu screen where we'll add one button & a logo. The button takes us to the list of shops and activities.
1. The list of shops and activities will show in the upper 50% screen a map with one pin for each event.
1. The list of shops and activities will show in the lower 50% screen. Logo to the left, background image taking all the row, event name in the front. Tapping a row takes us to the detail event screen.
1. All info should be read from a Core Data database
1. If you tap on a pin in the map a callout will open with the logo + event name. Taping the callout takes us to the detail event screen.
1. The map will be always centered in madrid, showing also the user location
1. All data is at least in Spanish & English: should cache all and display in Spanish (if that's our phone's language) or English otherwise
1. Event detail screen should show event name, description, address, and a map showing the shops and activities location without any pin

## **Extra requeriments**
1. Use a git repository to track your code as you go along.
1. To persist information while you're offline use Core Data! You can cache the images using any technique you like (Core Data, a library, archiving files, etc.)
1. Clean architecture would be nice: interactors, managers, etc.
1. Test: model, DAOs

## **Web services**

```sh
Url Map Cache "https://maps.googleapis.com/maps/api/staticmap?%25&size=320x220&scale=2&markers="
Url Activities API "https://madrid-shops.com/json_new/getActivities.php"
Url Shops API "https://madrid-shops.com/json_new/getShops.php"
```

## **Technology**
* Android Studio 3.0.1
* Kotlin
* Sqlite
* GoogleMaps
* [Picasso](http://square.github.io/picasso/)

## Setup
```
$ mkdir MadridShops
$ cd MadridShops
$ git clone https://github.com/manuelcolmenero/MadridShopsAndroid.git
```

You need to create a file within the project folder `values` with the following structure
```sh
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="GOOGLE_MAPS_API_KEY">GOOGLE_MAPS_API_KEY</string>
</resources>
```

## Screenshots
Main | Download | List | Detail
------------ | ------------- | ------------- | -------------
<img src = "https://github.com/manuelcolmenero/MadridShopsAndroid/blob/master/screenshots/Main.png" width="250px"> | <img src = "https://github.com/manuelcolmenero/MadridShopsAndroid/blob/master/screenshots/Download.png" width="250px"> | <img src = "https://github.com/manuelcolmenero/MadridShopsAndroid/blob/master/screenshots/List.png" width="250px"> | <img src = "https://github.com/manuelcolmenero/MadridShopsAndroid/blob/master/screenshots/Detail.png" width="250px">
