package droidmentor.tabwithviewpager.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import droidmentor.tabwithviewpager.R;
import droidmentor.tabwithviewpager.ViewPager.CustomTabActivity;
import droidmentor.tabwithviewpager.interfaces.CallInterface;
import droidmentor.tabwithviewpager.interfaces.EventCall;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment implements EventCall {


    public CallsFragment() {
        // Required empty public constructor
    }

    CallInterface callInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();

        ((CustomTabActivity) context).eventCall = this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("CallsFragment", "onCreate");
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        callInterface = (CallInterface) getActivity();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_calls_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void getCallData() {
        Log.e("CallsFragment", "getData_Called");
        try {
            JSONObject jObjCallFragment = new JSONObject();
            jObjCallFragment.put("One", "A");
            jObjCallFragment.put("Two", "B");
            jObjCallFragment.put("Three", "C");
            jObjCallFragment.put("Four", "D");
            callInterface.dataOne(jObjCallFragment);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
