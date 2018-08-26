package kr.mashup.mapc.ui.main.booking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.mashup.mapc.data.Booking;

public class BookingAdapter extends RecyclerView.Adapter<BookingViewHolder> {

    private ArrayList<Booking> dataList = new ArrayList<>();

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
