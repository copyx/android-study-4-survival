package com.copyx.androidstudy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

/*
 * 화면의 위쪽과 아래쪽을 나눈 후
 * 위쪽에는 이미지를 선택할 수 있는 리스트가 보이는 프래그먼트를 만들어 넣고
 * 아래쪽에는 선택된 이미지가 보이는 프래그먼트를 만들어 넣을 것입니다.
 * 그러면 위쪽 프래그먼트에서 선택한 이미지가 어떤 것인지를 액티비티에 알려준 후
 * 액티비티에서 아래 쪽 프래그먼트에 해당 이미지가 보이도록 해야 합니다.
 */


public class TwoFragmentInOneActivity extends AppCompatActivity {
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    String[] texts = {"This is test!", "Hello, world!!!", "AndroidiordnA"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_fragment_in_one);

        FragmentManager fragmentManager = getSupportFragmentManager();
        listFragment = (ListFragment) fragmentManager.findFragmentById(R.id.list_fragment);
        viewerFragment = (ViewerFragment) fragmentManager.findFragmentById(R.id.viewer_fragment);

        listFragment.callback = new ListFragment.ImageSelectionCallback() {
            @Override
            public void onImageSelected(int position) {
                viewerFragment.setText(texts[position]);
            }
        };
    }
}
