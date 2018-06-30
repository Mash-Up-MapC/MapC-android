package mashup.kr.mapc.ui.main.home.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import mashup.kr.mapc.R;

public class WeatherSummaryView extends FrameLayout {

    public WeatherSummaryView(@NonNull Context context) {
        super(context);

        init();
    }

    public WeatherSummaryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_weather_summary, this);


        View temperatureView = findViewById(R.id.temperature);
        View humidityView = findViewById(R.id.humidity);
        View windView = findViewById(R.id.wind);
        View dustView = findViewById(R.id.dust);

        bindData(
                temperatureView,
                "체감온도",
                "26'",
                "따뜻",
                R.drawable.icon_sun
        );
        bindData(
                humidityView,
                "습도",
                "82%",
                "습함",
                R.drawable.icon_umbrella_black
        );
        bindData(
                windView,
                "바람세기",
                "2m/s",
                "약함",
                R.drawable.icon_wind
        );
        bindData(
                dustView,
                "미세먼지",
                "나쁨",
                "",
                R.drawable.icon_mask
        );
    }

    private void bindData(View view, String title, String subTitle1, String subTitle2, int drawableRes) {
        ((TextView) view.findViewById(R.id.title)).setText(title);
        ((TextView) view.findViewById(R.id.subtitle_1)).setText(subTitle1);
        ((TextView) view.findViewById(R.id.subtitle_2)).setText(subTitle2);
        ((ImageView) view.findViewById(R.id.image)).setImageResource(drawableRes);
    }

}
