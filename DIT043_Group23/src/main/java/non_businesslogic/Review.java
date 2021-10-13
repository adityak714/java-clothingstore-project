package non_businesslogic;

public class Review {
    // ATTRIBUTES
   /* private String itemID;-----> am not sure if we are supposed to add the ID or not
    coz the facade and the test do have it. */
    private String reviewComment;
    private int reviewGrade;

    public Review( String reviewComment, int reviewGrade) {

        this.reviewComment = reviewComment;
        this.reviewGrade = reviewGrade;

    }
    public Review(int reviewGrade){

        this.reviewComment = "";
        this.reviewGrade = reviewGrade;

    }

    // Getters
    public String getComment() {return reviewComment;}
    public int getGrade() {return reviewGrade;}

    // Setters
    public void setComment(String newReviewComment) { this.reviewComment = newReviewComment;}
    public void setGrade(int newReviewGrade) { this.reviewGrade = newReviewGrade;}

    public String toString() {

        if(reviewComment.isBlank()){
            return "Grade: " + getGrade() + ".";
        }

        return "Grade: " + getGrade() + "." + getComment();
    }



}
