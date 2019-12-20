package domain;

public class Comment {
    private int topicId;
    private String name;
    private String commentText;
    private int rating;
    private String guid;

    public Comment(int topicId, String name, String commentText, int rating, String guid) {
        setTopicId(topicId);
        setName(name);
        setCommentText(commentText);
        setRating(rating);
        setGuid(guid);
    }

    public Comment() {}


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getCommentText() {
        return commentText;
    }

    private void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        if (rating > 10 || rating < 0) {
            throw new IllegalArgumentException("This rating is invalid");
        }
        else {
            this.rating = rating;
        }
    }

}
