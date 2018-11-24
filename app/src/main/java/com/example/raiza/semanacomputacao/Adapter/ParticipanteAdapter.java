    package com.example.raiza.semanacomputacao.Adapter;

    import android.content.Context;
    import android.database.Cursor;
    import android.support.annotation.NonNull;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import com.example.raiza.semanacomputacao.Classes.Participante;
    import com.example.raiza.semanacomputacao.R;
    import com.example.raiza.semanacomputacao.SemCompContract;

    import java.util.List;

    public class ParticipanteAdapter extends RecyclerView.Adapter<ParticipanteAdapter.ViewHolder>  {
        private Cursor cursor;
        private OnParticipanteClickListener listener;


    public interface OnParticipanteClickListener {
        void onParticipanteClick(View view, int position);
        void onLongParticipanteClick(View view, int position);
    }

    public void setOnParticipanteClickListener(OnParticipanteClickListener listener){
        this.listener = listener;
    }

        public void SetCursor(Cursor c){
            this.cursor = c;
            notifyDataSetChanged();
        }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView txtNome;

        public ViewHolder (View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txt_ptc_nome);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onLongParticipanteClick(view, position);
                        }
                    }
                return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onParticipanteClick(v, position);
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
                    listener.onParticipanteClick(v, position);
                }
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (listener!=null){
                int position = getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listener.onLongParticipanteClick(view, position);
                }
            }
            return true;
        }
    }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View linhaParticipante = inflater.inflate(R.layout.participante_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(linhaParticipante);

            return viewHolder;
        }


        public ParticipanteAdapter(Cursor c) {
            this.cursor = c;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            int idxTitulo = cursor.getColumnIndexOrThrow(SemCompContract.Participante.COLUMN_NAME_NOME);
            cursor.moveToPosition(position);
            holder.txtNome.setText(String.valueOf(cursor.getString(idxTitulo)));
        }

        @Override
        public int getItemCount() {
            return cursor.getCount();
        }

        @Override
        public long getItemId(int position) {
            int idxID = cursor.getColumnIndexOrThrow(SemCompContract.Participante._ID);
            cursor.moveToPosition(position);
            return cursor.getLong(idxID);
        }

    }
