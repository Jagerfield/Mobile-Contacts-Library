package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import jagerfield.mobilecontactslibrary.FieldElements.NoteElement.NoteElement;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;
import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;


public class NoteContainer
{
    @Expose
    private NoteElement note;

    public NoteContainer(Cursor cursor)
    {
        note = new NoteElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(NoteElement.column);
        return columns;
    }

    public String getNote()
    {
        String result = Utilities.elementValue(note);
        return result;
    }

}
