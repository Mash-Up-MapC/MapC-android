package kr.mashup.mapc.ui.main.booking;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import kr.mashup.mapc.data.Booking;
import kr.mashup.mapc.ui.booking.BookingDetailActivity;

public class BookingViewHolder extends RecyclerView.ViewHolder {

    public BookingViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(__ -> {
            Intent intent = new Intent(itemView.getContext(), BookingDetailActivity.class);
            itemView.getContext().startActivity(intent);
        });
    }

    public void setData(Booking data) {

    }

}
