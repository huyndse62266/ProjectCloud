package prc391.service.dto;

public class CartDTO {
    private Long bookID;
    private Long quanity;

    public CartDTO(Long bookID, Long quanity) {
        this.bookID = bookID;
        this.quanity = quanity;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Long getQuanity() {
        return quanity;
    }

    public void setQuanity(Long quanity) {
        this.quanity = quanity;
    }
}
