package kr.mashup.mapc.ui.main.etc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import kr.mashup.mapc.R;

public class EtcViewHolder extends RecyclerView.ViewHolder {

    public EtcViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(String data) {
        ((TextView) itemView.findViewById(R.id.content)).setText(data);
    }
}
