    package com.example.raiza.semanacomputacao;

    import android.content.Context;
    import android.support.annotation.NonNull;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import java.util.List;

    public class ParticipanteAdapter extends RecyclerView.Adapter<ParticipanteAdapter.ViewHolder>  {

        private List<Participante> participante;
        private OnParticipanteClickListener listener;

    public interface OnParticipanteClickListener {
        void onParticipanteClick(View view, int position);
    }

    public void setOnShortParticipanteClickListener(OnParticipanteClickListener listener){
            this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtNome;

        public ViewHolder (View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txt_ptc_nome);


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


        public ParticipanteAdapter(List<Participante> participante) {
            this.participante = participante;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtNome.setText(participante.get(position).getUsuario());

        }

        @Override
        public int getItemCount() {
            return participante.size();
        }

    }
