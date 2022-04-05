package unieuroop.view.analytic;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import unieuroop.controller.analytic.ControllerAnalyticImpl;
import unieuroop.model.analytic.Analytic;
import unieuroop.model.analytic.AnalyticImpl;
import unieuroop.model.product.Category;
import unieuroop.model.product.Product;
import unieuroop.model.product.ProductImpl;
import unieuroop.model.sale.Sale;
import unieuroop.model.sale.SaleImpl;
import unieuroop.model.shop.Shop;
import unieuroop.model.shop.ShopImpl;
import unieuroop.model.supplier.Supplier;
import unieuroop.model.supplier.SupplierImpl;

public class ViewAnalytic implements Initializable{
    @FXML
    private PieChart chartSpent;
    @FXML
    private PieChart chartEarned;
    @FXML
    private StackedAreaChart<Integer,Double> areaChart;
    @FXML
    private NumberAxis xAxis;
    
    private ControllerAnalyticImpl controller;
    private static final String APPLE_PRODUCT = "APPLE"; /*Brand of products*/
    private static final int TOTAL_PRODUCT_SOLD = 7;  /*all the total product sold , not the quantity*/
    private static final LocalDate TIME_NOW = LocalDate.now();

    private final Supplier s1 = new SupplierImpl("nome", Map.of());
    /**
     * ALL THE PRODUCTS THAT WILL BE USED IN THIS TEST.
     */
    private final Product p1 = new ProductImpl(1, "iphone 13 pro", ViewAnalytic.APPLE_PRODUCT,  1200.00,  900.00, "best phone ever created", Category.SMARTPHONE);
    private final Product p2 = new ProductImpl(2, "applewatch", ViewAnalytic.APPLE_PRODUCT, 500.00,  200.00, "best watch ever created", Category.SMARTWATCH);
    private final Product p3 = new ProductImpl(3, "mac book pro 14 ", ViewAnalytic.APPLE_PRODUCT,  3000.00, 2000.00, "best mac book ever created", Category.PC);
    private final Product p4 = new ProductImpl(4, "mac book pro 16", ViewAnalytic.APPLE_PRODUCT,  600.00,  3000.00, "best mac book ever created", Category.PC);
    private final Product p5 = new ProductImpl(5, "ipad Air ", ViewAnalytic.APPLE_PRODUCT,  700.00,  300.00, "best ipad ever created", Category.HOME);
    private final Product p6 = new ProductImpl(6, "ipad Pro", ViewAnalytic.APPLE_PRODUCT, 1000.00, 500.00, "best ipad Pro ever created", Category.HOME);
    private final Product p7 = new ProductImpl(7, "ipad Pro Max", ViewAnalytic.APPLE_PRODUCT, 1200.00,  900.00, "best ipad pro max ever created", Category.HOME);
    private final Product p8 = new ProductImpl(8, "ipad Pro Max v2", ViewAnalytic.APPLE_PRODUCT, 1200.00, 900.00, "best ipad pro max ever created", Category.HOME);
    /**
     * ALL THE SALES THAT WILL BE USED IN THIS TEST.
     */
    private final Sale sale1 = new SaleImpl(LocalDate.of(2010, 5, 20), Map.of(p1, 10, p2, 100, p5, 1), Optional.empty());
    private final Sale sale2 = new SaleImpl(LocalDate.of(2015, 3, 20), Map.of(p1, 10, p2, 100, p5, 1, p7, 10), Optional.empty());
    private final Sale sale3 = new SaleImpl(LocalDate.of(2017, 2, 10), Map.of(p5, 10, p2, 100, p6, 1), Optional.empty());
    private final Sale sale4 = new SaleImpl(LocalDate.of(2010, 9, 20), Map.of(p3, 10, p7, 100, p1, 1), Optional.empty());
    private final Sale sale5 = new SaleImpl(LocalDate.of(2011, 5, 20), Map.of(p1, 10, p4, 100, p3, 1), Optional.empty());
    private final Sale sale6 = new SaleImpl(LocalDate.of(2013, 1, 10), Map.of(p5, 10, p2, 100, p6, 1), Optional.empty());
    private final Sale sale7 = new SaleImpl(LocalDate.of(2022, 6, 20), Map.of(p3, 10, p7, 100, p1, 1), Optional.empty());
    private final Sale sale8 = new SaleImpl(LocalDate.of(2020, 2, 20), Map.of(p1, 10, p4, 100, p3, 1), Optional.empty());
    private final Sale sale9 = new SaleImpl(LocalDate.of(2010, 3, 20), Map.of(p1, 10, p2, 100, p5, 1), Optional.empty());
    private final Sale sale10 = new SaleImpl(LocalDate.of(2002, 2, 20), Map.of(p1, 10, p2, 100, p5, 1, p7, 10), Optional.empty());
    private final Sale sale11 = new SaleImpl(LocalDate.of(2000, 10, 10), Map.of(p5, 10, p2, 100, p6, 1), Optional.empty());
    private final Sale sale12 = new SaleImpl(LocalDate.of(2001, 4, 20), Map.of(p3, 10, p7, 100, p1, 1), Optional.empty());
    private final Sale sale13 = new SaleImpl(LocalDate.of(2022, 2, 20), Map.of(p1, 10, p4, 100, p3, 1), Optional.empty());
    private final Sale sale14 = new SaleImpl(LocalDate.of(2022, 5, 10), Map.of(p5, 10, p2, 100, p6, 1), Optional.empty());
    private final Sale sale15 = new SaleImpl(LocalDate.of(2012, 12, 20), Map.of(p3, 10, p7, 100, p1, 1), Optional.empty());
    private final Sale sale16 = new SaleImpl(LocalDate.of(2022, 11, 20), Map.of(p1, 10, p4, 100, p3, 1), Optional.empty());

