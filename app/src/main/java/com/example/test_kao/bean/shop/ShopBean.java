package com.example.test_kao.bean.shop;

import java.util.List;

public class ShopBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":636,"user_id":5,"session_id":"1","goods_id":1116033,"goods_sn":"1116033","product_id":171,"goods_name":"多功能人体工学转椅","market_price":1399,"retail_price":1399,"number":9,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/f1dbf1d9967c478ee6def81ed40734a2.png"}],"cartTotal":{"goodsCount":9,"goodsAmount":12591,"checkedGoodsCount":9,"checkedGoodsAmount":12591}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cartList : [{"id":636,"user_id":5,"session_id":"1","goods_id":1116033,"goods_sn":"1116033","product_id":171,"goods_name":"多功能人体工学转椅","market_price":1399,"retail_price":1399,"number":9,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/f1dbf1d9967c478ee6def81ed40734a2.png"}]
         * cartTotal : {"goodsCount":9,"goodsAmount":12591,"checkedGoodsCount":9,"checkedGoodsAmount":12591}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 9
             * goodsAmount : 12591
             * checkedGoodsCount : 9
             * checkedGoodsAmount : 12591
             */

            private int goodsCount;
            private double goodsAmount;
            private int checkedGoodsCount;
            private double checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public double getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(double goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public double getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(double checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 636
             * user_id : 5
             * session_id : 1
             * goods_id : 1116033
             * goods_sn : 1116033
             * product_id : 171
             * goods_name : 多功能人体工学转椅
             * market_price : 1399
             * retail_price : 1399
             * number : 9
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 1
             * list_pic_url : http://yanxuan.nosdn.127.net/f1dbf1d9967c478ee6def81ed40734a2.png
             */

            private int id;
            private int user_id;
            private String session_id;
            private int goods_id;
            private String goods_sn;
            private int product_id;
            private String goods_name;
            private String market_price;
            private double retail_price;
            private int number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private int checked;
            private String list_pic_url;

            public boolean selectOrder;  //下单状态
            public boolean selectEdit;  //编辑状态

            public boolean isSelectOrder() {
                return selectOrder;
            }

            public void setSelectOrder(boolean selectOrder) {
                this.selectOrder = selectOrder;
            }

            public boolean isSelectEdit() {
                return selectEdit;
            }

            public void setSelectEdit(boolean selectEdit) {
                this.selectEdit = selectEdit;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public double getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(double retail_price) {
                this.retail_price = retail_price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
