package com.linkstar.app.store.bean;

/**
 * Created by hx
 * Time 2018/12/17/017.
 */

public class GoodsMsgBean {
    private Integer goodsId;
    private Integer goodsImg;
    private String goodsName;
    private Integer leftNum;
    private Integer soldNum;
    private Integer price;

    public GoodsMsgBean(Integer goodsId, Integer goodsImg, String goodsName, Integer leftNum, Integer soldNum, Integer price) {
        this.goodsId = goodsId;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.leftNum = leftNum;
        this.soldNum = soldNum;
        this.price = price;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(Integer goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
