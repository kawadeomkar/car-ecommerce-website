package com.uci.rest.model;



//You will need to create a Java Object. Jersey uses these to contruct requests and responses.

public class Todo {
    private String make;
    private String model;
    private String type;
    private String price;
    private String hp;
    private String homePic;
    private String id;
    private String mainPic;
    private String description;
    private String galleryPic1;
    private String galleryPic2;
    private String galleryPic3;
    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;
    private String feature5;
    //not used
    //private String summary;
    //private String description;

    public void setFeature5(String feature5) {
        this.feature5 = feature5;
    }

    public String getFeature5() {
        return feature5;
    }
    
    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getFeature4() {
        return feature4;
    }
    
    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature3() {
        return feature3;
    }
    
    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature2() {
        return feature2;
    }
    
    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature1() {
        return feature1;
    }
    
    public void setGalleryPic3(String galleryPic3) {
        this.galleryPic3 = galleryPic3;
    }

    public String getGalleryPic3() {
        return galleryPic3;
    }
    
    public void setGalleryPic2(String galleryPic2) {
        this.galleryPic2 = galleryPic2;
    }

    public String getGalleryPic2() {
        return galleryPic2;
    }
    
    public void setGalleryPic1(String galleryPic1) {
        this.galleryPic1 = galleryPic1;
    }

    public String getGalleryPic1() {
        return galleryPic1;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getMainPic() {
        return mainPic;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
    
    public void setHomePic(String homePic) {
        this.homePic = homePic;
    }

    public String getHomePic() {
        return homePic;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getHp() {
        return hp;
    }
    
    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}