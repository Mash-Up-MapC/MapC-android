package kr.mashup.mapc.ui.main.etc;

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

public class EtcFragment extends Fragment {

    private static final String[] items = {
            "언어설정",
            "공지사항",
            "이벤트",
            "고객센터"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_etc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EtcAdapter adapter = new EtcAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.addDatas(items);
    }

    public static EtcFragment newInstance() {

        Bundle args = new Bundle();

        EtcFragment fragment = new EtcFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
