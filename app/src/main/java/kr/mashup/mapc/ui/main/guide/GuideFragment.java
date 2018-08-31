package kr.mashup.mapc.ui.main.guide;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import kr.mashup.mapc.R;

public class GuideFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_guide, container, false);


       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static GuideFragment newInstance() {

        Bundle args = new Bundle();

        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public class NaverCSSTask extends AsyncTask<String[],Void, String>{
        @Override
        protected String doInBackground(String[]... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
