package kr.mashup.mapc.ui.main.course;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.main.data.Course;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    private ArrayList<Course> dataList = new ArrayList<>();

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CourseViewHolder(
                LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_booking, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(Course course) {
        dataList.add(course);
        notifyItemInserted(dataList.size());
    }
}
