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
import droidmentor.tabwithviewpager.interfaces.ChatInterface;
import droidmentor.tabwithviewpager.interfaces.EventChat;

public class ChatFragment extends Fragment implements EventChat {

    public ChatFragment() {

    }
    ChatInterface chatInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
        ((CustomTabActivity) context).eventChat = this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ChatFragment", "onCreate");
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chatInterface = (ChatInterface) getActivity();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            inflater.inflate(R.menu.menu_chat_fragment, menu);
            super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void getChatData() {
        Log.e("ChatFragment", "getChatData_Called");
        try {
            JSONObject jObjChatFragment = new JSONObject();
            jObjChatFragment.put("Five", "E");
            jObjChatFragment.put("Six", "F");
            jObjChatFragment.put("Seven", "G");
            jObjChatFragment.put("Eight", "H");
            chatInterface.dataTwo(jObjChatFragment);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
