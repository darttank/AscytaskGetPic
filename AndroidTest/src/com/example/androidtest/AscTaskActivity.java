package com.example.androidtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 应用
 * 
 * @author tf
 * 
 */
public class AscTaskActivity extends Activity {

	private GridView picgrid;
	private List<Map<String, String>> list;
	private HashMap<String, String> map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pic_list);

		initView();
		getData();
		VideoListAdapter adapter = new VideoListAdapter(this, list);
		picgrid.setAdapter(adapter);
	}

	private void getData() {
		list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 10; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pic_adress", "http://192.168.1.107:8080/MobileSafeServer/pic1.png");
		
			list.add(map);
		}
		
	}
	
	private void initView() {
		picgrid = (GridView) findViewById(R.id.picgrid);
	}



	class VideoListAdapter extends BaseAdapter {
		private AsyncLoader loader;
		private Context context;
		private List<Map<String, String>> data;
		private LayoutInflater inflater;

		public VideoListAdapter(Context context, List<Map<String, String>> list) {
			this.context = context;
			this.data = list;
			inflater = LayoutInflater.from(context);
			loader = new AsyncLoader(context);
			
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		
		@SuppressLint("ResourceAsColor")
		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			final ViewHolder holder;
			if (null == convertView) {
				convertView = inflater.inflate(R.layout.pic_grid_item, null);
				holder = new ViewHolder();
				holder.pic_iamge_icon = (ImageView) convertView
						.findViewById(R.id.pic_iamge_icon);

				convertView.setTag(holder);

			} else {
				holder = (ViewHolder) convertView.getTag();
			}
		   //   holder.pic_iamge_icon.setText(data.get(position).get("pic_adress"));
			
			loader.displayImage(data.get(position).get("pic_adress"),
					
					holder.pic_iamge_icon);
		return convertView;
		}

		// 视图容器类,属性对应布局文件元素
		private class ViewHolder {
            ImageView pic_iamge_icon;
          //  TextView pic_iamge_icon;
		}

	}
}
