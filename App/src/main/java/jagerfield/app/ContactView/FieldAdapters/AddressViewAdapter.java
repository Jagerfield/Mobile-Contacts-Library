package jagerfield.app.ContactView.FieldAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jagerfield.mobilecontactslibrary.ElementContainers.AddressContainer;
import com.example.sense.mobilecontactslibrary.R;

import java.util.LinkedList;



public class AddressViewAdapter extends RecyclerView.Adapter<AddressViewAdapter.ViewHolder> {

    private Context context;
    private final LinkedList<AddressContainer> addressList;

    public AddressViewAdapter(Context context, LinkedList<AddressContainer> addressList) {
        this.context = context;
        this.addressList = addressList;
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
        String number = addressList.get(position).getAddress();
        String type = addressList.get(position).getAddressType();

        holder.tvValue.setText(number);
        holder.tvType.setText(type);
    }

    @Override
    public int getItemCount() {
        return addressList.size();
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
