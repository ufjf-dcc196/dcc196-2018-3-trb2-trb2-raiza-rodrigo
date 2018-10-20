package com.example.raiza.semanacomputacao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

    private List<Evento> evento;
    private EventoAdapter.OnEventoClickListener listener;

    public interface OnEventoClickListener {
        void onEventoClick(View view, int position);
    }

    public void setOnShortEventoClickListener(EventoAdapter.OnEventoClickListener listener){
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNome;

        public ViewHolder (View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.evt_txt_titulo);


            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onEventoClick(v, position);
                        }
                    }
                }
            });


        }

        @Override
        public void onClick(View v){
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onEventoClick(v, position);
                }
            }
        }
    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View linhaEvento = inflater.inflate(R.layout.evento_layout, parent, false);
        EventoAdapter.ViewHolder viewHolder = new EventoAdapter.ViewHolder(linhaEvento);

        return viewHolder;
    }


    public EventoAdapter(List<Evento> evento) {
        this.evento = evento;
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder holder, int position) {
        holder.txtNome.setText(evento.get(position).getTitulo());

    }

    @Override
    public int getItemCount() {
        return evento.size();
    }

}
