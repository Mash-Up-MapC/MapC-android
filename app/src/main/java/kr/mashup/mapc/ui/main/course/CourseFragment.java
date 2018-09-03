package kr.mashup.mapc.ui.main.course;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.main.data.Course;

public class CourseFragment extends Fragment {

    private RecyclerView recyclerView;
    private CourseAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private void init(View view) {
        view.findViewById(R.id.recycler_view_course).setFocusable(false);
        view.findViewById(R.id.main_image).requestFocus();

        recyclerView = view.findViewById(R.id.recycler_view_course);

        adapter = new CourseAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            adapter.addData(new Course());
        }
    }

    public static CourseFragment newInstance() {
        Bundle args = new Bundle();

        CourseFragment fragment = new CourseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}