package in.elango.tamillearning;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return activity_icon_images.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(activity_icon_images[position]);
        return imageView;
    }

    // references to our images
    private Integer[] activity_icon_images = {
    		R.drawable.ic_menu_numbers,
    		R.drawable.ic_menu_colors,
    		R.drawable.ic_menu_shapes,
    		R.drawable.ic_menu_fruits,
    		R.drawable.ic_menu_animals,
    		R.drawable.ic_menu_vehicles
            
    };



}
