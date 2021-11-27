package com.atguigu.crud.bean;

public class ScoreInfo extends ScoreInfoKey {
    private Float credit;

    private Float score;

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}