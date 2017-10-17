package com.example.usmanahmed.phonelogtwo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class BlankFragment extends Fragment {
    View view;
    static ArrayList<Contact> dataModels;
    private static RecyclerAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_blank, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        dataModels = new ArrayList<>();
        adapter = new RecyclerAdapter(dataModels,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerListener(getContext(), recyclerView, new RecyclerListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (view.getId() == R.id.item_info) {

                } else {
                    Contact contact = dataModels.get(position);
                    Gson gson=new Gson();
                    String datatosend=gson.toJson(contact);
                    onButtonPressed(datatosend);
                }

            }

            @Override
            public void onLongClick(View view, int position) {


            }
        }));
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String string) {
        if (mListener != null) {
            mListener.onFragmentInteraction(string);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public void show(Context mContext)
    {
        Toast.makeText(mContext,"done",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String string);
    }
}