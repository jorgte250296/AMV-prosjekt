package models;

import java.math.BigDecimal;

/* Klasser med gettere og settere for ToolModel - velger å behold ubrukte metoder inntil videre. */
public class ToolModel {
    private int tool_id;
    private String toolName;
    private String toolDescription;
    private BigDecimal toolPrice;
    private short statusID;
    private CategoryModel toolCategoryID;

    public ToolModel(int tool_id, String toolName, String toolDescription, BigDecimal toolPrice, short statusID, CategoryModel toolCategoryID) {
        this.tool_id = tool_id;
        this.toolName = toolName;
        this.toolDescription = toolDescription;
        this.toolPrice = toolPrice;
        this.statusID = statusID;
        this.toolCategoryID = toolCategoryID;
    }

    public ToolModel(int tool_id) {
    }

    public int getTool_id() {
        return tool_id;
    }

    public CategoryModel getToolCategoryID() {
        return toolCategoryID;
    }

    public void setToolCategoryID(CategoryModel toolCategoryID) {
        this.toolCategoryID = toolCategoryID;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolDescription() {
        return toolDescription;
    }

    public void setToolDescription(String toolDescription) {
        this.toolDescription = toolDescription;
    }

    public BigDecimal getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(BigDecimal toolPrice) {
        this.toolPrice = toolPrice;
    }

    public int getToolStatusID() {
        return statusID;
    }

    public void setStatusID(short statusID) {
        this.statusID = statusID;
    }
}

