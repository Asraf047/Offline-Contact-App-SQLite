package com.example.amanullah.myapplication18.database;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**Handle image blob operations
 * @author imran.h
 *
 */
public class Utility {
	

	/**convert from bitmap to byte array.
	 * @param  bitmap: to be converted to byte array
	 * @return byte array
	 */
	public static byte[] getBytes(Bitmap bitmap) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 0, stream);
		return stream.toByteArray();
	}

	
	
	/**convert from byte array to bitmap
	 * @param image: byte array to be converted to bitmap
	 * @return Bitmap form byte array
	 */
	public static Bitmap getPhoto(byte[] image) {
		return BitmapFactory.decodeByteArray(image, 0, image.length);
	}
}
