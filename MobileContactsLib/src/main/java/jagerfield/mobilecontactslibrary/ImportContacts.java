package jagerfield.mobilecontactslibrary;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import jagerfield.mobilecontactslibrary.FieldContainer.FieldsContainer;
import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;


public class ImportContacts
{
    private Activity activity;
    private LinkedHashMap<Long, Contact> contactsIdMap;
    @Expose
    private ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts()
    {
        return getMobileContacts();
    }

    public void insertContact(Contact contact)
    {
        this.contacts.add(contact);
    }

    public ImportContacts(Activity activity)
    {
        this.activity = activity;
    }

    private String[] getKeyWord() {
        return null;
    }

    private String getFilter()
    {
        return null;
    }

    private String[] getColumns()
    {
        Set<String> columns = new HashSet<>();

        FieldsContainer fieldsContainer = new FieldsContainer();
        columns.addAll(fieldsContainer.getElementsColumns());
        columns.add(ContactsContract.RawContacts.CONTACT_ID);
        columns.add(ContactsContract.Data.MIMETYPE);
        columns.add(ContactsContract.Data.PHOTO_URI);

        return columns.toArray(new String[columns.size()]);
    }

    public ArrayList<Contact> getMobileContacts()
    {
        boolean flag = hasPermission(Manifest.permission.READ_CONTACTS);

        if (!flag)
        {
            Log.i(Utilities.TAG_LIB, "Missing permission READ_CONTACTS");
            return new ArrayList<Contact>();
        }
                
        Cursor cursor = activity.getContentResolver().
                query(ContactsContract.Data.CONTENT_URI, // The content URI of the words table
                getColumns(),                            // The columns to return for each row
                getFilter(),                             // Selection criteria
                getKeyWord(),                            // Selection criteria
                ContactsContract.Data.DISPLAY_NAME);     // The sort order for the returned rows

        if (cursor != null)
        {
            long id ;
            String photoUri;
            String columnIndex;
            contactsIdMap = new LinkedHashMap<>();
            contacts = new ArrayList<>();

            while (cursor.moveToNext())
            {
                id = Utilities.getLong(cursor, ContactsContract.RawContacts.CONTACT_ID);

                Contact contact = contactsIdMap.get(id);
                if (contact==null)
                {
                    contact = new Contact(id);
                    contactsIdMap.put(id, contact);
                    insertContact(contact);
                }

                try
                {
                    photoUri = Utilities.getColumnIndex(cursor, ContactsContract.Data.PHOTO_URI);
                    if (photoUri != null && !photoUri.isEmpty())
                    {
                        contact.setPhotoUri(photoUri);
                    }
                }
                catch (Exception e)
                {
                    photoUri = "";
                }

                columnIndex =  Utilities.getColumnIndex(cursor, ContactsContract.Data.MIMETYPE);
                contact.execute(cursor, columnIndex);
            }

            cursor.close();
        }

        if (contacts.isEmpty())
        {
            Log.i(Utilities.TAG_LIB, "Lib: No contacts found");
        }

        return contacts;
    }

    public synchronized boolean hasPermission(String permission)
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
        {
            return true;
        }

        if (permission==null || permission.isEmpty())
        {

            return false;
        }

        String[] permissionsArray = {permission};

        for (int i = 0; i < permissionsArray.length; i++)
        {
            if (activity.checkSelfPermission(permissionsArray[i]) == PackageManager.PERMISSION_DENIED)
            {
                Log.w(Utilities.TAG_LIB, permission + " permission is missing.");
                return false;
            }
            else
            {
                return true;
            }
        }

        return false;
    }

}



