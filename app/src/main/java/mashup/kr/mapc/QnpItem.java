package mashup.kr.mapc;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jeongahri on 2018. 7. 1..
 */

public class QnpItem {

    ArrayList<String> labels = new ArrayList<>();
    String versus1;
    String versus2;

    float v1_ratio;
    float v2_ratio;

    public QnpItem(String versus1, String versus2, ArrayList<String> labels, float v1_raito, float v2_ratio) {
        this.versus1 = versus1;
        this.versus2 = versus2;
        this.labels = labels;
        this.v1_ratio = v1_raito;
        this.v2_ratio = v2_ratio;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    String getVersus1(){
        return this.versus1;
    }

    String getVersus2(){
        return this.versus2;
    }

    public float getV1_ratio() {
        return this.v1_ratio;
    }

    public float getV2_ratio() {
        return this.v2_ratio;
    }
}
