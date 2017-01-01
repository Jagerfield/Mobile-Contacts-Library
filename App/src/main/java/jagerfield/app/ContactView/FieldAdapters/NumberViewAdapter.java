package jagerfield.app.ContactView.FieldAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import jagerfield.mobilecontactslibrary.ElementContainers.NumberContainer;
import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.R;
import java.util.LinkedList;

public class NumberViewAdapter extends RecyclerView.Adapter<NumberViewAdapter.ViewHolder> {

    private Context context;
    private final LinkedList<NumberContainer> numbersList;

    public NumberViewAdapter(Context context, LinkedList<NumberContainer> numbersList) {
        this.context = context;
        this.numbersList = numbersList;
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
        String number = numbersList.get(position).elementValue();
        String type = numbersList.get(position).getNumType();

        holder.tvValue.setText(number);
        holder.tvType.setText(type);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvValue;
        public final TextView tvType;
        public Contact vhContact;

        public ViewHolder(View view) {
            super(view);
            tvValue = (TextView) view.findViewById(R.id.tvValue);
            tvType = (TextView) view.findViewById(R.id.tvType);
        }
    }
}