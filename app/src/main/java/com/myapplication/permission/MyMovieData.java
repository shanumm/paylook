//package com.myapplication.permission;
////
////public class priceData {
////    private Integer priceAmount;
////    private String sendReceived;
////    private String time;
////
////    public priceData(Integer priceAmount, String sendReceived, String time) {
////        this.priceAmount = priceAmount;
////        this.sendReceived = sendReceived;
////        this.time = time;
////    }
////
////    public Integer getPriceAmount() {
////        return priceAmount;
////    }
////
////    public void setPriceAmount(Integer priceAmount) {
////        this.priceAmount = priceAmount;
////    }
////
////    public String getSendReceived() {
////        return sendReceived;
////    }
////
////    public void setSendReceived(String sendReceived) {
////        this.sendReceived = sendReceived;
////    }
////
////    public String getTime() {
////        return time;
////    }
////
////    public void setTime(String time) {
////        this.time = time;
////    }
////}
//
package com.myapplication.permission;

public class MyMovieData {

    private String movieName;
    private String movieDate;
    private Integer movieImage;

    public MyMovieData(String movieName, String movieDate, Integer movieImage) {
        this.movieName = movieName;
        this.movieDate = movieDate;
        this.movieImage = movieImage;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }
}



