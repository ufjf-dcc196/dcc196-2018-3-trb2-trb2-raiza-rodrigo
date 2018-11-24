package com.example.raiza.semanacomputacao.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raiza.semanacomputacao.Classes.Evento;
import com.example.raiza.semanacomputacao.R;
import com.example.raiza.semanacomputacao.SemCompContract;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {
    private Cursor cursor;
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


    public EventoAdapter(Cursor c) {
        this.cursor = c;
    }

    public void SetCursor(Cursor c){
        this.cursor = c;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder holder, int position) {
        int idxTitulo = cursor.getColumnIndexOrThrow(SemCompContract.Evento.COLUMN_NAME_TITULO);
        cursor.moveToPosition(position);
        holder.txtNome.setText(String.valueOf(cursor.getString(idxTitulo)));

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    @Override
    public long getItemId(int position) {
        int idxID = cursor.getColumnIndexOrThrow(SemCompContract.Evento._ID);
        cursor.moveToPosition(position);
        return cursor.getLong(idxID);
    }
}
