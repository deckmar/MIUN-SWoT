package se.miun.swot.nfc;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArrayListAdapterForBottles extends BaseAdapter {

	private static ArrayList<ArrayList<String>> players;
	private LayoutInflater inflater;
	
	public ArrayListAdapterForBottles(Context context, ArrayList<ArrayList<String>> info) {
		players = info;
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return players.size();
	}

	@Override
	public Object getItem(int pos) {
		return players.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	// get View with two TextViews (id and temperature) if it already exists
	// otherwise create it and give it to the ListAdapter to display it
	//
	// this method is recommended by Google, it is the most efficient way to 
	// display Views in a ListView by minimizing the lagging the most possible
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null) {
			convertView = inflater.inflate(android.R.layout.simple_list_item_2, null);
			holder = new ViewHolder();
			holder.id = (TextView) convertView.findViewById(android.R.id.text1);
			holder.temp = (TextView) convertView.findViewById(android.R.id.text2);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();
		
		holder.id.setText(players.get(position).get(0));
		holder.temp.setText(players.get(position).get(1)+" degrees Celsius");
		
		return convertView;
	}

	private class ViewHolder{
		TextView id;
		TextView temp;
	}
	
}
