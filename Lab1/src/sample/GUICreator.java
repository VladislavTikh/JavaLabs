package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class GUICreator {
    private GridPane root;
    private Button getProductWeight;
    private Button getDryProductWeight;
    private TextField productWeightField;
    private TextField dryProductWeightField;
    private TextField percentField;

    public Scene CreateScene()
    {
        root = new GridPane();
        root.setPadding(new Insets(0,0,0,20));
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(15);
        root.setVgap(15);
        root.setPrefWidth(250);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        root.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        root.getColumnConstraints().add(column2);
        Scene scene = new Scene(root, 550, 150);
        FlowPane pane=new FlowPane();
        productWeightField = new TextField();
        Label solven = new Label("Масса раствора:");
        pane.setHgap(15);
        pane.getChildren().add(solven);
        pane.getChildren().add(productWeightField);
        root.add(pane,0,0);
        FlowPane pane2=new FlowPane();
        percentField = new TextField();
        percentField.setPrefWidth(98);
        Label percent = new Label("Процентное содержание:");
        pane2.setHgap(15);
        pane2.getChildren().add(percent);
        pane2.getChildren().add(percentField);
        root.add(pane2, 0,1);
        FlowPane pane3=new FlowPane();
        dryProductWeightField = new TextField();
        dryProductWeightField.setPrefWidth(110);
        Label dryProductLabel = new Label("Масса сухого вещества:");
        pane3.setHgap(15);
        pane3.getChildren().add(dryProductLabel);
        pane3.getChildren().add(dryProductWeightField);
        root.add(pane3, 0,2);

        getProductWeight = new Button("Узнать массу раствора");
        getDryProductWeight = new Button("Узнать массу сухого вещества");

        root.add(getProductWeight, 1, 0);
        root.add(getDryProductWeight, 1, 1);
        dryProductButtonClick();
        ProductWeightButtonClick();
        return scene;
    }
    private  void dryProductButtonClick() {
        getDryProductWeight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double productWeight = Double.parseDouble(productWeightField.getText());
                double percentage = Double.parseDouble(percentField.getText());
                Product product = new Product(productWeight, percentage, WeightCalculator.getDryProductWeight(productWeight, percentage));
                dryProductWeightField.setText(String.format("%.2f", (product.getDryProductWeight())));
            }
        });
    }
    private void ProductWeightButtonClick() {
        getProductWeight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double dryProductWeight = Double.parseDouble(dryProductWeightField.getText());
                double percentage = Double.parseDouble(percentField.getText());
                Product product = new Product(WeightCalculator.getProductWeight(dryProductWeight, percentage), percentage, dryProductWeight);
                productWeightField.setText(String.format("%.2f", (product.getProductWeight())));
            }
        });
    }
}
