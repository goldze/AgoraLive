package io.agora.vlive.ui.live;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.agora.vlive.Global;
import io.agora.vlive.R;
import io.agora.vlive.ui.components.LiveBottomButtonLayout;
import io.agora.vlive.ui.components.LiveHostInSeatAdapter;
import io.agora.vlive.ui.components.LiveRoomMessageList;
import io.agora.vlive.ui.components.LiveRoomParticipantLayout;

public class HostInLiveActivity extends BaseLiveActivity implements View.OnClickListener {
    private LiveRoomParticipantLayout mParticipants;
    private LiveRoomMessageList mMessageList;
    private LiveBottomButtonLayout mBottomButtons;
    private RecyclerView mSeatRecyclerView;
    private LiveHostInSeatAdapter mSeatAdapter;
    private boolean mIsHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_in);
        hideStatusBar(false);
        mIsHost = getIntent().getBooleanExtra(Global.Constants.KEY_IS_HOST, false);
        initUI();
    }

    private void initUI() {
        mParticipants = findViewById(R.id.host_in_participant);
        mParticipants.setIconResource("fake_icon_2.jpeg");
        mParticipants.setIconResource("fake_icon_3.jpeg");
        mParticipants.setIconResource("fake_icon_2.jpeg");
        mParticipants.setIconResource("fake_icon_3.jpeg");

        mMessageList = findViewById(R.id.message_list);
        mMessageList.addMessage("康康有毒", "他说会因为那一分钟而永远记住我，那时候我觉得很动听。但现在我看着时钟，我就告诉我自己，我要从这一分钟开始忘掉");
        mMessageList.addMessage("康康有毒", "他说会因为那一分钟而永远记住我，那时候我觉得很动听。但现在我看着时钟，我就告诉我自己，我要从这一分钟开始忘掉");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("康康有毒", "他说会因为那一分钟而永远记住我，那时候我觉得很动听。但现在我看着时钟，我就告诉我自己，我要从这一分钟开始忘掉");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.addMessage("起司甜甜", "何必在乎其它人");
        mMessageList.notifyDataSetChanged();

        mSeatRecyclerView = findViewById(R.id.live_host_in_seat_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this,
                3, RecyclerView.VERTICAL, false);
        mSeatRecyclerView.setLayoutManager(layoutManager);
        mSeatAdapter = new LiveHostInSeatAdapter(this);
        mSeatRecyclerView.setAdapter(mSeatAdapter);

        mBottomButtons = findViewById(R.id.host_in_bottom_layout);
        mBottomButtons.setHost(mIsHost);
        findViewById(R.id.live_bottom_btn_close).setOnClickListener(this);
        findViewById(R.id.live_bottom_btn_more).setOnClickListener(this);
        findViewById(R.id.live_bottom_btn_fun1).setOnClickListener(this);
        findViewById(R.id.live_bottom_btn_fun2).setOnClickListener(this);
    }

    @Override
    protected void onGlobalLayoutCompleted() {
        View topLayout = findViewById(R.id.host_in_top_participant_layout);
        RelativeLayout.LayoutParams params =
                (RelativeLayout.LayoutParams) topLayout.getLayoutParams();
        params.topMargin += systemBarHeight;
        topLayout.setLayoutParams(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.live_bottom_btn_close:
                showDialog(R.string.finish_broadcast_title,
                        R.string.finish_broadcast_message, this);
                break;
            case R.id.live_bottom_btn_more:
                break;
            case R.id.live_bottom_btn_fun1:
                if (mIsHost) {

                } else {

                }
                break;
            case R.id.live_bottom_btn_fun2:
                // this button is hidden when
                // current user is not host.
                if (mIsHost) {
                    showActionSheetDialog(ACTION_SHEET_BEAUTY);
                }
                break;
            case R.id.dialog_positive_button:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        showDialog(R.string.finish_broadcast_title,
                R.string.finish_broadcast_message, this);
    }
}
