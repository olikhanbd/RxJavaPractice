package com.ryx.rxjavatest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private final String TAG = "nexa_" + this.getClass().getSimpleName();

    private Context context;
    private List<Post> dataList = new ArrayList<>();

    public PostsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_posts, parent, false)
        );
    }

    public void setPosts(List<Post> posts) {
        this.dataList = posts;
        notifyDataSetChanged();
    }

    public void updatePost(Post post) {
        dataList.set(dataList.indexOf(post), post);
        notifyItemChanged(dataList.indexOf(post));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (dataList.isEmpty())
            return;
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNumber, tvDesc;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumber = itemView.findViewById(R.id.tv_number);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            progressBar = itemView.findViewById(R.id.progressbar);
        }

        public void bind(Post post) {
            tvDesc.setText(post.getBody());

            if (post.getComments() == null) {
                toggleProgressbar(true);
                tvNumber.setText("");
            } else {
                toggleProgressbar(false);
                tvNumber.setText(String.valueOf(post.getComments().size()));
            }


        }

        void toggleProgressbar(boolean show) {
            if (show) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}
