package jagerfield.app.ContactView.FieldAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jagerfield.mobilecontactslibrary.ElementContainers.EventContainer;
import com.example.sense.mobilecontactslibrary.R;
import java.util.LinkedList;


public class EventViewAdaptor extends RecyclerView.Adapter<EventViewAdaptor.ViewHolder> {

    private Context context;
    private final LinkedList<EventContainer> eventList;

    public EventViewAdaptor(Context context, LinkedList<EventContainer> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.field_list_item_double_prop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        String value = eventList.get(position).getEventStartDate();
        String type = eventList.get(position).getEventType();

        holder.tvValue.setText(value);
        holder.tvType.setText(type);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvValue;
        public final TextView tvType;

        public ViewHolder(View view) {
            super(view);
            tvValue = (TextView) view.findViewById(R.id.tvValue);
            tvType = (TextView) view.findViewById(R.id.tvType);
        }
    }
}