package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Locale;

import io.reactivex.rxjava3.core.Observable;

public class rxJavaEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_ex);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.KOREA);
        Observable<String> justSrc = Observable.just(
                sdf.format(System.currentTimeMillis())
        );

        Observable<String> deferSrc = Observable.defer(() ->
                Observable.just(sdf.format(System.currentTimeMillis()))
        );

        System.out.println("현재시각1 : " + sdf.format(System.currentTimeMillis()));

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("현재시각2 : " + sdf.format(System.currentTimeMillis()));
        justSrc.subscribe(time ->
                System.out.println("justSrc : " + time)
        );

        deferSrc.subscribe(time ->
                System.out.println("deferSrc : " + time)
        );

        Observable.empty()
                .doOnTerminate(() -> System.out.println("empty 종료"))
                .subscribe();

        Observable.never()
                .doOnTerminate(() -> System.out.println("never 종료"))
                .subscribe();

    }
}