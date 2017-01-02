# Mobile Contacts Library

This application demonstrates the "MobileContactsLib", The library uses the "ContentResolver", it is a well structured, fast, easy to use and easy to modify library for getting contacts from the mobile. This library requires minimum SDK 15.

Images from the app:

<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Screenshot_ContactList.png" width="240"/> &#160;
<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Screenshot_ContactDetails.png" width="240"/>

The sample app for Android Utilities Library is available on Google Play:

<a href='https://play.google.com/store/apps/details?id=jagerfield.mobilecontactslibrary'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="150" height="60"/></a>

## Installation

In the app manifest file add this permission: 

  ```
  <uses-permission android:name="android.permission.READ_CONTACTS" />
  ``` 
In the app build.gradle add the following:

  a. Add JitPack repository at the end of repositories 

```
    repositories {
      maven { url 'https://jitpack.io' }
    }
 ```
 
  b. Then add this dependency
 
```
    dependencies {
	        compile 'com.github.Jagerfield:Mobile-Contacts-Library:v1.4'
	}
```

## How to use?

1. After instaling the library, declare and instantiate an object of type "ImportContacts" class with "context" as an argument.
2. Call the getContacts() method to get all the contacts.

  ```
  /**
   * Declare and instantiate an object of the "ImportContacts" class
   */
    ImportContacts importContacts = new ImportContacts(context);

  /**
   * Fetch mobile contacts list
   */
    ArrayList<Contact> listItem = importContacts.getContacts();
  ```

## Available Contact elements:

  ```
  1. Name: 
    a. Displaydname
    b. Firstname
    c. Lastname
  2. Nickname: 
    a. Nickname
    b. Nicknametype
  3. Number: 
    a. Number
    b. Normalizednumber
    c. Numbertype
  4. Email: 
    a. Email
    b. Emaillabel
    c. Emailtype
  5. Website:
    a. Website
  6. Event:
    a. Eventstartdate
    b. Eventlabel
    c. Eventtype
  7. Note:
    a. Note
  8. Address:
    a. Address
    b. Addresstype
  ```

## UML Diagram

This is a general diagram of the library's architectural design, and it only includes the numbers elements for clarity. 

<img src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/ContactLib_UML.PNG" width="650">

## Apps using the library
 An earlier version of this library is used in **Dropbøx Contact Sharing Manager**

<a href='https://play.google.com/store/apps/details?id=jagerfield.dcm'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="150" height="60"/></a>

The **Mobile Contact Library** uses the **Android Utilities Library** to manage permissions:

<a href='https://github.com/Jagerfield/Android-Utilities-Library'><img alt='Android Utilities Library' src="https://github.com/Jagerfield/Mobile-Contacts-Library/blob/master/Snapshots/Octocat.png" width="65"/></a> &#160; <a href='https://play.google.com/store/apps/details?id=jagerfield.utilities'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="150" height="60"/></a>
