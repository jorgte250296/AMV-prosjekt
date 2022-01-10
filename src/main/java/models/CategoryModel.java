package models;

/* Klasser med gettere og settere for CategoryModel - velger å behold ubrukte metoder inntil videre (ubrukte står i grått). */
public class CategoryModel {
    private String category;
    private int categoryID;

    public CategoryModel(String category, int categoryID) {
        this.category = category;
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
