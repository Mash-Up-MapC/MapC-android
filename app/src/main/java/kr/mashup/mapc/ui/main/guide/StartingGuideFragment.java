package kr.mashup.mapc.ui.main.guide;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.main.MainActivity;

import static android.view.View.GONE;

public class StartingGuideFragment extends Fragment {

    View view;
    Button guide_start_btn;

    public static StartingGuideFragment newInstance() {

        Bundle args = new Bundle();

        StartingGuideFragment fragment = new StartingGuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_starting_guide, container, false);

        guide_start_btn = view.findViewById(R.id.guide_start_btn);
        guide_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new GuideFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//                for (Fragment currentFragment: fragmentManager.getFragments()) {
//                    if (currentFragment.isVisible()) {
//                        fragmentTransaction.remove(currentFragment);
//                    }
//                }

                fragmentTransaction.replace(R.id.relative_layout, fragment);
                view.findViewById(R.id.bus_view).setVisibility(View.GONE);
                view.findViewById(R.id.guide_start_btn).setVisibility(View.GONE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

       return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
