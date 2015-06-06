package io.exponential.actionbar;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {
    private static final String ARG_MESSAGE = "MainFragment.MESSAGE";

    private String message;

    private Callbacks callbacks;

    /**
     * Factory method to create a new instance of MainFragment.
     *
     * @param message Message sent during instance creation.
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance(String message) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    View.OnClickListener handleDisplayBActivityClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callbacks.displayBActivity();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getString(ARG_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Event handlers
        Button displayBActivity = (Button) view.findViewById(R.id.display_bactivity);
        displayBActivity.setOnClickListener(handleDisplayBActivityClick);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void displayBActivity();
    }

}
