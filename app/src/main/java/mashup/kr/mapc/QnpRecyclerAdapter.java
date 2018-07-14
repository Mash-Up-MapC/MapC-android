package mashup.kr.mapc;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeongahri on 2018. 7. 1..
 */

public class QnpRecyclerAdapter extends RecyclerView.Adapter<QnpRecyclerAdapter.ViewHolder> {

    Context context;
    List<QnpItem> qnp_items;
    int item_layout;




    public QnpRecyclerAdapter(Context context, List<QnpItem> qnp_items, int item_layout) {
        this.context = context;
        this.qnp_items = qnp_items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final QnpItem qnpItem = qnp_items.get(position);

        ArrayList<String> labels = qnpItem.getLabels();
        int label_size = labels.size();

        holder.label1.setText(labels.get(0));
        holder.label2.setText(labels.get(1));
        holder.label3.setText(labels.get(2));

        for (int i =0; i<label_size; i++){
            if(labels.get(i) == null){

                switch(i){
                    case 0:
                        holder.label1.setVisibility(View.GONE);
                        break;
                    case 1:
                        holder.label2.setVisibility(View.GONE);
                        break;
                    case 2:
                        holder.label3.setVisibility(View.GONE);
                        break;
                }
            }
        }

        holder.versus1.setText(qnpItem.getVersus1());
        holder.versus2.setText(qnpItem.getVersus2());

        holder.pieChart.setCenterTextSize(10f);
        holder.pieChart.setEntryLabelTextSize(8f);


        holder.versus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.versus1.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.versus2.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
                holder.pieChart.setVisibility(View.VISIBLE);

                List<PieEntry> entries = new ArrayList<>();

                entries.add(new PieEntry(qnpItem.getV1_ratio(), holder.versus1.getText()));
                entries.add(new PieEntry(qnpItem.getV2_ratio(), holder.versus2.getText()));

                PieDataSet set = new PieDataSet(entries,"");

                PieData data = new PieData(set);
                holder.pieChart.setData(data);

                holder.pieChart.setCenterText(holder.versus1.getText());
                holder.pieChart.setCenterTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
        });

        holder.versus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.versus2.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.versus1.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
                holder.pieChart.setVisibility(View.VISIBLE);


                List<PieEntry> entries = new ArrayList<>();

                entries.add(new PieEntry(qnpItem.getV1_ratio(), holder.versus1.getText()));
                entries.add(new PieEntry(qnpItem.getV2_ratio(), holder.versus2.getText()));

                PieDataSet set = new PieDataSet(entries,"");
                PieData data = new PieData(set);
                holder.pieChart.setData(data);

                holder.pieChart.setCenterText(holder.versus2.getText());
                holder.pieChart.setCenterTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.qnp_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView label1;
        TextView label2;
        TextView label3;

        PieChart pieChart;

        TextView versus1;
        TextView versus2;
        CardView cardview;

        ImageButton down_arrow;

        public ViewHolder(View itemView) {
            super(itemView);

            label1 = (TextView)itemView.findViewById(R.id.label_1);
            label2 = (TextView)itemView.findViewById(R.id.label_2);
            label3 = (TextView)itemView.findViewById(R.id.label_3);

            pieChart = (PieChart)itemView.findViewById(R.id.pie_chart);

            versus1 = (TextView)itemView.findViewById(R.id.versus_1);
            versus2 = (TextView)itemView.findViewById(R.id.versus_2);
            cardview = (CardView) itemView.findViewById(R.id.cardview);

            down_arrow = (ImageButton)itemView.findViewById(R.id.down_arrow);

            down_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pieChart.setVisibility(View.GONE);
                }
            });
        }
    }
}
