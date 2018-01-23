package sp.fr.conference;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sp.fr.conference.model.Conference;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdministratorListingThemeFragment extends Fragment {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference themeReference;
    private ListView themesListView ;
    private List<Conference> ConferenceList;
    private ConferenceArrayAdapter adapter;

    public AdministratorListingThemeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_administrator_listing, container, false);

        //Préparation de la base de données
        firebaseDatabase = FirebaseDatabase.getInstance();
        themeReference = firebaseDatabase.getReference().child("conference");

        //Rcupération de la listView
        themesListView = view.findViewById(R.id.ListViewThemesWaiting);

        ConferenceList = new ArrayList<>();

        //Instanciation de la liste
        adapter = new ConferenceArrayAdapter(this.getActivity(), R.layout.theme_list_items_waiting , ConferenceList);
        themesListView.setAdapter(adapter);


        themeReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Réinitialisation de la liste
                ConferenceList.clear();

                //Boucle sur l'ensemble des noeuds
                for(DataSnapshot themeSnapshot : dataSnapshot.getChildren()) {

                    //Création d'une instance de theme et hydratation avec les données du snapshot
                    Conference themeConf = (Conference)themeSnapshot.getValue(Conference.class);

                    String name = themeSnapshot.getChildren().toString();

                    //Ajout du theme à la liste
                    ConferenceList.add(themeConf);


                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    private class ConferenceArrayAdapter extends ArrayAdapter<Conference> {

        private Activity context;
        int resource;
        List<Conference> data;

        public ConferenceArrayAdapter(Activity context, int resource, List<Conference> data) {
            super(context, resource, data);

            this.context = context;
            this.resource = resource;
            this.data = data;

        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View view = context.getLayoutInflater().inflate(this.resource, parent, false);

            Conference currentConference = ConferenceList.get(position);

            TextView textView = view.findViewById(R.id.themeListTextItemWaiting);

            textView.setText(
                    currentConference.getTitle()
            );

            return view;
        }


    }

}
