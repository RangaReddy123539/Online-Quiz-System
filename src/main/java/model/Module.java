package model;

import java.sql.Date;

public class Module {

    private int moduleId;
    private String moduleName;
    private String description;
    private String category;
    private String pdfFilename;
    private String pdfPath;
    private Date createdDate;
    private int adminId;

    // Default Constructor
    public Module() {
    }

    // Parameterized Constructor
    public Module(int moduleId, String moduleName, String description,
                  String category, String pdfFilename, String pdfPath,
                  Date createdDate, int adminId) {

        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
        this.category = category;
        this.pdfFilename = pdfFilename;
        this.pdfPath = pdfPath;
        this.createdDate = createdDate;
        this.adminId = adminId;
    }

    // Getters and Setters

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPdfFilename() {
        return pdfFilename;
    }

    public void setPdfFilename(String pdfFilename) {
        this.pdfFilename = pdfFilename;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}