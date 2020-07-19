package com.cskhw.study.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.cskhw.study.R;

import java.util.ArrayList;

class Post {
    private final int id;
    private final String name;
    private final int age;

    Post(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

public class RecyclerActivity extends AppCompatActivity {
    ArrayList<Post> postList = new ArrayList<>();

    public void loadContent() {
        postList.add(0, new Post(1, "desk", 21));
        postList.add(1, new Post(2, "chair", 31));
        postList.add(2, new Post(3, "pencil", 25));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);

        RecyclerView recycler = findViewById(R.id.recycler_main_recyclerView);
        loadContent();
        LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new ListViewRecyclerViewAdapter(postList));
    }

    private static class ListViewRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<Post> posts;

        ListViewRecyclerViewAdapter(ArrayList<Post> postList) {
            posts = postList;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
            return new ListViewHolder(view);
        }

        static class ListViewHolder extends RecyclerView.ViewHolder {
            TextView textView1;
            TextView textView2;
            TextView textView3;

            ListViewHolder(@NonNull View itemView) {
                super(itemView);
                this.textView1 = itemView.findViewById(R.id.recycler_post_text1);
                this.textView2 = itemView.findViewById(R.id.recycler_post_text2);
                this.textView3 = itemView.findViewById(R.id.recycler_post_text3);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ListViewHolder itemView = (ListViewHolder) holder;
            System.out.println("아이디: " + posts.get(0).getId());
            itemView.textView1.setText(String.valueOf(posts.get(position).getId()));
            itemView.textView2.setText(posts.get(position).getName());
            itemView.textView3.setText(String.valueOf(posts.get(position).getAge()));
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }
    }


}
