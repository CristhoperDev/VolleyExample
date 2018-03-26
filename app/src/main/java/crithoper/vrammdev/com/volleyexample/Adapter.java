package crithoper.vrammdev.com.volleyexample;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrador on 25/03/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Tremor> tremorList;

    public Adapter(Context context, List<Tremor> tremorList) {
        this.context = context;
        this.tremorList = tremorList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.place.setText("LUGAR : " + tremorList.get(position).getPlace());
        holder.time.setText("HORA : " + tremorList.get(position).getDatetime());
        holder.magnitude.setText("MAGNITUD : " + tremorList.get(position).getMagnitude());
        holder.evaluation.setText("EVALUACION : " + tremorList.get(position).getEvaluation());
        holder.report.setText("REPORTE : " + tremorList.get(position).getReport());
    }

    @Override
    public int getItemCount() {
        return null != tremorList ? tremorList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView place;
        TextView time;
        TextView magnitude;
        TextView evaluation;
        TextView report;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.internationalitems);
            place = itemView.findViewById(R.id.txtplace);
            time = itemView.findViewById(R.id.txttime);
            magnitude = itemView.findViewById(R.id.txtmagnitude);
            evaluation = itemView.findViewById(R.id.txtevaluation);
            report = itemView.findViewById(R.id.txtreport);
            imageView = itemView.findViewById(R.id.imagentsunami);
        }
    }
}