    private Analytic analytic;
    private final Shop shop = new ShopImpl("TEST");

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.shop.addSale(sale1);
        this.shop.addSale(sale2);
        this.shop.addSale(sale3);
        this.shop.addSale(sale4);
        this.shop.addSale(sale5);
        this.shop.addSale(sale6);
        this.shop.addSale(sale7);
        this.shop.addSale(sale8);
        this.shop.addSale(sale9);
        this.shop.addSale(sale10);
        this.shop.addSale(sale11);
        this.shop.addSale(sale12);
        this.shop.addSale(sale13);
        this.shop.addSale(sale14);
        this.shop.addSale(sale15);
        this.shop.addSale(sale16);
        this.shop.addBills(LocalDate.of(2022, 1, 20), 46310);
        this.shop.addBills(LocalDate.of(2022, 5, 20), 10000);
        this.shop.addBills(ViewAnalytic.TIME_NOW, 14232);
        this.shop.addBills(LocalDate.of(2015, 3, 20), 2123);
        this.shop.addBills(LocalDate.of(2002, 1, 20), 10231);
        this.shop.addBills(LocalDate.of(2017, 2, 20), 1000);
        this.shop.addBills(ViewAnalytic.TIME_NOW, 14232);
        this.shop.addBills(LocalDate.of(2013, 4, 20), 2123);
        analytic = new AnalyticImpl(shop);
        this.controller = new ControllerAnalyticImpl(analytic);

        ObservableList<PieChart.Data> secondPieChartData = FXCollections.observableArrayList(
                this.controller.getLastYearEarned().entrySet().stream()
                .map((entry) -> new PieChart.Data(entry.getKey().toString(), entry.getValue())).collect(Collectors.toList()));
        secondPieChartData.forEach((data) -> data.nameProperty().bind(Bindings.concat(data.getName(), "\n", data.pieValueProperty())));
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(this.controller.getLastYearSpent().entrySet().stream().map(e-> new PieChart.Data(e.getKey().toString(), e.getValue())).collect(Collectors.toList()));
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), "\n", data.pieValueProperty(), " €"
                        )
                )
        );
        XYChart.Series<Integer, Double> serie1 = new XYChart.Series<>();
        serie1.setName("Spent");
        XYChart.Series<Integer, Double> serie2 = new XYChart.Series();
        serie2.setName("Earned");
        this.controller.getYearsTotalEarned().entrySet().forEach((entry) ->  serie1.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue())));
        //this.analytic.getTotalEarned((date) -> true).entrySet().forEach((entry) -> serie1.getData().add(new XYChart.Data<>(entry.getKey().getYear(), entry.getValue())));
        this.controller.getYearsTotalSpent().entrySet().forEach((entry) -> serie2.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue())));
        //this.analytic.getTotalSpent((date) -> true).entrySet().forEach((entry) -> serie2.getData().add(new XYChart.Data<>(entry.getKey().getYear(), entry.getValue())));
        final var lowerEarned = this.controller.getYearsTotalEarned().entrySet().stream()
                .map((entry) -> entry.getKey()).sorted().findFirst().get();
        final var lowerSpent = this.controller.getYearsTotalEarned().entrySet().stream()
                .map((entry) -> entry.getKey()).sorted().findFirst().get();
        areaChart.getData().addAll(serie2, serie1);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(lowerEarned > lowerSpent ? lowerSpent : lowerEarned);
        xAxis.setUpperBound(2030);
        xAxis.setTickUnit(2);
        chartSpent.setData(pieChartData);
        chartSpent.setLegendVisible(false);
        chartEarned.setData(secondPieChartData);
        chartEarned.setLegendVisible(false);
    }
}