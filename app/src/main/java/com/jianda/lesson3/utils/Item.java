package com.jianda.lesson3.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 15-12-29.
 */
public class Item {
    private long userId;
    private String userIcon;
    private String userName;
    private String content;
    private String image;

    public Item(JSONObject object) throws JSONException {
       if(! object.isNull("user")){
           userId = object.getJSONObject("user").getLong("id");
           userIcon = object.getJSONObject("user").getString("icon");
           userName = object.getJSONObject("user").getString("login");
       }
        content = object.getString("content");
        if (!object.isNull("image")) {
            image = object.getString("image");
        }
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
