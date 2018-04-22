package ru.tilman.gb.ee.garbage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProductToCDI {
    private String nameCDI = "chair";
    private String descriptionCDI = "good chair";


    public String getNameCDI() {
        return nameCDI;
    }

    public void setNameCDI(String nameCDI) {
        this.nameCDI = nameCDI;
    }

    public String getDescriptionCDI() {
        return descriptionCDI;
    }

    public void setDescriptionCDI(String descriptionCDI) {
        this.descriptionCDI = descriptionCDI;
    }
}
