/*
 * Copyright (c) 2015 SatuSatuDua.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package id.satusatudua.sigap.ui;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import butterknife.Bind;
import butterknife.OnClick;
import id.satusatudua.sigap.R;
import id.satusatudua.sigap.data.local.CacheManager;
import id.zelory.benih.ui.BenihActivity;

/**
 * Created on : January 17, 2016
 * Author     : zetbaitsu
 * Name       : Zetra
 * Email      : zetra@mail.ugm.ac.id
 * GitHub     : https://github.com/zetbaitsu
 * LinkedIn   : https://id.linkedin.com/in/zetbaitsu
 */
public class CalibrateActivity extends BenihActivity implements ShakeDetector.Listener {

    @Bind(R.id.shaking_image) ImageView shakingImage;
    @Bind(R.id.status) TextView status;

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_calibrate;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        CacheManager.pluck().setShakeToNotify(false);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shakeDetector = new ShakeDetector(this);
        shakeDetector.start(sensorManager);
    }

    @OnClick(R.id.button_save)
    public void save() {
        if (shakingImage.getVisibility() == View.VISIBLE) {
            CacheManager.pluck().setShakeToNotify(true);
        }
        finish();
    }

    @Override
    public void hearShake() {
        shakingImage.setVisibility(View.VISIBLE);
        status.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (shakingImage.getVisibility() == View.VISIBLE) {
            CacheManager.pluck().setShakeToNotify(true);
        }
    }
}
