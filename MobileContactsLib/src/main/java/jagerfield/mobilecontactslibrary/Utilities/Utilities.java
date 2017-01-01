package jagerfield.mobilecontactslibrary.Utilities;

import android.database.Cursor;
import android.provider.ContactsContract;
import jagerfield.mobilecontactslibrary.Abstracts.ElementParent;

public class Utilities
{
    public static final String TAG_LIB = "TAG_LIB";

    public static String getColumnIndex(Cursor c, String column)
    {
        String result = "";
        int index = c.getColumnIndex(column);
        if (index == -1)
        {
            result = null;
        }
        else
        {
            result = c.getString(index);
        }

        return result;
    }

    public static Long getLong(Cursor c, String column)
    {
        Long result = null;
        int index = c.getColumnIndex(column);

        if (index == -1)
        {
            result = null;
        }
        else
        {
            result = c.getLong(index);
        }

        return result;
    }

    public static String getNumberType(String type)
    {
        int value =99;

        try
        {
            value = Integer.parseInt(type);
        }
        catch(Exception e)
        {
            return "UNKNOWN";
        }

        switch (value)
        {
            case ContactsContract.CommonDataKinds.Phone.TYPE_CUSTOM:
                return "CUSTOM";
            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                return "HOME";
            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                return "MOBILE";
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                return "WORK";
            case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK:
                return "FAX_WORK";
            case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_HOME:
                return "FAX_HOME";
            case ContactsContract.CommonDataKinds.Phone.TYPE_PAGER:
                return "PAGER";
            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER:
                return "OTHER";
            case ContactsContract.CommonDataKinds.Phone.TYPE_CALLBACK:
                return "CALLBACK";
            case ContactsContract.CommonDataKinds.Phone.TYPE_CAR:
                return "CAR";
            case ContactsContract.CommonDataKinds.Phone.TYPE_COMPANY_MAIN:
                return "COMPANY_MAIN";
            case ContactsContract.CommonDataKinds.Phone.TYPE_ISDN:
                return "ISDN";
            case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
                return "MAIN";
            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER_FAX:
                return "OTHER_FAX";
            case ContactsContract.CommonDataKinds.Phone.TYPE_RADIO:
                return "RADIO";
            case ContactsContract.CommonDataKinds.Phone.TYPE_TELEX:
                return "TELEX";
            case ContactsContract.CommonDataKinds.Phone.TYPE_TTY_TDD:
                return "TTY_TDD";
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
                return "WORK_MOBILE";
            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_PAGER:
                return "WORK_PAGER";
            case ContactsContract.CommonDataKinds.Phone.TYPE_ASSISTANT:
                return "ASSISTANT";
            case ContactsContract.CommonDataKinds.Phone.TYPE_MMS:
                return "MMS";
            default:
                return "UNKNOWN";
        }
    }

    public static String getEventType(String type)
    {
        int value =99;

        try
        {
            value = Integer.parseInt(type);
        }
        catch(Exception e)
        {
            return "OTHER";
        }

        switch (value)
        {
            case ContactsContract.CommonDataKinds.Event.TYPE_CUSTOM:
                return "CUSTOM";
            case ContactsContract.CommonDataKinds.Event.TYPE_ANNIVERSARY:
                return "ANNIVERSARY";
            case ContactsContract.CommonDataKinds.Event.TYPE_OTHER:
                return "OTHER";
            case ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY:
                return "BIRTHDAY";
            default:
                return "OTHER";
        }
    }

    public static  String getNickNameType(String type)
    {
        int value =99;

        try
        {
            value = Integer.parseInt(type);
        }
        catch(Exception e)
        {
            return "DEFAULT";
        }

        switch (value)
        {
            case ContactsContract.CommonDataKinds.Nickname.TYPE_DEFAULT: return "DEFAULT";
            case ContactsContract.CommonDataKinds.Nickname.TYPE_OTHER_NAME: return "OTHERNAME";
            case ContactsContract.CommonDataKinds.Nickname.TYPE_MAIDEN_NAME: return "MAIDENNAME";
            case ContactsContract.CommonDataKinds.Nickname.TYPE_SHORT_NAME: return "SHORTNAME";
            case ContactsContract.CommonDataKinds.Nickname.TYPE_INITIALS: return "INITIALS";
            default: return "DEFAULT";
        }
    }

    public static  String getAddressType(String type)
    {
        int value =99;

        try
        {
            value = Integer.parseInt(type);
        }
        catch(Exception e)
        {
            return "OTHER";
        }

        switch (value)
        {
            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_CUSTOM: return "CUSTOME";
            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_HOME: return "HOME";
            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK: return "WORK";
            case ContactsContract.CommonDataKinds.StructuredPostal.TYPE_OTHER: return "OTHER";
            default: return "OTHER";
        }
    }

    public static  String getEmailType(String type)
    {
        int value =99;

        try
        {
            value = Integer.parseInt(type);
        }
        catch(Exception e)
        {
            return "OTHER";
        }

        switch (value)
        {
            case ContactsContract.CommonDataKinds.Email.TYPE_CUSTOM: return "CUSTOME";
            case ContactsContract.CommonDataKinds.Email.TYPE_HOME: return "HOME";
            case ContactsContract.CommonDataKinds.Email.TYPE_WORK: return "WORK";
            case ContactsContract.CommonDataKinds.Email.TYPE_OTHER: return "OTHER";
            case ContactsContract.CommonDataKinds.Email.TYPE_MOBILE: return "MOBILE";
            default: return "OTHER";
        }
    }

    public static String elementValue(ElementParent element)
    {
        String result;

        try
        {
            result = element.getValue();
        }
        catch(Exception e)
        {
            result = "";
            e.printStackTrace();
        }

        return result;
    }
}
