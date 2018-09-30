package kr.mashup.mapc.ui.main.etc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import kr.mashup.mapc.R;

public class EtcAdapter extends RecyclerView.Adapter<EtcViewHolder> {

    private ArrayList<String> dataList = new ArrayList<>();

    @NonNull
    @Override
    public EtcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EtcViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_etc_simple, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EtcViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addDatas(String[] datas) {
        dataList.addAll(Arrays.asList(datas));
        notifyItemInserted(datas.length);
    }
}
