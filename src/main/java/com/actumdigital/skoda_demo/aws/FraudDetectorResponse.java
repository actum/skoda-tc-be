package com.actumdigital.skoda_demo.aws;

import java.io.Serializable;

public class FraudDetectorResponse implements Serializable {

    private Float score;

    public FraudDetectorResponse(Float score) {
        this.score = score;
    }

    public Float getScore() {
        return score;
    }
}
