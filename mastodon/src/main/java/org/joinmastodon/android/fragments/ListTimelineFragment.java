package org.joinmastodon.android.fragments;

import android.app.Activity;
import android.media.MediaRouter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.joinmastodon.android.R;
import org.joinmastodon.android.api.requests.timelines.GetListTimeline;
import org.joinmastodon.android.model.Status;

import java.util.List;

import me.grishka.appkit.Nav;
import me.grishka.appkit.api.SimpleCallback;
import me.grishka.appkit.utils.V;


public class ListTimelineFragment extends StatusListFragment {
    private String listID;
    private String listTitle;
    private ImageButton fab;

    public ListTimelineFragment() {
        setListLayoutId(R.layout.recycler_fragment_with_fab);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        listID=getArguments().getString("listID");
        listTitle=getArguments().getString("listTitle");
        setTitle(listTitle);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        // TODO: implement edit, delete
        // inflater.inflate(R.menu.list, menu);
    }

    @Override
    protected void doLoadData(int offset, int count) {
        currentRequest=new GetListTimeline(listID, offset==0 ? null : getMaxID(), null, count, null)
                .setCallback(new SimpleCallback<>(this) {
                    @Override
                    public void onSuccess(List<Status> result) {
                        onDataLoaded(result, !result.isEmpty());
                    }
                })
                .exec(accountID);
    }

    @Override
    protected void onShown() {
        super.onShown();
        if(!getArguments().getBoolean("noAutoLoad") && !loaded && !dataLoading)
            loadData();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab=view.findViewById(R.id.fab);
        fab.setOnClickListener(this::onFabClick);
    }

    private void onFabClick(View v){
        Bundle args=new Bundle();
        args.putString("account", accountID);
        Nav.go(getActivity(), ComposeFragment.class, args);
    }

    @Override
    protected void onSetFabBottomInset(int inset) {
        ((ViewGroup.MarginLayoutParams) fab.getLayoutParams()).bottomMargin=V.dp(24)+inset;
    }
}
