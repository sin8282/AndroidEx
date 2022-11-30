package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.hardware.Camera;
import android.media.CamcorderProfile;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class VideoRecordeActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    // abandoned 뜨는데 노상관해도됨 영향을 끼치는 일은 없음...
    private Camera camera;
    private MediaRecorder mediaRecorder;
    private Button btn_record;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recorde);

        TedPermission.create()
                .setPermissionListener(permission)
                .setRationaleMessage("녹화를 권한 허용해주세요")
                .setDeniedMessage("아니 권한 달라고 십쌔야")
                .setPermissions(Manifest.permission.CAMERA
                        , Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.RECORD_AUDIO)
                .check();

        btn_record = findViewById(R.id.btn_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRecording){
                    mediaRecorder.stop();
                    mediaRecorder.release();
                    camera.lock();
                    isRecording = false;
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(VideoRecordeActivity.this, "녹화가 실행되었습니다.", Toast.LENGTH_SHORT).show();
                            try{
                                mediaRecorder = new MediaRecorder();
                                camera.unlock();
                                mediaRecorder.setCamera(camera);
                                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
                                mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                                mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));
                                mediaRecorder.setOrientationHint(90);
                                mediaRecorder.setOutputFile("/storage/emulated/0/Download/test.mp4");//Environment.getExternalStorageDirectory()
                                mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
                                mediaRecorder.prepare();
                                mediaRecorder.start();
                                isRecording = true;
                            }catch (Exception e){
                                mediaRecorder.release();
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        });


    }

    PermissionListener permission = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(VideoRecordeActivity.this, "권한 허용", Toast.LENGTH_SHORT).show();

            camera = Camera.open();
            camera.setDisplayOrientation(90);
            surfaceView = findViewById(R.id.surface_view);
            surfaceHolder = surfaceView.getHolder();
            surfaceHolder.addCallback(VideoRecordeActivity.this);
            surfaceHolder.setType(surfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            Toast.makeText(VideoRecordeActivity.this, "권한 거부", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    private void refreshCamera(Camera camera){
        if(surfaceHolder.getSurface() == null){
            return;
        }

        try {
            camera.stopPreview();
        }catch (Exception e){
            e.printStackTrace();
        }

        setCamera(camera);
    }

    private void setCamera(Camera cam){
        camera = cam;
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        refreshCamera(camera);
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
    }
}