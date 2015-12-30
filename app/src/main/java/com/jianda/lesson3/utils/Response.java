package com.jianda.lesson3.utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 15-12-29.
 */
public class Response {

    /**
     * format : word
     * image : null
     * published_at : 1451346901
     * tag :
     * user : {"avatar_updated_at":1451392978,"last_visited_at":1327836426,"created_at":1327836426,"state":"active","email":" ","last_device":"ios_1.0","role":"n","login":"潇湘墨兰","id":441420,"icon":"20151229124258.jpg"}
     * image_size : null
     * id : 114462277
     * votes : {"down":-558,"up":21628}
     * created_at : 1451344564
     * content : 见学长夫妇，说是最近俩人一直分床睡，已经好几个月了。我还以为是关系冷淡期，关切地问怎么回事。学长含羞一笑，说俩人共同爱好太多，三观太和，永远有聊不完的话题，一不小心就唠到三四点，再愉快地啪啪一下，第二天根本没法起床上班...秀得我泪流满面…
     * state : publish
     * comments_count : 212
     * allow_comment : true
     * share_count : 799
     * type : hot
     */

    @SerializedName("items")
    private List<ItemsEntity> items;

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        private String format;
        private Object image;
        /**
         * avatar_updated_at : 1451392978
         * last_visited_at : 1327836426
         * created_at : 1327836426
         * state : active
         * email :
         * last_device : ios_1.0
         * role : n
         * login : 潇湘墨兰
         * id : 441420
         * icon : 20151229124258.jpg
         */

        private UserEntity user;
        private int id;
        /**
         * down : -558
         * up : 21628
         */

        private VotesEntity votes;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;
        private String type;

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public String getState() {
            return state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getType() {
            return type;
        }

        public static class UserEntity {
            private String login;
            private int id;
            private String icon;

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }

        public static class VotesEntity {
            private int down;
            private int up;

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }
    }
}
