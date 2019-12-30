package com.ryx.rxjavatest;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ryx.rxjavatest.utils.Utils;

public class CenterZoomAdapter extends RecyclerView.Adapter<CenterZoomAdapter.ViewHolder> {

    private final String TAG = CenterZoomAdapter.class.getSimpleName();

    private final int NUMBERS_OF_ITEM_TO_DISPLAY = 3;
    private Context context;
    private int snapPosition = 1;

    public CenterZoomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_center_zoom, parent, false);

        int statusbarHeight = Utils.getStatusBarHeight(context);
        int actionbarHeight = Utils.getActionBarHeight(context);

        Log.d(TAG, "onCreateViewHolder: statusbarHeight: " + statusbarHeight
                + " actionbarHeight: " + actionbarHeight);

        int totalAvailableHeight = getScreenHeight() - (actionbarHeight + statusbarHeight);

        itemView.getLayoutParams().height
                = (int) (totalAvailableHeight / NUMBERS_OF_ITEM_TO_DISPLAY); /// THIS LINE WILL DIVIDE OUR VIEW INTO NUMBERS OF PARTS

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setSnapView();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public void setSnapPosition(int snapPosition) {
        this.snapPosition = snapPosition;
        notifyDataSetChanged();
    }

    public int getScreenHeight() {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }

        public void setSnapView() {
            if (getAdapterPosition() == snapPosition) {
                tv.setTextSize(28);
            } else {
                tv.setTextSize(20);
            }
        }
    }
}
