package gvit.chicken.app.fragements;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import gvit.chicken.app.R;
import gvit.chicken.app.activity.Addressactivity;
import gvit.chicken.app.activity.Book_Service_Activity;


public class Home_Fragment extends  Fragment  {

	ViewPager viewpager1;
    MaterialButton bookService;

	TextView user_name;


	private final Timer _timer = new Timer();

   int count = 0;

   TimerTask srcoll_timer;

   ArrayList<HashMap<String,Object>> listmap = new ArrayList<>();

@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.frag_home, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {

	viewpager1 = _view.findViewById(R.id.viewpager1);
    bookService = _view.findViewById(R.id.book_service);

user_name = _view.findViewById(R.id.user_name);

	}






	private void initializeLogic() {



		SharedPreferences sh = getContext().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
		if(!sh.getString("customer_name", "").equals(""))
		{
			user_name.setText((sh.getString("customer_name", "")));

		}



		bookService.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {


		SharedPreferences sh = getContext().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
		if(!sh.getString("token", "").equals("")) {


			if(!sh.getString("customer_pincode", "").equals("0"))
			{
				Intent i = new Intent();

				i.setClass(getContext(), Book_Service_Activity.class);
				startActivity(i);

			} else {

				Intent i = new Intent();
				i.putExtra("open", "address");
				i.setClass(getContext(), Addressactivity.class);
				startActivity(i);
			}




		} else
		{
			startActivity(new Intent(getActivity(), Book_Service_Activity.class));

		}





	}
});
	 _slider();

	}




/*
//https://clareservices.com/wp-content/uploads/2021/05/technician-service-removing-air-filter-air-conditioner-cleaning_35076-3617-640x426.jpg
	//https://etimg.etb2bimg.com/photo/78030866.cms
	//https://images.indianexpress.com/2020/09/GettyImages-pearl-facial_1200.jpg
	//https://empire-s3-production.bobvila.com/articles/wp-content/uploads/2021/07/how_much_does_a_plumber_cost.jpg
	//https://www.nobroker.in/blog/wp-content/uploads/2022/09/Home-Cleaning-Service-in-HSR-Layout-Bangalore-1-1.jpg
*/

	public void _slider () {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("image", "https://clareservices.com/wp-content/uploads/2021/05/technician-service-removing-air-filter-air-conditioner-cleaning_35076-3617-640x426.jpg");
			listmap.add(_item);
		}

		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("image", "https://etimg.etb2bimg.com/photo/78030866.cms");
			listmap.add(_item);
		}

		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("image", "https://images.indianexpress.com/2020/09/GettyImages-pearl-facial_1200.jpg");
			listmap.add(_item);
		}

		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("image", "https://empire-s3-production.bobvila.com/articles/wp-content/uploads/2021/07/how_much_does_a_plumber_cost.jpg");
			listmap.add(_item);
		}

		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("image", "https://www.nobroker.in/blog/wp-content/uploads/2022/09/Home-Cleaning-Service-in-HSR-Layout-Bangalore-1-1.jpg");
			listmap.add(_item);
		}

		final float scaleFactor = 0.96f;
		viewpager1.setPageMargin(-15);
		viewpager1.setOffscreenPageLimit(2);
		viewpager1.setPageTransformer(false, new ViewPager.PageTransformer() { @Override public void transformPage(@NonNull View page1, float position) { page1.setScaleY((1 - Math.abs(position) * (1 - scaleFactor))); page1.setScaleX(scaleFactor + Math.abs(position) * (1 - scaleFactor)); } });
		viewpager1.setAdapter(new Viewpager1Adapter(listmap));





		srcoll_timer = new TimerTask() {
			@Override
			public void run() {
				getActivity().runOnUiThread(new Runnable() {
					@Override
					public void run() {





						if (count == listmap.size()) {

							count = 0;
						}

						//Toast.makeText(getContext(), ""+coun[count], Toast.LENGTH_SHORT).show();
						viewpager1.setCurrentItem(count);
						count++;


						//viewpager2.setCurrentItem((int)count);
						//viewpager3.setCurrentItem((int)count);

					}
				});
			}
		};
		_timer.scheduleAtFixedRate(srcoll_timer, 4000, 4000);
	}

	@Override
	public void onPause() {

		if(srcoll_timer != null)
		{
			srcoll_timer.cancel();
		}


		super.onPause();
	}

	@Override
	public void onResume() {

		if(srcoll_timer != null) {
			srcoll_timer.run();
		}

		super.onResume();
	}

	public class Viewpager1Adapter extends PagerAdapter {
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}

		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getContext();
			_data = _arr;
		}

		@Override
		public int getCount() {
			return _data.size();
		}

		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}

		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}

		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}

		@Override
		public CharSequence getPageTitle(int pos) {
			// use the activitiy event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + pos;
		}

		@Override
		public  Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.custom_slider, _container, false);

			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);



			cardview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {



				}
			});


			Glide.with(_context)
					.load(Uri.parse(Objects.requireNonNull(listmap.get(_position).get("image")).toString()))
					.thumbnail(0.01f)
					.into(imageview1);

			_container.addView(_view);
			return _view;
		}
	}
}
