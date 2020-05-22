package com.example.myapplication.anim.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.anim.ArtDetailActivity;
import com.example.myapplication.anim.Constants;
import com.example.myapplication.anim.R;
import com.example.myapplication.anim.models.Artsy;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseArtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseArtViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindArtsy(Artsy artsy) {
        ImageView artImageView = (ImageView) mView.findViewById(R.id.artImageView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.artDescriptionTextView);
        TextView titleTextView = (TextView) mView.findViewById(R.id.titleTextView);
        TextView cultureTextView = (TextView) mView.findViewById(R.id.cultureTextView);


        Picasso.get().load(artsy.getPrimaryImageUrl()).into(artImageView);

        descriptionTextView.setText(artsy.getDescription());
        titleTextView.setText(artsy.getTitle());
        cultureTextView.setText(artsy.getCulture());
            }

    @Override
    public void onClick(View view) {
        final ArrayList<Artsy> mArtsies = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ARTS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mArtsies.add(snapshot.getValue(Artsy.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ArtDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(mArtsies));

                mContext.startActivity(intent);
            }

          /*  @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }*/

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

