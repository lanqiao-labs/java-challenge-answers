package org.lanqiao.exception;

public class ScoreException extends Exception{

    private static final long serialVersionUID = 1L;

    private String message;

    public ScoreException(double score) {
        this.message = "成绩设置为：" + score + "不合理！";
    }

    @Override
    public String toString() {
        return message;
    }
}