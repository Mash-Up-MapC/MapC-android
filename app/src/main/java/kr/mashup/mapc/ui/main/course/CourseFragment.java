package kr.mashup.mapc.ui.main.course;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.mashup.mapc.R;

public class CourseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            CourseMapFragment courseMapFragment = new CourseMapFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.course_map_container, courseMapFragment)
                    .commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static CourseFragment newInstance() {
        Bundle args = new Bundle();

        CourseFragment fragment = new CourseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}