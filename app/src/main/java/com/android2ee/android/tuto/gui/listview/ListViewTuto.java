/**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
 * Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 * Belongs to <strong>Mathias Seguy</strong></br>
 * ****************************************************************************************************************</br>
 * This code is free for any usage but can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br>
 * </br>
 * For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
 * <em>mathias.seguy.it@gmail.com</em></br>
 * *****************************************************************************************************************</br>
 * Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 * Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
 * Sa propriété intellectuelle appartient à <strong>Mathias Séguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br>
 * </br>
 * Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
 * <em>mathias.seguy.it@gmail.com</em></br>
 * *****************************************************************************************************************</br>
 * Merci à vous d'avoir confiance en Android2EE les Ebooks de programmation Android.
 * N'hésitez pas à nous suivre sur twitter: http://fr.twitter.com/#!/android2ee
 * N'hésitez pas à suivre le blog Android2ee sur Developpez.com : http://blog.developpez.com/android2ee-mathias-seguy/
 * *****************************************************************************************************************</br>
 * com.android2ee.android.tuto</br>
 * 25 mars 2011</br>
 */
package com.android2ee.android.tuto.gui.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author (Julien PAPUT sous la direction du Dr. Mathias Séguy)
 * @goals This class aims to:
 *        <ul>
 *        <li>Ask to the User what he like and show the result.</li>
 *        </ul>
 */
public class ListViewTuto extends Activity {
	/*** A text view */
	TextView textView;
	/*** The dummy data list */
	String[] items = { "item1", "item2", "item3", "item4", "item5", "item6" };
	/** *The arrayAdapter that manage the data displayed */
	ArrayAdapter<String> arrayAdapter;
	/*** The ListView */
	ListView myListView;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		myListView=(ListView)findViewById(R.id.mylist);
		// Define the Adapter (Context, ListView Ressource, The items to display)
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		// or using string values stored in the resources:
		String[] itemsFromRes = getResources().getStringArray(R.array.itemsList);
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsFromRes);
		// Set the ArrayAdapter to the ListActivity
		myListView.setAdapter(arrayAdapter);
		myListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				onListItemClick(parent, view, position, id);
			}
		});
		// The text view that displays the current selected item
		textView = (TextView) findViewById(R.id.text);
	}

	/*
	 * (non-Javadoc)@see android.app.ListActivity#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	public void onListItemClick(AdapterView<?> parent, View v, int position, long id) {
		textView.setText(items[position]);
	}

}