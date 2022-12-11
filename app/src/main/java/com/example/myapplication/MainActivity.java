package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edText;
    private Button btn;
    private ImageView iv;
    private Button intentBtn;
    private Button listItem;
    private Button navi;
    private Button shared;
    private Button webView;
    private Button camera;
    private Button recycle_btn;
    private Button fragment_btn;
    private Button thread_btn;
    private Button dialog_btn;
    private Button service_btn;
    private Button record_btn;
    private Button push_btn;
    private Button spinner_btn;
    private Button musicplayer_btn;
    private Button goBack_btn;
    private Button googleMap;
    private Button bottomNavi;
    private Button saf;
    private Button selector;
    private Button LoginTest;
    private Button broadcast_btn;
    private Button videoview_btn;
    private Button firebaseListExample;
    private Button viewPagerEx;
    private Button checkBoxEx;
    private Button radioBoxEx;
    private Button linearLayoutEx;
    private Button relativeLayoutEx;
    private Button constraintLayoutEx;
    private Button googleLoginEx;
    private Button tableLayoutEx;
    private Button fragmentBundleEx;
    private Button CardViewEx;
    private Button ViewBindingEx;
    private Button LifeCycleEx;
    private Button KakaoLoginEx;
    private Button RoomDatabaseEx;
    private Button RegisterForActivityResult;

// git 테스트
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edtext);
        btn= findViewById(R.id.btn);
        //iv = findViewById(R.id.iv); // 이미지 띄우고 클릭하면 뭔가 실행하게 하기.
        intentBtn = findViewById(R.id.intentBtn); // 기본적인 화면전환방법 intent
        listItem = findViewById(R.id.listItem); // 리스트 자료 불러오기
        navi = findViewById(R.id.navi); // 옆에서 날라오는 네비바
        shared = findViewById(R.id.shared); // 앱이 꺼지더라도 값을 저장하고 있는 데이터 예제, 앱 사용자설정 등에 사용가능.
        webView = findViewById(R.id.webView); // 앱에서 웹키기
        camera = findViewById(R.id.camera); // 카메라 예제
        recycle_btn = findViewById(R.id.recycle_btn); // 리사이클 예제 컨텐츠를 추가할때 화면을 재활용하는 방법
        fragment_btn = findViewById(R.id.fragment_btn); // 프레이그먼트 예제 화면전환
        thread_btn = findViewById(R.id.thread_btn); // 쓰레드 예제
        dialog_btn = findViewById(R.id.dialog_btn); // 다이얼로그 확인창을 띄워서 입력 및 취소를 받아옴
        service_btn = findViewById(R.id.service_btn); //백그라운드에서 프로그램 실행되는예제 노래로 예제만듬
        record_btn = findViewById(R.id.record_btn); // 동영상 녹화하고 저장하는 앱 경로 다운로드로 되어있음
        push_btn = findViewById(R.id.push_btn); // 푸시 알림 설정하는 예제 구글api이용
        spinner_btn = findViewById(R.id.spinner_btn); //셀렉트 매뉴 펼쳐지는 예제
        musicplayer_btn = findViewById(R.id.musicplayer_btn); // 뮤직앱
        goBack_btn = findViewById(R.id.goBack_btn); // 뒤로가기 버튼
        googleMap = findViewById(R.id.googleMap); // 구글맵 구글api이용
        bottomNavi = findViewById(R.id.bottomNavi); // 화면 하단에 네비버튼 만들기
        saf = findViewById(R.id.saf); // 값받은거 부모화면으로 보내기 StartActivityForResult
        selector = findViewById(R.id.selector_btn); // 버튼 클릭 시 hover기능
        LoginTest = findViewById(R.id.LoginTest); // 로그인을 위한 기능 안드로이드에서는 보안때문에 내부 DB 페키지를 이용 할 수 없다. 따라서 db접속 및 리턴 서버를 따로 만들어 거기에 요청하고 받는 식으로 진행한다.
        broadcast_btn = findViewById(R.id.broadcast_btn); //상태값 체크하기(네퉉,배터리량 등등)
        videoview_btn = findViewById(R.id.videoview_btn); //비디오 뷰 보기
        firebaseListExample = findViewById(R.id.firebaseListExample); // firebase란 db에접속해서 리스트 형식으로 불러오기
        viewPagerEx = findViewById(R.id.viewPagerEx); // 뷰페이저 ex
        checkBoxEx = findViewById(R.id.checkBoxEx); // 체크박스
        radioBoxEx = findViewById(R.id.radioBoxEx); // 라디오박스
        linearLayoutEx = findViewById(R.id.linearLayoutEx);
        relativeLayoutEx = findViewById(R.id.relativeLayoutEx);
        constraintLayoutEx = findViewById(R.id.constraintLayoutEx);
        googleLoginEx = findViewById(R.id.googleLoginEx); // 구글로그인 서비스를 테스트한다. 서비스는 파이어베이스 콘솔에서 작업하며, 디펜던시와 json파일을 등록하고 Authentication 탭에서 사용권한을 사용으로 해야 작동한다.
        tableLayoutEx = findViewById(R.id.tableLayoutEx); // 테이블을 생성해보는 예제
        fragmentBundleEx = findViewById(R.id.fragmentBundleEx); // 프레이그먼트간에 화면 움직임없이 번들로 넘기는 방법
        CardViewEx = findViewById(R.id.cardViewEx);
        ViewBindingEx = findViewById(R.id.viewBindingEx); // <<findViewById를 사용하여 매번 선언하는 과정을 ViewBinding을 통해 한번에 해결가능해진다. 개편함.
        LifeCycleEx = findViewById(R.id.lifeCycleEx); // 안드로이드에 기본이 되는 라이프사이클을 확인해볼수있다.
        KakaoLoginEx = findViewById(R.id.KakaoLoginEx); // 카카오 로그인
        RoomDatabaseEx = findViewById(R.id.RoomDatabaseEx); // 내부데이터베이스 사용하는법
        RegisterForActivityResult = findViewById(R.id.RegisterForActivityResult);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edText.setText("버튼을 누르셨군요!");
            }
        });


