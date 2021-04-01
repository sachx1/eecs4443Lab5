package ca.yorku.eecs.mack.democamera;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

class ImageAdapter extends BaseAdapter
{
//    private final String[] fileNames;
//    private String directory;
//    private int displayWidth;
//
//    private final ImageDownloader imageDownloader = new ImageDownloader();
//
//    ImageAdapter(String[] fileNamesArg, String directoryArg, int displayWidthArg)
//    {
//        fileNames = fileNamesArg;
//        directory = directoryArg;
//        displayWidth = displayWidthArg;
//    }
//
//    @Override
//    public int getCount()
//    {
//        return fileNames.length;
//    }
//
//    @Override
//    public String getItem(int position)
//    {
//        return fileNames[position];
//    }
//
//    @Override
//    public long getItemId(int position)
//    {
//        return fileNames[position].hashCode();
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent)
//    {
//        if (view == null)
//        {
//            view = new ImageView(parent.getContext());
//            view.setBackgroundColor(Color.LTGRAY);
//            ((ImageView)view).setScaleType(ImageView.ScaleType.CENTER);
//            view.setPadding(6, 6, 6, 6);
//        }
//
//        String path = directory + File.separator + fileNames[position];
//        imageDownloader.download(path, (ImageView)view, displayWidth);
//        return view;
//    }

    String[] filenames;
    File directory;
    ImageDownloader imageDownloader = new ImageDownloader();
    int columnWidth;

    private Context context;

    public ImageAdapter(Context c)
    {
        context = c;
    }

    public ImageAdapter(String[] imageFilenames, String directory, int displayWidth) {
    }

    public int getCount()
    {
        return filenames.length;
    }

    public Object getItem(int position)
    {
        return null;
    }

    public long getItemId(int position)
    {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(columnWidth, columnWidth));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else
        {
            imageView = (ImageView)convertView;
        }

        // download the image and associate it with the ImageView
        String path = directory + File.separator + filenames[position];
        imageDownloader.download(path, imageView, 250);
        return imageView;
    }

    // give the ImageAdapter the filenames array and the directory
    public void setFilenames(String[] filenamesArg, File directoryArg)
    {
        filenames = filenamesArg;
        directory = directoryArg;
    }

    public void setColumnWidth(int widthArg)
    {
        columnWidth = widthArg;
    }
}
