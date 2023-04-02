package edu.psu.sweng888.lessonfour_contentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Contact> mContacts;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_item, parent, false);
        }

        Contact contact = mContacts.get(position);

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView phoneTextView = convertView.findViewById(R.id.phoneTextView);

        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhoneNumber());

        return convertView;
    }
}