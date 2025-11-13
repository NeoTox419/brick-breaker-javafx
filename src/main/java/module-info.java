module com.saikat.brickbreaker.brickbreakerjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.saikat.brickbreaker.brickbreakerjavafx to javafx.fxml;
    exports com.saikat.brickbreaker.brickbreakerjavafx;
}