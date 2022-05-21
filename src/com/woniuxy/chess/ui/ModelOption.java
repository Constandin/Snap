package com.woniuxy.chess.ui;
import com.woniuxy.chess.SingleModelGame;
import com.woniuxy.chess.global_config.Global;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ModelOption extends Application {
    static Stage m;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("游 戏 模 式 选 择");
        primaryStage.setResizable(false); // 固定大小
        Pane pane = new Pane(); // 面板，展示各种控件的载体

        Button singleModel = new Button("单人 模式");
        singleModel.setPrefSize(100, 100);
        singleModel.setLayoutX(150.0);
        singleModel.setLayoutY(200.0);
        pane.getChildren().add(singleModel);

        Button LANModel = new Button("局域网模式");
        LANModel.setPrefSize(100, 100);
        LANModel.setLayoutX(350);
        LANModel.setLayoutY(200.0);
        pane.getChildren().add(LANModel);

        Button netModel = new Button("网络 模式");
        netModel.setPrefSize(100, 100);
        netModel.setLayoutX(550.0);
        netModel.setLayoutY(200.0);
        pane.getChildren().add(netModel);

        singleModel.setOnMouseClicked(e -> {
            SingleModelGame stage = new SingleModelGame();
            stage.show();
            primaryStage.close();

        });

        LANModel.setOnMouseClicked(e -> {
            SignInStage sis = new SignInStage();
            sis.show();
//            LANModelGameWindow l = new LANModelGameWindow();
//            l.show();
            primaryStage.close();
        });
        m = primaryStage;


        Scene scene = new Scene(pane, 800, 400); // 场景，存放面板
        primaryStage.setScene(scene); // 设置场景到主舞台
        primaryStage.show(); // 展示舞台
    }
}
