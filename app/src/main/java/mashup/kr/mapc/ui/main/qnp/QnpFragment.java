package mashup.kr.mapc.ui.main.qnp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mashup.kr.mapc.QnpItem;
import mashup.kr.mapc.QnpRecyclerAdapter;
import mashup.kr.mapc.R;

public class QnpFragment extends Fragment {

    final int ITEM_SIZE = 5;

    RecyclerView recyclerView;

    ArrayList<String> labels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qnp, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<QnpItem> qnp_items = new ArrayList<>();
        QnpItem[] qnp_item = new QnpItem[ITEM_SIZE];

        labels = new ArrayList<String>(Arrays.asList("진행중", "Best Pick", "Hot Topic"));

        qnp_item[0] = new QnpItem("반팔", "셔츠", labels, 80.1f, 19.9f);
        qnp_item[1] = new QnpItem("청바지", "반바지", labels, 60f, 40f);
        qnp_item[2] = new QnpItem("가디건", "자켓", labels,50f,50f);
        qnp_item[3] = new QnpItem("슬랙스", "치마", labels,30.4f,59.6f);
        qnp_item[4] = new QnpItem("원피스 정장", "투피스 정장", labels,20.2f, 79.8f);

        for (int i = 0; i < ITEM_SIZE; i++) {
            qnp_items.add(qnp_item[i]);
        }

        recyclerView.setAdapter(new QnpRecyclerAdapter(this.getContext(), qnp_items, R.layout.activity_main));
    }

    public static QnpFragment newInstance() {

        Bundle args = new Bundle();

        QnpFragment fragment = new QnpFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
