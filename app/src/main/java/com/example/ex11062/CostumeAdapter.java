package com.example.ex11062;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CostumeAdapter extends BaseAdapter {
    private Context context;
    private Costume[] costumes;

    public CostumeAdapter(Context context, Costume[] costumes) {
        this.context = context;
        this.costumes = costumes;
    }

    @Override
    public int getCount() {
        return costumes.length;
    }

    @Override
    public Object getItem(int position) {
        return costumes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_row, parent, false);
        }

        Costume currentCostume = costumes[position];

        ImageView imgIcon = convertView.findViewById(R.id.imgIcon);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvCategory = convertView.findViewById(R.id.tvCategory);
        TextView tvLevel = convertView.findViewById(R.id.tvLevel);

        imgIcon.setImageResource(currentCostume.getImage());
        tvName.setText(currentCostume.getName());
        tvCategory.setText(currentCostume.getCategory());
        tvLevel.setText("Level: " + currentCostume.getLevel());

        return convertView;
    }
}