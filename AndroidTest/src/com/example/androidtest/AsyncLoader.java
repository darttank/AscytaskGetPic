package com.example.androidtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class AsyncLoader {

	private DisplayImageOptions options;
	private ImageLoader imageLoader;
	private Context context;

	public AsyncLoader(Context context) {
		super();
		this.context = context;
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.default_image) // 设置图片在下载期间显示的图片
				.showImageForEmptyUri(R.drawable.default_image)// 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.default_image) // 设置图片加载/解码过程中错误时候显示的图片
				.cacheInMemory(true)// 设置下载的图片是否缓存在内存�?				.cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
				// .considerExifParams(true) //是否考虑JPEG图像EXIF参数（旋转，翻转�?				// .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
				.bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类�?/
				// .delayBeforeLoading(int delayInMillis)//int
				// delayInMillis为你设置的下载前的延迟时�?				// 设置图片加入缓存前，对bitmap进行设置
				// .preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(false)// 设置图片在下载前是否重置，复�?				.imageScaleType(ImageScaleType.EXACTLY)

				.build();// 构建完成
		imageLoader = ImageLoader.getInstance();
		// type =new PreferencesHelper(context,
		// Constant.PRE_SETTING_FILE).getValueInt(Constant.PRE_SETTING_IMAGE_KEY);
		// netWorkType =AndroidUtil.getNetWorkType(context);
	}

	public AsyncLoader(Context context, int resId) {
		super();
		this.context = context;
		options = new DisplayImageOptions.Builder().showImageOnLoading(resId) // 设置图片在下载期间显示的图片
				.showImageForEmptyUri(resId)// 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(resId) // 设置图片加载/解码过程中错误时候显示的图片
				.cacheInMemory(true)// 设置下载的图片是否缓存在内存�?				.cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
				// .considerExifParams(true) //是否考虑JPEG图像EXIF参数（旋转，翻转�?				// .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
				.bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类�?/
				// .delayBeforeLoading(int delayInMillis)//int
				// delayInMillis为你设置的下载前的延迟时�?				// 设置图片加入缓存前，对bitmap进行设置
				// .preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(false)// 设置图片在下载前是否重置，复�?				.imageScaleType(ImageScaleType.EXACTLY)

				.build();// 构建完成

		imageLoader = ImageLoader.getInstance();
	}

	public void displayImage(String uri, ImageView imageView) {
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		imageLoader.displayImage(uri, new ImageViewAware(imageView, false),
				options);
	}

	public void displayImageWithUri(String uri, ImageView imageView) {
		imageLoader.displayImage(uri, new ImageViewAware(imageView, false),
				options);
	}

	public void displayImage(String uri, ImageView imageView,
			ImageLoadingListener listener) {
		
	
		imageLoader.displayImage(uri, new ImageViewAware(imageView, false),
				options, listener);
	}

	public void displayImageBG(String uri, ImageView imageView) {
		imageLoader.displayImage(uri, new BgImageAware(imageView), options);
	}

	public void displayImageWithFile(String path, ImageView imageView) {
		imageLoader.displayImage("file://" + path, imageView);
	}

	/*
	 * public void displayImageAuto(String uri, ImageView imageView) {
	 * imageLoader
	 * .displayImage(GlobalApplication.getInstance().getBaseUrl()+getNetTypeURi
	 * ()+uri, new ImageViewAware(imageView,false), options, new
	 * ImageLoadingListener() {
	 * 
	 * @Override public void onLoadingStarted(String arg0, View arg1) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onLoadingFailed(String arg0, View arg1, FailReason
	 * arg2) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onLoadingComplete(String arg0, View view, Bitmap
	 * loadedImage) { if(loadedImage!=null){ UIUtils.setAutoLayout(context,
	 * view, loadedImage); } }
	 * 
	 * @Override public void onLoadingCancelled(String arg0, View arg1) { //
	 * TODO Auto-generated method stub
	 * 
	 * } }); }
	 */

}