/*        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext()
                        ,"안녕하세요 확인창입니다."
                        ,Toast.LENGTH_SHORT).show();
            }
        });*/

        intentBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                String str = edText.getText().toString();
                intent.putExtra("str",str);
                startActivity(intent);

            }
        });

        listItem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        navi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        });

        shared.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SharedActivity.class);
                startActivity(intent);
            }
        });

        webView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        recycle_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        fragment_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });

        thread_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(intent);
            }
        });

        dialog_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        service_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        record_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoRecordeActivity.class);
                startActivity(intent);
            }
        });

        push_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pushTestActivity.class);
                startActivity(intent);
            }
        });

        spinner_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        musicplayer_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicPlayerActivity2.class);
                startActivity(intent);
            }
        });

        goBack_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BackButtonActivity.class);
                startActivity(intent);
            }
        });

        googleMap.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoogleMapActivity.class);
                startActivity(intent);
            }
        });

        bottomNavi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BottomNaviActivity.class);
                startActivity(intent);
            }
        });

        saf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartActivityForResult.class);
                startActivity(intent);
            }
        });

        selector.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectorActivity.class);
                startActivity(intent);
            }
        });

        LoginTest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        broadcast_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroadCastReceiver.class);
                startActivity(intent);
            }
        });

        videoview_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoViewExActivity.class);
                startActivity(intent);
            }
        });

        firebaseListExample.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirebaseListExample.class);
                startActivity(intent);
            }
        });

        viewPagerEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewPagerEx.class);
                startActivity(intent);
            }
        });

        checkBoxEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CheckBoxEx.class);
                startActivity(intent);
            }
        });

        radioBoxEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RadioButtonEx.class);
                startActivity(intent);
            }
        });

        linearLayoutEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearLayout.class);
                startActivity(intent);
            }
        });

        relativeLayoutEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        constraintLayoutEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConstraintLayout.class);
                startActivity(intent);
            }
        });

        googleLoginEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GoogleLoginEx.class);
                startActivity(intent);
            }
        });

        tableLayoutEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TableLayoutEx.class);
                startActivity(intent);
            }
        });

        fragmentBundleEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentBundleEx.class);
                startActivity(intent);
            }
        });

        CardViewEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardViewEx.class);
                startActivity(intent);
            }
        });

        ViewBindingEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewBindingEx.class);
                startActivity(intent);
            }
        });

        LifeCycleEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LifeCycleEx.class);
                startActivity(intent);
            }
        });

        LifeCycleEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LifeCycleEx.class);
                startActivity(intent);
            }
        });

        KakaoLoginEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KakaoLoginEx.class);
                startActivity(intent);
            }
        });

        RoomDatabaseEx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RoomDatabaseEx.class);
                startActivity(intent);
            }
        });

        RegisterForActivityResult.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterForActivityResult.class);
                startActivity(intent);
            }
        });


    }
}