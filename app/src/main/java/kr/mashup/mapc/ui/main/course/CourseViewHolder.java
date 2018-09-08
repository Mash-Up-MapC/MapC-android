package kr.mashup.mapc.ui.main.course;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kr.mashup.mapc.ui.main.data.Course;

public class CourseViewHolder extends RecyclerView.ViewHolder {

    public CourseViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(__ -> {
            Intent intent = new Intent(itemView.getContext(), CourseDetailActivity.class);
            itemView.getContext().startActivity(intent);
        });
    }

    public void setData(Course data) {

    }
}
