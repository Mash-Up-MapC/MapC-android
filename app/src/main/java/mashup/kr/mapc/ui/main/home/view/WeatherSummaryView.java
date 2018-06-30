package mashup.kr.mapc.ui.main.home.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

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
    }


}
