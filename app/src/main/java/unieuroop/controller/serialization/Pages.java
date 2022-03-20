package unieuroop.controller.serialization;

import java.io.File;

public enum Pages {
    /**
     * @param 
     */
    DASHBOARD("Dashboard.fxml"),
    /**
     * @param
     */
    STOCK("Stock.fxml"),
    /**
     * @param
     */
    SALES("/pages/Sale/MainSale.fxml"),
    /**
     * @param
     */
    LABEL_PRODUCT_SALE("/pages/Sale/labelProduct.fxml"),
    /**
     * @param
     */
    DEPARTMENTS("/pages/Department/DepartmentsView.fxml"),
    /**
     * @param file directory of balance's chart
     */
    BALANCE("/pages/Balance/SpentEarnedChart.fxml"),
    /**
     * @param
     */
    MAIN_CATEGORIES_SOLD("/pages/CategoriesSold/MainCategoriesSold.fxml"),
    /**
     * @param
     */
    TABLE_CATEGORIES_SOLD("/pages/CategoriesSold/tableCategoriesSold.fxml"),
    /**
     * @param
     */
    MAIN_DATE_SOLD("/pages/DateSold/MainDateChart.fxml");

    private final String fileName;

    Pages(final String fileName) {
        this.fileName = fileName;
    }
    /**
     * 
     * @return the path of the file 
     */
    public String getPath() {
        return this.fileName;
    }
}