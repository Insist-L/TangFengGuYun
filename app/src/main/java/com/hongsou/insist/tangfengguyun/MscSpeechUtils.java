package com.hongsou.insist.tangfengguyun;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

/**
 * 作者：***
 * 版本：1.0
 * 创建日期：2018/7/24 0024
 * 描述：
 * 修订历史：
 * ┌─┐       ┌─┐
 * ┌──┘ ┴───────┘ ┴──┐
 * │                 │
 * │       ───       │
 * │  ─┬┘       └┬─  │
 * │                 │
 * │       ─┴─       │
 * │                 │
 * └───┐         ┌───┘
 * │         │
 * │         │
 * │         │
 * │         └──────────────┐
 * │                        │
 * │                        ├─┐
 * │                        ┌─┘
 * │                        │
 * └─┐  ┐  ┌───────┬──┐  ┌──┘
 * │ ─┤ ─┤       │ ─┤ ─┤
 * └──┴──┘       └──┴──┘
 * 神兽保佑
 * 代码无BUG!
 */


public class MscSpeechUtils {
    //语音
    public static void speech(String speechStr, Context context) {
        SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.createSynthesizer(context, null);
        speechSynthesizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        speechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoqi");
        speechSynthesizer.setParameter(SpeechConstant.VOLUME, "100");
        speechSynthesizer.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        speechSynthesizer.startSpeaking(speechStr, new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {
            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {
            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onCompleted(SpeechError speechError) {
                if (speechError == null) {

                } else if (speechError != null) {

                }
            }

            @Override
            public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {

            }
        });

    }
}
