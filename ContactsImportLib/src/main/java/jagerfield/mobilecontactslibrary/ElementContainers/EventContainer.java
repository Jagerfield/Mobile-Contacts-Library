package jagerfield.mobilecontactslibrary.ElementContainers;

import android.database.Cursor;

import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventLabelElement;
import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventStartDateElement;
import jagerfield.mobilecontactslibrary.FieldElements.EventElements.EventTypeElement;
import jagerfield.mobilecontactslibrary.Utilities.Utility;
import com.google.gson.annotations.Expose;
import java.util.HashSet;
import java.util.Set;

public class EventContainer
{
    private transient Cursor cursor;
    @Expose
    private EventStartDateElement startDate;
    @Expose
    private EventTypeElement eventType;
    @Expose
    private EventLabelElement eventLable;

    public EventContainer(Cursor cursor)
    {
        this.cursor = cursor;
        startDate = new EventStartDateElement(cursor);
        eventType = new EventTypeElement(cursor);
        eventLable = new EventLabelElement(cursor);
    }

    public static Set<String> getFieldColumns()
    {
        Set<String> columns = new HashSet<>();
        columns.add(EventStartDateElement.column);
        columns.add(EventTypeElement.column);
        columns.add(EventLabelElement.column);
        return columns;
    }

    public String getEventStartDate()
    {
        String result = Utility.elementValue(startDate);
        return result;
    }
    public String getEventType()
    {
        String result = Utility.elementValue(eventType);
        return result;
    }
    public String getEventLabel()
    {
        String result = Utility.elementValue(eventLable);
        return result;
    }
}